package com.itwill.shop.test;

import java.util.List;

import com.itwill.shop.cart.Cart;
import com.itwill.shop.cart.CartDao;
import com.itwill.shop.product.Product;

public class CartDaoTestMain {
	
	public static void main(String[] args) throws Exception {
		CartDao cartDao = new CartDao();
		
//		System.out.println("1.cart insert");
//		Cart addCart=new Cart(0, 1, "user1", new Product(4, null, 0, null, null));
//		int rowCount=-999;
//		rowCount = cartDao.insert(addCart);
//		System.out.println(">> "+rowCount);
		
		System.out.println("2.updateByCartNo");
		int rowCount=cartDao.update(8, 1);
		System.out.println(">> "+rowCount);
		
		System.out.println("2.updateByProductNoAndUserId");
		rowCount=cartDao.updateByProduct(3,"user1",2);
		System.out.println(">> "+rowCount);
		
		System.out.println("3.delete");
		rowCount=cartDao.deleteByCartNo(5);
		System.out.println(">> "+rowCount);
		
		System.out.println("4.cartList[select]");
		List<Cart> cartList1=cartDao.findSelectAll("user2");
		System.out.println("guard1-->"+cartList1);
		
	}
	
}
