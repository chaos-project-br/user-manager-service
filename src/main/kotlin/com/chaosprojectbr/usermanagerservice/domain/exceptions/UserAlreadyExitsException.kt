package com.chaosprojectbr.usermanagerservice.domain.exceptions

import org.springframework.http.HttpStatus

class UserAlreadyExistsException(
    reason: String = "User already exists!"
) : ApiException(reason = reason, httpStatus = HttpStatus.BAD_REQUEST)