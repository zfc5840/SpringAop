package com.SpringAop;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *com.SpringAop.AopController.java 
 *
 * @author 张富成
 * @history
 * <TABLE id="HistoryTable" border="1">
 * 	<TR><TD>时间</TD><TD>描述</TD><TD>作者</TD></TR>
 *	<TR><TD>2014-5-21</TD><TD>创建初始版本</TD><TD>张富成</TD></TR>
 * </TABLE>
 */
@Controller
public class AopController {
	 @Resource
	  private PersonServiceImpl personServiceImpl;
	
	 @RequestMapping("/aop.do")
	 public String aop(){
		 System.out.println("面向切面开始");
		 personServiceImpl.save("sss");
		  System.out.println("面向切面结束");
		//  personServiceImpl.getName(99);
		//  personServiceImpl.update("update");
		 return "aop";
	 }
	 

		/*@Test
		public void test(){
		  System.out.println("面向切面开始");
		  personServiceImpl.save("sss");
		  System.out.println("面向切面结束");
		  personServiceImpl.getName(99);
		  personServiceImpl.update("update");
		//  return "aop/query";	
		}*/
	
}

/**
 * Copyright © 2014,天津天安怡和科技有限公司 All rights reserved.
 */