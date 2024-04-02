package com.primenumbers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.primenumbers.db.Numbers;

public interface NumbersRepository extends JpaRepository<Numbers, Long> {

	List<Numbers> findByMinAndMax(int min, int max);
	
}
