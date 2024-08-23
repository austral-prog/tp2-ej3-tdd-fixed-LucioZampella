package com.template;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

import static javax.management.Query.and;

public class App {

    public static Map<String, Integer> create(Map<String, Integer> accounts, String account, int balance) {
        accounts.put(account, balance);
        return accounts;
    }

    public static Map<String, Integer> deposit(Map<String, Integer> accounts, String account, int amount) {
        if (!accounts.containsKey(account)) {
            System.out.println("Invalid account");
        } else if (amount > 0) {
            int currentBalance = accounts.get(account);
            int newAmount = currentBalance + amount;
            accounts.put(account, newAmount);
        } else {
            System.out.println("Invalid amount");
        }
        return accounts;
    }

    public static Map<String, Integer> retire(Map<String, Integer> accounts, String account, int amount) {
        if (!accounts.containsKey(account)) {
            System.out.println("Invalid account");
        } else if (amount >= 0) {
            int currentBalance = accounts.get(account);
            if (currentBalance >= amount) {
                int newAmount = currentBalance - amount;
                accounts.put(account, newAmount);
            } else {
                System.out.println("Insufficient funds");
                accounts.put(account, accounts.get(account));
            }
        } else {
            System.out.println("Invalid amount");
        }
        return accounts;
    }

    public static Map<String, Integer> transfer(Map<String, Integer> accounts, String fromAccount, String toAccount, int amount) {
        if (amount >= 0 && accounts.containsKey(fromAccount) && accounts.containsKey(toAccount)) {
            if (fromAccount != toAccount) {
                if (amount > accounts.get(toAccount)) {
                    System.out.println("Insufficient funds");
                    accounts.get(toAccount);
                    accounts.get(fromAccount);
                }
                else if (accounts.get(toAccount) == 0 || accounts.get(fromAccount) == 0) {
                    System.out.println("Transfers cannot be made without a balance");
                    accounts.get(fromAccount);
                    accounts.get(toAccount);
                }
                else {
                    accounts.put(fromAccount, accounts.get(fromAccount) - amount);
                    accounts.put(toAccount, accounts.get(toAccount) + amount);
                }
                }
           else {
                System.out.println("Accounts are the same");
                accounts.get(fromAccount);
        }

        }
        else if (amount <= 0) {
            System.out.println("Invalid amount");
            accounts.get(fromAccount);
            accounts.get(toAccount);
        }
        return accounts;
    }
}

