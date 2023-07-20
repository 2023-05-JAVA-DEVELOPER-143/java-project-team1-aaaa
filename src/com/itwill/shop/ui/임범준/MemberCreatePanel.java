package com.itwill.shop.ui.임범준;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.itwill.shop.member.Member;
import com.itwill.shop.test.Main2;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MemberCreatePanel extends JPanel {
	private JTextField memberJoinIdTF;
	private JTextField memberJoinPwTF;
	private JTextField memberJoinPwCheckTF;
	private JTextField memberJoinNameTF;
	private JTextField memberJoinPhoneTF;
	private JTextField memberJoinEmailTF;
	private JTextField memberJoinAddressTF;

	public Main2 mainFrame;
	/**
	 * Create the panel.
	 */
	public MemberCreatePanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel memberCreatePanel = new JPanel();
		add(memberCreatePanel, BorderLayout.CENTER);
		memberCreatePanel.setLayout(null);
		
		JLabel memberJoinTitleLB = new JLabel("회원가입");
		memberJoinTitleLB.setHorizontalAlignment(SwingConstants.CENTER);
		memberJoinTitleLB.setFont(new Font("굴림", Font.BOLD, 22));
		memberJoinTitleLB.setBounds(73, 32, 314, 29);
		memberCreatePanel.add(memberJoinTitleLB);
		
		memberJoinIdTF = new JTextField();
		memberJoinIdTF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				memberJoinIdTF.setText("");
			}
		});
		memberJoinIdTF.setText("아이디\r\n");
		memberJoinIdTF.setHorizontalAlignment(SwingConstants.LEFT);
		memberJoinIdTF.setFont(new Font("굴림", Font.PLAIN, 18));
		memberJoinIdTF.setColumns(10);
		memberJoinIdTF.setBounds(93, 91, 287, 25);
		memberCreatePanel.add(memberJoinIdTF);
		
		memberJoinPwTF = new JTextField();
		memberJoinPwTF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				memberJoinPwTF.setText("");
			}
		});
		memberJoinPwTF.setText("비밀번호");
		memberJoinPwTF.setHorizontalAlignment(SwingConstants.LEFT);
		memberJoinPwTF.setFont(new Font("굴림", Font.PLAIN, 18));
		memberJoinPwTF.setColumns(10);
		memberJoinPwTF.setBounds(93, 155, 287, 25);
		memberCreatePanel.add(memberJoinPwTF);
		
		memberJoinPwCheckTF = new JTextField();
		memberJoinPwCheckTF.setText("비밀번호 재확인");
		memberJoinPwCheckTF.setHorizontalAlignment(SwingConstants.LEFT);
		memberJoinPwCheckTF.setFont(new Font("굴림", Font.PLAIN, 18));
		memberJoinPwCheckTF.setColumns(10);
		memberJoinPwCheckTF.setBounds(93, 191, 287, 25);
		memberCreatePanel.add(memberJoinPwCheckTF);
		
		JLabel memberJoinIdMsgLB = new JLabel("");
		memberJoinIdMsgLB.setHorizontalAlignment(SwingConstants.CENTER);
		memberJoinIdMsgLB.setForeground(Color.RED);
		memberJoinIdMsgLB.setBounds(103, 126, 277, 20);
		memberCreatePanel.add(memberJoinIdMsgLB);
		
		memberJoinNameTF = new JTextField();
		memberJoinNameTF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				memberJoinNameTF.setText("");
			}
		});
		memberJoinNameTF.setText("이름");
		memberJoinNameTF.setHorizontalAlignment(SwingConstants.LEFT);
		memberJoinNameTF.setFont(new Font("굴림", Font.PLAIN, 18));
		memberJoinNameTF.setColumns(10);
		memberJoinNameTF.setBounds(93, 247, 287, 25);
		memberCreatePanel.add(memberJoinNameTF);
		
		JLabel memberJoinPwCheckMsgLB = new JLabel("");
		memberJoinPwCheckMsgLB.setForeground(Color.RED);
		memberJoinPwCheckMsgLB.setBounds(103, 223, 277, 20);
		memberCreatePanel.add(memberJoinPwCheckMsgLB);
		
		memberJoinPhoneTF = new JTextField();
		memberJoinPhoneTF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				memberJoinPhoneTF.setText("");
			}
		});
		memberJoinPhoneTF.setText("전화번호");
		memberJoinPhoneTF.setHorizontalAlignment(SwingConstants.LEFT);
		memberJoinPhoneTF.setFont(new Font("굴림", Font.PLAIN, 18));
		memberJoinPhoneTF.setColumns(10);
		memberJoinPhoneTF.setBounds(93, 290, 287, 25);
		memberCreatePanel.add(memberJoinPhoneTF);
		
		memberJoinEmailTF = new JTextField();
		memberJoinEmailTF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				memberJoinEmailTF.setText("");
			}
		});
		memberJoinEmailTF.setText("이메일");
		memberJoinEmailTF.setHorizontalAlignment(SwingConstants.LEFT);
		memberJoinEmailTF.setFont(new Font("굴림", Font.PLAIN, 18));
		memberJoinEmailTF.setColumns(10);
		memberJoinEmailTF.setBounds(93, 336, 287, 25);
		memberCreatePanel.add(memberJoinEmailTF);
		
		memberJoinAddressTF = new JTextField();
		memberJoinAddressTF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				memberJoinAddressTF.setText("");
			}
		});
		memberJoinAddressTF.setText("주소");
		memberJoinAddressTF.setHorizontalAlignment(SwingConstants.LEFT);
		memberJoinAddressTF.setFont(new Font("굴림", Font.PLAIN, 18));
		memberJoinAddressTF.setColumns(10);
		memberJoinAddressTF.setBounds(93, 382, 287, 25);
		memberCreatePanel.add(memberJoinAddressTF);
		
		JButton memberJoinButton = new JButton("가입");
		memberJoinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String memberId = memberJoinIdTF.getText();
					boolean isDuplicate = mainFrame.memberService.isDuplicateId(memberId);
					if(isDuplicate) {
						memberJoinIdTF.setSelectionStart(0);
						memberJoinIdTF.setSelectionEnd(memberId.length());
						memberJoinIdTF.requestFocus();
						memberJoinIdMsgLB.setText("아이디가 존재합니다");
						return;
					}
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
					mainFrame.memberService.create(member);
					mainFrame.MemberTabbedpane.setSelectedIndex(0);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
	
			}
		});
		memberJoinButton.setFont(new Font("굴림", Font.BOLD, 20));
		memberJoinButton.setBounds(135, 427, 193, 50);
		memberCreatePanel.add(memberJoinButton);

	}
	
	public void setMainFrame(Main2 mainFrame) {
		this.mainFrame = mainFrame;
	}
}
