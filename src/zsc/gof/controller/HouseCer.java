package zsc.gof.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import zsc.gof.biz.HouseBiz;
import zsc.gof.biz.HouseimgBiz;
import zsc.gof.biz.PremiseBiz;
import zsc.gof.entity.House;
import zsc.gof.entity.HouseImg;
import zsc.gof.entity.Housetype;
import zsc.gof.entity.Premises;

@Controller
public class HouseCer {
	@Autowired
	PremiseBiz premiseBiz;
	@Autowired
	HouseBiz houseBiz;
	@Autowired
	HouseimgBiz houseimgBiz;
	
	
	/*
	 * 定位查询  ->buildId
	 * 显示楼盘信息
	 * 显示房子信息
	 */
	@RequestMapping("/index3")
	public ModelAndView premisAndHouse(@RequestParam("buildId")int buildId){
		Premises premises=premiseBiz.findOne(buildId);
		List<House> listHouses=houseBiz.listHouse(buildId);
		ModelAndView modelAndView=new ModelAndView("index3");
		modelAndView.addObject("premises",premises);
		modelAndView.addObject("listHouses", listHouses);
		return modelAndView;
	}
	
	/*
	 * 后台
	 * 添加房子
	 */
	/*@RequestMapping("/addHouse")
	public ModelAndView addHouse(@RequestParam("file") MultipartFile[] files,
			@RequestParam("houseDesc")String houseDesc,@RequestParam("houseType")int houseTypeId,
			@RequestParam("houseArea")double houseArea,@RequestParam("housePrice")double housePrice,
			@RequestParam("buildId")int buildId,HttpServletRequest request){
		House house=new House();
		house.setHouseArea(houseArea);
		house.setHouseDesc(houseDesc);
		house.setHousePrice(housePrice);
		Housetype housetype=new Housetype();
		housetype.setHtypeId(houseTypeId);
		house.setHousetype(housetype);
	}*/
	/*
	 * 后台
	 * 修改房子信息
	 */
	@RequestMapping("/updateHouse")
	public ModelAndView updateHouse(@RequestParam("file") MultipartFile[] files,@RequestParam("houseId")int houseId,
		@RequestParam("houseDesc")String houseDesc,@RequestParam("houseType")int houseTypeId,
		@RequestParam("houseArea")double houseArea,@RequestParam("housePrice")double housePrice,
		@RequestParam("buildId")int buildId,HttpServletRequest request)throws IOException{
		
		House house=new House();
		house.setHouseArea(houseArea);
		house.setHouseDesc(houseDesc);
		house.setHouseId(houseId);
		house.setHousePrice(housePrice);
		Housetype housetype=new Housetype();
		housetype.setHtypeId(houseTypeId);
		house.setHousetype(housetype);
		List<HouseImg> listimg=new ArrayList<HouseImg>();
		
		String[] filePaths = null;
		if(files.length>0){
			for(int i=0;i<files.length;i++){
				filePaths[i] = request.getSession().getServletContext().getRealPath("/") + "upload/"  
                        + files[i].getOriginalFilename();
				files[i].transferTo(new File(filePaths[i]));
				//System.out.println(filePaths[i]);
				//创建房子图片对象，添加图片
				HouseImg houseImg=new HouseImg();
				houseImg.setHouseId(houseId);
				houseImg.setImgUrl(filePaths[i]);
				listimg.add(houseImg);
			}
		}
		houseimgBiz.updateHouseImgs(listimg);
		//house.setHouseimg(listimg);
		houseBiz.updateHouse(house);
		return new ModelAndView("返回当前楼盘下页面");
	}
}
