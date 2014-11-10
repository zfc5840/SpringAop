package com.SpringAop;


import javax.annotation.Resource;

import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *foo.aop.SpringAopDemo.java 
 *
 * @author 张富成
 * @history
 * <TABLE id="HistoryTable" border="1">
 * 	<TR><TD>时间</TD><TD>描述</TD><TD>作者</TD></TR>
 *	<TR><TD>2013年10月22日</TD><TD>创建初始版本</TD><TD>张富成</TD></TR>
 * </TABLE>
 */
public class SpringAopDemo {
	
    /*@Resource
    private static PersonServiceImpl personService;*/
     
	public static void main(String[] args) {
		ApplicationContext ctx=new 	ClassPathXmlApplicationContext("applicationContext.xml");
		PersonServiceImpl personServiceImpl=(PersonServiceImpl)ctx.getBean("personServiceImpl");
		personServiceImpl.save("xxx");
	}

}

/**
 * Copyright © 2013,天津天安怡和科技有限公司 All rights reserved.
 */