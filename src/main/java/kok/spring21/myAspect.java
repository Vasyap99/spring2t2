package kok.spring21;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Aspect;


@Component
@Aspect
public class myAspect {
	@Before("execution(* kok.spring21.dao.PersonDAO.index(..))")  //execution(* kok.spring21.myLogger.log(..))
	public void advice() throws Throwable {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@ ASPECT @@@@@@@@@@@@@@@@@@@@@0 ");
		//pjp.proceed();
		//System.out.println("@@@@@@@@@@@@@@@@@@@@@ ASPECT @@@@@@@@@@@@@@@@@@@@@");
	}
}