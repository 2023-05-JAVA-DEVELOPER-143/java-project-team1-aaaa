package com.itwill.shop.ui.임범준;
import java.awt.BorderLayout;
import java.awt.Cursor;
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

public class MainCategoryPanel extends JPanel {
		

	/**
	 * Create the panel.
	 */
	private Main2 mainFrame;
		
	public MainCategoryPanel() {
	
		setLayout(new BorderLayout(0, 0));
			
		JPanel categoryPane = new JPanel();
		add(categoryPane, BorderLayout.CENTER);
		categoryPane.setLayout(null);
			
		JLabel bestSellerLabel = new JLabel("");
		bestSellerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bestSellerLabel.addMouseListener(new MouseAdapter() {
			@Override
				public void mouseClicked(MouseEvent e) {
					/***************베스트셀러화면패널보여주세요***********************/
					System.out.println("베스트셀러화면패널보여주세요");
					mainFrame.changePanel(2, 0,-1,null);
					
				}
		});
		bestSellerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bestSellerLabel.setIcon(new ImageIcon("/com/itwill/shop/image/bestSeller1.jpg"));
		bestSellerLabel.setBounds(31, 52, 125, 185);
		categoryPane.add(bestSellerLabel);
			
		JLabel nonFictionLabel = new JLabel("");
		nonFictionLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		nonFictionLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					/***************소설화면패널보여주세요***********************/
					System.out.println("소설화면패널보여주세요");
					mainFrame.changePanel(2, 1,-1,null);
				}
			});
			nonFictionLabel.setIcon(new ImageIcon("/com/itwill/shop/image/bestSeller2.jpg"));
			nonFictionLabel.setHorizontalAlignment(SwingConstants.CENTER);
			nonFictionLabel.setBounds(168, 52, 125, 185);
			categoryPane.add(nonFictionLabel);
			
			JLabel localBookLabel = new JLabel("");
			localBookLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			localBookLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					/***************국내도서화면패널보여주세요***********************/
					System.out.println("국내도서화면패널보여주세요");
					mainFrame.changePanel(2, 2,-1,null);
				}
			});
			localBookLabel.setIcon(new ImageIcon("/com/itwill/shop/image/bestSeller3.jpg"));
			localBookLabel.setHorizontalAlignment(SwingConstants.CENTER);
			localBookLabel.setBounds(305, 52, 125, 185);
			categoryPane.add(localBookLabel);
			
			JButton bestSellerButton = new JButton("베스트셀러");
			
			bestSellerButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					/***************베스트셀러화면패널보여주세요***********************/
					System.out.println("베스트셀러화면패널보여주세요");
					
				}
			});
			bestSellerButton.setBounds(41, 247, 97, 23);
			categoryPane.add(bestSellerButton);
			
			JButton nonFictonButton = new JButton("소설");
			nonFictonButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					/***************소설화면패널보여주세요***********************/
					System.out.println("소설화면패널보여주세요");
				}
			});
			nonFictonButton.setBounds(178, 247, 97, 23);
			categoryPane.add(nonFictonButton);
			
			JButton localBookButton = new JButton("국내도서");
			localBookButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					/***************국내도서화면패널보여주세요***********************/
					System.out.println("국내도서화면패널보여주세요");
				}
			});
			localBookButton.setBounds(315, 247, 97, 23);
			categoryPane.add(localBookButton);
		}
	

		public void setMainFrame(Main2 mainFrame) {
			this.mainFrame=mainFrame;
			
		}
	}

