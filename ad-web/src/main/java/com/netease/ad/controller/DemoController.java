package com.netease.ad.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.netease.ad.model.Demo;


@Controller
public class DemoController {

	@Autowired
	private com.netease.ad.dao.Demo demoDao;	
	
	@RequestMapping(value = "/demo")
	@ResponseBody
	public Object demo(HttpServletRequest req){
		Map<String, String> map = new HashMap<String, String>();
		map.put("json1", "json1");
		map.put("json2", "json2");
		
		//分页测试
		 PageHelper.startPage(2,2);
         List<Demo> list = demoDao.queryDemosAll();
         PageInfo<Demo> page = new PageInfo(list);
         System.out.println(page.getTotal());
		return page;
	}

}
