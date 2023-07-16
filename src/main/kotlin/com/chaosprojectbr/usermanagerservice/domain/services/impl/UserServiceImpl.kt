package com.chaosprojectbr.usermanagerservice.domain.services.impl

import com.chaosprojectbr.usermanagerservice.application.payloads.request.UserRequest
import com.chaosprojectbr.usermanagerservice.domain.entities.User
import com.chaosprojectbr.usermanagerservice.domain.exceptions.UserAlreadyExistsException
import com.chaosprojectbr.usermanagerservice.domain.repositories.UserRepository
import com.chaosprojectbr.usermanagerservice.domain.services.UserService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
) : UserService {

    override fun create(userRequest: UserRequest): User {
        userRepository.findUserByEmail(userRequest.email).ifPresent {
            logger.error("E-mail to user=${it.name} already registered!")
            throw UserAlreadyExistsException()
        }

        return userRepository.save(
            User(
                userRequest
            )
        ).also {
            logger.info("User=${it.name} is registered with success!!!")
        }
    }

    companion object {
        val logger: Logger = LoggerFactory.getLogger(UserService::class.java)
    }
}