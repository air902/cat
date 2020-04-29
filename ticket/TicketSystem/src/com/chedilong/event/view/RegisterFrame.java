package com.chedilong.event.view;

import com.chedilong.event.controller.UserController;
import com.chedilong.event.entity.User;
import com.chedilong.event.util.TxtJudgeUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;

public class RegisterFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nameTxt;
	private JTextField passwordTxt;
	private JTextField playerTxt;

	/**
	 * 用户注册界面
	 */
	public RegisterFrame() {
		setTitle("用户注册");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("用户名");
		
		nameTxt = new JTextField();
		nameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("密码");
		
		passwordTxt = new JTextField();
		passwordTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("注册");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registerPerformed();
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("注册身份");
		
		playerTxt = new JTextField();
		playerTxt.setText("召唤师玩家");
		playerTxt.setEditable(false);
		playerTxt.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(50)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(playerTxt)
						.addComponent(passwordTxt)
						.addComponent(nameTxt, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))
					.addContainerGap(81, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(187, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(184))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(66)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(playerTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addComponent(btnNewButton)
					.addContainerGap(59, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	private void registerPerformed() {
		//封装用户注册信息
		User userTxt = new User(null,nameTxt.getText(),passwordTxt.getText(), BigDecimal.valueOf(0),"召唤师玩家");
		//判断用户输入信息是否符合规范
		Boolean sign = TxtJudgeUtil.userTxtJudge(userTxt,null);
		if(sign){
			UserController userController = new UserController();
			Boolean result = userController.register(userTxt);
			if(result){
				JOptionPane.showMessageDialog(null, "注册成功！");
				dispose();
			}else{
				JOptionPane.showMessageDialog(null, "注册失败，可能该用户名已经被注册！");
			}
		}else{
			return;
		}
	}

}