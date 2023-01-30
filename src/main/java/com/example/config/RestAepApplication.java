package com.example.config;

import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
//@ComponentScan(basePackageClasses = {ClienteController.class,ClienteService.class,ClienteDao.class})

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@EnableTransactionManagement
@ComponentScans(value = { 
		@ComponentScan("com.example.controller"), 
		@ComponentScan("com.example.service"),
		@ComponentScan("com.example.dao"), 
		@ComponentScan("com.example.model"), 
		@ComponentScan("com.example.config") })
@PropertySource("file:C:\\\\wildfly\\standalone\\data\\bd.properties")
public class RestAepApplication {


	

	
	@Value("${db.aep.url}")
	String URL_AEP;
	@Value("${db.aep.user}")
	String USER_AEP;
	@Value("${db.aep.pass}")
	String PASS_AEP;

	public static void main(String[] args) {
		SpringApplication.run(RestAepApplication.class, args);
	}

	@Bean
	public DataSource getDataSource() {
		SQLServerDataSource dataSource = new SQLServerDataSource();
		dataSource.setURL(URL_AEP + Entidades.CATALOGO_DB + ";TrustServerCertificate=True;");
		dataSource.setUser(USER_AEP);
		dataSource.setPassword(PASS_AEP);

		return dataSource;
	}

	@Bean(name = "entityManagerFactory")
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setDataSource(getDataSource());

		Properties props = new Properties();
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.dialect", "org.hibernate.dialect.SQLServer2012Dialect");
		props.put("hibernate.connection.driver_class", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
		props.put("hibernate.id.new_generator_mappings", "false");
		props.put("hibernate.connection.autocommit", "true");
		props.put("hibernate.connection.pool_size", "100");

		props.put("hibernate.connection.isolation", String.valueOf(Connection.TRANSACTION_READ_UNCOMMITTED));
		factoryBean.setHibernateProperties(props);

		return Entidades.cargaClases(factoryBean);
	}

	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		// transactionManager.setDefaultTimeout(180);
		return transactionManager;
	}
}
