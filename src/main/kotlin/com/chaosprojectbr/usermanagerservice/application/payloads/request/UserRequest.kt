package com.chaosprojectbr.usermanagerservice.application.payloads.request

data class UserRequest(
    val name: String,
    val surname: String,
    val email: String,
    val nickname: String,
    val password: String
)