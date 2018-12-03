package com.kick.Emp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;

@Entity
@Table(name="Employee")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//@SequenceGenerator(name="seq",initialValue=1,allocationSize=100)
public class Employee {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private long id;

private String name;
private String Country;
	

public void setCountry(String country) {
	Country = country;
}
	public long getid() {
	return id;
}
	@Column(name="id")
public void setid(long id) {
	id = id;
}
public String getName() {
	return name;
}
@Column(name="Name")
public void setName(String name) {
	this.name = name;
}
@Override
public String toString() {
	return "Employee [id=" + id + ", name=" + name + ", Country=" + Country + "]";
}
	public String getCountry() {
	return Country;
}
	
	
}
