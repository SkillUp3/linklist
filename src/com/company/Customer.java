package com.company;

/**
 * Created by idejesus on 14/03/2017.
 */
public class Customer {
    private String mName;
    private double mBalance;

    public Customer(String name, double balance) {
        mName = name;
        mBalance = balance;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public double getBalance() {
        return mBalance;
    }

    public void setBalance(double balance) {
        mBalance = balance;
    }
}
