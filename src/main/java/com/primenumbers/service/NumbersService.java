package com.primenumbers.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class NumbersService {

	public ArrayList<Integer> primeNumArr(int min, int max){
		ArrayList<Integer> array = new ArrayList<>();
		for (int num = min; num <= max; num++) {
	        if (isNumPrime(num)) {
	        	array.add(num);
	        }
	    }
		return array;
	}
	
	public boolean isNumPrime(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
	
}
