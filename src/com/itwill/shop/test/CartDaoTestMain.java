package com.itwill.shop.test;

import com.itwill.shop.cart.Cart;
import com.itwill.shop.cart.CartDao;
import com.itwill.shop.product.Product;

public class CartDaoTestMain {
	public static void main(String[] args) throws Exception{
		CartDao cartDao = new CartDao();
		
		System.out.println("1.insert");
		//int rowCount = cartDao.insert(new Cart(0, 1, "user1" ,new Product(1, "문과 남자의 과학공부", 15750, "유시민이 들려주는 과학 인문학이야기", "/com/itwill/shop/image/bestSeller1")));
		//rowCount = cartDao.insert(new Cart(0, 1, "user1" ,new Product(2, "스킵과 로퍼 6", 5400, "도쿄 고교생활 속 연애이야기", "/com/itwill/shop/image/bestSeller2")));
		//rowCount = cartDao.insert(new Cart(0, 1, "user2" ,new Product(3, "둑맞은 집중력", 16920, "삶에서 도난당하고 있는 집중력을 되찾는법을 담은책", "/com/itwill/shop/image/bestSeller3")));
		//System.out.println(rowCount);
		
		System.out.println("2.deleteByCartNo");
		//rowCount = cartDao.deleteByCartNo(5);
		//System.out.println(rowCount);
		
		System.out.println("3.deleteByAll");
		//int rowCount =cartDao.deleteByAll("user2");
		//System.out.println(rowCount);
		
		System.out.println("4.update");
		//int rowCount = cartDao.update(3, 7);
		//System.out.println(rowCount);
		
		System.out.println("5.update");
		//int rowCount = cartDao.updateByProduct(10, "user1", 1);
		//System.out.println(rowCount);
		
		System.out.println("6.findSelectByCartNo");
		//System.out.println(">>"+ cartDao.findSelectByCartNo(7));
	
		System.out.println("findSelectAll");
		//System.out.println(">>"+cartDao.findSelectAll("user1"));
	}
	
}
