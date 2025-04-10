package com.users.academyusers.dto;

import com.example.common.enums.users.Belts;
import com.example.common.enums.users.UserRole;
import com.example.common.enums.users.UserStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

public record UserRequest(
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
        String password,
        Belts belts,
        UserRole userRole,
        UserStatus userStatus
) {
}
