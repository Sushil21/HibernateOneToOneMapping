package com.example.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @author sushil.kumar
 *
 */
@Configuration
@ConfigurationProperties
@EnableTransactionManagement
public class HibernateConfig {
	
	 @Value("${datasource.driver}")
	  private String dbDriver;
	  @Value("${datasource.password}")
	  private String dbPassword;
	  @Value("${datasource.url}")
	  private String dbUrl;
	  @Value("${datasource.username}")
	  private String dbUsername;
	  @Value("${hibernate.show_sql}")
	  private String showSql;
	  @Value("${hibernate.hbm2ddl.auto}")
	  private String hibernateDdlAuto;
	  @Value("${entitymanager.packagesToScan}")
	  private String packagesToScan;
	  @Value("${hibernate.dialect}")
	  private String hibernateDialect;
	  @Value("${hibernate.c3p0.min_size}")
	  private String poolMinSize;
	  @Value("${hibernate.c3p0.max_size}")
	  private String poolMaxSize;
	  @Value("${hibernate.c3p0.timeout}")
	  private String poolTimeOut;
	  @Value("${hibernate.c3p0.max_statements}")
	  private String poolMaxStatements;
	  
	  @Autowired
	  @Bean
	  public DataSource dataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName(dbDriver);
	    dataSource.setUrl(dbUrl);
	    dataSource.setUsername(dbUsername);
	    dataSource.setPassword(dbPassword);
	    return dataSource;
	  }

	  @Bean
	  public LocalSessionFactoryBean sessionFactory() {
	    LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
	    sessionFactoryBean.setDataSource(dataSource());
	    Properties hibernateProperties = new Properties();
	    hibernateProperties.put("hibernate.dialect", hibernateDialect);
	    hibernateProperties.put("hibernate.show_sql", showSql);
	    hibernateProperties.put("hibernate.hbm2ddl.auto", hibernateDdlAuto);
	    hibernateProperties.put("hibernate.c3p0.min_size", poolMinSize);
	    hibernateProperties.put("hibernate.c3p0.max_size", poolMaxSize);
	    hibernateProperties.put("hibernate.c3p0.timeout",poolTimeOut);
	    hibernateProperties.put("hibernate.c3p0.max_statements",poolMaxStatements);
	    sessionFactoryBean.setHibernateProperties(hibernateProperties);
	    sessionFactoryBean.setPackagesToScan(packagesToScan);
	    return sessionFactoryBean;
	  }

	  @Bean
	  public HibernateTransactionManager transactionManager() {
	    HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	    transactionManager.setSessionFactory(sessionFactory().getObject());
	    return transactionManager;
	  }

}
