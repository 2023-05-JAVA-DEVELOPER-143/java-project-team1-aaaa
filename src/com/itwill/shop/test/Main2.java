package com.itwill.shop.test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class Main2 extends JFrame {

	private JPanel contentPane;
	private JTextField searchTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main2 frame = new Main2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel northPanel = new JPanel();
		northPanel.setPreferredSize(new Dimension(10, 40));
		contentPane.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(null);
		
		JLabel logoLabel = new JLabel("logo");
		logoLabel.setBounds(0, 0, 78, 40);
		northPanel.add(logoLabel);
		
		JLabel cartLogoLabel = new JLabel("");
		cartLogoLabel.setIcon(new ImageIcon("C:\\2023-05-JAVA-DEVELOPER\\repositories\\java-project-team1-aaaa\\src\\com\\itwill\\shop\\image\\216477_shopping_cart_icon (2).png"));
		cartLogoLabel.setBounds(418, 0, 30, 40);
		northPanel.add(cartLogoLabel);
		
		searchTextField = new JTextField();
		searchTextField.setBounds(145, 10, 131, 21);
		northPanel.add(searchTextField);
		searchTextField.setColumns(10);
		
		JLabel searchLabel = new JLabel("New label");
		searchLabel.setBounds(288, 13, 57, 15);
		northPanel.add(searchLabel);
		
		JTabbedPane shopTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(shopTabbedPane, BorderLayout.CENTER);
		
		JTabbedPane mainTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		shopTabbedPane.addTab("메인", null, mainTabbedPane, null);
		
		JTabbedPane MemberTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		shopTabbedPane.addTab("회원", null, MemberTabbedPane, null);
		
		JTabbedPane loginTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		MemberTabbedPane.addTab("로그인", null, loginTabbedPane, null);
		
		JTabbedPane insertTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		MemberTabbedPane.addTab("회원가입", null, insertTabbedPane, null);
		
		JTabbedPane infoTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		MemberTabbedPane.addTab("회원정보", null, infoTabbedPane, null);
		
		JTabbedPane productTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		shopTabbedPane.addTab("상품", null, productTabbedPane, null);
		
		JPanel productBestSellerPanel = new JPanel();
		productTabbedPane.addTab("베스트셀러", null, productBestSellerPanel, null);
		
		JPanel productNovel = new JPanel();
		productTabbedPane.addTab("소설", null, productNovel, null);
		
		JPanel productSelfImprovement = new JPanel();
		productTabbedPane.addTab("자기계발", null, productSelfImprovement, null);
		
		JTabbedPane cartTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		shopTabbedPane.addTab("장바구니", null, cartTabbedPane, null);
		
		JTabbedPane orderInfoPane = new JTabbedPane(JTabbedPane.TOP);
		shopTabbedPane.addTab("주문내역", null, orderInfoPane, null);
	}

}
