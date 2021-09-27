package cn.tedu.ssm.service;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;

import cn.tedu.ssm.bean.Dept;
import cn.tedu.ssm.mapper.DeptMapper;

@Service
public class DeptServiceImpl implements DeptService {
	@Resource
    private DeptMapper deptMapper;
	public void addDept(Dept dept) {
		deptMapper.insertDept(dept);
		
		
		
	}
	public List<Dept> getAllDept() {
		
		return deptMapper.selectAll();
	}
	public void delDept(Integer id) {
		deptMapper.delDept(id);
		
	}
	public Dept getDeptById(Integer id) {
		
		return deptMapper.selectById(id);
	}
	
		
	
	public void uptDept(Dept dept) {
		deptMapper.updateDept(dept);
		
	}
	

}
