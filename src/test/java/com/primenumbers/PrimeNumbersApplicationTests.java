package com.primenumbers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.primenumbers.service.NumbersService;

@SpringBootTest
public class PrimeNumbersApplicationTests {
	
	@Autowired
	private NumbersService numbersService;

	@Test
	public void calcPrimeNum() {
		ArrayList<Integer> arrExpected = new ArrayList<>();
		arrExpected.add(5);
		arrExpected.add(7);
		arrExpected.add(11);
		arrExpected.add(13);
		arrExpected.add(17);
		arrExpected.add(19);
		ArrayList<Integer> arrActual = numbersService.primeNumArr(5, 20);
		
		assertEquals(arrExpected, arrActual);
	}
}
