package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;
	
	// add a new mthod findAccounts()
	
	public List<Account> findAccounts() {
		
		List<Account> accounts = new ArrayList<Account>(Arrays.asList(
								 new Account("John", "Silver"),
								 new Account("Madhu", "Platinum"),
								 new Account("Luca", "Gold")));
		
		return accounts;
	}
	
	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ": performing work in account class");
		return true;
	}

	public String getName() {
		System.out.println(getClass() +": in AccountDAO.getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() +": in AccountDAO.setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() +": in AccountDAO.getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() +": in AccountDAO.setServiceCode()");
		this.serviceCode = serviceCode;
	}
	
	
	
}
