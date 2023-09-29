package com.chaosprojectbr.usermanagerservice.application.payloads.response

import com.chaosprojectbr.usermanagerservice.domain.entities.User
import java.time.LocalDateTime

data class UserResponse(
    val name: String,
    val surname: String,
    val email: String,
    val nickname: String,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?
) {
    constructor(user: User) : this(
        name = user.name,
        surname = user.surname,
        email = user.email,
        nickname = user.nickname,
        createdAt = user.createdAt,
        updatedAt = user.updatedAt
    )
}