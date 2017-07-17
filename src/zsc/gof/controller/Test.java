package zsc.gof.controller;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import zsc.gof.entity.Premises;
import zsc.gof.entity.Premisetype;
import zsc.gof.entity.Region;

@Controller
public class Test {

	@RequestMapping("/fileUpload")
	public String fileUpload(@RequestParam("file") MultipartFile[] files,HttpServletRequest request)throws Exception {
		
		/*String buildName=request.getParameter("buildName");
		
		
		Premises premises=new Premises();
		premises.setBuildName(buildName);
		premises.setInOpen(inOpen);
		premises.setInLive(inLive);
		premises.setHouseholds(households);
		premises.setPropertyRight(propertyRight);
		premises.setPropertyCosts(propertyCosts);
		premises.setBuildArea(buildArea);
		premises.setFloorArea(floorArea);
		premises.setBuildAddress(buildAddress);
		Premisetype premisetype=new Premisetype();
		premisetype.setBtypeId(btypeId);
		premises.setPremisetype(premisetype);
		Region region=new Region();
		region.setRegionId(regionId);
		premises.setRegion(region);*/
	//	premises.setIconUrl(iconUrl);
		System.out.println(request.getParameter("iconUrl"));
		if(files.length>0){
			for(int i=0;i<files.length;i++){
				String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/"  
                        + files[i].getOriginalFilename();
				files[i].transferTo(new File(filePath));
				System.out.println(filePath);
			}
		}
		return "index";
	}

	@RequestMapping("/file")
	public String files() { 
		return "file";
	}
}
