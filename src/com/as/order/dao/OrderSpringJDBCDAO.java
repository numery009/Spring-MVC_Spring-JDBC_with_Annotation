package com.as.order.dao;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.as.order.vo.Order;

@Repository
public class OrderSpringJDBCDAO implements OrderDAOIntf {
	@Autowired
	private JdbcTemplate jdbctemplate=null;
	
	
	public void processOrder(Order order) {
		
		Object[] obj1 = new Object[5];

	        obj1[0] = order.getItemCount();
	        obj1[1] = order.getOrderTotal();
	        obj1[2] = order.getCard();
	        obj1[3] = order.getPersonName();
	        obj1[4] = order.getShippingAddress();
	        

/*	       this.getJdbctemplate().update(
	                "INSERT INTO `order`(itemcount, order_total, card,"
	                        + "person_name,shipping_address) VALUES "
	                        + "(?,?,?,?,?)", obj1);
	       */ 

	        String str = "INSERT INTO `order`(itemcount, order_total, card,"
                    + "person_name,shipping_address) VALUES "
                    + "(?,?,?,?,?)";
	        
	        jdbctemplate.update(str, new Object[]{order.getItemCount(),order.getOrderTotal(),order.getCard(),order.getPersonName(), order.getShippingAddress()});

	}
	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}
	
	public void setJdbctemplate(JdbcTemplate jdbctemplate) {		
		this.jdbctemplate=jdbctemplate;
	}
	
}
