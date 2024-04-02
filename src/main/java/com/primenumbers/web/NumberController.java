package com.primenumbers.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.primenumbers.db.Numbers;
import com.primenumbers.repository.NumbersRepository;
import com.primenumbers.service.NumbersService;

@Controller
public class NumberController {
	
	@Autowired
	private NumbersRepository numbersRepo;
	
	@Autowired
	private NumbersService numbersService;
	
	@GetMapping("/numbers")
	public String getNumbersView(ModelMap model, @RequestParam("min") int min, @RequestParam("max") int max) {
		
		ArrayList<Integer> array = numbersService.primeNumArr(min, max);
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
}
