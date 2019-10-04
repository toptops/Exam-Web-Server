package com.top.study.global.config.db;

import javax.sql.DataSource;

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
	
	@Value("${jpa.properties-location}")
    private String propertiesLoc;
	
	//프로퍼티로 뺴서 읽기
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

		vendorAdapter.setShowSql(true); // SQL 로그를 보여주는 여부.
		vendorAdapter.setDatabase(Database.POSTGRESQL); // 명시적으로 어떤 디비 쓸껀지 알고리즘.
		vendorAdapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQL10Dialect"); // 방언 추가.
		vendorAdapter.setGenerateDdl(true); // hbm2ddl.auto=update
		vendorAdapter.setPrepareConnection(true); // 하이버네이트 트랜잭션을 JDBC에 연결할지 여부. (기본 True)

		return vendorAdapter;
	}

	

}
