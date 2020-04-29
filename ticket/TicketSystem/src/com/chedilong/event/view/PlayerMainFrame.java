package com.chedilong.event.view;

import com.chedilong.event.entity.User;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlayerMainFrame extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;

	/**
	 * 召唤师玩家主界面
	 */
	public PlayerMainFrame(User loginUser) {
		setTitle("英雄联盟赛事票务管理系统欢迎您");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("个人信息管理");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("账户基本信息");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserInFoManage(loginUser);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("钱包管理");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserWalletManage(loginUser);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("赛事查看");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("赛事大厅");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GamesHall(loginUser);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("我的赛事");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserBookedCompetition(loginUser);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 1833, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 1013, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		//设置JFrame最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	/**
	 * 打开管理用户已经预定的赛事窗口
	 */
	private void UserBookedCompetition(User loginUser) {
		OrderManageInternalFrame orderManageInternalFrame = new OrderManageInternalFrame(loginUser);
		orderManageInternalFrame.setVisible(true);
		desktopPane.add(orderManageInternalFrame);
	}

	/**
	 * 打开赛事大厅窗口，用户可以在这里预定赛事
	 */
	private void GamesHall(User loginUser) {
		GamesHallInternalFrame gamesHallInternalFrame = new GamesHallInternalFrame(loginUser);
		gamesHallInternalFrame.setVisible(true);
		desktopPane.add(gamesHallInternalFrame);
	}

	/**
	 * 打开用户钱包管理
	 */
	private void UserWalletManage(User loginUser) {
		UserWalletInternalFrame userWalletInternalFrame = new UserWalletInternalFrame(loginUser);
		userWalletInternalFrame.setVisible(true);
		desktopPane.add(userWalletInternalFrame);
	}

	/**
	 * 打开用户个人信息管理窗口
	 */
	private void UserInFoManage(User loginUser) {
		UserInFoManageInternalFrame userInFoManageInternalFrame = new UserInFoManageInternalFrame(loginUser);
		userInFoManageInternalFrame.setVisible(true);
		desktopPane.add(userInFoManageInternalFrame);
		
	}
}
