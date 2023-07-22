package com.doctores.doctores.domains.responses


data class ErrorResponse(
    val error: String
)
sealed class Result<out T>
data class Success<out T>(val data: T) : Result<T>()
data class Failure(val error: String) : Result<Nothing>()
