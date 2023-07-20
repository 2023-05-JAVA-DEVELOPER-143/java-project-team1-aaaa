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

public class Main2 extends JFrame {
	/************ 1.Service객체멤버변수선언 ************/
	private ProductService productService;
	private MemberService memberService;
	private CartService cartService;
	private OrderService orderService;
	
	/*********2.로그인한회원 멤버필드선언*****/
	private Member loginMember=null;
	

	private JPanel contentPane;
	private JTabbedPane memberTabbedpane;
	private JTextField searchTextField;
	private JTextField memberLoginIdTF;
	private JTextField memberLoginPwTF;
	private JTextField memberJoinIdTF;
	private JTextField memberJoinPwTF;
	private JTextField memberJoinNameTF;
	private JTextField memberJoinPhoneTF;
	private JTextField memberJoinEmailTF;
	private JTextField memberJoinAddressTF;
	private JTextField memberJoinPwCheckTF;
	private JLabel memberJoinIdMsgLB;
	private JLabel memberJoinPwCheckMsgLB;
	private JLabel memberLoginIdMsgLB;
	private JLabel memberLoginPwMsgLB;
	private JTabbedPane MemberTabbedpane;

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
		
		JPanel memberLoginPanel = new JPanel();
		MemberTabbedpane.addTab("로그인", null, memberLoginPanel, null);
		memberLoginPanel.setLayout(null);
		
		memberLoginIdTF = new JTextField();
		memberLoginIdTF.setFont(new Font("굴림", Font.PLAIN, 18));
		memberLoginIdTF.setText("아이디");
		memberLoginIdTF.setBounds(92, 191, 245, 35);
		memberLoginPanel.add(memberLoginIdTF);
		memberLoginIdTF.setColumns(10);
		
		memberLoginPwTF = new JTextField();
		memberLoginPwTF.setFont(new Font("굴림", Font.PLAIN, 18));
		memberLoginPwTF.setText("비밀번호");
		memberLoginPwTF.setColumns(10);
		memberLoginPwTF.setBounds(92, 272, 245, 35);
		memberLoginPanel.add(memberLoginPwTF);
		
		JLabel loginTitleLabel = new JLabel("로그인");
		loginTitleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		loginTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginTitleLabel.setBounds(135, 81, 202, 54);
		memberLoginPanel.add(loginTitleLabel);
		
		JButton loginButton = new JButton("로그인");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/***********입력 유효성체크********/
				String userid = memberLoginIdTF.getText();
				String password = memberLoginPwTF.getText();
				if (userid.equals("")) {
					memberLoginIdMsgLB.setText("아이디를 입력하세요.");
					memberLoginIdMsgLB.requestFocus();
					return;
				}
				if (password.equals("")) {
					memberLoginPwMsgLB.setText("패쓰워드를 입력하세요.");
					memberLoginPwMsgLB.requestFocus();
					return;
				}
				/************memberService 객체 생성***********/
				try {
					int result = memberService.login(userid, password);
					if (result == 1) {
						
						Member loginUser = memberService.findUser(userid);
						loginProcess(loginUser);

					} else if (result == 0) {
						memberLoginIdMsgLB.setText("아이디또는비밀번호가 일치하지않습니다.");
						memberLoginIdTF.requestFocus();
						memberLoginIdTF.setSelectionStart(0);
						memberLoginIdTF.setSelectionEnd(userid.length());
					
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		loginButton.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		loginButton.setBounds(349, 191, 105, 116);
		memberLoginPanel.add(loginButton);
		
		JButton memberInsertButton = new JButton("회원가입");
		memberInsertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberTabbedpane.setSelectedIndex(1);
			}
		});
		memberInsertButton.setForeground(new Color(0, 0, 0));
		memberInsertButton.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		memberInsertButton.setBounds(92, 361, 362, 54);
		memberLoginPanel.add(memberInsertButton);
		
		JLabel memberLoginIdMsgLB = new JLabel("");
		memberLoginIdMsgLB.setForeground(new Color(255, 0, 0));
		memberLoginIdMsgLB.setBounds(102, 236, 235, 26);
		memberLoginPanel.add(memberLoginIdMsgLB);
		
		JLabel memberLoginPwMsgLB = new JLabel("");
		memberLoginPwMsgLB.setForeground(new Color(255, 0, 0));
		memberLoginPwMsgLB.setBounds(102, 317, 235, 26);
		memberLoginPanel.add(memberLoginPwMsgLB);
		
		JPanel memberJoinPanel = new JPanel();
		MemberTabbedpane.addTab("회원가입", null, memberJoinPanel, null);
		memberJoinPanel.setLayout(null);
		
		JLabel memberJoinTitleLB = new JLabel("회원가입");
		memberJoinTitleLB.setHorizontalAlignment(SwingConstants.CENTER);
		memberJoinTitleLB.setFont(new Font("굴림", Font.BOLD, 22));
		memberJoinTitleLB.setBounds(72, 20, 314, 29);
		memberJoinPanel.add(memberJoinTitleLB);
		
		memberJoinIdTF = new JTextField();
		
		memberJoinIdTF.setFont(new Font("굴림", Font.PLAIN, 18));
		memberJoinIdTF.setHorizontalAlignment(SwingConstants.LEFT);
		memberJoinIdTF.setBounds(99, 59, 287, 25);
		memberJoinPanel.add(memberJoinIdTF);
		memberJoinIdTF.setColumns(10);
		
		memberJoinPwTF = new JTextField();
		memberJoinPwTF.setHorizontalAlignment(SwingConstants.LEFT);
		memberJoinPwTF.setFont(new Font("굴림", Font.PLAIN, 18));
		memberJoinPwTF.setColumns(10);
		memberJoinPwTF.setBounds(99, 117, 287, 25);
		memberJoinPanel.add(memberJoinPwTF);
		
		memberJoinNameTF = new JTextField();
		memberJoinNameTF.setHorizontalAlignment(SwingConstants.LEFT);
		memberJoinNameTF.setFont(new Font("굴림", Font.PLAIN, 18));
		memberJoinNameTF.setColumns(10);
		memberJoinNameTF.setBounds(100, 214, 287, 25);
		memberJoinPanel.add(memberJoinNameTF);
		
		memberJoinPhoneTF = new JTextField();
		memberJoinPhoneTF.setHorizontalAlignment(SwingConstants.LEFT);
		memberJoinPhoneTF.setFont(new Font("굴림", Font.PLAIN, 18));
		memberJoinPhoneTF.setColumns(10);
		memberJoinPhoneTF.setBounds(100, 265, 287, 25);
		memberJoinPanel.add(memberJoinPhoneTF);
		
		memberJoinEmailTF = new JTextField();
		memberJoinEmailTF.setHorizontalAlignment(SwingConstants.LEFT);
		memberJoinEmailTF.setFont(new Font("굴림", Font.PLAIN, 18));
		memberJoinEmailTF.setColumns(10);
		memberJoinEmailTF.setBounds(99, 312, 287, 25);
		memberJoinPanel.add(memberJoinEmailTF);
		
		memberJoinAddressTF = new JTextField();
		memberJoinAddressTF.setHorizontalAlignment(SwingConstants.LEFT);
		memberJoinAddressTF.setFont(new Font("굴림", Font.PLAIN, 18));
		memberJoinAddressTF.setColumns(10);
		memberJoinAddressTF.setBounds(99, 368, 287, 25);
		memberJoinPanel.add(memberJoinAddressTF);
		
		memberJoinPwCheckTF = new JTextField();
		memberJoinPwCheckTF.setHorizontalAlignment(SwingConstants.LEFT);
		memberJoinPwCheckTF.setFont(new Font("굴림", Font.PLAIN, 18));
		memberJoinPwCheckTF.setColumns(10);
		memberJoinPwCheckTF.setBounds(99, 156, 287, 25);
		memberJoinPanel.add(memberJoinPwCheckTF);
		
		JButton memberJoinButton = new JButton("가입");
		memberJoinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String memberId = memberJoinIdTF.getText();
