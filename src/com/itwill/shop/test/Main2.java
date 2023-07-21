package com.itwill.shop.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.itwill.shop.cart.CartService;
import com.itwill.shop.member.Member;
import com.itwill.shop.member.MemberService;
import com.itwill.shop.product.ProductService;
import com.itwill.shop.ui.이동현.ProductBestSellerListPanel;
import com.itwill.shop.ui.이동현.ProductNovelListPanel;
import com.itwill.shop.ui.이동현.ProductSelfImprovementListPanel;
import com.itwill.shop.ui.임범준.MemberLoginPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import com.itwill.shop.ui.임범준.MemberCreatePanel;
import com.itwill.shop.ui.임범준.OrderPanel;
import javax.swing.ImageIcon;
import com.itwill.shop.ui.임범준.OrderPanel1;

public class Main2 extends JFrame {
	/************ 1.Service객체멤버변수선언 ************/
	public ProductService productService;
	public MemberService memberService;
	public CartService cartService;
//	public OrderService orderService;
	
	/*********2.로그인한회원 멤버필드선언*****/
	public Member loginMember=null;
	
	
	private JPanel contentPane;
	private JTextField searchTextField;
	
	
	public JTabbedPane memberTabbedpane;
	public MemberLoginPanel loginPanel;
	
	
	
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
	 * @throws Exception 
	 */
	public Main2() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel northPanel = new JPanel();
		northPanel.setBackground(new Color(255, 255, 255));
		northPanel.setPreferredSize(new Dimension(10, 40));
		contentPane.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(null);
		
		JLabel logoLabel = new JLabel("logo");
		logoLabel.setBounds(0, 0, 100, 40);
		northPanel.add(logoLabel);
		
		JLabel cartLogoLabel = new JLabel("");
		cartLogoLabel.setIcon(new ImageIcon(Main2.class.getResource("/com/itwill/shop/image/cart.png")));
		cartLogoLabel.setBounds(418, 0, 46, 40);
		northPanel.add(cartLogoLabel);
		
		searchTextField = new JTextField();
		searchTextField.setBounds(145, 10, 131, 21);
		northPanel.add(searchTextField);
		searchTextField.setColumns(10);
		
		JLabel searchLabel = new JLabel("New label");
		searchLabel.setBounds(288, 0, 60, 40);
		northPanel.add(searchLabel);
		
		JTabbedPane shopTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		shopTabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		contentPane.add(shopTabbedPane, BorderLayout.CENTER);
		
		JPanel mainPane = new JPanel();
		mainPane.setToolTipText("");
		shopTabbedPane.addTab("메인", null, mainPane, null);
		mainPane.setLayout(null);
		
		memberTabbedpane = new JTabbedPane(JTabbedPane.TOP);
		shopTabbedPane.addTab("회원", null, memberTabbedpane, null);
		
		JPanel mbLoginPanel = new JPanel();
		memberTabbedpane.addTab("로그인", null, mbLoginPanel, null);
		mbLoginPanel.setLayout(new BorderLayout(0, 0));
		
		MemberLoginPanel memberLoginPanel = new MemberLoginPanel();
		mbLoginPanel.add(memberLoginPanel, BorderLayout.CENTER);
		
		JPanel memberJoinPanel = new JPanel();
		memberTabbedpane.addTab("회원가입", null, memberJoinPanel, null);
		memberJoinPanel.setLayout(new BorderLayout(0, 0));
		
		MemberCreatePanel memberCreatePanel = new MemberCreatePanel();
		memberJoinPanel.add(memberCreatePanel, BorderLayout.CENTER);
		
		JPanel memberInfoPanel = new JPanel();
		memberTabbedpane.addTab("회원정보", null, memberInfoPanel, null);
		memberInfoPanel.setLayout(null);
		
		JTabbedPane productTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		shopTabbedPane.addTab("상품", null, productTabbedPane, null);
		
		JPanel productBestSellerPanel = new JPanel();
		productTabbedPane.addTab("베스트셀러", null, productBestSellerPanel, null);
		productBestSellerPanel.setLayout(new BorderLayout(0, 0));
		
		ProductBestSellerListPanel productBestSellerListPanel = new ProductBestSellerListPanel();
		productBestSellerPanel.add(productBestSellerListPanel, BorderLayout.CENTER);
		
		JPanel productNovel = new JPanel();
		productTabbedPane.addTab("소설", null, productNovel, null);
		productNovel.setLayout(new BorderLayout(0, 0));
		
		ProductNovelListPanel productNovelListPanel = new ProductNovelListPanel();
		productNovel.add(productNovelListPanel, BorderLayout.CENTER);
		
		JPanel productSelfImprovement = new JPanel();
		productTabbedPane.addTab("자기계발", null, productSelfImprovement, null);
		productSelfImprovement.setLayout(new BorderLayout(0, 0));
		
		ProductSelfImprovementListPanel productSelfImprovementListPanel = new ProductSelfImprovementListPanel();
		productSelfImprovement.add(productSelfImprovementListPanel, BorderLayout.CENTER);
		
		JPanel productDetail = new JPanel();
		productTabbedPane.addTab("상세페이지", null, productDetail, null);
		
		JTabbedPane cartTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		shopTabbedPane.addTab("장바구니", null, cartTabbedPane, null);
		
		JPanel orderPane = new JPanel();
		shopTabbedPane.addTab("주문", null, orderPane, null);
		orderPane.setLayout(new BorderLayout(0, 0));
		
		OrderPanel1 orderPanel1 = new OrderPanel1();
		orderPane.add(orderPanel1, BorderLayout.CENTER);
		
	
		
		/**********2. Service 객체생성*************/
		memberService=new MemberService();
		productService=new ProductService();
//		orderService = new OrderService();
		cartService = new CartService();
		
	}//생성자
}
	
	
//	/**************로그인성공시 호출할메쏘드***************/
//	void loginProcess(Member loginMember) throws Exception{
//		/***********로그인성공시 해야할일***********
//		 1.로그인성공한 멤버객체 멤버필드에저장
//		 2.MemberMainFrame타이틀변경
//		 3.로그인,회원가입탭 불활성화
//		   회원정보       탭 활성화
//		   로그인,회원가입 메뉴아이템 불활성화
//		   로그아웃 메뉴아이템 활성화
//		   
//		   
//		 4.회원정보보기 화면전환
//		********************************************/
//		this.loginMember=loginMember;
//		setTitle(loginMember.getM_Id()+ " 님 로그인");
//		if(loginMember.getM_Id().equals("admin")) {
//			MemberTabbedpane.setEnabledAt(0,false);
//			MemberTabbedpane.setEnabledAt(1,false );
//			MemberTabbedpane.setEnabledAt(2,true);
//			
////			memberTabbedPane.setEnabledAt(4,true);
//			MemberTabbedpane.setSelectedIndex(2);
//
//		}else {
//			MemberTabbedpane.setEnabledAt(0,false );
//			MemberTabbedpane.setEnabledAt(1,false );
//			MemberTabbedpane.setEnabledAt(2,true);
//			
//			MemberTabbedpane.setSelectedIndex(2);


		
//		}
//	}
