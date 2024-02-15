package com.octocat.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{
    @Override
    public void addSillyMember() {

        System.out.println(getClass() + ": Doing my db work: Adding a MEMBERSHIP account");
    }
}
