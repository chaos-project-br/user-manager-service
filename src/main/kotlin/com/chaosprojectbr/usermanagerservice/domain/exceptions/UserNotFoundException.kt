package com.chaosprojectbr.usermanagerservice.domain.exceptions

import org.springframework.http.HttpStatus

class UserNotFoundException(
    reason: String = "User not found!"
) : ApiException(httpStatus = HttpStatus.NOT_FOUND, reason = reason)