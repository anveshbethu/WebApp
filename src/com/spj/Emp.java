package com.spj;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class Emp
 */
@Stateless
@LocalBean
public class Emp {

    private String fname, lname;
    public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public Emp() {
        // TODO Auto-generated constructor stub
    }
	public String add(){
		return fname+" "+lname+ " from EJB";
	}

}
