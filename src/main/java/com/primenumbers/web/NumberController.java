package com.primenumbers.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.primenumbers.service.NumbersService;

@Controller
public class NumberController {
	
	@Autowired
	private NumbersService numbersService;
	
	@GetMapping("/numbers")
	public String getNumbersView(ModelMap model, @RequestParam("min") int min, @RequestParam("max") int max) {
		return numbersService.getPrimeNumbers(model, min, max);
	}
}