//					boolean isDuplicate = memberService.isDuplicateId(memberId);
//					if(isDuplicate) {
//						memberJoinIdTF.setSelectionStart(0);
//						memberJoinIdTF.setSelectionEnd(memberId.length());
//						memberJoinIdTF.requestFocus();
//						memberJoinIdMsgLB.setText("아이디가 존재합니다");
//						return;
//					}
					String password = memberJoinPwTF.getText();
//					if(memberJoinPwTF.getText() != memberJoinPwCheckTF.getText()) {
//						memberJoinPwCheckTF.setSelectionStart(0);
//						memberJoinPwCheckTF.setSelectionEnd(password.length());
//						memberJoinPwCheckTF.requestFocus();
//						memberJoinPwCheckMsgLB.setText("비밀번호가 맞지않습니다");
//						return;
//					}
					String name = memberJoinNameTF.getText();
					String phone = memberJoinPhoneTF.getText();
					String email = memberJoinEmailTF.getText();
					String address = memberJoinAddressTF.getText();
					Member member = new Member(memberId, password, name, phone, email, address);
					memberService.create(member);
					shopTabbedPane.setSelectedIndex(0);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		memberJoinButton.setFont(new Font("굴림", Font.BOLD, 20));
		memberJoinButton.setBounds(153, 420, 193, 50);
		memberJoinPanel.add(memberJoinButton);
		
		JLabel memberJoinIdMsgLB = new JLabel("");
		memberJoinIdMsgLB.setForeground(new Color(255, 0, 0));
		memberJoinIdMsgLB.setBounds(109, 90, 277, 20);
		memberJoinPanel.add(memberJoinIdMsgLB);
		
		JLabel memberJoinPwCheckMsgLB = new JLabel("");
		memberJoinPwCheckMsgLB.setForeground(Color.RED);
		memberJoinPwCheckMsgLB.setBounds(109, 184, 277, 20);
		memberJoinPanel.add(memberJoinPwCheckMsgLB);
		
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
		
		JTabbedPane cartTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		shopTabbedPane.addTab("장바구니", null, cartTabbedPane, null);
		
		JTabbedPane orderInfoPane = new JTabbedPane(JTabbedPane.TOP);
		shopTabbedPane.addTab("주문내역", null, orderInfoPane, null);
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
			memberTabbedpane.setEnabledAt(1,false);
			memberTabbedpane.setEnabledAt(2,false );
			memberTabbedpane.setEnabledAt(3,true);
			
//			memberTabbedPane.setEnabledAt(4,true);
//			memberTabbedPane.setSelectedIndex(3);
			
			
//			loginMenuItem.setEnabled(false);
//			joinMenuItem.setEnabled(false);
//			logoutMenuItem.setEnabled(true);
//		}else {
//			memberTabbedPane.setEnabledAt(1,false );
//			memberTabbedPane.setEnabledAt(2,false );
//			memberTabbedPane.setEnabledAt(3,true);
//			
//			memberTabbedPane.setSelectedIndex(3);
//			
//			loginMenuItem.setEnabled(false);
//			joinMenuItem.setEnabled(false);
//			logoutMenuItem.setEnabled(true);
//		}
		
		}
	}
}
