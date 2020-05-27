package com.rooting.consumer.config.datasource;
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

@Configuration
@EnableEncryptableProperties
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactory"
        , transactionManagerRef = "transactionManager"
        , basePackages = {"com.rooting.consumer"}
        , includeFilters = @Filter(type = FilterType.REGEX, pattern = "com.rooting.consumer.*.*JpaRepository")
)
public class RootingDBConfig {
    @Value("${jdbc.template.max.rows}")
    private int maxRows;

    @Primary
    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "rooting.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean rootingDBEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("dataSource") DataSource dataSource) {
        Map<String, String> properties = new HashMap<String, String>();
        properties.put("hibernate.implicit_naming_strategy", "org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy");
        properties.put("hibernate.physical_naming_strategy", "org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLInnoDBDialect");

        return builder
                .dataSource(dataSource)
                .packages("com.rooting.consumer")
                .persistenceUnit("rootingDB")
                .properties(properties)
                .build();
    }

    @Primary
    @Bean(name = "transactionManager")
    public PlatformTransactionManager rootingDBTransactionManager(@Qualifier("entityManagerFactory") EntityManagerFactory rootingDBEntityManagerFactory) {
        return new JpaTransactionManager(rootingDBEntityManagerFactory);
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
