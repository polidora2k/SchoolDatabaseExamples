package com.teksystems.schooldatabase.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentTest {

	@Test
    public void testStudent() {
        Student a = new Student();
        a.setId(1);
        a.setFirstname("Mike");
        a.setLastname("Gabriel");
        
        Student b = new Student();
        b.setId(1);
        b.setFirstname("Mike");
        b.setLastname("Gabriel");        
        
        assertEquals(a, b);
    }
}
