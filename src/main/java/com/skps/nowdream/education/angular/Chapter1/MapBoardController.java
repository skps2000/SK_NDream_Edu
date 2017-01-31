package com.skps.nowdream.education.angular.Chapter1;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
@RequestMapping("/chapterone")
public class MapBoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(MapBoardController.class);
	
	@Autowired
	private MapBoardService mapService;
	
	@RequestMapping("/map")
	public String map(){
		
		return "/chapterone/map/index.jsp";
	}
	
	@RequestMapping("/getView")
	public String getView(ModelMap modelMap, @RequestParam HashMap<String,Object> parameterMap){
		
		return "/chapterone/mapboard/mapboard.jsp";
	}
	
	@RequestMapping("/getList")
	@ResponseBody
	public String getList(ModelMap modelMap, @RequestParam HashMap<String,Object> parameterMap){
		Gson gson = new Gson();
		String jsonResultList;
		List<HashMap<String,Object>> resultMap = mapService.getList(parameterMap);
		jsonResultList = gson.toJson(resultMap);
		return jsonResultList;
	}
	
	@RequestMapping("/getPlaces")
	@ResponseBody
	public String getPlaces(ModelMap modelMap, @RequestParam HashMap<String,Object> parameterMap){
		Gson gson = new Gson(); 
		List<HashMap<String,Object>> resultMap = mapService.getPlaces(parameterMap);
		String placesResult = gson.toJson(resultMap); 
		return placesResult;
	}
	
	@RequestMapping("/getWriteBoard")
	@ResponseBody
	public int getWriteBoard(@RequestParam HashMap<String,Object> parameterMap){
			parameterMap.put("placesLat", Double.parseDouble(parameterMap.get("placesLat").toString()));
			parameterMap.put("placesLon", Double.parseDouble(parameterMap.get("placesLon").toString()));
			int result = mapService.getWriteBoard(parameterMap);
		return result;
	}
	
	
	public String getInsert(HashMap<String, Object> parameterMap) {
		List<HashMap<String,Object>> resultList = mapService.getList(parameterMap);
		
		return "/chapterone/mapboard/mapboard";
	}

	public String getUpdate(HashMap<String, Object> parameterMap) {
		
		return "/chapterone/mapboard/mapboard";
	}

	public String getDelete(HashMap<String, Object> parameterMap) {
		
		return "/chapterone/mapboard/mapboard";
	}
	
	
	
}
