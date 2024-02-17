package com.octocat.aopdemo;

import com.octocat.aopdemo.dao.AccountDAO;
import com.octocat.aopdemo.dao.MembershipDAO;
import com.octocat.aopdemo.service.TrafficFortunrService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO,
											   MembershipDAO theMembershipDAO,
											   TrafficFortunrService theTrafficFortuneService){


		return runner ->{

			// demoTheBeforeAdvice(theAccountDAO,theMembershipDAO);
			// demoTheAfterReturningAdcvice(theAccountDAO);
			// demoTheAfterThrowingAdvice(theAccountDAO);
			// demoTheAfterAdvice(theAccountDAO);
			// demoTheAroundAdvice(theTrafficFortuneService);
			// demoTheAroundAdviceHandleException(theTrafficFortuneService);
			demoTheAroundAdviceRethrowException(theTrafficFortuneService);

			
		};
	}

	private void demoTheAroundAdviceRethrowException(TrafficFortunrService theTrafficFortuneService) {

		System.out.println("Main program: demoTheAroundAdviceRethrowException");

		System.out.println("Calling getFortune()");
		boolean tripWire = true;

		String data = theTrafficFortuneService.getFortune(tripWire);

		System.out.println("My fortune is: "+ data);

		System.out.println("Finished");
	}

	private void demoTheAroundAdviceHandleException(TrafficFortunrService theTrafficFortuneService) {

		System.out.println("Main program: demoTheAroundAdviceHandleException");

		System.out.println("Calling getFortune()");
		boolean tripWire = true;

		String data = theTrafficFortuneService.getFortune(tripWire);

		System.out.println("My fortune is: "+ data);

		System.out.println("Finished");
	}

	private void demoTheAroundAdvice(TrafficFortunrService theTrafficFortuneService) {

		System.out.println("Main program: demoTheAroundAdvice");

		System.out.println("Calling getFortune()");

		String data = theTrafficFortuneService.getFortune();

		System.out.println("My fortune is: "+ data);

		System.out.println("Finished");
	}

	private void demoTheAfterAdvice(AccountDAO theAccountDAO) {

		// call method to find the accounts
		List<Account> theAccounts = null;

		try {
			// add a boolean flag to simulate exceptions
			boolean tripWire = false;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}
		catch (Exception exc){
			System.out.println("Main Program: caught exception: " + exc);
		}

		// display the accounts
		System.out.println("Main Program: demoTheAfterThrowingAdvice");
		System.out.println("-----");

		System.out.println(theAccounts);
	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
		// call method to find the accounts
		List<Account> theAccounts = null;

		try {
			// add a boolean flag to simulate exceptions
			boolean tripWire = true;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}
		catch (Exception exc){
			System.out.println("Main Program: caught exception: " + exc);
		}

		// display the accounts
		System.out.println("Main Program: demoTheAfterThrowingAdvice");
		System.out.println("-----");

		System.out.println(theAccounts);
	}

	private void demoTheAfterReturningAdcvice(AccountDAO theAccountDAO) {

		// call method to find the accounts
		List<Account> theAccounts = theAccountDAO.findAccounts();

		// display the accounts
		System.out.println("Main Program: demoTheAfterReturningAdvice");
		System.out.println("-----");

		System.out.println(theAccounts);
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO){

		// call the business method
		Account myAccount = new Account();
		myAccount.setName("Madhu");
		myAccount.setLevel("Platinum");
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();

		// call the accountdao getter/setter methods
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();


		// call teh membership business method
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();

	}

}
