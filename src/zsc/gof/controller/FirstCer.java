package zsc.gof.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import zsc.gof.biz.PremiseBiz;
import zsc.gof.entity.Premises;

@Controller
public class FirstCer {
	
	@Autowired 
	PremiseBiz premiseBiz;
	/*
	 * 从首页输入模糊查询
	 * 跳转至列表找房子
	 */
	@RequestMapping("/Search")
	public ModelAndView search(@RequestParam("condition")String str){
		Map<String,String> map=new HashMap<String, String>();
		map.put("keyword","%"+str+"%");
		
		System.out.println(str);
		List<Premises> list=premiseBiz.find(map);
		/*for(Premises p:list){
			
		}*/
		ModelAndView modelAndView =new ModelAndView("searchlist/Defaultlist");
		modelAndView.addObject("list", list);
		return modelAndView;
	}
	
}
