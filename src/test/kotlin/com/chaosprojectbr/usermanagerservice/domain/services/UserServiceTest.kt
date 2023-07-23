package com.chaosprojectbr.usermanagerservice.domain.services

import com.chaosprojectbr.usermanagerservice.domain.exceptions.UserAlreadyExistsException
import com.chaosprojectbr.usermanagerservice.domain.factories.UserFactory
import com.chaosprojectbr.usermanagerservice.domain.factories.UserRequestFactory
import com.chaosprojectbr.usermanagerservice.domain.repositories.UserRepository
import com.chaosprojectbr.usermanagerservice.domain.services.impl.UserServiceImpl
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.*

class UserServiceTest {

    private val userRepository = mockk<UserRepository>()

    private val service = UserServiceImpl(
        userRepository = userRepository
    )

    @BeforeEach
    fun init() {
        clearAllMocks()
    }

    @Test
    fun `it should be registered an user`() {
        val mockUserRequest = UserRequestFactory.sample()
        val mockUser = UserFactory.sample()

        every {
            userRepository.findUserByEmail(any())
        } returns Optional.empty()

        every {
            userRepository.save(any())
        } returns mockUser

        service.create(mockUserRequest)

        verify(exactly = 1) {
            userRepository.findUserByEmail(any())
            userRepository.save(any())
        }
    }

    @Test
    fun `it should throw user already exist exception`() {
        val mockUser = UserFactory.sample()
        val mockUserRequest = UserRequestFactory.sample()

        every {
            userRepository.findUserByEmail(any())
        } returns Optional.of(mockUser)

        assertThrows<UserAlreadyExistsException> {
            service.create(mockUserRequest)
        }
    }
}