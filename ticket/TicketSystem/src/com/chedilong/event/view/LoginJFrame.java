package com.chedilong.event.view;

import com.chedilong.event.controller.UserController;
import com.chedilong.event.entity.User;
import com.chedilong.event.util.TxtJudgeUtil;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTxt;
	private JPasswordField passwordTxt;
	private JRadioButton administratorBut;
	private JRadioButton playerBut;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * 登录界面
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginJFrame frame = new LoginJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 用户登录界面
	 */
	public LoginJFrame() {
		setResizable(false);
		setTitle("欢迎登陆英雄联盟赛事票务管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 392, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("用户名");
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("密码");
		
		JLabel lblNewLabel_2 = new JLabel("身份");
		
		playerBut = new JRadioButton("召唤师玩家");
		playerBut.setSelected(true);
		buttonGroup.add(playerBut);
		
		administratorBut = new JRadioButton("管理员");
		buttonGroup.add(administratorBut);
		
		JButton registerBut = new JButton("注册");
		registerBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userRegisterPerformed();
			}
		});
		
		JButton loginBut = new JButton("登陆");
		loginBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userLoginPerformed();
			}
		});
		
		passwordTxt = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(55)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addContainerGap())
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblNewLabel_1)
								.addContainerGap())
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNewLabel)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(83)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(userNameTxt, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
											.addComponent(playerBut)
											.addComponent(administratorBut)
											.addComponent(loginBut, Alignment.TRAILING)
											.addComponent(passwordTxt, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))))
								.addGap(90)))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(92)
					.addComponent(registerBut)
					.addContainerGap(221, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(54)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(playerBut))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(administratorBut)
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(registerBut)
						.addComponent(loginBut))
					.addContainerGap(43, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);
	}

	private void userLoginPerformed() {
		//获取用户登录信息
		UserController userController = new UserController();
		String userName = userNameTxt.getText();
		String password = new String(passwordTxt.getPassword());
		String status = null;
		if(playerBut.isSelected()){
			status = "召唤师玩家";
		}else if(administratorBut.isSelected()){
			status = "管理员";
		}
		User userTxt = new User(null,userName,password,null,status);
		//检验用户登录信息格式是否正确
		Boolean sign = TxtJudgeUtil.userTxtJudge(userTxt,null);
		if(!sign){
			return;
		}
		//获取后台传回数据
		User loginUser = userController.login(userTxt);
		//根据传回数据打开相应界面
		if(loginUser == null){
			JOptionPane.showMessageDialog(null, "您输入的信息有误，登录失败！");
			return;
		}else if(loginUser.getStatus().equals("召唤师玩家")){
			dispose();
			new PlayerMainFrame(loginUser).setVisible(true);
		}else if(loginUser.getStatus().equals("管理员")){
			dispose();
			new AdministratorMainFrame(loginUser).setVisible(true);

		}
	}

	/**
	 * 打开注册窗口
	 */
	private void userRegisterPerformed() {
		new RegisterFrame().setVisible(true);
	}
}
