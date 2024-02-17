package com.octocat.aopdemo.aspect;

import com.octocat.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @After("execution(* com.octocat.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint){

        // print out which method we  are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("=========> Executing @After (finally) on method: "+ method);


    }

    @AfterThrowing(
            pointcut = "execution(* com.octocat.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccounts(JoinPoint theJoinPoint, Throwable theExc){

        // print out which method we  are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("=========> Executing @AfterThrowing on method: "+ method);

        // log the exception
        System.out.println("=========> The exception is: "+ theExc);

    }
    @AfterReturning(
            pointcut = "execution(* com.octocat.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccounts(JoinPoint theJoinPoint, List<Account> result){

        // print ou which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("=========> Executing @AfterReturning on method: "+ method);

        // print out the results of the method call
        System.out.println("======> result is: " + result);

        // let's post-process the data ... let's modify it

        // convert the account names to uppercase
        convertAccountNamesToTupperCase(result);

        System.out.println("======> result is: " + result);
    }

    private void convertAccountNamesToTupperCase(List<Account> result) {

        // loop through accounts
        for (Account acc : result){

        // get uppercase version of name
            String name = acc.getName().toUpperCase();

        // update the name on the account
            acc.setName(name);

        }
    }

    @Before("com.octocat.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccount(JoinPoint theJoinPoint){

        // JoinPoint has metadata about method call
        System.out.println(" =========> Executing @Before advice on addAccount()");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        // display the method arguments

        // get args
        Object[] args = theJoinPoint.getArgs();

        // loop thru args
        for (Object tempArg : args){
            System.out.println(tempArg);

            if (tempArg instanceof Account){

                // downcast and print Account specific stuff
                Account theAccount = (Account) tempArg;

                System.out.println("account name: "+theAccount.getName());
                System.out.println("account level: "+theAccount.getLevel());
            }
        }
    }
}
