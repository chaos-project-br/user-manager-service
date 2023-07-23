package com.chaosprojectbr.usermanagerservice.domain.factories

import com.chaosprojectbr.usermanagerservice.application.payloads.request.UserRequest

object UserRequestFactory {
    fun sample() = UserRequest(
        name = "valid_name",
        surname = "valid_surname",
        email = "valid_mail@mail.com",
        nickname = "valid_nickname",
        password = "valid_password"
    )
}