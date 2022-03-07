package com.konman.clipper.aspect;

import org.aspectj.lang.annotation.Pointcut;


public class ClipperAopExpression {
	
	@Pointcut("execution(* com.konman.clipper.dao.*.*(..))")
	public void forDaoPackage() {
		
	}
	
	@Pointcut("execution(* com.konman.clipper.service.*.*(..))")
	public void forServicePackage() {
		
	}

}
