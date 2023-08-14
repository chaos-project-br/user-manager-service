package com.chaosprojectbr.usermanagerservice.application.web.controllers

import com.chaosprojectbr.usermanagerservice.application.payloads.request.UserRequest
import com.chaosprojectbr.usermanagerservice.application.payloads.response.UserResponse
import com.chaosprojectbr.usermanagerservice.domain.services.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(
    private val userService: UserService
) {
    @PostMapping
    fun create(@RequestBody userRequest: UserRequest): ResponseEntity<UserResponse> {
        return ResponseEntity(UserResponse(userService.create(userRequest)), HttpStatus.CREATED)
    }
}