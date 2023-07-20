package com.itwill.shop.test;

import com.itwill.shop.cart.Cart;
import com.itwill.shop.cart.CartDao;
import com.itwill.shop.product.Product;

public class CartDaoTestMain {
	
	public static void main(String[] args)throws Exception{
		CartDao cartDao = new CartDao();
		
		//1 카트추가
		System.out.println("카트추가>> "+cartDao.insert(new Cart(0, 3, "aa", new Product(1,"문과 남자의 과학공부", 15750, "/com/itwill/shop/image/bestSeller1", "유시민이 들려주는 과학 인문학이야기"))));
		
		//2 id, 상품종류로 카트제품존재(개수)확인
		System.out.println("카트개수>>"+cartDao.countByCart("sy1", 3));
		
	}
}
