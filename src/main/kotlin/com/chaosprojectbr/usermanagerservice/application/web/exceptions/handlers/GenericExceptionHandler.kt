package com.chaosprojectbr.usermanagerservice.application.web.exceptions.handlers

import com.chaosprojectbr.usermanagerservice.domain.exceptions.ApiException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@RestControllerAdvice
class GenericExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(Exception::class)
    fun handleAllExceptions(ex: ApiException): ResponseEntity<ExceptionResponse> {
        Companion.logger.error(ex.message)
        val exceptionResponse = ExceptionResponse(message = ex.reason)
        return ResponseEntity<ExceptionResponse>(exceptionResponse, ex.statusCode)
    }

    companion object {
        val logger: Logger = LoggerFactory.getLogger(GenericExceptionHandler::class.java)
    }
}