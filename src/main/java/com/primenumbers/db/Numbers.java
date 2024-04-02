package com.primenumbers.db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Numbers {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private int min;
	private int max;
	private String primeNumbers;
	
	public Numbers() {}
	
	public Numbers(int min, int max, String primeNumbers) {
		super();
		this.min = min;
		this.max = max;
		this.primeNumbers = primeNumbers;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public String getPrimeNumbers() {
		return primeNumbers;
	}

	public void setPrimeNumbers(String primeNumbers) {
		this.primeNumbers = primeNumbers;
	}

	@Override
	public String toString() {
		return "Numbers [id=" + id + ", min=" + min + ", max=" + max + ", primeNumbers=" + primeNumbers + "]";
	}
	
	
}
