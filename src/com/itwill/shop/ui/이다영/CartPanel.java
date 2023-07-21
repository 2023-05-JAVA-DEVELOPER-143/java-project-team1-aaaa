package com.itwill.shop.ui.이다영;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;

import com.itwill.shop.cart.Cart;
import com.itwill.shop.cart.CartService;
import com.itwill.shop.product.ProductService;
import com.itwill.shop.test.Main2;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

public class CartPanel extends JPanel {
	
	/********Service************/
	private ProductService productService;
	private CartService cartService;
	
	public JButton deleteAllButton;
	private JLabel cartTotalLabel;
	private JLabel cartTotalPriceLabel;
	private JPanel cartListContentPanel;
	private JPanel cartListPanel;
	private JPanel cartBottomPanel;
	private JPanel itemPanel;
	private JLabel bookItemImageLabel;
	private JLabel bookTitleLabel;
	private JComboBox itemQtyComboBox;
	private JButton deleteButton;
	private JLabel bookPriceLabel;
	public JButton selectedItemOrderButton;
	/****Frame*****/
	private Main2 mainFrame;
	
	int totPrice = 0;
	
	/**
	 * Create the panel.
	 */
	public CartPanel() { // 생성자 시작
		setPreferredSize(new Dimension(460, 500)); 
		setLayout(new BorderLayout(0, 0));
		
		JPanel cartContentPanel = new JPanel();
		add(cartContentPanel, BorderLayout.CENTER);
		cartContentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel cartTopPanel = new JPanel();
		cartTopPanel.setPreferredSize(new Dimension(10, 50));
		cartContentPanel.add(cartTopPanel, BorderLayout.NORTH);
		cartTopPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("알라딘 배송");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 13));
		lblNewLabel.setBounds(179, 10, 77, 30);
		cartTopPanel.add(lblNewLabel);
		
		// 카트 전체삭제
		deleteAllButton = new JButton("전체 삭제");
		deleteAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					mainFrame.cartService.deleteCartItemByUserId(mainFrame.loginMember.getM_Id());
					JOptionPane.showMessageDialog(null, "전체상품이 삭제되었습니다.");
					displayCartList();
					resetCartTotalPrice();
					
				} catch (Exception e1) {
					//
				}
			}
		});
		
		deleteAllButton.setBounds(325, 14, 89, 23);
		cartTopPanel.add(deleteAllButton);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBounds(12, 21, 29, 23);
		cartTopPanel.add(chckbxNewCheckBox);
		
		cartBottomPanel = new JPanel();
		cartBottomPanel.setPreferredSize(new Dimension(10, 80));
		cartContentPanel.add(cartBottomPanel, BorderLayout.SOUTH);
		cartBottomPanel.setLayout(null);
		
		cartTotalLabel = new JLabel("총 상품금액");
		cartTotalLabel.setBounds(25, 38, 73, 15);
		cartBottomPanel.add(cartTotalLabel);
		
		// 카트 총 상품금액이 나오는 곳
		cartTotalPriceLabel = new JLabel("");
		cartTotalPriceLabel.setBounds(110, 25, 99, 28);
		cartBottomPanel.add(cartTotalPriceLabel);
		
		selectedItemOrderButton = new JButton("선택 상품 주문하기");
		selectedItemOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					// mainFrame.orderService.create(mainFrame.loginMember.getM_Id());
					// mainFrame.orderPanel.displayOrderList();
					// mainFrame.cartPanel.displayCartList();
					// resetCartTotalPrice();
					mainFrame.memberTabbedpane.setSelectedIndex(4);
				}catch(Exception e2) {
					e2.printStackTrace();
				}
				
				
				
			}
		});
		selectedItemOrderButton.setFont(new Font("굴림", Font.PLAIN, 15));
		selectedItemOrderButton.setBounds(254, 10, 169, 60);
		cartBottomPanel.add(selectedItemOrderButton);
		
		cartListPanel = new JPanel();
		cartContentPanel.add(cartListPanel, BorderLayout.CENTER);
		cartListPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(460, 400));
		scrollPane.setBounds(0, 0, 460, 370);
		cartListPanel.add(scrollPane);
		
		// 카트 리스트
		cartListContentPanel = new JPanel();
		cartListContentPanel.setPreferredSize(new Dimension(350, 500));
		scrollPane.setViewportView(cartListContentPanel);
		
		itemPanel = new JPanel(); // 카트 상품 디테일
		itemPanel.setBackground(new Color(255, 255, 255));
		itemPanel.setPreferredSize(new Dimension(440, 100));
		cartListContentPanel.add(itemPanel);
		itemPanel.setLayout(null);
		
		JCheckBox itemCheckBox = new JCheckBox("");
		itemCheckBox.setBackground(Color.WHITE);
		itemCheckBox.setBounds(8, 40, 21, 23);
		itemPanel.add(itemCheckBox);
		
		// 카트 상품 이미지 
		bookItemImageLabel = new JLabel("이미지");
		bookItemImageLabel.setBounds(49, 9, 63, 80);
		itemPanel.add(bookItemImageLabel);
		
		bookTitleLabel = new JLabel("책 이름");
		bookTitleLabel.setBounds(124, 20, 112, 58);
		itemPanel.add(bookTitleLabel);
		
		JLabel bookPriceLabel = new JLabel("가격");
		bookPriceLabel.setBounds(292, 40, 51, 23);
		itemPanel.add(bookPriceLabel);
		
		// 카트 상품 수량
		itemQtyComboBox = new JComboBox();
		itemQtyComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		itemQtyComboBox.setBounds(248, 40, 32, 23);
		itemPanel.add(itemQtyComboBox);
		
		JButton orderButton = new JButton("주문");
		orderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		orderButton.setBounds(345, 20, 72, 30);
		itemPanel.add(orderButton);
		
		deleteButton = new JButton("삭제");
		deleteButton.setBounds(345, 60, 72, 29);
		itemPanel.add(deleteButton);

		try {
			this.cartService = new CartService();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
	} // 생성자 끝
	
	
	public void displayCartList() throws Exception{
		
			cartListContentPanel.removeAll();
			
			List<Cart> cartList = mainFrame.cartService.findCartItemByAll(mainFrame.loginMember.getM_Id());
			totPrice = 0;
			
			/*********************for문 시작*****************/
			for(Cart cart : cartList) {
				totPrice += cart.getCart_qty()*cart.getProduct().getP_price();
				cartTotalPriceLabel.setText(new DecimalFormat("#,###원").format(totPrice));
				
				// 카트 상품 디테일 패널
				itemPanel = new JPanel();
				itemPanel.setBackground(new Color(255, 255, 255));
				itemPanel.setPreferredSize(new Dimension(420, 100));
				cartListContentPanel.add(itemPanel);
				
				// 카트 상품 이미지 가져오기
				bookItemImageLabel = new JLabel();
				bookItemImageLabel.setIcon(new ImageIcon(CartPanel.class.getResource("/com.itwill.shop/image"+cart.getProduct().getP_image())));
				bookItemImageLabel.setBounds(49, 9, 63, 80);
				itemPanel.add(bookItemImageLabel);
				
				// 카트 상품 제목 가져오기
				bookTitleLabel = new JLabel();
				bookTitleLabel.setText(cart.getProduct().getP_name());
				bookTitleLabel.setBounds(124, 20, 112, 58);
				itemPanel.add(bookTitleLabel);
				
				// 카트 상품 수량 수정 (콤보박스)
				itemQtyComboBox = new JComboBox();
				itemQtyComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
				itemQtyComboBox.setBounds(248, 40, 32, 23);
				
				/*********카트 상품이 수정이 되고 카트 총액이 바뀌고 ************/
				itemQtyComboBox.setSelectedItem(Integer.toString(cart.getCart_qty()));
				itemQtyComboBox.addItemListener(new ItemListener() {
					@Override
					public void itemStateChanged(ItemEvent e) {
						if(e.getStateChange()==ItemEvent.SELECTED) {
							try {
								int c_qty = Integer.parseInt((String)itemQtyComboBox.getSelectedItem());
								mainFrame.cartService.updateCart(cart.getCart_no(), c_qty);
								List<Cart> cartList = mainFrame.cartService.findCartItemByAll(mainFrame.loginMember.getM_Id());
								int totPrice = 0;
								for (Cart cart : cartList) {
									totPrice += cart.getCart_qty()*cart.getProduct().getP_price();
								}
							
							// 수량 수정하면 가격 변경
							 bookPriceLabel.setText(new DecimalFormat("#,###원").format(totPrice));
							 JOptionPane.showMessageDialog(null, "상품이 수정되었습니다.");
							
							}catch(Exception e1){
								e1.printStackTrace();
								
							}
						}
						
					}
				});
				
				itemPanel.add(itemQtyComboBox); // 상품 수정 후 마지막에 콤보박스가 추가되야함.
				
				
				// 카트 리스트 안에서 삭제 버튼 누르면 상품 삭제
				deleteButton = new JButton();
				deleteButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// 삭제 메소드, m_id인자 들어와야함.
						try {
							mainFrame.cartService.deleteCartItemByCartNo(cart.getCart_no());
							JOptionPane.showMessageDialog(null, "상품이 삭제되었습니다.");
							itemPanel.removeAll();
							
							// 카트 총액이 변경
							if(cartList.size()==0) {
								cartTotalPriceLabel.setText("");
								cartTotalPriceLabel.setBounds(110, 25, 99, 28);
								cartBottomPanel.add(cartTotalPriceLabel);
							}else {
								cartTotalPriceLabel.setText(new DecimalFormat("#,###원").format(totPrice));
								cartTotalPriceLabel.setBounds(110, 25, 99, 28);
								cartBottomPanel.add(cartTotalPriceLabel);
							}
							
							displayCartList();
							cartTotalPriceLabel.setText(new DecimalFormat("#,###원").format(totPrice));
							cartTotalPriceLabel.setBounds(110, 25, 99, 28);
							cartBottomPanel.add(cartTotalPriceLabel);
							
							
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						
					}
				});
				//카트 아이템 디테일 끝
				
				
			} /**************** for문 끝 *****************/
			
			
				
	} // displayCartList() 끝
	
	
	public void resetCartTotalPrice() {
		cartTotalPriceLabel.removeAll();
		cartTotalPriceLabel.setBounds(110, 25, 99, 28);
		cartBottomPanel.add(cartTotalPriceLabel);
		
	}
	
	
	public void setMainFrame(Main2 mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	
}
