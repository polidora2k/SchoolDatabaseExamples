package com.teksystems.schooldatabase.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "faculty")
public class Faculty {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer id;
	@EqualsAndHashCode.Include
	private String firstname;
	@EqualsAndHashCode.Include
	private String lastname;
	
	@EqualsAndHashCode.Include
	@Column(insertable = false, updatable = false)
	private Integer deptid;
	
	@ManyToOne
	@JoinColumn(name = "deptid", nullable = false)
	private Department department;
}
