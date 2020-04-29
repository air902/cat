package com.chedilong.event.view;

import com.chedilong.event.controller.UserController;
import com.chedilong.event.entity.User;
import com.chedilong.event.util.TxtJudgeUtil;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserInFoManageInternalFrame extends JInternalFrame {
	private JTextField nameTxt;
	private JTextField idTxt;
	private JTextField passwordTxt;
	private JTextField statusTxt;

	/**
	 * 用户个人信息管理窗口
	 */
	public UserInFoManageInternalFrame(User loginUser) {
		setClosable(true);
		setIconifiable(true);
		setTitle("个人信息管理");
		setBounds(100, 100, 424, 380);
		
		JLabel lblNewLabel = new JLabel("用户名");
		
		JLabel lblNewLabel_1 = new JLabel("密码");
		
		JLabel lblNewLabel_2 = new JLabel("身份");
		
		nameTxt = new JTextField();
		nameTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("id");
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		passwordTxt = new JTextField();
		passwordTxt.setColumns(10);

		statusTxt = new JTextField();
		statusTxt.setEditable(false);
		statusTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("确认修改");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserInFoUpdatePerformed(loginUser);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(61)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2))
							.addGap(43)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(statusTxt)
								.addComponent(passwordTxt)
								.addComponent(idTxt)
								.addComponent(nameTxt, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(137)
							.addComponent(btnNewButton)))
					.addContainerGap(79, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(67)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(statusTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(48))
		);
		getContentPane().setLayout(groupLayout);
		//初始化用户管理界面信息
		initUserInFo(loginUser);
	}

	/**
	 * 用户修改个人信息事件处理
	 */
	private void UserInFoUpdatePerformed(User loginUser) {
		//封装用户输入信息
		User userTxt = new User(Integer.valueOf(idTxt.getText()),nameTxt.getText(),passwordTxt.getText(),loginUser.getBalance(),statusTxt.getText());
		//检查用户输入信息是否符合规范
		Boolean sign = TxtJudgeUtil.userTxtJudge(userTxt,loginUser);
		if(!sign){
			return;
		}else{
			//获取后台传回数据
			UserController userController = new UserController();
			User result = userController.inFoUpdate(userTxt,loginUser);
			if(result == null){
				JOptionPane.showMessageDialog(null, "修改失败，可能该用户名已被注册！");
			}else{
				//更新用户登录信息
				loginUser.setName(result.getName());
				loginUser.setPassword(result.getPassword());
				JOptionPane.showMessageDialog(null, "修改成功！");
			}
		}
	}

	/**
	 * 初始化管理界面用户信息
	 */
	private void initUserInFo(User loginUser){
		idTxt.setText(String.valueOf(loginUser.getId()));
		nameTxt.setText(loginUser.getName());
		passwordTxt.setText(loginUser.getPassword());
		statusTxt.setText(loginUser.getStatus());
	}

}
