package com.primenumbers.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.primenumbers.db.Numbers;
import com.primenumbers.repository.NumbersRepository;

@Controller
public class NumberController {
	
	@Autowired
	private NumbersRepository numbersRepo;
	
	@GetMapping("/numbers")
	public String getNumbersView(ModelMap model, @RequestParam("min") int min, @RequestParam("max") int max) {
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		for (int num = min; num <= max; num++) {
            if (isNumPrime(num)) {
            	array.add(num);
            }
        }
		
		String strArr = array.toString();
		
		if(numbersRepo.findByMinAndMax(min, max).isEmpty()) {
			numbersRepo.save(new Numbers(min, max, strArr));
			model.put("duplicate", false);
			model.put("array", array);
			model.put("min", min);
			model.put("max", max);
			return "index";
		} else {
			model.put("duplicate", true);
			model.put("array", array);
			model.put("min", min);
			model.put("max", max);
			return "index";
		}
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
