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
import com.itwill.shop.order.OrderService;
import com.itwill.shop.product.ProductService;
import com.itwill.shop.ui.임범준.MemberLoginPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class Main2 extends JFrame {
	/************ 1.Service객체멤버변수선언 ************/
	public ProductService productService;
	public MemberService memberService;
	public CartService cartService;
	public OrderService orderService;
	
	/*********2.로그인한회원 멤버필드선언*****/
	public Member loginMember=null;
	

	private JPanel contentPane;
	private JTextField searchTextField;
	
	
	public JTabbedPane MemberTabbedpane;
	
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
		northPanel.setPreferredSize(new Dimension(10, 40));
		contentPane.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(null);
		
		JLabel logoLabel = new JLabel("logo");
		logoLabel.setBounds(0, 0, 78, 40);
		northPanel.add(logoLabel);
		
		JLabel cartLogoLabel = new JLabel("");
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
		shopTabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		contentPane.add(shopTabbedPane, BorderLayout.CENTER);
		
		JTabbedPane mainTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		shopTabbedPane.addTab("메인", null, mainTabbedPane, null);
		
		MemberTabbedpane = new JTabbedPane(JTabbedPane.TOP);
		shopTabbedPane.addTab("회원", null, MemberTabbedpane, null);
		
		JPanel mbLoginPanel = new JPanel();
		MemberTabbedpane.addTab("로그인", null, mbLoginPanel, null);
		mbLoginPanel.setLayout(new BorderLayout(0, 0));
		
		MemberLoginPanel memberLoginPanel = new MemberLoginPanel();
		mbLoginPanel.add(memberLoginPanel, BorderLayout.CENTER);
		
		JPanel memberJoinPanel = new JPanel();
		MemberTabbedpane.addTab("회원가입", null, memberJoinPanel, null);
		memberJoinPanel.setLayout(null);
		
		JPanel memberInfoPanel = new JPanel();
		MemberTabbedpane.addTab("회원정보", null, memberInfoPanel, null);
		memberInfoPanel.setLayout(null);
		
		JTabbedPane productTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		shopTabbedPane.addTab("상품", null, productTabbedPane, null);
		
		JPanel productBestSellerPanel = new JPanel();
		productTabbedPane.addTab("베스트셀러", null, productBestSellerPanel, null);
		
		JPanel productNovel = new JPanel();
		productTabbedPane.addTab("소설", null, productNovel, null);
		
		JPanel productSelfImprovement = new JPanel();
		productTabbedPane.addTab("자기계발", null, productSelfImprovement, null);
		
		JPanel productDetail = new JPanel();
		productTabbedPane.addTab("상세페이지", null, productDetail, null);
		
		JTabbedPane cartTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		shopTabbedPane.addTab("장바구니", null, cartTabbedPane, null);
		
		JPanel orderPanel = new JPanel();
		shopTabbedPane.addTab("주문내역", null, orderPanel, null);
		orderPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane orderContentPanelScrollPane = new JScrollPane();
		orderPanel.add(orderContentPanelScrollPane, BorderLayout.CENTER);
		
		JPanel orderContentPanel = new JPanel();
		orderContentPanel.setPreferredSize(new Dimension(450, 1000));
		orderContentPanelScrollPane.setViewportView(orderContentPanel);
		
		JPanel orderListTitlePanel = new JPanel();
		orderListTitlePanel.setPreferredSize(new Dimension(450, 40));
		orderContentPanel.add(orderListTitlePanel);
		orderListTitlePanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(450, 10));
		orderContentPanel.add(panel);
		panel.setLayout(null);
		
		memberService=new MemberService();
		loginMember = new Member();
		
		
		loginPanel.setMainFrame(this);
	}
	
	
	
	
	
	/**************로그인성공시 호출할메쏘드***************/
	void loginProcess(Member loginMember) throws Exception{
		/***********로그인성공시 해야할일***********
		 1.로그인성공한 멤버객체 멤버필드에저장
		 2.MemberMainFrame타이틀변경
		 3.로그인,회원가입탭 불활성화
		   회원정보       탭 활성화
		   로그인,회원가입 메뉴아이템 불활성화
		   로그아웃 메뉴아이템 활성화
		   
		   
		 4.회원정보보기 화면전환
		********************************************/
		this.loginMember=loginMember;
		setTitle(loginMember.getM_Id()+ " 님 로그인");
		if(loginMember.getM_Id().equals("admin")) {
			MemberTabbedpane.setEnabledAt(0,false);
			MemberTabbedpane.setEnabledAt(1,false );
			MemberTabbedpane.setEnabledAt(2,true);
			
//			memberTabbedPane.setEnabledAt(4,true);
			MemberTabbedpane.setSelectedIndex(2);

		}else {
			MemberTabbedpane.setEnabledAt(0,false );
			MemberTabbedpane.setEnabledAt(1,false );
			MemberTabbedpane.setEnabledAt(2,true);
			
			MemberTabbedpane.setSelectedIndex(2);


		
		}
	}
}
