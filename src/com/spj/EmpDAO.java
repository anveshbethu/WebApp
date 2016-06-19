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
		
		System.out.println("came till DAO");
		try {

			Class.forName("org.postgresql.Driver");
	         con = DriverManager
	            .getConnection("jdbc:postgresql://spjdb.cee7p279hqea.us-west-2.rds.amazonaws.com:5432/mydb",
	            "bethu", "mech");
	         System.out.println("created connection");
	         PreparedStatement st = 
	         con.prepareStatement("insert into employees(id, firstname, lastname, designation) values(?,?,?,?)");
	         st.setInt(1, e.getId());
	         st.setString(2, e.getFname());
	         st.setString(3, e.getLname());
	         st.setString(4, e.getDesignation());
	         int result = st.executeUpdate();                

	      } catch (SQLException ex) {
	         ex.printStackTrace();
	      } catch (ClassNotFoundException ex) {
	         ex.printStackTrace();
	      }    
	}

}
