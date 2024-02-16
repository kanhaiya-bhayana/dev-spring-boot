package com.octocat.aopdemo.dao;

import com.octocat.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{
    @Override
    public void addAccount(Account theAccount) {

        System.out.println(getClass() + ": Doing my db work: Adding an account");
    }
}
