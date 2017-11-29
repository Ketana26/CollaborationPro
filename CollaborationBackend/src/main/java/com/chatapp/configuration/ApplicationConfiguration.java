package com.chatapp.configuration;



import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.chatapp.model.AnswerForum;
import com.chatapp.model.Blog;
import com.chatapp.model.BlogComment;
import com.chatapp.model.Forum;
import com.chatapp.model.Friend;
import com.chatapp.model.Jobs;
import com.chatapp.model.Users;



@Configuration
@ComponentScan("com.chatapp")
@EnableTransactionManagement
public class ApplicationConfiguration {

	@Autowired
	@Bean(name="dataSource")
	public DataSource getDataSource()
	{
		System.out.println("get datasource method called");
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		System.out.println("DriverManagerDataSource is kkk");
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		System.out.println("driver is k");
		dataSource.setUsername("MYAPP");
		dataSource.setPassword("ketana");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		System.out.println("url is k");
		return dataSource;
	}
	private  Properties getHibernateProperties()
	 {
		  Properties properties=new Properties();
		  properties.setProperty("hibernate.show_sql", "true");
			properties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
			properties.setProperty("hibernate.hbm2ddl.auto", "");
			properties.setProperty("hibernate.format_sql", "true");
			
			return properties;
				  
	 }
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder localSessionFactoryBuilder=new LocalSessionFactoryBuilder(dataSource);
		localSessionFactoryBuilder.addProperties(getHibernateProperties());
		/*localSessionFactoryBuilder.addAnnotatedClass(Users.class);
		localSessionFactoryBuilder.addAnnotatedClass(Blog.class);
		localSessionFactoryBuilder.addAnnotatedClass(Forum.class);
		localSessionFactoryBuilder.addAnnotatedClass(Jobs.class);
		localSessionFactoryBuilder.addAnnotatedClass(Friend.class);
		localSessionFactoryBuilder.addAnnotatedClass(BlogComment.class);
		localSessionFactoryBuilder.addAnnotatedClass(AnswerForum.class);*/
		localSessionFactoryBuilder.scanPackages("com.chatapp.model");
		
		return localSessionFactoryBuilder.buildSessionFactory();
	}
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager hibernateTransactionManager=new HibernateTransactionManager(sessionFactory);
		return hibernateTransactionManager;
		
	}
	@Bean
	public CommonsMultipartResolver multipartResolver() {
	    CommonsMultipartResolver resolver=new CommonsMultipartResolver();
	    resolver.setDefaultEncoding("utf-8");
	    return resolver;
	}

}
