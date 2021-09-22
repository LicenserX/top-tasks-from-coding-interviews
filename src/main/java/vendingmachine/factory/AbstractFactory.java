/*
 * Copyright 2021 Russian Post
 *
 * This source code is Russian Post Confidential Proprietary.
 * This software is protected by copyright. All rights and titles are reserved.
 * You shall not use, copy, distribute, modify, decompile, disassemble or reverse engineer the software.
 * Otherwise this violation would be treated by law and would be subject to legal prosecution.
 * Legal use of the software provides receipt of a license from the right holder only.
 */
package vendingmachine.factory;

import vendingmachine.drink.Drink;

public abstract class AbstractFactory {
    Drink drink;

    public AbstractFactory(Drink drink) {
        this.drink = drink;
    }

    public Drink getDrink() {
        return drink;
    }

}
