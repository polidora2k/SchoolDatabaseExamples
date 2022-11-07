package com.teksystems.application;

import java.util.ArrayList;
import java.util.List;

import com.teksystems.schooldatabase.entity.Course;

public class App {

	public static void main(String[] args) {
		List<Course> expected = new ArrayList<Course>();
        Course course1 = new Course();
        Course course2 = new Course();
        
        course1.setId(41);
        course1.setName("History");
        course1.setDeptId(3);
        
        expected.add(course1);
        
        course2.setId(42);
        course2.setName("History of Art, Architecture & Design");
        course2.setDeptId(1);
        
        expected.add(course2);
        
        System.out.println(expected);

	}

}
