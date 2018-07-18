package com.wha.dao;

import java.util.List;

import com.wha.model.Transaction;

public interface TransactionDao {

	Transaction findById(int id);

	void save(Transaction transaction);

	void transactionCompteById(int id);

	List<Transaction> findAllTransaction();

}
