package com.javabycode.springboot;

public class CustomerDetailsImpl {

	public Customer printCustomer(int id, String name, String ssn) {
		
		Customer c=new Customer();
		c.setId(id);
		c.setName(name);
		c.setSsn(ssn);
		
		return c;
	}
	

}
