package com.rooting.producer.config.datasource;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import javax.persistence.EntityManagerFactory;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableEncryptableProperties
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "rootingEntityManagerFactory"
        , transactionManagerRef = "rootingTransactionManager"
        , basePackages = {"com.rooting.producer"}
        , includeFilters = @Filter(type = FilterType.REGEX, pattern = "com.rooting.producer.*.*Repository")
)
public class RootingDBConfig {

    @Value("${jdbc.template.max.rows}")
    private int maxRows;

    @Primary
    @Bean(name = "rootingDataSource")
    @ConfigurationProperties(prefix = "rooting.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "rootingEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("rootingDataSource") DataSource dataSource) {
        Map<String, String> properties = new HashMap<String, String>();
        properties.put("hibernate.implicit_naming_strategy", "org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy");
        properties.put("hibernate.physical_naming_strategy", "org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy");
//        properties.put("hibernate.current_session_context_class", "org.springframework.boot.orm.hibernate5.SpringSessionContext");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");

        return builder
                .dataSource(dataSource)
                .packages("com.rooting.producer")
                .persistenceUnit("rooting")
                .properties(properties)
                .build();
    }

    @Primary
    @Bean(name = "rootingTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("rootingEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Primary
    @Bean(name = "rootingJdbcTemplate")
    @Autowired
    public NamedParameterJdbcTemplate getJdbcTemplate(@Qualifier("rootingDataSource") DataSource db) {
        NamedParameterJdbcTemplate namedParamterJdbcTemplate = new NamedParameterJdbcTemplate(db);
        namedParamterJdbcTemplate.getJdbcTemplate().setMaxRows(maxRows);
        return namedParamterJdbcTemplate;
    }
}
