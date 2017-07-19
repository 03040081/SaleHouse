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

import zsc.gof.biz.PremiseBiz;
import zsc.gof.biz.PremiseimgBiz;
import zsc.gof.entity.Premises;
import zsc.gof.entity.Premisesimg;
import zsc.gof.entity.Premisetype;
import zsc.gof.entity.Region;

@Controller
public class PremisesCer {

	@Autowired
	PremiseBiz premiseBiz;
/*	@Autowired
	HttpServletRequest request;*/
/*	@Autowired
	Premises premises;
	@Autowired
	Premisetype premisetype;
	@Autowired
	Region region;*/
	@Autowired
	PremiseimgBiz premiseimgBiz;
	
	
	@RequestMapping("/addPremises")
	public ModelAndView addPremises(@RequestParam("file") MultipartFile[] files,
			@RequestParam("buildName") String buildName, @RequestParam("inOpen") String inOpen,
			@RequestParam("inLive") String inLive, @RequestParam("households") int households,
			@RequestParam("propertyRight") String propertyRight, @RequestParam("propertyCosts") String propertyCosts,
			@RequestParam("buildArea") String buildArea, @RequestParam("floorArea") String floorArea,
			@RequestParam("buildAddress") String buildAddress, @RequestParam("buildType") int buildType,
			@RequestParam("developer") String developer, @RequestParam("regionId") int regionId,HttpServletRequest request)throws Exception {
		ModelAndView modelAndView = null;
		try {
			Premises premises=new Premises();
			Premisetype premisetype=new Premisetype();
			Region region=new Region();
			String[] filePaths = null;
			if(files.length>0){
				for(int i=0;i<files.length;i++){
					filePaths[i] = request.getSession().getServletContext().getRealPath("/") + "upload/"  
	                        + files[i].getOriginalFilename();
					files[i].transferTo(new File(filePaths[i]));
					System.out.println(filePaths[i]);
				}
			}
			premises.setBuildName(buildName);
			premises.setInOpen(inOpen);
			premises.setInLive(inLive);
			premises.setHouseholds(households);
			premises.setPropertyRight(propertyRight);
			premises.setPropertyCosts(propertyCosts);
			premises.setBuildArea(buildArea);
			premises.setFloorArea(floorArea);
			premises.setBuildAddress(buildAddress);
			premisetype.setBtypeId(buildType);//楼盘类型
			premises.setPremisetype(premisetype);
			premises.setDeveloper(developer);
			region.setRegionId(regionId);//楼盘区域
			premises.setRegion(region);
			premises.setIconUrl(filePaths[0]);
			List<Premisesimg> list=new ArrayList<Premisesimg>();
			int buildId=premiseBiz.addPremise(premises);//添加楼盘后返回 楼盘 ID
			for(int i=1;i<filePaths.length;i++){
				Premisesimg p=new Premisesimg();
				p.setBuildId(buildId);
				p.setImgUrl(filePaths[i]);
				list.add(p);
			}
			premises.setPremisesimg(list);
			premiseimgBiz.addPremisimg(list);
			modelAndView=new ModelAndView("index3");//显示楼盘的界面
			modelAndView.addObject(premises);
			System.out.println(premises.getBuildName());
				
			return modelAndView;
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return new ModelAndView("添加楼盘界面");
	}
	
	@RequestMapping("/updatePremise")
	public ModelAndView updatePremise(@RequestParam("file") MultipartFile[] files,
			@RequestParam("buildId") int buildId,
			@RequestParam("buildName") String buildName, @RequestParam("inOpen") String inOpen,
			@RequestParam("inLive") String inLive, @RequestParam("households") int households,
			@RequestParam("propertyRight") String propertyRight, @RequestParam("propertyCosts") String propertyCosts,
			@RequestParam("buildArea") String buildArea, @RequestParam("floorArea") String floorArea,
			@RequestParam("buildAddress") String buildAddress, @RequestParam("buildType") int buildType,
			@RequestParam("developer") String developer, @RequestParam("regionId") int regionId,HttpServletRequest request)throws Exception {
		ModelAndView modelAndView = null;
		try {
			Premises premises=new Premises();
			Premisetype premisetype=new Premisetype();
			Region region=new Region();
			String[] filePaths = null;
			if(files.length>0){
				for(int i=0;i<files.length;i++){
					filePaths[i] = request.getSession().getServletContext().getRealPath("/") + "upload/"  
	                        + files[i].getOriginalFilename();
					files[i].transferTo(new File(filePaths[i]));
					System.out.println(filePaths[i]);
				}
			}
			premises.setBuildId(buildId);///////////
			premises.setBuildName(buildName);
			premises.setInOpen(inOpen);
			premises.setInLive(inLive);
			premises.setHouseholds(households);
			premises.setPropertyRight(propertyRight);
			premises.setPropertyCosts(propertyCosts);
			premises.setBuildArea(buildArea);
			premises.setFloorArea(floorArea);
			premises.setBuildAddress(buildAddress);
			premisetype.setBtypeId(buildType);//楼盘类型
			premises.setPremisetype(premisetype);
			premises.setDeveloper(developer);
			region.setRegionId(regionId);//楼盘区域
			premises.setRegion(region);
			premises.setIconUrl(filePaths[0]);
			List<Premisesimg> list=new ArrayList<Premisesimg>();
			//int buildId=premiseBiz.addPremise(premises);//添加楼盘后返回 楼盘 ID
			premiseBiz.updatePremises(premises);
			for(int i=1;i<filePaths.length;i++){
				Premisesimg p=new Premisesimg();
				p.setBuildId(buildId);
				p.setImgUrl(filePaths[i]);
				list.add(p);
			}
			premises.setPremisesimg(list);
			//premiseimgBiz.addPremisimg(list);
			premiseimgBiz.updatePremisimg(list);
			modelAndView=new ModelAndView("index3");//显示楼盘的界面
			modelAndView.addObject(premises);
			System.out.println(premises.getBuildName());
				
			return modelAndView;
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return modelAndView;
	}
	@RequestMapping("/deletePremise")
	public ModelAndView deletePremise(@RequestParam("buildId")int buildId){
		premiseimgBiz.deletePremisimg(buildId);
		premiseBiz.deletePremises(buildId);
		return new ModelAndView("楼盘显示  列表");
	}
}
