package com.octocat.aopdemo.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class AopExpressions {
    @Pointcut("execution(* com.octocat.aopdemo.dao.*.*(..))")
    public void forDaoPackage(){}

    // create a pointcut for getter methods
    @Pointcut("execution(* com.octocat.aopdemo.dao.*.get*(..))")
    public void getter(){}

    // create a pointcut for setter methods
    @Pointcut("execution(* com.octocat.aopdemo.dao.*.set*(..))")
    public void setter(){}

    // create pointcut: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter(){}
}
