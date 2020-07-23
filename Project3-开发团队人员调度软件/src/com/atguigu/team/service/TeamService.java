package com.atguigu.team.service;

import com.atguigu.team.domain.Employee;
import com.atguigu.team.domain.Programmer;

/**
 * 关于开发团队的管理添加和删除
 * @author Z.ero
 *
 */
public class TeamService {
	private static int counter =1;//给memberid赋值
	private final int MAX_MEMBER =5;
	private Programmer[] team = new Programmer[MAX_MEMBER];
	private int total ;//记录开发团队中实际人数
	public TeamService() {
		super();
	}
	/**
	 * 获取开发团队所有成员
	 * @return
	 */
	public Programmer[] getTeam() {
		Programmer[] team = new Programmer[total];
		for (int i = 0; i < team.length; i++) {
			team[i]= this.team[i]; 
		}
		return team;
	}
	/**
	 * 将指定员工添加到团队中
	 * @param e
	 * @throws TeamException 
	 */
	public void addMember(Employee e) throws TeamException {
		//成员已满 无法添加
		if (total>=MAX_MEMBER) {
			throw new TeamException("成员已满");
		}
		//该成员不是开发人员 无法添加
		if(!(e instanceof Programmer)) {
			throw new TeamException("该成员不是开发人员，无法添加");
		}
		//已经在团队中
		if(isExist(e)) {
			throw new TeamException("该团队已经在团队中");
		}
		//该成员已在其他团队中/该成员在休假
		Programmer programmer  = (Programmer)e;
		if(programmer.getStatus().getNAME().equals("BUSY")) {
			throw new TeamException("该员工已是某团队成员");
		}else if("VOCATION".equals(programmer.getStatus().getNAME())) {
			throw new TeamException("正在休假");
		}
		//团队中最多只能有1名结构师
		//团队中最多只能有2名设计师
		//团队中最多只能有3名程序员
		//获取已有的架构师、设计师、程序员人数
		int numOfArch =0,numOfDes =0,numOfPro = 0;
		for (int i = 0; i < total; i++) {
			if (team[i] instanceof Architect ) {
				numOfArch++;
			}else if(team[i] instanceof Designer) {
				numOfDes ++;
			}else if(team[i]instanceof Programmer ) {
				numOfPro++;
			}
		}
		if (programmer  instanceof Architect) {
			if (numOfArch >=1) {
				throw new TeamException("团队中最多只能有一名架构师");
			}
		}else if(programmer instanceof Designer) {
		if (numOfDes >=2) {
			throw new TeamException("团队中最多只能有一名设计师");
			}
		}else if(programmer instanceof Programmer) {
			if (numOfPro>=3) {
				throw new TeamException("最多三名程序员");
			}
		}
		//先后无所谓 因为是赋值的引用对象 只是传递了地址 并没有赋值里面的对象
		team[total] = programmer;
		total++;
		programmer.setStatus(Status.Busy);
		programmer.setMemberId(counter++);
	}
	private boolean isExist(Employee e) {
		for (int i = 0; i < total; i++) {
			if (team[i].getId() == e.getId()) {
				return true;
			}
		}
		return false;
	}
	public void removeMember(int memberId) throws TeamException {
		int i =0;
		for (; i < total; i++) {
			if (team[i].getMemberId() == memberId) {
				team[i].setStatus(Status.Free);
				break;
			}
		}
		//未找到
		if (i == total) {
			throw new TeamException("找不到指定memberId的员工，删除失败");
		}
		for(int j =i;j<total-1;j++) {
			team[j] = team[j+1];
		}
		team[total-1] = null;
		total--;

	}
}
