package com.teksystems.schooldatabase.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.teksystems.schooldatabase.entity.Course;
import com.teksystems.schooldatabase.entity.Department;

class CourseDAOTest {
	private static CourseDAO courseDAO;
    
	@BeforeAll
    public static void setUp() {
        courseDAO = new CourseDAO();
    }
	
    @Test
    void testGetCourseById() {
        Course expected = new Course();
        
        expected.setId(1);
        expected.setName("Accounting & Finance");
        expected.setDeptId(2);
        
        Course actual = courseDAO.findCourseById(1);
        
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(expected.getName(), actual.getName());
        Assertions.assertEquals(expected.getDeptId(), expected.getDeptId());
    }
    
    @Test
    void testGetCourseByName() {
        Course expected = new Course();
        
        expected.setId(1);
        expected.setName("Accounting & Finance");
        expected.setDeptId(2);
        
        Course actual = courseDAO.findByCourseName("Accounting & Finance").get(0);
        
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(expected.getName(), actual.getName());
        Assertions.assertEquals(expected.getDeptId(), expected.getDeptId());
    }
    
    @Test
    void testGetCourseByNameStartsWith() {
    	// Given
    	List<Course> expected = new ArrayList<Course>();
        Course course1 = new Course();
        Course course2 = new Course();
        
        course1.setId(41);
        course1.setName("History");
        course1.setDeptId(3);
        course1.setDepartment(new Department(3, "Culture & History"));
        
        expected.add(course1);
        
        course2.setId(42);
        course2.setName("History of Art, Architecture & Design");
        course2.setDeptId(1);
        course2.setDepartment(new Department(1, "Arts & Design"));
        
        expected.add(course2);
        
        // When
        List<Course> actual = courseDAO.findByCourseNameStartsWith("History");
        
        // Then
        Assertions.assertIterableEquals(expected, actual);
    }
}
