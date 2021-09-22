/*
 * Copyright 2021 Russian Post
 *
 * This source code is Russian Post Confidential Proprietary.
 * This software is protected by copyright. All rights and titles are reserved.
 * You shall not use, copy, distribute, modify, decompile, disassemble or reverse engineer the software.
 * Otherwise this violation would be treated by law and would be subject to legal prosecution.
 * Legal use of the software provides receipt of a license from the right holder only.
 */
package vendingmachine.payment;

import vendingmachine.factory.AbstractFactory;
import vendingmachine.payment.coin.Coin;
import vendingmachine.payment.coin.storage.CoinStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static vendingmachine.payment.coin.Coin.NICKEL;
import static vendingmachine.payment.coin.Coin.PENNY;
import static vendingmachine.payment.status.PayStatus.*;

public class PaymentImpl implements Payment {
    AbstractFactory factory;

    public PaymentImpl(AbstractFactory factory) {
        this.factory = factory;
    }

    public PaymentInfo getPayInfo(List<Coin> coins) {
        int price = factory.getDrink().getPrice();

        int sumCents = coins.stream()
                .mapToInt(Coin::getNominalValue)
                .sum();

        UUID operationId = UUID.randomUUID();
        
        if (sumCents == price) {
           return new PaymentInfo(sumCents, APPROVED, operationId, "Payment successful");
        }
        if (sumCents > price) {
            return new PaymentInfo(sumCents, CHANGE_REQUIRED, operationId, "Change required");
        }
        return new PaymentInfo(sumCents, REJECTED, operationId, "Not enough money");
    }

    @Override
    public List<Coin> refund(List<Coin> coins) {
        return coins;
    }

    @Override
    public List<Coin> change(int summary, int price) {
        int change = summary - price;

        Map<Coin, Integer> allAvailableCoins = CoinStorage.getAllAvailableCoins();

        if (allAvailableCoins.get(PENNY) >= change) {
            List<Coin> pennys = new ArrayList<>();
            for (int i = 0; i < change; i++) {
                pennys.add(PENNY);
            }
            return pennys;
        }

        if (allAvailableCoins.get(NICKEL) * NICKEL.getNominalValue() >= change) {
            List<Coin> nickels = new ArrayList<>();
            if(change % NICKEL.getNominalValue() == 0) {
                int size = change / NICKEL.getNominalValue();
                for (int i = 0; i< size; i++) {
                    nickels.add(NICKEL);
                }
            }
            return nickels;
        }
        return null;
    }


}
