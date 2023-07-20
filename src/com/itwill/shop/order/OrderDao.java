package com.itwill.shop.order;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.itwill.shop.common.DataSource;

public class OrderDao {

	private DataSource dataSource;
	
	public OrderDao()throws Exception {
		dataSource = new DataSource();
	}
	
}
