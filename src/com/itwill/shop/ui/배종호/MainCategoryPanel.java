package com.itwill.shop.ui.배종호;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.itwill.shop.test.Main2;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JScrollPane;

public class MainCategoryPanel extends JPanel {
	
	private Main2 mainFrame;
	
	
	
		public MainCategoryPanel() {
		 setPreferredSize(new Dimension(460, 500));  //크기설정
	        setLayout(new BorderLayout(0, 0));
	        
	       
		JPanel categoryPane = new JPanel();
		add(categoryPane, BorderLayout.CENTER);
		categoryPane.setLayout(null);
		
			
		JLabel bestSellerLabel = new JLabel("");
		bestSellerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bestSellerLabel.addMouseListener(new MouseAdapter() {
			@Override
				public void mouseClicked(MouseEvent e) {
					
					mainFrame.changePanel(2, 0,-1,null);
					
				}
			
		});
		bestSellerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bestSellerLabel.setIcon(null);
		bestSellerLabel.setBounds(10, 32, 423, 182);
		categoryPane.add(bestSellerLabel);
			
		JLabel nonFictionLabel = new JLabel("");
		nonFictionLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		nonFictionLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					
					mainFrame.changePanel(2, 1,-1,null);
				}
			});
			nonFictionLabel.setIcon(null);
			nonFictionLabel.setHorizontalAlignment(SwingConstants.CENTER);
			nonFictionLabel.setBounds(12, 302, 421, 160);
			categoryPane.add(nonFictionLabel);
			
			JLabel localBookLabel = new JLabel("");
			localBookLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			localBookLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					mainFrame.changePanel(2, 2,-1,null);
				}
			});
			localBookLabel.setIcon(null);
			localBookLabel.setHorizontalAlignment(SwingConstants.CENTER);
			localBookLabel.setBounds(0, 511, 415, 120);
			categoryPane.add(localBookLabel);
			categoryPane.add(localBookLabel);
			
			JLabel backGroud = new JLabel(""); 
			backGroud.setIcon(new ImageIcon(MainCategoryPanel.class.getResource("/com/itwill/shop/image/mainbook.jpg"))); 
			backGroud.setHorizontalAlignment(SwingConstants.CENTER);
			backGroud.setBounds(10, 41, 460, 500);
			categoryPane.add(backGroud);
			
			JScrollPane scrollPane = new JScrollPane(backGroud);
			scrollPane.setBounds(0, 0, 460, 500);
			categoryPane.add(scrollPane);
		
		}
		
		
	

		public void setMainFrame(Main2 mainFrame) {
			this.mainFrame=mainFrame;
			
		}
	}

