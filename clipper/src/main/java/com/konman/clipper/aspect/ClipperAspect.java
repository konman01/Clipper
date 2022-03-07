package com.konman.clipper.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.konman.clipper.utility.ClipperUtility;

@Aspect
@Component
public class ClipperAspect {
	
	@Before("com.konman.clipper.aspect.ClipperAopExpression.forDaoPackage()")
	public void performTransactionMonitor(JoinPoint theJointPoint) {
		
		MethodSignature methodSignator = (MethodSignature) theJointPoint.getSignature();
		ClipperUtility.clipperLogger.info("Perform DB Activity using the function:"+methodSignator.toShortString());;
		return;
	}
	
	@Before("com.konman.clipper.aspect.ClipperAopExpression.forServicePackage()")
	public void performServiceMonitor(JoinPoint theJoinPoint) {
		
		MethodSignature methodSignator = (MethodSignature) theJoinPoint.getSignature();
		ClipperUtility.clipperLogger.info("Calling service function:"+methodSignator.toShortString());;
		return;
	}
}
