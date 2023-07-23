package com.chaosprojectbr.usermanagerservice.domain.services

import com.chaosprojectbr.usermanagerservice.application.payloads.request.UserRequest
import com.chaosprojectbr.usermanagerservice.domain.entities.User

interface UserService {
    fun create(userRequest: UserRequest): User
}