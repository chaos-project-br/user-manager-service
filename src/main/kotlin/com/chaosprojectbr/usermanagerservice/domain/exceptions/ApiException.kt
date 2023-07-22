package com.chaosprojectbr.usermanagerservice.domain.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

abstract class ApiException(
    httpStatus: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
    reason: String
) : ResponseStatusException(httpStatus, reason)