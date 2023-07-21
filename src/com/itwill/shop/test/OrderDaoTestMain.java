package com.itwill.shop.test;

import java.util.ArrayList;
import java.util.Date;

import com.itwill.shop.order.Order;
import com.itwill.shop.order.OrderDao;
import com.itwill.shop.order.OrderItem;
import com.itwill.shop.product.Product;
import com.itwill.shop.product.ProductDao;

public class OrderDaoTestMain {

	public static void main(String[] args)throws Exception {
		OrderDao orderDao = new OrderDao();

		System.out.println(orderDao.findOrderByUserId("user2")); //orderitem없이 뽑음
		System.out.println("***********************");
//		System.out.println(orderDao.findByOrderNo(2));
		System.out.println("***********************");
		System.out.println(orderDao.findOrderWithOrderItemByUserId("user2")); //orderitem까지 뽑음
		
	
		

	}

}
