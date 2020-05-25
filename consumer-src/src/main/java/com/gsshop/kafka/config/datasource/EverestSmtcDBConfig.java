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
        entityManagerFactoryRef = "entityManagerFactory"
        , transactionManagerRef = "transactionManager"
        , basePackages = {"com.gsshop.kafka.consumer"}
        , includeFilters = @Filter(type = FilterType.REGEX, pattern = "com.gsshop.kafka.consumer.*.*JpaRepository")
        )
public class EverestSmtcDBConfig {
    @Value("${jdbc.template.max.rows}")
    private int maxRows;
    
    @Primary
    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "smtc.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
    
    @Primary
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean smtcDBEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("dataSource") DataSource dataSource) {
        Map<String, String> properties = new HashMap<String, String>();
        properties.put("hibernate.implicit_naming_strategy", "org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy");
        properties.put("hibernate.physical_naming_strategy", "org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy");
        properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
        
        return builder
                .dataSource(dataSource)
                .packages("com.gsshop.kafka.consumer")
                .persistenceUnit("smtcDB")
                .properties(properties)
                .build();
    }
    
    @Primary
    @Bean(name = "transactionManager")
    public PlatformTransactionManager smtcDBTransactionManager(@Qualifier("entityManagerFactory") EntityManagerFactory smtcDBEntityManagerFactory) {
        return new JpaTransactionManager(smtcDBEntityManagerFactory);
    }
    
    @Primary
    @Bean
    @Autowired
    public NamedParameterJdbcTemplate getJdbcTemplate(@Qualifier("dataSource") DataSource db) {
        NamedParameterJdbcTemplate namedParamterJdbcTemplate = new NamedParameterJdbcTemplate(db);
        namedParamterJdbcTemplate.getJdbcTemplate().setMaxRows(maxRows);
        return namedParamterJdbcTemplate;
    }
}
