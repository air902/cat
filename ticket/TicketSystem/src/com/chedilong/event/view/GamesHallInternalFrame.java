package com.chedilong.event.view;

import com.chedilong.event.controller.CompetitionController;
import com.chedilong.event.controller.OrderController;
import com.chedilong.event.entity.Competition;
import com.chedilong.event.entity.User;
import com.chedilong.event.util.StringJudgeUtil;

import java.awt.*;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.border.TitledBorder;
import javax.swing.LayoutStyle.ComponentPlacement;

public class GamesHallInternalFrame extends JInternalFrame {
	private JTextField teamTxt;
	private JTable competitionTable;
	private JTextField competitionIDTxt;
	private JTextField timeTxt;
	private JTextField homeFieldTxt;
	private JTextField visitingFieldTxt;
	private JTextArea introductionTxt;
	private JTextField priceTxt;

	/**
	 * 赛事大厅窗口
	 */
	public GamesHallInternalFrame(User loginUser) {
		setIconifiable(true);
		setClosable(true);
		setTitle("赛事大厅");
		setBounds(100, 100, 599, 698);
		
		JLabel lblNewLabel = new JLabel("战队名称");
		
		teamTxt = new JTextField();
		teamTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				competitionSearchPerformed();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8D5B\u4E8B\u8BE6\u60C5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnNewButton_1 = new JButton("预定赛事");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reserveCompetitionPerformed(loginUser);
			}
		});
		
		JButton btnNewButton_2 = new JButton("退出大厅");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logoutHallPerformed();
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(140)
					.addComponent(btnNewButton_2)
					.addPreferredGap(ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
					.addComponent(btnNewButton_1)
					.addGap(119))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(88)
							.addComponent(lblNewLabel)
							.addGap(18)
							.addComponent(teamTxt, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
							.addGap(53)
							.addComponent(btnNewButton))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(teamTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_1))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("赛事id");
		
		competitionIDTxt = new JTextField();
		competitionIDTxt.setEditable(false);
		competitionIDTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("比赛时间");
		
		timeTxt = new JTextField();
		timeTxt.setEditable(false);
		timeTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("主场战队");
		
		homeFieldTxt = new JTextField();
		homeFieldTxt.setEditable(false);
		homeFieldTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("客场战队");
		
		visitingFieldTxt = new JTextField();
		visitingFieldTxt.setEditable(false);
		visitingFieldTxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("简介");
		
		introductionTxt = new JTextArea();
		introductionTxt.setEditable(false);
		
		JLabel lblNewLabel_6 = new JLabel("价格");
		
		priceTxt = new JTextField();
		priceTxt.setEditable(false);
		priceTxt.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addGap(27)
									.addComponent(competitionIDTxt, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(priceTxt, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
										.addComponent(homeFieldTxt))))
							.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addGap(18)
									.addComponent(timeTxt, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_4)
									.addGap(18)
									.addComponent(visitingFieldTxt)))
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_5)
							.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
							.addComponent(introductionTxt, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE)
							.addGap(22))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_6)
							.addContainerGap(457, Short.MAX_VALUE))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(competitionIDTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(timeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(homeFieldTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(visitingFieldTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(introductionTxt, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5))
					.addContainerGap())
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
				"\u8D5B\u4E8Bid", "\u4E3B\u573A\u6218\u961F", "\u5BA2\u573A\u6218\u961F", "\u7B80\u4ECB", "\u6BD4\u8D5B\u65F6\u95F4", "\u4EF7\u683C(\u5143)"
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

	}

	/**
	 *用户预订比赛
	 */
	private void reserveCompetitionPerformed(User loginUser) {
		//判断用户是否选择比赛
		if(StringJudgeUtil.isEmpty(competitionIDTxt.getText())){
			JOptionPane.showMessageDialog(null, "请选择你要预定的比赛！");
			return;
		}
		int sign = JOptionPane.showConfirmDialog(null,"确认预定该赛事吗？");
		if(sign == 1||sign == 2){
			return;
		}
		OrderController orderController = new OrderController();
		//封装赛事信息
		Competition competitionSelected = new Competition(Integer.parseInt(competitionIDTxt.getText()),homeFieldTxt.getText(),
				                          visitingFieldTxt.getText(),introductionTxt.getText(),timeTxt.getText(),
				                          new BigDecimal(priceTxt.getText()));
		User result = orderController.orderAdd(loginUser,competitionSelected);
		if(result == null){
			JOptionPane.showMessageDialog(null, "预定失败，请检查您的余额是否充足或您是否已经预定该赛事！");
		}else{
			loginUser.setBalance(result.getBalance());
			JOptionPane.showMessageDialog(null, "预定成功！");
		}
	}

	/**
	 * 退出赛事大厅
	 */
	private void logoutHallPerformed() {
		int sign = JOptionPane.showConfirmDialog(null,"确认退出赛事大厅吗？");
		if(sign == 0){
			dispose();;
		}
	}

	/**
	 * 将用户选中的表格行添加到信息框中
	 */
	private void competitionSelectPressed() {
		//获取选中的行
		int row = competitionTable.getSelectedRow();
		//将行信息添加到赛事详情框中
		competitionIDTxt.setText(String.valueOf(competitionTable.getValueAt(row,0)));
		timeTxt.setText((String)competitionTable.getValueAt(row,1));
		homeFieldTxt.setText((String)competitionTable.getValueAt(row,2));
		visitingFieldTxt.setText((String)competitionTable.getValueAt(row,3));
		introductionTxt.setText((String)competitionTable.getValueAt(row,4));
		priceTxt.setText(String.valueOf(competitionTable.getValueAt(row,5)));
	}

	/**
	 * 搜索比赛信息
	 */
	private void competitionSearchPerformed() {
		CompetitionController competitionController = new CompetitionController();
		List<Competition> competitionList = competitionController.competitionSearch(teamTxt.getText());
		DefaultTableModel dtm = (DefaultTableModel) competitionTable.getModel();
		if(competitionList.size() == 0){
			//将表格设置为0行
			dtm.setRowCount(0);
			JOptionPane.showMessageDialog(null, "未找到相关赛事信息！");
			return;
		}else {
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
