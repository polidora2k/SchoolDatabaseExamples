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
@Table(name = "course")
public class Course {
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private Integer id;
	
	private String name;
	
	@Column(insertable = false, updatable = false)
	private Integer deptId;
	
	@ManyToOne
	@JoinColumn(name = "deptId")
	@ToString.Exclude
	private Department department;
}
