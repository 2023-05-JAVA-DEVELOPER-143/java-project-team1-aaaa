package com.itwill.shop.ui.이다영;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.itwill.shop.cart.Cart;
import com.itwill.shop.cart.CartService;
import com.itwill.shop.member.Member;
import com.itwill.shop.product.ProductService;
import com.itwill.shop.test.Main2;
import javax.swing.SwingConstants;

public class CartPanel extends JPanel {
	
	/********Service************/
	private ProductService productService;
	private CartService cartService;
	
	public JButton deleteAllButton;
	private JLabel cartTotalLabel;
	private JLabel cartTotalPriceLabel;
	private JPanel cartListContentPanel;
	private JPanel cartListPanel;
	private JPanel itemPanel;
	private JLabel bookItemImageLabel;
	private JLabel bookTitleLabel;
	private JComboBox itemQtyComboBox;
	private JButton deleteButton;
	private JLabel priceLabel;
	/****Frame*****/
	private Main2 mainFrame;
	
	int totPrice = 0;
	private JLabel bookPriceLabel;
	private JPanel cartBottomPanel;
	private JPanel cartContentPanel;
	private JScrollPane scrollPane;
	private JCheckBox itemCheckBox;
	
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public CartPanel() throws Exception { // 생성자 시작
		setPreferredSize(new Dimension(460, 500)); 
		setLayout(new BorderLayout(0, 0));
		
		cartContentPanel = new JPanel();
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
		cartTotalLabel.setFont(new Font("굴림", Font.PLAIN, 14));
		cartTotalLabel.setBounds(25, 22, 97, 26);
		cartBottomPanel.add(cartTotalLabel);
		
		// 카트 총 상품금액이 나오는 곳
		cartTotalPriceLabel = new JLabel("");
		cartTotalPriceLabel.setBounds(134, 10, 132, 47);
		cartBottomPanel.add(cartTotalPriceLabel);
		
		JButton selectedItemOrderButton = new JButton("주문하기");
		selectedItemOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					mainFrame.orderService.create(mainFrame.loginMember.getM_Id());
					
					mainFrame.shopTabbedPane.setSelectedIndex(0);
					mainFrame.shopTabbedPane.setSelectedIndex(4);
					displayCartList();
				}catch(Exception e2) {
					e2.printStackTrace();
				}
				
				
				
			}
		});
		selectedItemOrderButton.setFont(new Font("굴림", Font.PLAIN, 15));
		selectedItemOrderButton.setBounds(294, 10, 142, 60);
		cartBottomPanel.add(selectedItemOrderButton);
		
		cartListPanel = new JPanel();
		cartContentPanel.add(cartListPanel, BorderLayout.CENTER);
		cartListPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(460, 2000));
		scrollPane.setBounds(0, 0, 460, 370);
		cartListPanel.add(scrollPane);
		
		// 카트 리스트
		cartListContentPanel = new JPanel();
		cartListContentPanel.setPreferredSize(new Dimension(350, 2000));
		scrollPane.setViewportView(cartListContentPanel);
		
		itemPanel = new JPanel(); // 카트 상품 디테일
		itemPanel.setBackground(new Color(255, 255, 255));
		itemPanel.setPreferredSize(new Dimension(440, 230));
		itemPanel.setLayout(null);
		cartListContentPanel.add(itemPanel);
		
		itemCheckBox = new JCheckBox("");
		itemCheckBox.setBackground(Color.WHITE);
		itemCheckBox.setBounds(8, 94, 21, 23);
		itemPanel.add(itemCheckBox);
		
		// 카트 상품 이미지 
		bookItemImageLabel = new JLabel("이미지");
		bookItemImageLabel.setBounds(82, 50, 81, 96);
		itemPanel.add(bookItemImageLabel);
		
		bookTitleLabel = new JLabel("책 이름");
		bookTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bookTitleLabel.setBounds(186, 49, 228, 30);
		itemPanel.add(bookTitleLabel);
		
		bookPriceLabel = new JLabel("");
		bookPriceLabel.setBounds(322, 108, 81, 23);
		itemPanel.add(bookPriceLabel);
		
		// 카트 상품 수량
		itemQtyComboBox = new JComboBox();
		itemQtyComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		itemQtyComboBox.setBounds(244, 176, 40, 30);
		itemPanel.add(itemQtyComboBox);
		
		
		deleteButton = new JButton("삭제");
		deleteButton.setBounds(296, 175, 95, 30);
		itemPanel.add(deleteButton);
		
		priceLabel = new JLabel("상품금액  :");
		priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		priceLabel.setFont(new Font("굴림", Font.BOLD, 15));
		priceLabel.setBounds(219, 108, 81, 30);
		itemPanel.add(priceLabel);

	
			
		this.cartService = new CartService();
		
			
	} // 생성자 끝
	
	public void setMainFrame(Main2 mainFrame) throws Exception {
		this.mainFrame=mainFrame;
		
	}
	
	
	
	public void displayCartList() throws Exception{
		
			JCheckBox[] cartCB = null;
			cartListContentPanel.removeAll();
			List<Cart> cartList = mainFrame.cartService.findCartItemByAll(mainFrame.loginMember.getM_Id());
			totPrice = 0;
			cartCB = new JCheckBox[cartList.size()];
			/*********************for문 시작*****************/
			for(Cart cart : cartList) {
				
				// 카트 상품 디테일 패널
				itemPanel = new JPanel();
				itemPanel.setBackground(new Color(255, 255, 255));
				itemPanel.setPreferredSize(new Dimension(420, 230));
				itemPanel.setLayout(null);
				cartListContentPanel.add(itemPanel);

				
				
				// 카트 상품 이미지 가져오기
				bookItemImageLabel = new JLabel();
				bookItemImageLabel.setIcon(new ImageIcon(CartPanel.class.getResource("/com/itwill/shop/image/"+cart.getProduct().getP_image())));
				bookItemImageLabel.setBounds(50, 10, 120, 175);
				itemPanel.add(bookItemImageLabel);

				
				totPrice += cart.getCart_qty() * cart.getProduct().getP_price();
				cartTotalPriceLabel = new JLabel("");
				cartTotalPriceLabel.setText(new DecimalFormat("#,###원").format(totPrice));
				cartTotalPriceLabel.setBounds(134, 10, 132, 47);
				cartBottomPanel.add(cartTotalPriceLabel);
				
				
				//카트 상품 수량에따른 가격
				bookPriceLabel = new JLabel();
				bookPriceLabel.setText(new DecimalFormat("#,###원").format(cart.getProduct().getP_price() * cart.getCart_qty()));
				bookPriceLabel.setBounds(322, 108, 81, 23);
				itemPanel.add(bookPriceLabel);
				
				// 카트 상품 제목 가져오기
				bookTitleLabel = new JLabel("책 이름");
				bookTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
				bookTitleLabel.setText(cart.getProduct().getP_name());
				bookTitleLabel.setBounds(186, 49, 228, 30);
				itemPanel.add(bookTitleLabel);
				
				itemCheckBox = new JCheckBox("");
				itemCheckBox.setBackground(Color.WHITE);
				itemCheckBox.setBounds(8, 94, 21, 23);
				itemPanel.add(itemCheckBox);
				
				
				priceLabel = new JLabel("상품금액  :");
				priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
				priceLabel.setFont(new Font("굴림", Font.BOLD, 15));
				priceLabel.setBounds(219, 108, 81, 30);
				itemPanel.add(priceLabel);
				
				
				// 카트 상품 수량 수정 (콤보박스)
				itemQtyComboBox = new JComboBox();
				itemQtyComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
				itemQtyComboBox.setBounds(244, 176, 40, 30);
				itemQtyComboBox.setSelectedItem(cart.getCart_qty() + "");
				itemQtyComboBox.addItemListener(new ItemListener() {
					private Cart c = cart;
					
					public void itemStateChanged(ItemEvent e) {
						if(e.getStateChange() == ItemEvent.SELECTED) {
							//카트 갯수에따른 총금액
							try {
								String cartSelectedQtyStr = (String)itemQtyComboBox.getSelectedItem();
								int cartSelectedQty = Integer.parseInt(cartSelectedQtyStr);
								int updateCartCount = cartService.updateCart(c.getCart_no(), cartSelectedQty);
								// 카트아이템총가격변경
								bookPriceLabel.setText(new DecimalFormat("#,###원").format(c.getProduct().getP_price() * cartSelectedQty));

								
							}catch (Exception e1) {
								e1.printStackTrace();
							}
						}
					}
				});
				/*********카트 상품이 수정이 되고 카트 총액이 바뀌고 ************/
				itemPanel.add(itemQtyComboBox); // 상품 수정 후 마지막에 콤보박스가 추가되야함.

				
				// 카트 리스트 안에서 삭제 버튼 누르면 상품 삭제
				deleteButton = new JButton("삭제");
				deleteButton.addActionListener(new ActionListener() {
					private Cart c = cart;			
					public void actionPerformed(ActionEvent e) {
						// 삭제 메소드, m_id인자 들어와야함.
						// 카트 총액
						try {
							int deleteItemCount = mainFrame.cartService.deleteCartItemByCartNo(cart.getCart_no());
							JOptionPane.showMessageDialog(null, "상품이 삭제되었습니다");

							
							displayCartList();
							cartTotalPriceLabel.setText(new DecimalFormat("#,###원").format(totPrice));
							cartTotalPriceLabel.setBounds(110, 25, 99, 28);
							cartBottomPanel.add(cartTotalPriceLabel);
							
							mainFrame.shopTabbedPane.setSelectedIndex(0);
							mainFrame.shopTabbedPane.setSelectedIndex(3);
							
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				
				deleteButton.setBounds(296, 175, 95, 30);
				itemPanel.add(deleteButton);

				cartListContentPanel.add(itemPanel);
				
				//카트 아이템 디테일 끝
				
			
			} /**************** for문 끝 *****************/
			
				
	} // displayCartList() 끝
	
	public String addCartListTotal() throws Exception {
		mainFrame.loginMember = new Member();
		return Integer.toString(mainFrame.cartService.addCartListTotal(mainFrame.loginMember.getM_Id()));
		
	}
	
	
	
	public void resetCart() throws Exception {
		cartTotalPriceLabel.setText(addCartListTotal() + "원");
		displayCartList();
	}
}
