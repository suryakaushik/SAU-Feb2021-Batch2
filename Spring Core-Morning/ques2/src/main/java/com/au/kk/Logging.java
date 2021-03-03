package com.au.kk;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class Logging {

    //Before advice
	@Before("execution(public void fun())")
	public void adv1() {
		System.out.println("Before 'fun' is called");
	}
   
	//After advice
	@After("execution(public void fun())")
	public void adv2() {
		System.out.println("After 'fun' is called");
	}

	//Around advice
	@Around("execution(public void fun())")
	public void adv3(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("Before and After invoking 'fun' method");
		jp.proceed();
	}

	//AfterThrowing advice
	@AfterThrowing(value = "execution(public void fun())", throwing = "ex")
	public void adv4(JoinPoint jp, Exception ex) {
		System.out.println("After Throwing exception in method:" + jp.getSignature());
		System.out.println("Exception is:" + ex.getMessage());
	}

	//AfterReturning advice
	@AfterReturning("execution(public void fun())")
	public void adv5() {
		System.out.println("After Returning from 'fun'");
	}

	//pointcut with 'within' and 'args ------------------------
	@Pointcut("within(com.au.kk.NewBean)")
	public void allhelper() {

		System.out.println("Within pointcut is applied on method:");
	}

	@Pointcut("(args(String))")
	public void Args() {

		System.out.println("PointCut with args:");
	}
}