package com.itwill.shop.ui.임범준;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.itwill.shop.member.Member;
import com.itwill.shop.order.Order;
import com.itwill.shop.test.Main2;

public class OrderPanel1 extends JPanel {
	private JTextField orderDeliveryAddressTF;
	private JTextField orderDeliveryNameTF;
	private JTextField orderDeliveryPhoneTF;
	
	public Main2 mainFrame;
	
	
	
	/*******loginMember 객체 선언***********/
	Member loginMember = null;

	/**
	 * Create the panel.
	 */
	public OrderPanel1() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel orderPanel = new JPanel();
		add(orderPanel, BorderLayout.CENTER);
		orderPanel.setLayout(null);
		
		JPanel orderListTitlePanel = new JPanel();
		orderListTitlePanel.setLayout(null);
		orderListTitlePanel.setBounds(12, 10, 434, 29);
		orderPanel.add(orderListTitlePanel);
		
		JLabel orderItemLB = new JLabel("주문 내역");
		orderItemLB.setHorizontalAlignment(SwingConstants.CENTER);
		orderItemLB.setFont(new Font("굴림", Font.BOLD, 20));
		orderItemLB.setBounds(117, 0, 189, 25);
		orderListTitlePanel.add(orderItemLB);
		
		JPanel orderListPanel = new JPanel();
		orderListPanel.setBounds(12, 49, 434, 205);
		orderPanel.add(orderListPanel);
		orderListPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane orderListScrollPane = new JScrollPane();
		orderListPanel.add(orderListScrollPane, BorderLayout.CENTER);
		
		JPanel orderListPanelScroll = new JPanel();
		orderListPanelScroll.setPreferredSize(new Dimension(10, 2000));
		orderListScrollPane.setViewportView(orderListPanelScroll);
		orderListPanelScroll.setLayout(null);
		
		JLabel orderItemImage = new JLabel("New label");
		orderItemImage.setPreferredSize(new Dimension(120, 175));
		orderItemImage.setBounds(12, 10, 120, 175);
		orderListPanelScroll.add(orderItemImage);
		
		JLabel orderDescLB = new JLabel("New label");
		orderDescLB.setBounds(191, 68, 180, 15);
		orderListPanelScroll.add(orderDescLB);
		
		JLabel orderItemPriceTitleLB = new JLabel("총 금액:");
		orderItemPriceTitleLB.setFont(new Font("굴림", Font.BOLD, 12));
		orderItemPriceTitleLB.setBounds(173, 127, 105, 41);
		orderListPanelScroll.add(orderItemPriceTitleLB);
		
		JLabel orderPriceLB = new JLabel("New label");
		orderPriceLB.setBounds(300, 127, 93, 41);
		orderListPanelScroll.add(orderPriceLB);
		
		JPanel orderTotalPricePanel = new JPanel();
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
		
		JPanel orderDeliveryPanel = new JPanel();
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
	
	
	public void displayOrderList() {
		Order tempOrder = null;
		
		
	}
	
	
	
	
	
}
