package com.itwill.shop.ui.권경록;

import javax.swing.JPanel;

import com.itwill.shop.product.Product;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;

public class ProductDetailPanel extends JPanel {
	
	Product product;
	private JScrollPane scrollPane;
	private JPanel panel;
	/**
	 * Create the panel.
	 */
	public ProductDetailPanel() {
		setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(-1, 0, 464, 503);
		add(scrollPane);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(446, 800));
		scrollPane.setViewportView(panel);
		
		JLabel productDetailImageLabel = new JLabel("");
		productDetailImageLabel.setIcon(new ImageIcon(ProductDetailPanel.class.getResource("/com/itwill/shop/image/bestSeller1.jpg")));
		
		productDetailImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		productDetailImageLabel.setBounds(0, 0, 446, 300);
		panel.add(productDetailImageLabel);
		
		JLabel productDetailNameLabel = new JLabel("제목");
	
		productDetailNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		productDetailNameLabel.setBounds(0, 310, 446, 50);
		panel.add(productDetailNameLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(88, 438, 60, 35);
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(160, 430, 130, 50);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(300, 430, 130, 50);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("판매가");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblNewLabel.setBounds(121, 370, 66, 50);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(199, 370, 231, 50);
		panel.add(lblNewLabel_1);

	}
	
	public void setProduct(Product product) {
		this.product = product;
	}

	public void displayProductDetail() {
		panel.removeAll();
		JLabel productDetailImageLabel = new JLabel("");
		productDetailImageLabel.setIcon(new ImageIcon(ProductDetailPanel.class.getResource("/com/itwill/shop/image/"+product.getP_image())));
		
		productDetailImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		productDetailImageLabel.setBounds(0, 0, 446, 300);
		panel.add(productDetailImageLabel);
		
		
		JLabel productDetailNameLabel = new JLabel(product.getP_name());
		
		productDetailNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		productDetailNameLabel.setBounds(0, 310, 446, 50);
		panel.add(productDetailNameLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(88, 438, 60, 35);
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(160, 430, 130, 50);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(300, 430, 130, 50);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("판매가");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblNewLabel.setBounds(121, 370, 66, 50);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(199, 370, 231, 50);
		panel.add(lblNewLabel_1);
	}

}
