package com.chedilong.event.view;

import com.chedilong.event.controller.CompetitionController;
import com.chedilong.event.entity.Competition;
import com.chedilong.event.util.StringJudgeUtil;
import com.chedilong.event.util.TxtJudgeUtil;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class CompetitionManageInternalFrame extends JInternalFrame {
	private JTextField nameSearchTxt;
	private JTable competitionTable;
	private JTextField competitionIdTxt;
	private JTextField timeTxt;
	private JTextField homeFieldTxt;
	private JTextField visitingFieldTxt;
	private JTextField priceTxt;
	private JTextArea introductionTxt;
	private Competition competitionSelect;

	/**
	 * 赛事管理窗口
	 */
	public CompetitionManageInternalFrame() {
		setIconifiable(true);
		setClosable(true);
		setTitle("赛事管理");
		setBounds(100, 100, 654, 796);
		
		JLabel lblNewLabel = new JLabel("战队名称");
		
		nameSearchTxt = new JTextField();
		nameSearchTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				competitionSearchPerformed();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8D5B\u4E8B\u8BE6\u60C5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnNewButton_1 = new JButton("删除该赛事");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				competitionDeletePerformed();
			}
		});
		
		JButton btnNewButton_2 = new JButton("确认修改");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				competitionUpdatePerformed();
			}
		});
		
		JLabel lblNewLabel_8 = new JLabel("注意事项：");
		
		JLabel lblNewLabel_9 = new JLabel("1.比赛时间格式为20xx(年)-xx(月)-xx(日)-xx(时):xx(分)");
		
		JLabel lblNewLabel_10 = new JLabel("例：2020-01-01-01:00");
		
		JLabel lblNewLabel_11 = new JLabel("2.价格请精确到分，最低价1元，最高价9999.99元");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(135)
							.addComponent(lblNewLabel)
							.addGap(31)
							.addComponent(nameSearchTxt, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
							.addGap(63)
							.addComponent(btnNewButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)))
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(126)
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
					.addComponent(btnNewButton_2)
					.addGap(119))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(40)
					.addComponent(lblNewLabel_8)
					.addContainerGap(526, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(99)
					.addComponent(lblNewLabel_9)
					.addContainerGap(467, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(119)
					.addComponent(lblNewLabel_10)
					.addContainerGap(447, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(100)
					.addComponent(lblNewLabel_11)
					.addContainerGap(466, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(nameSearchTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addGap(18)
					.addComponent(lblNewLabel_8)
					.addGap(13)
					.addComponent(lblNewLabel_9)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_10)
					.addGap(11)
					.addComponent(lblNewLabel_11)
					.addContainerGap(14, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("赛事id");
		
		competitionIdTxt = new JTextField();
		competitionIdTxt.setEditable(false);
		competitionIdTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("时   间");
		
		timeTxt = new JTextField();
		timeTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("主场战队");
		
		homeFieldTxt = new JTextField();
		homeFieldTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("客场战队");
		
		visitingFieldTxt = new JTextField();
		visitingFieldTxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("价   格");
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("元");
		
		JLabel lblNewLabel_7 = new JLabel("简   介");
		
		introductionTxt = new JTextArea();
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
									.addGap(26)
									.addComponent(competitionIdTxt, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblNewLabel_6))
										.addComponent(homeFieldTxt))))
							.addGap(36)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_4))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(visitingFieldTxt)
								.addComponent(timeTxt, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)))
						.addComponent(lblNewLabel_5)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_7)
							.addGap(18)
							.addComponent(introductionTxt)))
					.addContainerGap(45, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(competitionIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(timeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(homeFieldTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(visitingFieldTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_6))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_7)
						.addComponent(introductionTxt, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(67, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		competitionTable = new JTable();
		competitionTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				competitionSelectPress();
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

	}

	/**
	 * 将用户选择的赛事添加到详情栏
	 */
	private void competitionSelectPress() {
		//获取选中的行
		int row = competitionTable.getSelectedRow();
		//将行信息添加到赛事详情框中
		competitionIdTxt.setText(String.valueOf(competitionTable.getValueAt(row,0)));
		homeFieldTxt.setText((String)competitionTable.getValueAt(row,1));
		visitingFieldTxt.setText((String)competitionTable.getValueAt(row,2));
		introductionTxt.setText((String)competitionTable.getValueAt(row,3));
		timeTxt.setText((String)competitionTable.getValueAt(row,4));
		priceTxt.setText(String.valueOf(competitionTable.getValueAt(row,5)));
		//初始化competitionSelect
		competitionSelect = new Competition(Integer.valueOf(competitionIdTxt.getText()),homeFieldTxt.getText(),
				                           visitingFieldTxt.getText(),introductionTxt.getText(),timeTxt.getText(),
				                           new BigDecimal(priceTxt.getText()));
	}

	/**
	 * 确认更新赛事信息
	 */
	private void competitionUpdatePerformed() {
		//判断用户是否选择赛事
		if(StringJudgeUtil.isEmpty(competitionIdTxt.getText())){
			JOptionPane.showMessageDialog(null, "请选择你要修改的赛事！");
			return;
		}
		int sign = JOptionPane.showConfirmDialog(null,"是否修改该比赛信息？");
		if(sign == 1||sign == 2){
			return;
		}
		//检查用户输入信息是否符合要求
		Map<String,String> competitionMap = new HashMap<>();
		competitionMap.put("homeFieldTxt",homeFieldTxt.getText());
		competitionMap.put("visitingFieldTxt",visitingFieldTxt.getText());
		competitionMap.put("timeTxt",timeTxt.getText());
		competitionMap.put("priceTxt",priceTxt.getText());
		competitionMap.put("introductionTxt",introductionTxt.getText());
		if(TxtJudgeUtil.competitionTxtJudge(competitionMap,competitionSelect)) {
			CompetitionController competitionController = new CompetitionController();
			//封装用户输入赛事信息
			Competition competitionTxt = new Competition(Integer.parseInt(competitionIdTxt.getText()), homeFieldTxt.getText(),
					                     visitingFieldTxt.getText(), introductionTxt.getText(), timeTxt.getText(),
					                     new BigDecimal(priceTxt.getText()));
			//更新赛事信息
			Competition result = competitionController.competitionUpdate(competitionTxt);
			if(result == null) {
				JOptionPane.showMessageDialog(null, "修改失败！");
			}else {
				JOptionPane.showMessageDialog(null, "修改成功！");
				//更新competitionSelect
				competitionSelect.setHomeField(homeFieldTxt.getText());
				competitionSelect.setVisitingField(visitingFieldTxt.getText());
				competitionSelect.setTime(timeTxt.getText());
				competitionSelect.setPrice(new BigDecimal(priceTxt.getText()));
				competitionSelect.setIntroduction(introductionTxt.getText());
				//刷新赛事表格
				competitionSearchPerformed();
			}
		}
	}

	/**
	 * 删除赛事信息
	 */
	private void competitionDeletePerformed() {
		//判断用户是否选择赛事
		if(StringJudgeUtil.isEmpty(competitionIdTxt.getText())){
			JOptionPane.showMessageDialog(null, "请选择你要删除的赛事！");
			return;
		}
		int sign = JOptionPane.showConfirmDialog(null,"是否删除该比赛信息？");
		if(sign == 1||sign == 2){
			return;
		}
		CompetitionController competitionController = new CompetitionController();
		Boolean result = competitionController.competitionDelete(Integer.parseInt(competitionIdTxt.getText()));
		if(result){
			JOptionPane.showMessageDialog(null, "删除成功！");
			//清空表格和competitionSelect
			competitionIdTxt.setText(null);
			homeFieldTxt.setText(null);
			visitingFieldTxt.setText(null);
			introductionTxt.setText(null);
			timeTxt.setText(null);
			priceTxt.setText(null);
			competitionSelect = null;
		}
	}

	/**
	 * 赛事搜索
	 */
	private void competitionSearchPerformed() {
		CompetitionController competitionController = new CompetitionController();
		List<Competition> competitionList = competitionController.competitionSearch(nameSearchTxt.getText());
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
