package lk.ijse.aadassignmentphase02possystembackendusingspringmvc.config;

import jakarta.persistence.EntityManagerFactory;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "lk.ijse.aadassignmentphase02possystembackendusingspringmvc")
@EnableJpaRepositories(basePackages = "lk.ijse.aadassignmentphase02possystembackendusingspringmvc.dao")
@EnableTransactionManagement

public class WebAppRootConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
    @Bean
    public DataSource dataSource() {
        var driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/pos_system_springmvc?createDatabaseIfNotExist=true");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("1234");
        return driverManagerDataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();

        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("lk.ijse.aadassignmentphase02possystembackendusingspringmvc.entity");
        factory.setDataSource(dataSource());

        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect"); // Hibernate dialect for MySQL
        jpaProperties.put("hibernate.hbm2ddl.auto", "update"); // Automatically update schema
        jpaProperties.put("hibernate.show_sql", "true"); // Show SQL queries in the console
        jpaProperties.put("hibernate.format_sql", "true"); // Format SQL queries for readability
        jpaProperties.put("hibernate.use_sql_comments", "true"); // Add comments in SQL logs
        factory.setJpaProperties(jpaProperties);
        return factory;
    }

    //Transaction manager part eka(Transaction manage karanna)-transaction enable part
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }

}
