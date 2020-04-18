package com.chedilong.event.view;

import com.chedilong.event.controller.CompetitionController;
import com.chedilong.event.entity.Competition;
import com.chedilong.event.util.TxtJudgeUtil;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class CompetitionAddInternalFrame extends JInternalFrame {
	private JTextField homeFieldTxt;
	private JTextField visitingFieldTxt;
	private JTextField timeTxt;
	private JTextField priceTxt;
	private JTextArea introductionTxt;

	/**
	 * Create the frame.
	 */
	public CompetitionAddInternalFrame() {
		setIconifiable(true);
		setTitle("赛事添加");
		setBounds(100, 100, 547, 514);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8D5B\u4E8B\u8BE6\u60C5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnNewButton = new JButton("退出添加");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCancelPerformed();
			}
		});
		
		JButton btnNewButton_1 = new JButton("确认添加");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				competitionAddPerformed();
			}
		});
		
		JLabel lblNewLabel_5 = new JLabel("注意事项");
		
		JLabel lblNewLabel_6 = new JLabel("1.比赛时间格式为20xx(年)-xx(月)-xx(日)-xx(时):xx(分)");
		
		JLabel lblNewLabel_7 = new JLabel("例：2020-01-01-01:00");
		
		JLabel lblNewLabel_8 = new JLabel("2.价格请精确到分，最低价1元，最高价9999.99元");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(87)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED, 181, Short.MAX_VALUE)
					.addComponent(btnNewButton_1)
					.addGap(77))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_5)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 484, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(25, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(91)
					.addComponent(lblNewLabel_7)
					.addContainerGap(368, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(71)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_8)
						.addComponent(lblNewLabel_6))
					.addContainerGap(56, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addGap(28)
					.addComponent(lblNewLabel_5)
					.addGap(18)
					.addComponent(lblNewLabel_6)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_7)
					.addGap(18)
					.addComponent(lblNewLabel_8)
					.addContainerGap(77, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("主场战队");
		
		homeFieldTxt = new JTextField();
		homeFieldTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("客场战队");
		
		visitingFieldTxt = new JTextField();
		visitingFieldTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("比赛时间");
		
		timeTxt = new JTextField();
		timeTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("价   格");
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("简介");
		
		introductionTxt = new JTextArea();
		
		JLabel lblNewLabel_9 = new JLabel("元");
		GroupLayout groupLayout_1 = new GroupLayout(panel);
		groupLayout_1.setHorizontalGroup(
			groupLayout_1.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout_1.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout_1.createSequentialGroup()
							.addGroup(groupLayout_1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout_1.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addGap(18)
									.addComponent(homeFieldTxt, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout_1.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addGap(18)
									.addComponent(timeTxt)))
							.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
							.addGroup(groupLayout_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_3))
							.addGap(18)
							.addGroup(groupLayout_1.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout_1.createSequentialGroup()
									.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_9))
								.addComponent(visitingFieldTxt, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout_1.createSequentialGroup()
							.addComponent(lblNewLabel_4)
							.addGap(56)
							.addComponent(introductionTxt, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout_1.setVerticalGroup(
			groupLayout_1.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout_1.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(homeFieldTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(visitingFieldTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(18)
					.addGroup(groupLayout_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(timeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_9))
					.addGap(18)
					.addGroup(groupLayout_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(introductionTxt, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		panel.setLayout(groupLayout_1);
		getContentPane().setLayout(groupLayout);

	}

	/**
	 * 确认添加赛事
	 */
	private void competitionAddPerformed() {
		int sign = JOptionPane.showConfirmDialog(null,"是否添加该比赛信息？");
		if(sign == 1||sign == 2){
			return;
		}
		//检查用户输入信息是否符合要求
		Map<String,String> competitionTxt = new HashMap<>();
		competitionTxt.put("homeFieldTxt",homeFieldTxt.getText());
		competitionTxt.put("visitingFieldTxt",visitingFieldTxt.getText());
		competitionTxt.put("timeTxt",timeTxt.getText());
		competitionTxt.put("priceTxt",priceTxt.getText());
		competitionTxt.put("introductionTxt",introductionTxt.getText());
		if(TxtJudgeUtil.competitionTxtJudge(competitionTxt,null)){
			CompetitionController competitionController = new CompetitionController();
			//封装用户输入赛事信息
			Competition competition = new Competition(null,homeFieldTxt.getText(),visitingFieldTxt.getText(),
					introductionTxt.getText(), timeTxt.getText(),new BigDecimal(priceTxt.getText()));
			Boolean result = competitionController.competitionAdd(competition);
			if(result){
				JOptionPane.showMessageDialog(null, "添加成功！");
				//清空信息框
				homeFieldTxt.setText(null);
				visitingFieldTxt.setText(null);
				timeTxt.setText(null);
				priceTxt.setText(null);
				introductionTxt.setText(null);
			}else{
				JOptionPane.showMessageDialog(null, "添加失败！");
			}
		}else{
			return;
		}

	}

	/**
	 * 取消赛事添加
	 */
	private void addCancelPerformed() {
		int sign = JOptionPane.showConfirmDialog(null,"退出赛事添加窗口后信息将不被保存，是否确定退出？");
		if(sign == 0){
			dispose();
		}
	}

}
