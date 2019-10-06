package com.top.study.global.config.db;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.top.study.global.util.OtherMethod;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "PostgresqlHikariEntityManagerFactory",
		transactionManagerRef = "jpaTransactionManager", 
		basePackages = {
							"com.top.study.domain.user.dao" 
						}
		)
public class PostgresqlEntityManagerFactory {
	private static final Logger logger = LogManager.getLogger(PostgresqlEntityManagerFactory.class);
	
	@Value("${jpa.properties-location}")
    private String propertiesLoc;
	
	@Bean( name = "postreqHikariDatatsource")
	public DataSource postgresqlHikariDatasource() {
		HikariDataSource hikariDataSource = new HikariDataSource();
		hikariDataSource.setDriverClassName("org.postgresql.Driver");
		hikariDataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
		hikariDataSource.setUsername("postgres");
		hikariDataSource.setPassword("3158");

		return hikariDataSource;
	}
	
	@Bean(name = "jpaTransactionManager")
	public PlatformTransactionManager jpaTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
		
		logger.debug("JPA EntitManager Create Success !!");
		return transactionManager;
	}
	
	@Bean(name = "PostgresqlHikariEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter());
		entityManagerFactoryBean.setDataSource(postgresqlHikariDatasource());
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		entityManagerFactoryBean.setPackagesToScan(new String[] { "com.top.study.domain.user.domain" });

		entityManagerFactoryBean.setJpaProperties(OtherMethod.setJPAHibernateProperties(propertiesLoc));
		entityManagerFactoryBean.setPersistenceUnitName("PostgresqlHikariEMFactroy");
		entityManagerFactoryBean.afterPropertiesSet(); 

		return entityManagerFactoryBean;
	}
	
	private HibernateJpaVendorAdapter vendorAdapter() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

		vendorAdapter.setShowSql(true); 
		vendorAdapter.setDatabase(Database.POSTGRESQL);
		vendorAdapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQL10Dialect");
		vendorAdapter.setGenerateDdl(true);
		vendorAdapter.setPrepareConnection(true);

		return vendorAdapter;
	}

	

}
