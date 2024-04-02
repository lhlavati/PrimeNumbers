package com.primenumbers.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.primenumbers.db.Numbers;
import com.primenumbers.repository.NumbersRepository;

@Service
public class NumbersService {
	
	@Autowired
	NumbersRepository numbersRepo;

	public String getPrimeNumbers(ModelMap model, int min, int max){
		
		Numbers numbers = numbersRepo.findByMinAndMax(min, max);
		List<Integer> array;
		if(numbers == null) {
			model.put("duplicate", false);
			array = primeNumArr(min, max);
			String strArr = array.stream().map(Objects::toString).collect(Collectors.joining(","));
			numbersRepo.save(new Numbers(min, max, strArr));
		} else {
			model.put("duplicate", true);
			array = Arrays.stream(numbers.getPrimeNumbers().split(",")).map(Integer::parseInt).toList();
		}
		
		model.put("array", array);
		model.put("min", min);
		model.put("max", max);
		
		return "index";
	}
	
	public ArrayList<Integer> primeNumArr(int min, int max){
		ArrayList<Integer> array = new ArrayList<>();
		for (int num = min; num <= max; num++) {
	        if (isNumPrime(num)) {
	        	array.add(num);
	        }
	    }
		return array;
	}
	
	private boolean isNumPrime(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
