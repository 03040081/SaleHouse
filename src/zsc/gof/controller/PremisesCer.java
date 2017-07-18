package zsc.gof.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import zsc.gof.biz.PremiseBiz;
import zsc.gof.entity.Premises;

@Controller
public class PremisesCer {

	@Autowired
	PremiseBiz premiseBiz;
	@Autowired
	HttpServletRequest request;
	@Autowired
	Premises premises;

	public ModelAndView addPremises(@RequestParam("file") MultipartFile[] files,
			@RequestParam("buildName") String buildName, @RequestParam("inOpen") String inOpen,
			@RequestParam("inLive") String inLive, @RequestParam("households") int households,
			@RequestParam("propertyRight") int propertyRight, @RequestParam("propertyCosts") String propertyCosts,
			@RequestParam("buildArea") double buildArea, @RequestParam("floorArea") double floorArea,
			@RequestParam("buildAddress") String buildAddress, @RequestParam("buildType") int buildType,
			@RequestParam("developer") String developer, @RequestParam("regionId") int regionId) {
		try {
			if (files.length > 0) {
				for (int i = 0; i < files.length; i++) {
					String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/"
							+ files[i].getOriginalFilename();
					files[i].transferTo(new File(filePath));
					// System.out.println(filePath);
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
			premises.set
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
