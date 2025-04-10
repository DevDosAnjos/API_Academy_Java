package com.users.academyusers.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record RegisterRequest(
        String name,
        String rg,
        String cpf,
        LocalDate dateOfBirth,
        Integer age,
        BigDecimal weight,
        BigDecimal height,
        String address,
        String cellphoneNumber,
        String email,
        String password
) {
}
