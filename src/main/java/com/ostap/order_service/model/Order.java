package com.ostap.order_service.model;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

import java.time.LocalDate;

public record Order(

        @Null
        Long id,

        @NotNull
        Long userId,

        @NotNull
        @FutureOrPresent
        LocalDate time,

        @NotNull
        double price,

        @NotNull
        OrderStatus orderStatus
) {

}
