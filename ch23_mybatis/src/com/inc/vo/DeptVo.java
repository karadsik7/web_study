package com.inc.vo;

import java.util.List;

public class DeptVo {
	
	private int department_id;
	private String department_name;
	private int location_id, manager_id;
	private List<EmpVo> empList;
	private LocVo locVo;
	
	public int getLocation_id() {
		return location_id;
	}
	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}
	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}
	
	public LocVo getLocVo() {
		return locVo;
	}
	public void setLocVo(LocVo locVo) {
		this.locVo = locVo;
	}
	public List<EmpVo> getEmpList() {
		return empList;
	}
	public void setEmpList(List<EmpVo> empList) {
		this.empList = empList;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	
}
