package com.itwill.shop.test;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import com.itwill.shop.product.Product;
import com.itwill.shop.product.ProductService;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class ProductSelfImprovementListPanel extends JPanel {
	private JPanel productSelfImprovementListPanel;
	public Main2 mainFrame;
	/**
	 * Create the panel.
	 */
	public ProductSelfImprovementListPanel() throws Exception {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(0, 0, 460, 500);
		add(scrollPane);
		
		productSelfImprovementListPanel = new JPanel();
		productSelfImprovementListPanel.setBackground(SystemColor.menu);
		productSelfImprovementListPanel.setPreferredSize(new Dimension(420, 750));
		scrollPane.setViewportView(productSelfImprovementListPanel);
		productSelfImprovementListPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JPanel bestSellerListPanel = new JPanel();
		bestSellerListPanel.setBackground(Color.WHITE);
		bestSellerListPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bestSellerListPanel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bestSellerListPanel.setPreferredSize(new Dimension(420, 175));
		productSelfImprovementListPanel.add(bestSellerListPanel);
		bestSellerListPanel.setLayout(null);
		
		JLabel bestSellerImageLabel = new JLabel("");
		bestSellerImageLabel.setIcon(new ImageIcon(ProductBestSellerListPanel.class.getResource("/com/itwill/shop/image/bestSeller2.jpg")));
		bestSellerImageLabel.setBounds(0, 0, 120, 175);
		bestSellerListPanel.add(bestSellerImageLabel);
		
		JLabel bestSellerNameLabel = new JLabel("");
		bestSellerNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bestSellerNameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		bestSellerNameLabel.setBounds(132, 10, 276, 44);
		bestSellerListPanel.add(bestSellerNameLabel);
		
		JButton buyButton = new JButton("바로구매");
		buyButton.setBounds(294, 119, 80, 40);
		bestSellerListPanel.add(buyButton);
		
		JButton cartButton = new JButton("");
		cartButton.setIcon(new ImageIcon(ProductBestSellerListPanel.class.getResource("/com/itwill/shop/image/shopping_cart_icon.png")));
		cartButton.setBounds(232, 119, 50, 40);
		bestSellerListPanel.add(cartButton);
		
		JLabel saleLabel = new JLabel("판매가");
		saleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		saleLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		saleLabel.setBounds(156, 64, 100, 30);
		bestSellerListPanel.add(saleLabel);
		
		JLabel priceLabel = new JLabel("원");
		priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		priceLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		priceLabel.setBounds(258, 64, 150, 30);
		bestSellerListPanel.add(priceLabel);
		
		
		
	}
	
	public void displayBestSellerList() throws Exception {
		List<Product> selfImprovementList = mainFrame.productService.selfImprovementList();
		
		productSelfImprovementListPanel.removeAll();
		
		for (Product product : selfImprovementList) {
			JPanel bestSellerListPanel = new JPanel();
			bestSellerListPanel.setBackground(Color.WHITE);
			bestSellerListPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			bestSellerListPanel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			bestSellerListPanel.setPreferredSize(new Dimension(420, 175));
			productSelfImprovementListPanel.add(bestSellerListPanel);
			bestSellerListPanel.setLayout(null);
			
			JLabel bestSellerImageLabel = new JLabel("");
			bestSellerImageLabel.setIcon(new ImageIcon(ProductBestSellerListPanel.class.getResource("/com/itwill/shop/image/"+product.getP_image())));
			bestSellerImageLabel.setBounds(0, 0, 120, 175);
			bestSellerListPanel.add(bestSellerImageLabel);
			
			JLabel bestSellerNameLabel = new JLabel(product.getP_name());
			bestSellerNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
			bestSellerNameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 17));
			bestSellerNameLabel.setBounds(132, 10, 276, 44);
			bestSellerListPanel.add(bestSellerNameLabel);
			
			JButton buyButton = new JButton("바로구매");
			buyButton.setBounds(294, 119, 90, 40);
			bestSellerListPanel.add(buyButton);
			
			JComboBox cartComboBox = new JComboBox();
			cartComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
			cartComboBox.setBounds(170, 119, 50, 23);
			bestSellerListPanel.add(cartComboBox);
			
			JButton cartButton = new JButton("");
			cartButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String cartQtyStr = (String)cartComboBox.getSelectedItem();
					int cartQty = Integer.parseInt(cartQtyStr);
				}
			});
			cartButton.setIcon(new ImageIcon(ProductBestSellerListPanel.class.getResource("/com/itwill/shop/image/216477_shopping_cart_icon (2).png")));
			cartButton.setBounds(232, 119, 50, 40);
			bestSellerListPanel.add(cartButton);
			
			JLabel saleLabel = new JLabel("판매가");
			saleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			saleLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
			saleLabel.setBounds(156, 64, 100, 30);
			bestSellerListPanel.add(saleLabel);
			
			JLabel priceLabel = new JLabel(product.getP_price()+"원");
			priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
			priceLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
			priceLabel.setBounds(258, 64, 150, 30);
			bestSellerListPanel.add(priceLabel);
		}
	}
	public void setMainFrame(Main2 mainFrame) throws Exception{
		this.mainFrame = mainFrame;
	}

}
