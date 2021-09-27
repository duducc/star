package cn.tedu.ssm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.ssm.bean.Dept;
import cn.tedu.ssm.service.DeptService;

@Controller
@RequestMapping("/dept")
public class DeptController {
	@Resource
	private DeptService deptService;
	@RequestMapping("/showAdd.do")
	public String showAdd(){
		return "add";
	}
	
	@RequestMapping("/add.do")
	public String add(String name,String address){
		Dept dept = new Dept();
		dept.setDeptName(name);
		dept.setDeptAddress(address);
		deptService.addDept(dept);
		return "index";
	}
	@RequestMapping("getAllDept.do")
	public String getAllDept(ModelMap map){
		List<Dept> list = deptService.getAllDept();
		map.addAttribute("list",list);
		return "showDept";
		
	}
	@RequestMapping("deleteDept.do")
	public String  deleteDept(Integer id){
		deptService.delDept(id);
		return "redirect:getAllDept.do";
		
	}
	@RequestMapping("/showUpdate.do")
	public String showUpdata(Integer id,ModelMap map){
		Dept dept = deptService.getDeptById(id);
		map.addAttribute("dept",dept);
		return "update";
	}
   @RequestMapping("/update.do")
   public String update(Integer id,String name,String address){
	   Dept dept = new Dept();
	   dept.setId(id);
	   dept.setDeptName(name);
	   dept.setDeptAddress(address);
	   deptService.uptDept(dept);
	   return "redirect:getAllDept.do";
   }
}
