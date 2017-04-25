package com.excercise.college.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.excercise.college.dao.impl.FRSDAOImpl;
import com.excercise.college.dao.impl.FRSDetailDAOImpl;
import com.excercise.college.dao.impl.MajorDAOImpl;
import com.excercise.college.dao.impl.ReportDAOImpl;
import com.excercise.college.dao.impl.RoomDAOImpl;
import com.excercise.college.dao.impl.ScheduleDAOImpl;
import com.excercise.college.dao.impl.StudentDAOImpl;
import com.excercise.college.dao.impl.SubjectDAOImpl;
import com.excercise.college.dao.impl.SubjectMajorDAOImpl;
import com.excercise.college.dao.FRSDAO;
import com.excercise.college.dao.FRSDetailDAO;
import com.excercise.college.dao.MajorDAO;
import com.excercise.college.dao.ReportDAO;
import com.excercise.college.dao.RoomDAO;
import com.excercise.college.dao.ScheduleDAO;
import com.excercise.college.dao.StudentDAO;
import com.excercise.college.dao.SubjectDAO;
import com.excercise.college.dao.SubjectMajorDAO;

@Configuration
@ComponentScan("com.excercise.college.*")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class ApplicationContextConfig {

	@Autowired
	private Environment env;

	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.username"));
		dataSource.setPassword(env.getProperty("jdbc.password"));

		return dataSource;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) throws Exception {
		Properties properties = new Properties();

		properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		properties.put("current_session_context_class", env.getProperty("current_session_context_class"));
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));

		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setPackagesToScan(new String[] { "com.excercise.college.models" });
		factoryBean.setDataSource(dataSource);
		factoryBean.setHibernateProperties(properties);
		factoryBean.afterPropertiesSet();
		//
		SessionFactory sf = factoryBean.getObject();
		return sf;
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
	}

	@Bean(name = "MajorDAO")
	public MajorDAO getMajorDAO() {
		return new MajorDAOImpl();
	}

	@Bean(name = "SubjectDAO")
	public SubjectDAO getSubjectDAO() {
		return new SubjectDAOImpl();
	}

	@Bean(name = "StudentDAO")
	public StudentDAO getStudentDAO() {
		return new StudentDAOImpl();
	}
	
	@Bean(name = "ScheduleDAO")
	public ScheduleDAO getScheduleDAO() {
		return new ScheduleDAOImpl();
	}
	
	@Bean(name = "FRSDAO")
	public FRSDAO getFRSDAO() {
		return new FRSDAOImpl();
	}
	
	@Bean(name = "SubjectMajorDAO")
	public SubjectMajorDAO getSubjectMajorDAO() {
		return new SubjectMajorDAOImpl();
	}
	
	@Bean(name = "ReportDAO")
	public ReportDAO getReportDAO() {
		return new ReportDAOImpl();
	}
	
	@Bean(name = "FRSDetailDAO")
	public FRSDetailDAO getFRSDetailDAO() {
		return new FRSDetailDAOImpl();
	}
	
	@Bean(name = "RoomDAO")
	public RoomDAO getRoomDAO() {
		return new RoomDAOImpl();
	}
}
