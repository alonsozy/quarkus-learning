package com.bcp.training;


import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Path;

import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

@ApplicationScoped
public class ExpenseService {
    private Set<Expense> expenses = Collections.newSetFromMap(Collections.synchronizedMap(new HashMap<>()));


    @PostConstruct
    public void init(){
        expenses.add(
                new Expense("Quarkus for Spring developers",Expense.PaymentMethod.DEBIT_CARD,"10.00")
        );

        expenses.add(
                new Expense("Openshift for developers, Second Edition",Expense.PaymentMethod.CREDIT_CARD,"30.00")
        );
    }

    public Set<Expense> list() {
        System.out.println("<<<<<<< Get Expense List >>>>>>>>>>");
        return expenses;
    }

    public Expense create(Expense expense) {
        System.out.println("<<<<<<< Adding Expense >>>>>>>>>>");
        expenses.add(expense);
        return expense;
    }

    public boolean delete(UUID uuid) {
        return expenses.removeIf(expense -> expense.getUuid().equals(uuid));
    }

    public void update(Expense expense) {
        delete(expense.getUuid());
        create(expense);
    }

    public boolean exists(UUID uuid) {
        return expenses.stream().anyMatch(exp -> exp.getUuid().equals(uuid));
    }
}