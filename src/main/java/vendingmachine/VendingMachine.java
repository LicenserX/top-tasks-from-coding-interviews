/*
 * Copyright 2021 Russian Post
 *
 * This source code is Russian Post Confidential Proprietary.
 * This software is protected by copyright. All rights and titles are reserved.
 * You shall not use, copy, distribute, modify, decompile, disassemble or reverse engineer the software.
 * Otherwise this violation would be treated by law and would be subject to legal prosecution.
 * Legal use of the software provides receipt of a license from the right holder only.
 */
package vendingmachine;

import vendingmachine.drink.impl.Coke;
import vendingmachine.drink.type.Container;
import vendingmachine.factory.AbstractFactory;
import vendingmachine.factory.impl.CokeFactory;
import vendingmachine.payment.Payment;
import vendingmachine.payment.PaymentImpl;
import vendingmachine.payment.PaymentInfo;
import vendingmachine.payment.coin.Coin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static vendingmachine.drink.type.Container.PLASTIC;
import static vendingmachine.payment.coin.Coin.*;

public class VendingMachine {

    private Payment payment;
    private AbstractFactory factory;

    public VendingMachine(Payment payment, AbstractFactory factory) {
        this.payment = payment;
        this.factory = factory;
    }

    public static void main(String[] args) throws InterruptedException {
        AbstractFactory cokeFactory;
        Payment payment;
        VendingMachine vendingmachine;


        System.out.println("Hi, choose your drink");
        TimeUnit.SECONDS.sleep(5);

        Coke drink = new Coke("Coke", 25, PLASTIC);
        cokeFactory = new CokeFactory(drink);
        payment = new PaymentImpl(cokeFactory);
        vendingmachine = new VendingMachine(payment, cokeFactory);

        System.out.println("Thank you for your choice, you have chosen a " + drink.getName());
        System.out.println("Please pay a " + drink.getPrice());

        TimeUnit.SECONDS.sleep(2);

        List<Coin> coins = new ArrayList<>();
        coins.add(QUARTER);
        coins.add(DIME);

        System.out.println("To get money back, please push Cancel button");
        System.out.println("To continue please push Continue button");

        TimeUnit.SECONDS.sleep(5);

        boolean isRefundActivated = false;
        if (isRefundActivated) {
            payment.refund(coins);
            System.out.println("Please take the money");
            return;
        }

        PaymentInfo payInfo = payment.getPayInfo(coins);

        switch (payInfo.getPayStatus()) {
            case APPROVED:
                System.out.println("Please take your drink");
                return;
            case CHANGE_REQUIRED:
                System.out.println(payment.change(payInfo.getSummary(), drink.getPrice()));
                System.out.println("Please take your drink, and forget a change");
                return;
            case REJECTED:
                System.out.println("Not enough money, please try again");
                return;
        }


    }
}
