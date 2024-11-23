package rom.buulaen.mediator.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;


@Configuration
public class DatabaseConfig {

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.postgresql.Driver");
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/comunication");
        config.setUsername("postgres");
        config.setPassword("Legion1944");

        // Dodatkowe ustawienia
        config.setMaximumPoolSize(10); // Maksymalna liczba połączeń
        config.setMinimumIdle(2);     // Minimalna liczba nieużywanych połączeń
        config.setIdleTimeout(30000); // Czas wygaszenia nieużywanych połączeń (w ms)
        config.setMaxLifetime(1800000); // Maksymalny czas istnienia połączenia (w ms)

        return new HikariDataSource(config);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("rom.buulaen.mediator.db_connector.model"); // Pakiet z encjami

        // Ustawienia Hibernate jako JPA provider
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        // Dodatkowe właściwości JPA/Hibernate
        em.getJpaPropertyMap().put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        em.getJpaPropertyMap().put("hibernate.show_sql", "true");
        em.getJpaPropertyMap().put("hibernate.hbm2ddl.auto", "update");
        em.getJpaPropertyMap().put("hibernate.ddl-auto", "update");

        return em;
    }

    @Bean
    public JpaTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory.getObject());
        return transactionManager;
    }
}
