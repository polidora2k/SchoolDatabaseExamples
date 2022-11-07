package com.teksystems.schooldatabase.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import com.teksystems.schooldatabase.dao.FacultyDAO;

class FacultyTest {
	private static FacultyDAO fdao;
	
	@BeforeAll
	public static void setup() {
		fdao = new FacultyDAO();
	}
	
	
	@ParameterizedTest
    @CsvSource({"2,Norman,Diana,2", "3,Cherish,Revard,5"})
    void testFacultyCSV(Integer id, String firstName, String lastName, Integer deptId) {
        Faculty expected = new Faculty();
        expected.setId(id);
        expected.setFirstname(firstName);
        expected.setLastname(lastName);
        expected.setDeptid(deptId);
        
        Faculty actual = fdao.findFacultyById(id);
        
        Assertions.assertEquals(expected, actual);
    }
	
	@ParameterizedTest
    @CsvFileSource(resources = {"/faculty.csv"}, delimiter = ',', numLinesToSkip = 1)
    void testFacultyCSVFile(Integer id, String firstName, String lastName, Integer deptId) {
        Faculty expected = new Faculty();
        expected.setId(id);
        expected.setFirstname(firstName);
        expected.setLastname(lastName);
        expected.setDeptid(deptId);
        
        Faculty actual = fdao.findFacultyById(id);
        
        Assertions.assertEquals(expected, actual);
    }

}
