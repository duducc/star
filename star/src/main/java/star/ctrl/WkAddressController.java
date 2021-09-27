package star.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;

import star.bean.WkAddress;
import star.service.WkAddressService;

@Controller
public class WkAddressController {
	
	@Resource
	private WkAddressService wkAddressService;
	
	
	@RequestMapping("/show.do")
	public String selectAll(ModelMap map) {
		List<WkAddress> list = wkAddressService.selectAll();
		map.addAttribute("code", 0);
		map.addAttribute("msg", "");
		map.addAttribute("count",5000);
		map.addAttribute("data", list);
		return "list";
	}
	
	@RequestMapping("/addWkAddress.do")
	@ResponseBody
	public void addWkAddress(ModelMap map,HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8;");
		PrintWriter out = response.getWriter();
		try {
			String jsonData = request.getParameter("jsonData");
			System.out.println(jsonData);			
			
		    JSONObject jsonObject = JSONObject.parseObject(jsonData);
			String address = jsonObject.getString("address");
			String desc = jsonObject.getString("desc");
			String type = jsonObject.getString("type");
			String category = jsonObject.getString("category");
			String extractcode = jsonObject.getString("extractcode");
			
			WkAddress wkAddress = new WkAddress();
			wkAddress.setAddress(address);
			wkAddress.setDesc(desc);
			wkAddress.setType(type);
			wkAddress.setCategory(category);
			wkAddress.setExtractcode(extractcode);
			
			int result = wkAddressService.addWkAddress(wkAddress);
			if(result>0) {
				map.addAttribute("errorMsg","success");
			}else {
				map.addAttribute("errorMsg","failed");
			}
			
			map.addAttribute("count",5000);
		}catch (Exception e) {
			map.addAttribute("errorMsg","error");
			e.printStackTrace();
		}
		out.write(new Gson().toJson(map));   
	}
	
	
	@RequestMapping("/all.do")
	@ResponseBody
	public void queryAll(ModelMap map,HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8;");
		PrintWriter out = response.getWriter();
		List<WkAddress> list = wkAddressService.selectAll();
		map.addAttribute("code", 0);
		map.addAttribute("count",5000);
		map.addAttribute("data", list);
		map.addAttribute("msg", "");
	    out.write(new Gson().toJson(map));
	}

}
