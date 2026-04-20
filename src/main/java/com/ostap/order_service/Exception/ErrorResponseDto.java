package com.ostap.order_service.Exception;

import java.time.LocalDateTime;
//DTO - переносить дані між клієнтом та сервером
public record ErrorResponseDto(
        String message,
        String detailedMessage,
        LocalDateTime errorTime
) {

}
