package com.bookstoredb.entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testAdd() {
        Calculator cal = new Calculator();
        int a = 1212;
        int b =3000;
        
        int result = cal.add(a,b);
        int expect= 4212;
        assertEquals(expect, result);
	}

}
