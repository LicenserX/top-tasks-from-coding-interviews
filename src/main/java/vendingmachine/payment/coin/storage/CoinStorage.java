/*
 * Copyright 2021 Russian Post
 *
 * This source code is Russian Post Confidential Proprietary.
 * This software is protected by copyright. All rights and titles are reserved.
 * You shall not use, copy, distribute, modify, decompile, disassemble or reverse engineer the software.
 * Otherwise this violation would be treated by law and would be subject to legal prosecution.
 * Legal use of the software provides receipt of a license from the right holder only.
 */
package vendingmachine.payment.coin.storage;

import vendingmachine.payment.coin.Coin;

import java.util.EnumMap;
import java.util.Map;

import static vendingmachine.payment.coin.Coin.*;

public final class CoinStorage {
    private CoinStorage() {
    }

    private static final Map<Coin, Integer> coinToAmountNumber = new EnumMap<Coin, Integer>(Coin.class);

    static {
        coinToAmountNumber.put(PENNY, 5);
        coinToAmountNumber.put(NICKEL, 5);
        coinToAmountNumber.put(DIME, 5);
        coinToAmountNumber.put(QUARTER, 5);
    }

    public static final void addCoin() {}

    public static final void removeCoin() {}

    public static final Map<Coin, Integer> getAllAvailableCoins() {
        return coinToAmountNumber;
    }
}
