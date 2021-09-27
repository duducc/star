package cn.tedu.ssm.service;





import java.util.List;

import cn.tedu.ssm.bean.Dept;



public interface DeptService {
	void addDept(Dept dept);
	List<Dept> getAllDept();
	void delDept(Integer id);
	Dept getDeptById(Integer id);
	void uptDept(Dept dept);

}
