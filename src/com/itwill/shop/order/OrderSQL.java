package com.itwill.shop.order;

public class OrderSQL {
	
/*
이름      널?       유형            
------- -------- ------------- 
O_NO    NOT NULL NUMBER(10)    
O_DESC           VARCHAR2(100) 
O_DATE           DATE          
O_PRICE          NUMBER(10)    
M_ID             VARCHAR2(20) 
 */
	public final static String ORDER_DELETE_BY_M_ID = "delete orders where m_id = ?";
	public final static String ORDER_DELETE_BY_O_NO = "delete orders where o_no";
	public final static String ORDER_INSERT = "insert into orders(o_no,o_desc,o_date,o_price,m_id) values(orders_o_no_seq.nextval,?,sysdate,?,?";
	public final static String ORDERITEM_INSERT="insert into order_item(oi_no,oi_qty,p_no,o_no) values(order_item_oi_no_SEQ.nextval,?,?,orders_o_no_seq.currval";
	public final static String ORDER_SELECT_BY_M_ID = "select * from orders where m_id = ?";
	public final static String ORDER_SELECT_WITH_ORDERITEM_BY_O_NO = 
			"select * from orders o join order_item oi on o.o_no=oi.o_no  join  product p on oi.p_no=p.p_no where  o.o_no = ?";
	public final static String ORDER_SELECT_WITH_ORDERITEM_BY_USERID = "select * from orders o join order_item oi on o.o_no=oi.o_no  join  product p on oi.p_no=p.p_no where  o.userid = ?";
}
