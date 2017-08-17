package com.rest.excercise.domain.entities;

public class Payload {

	Account account;
	User user;
	Company company;
	Order order;
	Notice notice;
	
	public Payload(Account account, User user, Company company, Order order, Notice notice) {
		super();
		this.account = account;
		this.user = user;
		this.company = company;
		this.order = order;
		this.notice = notice;
	}

	public Payload() {
		super();
	}
	
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}
}
