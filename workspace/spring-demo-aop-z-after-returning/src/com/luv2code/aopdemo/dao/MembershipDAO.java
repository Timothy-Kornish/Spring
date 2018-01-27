package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public String addMember() {
		System.out.println(getClass() + ": adding a membership account");
		return "Member added";
	}
}
