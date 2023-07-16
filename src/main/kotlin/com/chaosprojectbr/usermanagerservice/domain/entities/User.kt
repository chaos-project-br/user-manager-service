package com.chaosprojectbr.usermanagerservice.domain.entities

import com.chaosprojectbr.usermanagerservice.application.payloads.request.UserRequest
import org.bson.types.ObjectId
import java.time.LocalDateTime

data class User(
    val _id: ObjectId? = null,
    val name: String,
    val surname: String,
    val nickname: String,
    val email: String,
    val password: String,
    val createdAt: LocalDateTime? = LocalDateTime.now(),
    val updatedAt: LocalDateTime? = LocalDateTime.now()
) {
    constructor(userRequest: UserRequest) : this(
        name = userRequest.name,
        surname = userRequest.surname,
        nickname = userRequest.nickname,
        email = userRequest.email,
        password = userRequest.password,
    )
}