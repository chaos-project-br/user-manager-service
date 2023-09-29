package com.chaosprojectbr.usermanagerservice.application.web.controllers

import com.chaosprojectbr.usermanagerservice.application.payloads.request.UserRequest
import com.chaosprojectbr.usermanagerservice.application.payloads.response.UserResponse
import com.chaosprojectbr.usermanagerservice.domain.services.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(
    private val userService: UserService
) {
    @PostMapping
    fun create(@RequestBody userRequest: UserRequest): ResponseEntity<UserResponse> {
        return ResponseEntity(UserResponse(userService.create(userRequest)), HttpStatus.CREATED)
    }

    @GetMapping
    fun findByEmailAndPassword(
        @RequestParam email: String,
        @RequestParam password: String
    ): ResponseEntity<UserResponse> {
        return ResponseEntity(
            userService.findByEmailAndPassword(email, password)?.let { UserResponse(it) },
            HttpStatus.OK
        )
    }
}