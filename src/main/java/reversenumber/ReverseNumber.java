/*
 * Copyright 2021 Russian Post
 *
 * This source code is Russian Post Confidential Proprietary.
 * This software is protected by copyright. All rights and titles are reserved.
 * You shall not use, copy, distribute, modify, decompile, disassemble or reverse engineer the software.
 * Otherwise this violation would be treated by law and would be subject to legal prosecution.
 * Legal use of the software provides receipt of a license from the right holder only.
 */
package reversenumber;

public class ReverseNumber {
    public static void main(String[] args) {
        System.out.println(getReversedNumber(1234567891));
    }

    public static int getReversedNumber(int n) {
        int[] ints = new int[10];
        int iteration = 0;

        while (n % 10 != 0) {
            ints[iteration++] = n % 10;
            n = n / 10;
        }

        int result =  ints[0] * 10 + ints[1];

        for (int i = 1; i < iteration - 1; i++) {
            result = result * 10 + ints[i + 1];
        }
       return result;
    }
}
