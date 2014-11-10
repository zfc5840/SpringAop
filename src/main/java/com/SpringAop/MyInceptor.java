package com.SpringAop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 *com.SpringAop.MyInceptor.java 
 *
 * @author 张富成
 * @history
 * <TABLE id="HistoryTable" border="1">
 * 	<TR><TD>时间</TD><TD>描述</TD><TD>作者</TD></TR>
 *	<TR><TD>2013年10月22日</TD><TD>创建初始版本</TD><TD>张富成</TD></TR>
 * </TABLE>
 */
@Component
@Aspect
public class MyInceptor {
	
   @Pointcut("execution (* com.SpringAop.PersonServiceImpl.*(..))")
   //声明切入点
   private void anyMethod() 
   {
	   System.out.println("我是切入点");
   }
   //声明前置通知
   //加入 参数后，在后面调用此类的方法时，只要符合参数类型、个数相同即有前置通知
   //比如：这个前置通知适合PersonServiceImpl类中的update（String user)和save（String name)方法
   //通过在方法体内定义参数，即对应execution后的第一“*”的参数类型为String
   @Before("anyMethod() && args(name)")
   public void before(String name){
	   System.out.println("我是前置通知,我获取到了参数："+name);
   }
   //声明后置通知,通过设置pointcut、returning可以获取返回结果,这种设置并不局限于后置通知
   @AfterReturning(pointcut="anyMethod()",returning="result")
   public void afterReturning(String result){
	   System.out.println("我是后置通知,我获取到了返回结果："+result);
   }
   //声明最终通知
   @After("anyMethod()")
   public void after(){
	   System.out.println("我是最终通知");
   }
   //声明例外通知，用于在有异常出现时执行，即catch的方法块内
   //在例外通知中，可以通过设置pointcut、throwing获取抛出的例外
   @AfterThrowing(pointcut="anyMethod()",throwing="e")
	public void afterThrowing(Exception e){
	   System.out.println("我是例外通知,我抛出的异常为："+e);
   }
   //声明环绕通知，环绕通知在前置通知前执行
   @Around("anyMethod()")
   public Object around(ProceedingJoinPoint pjp) throws Throwable{
	   System.out.println("我是环绕通知");
	   System.out.println("进入方法前");
	   Object result = pjp.proceed();
	   System.out.println("进入方法后");
	   return result;
   }
   /*
    * 执行的顺序为：
    * 1、切入点（但不知为何切入点内方法不执行，可能就仅仅是个方法供后面通知调用）
    * 环绕通知--进入方法前--前置通知--执行方法--进入方法后--后置通知--最终通知
    * 
    */
}

/**
 * Copyright © 2013,天津天安怡和科技有限公司 All rights reserved.
 */