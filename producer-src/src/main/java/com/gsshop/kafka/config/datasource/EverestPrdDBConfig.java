package com.gsshop.kafka.config.datasource;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

/**
 * Created by jinete on 18/08/24.
 */
@Configuration
@EnableEncryptableProperties
@EnableTransactionManagement
@EnableJpaRepositories(
          entityManagerFactoryRef = "prdEntityManagerFactory"
        , transactionManagerRef = "prdTransactionManager"
        , basePackages = {"com.gsshop.kafka.producer"}
        , includeFilters = @Filter(type = FilterType.REGEX, pattern = "com.gsshop.kafka.producer.*.*Repository")
        )
public class EverestPrdDBConfig {
    @Value("${jdbc.template.max.rows}")
    private int maxRows;
    
    @Primary
    @Bean(name = "prdDataSource")
    @ConfigurationProperties(prefix = "prd.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
    
    @Primary
    @Bean(name = "prdEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("prdDataSource") DataSource dataSource) {
        Map<String, String> properties = new HashMap<String, String>();
        properties.put("hibernate.implicit_naming_strategy", "org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy");
        properties.put("hibernate.physical_naming_strategy", "org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy");
//        properties.put("hibernate.current_session_context_class", "org.springframework.boot.orm.hibernate5.SpringSessionContext");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        
        return builder
                .dataSource(dataSource)
                .packages("com.gsshop.kafka.producer")
                .persistenceUnit("prd")
                .properties(properties)
                .build();
    }
    
    @Primary
    @Bean(name = "prdTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("prdEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
    
    @Primary
    @Bean(name = "prdJdbcTemplate")
    @Autowired
    public NamedParameterJdbcTemplate getJdbcTemplate(@Qualifier("prdDataSource") DataSource db) {
        NamedParameterJdbcTemplate namedParamterJdbcTemplate = new NamedParameterJdbcTemplate(db);
        namedParamterJdbcTemplate.getJdbcTemplate().setMaxRows(maxRows);
        return namedParamterJdbcTemplate;
    }
}
