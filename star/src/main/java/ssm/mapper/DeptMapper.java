package cn.tedu.ssm.mapper;

import cn.tedu.ssm.bean.Dept;

import java.util.List;

public interface DeptMapper {
	void insertDept(Dept dept);

	List<Dept> selectAll();

	void delDept(Integer id);

	Dept selectById(Integer id);

	void updateDept(Dept dept);

}
