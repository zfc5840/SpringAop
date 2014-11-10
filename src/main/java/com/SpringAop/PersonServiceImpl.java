package com.SpringAop;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *foo.aop.PersonServiceImpl.java 
 *
 * @author 张富成
 * @history
 * <TABLE id="HistoryTable" border="1">
 * 	<TR><TD>时间</TD><TD>描述</TD><TD>作者</TD></TR>
 *	<TR><TD>2013年10月22日</TD><TD>创建初始版本</TD><TD>张富成</TD></TR>
 * </TABLE>
 */

@Component
public class PersonServiceImpl {

	public void save(String name) {
		System.out.println("已经保存了："+name);
	}


	public void update(String user) {
       System.out.println("我是update方法");		
	}


	public String getName(int id) {
		System.out.println("我是getName()方法");
		int idd = 100;
		return "id="+idd;
	}

}

/**
 * Copyright © 2013,天津天安怡和科技有限公司 All rights reserved.
 */