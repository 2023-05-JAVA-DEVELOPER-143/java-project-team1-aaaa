package com.itwill.shop.order;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.itwill.shop.common.DataSource;

public class OrderDao {

	private DataSource dataSource;
	
	public OrderDao()throws Exception {
		dataSource = new DataSource();
	}
	
	public int deleteByMemberId(String m_id)throws Exception{
		Connection con =dataSource.getConnection();
		PreparedStatement pstmt =con.prepareStatement(OrderSQL.ORDER_DELETE_BY_M_ID);
		pstmt.setString(1, m_id);
		int rowCount = 0;
		rowCount = pstmt.executeUpdate();
			con.close();
			pstmt.close();
		
		return 0;
	}
	
}
