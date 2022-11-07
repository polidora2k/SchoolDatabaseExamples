package com.teksystems.schooldatabase.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Table(name = "studentcourse")
public class StudentCourse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer id;
	
	@Column(insertable = false, updatable = false)
	private Integer studentId;
	
//	@ManyToOne
//	@JoinColumn(name = "studentId", nullable = false)
//	@Column(insertable = false, updatable = false)
//	@ToString.Exclude
//	private Student student;
	
	@Column(insertable = false, updatable = false)
	private Integer courseId;
	
//	@ManyToOne
//	@JoinColumn(name = "courseId", nullable = false)
//	@ToString.Exclude
//	private Course course;
	
	private Integer progress;
	
	@Temporal(TemporalType.DATE)
	private Date startDate;

}
