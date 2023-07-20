package com.itwill.shop.ui.임범준;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class OrderPanel extends JPanel {
	private JTextField orderDeliveryAddressTF;
	private JTextField orderDeliveryNameTF;
	private JTextField orderDeliveryPhoneTF;

	/**
	 * Create the panel.
	 */
	public OrderPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane orderScrollPane = new JScrollPane();
		orderScrollPane.setPreferredSize(new Dimension(460, 1500));
		add(orderScrollPane, BorderLayout.CENTER);
		
		JPanel orderListPanel = new JPanel();
		orderScrollPane.setViewportView(orderListPanel);
		orderListPanel.setLayout(null);
		
		JPanel orderListTitlePanel = new JPanel();
		orderListTitlePanel.setBounds(12, 10, 434, 29);
		orderListPanel.add(orderListTitlePanel);
		orderListTitlePanel.setLayout(null);
		
		JLabel orderItemLB = new JLabel("주문 내역");
		orderItemLB.setFont(new Font("굴림", Font.BOLD, 20));
		orderItemLB.setHorizontalAlignment(SwingConstants.CENTER);
		orderItemLB.setBounds(117, 0, 189, 25);
		orderListTitlePanel.add(orderItemLB);
		
		JPanel orderLIst = new JPanel();
		orderLIst.setBounds(12, 49, 434, 200);
		orderListPanel.add(orderLIst);
		orderLIst.setLayout(null);
		
		JLabel orderItemImage = new JLabel("New label");
		orderItemImage.setPreferredSize(new Dimension(120, 175));
		orderItemImage.setBounds(12, 10, 120, 175);
		orderLIst.add(orderItemImage);
		
		JLabel orderDescLB = new JLabel("New label");
		orderDescLB.setBounds(180, 61, 180, 15);
		orderLIst.add(orderDescLB);
		
		JLabel orderItemPriceTitleLB = new JLabel("총 금액:");
		orderItemPriceTitleLB.setFont(new Font("굴림", Font.BOLD, 12));
		orderItemPriceTitleLB.setBounds(182, 125, 105, 41);
		orderLIst.add(orderItemPriceTitleLB);
		
		JLabel orderPriceLB = new JLabel("New label");
		orderPriceLB.setBounds(309, 125, 93, 41);
		orderLIst.add(orderPriceLB);
		
		JPanel orderTotalPricePanel = new JPanel();
		orderTotalPricePanel.setBounds(12, 259, 434, 34);
		orderListPanel.add(orderTotalPricePanel);
		orderTotalPricePanel.setLayout(null);
		
		JLabel orderTotalPriceNameLB = new JLabel("최종 결재 금액");
		orderTotalPriceNameLB.setFont(new Font("굴림", Font.BOLD, 14));
		orderTotalPriceNameLB.setBounds(12, 10, 150, 23);
		orderTotalPricePanel.add(orderTotalPriceNameLB);
		
		JLabel orderTotalPriceLB = new JLabel("50000원");
		orderTotalPriceLB.setFont(new Font("굴림", Font.BOLD, 14));
		orderTotalPriceLB.setHorizontalAlignment(SwingConstants.RIGHT);
		orderTotalPriceLB.setBounds(250, 10, 159, 23);
		orderTotalPricePanel.add(orderTotalPriceLB);
		
		JPanel orderDeliveryPanel = new JPanel();
		orderDeliveryPanel.setLayout(null);
		orderDeliveryPanel.setBorder(null);
		orderDeliveryPanel.setBackground(new Color(226, 226, 226));
		orderDeliveryPanel.setBounds(12, 303, 434, 146);
		orderListPanel.add(orderDeliveryPanel);
		
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
		orderDeliveryAddressTF.setBounds(103, 70, 229, 21);
		orderDeliveryPanel.add(orderDeliveryAddressTF);
		
		orderDeliveryNameTF = new JTextField();
		orderDeliveryNameTF.setToolTipText("");
		orderDeliveryNameTF.setColumns(10);
		orderDeliveryNameTF.setBounds(103, 39, 229, 21);
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
		orderDeliveryPhoneLB.setBounds(17, 106, 57, 15);
		orderDeliveryPanel.add(orderDeliveryPhoneLB);
		
		orderDeliveryPhoneTF = new JTextField();
		orderDeliveryPhoneTF.setBounds(103, 103, 229, 21);
		orderDeliveryPanel.add(orderDeliveryPhoneTF);
		orderDeliveryPhoneTF.setColumns(10);
		
		JButton btnNewButton = new JButton("주문하기");
		btnNewButton.setBounds(93, 477, 107, 23);
		orderListPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("취소하기");
		btnNewButton_1.setBounds(254, 477, 114, 23);
		orderListPanel.add(btnNewButton_1);

	}
}
