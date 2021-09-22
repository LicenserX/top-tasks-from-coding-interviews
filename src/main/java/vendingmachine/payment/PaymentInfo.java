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

import vendingmachine.payment.status.PayStatus;

import java.util.UUID;

public final class PaymentInfo {
    private final int summary;
    private final PayStatus payStatus;
    private final UUID operationId;
    private final String description;

    public PaymentInfo(int summary, PayStatus payStatus, UUID operationId, String description) {
        this.summary = summary;
        this.payStatus = payStatus;
        this.operationId = operationId;
        this.description = description;
    }

    public int getSummary() {
        return summary;
    }

    public final PayStatus getPayStatus() {
        return payStatus;
    }

    public final UUID getOperationId() {
        return operationId;
    }

    public final String getDescription() {
        return description;
    }
}
