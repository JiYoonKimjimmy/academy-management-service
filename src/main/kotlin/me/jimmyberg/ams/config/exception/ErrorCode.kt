package me.jimmyberg.ams.config.exception

enum class ErrorCode(
    val code: String,
    val message: String
) {

    NOT_FOUND_STUDENT("001", "Student not found")

}