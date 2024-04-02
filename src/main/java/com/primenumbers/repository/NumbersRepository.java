package com.primenumbers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.primenumbers.db.Numbers;

public interface NumbersRepository extends JpaRepository<Numbers, Long> {

	Numbers findByMinAndMax(int min, int max);
	
}
