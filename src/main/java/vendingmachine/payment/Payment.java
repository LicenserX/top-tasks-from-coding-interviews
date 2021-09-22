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

import vendingmachine.payment.coin.Coin;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public interface Payment {
    PaymentInfo getPayInfo(List<Coin> coins);

    List<Coin> refund(List<Coin> coins);

    List<Coin> change(int summary, int price);


}
