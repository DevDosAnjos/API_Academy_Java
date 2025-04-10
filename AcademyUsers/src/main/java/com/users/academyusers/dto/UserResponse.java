package com.users.academyusers.dto;

import com.example.common.enums.users.UserStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

public record UserResponse(
        String id,
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
        UserStatus userStatus
) {
}
