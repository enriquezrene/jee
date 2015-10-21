package com.github.demo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

// Avoid get/set
@Data
@Entity
@Table(name = "tbl_department")
public class Department {

	// GenerationType.AUTO
	// GenerationType.IDENTITY
	// GenerationType.SEQUENCE
	// GenerationType.TABLE

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "dep_id")
	private long id;

	@Column(name = "dep_name")
	private String name;

	// one department -> many employees
	@OneToMany(mappedBy = "department")
	private List<Employee> employees;

}
