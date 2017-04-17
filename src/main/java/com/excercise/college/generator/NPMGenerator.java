package com.excercise.college.generator;


import java.io.Serializable;
import java.sql.*;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.excercise.college.models.Student;

public class NPMGenerator implements IdentifierGenerator {
	private String DEFAULT_SEQUENCE_NAME ="hibernate_sequence";
	
	@Override
	public Serializable generate(SessionImplementor session, Object object) 
			throws HibernateException {
		Serializable result=null;
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet = null;
	    try {
            String prefix = "Mhs";
            connection = session.connection();
            statement = connection.createStatement();                   
             try {  
                 resultSet = statement.executeQuery("call next value for "+DEFAULT_SEQUENCE_NAME);

             } catch(Exception ex) {
                 // if sequence is not found then creating the sequence
                 statement = connection.createStatement();
                 statement.execute("CREATE SEQUENCE "+DEFAULT_SEQUENCE_NAME);
                 System.out.println("Sequece Created successfully. ");
                 resultSet = statement.executeQuery("call next value for "+DEFAULT_SEQUENCE_NAME);
             }
            
            if(resultSet.next()) {
                int nextValue = resultSet.getInt(1);                
                String suffix = String.format("%05d", nextValue + 1);               
                result = prefix.concat(suffix);
                System.out.println("Custom generated Sequence value : "+result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return null;
	}
	

}
