package com.spj;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class EmpDAO implements EmpRemote, Serializable{
	

	public void add(Emp e){
		Connection con = null;
		String url = "jdbc.postgresql://localhost:5432/mydb";
		String driver = "org.postgresql.Driver";
		String username = "bethu";
		String password = "mech";
		System.out.println("came till DAO");
		try {

			Class.forName("org.postgresql.Driver");
	         con = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/mydb",
	            "bethu", "mech");
	         System.out.println("created connection");
	         PreparedStatement st = 
	         con.prepareStatement("insert into employee(fname, lname) values(?,?)");
	         st.setString(1, e.getLname());
	         st.setString(2, e.getFname());

	         int result = st.executeUpdate();                

	      } catch (SQLException ex) {
	         ex.printStackTrace();
	      } catch (ClassNotFoundException ex) {
	         ex.printStackTrace();
	      }    
	}

}
