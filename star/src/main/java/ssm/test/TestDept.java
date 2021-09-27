package ssm.test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.ssm.bean.Dept;
import cn.tedu.ssm.mapper.DeptMapper;
import cn.tedu.ssm.service.DeptService;

public class TestDept {
	@Test
	public void testInsert(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		DeptMapper dm =ac.getBean("deptMapper",DeptMapper.class);
		Dept dept = new Dept();
		dept.setDeptName("拓展部");
		dept.setDeptAddress("甘肃");
		dm.insertDept(dept);
		
	}
	@Test
	public void testAdd(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		DeptService ds = ac.getBean("deptServiceImpl",DeptService.class);
		Dept dept = new Dept();
		dept.setDeptName("市场部");
		dept.setDeptAddress("广州");
		ds.addDept(dept);
	}
	@Test
	public void testShowAll(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		DeptMapper dm =ac.getBean("deptMapper",DeptMapper.class);
		System.out.println(dm.selectAll());
	}
	@Test
	public void testGetAllDept(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		DeptService ds = ac.getBean("deptServiceImpl",DeptService.class);
		System.out.println(ds.getAllDept());
		
	}
	@Test
	public void testSelectById(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		DeptMapper dm =ac.getBean("deptMapper",DeptMapper.class);
		
		System.out.println(dm.selectById(1));
		
	}
	@Test
	public void testGetByid(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		DeptService ds = ac.getBean("deptServiceImpl",DeptService.class);
		System.out.println(ds.getDeptById(1));
	}

}
