package com.kalu.customer.model.response;

import java.time.LocalDateTime;

public record FraudCheckResponse(Boolean isFraudster, LocalDateTime timestamp) {
}
