package com.kalu.fraud.model.response;

import java.time.LocalDateTime;

public record FraudCheckResponse(Boolean isFraudster, LocalDateTime timestamp) {
}
