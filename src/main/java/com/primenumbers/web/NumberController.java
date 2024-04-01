package com.primenumbers.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NumberController {
	
	@GetMapping("/numbers")
	public String getNumbersView(ModelMap model, @RequestParam("min") int min, @RequestParam("max") int max) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		for (int num = min; num <= max; num++) {
            if (isNumPrime(num)) {
            	array.add(num);
            }
        }
		model.put("array", array);
		model.put("min", min);
		model.put("max", max);
		return "index";
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
