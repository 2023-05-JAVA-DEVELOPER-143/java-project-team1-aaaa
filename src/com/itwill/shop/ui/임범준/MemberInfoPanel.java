package com.itwill.shop.ui.임범준;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.itwill.shop.member.Member;
import com.itwill.shop.test.Main2;

public class MemberInfoPanel extends JPanel {
	private JLabel memberInfoIdLB;
	private JTextField memberInfoIdTF;
	private JTextField memberInfoPwTF;
	private JTextField memberInfoNameTF;
	private JTextField memberInfoPhoneTF;
	private JTextField memberInfoPhoneEmailTF;
	private JTextField memberInfoAddressTF;
	
	public Main2 mainFrame;
	
	public Member loginMember =null;

	/**
	 * Create the panel.
	 */
	public MemberInfoPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel memberInfoPanel = new JPanel();
		memberInfoPanel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
//				if(loginMember == null) {
//					System.out.println("멘토날렸어");
//					
//					} else {
//						memberInfoIdTF.setText(mainFrame.loginMember.getM_Id());
//						memberInfoPwTF.setText(mainFrame.loginMember.getM_Pw());
//						memberInfoNameTF.setText(mainFrame.loginMember.getM_Name());
//						memberInfoPhoneTF.setText(mainFrame.loginMember.getM_Phone());
//						memberInfoPhoneEmailTF.setText(mainFrame.loginMember.getM_Email());
//						memberInfoAddressTF.setText(mainFrame.loginMember.getM_Address());
//					}
//				
				
				if(loginMember )
				
				}
				
			
		});
		memberInfoPanel.setBackground(new Color(255, 255, 255));
		add(memberInfoPanel, BorderLayout.CENTER);
		memberInfoPanel.setLayout(null);
		
		JLabel memberInfoTitleLB = new JLabel("회원정보");
		memberInfoTitleLB.setFont(new Font("굴림", Font.BOLD, 20));
		memberInfoTitleLB.setHorizontalAlignment(SwingConstants.CENTER);
		memberInfoTitleLB.setBounds(124, 34, 185, 42);
		memberInfoPanel.add(memberInfoTitleLB);
		
		memberInfoIdLB = new JLabel("아이디");
		memberInfoIdLB.setBounds(71, 118, 73, 28);
		memberInfoPanel.add(memberInfoIdLB);
		
		JLabel memberInfoPwLB = new JLabel("비밀번호");
		memberInfoPwLB.setBounds(71, 166, 73, 28);
		memberInfoPanel.add(memberInfoPwLB);
		
		JLabel memberInfoNameLB = new JLabel("이름");
		memberInfoNameLB.setBounds(71, 222, 73, 28);
		memberInfoPanel.add(memberInfoNameLB);
		
		JLabel memberInfoPhoneLB = new JLabel("전화번호");
		memberInfoPhoneLB.setBounds(71, 279, 73, 28);
		memberInfoPanel.add(memberInfoPhoneLB);
		
		JLabel memberInfoEmailLB = new JLabel("이메일");
		memberInfoEmailLB.setBounds(71, 333, 73, 28);
		memberInfoPanel.add(memberInfoEmailLB);
		
		JLabel memberInfoAddressLB = new JLabel("주소");
		memberInfoAddressLB.setBounds(71, 400, 73, 28);
		memberInfoPanel.add(memberInfoAddressLB);
		
		memberInfoIdTF = new JTextField();
		memberInfoIdTF.setEditable(false);
		memberInfoIdTF.setBounds(160, 120, 160, 28);
		memberInfoPanel.add(memberInfoIdTF);
		memberInfoIdTF.setColumns(10);
		
		memberInfoPwTF = new JTextField();
		memberInfoPwTF.setEditable(false);
		memberInfoPwTF.setColumns(10);
		memberInfoPwTF.setBounds(160, 170, 160, 28);
		memberInfoPanel.add(memberInfoPwTF);
		
		memberInfoNameTF = new JTextField();
		memberInfoNameTF.setEditable(false);
		memberInfoNameTF.setColumns(10);
		memberInfoNameTF.setBounds(160, 221, 160, 28);
		memberInfoPanel.add(memberInfoNameTF);
		
		memberInfoPhoneTF = new JTextField();
		memberInfoPhoneTF.setEditable(false);
		memberInfoPhoneTF.setColumns(10);
		memberInfoPhoneTF.setBounds(160, 280, 160, 28);
		memberInfoPanel.add(memberInfoPhoneTF);
		
		memberInfoPhoneEmailTF = new JTextField();
		memberInfoPhoneEmailTF.setEditable(false);
		memberInfoPhoneEmailTF.setColumns(10);
		memberInfoPhoneEmailTF.setBounds(160, 335, 160, 28);
		memberInfoPanel.add(memberInfoPhoneEmailTF);
		
		memberInfoAddressTF = new JTextField();
		memberInfoAddressTF.setEditable(false);
		memberInfoAddressTF.setColumns(10);
		memberInfoAddressTF.setBounds(160, 400, 160, 28);
		memberInfoPanel.add(memberInfoAddressTF);
		
		JButton updateBtn = new JButton("수정하기");
		updateBtn.setBounds(234, 469, 97, 23);
		memberInfoPanel.add(updateBtn);
		
		JButton updateBtn1 = new JButton("수정");
		updateBtn1.setBounds(109, 469, 97, 23);
		memberInfoPanel.add(updateBtn1);

	}
	
	public void setMainFrame(Main2 mainFrame) {
		this.mainFrame=mainFrame;
	}
	
	
	
}
