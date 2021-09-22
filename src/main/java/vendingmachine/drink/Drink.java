/*
 * Copyright 2021 Russian Post
 *
 * This source code is Russian Post Confidential Proprietary.
 * This software is protected by copyright. All rights and titles are reserved.
 * You shall not use, copy, distribute, modify, decompile, disassemble or reverse engineer the software.
 * Otherwise this violation would be treated by law and would be subject to legal prosecution.
 * Legal use of the software provides receipt of a license from the right holder only.
 */
package vendingmachine.drink;

import vendingmachine.drink.type.Container;

import java.math.BigDecimal;

public abstract class Drink {
    String name;
    int price;
    Container container;

    public Drink(String name, int price, Container container) {
        this.name = name;
        this.price = price;
        this.container = container;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Container getContainer() {
        return container;
    }
}
