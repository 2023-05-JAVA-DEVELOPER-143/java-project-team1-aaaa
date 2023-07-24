package com.itwill.shop.ui.배종호;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.Rectangle;
import javax.swing.border.LineBorder;

import com.itwill.shop.ui.Main2;

public class MainCategoryPanel extends JPanel {
	
	private Main2 mainFrame;
	
	JScrollPane scrollPane = new JScrollPane();
		public MainCategoryPanel() throws Exception{
			setPreferredSize(new Dimension(500, 572));
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(2, 480));
		//scrollPane.setPreferredSize(new Dimension(460, 500));
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(0, 0, 470, 572);
		add(scrollPane);
		
		JPanel backgroundPanel = new JPanel();
		backgroundPanel.setBackground(Color.WHITE);
		
		
		
		backgroundPanel.setPreferredSize(new Dimension(10, 800));
		scrollPane.setViewportView(backgroundPanel);
		backgroundPanel.setLayout(null);
		
		JPanel bestPanel = new JPanel();
		bestPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bestPanel.setBackground(Color.WHITE);
		bestPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainFrame.changePanel(2,0, -1, null);
			}
		});
		bestPanel.setBounds(0, 0, 469, 196);
		backgroundPanel.add(bestPanel);
		bestPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel.setIcon(new ImageIcon(MainCategoryPanel.class.getResource("/com/itwill/shop/image/bestSeller1.jpg")));
		lblNewLabel.setBounds(25, 10, 118, 176);
		bestPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setIcon(new ImageIcon(MainCategoryPanel.class.getResource("/com/itwill/shop/image/bestSeller2.jpg")));
		lblNewLabel_1.setBounds(168, 10, 118, 176);
		bestPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2.setIcon(new ImageIcon(MainCategoryPanel.class.getResource("/com/itwill/shop/image/bestSeller3.jpg")));
		lblNewLabel_2.setBounds(311, 10, 118, 176);
		bestPanel.add(lblNewLabel_2);
		
		JPanel novelPanel = new JPanel();
		novelPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		novelPanel.setBackground(Color.WHITE);
		novelPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainFrame.changePanel(2,1, -1, null);
			}
		});
		novelPanel.setBounds(0, 249, 469, 196);
		backgroundPanel.add(novelPanel);
		novelPanel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3.setIcon(new ImageIcon(MainCategoryPanel.class.getResource("/com/itwill/shop/image/novel1.jpg")));
		lblNewLabel_3.setBounds(25, 10, 118, 176);
		novelPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_1.setIcon(new ImageIcon(MainCategoryPanel.class.getResource("/com/itwill/shop/image/novel2.jpg")));
		lblNewLabel_1_1.setBounds(169, 10, 118, 176);
		novelPanel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_1.setIcon(new ImageIcon(MainCategoryPanel.class.getResource("/com/itwill/shop/image/novel3.jpg")));
		lblNewLabel_2_1.setBounds(316, 10, 118, 176);
		novelPanel.add(lblNewLabel_2_1);
		
		JPanel localPanel = new JPanel();
		localPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainFrame.changePanel(2,2, -1, null);
			}
		});
		localPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		localPanel.setBackground(Color.WHITE);
		localPanel.setBounds(0, 498, 469, 196);
		backgroundPanel.add(localPanel);
		localPanel.setLayout(null);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_1.setIcon(new ImageIcon(MainCategoryPanel.class.getResource("/com/itwill/shop/image/selfImprovement1.jpg")));
		lblNewLabel_3_1.setBounds(25, 10, 118, 176);
		localPanel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_1_1.setIcon(new ImageIcon(MainCategoryPanel.class.getResource("/com/itwill/shop/image/selfImprovement2.jpg")));
		lblNewLabel_1_1_1.setBounds(168, 10, 118, 176);
		localPanel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("");
		lblNewLabel_2_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_1_1.setIcon(new ImageIcon(MainCategoryPanel.class.getResource("/com/itwill/shop/image/selfImprovement3.jpg")));
		lblNewLabel_2_1_1.setBounds(322, 10, 118, 176);
		localPanel.add(lblNewLabel_2_1_1);
		
		
		
		
	}
		public void setMainFrame(Main2 main2) {
			this.mainFrame=main2;
			
		}
}



