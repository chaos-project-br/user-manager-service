package com.chaosprojectbr.usermanagerservice.domain.factories

import com.chaosprojectbr.usermanagerservice.domain.entities.User

object UserFactory {
    fun sample() = User(
        name = "valid_name",
        surname = "valid_surname",
        nickname = "valid_nickname",
        email = "valid_mail@mail.com",
        password = "valid_password"
    )
}