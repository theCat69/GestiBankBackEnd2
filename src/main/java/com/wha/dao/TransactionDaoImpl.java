package com.wha.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.wha.model.Transaction;

@Repository("transaction")
public class TransactionDaoImpl extends AbstractDao<Integer, Transaction> implements TransactionDao {

	@Override
	public Transaction findById(int id) {
		return getByKey(id);
	}

	@Override
	public void save(Transaction transaction) {
		save(transaction);

	}

	@Override
	public void transactionCompteById(int id) {

	}

	@Override
	public List<Transaction> findAllTransaction() {
		Query q = getEntityManager().createQuery("select * from Transaction");
		return (List<Transaction>) q.getResultList();
	}

}
