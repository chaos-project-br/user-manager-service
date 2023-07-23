package com.chaosprojectbr.usermanagerservice.domain.repositories

import com.chaosprojectbr.usermanagerservice.domain.entities.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : MongoRepository<User, UUID> {
    fun findUserByEmail(email: String): Optional<User>
}