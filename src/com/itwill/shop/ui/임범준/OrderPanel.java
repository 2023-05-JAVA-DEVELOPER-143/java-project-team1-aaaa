package com.itwill.shop.ui.임범준;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.itwill.shop.member.Member;
import com.itwill.shop.order.Order;
import com.itwill.shop.order.OrderItem;
import com.itwill.shop.product.Product;
import com.itwill.shop.test.Main2;

public class OrderPanel extends JPanel {
	private JTextField orderDeliveryAddressTF;
	private JTextField orderDeliveryNameTF;
	private JTextField orderDeliveryPhoneTF;
	
	public Main2 mainFrame;
	
	/*******loginMember 객체 선언***********/
	
	private JPanel orderListTitlePanel;
	private JPanel orderListPanel;
	private JPanel orderTotalPricePanel;
	private JPanel orderDeliveryPanel;
	private JPanel orderListPanelScroll;
	private JPanel orderPanel;

	/**
	 * Create the panel.
	 */
	public OrderPanel() {
		setLayout(new BorderLayout(0, 0));
		
		orderPanel = new JPanel();
		add(orderPanel, BorderLayout.CENTER);
		orderPanel.setLayout(null);
		
		orderListTitlePanel = new JPanel();
		orderListTitlePanel.setLayout(null);
		orderListTitlePanel.setBounds(12, 10, 434, 29);
		orderPanel.add(orderListTitlePanel);
		
		JLabel orderItemLB = new JLabel("주문 내역");
		orderItemLB.setHorizontalAlignment(SwingConstants.CENTER);
		orderItemLB.setFont(new Font("굴림", Font.BOLD, 20));
		orderItemLB.setBounds(117, 0, 189, 25);
		orderListTitlePanel.add(orderItemLB);
		
		orderListPanel = new JPanel();
		orderListPanel.setBounds(12, 49, 434, 205);
		orderPanel.add(orderListPanel);
		orderListPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane orderListScrollPane = new JScrollPane();
		orderListPanel.add(orderListScrollPane, BorderLayout.CENTER);
		
		orderListPanelScroll = new JPanel();
		orderListPanelScroll.setPreferredSize(new Dimension(10, 2000));
		orderListScrollPane.setViewportView(orderListPanelScroll);
		orderListPanelScroll.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel orderItemPanel = new JPanel();
		orderItemPanel.setPreferredSize(new Dimension(410, 200));
		orderListPanelScroll.add(orderItemPanel);
		orderItemPanel.setLayout(null);
		
		JLabel orderItemImage = new JLabel("이미지");
		orderItemImage.setPreferredSize(new Dimension(120, 175));
		orderItemImage.setBounds(12, 10, 120, 175);
		orderItemPanel.add(orderItemImage);
		
		JLabel orderDescLB = new JLabel("주문내역");
		orderDescLB.setHorizontalAlignment(SwingConstants.CENTER);
		orderDescLB.setBounds(191, 68, 180, 15);
		orderItemPanel.add(orderDescLB);
		
		JLabel orderItemPriceTitleLB = new JLabel("총 금액:");
		orderItemPriceTitleLB.setFont(new Font("굴림", Font.BOLD, 12));
		orderItemPriceTitleLB.setBounds(173, 127, 105, 41);
		orderItemPanel.add(orderItemPriceTitleLB);
		
		JLabel orderItemPriceLB = new JLabel("10000원");
		orderItemPriceLB.setBounds(300, 127, 93, 41);
		orderItemPanel.add(orderItemPriceLB);
		
		JButton orderCancelbtn = new JButton("New button");
		orderCancelbtn.setBounds(353, 10, 50, 30);
		orderItemPanel.add(orderCancelbtn);
		
		orderTotalPricePanel = new JPanel();
		orderTotalPricePanel.setLayout(null);
		orderTotalPricePanel.setBounds(12, 263, 434, 34);
		orderPanel.add(orderTotalPricePanel);
		
		JLabel orderTotalPriceNameLB = new JLabel("최종 결재 금액");
		orderTotalPriceNameLB.setFont(new Font("굴림", Font.BOLD, 14));
		orderTotalPriceNameLB.setBounds(12, 10, 150, 23);
		orderTotalPricePanel.add(orderTotalPriceNameLB);
		
		JLabel orderTotalPriceLB = new JLabel("50000원");
		orderTotalPriceLB.setHorizontalAlignment(SwingConstants.RIGHT);
		orderTotalPriceLB.setFont(new Font("굴림", Font.BOLD, 14));
		orderTotalPriceLB.setBounds(250, 10, 159, 23);
		orderTotalPricePanel.add(orderTotalPriceLB);
		
		orderDeliveryPanel = new JPanel();
		orderDeliveryPanel.setLayout(null);
		orderDeliveryPanel.setBorder(null);
		orderDeliveryPanel.setBackground(new Color(226, 226, 226));
		orderDeliveryPanel.setBounds(12, 312, 434, 146);
		orderPanel.add(orderDeliveryPanel);
		
		JLabel orderDeliveryInfoLB = new JLabel("배송정보");
		orderDeliveryInfoLB.setHorizontalAlignment(SwingConstants.CENTER);
		orderDeliveryInfoLB.setFont(new Font("Dialog", Font.PLAIN, 14));
		orderDeliveryInfoLB.setBounds(171, 10, 85, 19);
		orderDeliveryPanel.add(orderDeliveryInfoLB);
		
		JCheckBox orderDeliveryCKB = new JCheckBox("기본 배송지");
		orderDeliveryCKB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(orderDeliveryCKB.isSelected()) {
					orderDeliveryNameTF.setText(mainFrame.loginMember.getM_Name());
					orderDeliveryAddressTF.setText(mainFrame.loginMember.getM_Address());
					orderDeliveryPhoneTF.setText(mainFrame.loginMember.getM_Phone());
				} else {
					orderDeliveryNameTF.setText("");
					orderDeliveryAddressTF.setText("");
					orderDeliveryPhoneTF.setText("");
					orderDeliveryNameTF.requestFocus();
					
				}
			}
		});
		orderDeliveryCKB.setHorizontalTextPosition(SwingConstants.LEADING);
		orderDeliveryCKB.setHorizontalAlignment(SwingConstants.CENTER);
		orderDeliveryCKB.setFont(new Font("Dialog", Font.PLAIN, 14));
		orderDeliveryCKB.setBorder(null);
		orderDeliveryCKB.setBackground(new Color(226, 226, 226));
		orderDeliveryCKB.setBounds(320, 6, 102, 23);
		orderDeliveryPanel.add(orderDeliveryCKB);
		
		orderDeliveryAddressTF = new JTextField();
		orderDeliveryAddressTF.setColumns(10);
		orderDeliveryAddressTF.setBounds(116, 70, 229, 21);
		orderDeliveryPanel.add(orderDeliveryAddressTF);
		
		orderDeliveryNameTF = new JTextField();
		orderDeliveryNameTF.setToolTipText("");
		orderDeliveryNameTF.setColumns(10);
		orderDeliveryNameTF.setBounds(116, 39, 229, 21);
		orderDeliveryPanel.add(orderDeliveryNameTF);
		
		JLabel orderDeliveryAddressLB = new JLabel("주소");
		orderDeliveryAddressLB.setFont(new Font("Dialog", Font.PLAIN, 14));
		orderDeliveryAddressLB.setBounds(27, 72, 57, 15);
		orderDeliveryPanel.add(orderDeliveryAddressLB);
		
		JLabel orderDeliveryNameLB = new JLabel("받는 사람");
		orderDeliveryNameLB.setFont(new Font("Dialog", Font.PLAIN, 14));
		orderDeliveryNameLB.setBounds(17, 41, 68, 15);
		orderDeliveryPanel.add(orderDeliveryNameLB);
		
		JLabel orderDeliveryPhoneLB = new JLabel("전화번호");
		orderDeliveryPhoneLB.setFont(new Font("굴림", Font.PLAIN, 14));
		orderDeliveryPhoneLB.setBounds(17, 106, 67, 15);
		orderDeliveryPanel.add(orderDeliveryPhoneLB);
		
		orderDeliveryPhoneTF = new JTextField();
		orderDeliveryPhoneTF.setColumns(10);
		orderDeliveryPhoneTF.setBounds(116, 103, 229, 21);
		orderDeliveryPanel.add(orderDeliveryPhoneTF);
		
		JButton orderBtn = new JButton("주문하기");
		orderBtn.setBounds(90, 489, 107, 23);
		orderPanel.add(orderBtn);
		
		JButton orderCancelBtn = new JButton("취소하기");
		orderCancelBtn.setBounds(251, 489, 114, 23);
		orderPanel.add(orderCancelBtn);

	} // 생성자 종료
	
	public void setMainFrame(Main2 mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	
	public void displayOrderList() throws Exception {
//		orderListTitlePanel = new JPanel();
//		orderListTitlePanel.setLayout(null);
//		orderListTitlePanel.setBounds(12, 10, 434, 29);
//		orderPanel.add(orderListTitlePanel);
//		JLabel orderItemLB = new JLabel("주문 내역");
//		orderItemLB.setHorizontalAlignment(SwingConstants.CENTER);
//		orderItemLB.setFont(new Font("굴림", Font.BOLD, 20));
//		orderItemLB.setBounds(117, 0, 189, 25);
//		orderListTitlePanel.add(orderItemLB);
//		
		
//		String orderName = null;
//		int orderNo = 0;
//		
//		Order tempOrder = null;
//		List<Order> orderList = mainFrame.orderService.orderWithOrderItemList(mainFrame.loginMember.getM_Id());
//		for (Order order : orderList) {
//			orderName = order.getO_desc();
//			orderNo = order.getO_no();
//		}
//		tempOrder = mainFrame.orderService.orderWithOrderItem(mainFrame.loginMember.getM_Id(), orderNo);
//			orderListPanel.removeAll();
//			
//			JLabel orderItemImage = new JLabel("이미지");
//			orderItemImage.setPreferredSize(new Dimension(120, 175));
//			orderItemImage.setIcon(new ImageIcon(OrderPanel.class.getResource("/images/50"+tempOrder.getOrderItemList().get(0).getProduct().getP_price())));
//			orderItemImage.setBounds(12, 10, 120, 175);
//			orderListPanelScroll.add(orderItemImage);
//			
//			JLabel orderDescLB = new JLabel(orderName + "외 "+(orderList.size()-1)+"건");
//			orderDescLB.setHorizontalAlignment(SwingConstants.CENTER);
//			orderDescLB.setBounds(191, 68, 180, 15);
//			orderListPanelScroll.add(orderDescLB);
//			
//			JLabel orderItemPriceTitleLB = new JLabel("총 주문금액:");
//			orderItemPriceTitleLB.setFont(new Font("굴림", Font.BOLD, 12));
//			orderItemPriceTitleLB.setBounds(173, 127, 105, 41);
//			orderListPanelScroll.add(orderItemPriceTitleLB);
//			
//			JLabel orderItemPriceLB = new JLabel(new DecimalFormat("#,###원").format(mainFrame.orderService.orderWithOrderItemList(loginMember.getM_Id())));
//			orderItemPriceLB.setBounds(300, 127, 93, 41);
//			orderListPanelScroll.add(orderItemPriceLB);
//			
//			JButton orderCancelbtn = new JButton("");
//			orderCancelbtn.addMouseListener(new MouseAdapter() {
//				@Override
//				public void mouseClicked(MouseEvent arg0) {
//					try {
////						mainFrame.orderService.deleteByOrderNo(.getO_no());
//						mainFrame.shopTabbedPane.setSelectedIndex(0);
//						mainFrame.shopTabbedPane.setSelectedIndex(4);
//						
//						displayOrderList();
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			});
//			orderCancelbtn.setBounds(353, 10, 50, 30);
//			orderListPanelScroll.add(orderCancelbtn);
//			
//		
		
		String orderName = null;
		int orderNo=0;
		Order itemOrder = null;
		List<Order> orderList=mainFrame.orderService.orderList(mainFrame.loginMember.getM_Id());
		System.out.println(orderList);
		for (Order order : orderList) {
			orderName = order.getO_desc();
			orderNo = order.getO_no();
		}
		
		JLabel orderItemImage = new JLabel("이미지");
		orderItemImage.setPreferredSize(new Dimension(120, 175));
		orderItemImage.setIcon(new ImageIcon(OrderPanel.class.getResource("/com/iwtill/shop/image/"+mainFrame.orderItem.getProduct().getP_image())));
		orderItemImage.setBounds(12, 10, 120, 175);
		orderListPanelScroll.add(orderItemImage);
		
		JLabel orderDescLB = new JLabel(mainFrame.orderItem.getProduct().getP_name() + "외 "+(orderList.size()-1)+"건");
		orderDescLB.setHorizontalAlignment(SwingConstants.CENTER);
		orderDescLB.setBounds(191, 68, 180, 15);
		orderListPanelScroll.add(orderDescLB);
		
		JLabel orderItemPriceTitleLB = new JLabel("총 주문금액:");
		orderItemPriceTitleLB.setFont(new Font("굴림", Font.BOLD, 12));
		orderItemPriceTitleLB.setBounds(173, 127, 105, 41);
		orderListPanelScroll.add(orderItemPriceTitleLB);
		
		JLabel orderItemPriceLB = new JLabel(new DecimalFormat("#,###원").format(mainFrame.orderService.orderWithOrderItemList(mainFrame.loginMember.getM_Id())));
		orderItemPriceLB.setBounds(300, 127, 93, 41);
		orderListPanelScroll.add(orderItemPriceLB);
		
		JButton orderCancelbtn = new JButton("");
		orderCancelbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					mainFrame.orderService.deleteByOrderNo(mainFrame.order.getO_no());
					mainFrame.shopTabbedPane.setSelectedIndex(0);
					mainFrame.shopTabbedPane.setSelectedIndex(4);
					
					displayOrderList();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		orderCancelbtn.setBounds(353, 10, 50, 30);
		orderListPanelScroll.add(orderCancelbtn);
		
	}	
			
				
}
		



	

