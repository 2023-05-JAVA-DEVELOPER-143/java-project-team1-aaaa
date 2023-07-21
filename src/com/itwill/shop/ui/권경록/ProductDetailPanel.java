package com.itwill.shop.ui.권경록;

import javax.swing.JPanel;

import com.itwill.shop.cart.Cart;
import com.itwill.shop.product.Product;
import com.itwill.shop.test.Main2;
import com.itwill.shop.ui.이동현.ProductBestSellerListPanel;

import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductDetailPanel extends JPanel {
	public Main2 mainFrame;
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
		
		JComboBox cartComboBox = new JComboBox();
		cartComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		cartComboBox.setBounds(88, 438, 60, 35);
		panel.add(cartComboBox);
		
		JButton cartAddButton = new JButton("");
		cartAddButton.setIcon(new ImageIcon(ProductBestSellerListPanel.class.getResource("/com/itwill/shop/image/shopping_cart_icon.png")));
		cartAddButton.setBounds(160, 430, 130, 50);
		panel.add(cartAddButton);
		
		JButton buyButton = new JButton("바로구매");
		buyButton.setBounds(300, 430, 130, 50);
		panel.add(buyButton);
		
		JLabel saleLabel = new JLabel("판매가");
		saleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		saleLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		saleLabel.setBounds(121, 370, 66, 50);
		panel.add(saleLabel);
		
		JLabel priceLabel = new JLabel("priceLabel");
		priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		priceLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		priceLabel.setBounds(199, 370, 231, 50);
		panel.add(priceLabel);

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
		
		JComboBox cartComboBox = new JComboBox();
		cartComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		cartComboBox.setBounds(88, 438, 60, 35);
		panel.add(cartComboBox);
		
		JButton cartAddButton = new JButton("New button");
		cartAddButton.addActionListener(new ActionListener() {
			Product p = product;
			
			public void actionPerformed(ActionEvent e) {
				if (mainFrame.loginMember != null) {
					// 장바구니 상품 추가
				try {
					String cartQtyStr = (String)cartComboBox.getSelectedItem();
					int cartQty = Integer.parseInt(cartQtyStr);
					mainFrame.cartService.addCart(new Cart(0, cartQty, mainFrame.loginMember.getM_Id(), 
										new Product(p.getP_no(), p.getP_name(), p.getP_price(),
													p.getP_image(), p.getP_desc(), p.getP_category())));
					JOptionPane.showMessageDialog(null, "장바구니에 상품이 담겼습니다.");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		});
		cartAddButton.setBounds(160, 430, 130, 50);
		panel.add(cartAddButton);
		
		JButton buyButton = new JButton("바로구매");
		buyButton.setBounds(300, 430, 130, 50);
		panel.add(buyButton);
		
		JLabel saleLabel = new JLabel("판매가");
		saleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		saleLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		saleLabel.setBounds(121, 370, 66, 50);
		panel.add(saleLabel);
		
		JLabel priceLabel = new JLabel(product.getP_price()+"");
		priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		priceLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		priceLabel.setBounds(199, 370, 231, 50);
		panel.add(priceLabel);
	}
	
}
