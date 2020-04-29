package com.chedilong.event.view;

import com.chedilong.event.controller.UserController;
import com.chedilong.event.entity.User;
import com.chedilong.event.util.StringJudgeUtil;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;

public class UserWalletInternalFrame extends JInternalFrame {
	private JTextField balanceTxt;
	private JTextField moneyTxt;

	/**
	 * 用户账户充值界面
	 */
	public UserWalletInternalFrame(User loginUser) {
		setIconifiable(true);
		setClosable(true);
		setTitle("个人钱包");
		setBounds(100, 100, 450, 377);
		
		JLabel lblNewLabel = new JLabel("账户余额");
		
		balanceTxt = new JTextField();
		balanceTxt.setEditable(false);
		balanceTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("充值金额");
		
		moneyTxt = new JTextField();
		moneyTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("确认充值");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rechargePerformed(loginUser);
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("注意：");
		
		JLabel lblNewLabel_3 = new JLabel("1.每次充值不能少于1元，不超过9999.99元");
		
		JLabel lblNewLabel_4 = new JLabel("2.充值金额精确到分");
		
		JLabel lblNewLabel_5 = new JLabel("元");
		
		JLabel lblNewLabel_6 = new JLabel("元");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(49)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addGap(18)
									.addComponent(balanceTxt))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addGap(18)
									.addComponent(moneyTxt, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_6)
								.addComponent(lblNewLabel_5)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(165)
							.addComponent(btnNewButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_2))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(70)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_3))))
					.addContainerGap(74, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(48)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(balanceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5))
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(moneyTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_6))
					.addGap(53)
					.addComponent(btnNewButton)
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addGap(38))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addContainerGap(41, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		//初始化钱包余额
		initWallet(loginUser);

	}

	/**
	 * 用户余额充值事件处理
	 */
	private void rechargePerformed(User loginUser) {
		UserController userController = new UserController();
		//获取用户输入充值金额，判断金额是否符合要求
		String money = moneyTxt.getText();
		Boolean sign = StringJudgeUtil.isMoney(money);
		if(sign){
			User result = userController.userRecharge(loginUser,new BigDecimal(money));
			//充值成功更新loginUser的balance，同时清空充值栏
			if(result != null){
				JOptionPane.showMessageDialog(null, "充值成功！");
				loginUser.setBalance(result.getBalance());
				balanceTxt.setText(loginUser.getBalance().toString());
				moneyTxt.setText(null);
			}else{
				JOptionPane.showMessageDialog(null, "充值失败！");
			}
		}else{
			JOptionPane.showMessageDialog(null, "请输入正确的金额，每次充值不少于1元，不超过9999.99元！");
			return;
		}
//		Boolean result = userController.userRecharge(loginUser,money);
	}

	/**
	 * 初始化钱包余额
	 * @param loginUser
	 */
	private void initWallet(User loginUser){
		balanceTxt.setText(loginUser.getBalance().toString());
	}
}
