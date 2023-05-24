package com.dto;

import java.sql.Date;
import java.time.LocalDate;

public class Mobile {
	
	 private int id;
	  private String modelno;
	  private String company;
	  private int price;
  private LocalDate date;
  
  
  

public Mobile(String modelno, String company, int price, LocalDate date) {
	super();
	
	this.modelno = modelno;
	this.company = company;
	this.price = price;
	this.date = date;
}
public Mobile() {
	super();
	// TODO Auto-generated constructor stub
}
public Mobile(int id, String modelno, String company, int price, LocalDate date) {
	super();
	this.id = id;
	this.modelno = modelno;
	this.company = company;
	this.price = price;
	this.date = date;
}



public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getModelno() {
	return modelno;
}
public void setModelno(String modelno) {
	this.modelno = modelno;
}
public String getCompany() {
	return company;
}
public void setCompany(String company) {
	this.company = company;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
@Override
public String toString() {
	return "Mobile [id=" + id + ", modelno=" + modelno + ", company=" + company + ", price=" + price + ", date=" + date
			+ "]";
}
	
  
  
}
