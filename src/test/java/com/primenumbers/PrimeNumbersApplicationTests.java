package com.primenumbers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

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
		
		int[] arrayExpected = arrExpected.stream().mapToInt(i -> i).toArray();
		int[] arrayActual = arrActual.stream().mapToInt(i -> i).toArray();
		
		System.out.println(arrayExpected);
		System.out.println(arrayActual);
		assertArrayEquals(arrayExpected, arrayActual);
		
		/*
		 * if(arrExpected.equals(arrActual)) { System.out.println("Same");
		 * System.out.println(arrExpected); System.out.println(arrActual); } else {
		 * System.out.println("Not same"); System.out.println(arrExpected);
		 * System.out.println(arrActual); }
		 */
	}
}
