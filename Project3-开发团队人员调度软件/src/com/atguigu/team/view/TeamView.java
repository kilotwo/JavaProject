package com.atguigu.team.view;

import javax.print.DocFlavor.CHAR_ARRAY;
import javax.swing.text.View;

import com.atguigu.team.domain.Employee;
import com.atguigu.team.domain.Programmer;
import com.atguigu.team.service.NameListService;
import com.atguigu.team.service.TeamException;
import com.atguigu.team.service.TeamService;

public class TeamView {
	private NameListService listSvc = new NameListService();
	private TeamService teamSvc = new TeamService();
	
	public void enterMainMenu() {
		boolean loop = true;
		char menu =0;
		while(loop) {
			if (menu !='1') {
				listAllEmployees();
			}
			System.out.println("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择（1-4）");
			menu = TSUtility.readMenuSelection();
			switch (menu) {
			case '1':
				getTeam();
				break;
			case '2':
				addMember();
				break;
			case '3':
				deleteMember();
				break;		
			case '4':
				System.out.println("是否要退出（Y/N）");
				char isExit = TSUtility.readConfirmSelection();
				if (isExit == 'Y') {
					loop = false;
				}
				break;	
				
				
			default:
				break;
			}
		}
	}
	/**
	 * 显示所有员工情况
	 */
	private void listAllEmployees() {
		System.out.println("-------------开发调度软件-----------\n");
		Employee[] employees = listSvc.getAllEmployees();
		if (employees == null ||employees.length ==0 ) {
			System.out.println("公司中没有任何员工信息");
		}else {
			System.out.println("ID\t姓名\t 年龄 \t工资 \t职位\t状态\t奖金\t股票\t领用设备");
			for (int i = 0; i < employees.length; i++) {
				System.out.println(employees[i]);
			}
		}
		System.out.println("-----------------------------");
	}
	
	private void getTeam() {
		System.out.println("查看开发团队情况");
		Programmer[] team = teamSvc.getTeam();
		
		if (team == null || team.length == 0) {
			System.out.println("目前没有成员");
		}else {
			System.out.println("ID\t姓名\t年龄\t工资\t职位\t奖金\t股票");
			for (int i = 0; i < team.length; i++) {
				System.out.println(team[i].getDetailForTeam());
			}
		}
		
	}
	private void addMember() {
		System.out.println("添加团队成员");
		System.out.println("请输入要添加的员工ID：");
		int id = TSUtility.readInt();
		
		try {
			Employee employee = listSvc.getEmployee(id);
			teamSvc.addMember(employee);
			System.out.println("添加成功");
			
		} catch (TeamException e) {
			// TODO Auto-generated catch block
			System.out.println("添加失败 原因:"+e.getMessage());
		}
		
		TSUtility.readReturn();
	}
	private void deleteMember() {
		System.out.println("-----------删除团队成员-----------");
		System.out.println("请输入要删除员工的TID");
		int memberId = TSUtility.readInt();
		System.out.println("确认是否删除(y/n)");
		char isDelete = TSUtility.readConfirmSelection();
		if (isDelete =='N') {
			return;
		}
		try {
			teamSvc.removeMember(memberId);
			System.out.println("删除成功");
		} catch (TeamException e) {
			// TODO Auto-generated catch block
			System.out.println("删除失败"+e.getMessage());
		}
		TSUtility.readReturn();
	}
	public static void main (String[] args) {
		TeamView teamView = new TeamView();
		teamView.enterMainMenu();
	}
}
