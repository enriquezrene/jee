package com.github.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//Avoid get/set
@Entity
@Table(name = "tbl_employee")
public class Employee {

	// GenerationType.AUTO
	// GenerationType.IDENTITY
	// GenerationType.SEQUENCE
	// GenerationType.TABLE

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "emp_id")
	private long id;

	@Column(name = "emp_name")
	private String name;

	@Column(name = "emp_lastname")
	private String lastname;

	@Column(name = "emp_salary")
	private int salary;

	// many employees -> one department
	@ManyToOne
	@JoinColumn(name = "dep_id")
	private Department department;
}
