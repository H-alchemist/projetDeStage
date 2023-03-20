package com.serverside.Api.Dao;

import com.serverside.Api.Model.Transaction;

import com.serverside.Api.Reposetries.Transactionrepo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class TransactionDao {


    @Autowired
    Transactionrepo transactionR;


    public Transaction add(Transaction t){

        return transactionR.save(t);
    }

    public List<Transaction> getAll(){

        return transactionR.findAll();

    }

    public boolean delete(){
        transactionR.deleteAll();
        return true;
    }





}
