package com.teksystems.schooldatabase.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer id;
	
	private String email;
	private String name;
	private String password;
	private String address;
	private String state;
	private String zipcode;
}
