package com.itwill.shop.order;

import java.util.ArrayList;
import java.util.List;

import com.itwill.shop.cart.Cart;
import com.itwill.shop.cart.CartDao;
import com.itwill.shop.product.Product;
import com.itwill.shop.product.ProductDao;

public class OrderService {
	private OrderDao orderDao;
	private ProductDao productDao;
	private CartDao cartDao;
	public OrderService() throws Exception{
		orderDao=new OrderDao();
		productDao=new ProductDao();
		cartDao=new CartDao();
	}
	/*
	 * 주문1개삭제
	 */
	public int deleteByOrderNo(int o_no)throws Exception{
		return orderDao.deleteByOrderNo(o_no);
	}
	/*
	 * 주문전체삭제
	 */
	public int delete(String sUserId)throws Exception{
		return orderDao.deleteByUserId(sUserId);
	}
	/*
	 * 주문목록
	 */
	public List<Order> orderList(String sUserId) throws Exception{
		return orderDao.findOrderByUserId(sUserId);
	}
	/*
	 * 주문+주문아이템 목록
	 */
	public List<Order> orderWithOrderItemList(String sUserId) throws Exception{
		return orderDao.findOrderWithOrderItemByUserId(sUserId);
	}
	/*
	 * 주문+주문아이템 상세보기
	 */
	public Order orderWithOrderItem(int o_no)throws Exception{
		return orderDao.findByOrderNo(o_no);
	}
	/*
	 * 상품에서 직접주문
	 */
	public int create(String m_id,int p_no,int oi_qty) throws Exception{
		
		Product product=productDao.findByNo(p_no);
		OrderItem orderItem=new OrderItem(0, oi_qty, p_no, product);
		ArrayList<OrderItem> orderItemList=new ArrayList<OrderItem>();
		orderItemList.add(orderItem);
		
		Order newOrder=
				new Order(0,null,
						orderItemList.get(0).getProduct().getP_name()+"외 "+(oi_qty-1)+" 개", 
						null,m_id,
						orderItemList.get(0).getOi_qty()*orderItemList.get(0).getProduct().getP_price(),
						orderItemList);
		
		return orderDao.insert(newOrder);
	}
	
	/*
	 * cart에서 주문
	 */
	public int create(String m_id) throws Exception{
		List<Cart> cartList=cartDao.findSelectAll(m_id);
		ArrayList<OrderItem> orderItemList=new ArrayList<OrderItem>();
		int o_tot_price=0;
		int oi_tot_count=0;
		for (Cart cart : cartList) {
			OrderItem orderItem=new OrderItem(0,cart.getCart_qty(),0, cart.getProduct());
			orderItemList.add(orderItem);
			o_tot_price+=orderItem.getOi_qty()*orderItem.getProduct().getP_price();
			oi_tot_count+=orderItem.getOi_qty();
		}
		String o_desc = orderItemList.get(0).getProduct().getP_name()+"외 "+(oi_tot_count-1)+" 개";
		
		Order newOrder=new Order(0,o_desc, null, o_tot_price, m_id,orderItemList);
		orderDao.insert(newOrder);
		cartDao.deleteByAll(m_id);
		return 0;
	}
	/*
	 * cart에서 선택주문
	 */
	public int create(String m_Id,String[] cart_item_noStr_array) throws Exception{
		
		ArrayList<OrderItem> orderItemList=new ArrayList<OrderItem>();
		int o_tot_price=0;
		int oi_tot_count=0;
		for(int i =0;i<cart_item_noStr_array.length;i++) {
			Cart  cartItem = cartDao.findSelectByCartNo(Integer.parseInt(cart_item_noStr_array[i]));
			OrderItem orderItem=new OrderItem(0, cartItem.getCart_qty(),0,cartItem.getProduct());
			orderItemList.add(orderItem);
			o_tot_price+=orderItem.getOi_qty()*orderItem.getProduct().getP_price();
			oi_tot_count+=orderItem.getOi_qty();
		}
		String o_desc = orderItemList.get(0).getProduct().getP_name()+"외 "+(oi_tot_count-1)+" 개";
		
		Order newOrder=new Order(0,o_desc, null, o_tot_price, m_Id,orderItemList);
		orderDao.insert(newOrder);
		
		for(int i =0;i<cart_item_noStr_array.length;i++) {
			cartDao.deleteByCartNo(Integer.parseInt(cart_item_noStr_array[i]));
		}
		return 0;
	}
}
