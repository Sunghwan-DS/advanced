package jsh.aop.order.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

    // jsh.aop.order 패키지와 하위 패키지
    @Pointcut("execution(* jsh.aop.order..*(..))")
    public void allOrder(){} //pointcut 시그니처

    //클래스 이름 패턴이 *Service
    @Pointcut("execution(* *..*Service.*(..))")
    public void allService(){}

    //allOrder && allService
    @Pointcut("allOrder() && allService()")
    public void orderAndService() {}
}
