package com.payments.academypayments.controller;

public record PaymentConfirmedEvent(
        String sessionID,
        String customerEmail
) {
}
