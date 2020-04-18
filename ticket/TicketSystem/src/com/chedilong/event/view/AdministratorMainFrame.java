package com.chedilong.event.view;

import com.chedilong.event.entity.User;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;

public class AdministratorMainFrame extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;

	/**
	 * 管理员主界面
	 */
	public AdministratorMainFrame(User loginUser) {
		setTitle("英雄联盟赛事票务管理系统欢迎您");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("个人信息");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("基本信息管理");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userInFoManagePerformed(loginUser);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("赛事信息");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("赛事添加");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				competitionAddPerformed();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("赛事管理");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				competitionManagePerformed();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 1832, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 1023, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		//设置JFrame最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	/**
	 * 打开赛事管理界面
	 */
	private void competitionManagePerformed() {
		CompetitionManageInternalFrame competitionManageInternalFrame = new CompetitionManageInternalFrame();
		competitionManageInternalFrame.setVisible(true);
		desktopPane.add(competitionManageInternalFrame);
	}

	/**
	 * 打开赛事添加界面
	 */
	private void competitionAddPerformed() {
		CompetitionAddInternalFrame competitionAddInternalFrame = new CompetitionAddInternalFrame();
		competitionAddInternalFrame.setVisible(true);
		desktopPane.add(competitionAddInternalFrame);
	}

	/**
	 * 打开个人信息管理界面
	 */
	private void userInFoManagePerformed(User loginUser) {
		UserInFoManageInternalFrame userInFoManageInternalFrame = new UserInFoManageInternalFrame(loginUser);
		userInFoManageInternalFrame.setVisible(true);
		desktopPane.add(userInFoManageInternalFrame);
	}

}
