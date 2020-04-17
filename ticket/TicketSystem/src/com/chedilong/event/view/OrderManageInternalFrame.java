package com.chedilong.event.view;

import com.chedilong.event.controller.OrderController;
import com.chedilong.event.entity.Competition;
import com.chedilong.event.entity.User;
import com.chedilong.event.util.StringJudgeUtil;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.TitledBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Vector;

public class OrderManageInternalFrame extends JInternalFrame {
	private JTable competitionTable;
	private JTextField competitionIDTxt;
	private JTextField timeTxt;
	private JTextField homeFieldTxt;
	private JTextField visitingFieldTxt;
	private JTextField priceTxt;
	private JTextArea introductionTxt;

	/**
	 * 用户赛事订单管理
	 */
	public OrderManageInternalFrame(User loginUser) {
		setTitle("赛事订单管理");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 598, 598);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8D5B\u4E8B\u8BE6\u60C5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnNewButton = new JButton("退出订单管理");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginOutPerformed();
			}
		});
		
		JButton btnNewButton_1 = new JButton("取消订单");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderDeletePerformed();
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(128)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
					.addComponent(btnNewButton_1)
					.addGap(107))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(43, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("赛事id");

		competitionIDTxt = new JTextField();
		competitionIDTxt.setEditable(false);
		competitionIDTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("比赛时间");
		
		timeTxt = new JTextField();
		timeTxt.setEditable(false);
		timeTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("主场战队");
		
		homeFieldTxt = new JTextField();
		homeFieldTxt.setEditable(false);
		homeFieldTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("客场战队");
		
		visitingFieldTxt = new JTextField();
		visitingFieldTxt.setEditable(false);
		visitingFieldTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("价格");
		
		priceTxt = new JTextField();
		priceTxt.setEditable(false);
		priceTxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("简介");
		
		introductionTxt = new JTextArea();
		introductionTxt.setEditable(false);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_5))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(competitionIDTxt, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
								.addComponent(homeFieldTxt)
								.addComponent(priceTxt))
							.addGap(39)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addGap(18)
									.addComponent(timeTxt, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addGap(18)
									.addComponent(visitingFieldTxt, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))))
						.addComponent(introductionTxt, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1)
						.addComponent(timeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(competitionIDTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_3)
						.addComponent(visitingFieldTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(homeFieldTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(introductionTxt, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		competitionTable = new JTable();
		competitionTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				competitionSelectPressed();
			}
		});
		competitionTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8D5B\u4E8Bid", "\u4E3B\u573A\u6218\u961F", "\u5BA2\u573A\u6218\u961F", "\u7B80\u4ECB", "\u65F6\u95F4", "\u4EF7\u683C"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(competitionTable);
		getContentPane().setLayout(groupLayout);
		//初始化用户预约的赛事订单
		initCompetitionTable(loginUser);

	}

	/**
	 * 用户取消赛事订单
	 */
	private void orderDeletePerformed() {
		//判断用户是否选择比赛
		if(StringJudgeUtil.isEmpty(competitionIDTxt.getText())){
			JOptionPane.showMessageDialog(null, "请选择你要取消预约的比赛！");
			return;
		}
		int sign = JOptionPane.showConfirmDialog(null,"确认取消预定该赛事吗？");
		if(sign == 1||sign == 2){
			return;
		}
		
	}

	/**
	 * 退出赛事管理系统
	 */
	private void loginOutPerformed() {
		int sign = JOptionPane.showConfirmDialog(null,"确认退出赛事管理吗？");
		if(sign == 0){
			dispose();;
		}
		
	}

	/**
	 * 将用户选择的赛事订单添加到详情框中
	 */
	private void competitionSelectPressed() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 初始化用户预约的比赛信息
	 */
	private void initCompetitionTable(User loginUser){
		OrderController orderController = new OrderController();
		List<Competition> competitionList = orderController.orderSearch(loginUser.getId());
		if(competitionList == null){
			JOptionPane.showMessageDialog(null, "您目前暂未预约任何比赛！");
		}else{
			DefaultTableModel dtm = (DefaultTableModel) competitionTable.getModel();
			dtm.setRowCount(0);
			//将返回结果添加到表格中
			for (int i = 0; i < competitionList.size(); i++) {
				Vector v = new Vector();
				v.add(competitionList.get(i).getId());
				v.add(competitionList.get(i).getHomeField());
				v.add(competitionList.get(i).getVisitingField());
				v.add(competitionList.get(i).getIntroduction());
				v.add(competitionList.get(i).getTime());
				v.add(competitionList.get(i).getPrice());
				dtm.addRow(v);
			}
		}
	}

}
