package com.chaosprojectbr.usermanagerservice.domain.services.impl

import com.chaosprojectbr.usermanagerservice.application.payloads.request.UserRequest
import com.chaosprojectbr.usermanagerservice.domain.entities.User
import com.chaosprojectbr.usermanagerservice.domain.exceptions.UserAlreadyExistsException
import com.chaosprojectbr.usermanagerservice.domain.exceptions.UserNotFoundException
import com.chaosprojectbr.usermanagerservice.domain.repositories.UserRepository
import com.chaosprojectbr.usermanagerservice.domain.services.UserService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.security.crypto.bcrypt.BCrypt
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
) : UserService {

    override fun create(userRequest: UserRequest): User {
        userRepository.findByEmail(userRequest.email).ifPresent {
            logger.error("E-mail to user=${it.name} already registered!")
            throw UserAlreadyExistsException()
        }
        return userRepository.save(
            User(
                userRequest.copy(password = BCrypt.hashpw(userRequest.password, BCrypt.gensalt(12)))
            )
        ).also {
            logger.info("User=${it.name} is registered with success!!!")
        }
    }

    override fun findByEmailAndPassword(email: String, password: String): User? {
        logger.info("Finding user with email=$email and password=$password")
        val user = userRepository.findByEmail(email).orElseThrow { UserNotFoundException() }
        if (!BCrypt.checkpw(password, user.password)) throw UserNotFoundException()
        return user
    }


    companion object {
        val logger: Logger = LoggerFactory.getLogger(UserService::class.java)
    }
}