package com.octocat.aopdemo.dao;

import com.octocat.aopdemo.Account;

public interface AccountDAO {

    void addAccount(Account theAccount, boolean vipFlag);
}
