package com.synerzip.expenseCalculation.repository;


import java.util.Collection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.synerzip.expenseCalculation.model.Expense;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Integer> {

	@Query(value = "Select e from Expense e where e.user_id = :userId", nativeQuery = true)
	public Collection<Expense> findAllByUserId(@Param("userId") int userId);
}
