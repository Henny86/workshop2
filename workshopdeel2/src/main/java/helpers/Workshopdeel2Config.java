/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author jeroenO
 */

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"DAOs", "POJOs", "helpers", "service"})
public class Workshopdeel2Config {
    
  @Bean
  public JpaVendorAdapter jpaVendorAdapter() {
    HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
    adapter.setDatabase(Database.MYSQL);
    adapter.setShowSql(true);
    adapter.setGenerateDdl(false);
    adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
    return adapter;
  }
  
  @Bean
  public DataSource dataSource() {
    
    HikariConfig hikariConfig = new HikariConfig();
    hikariConfig.setDriverClassName("com.mysql.jdbc.Driver");
    hikariConfig.setJdbcUrl("jdbc:mysql://localhost/workshopdeel2"); 
    hikariConfig.setUsername("hallo");
    hikariConfig.setPassword("doei");

    hikariConfig.setMaximumPoolSize(5);
    hikariConfig.setPoolName("springHikariCP");

    hikariConfig.addDataSourceProperty("dataSource.cachePrepStmts", "true");
    hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSize", "250");
    hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSqlLimit", "2048");
    hikariConfig.addDataSourceProperty("dataSource.useServerPrepStmts", "true");

    HikariDataSource dataSource = new HikariDataSource(hikariConfig);

    return dataSource;
      
  }
  
  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
    LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
    emfb.setDataSource(dataSource);
    emfb.setJpaVendorAdapter(jpaVendorAdapter);
    emfb.setPackagesToScan("DAOs", "POJOs", "helpers", "service");
    return emfb;
  }
  
  @Bean
  public  PersistenceAnnotationBeanPostProcessor paPostProcessor(){
      return new PersistenceAnnotationBeanPostProcessor();
  }
 /*

  @Autowired
  @Bean (name = "transactionManager")
	public PlatformTransactionManager transactionManager(EntityManagerFactory emfb){
		JpaTransactionManager txm = new JpaTransactionManager();
		txm.setEntityManagerFactory(emfb);
		return txm;
	}

*/
  @Bean
  public JpaTransactionManager transactionManager() {
    return new JpaTransactionManager(); 
  }
}
