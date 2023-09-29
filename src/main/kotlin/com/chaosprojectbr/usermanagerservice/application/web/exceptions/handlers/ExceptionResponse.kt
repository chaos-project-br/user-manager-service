package com.chaosprojectbr.usermanagerservice.application.web.exceptions.handlers

import java.time.LocalDateTime

data class ExceptionResponse(
    val timestamp: LocalDateTime? = LocalDateTime.now(),
    val message: String?
)