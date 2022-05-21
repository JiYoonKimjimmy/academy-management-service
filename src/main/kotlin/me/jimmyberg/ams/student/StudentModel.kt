package me.jimmyberg.ams.student

data class StudentModel(
    val id: Long,
    val name: String,
    val mobileNumber: String,
    val dateOfBirth: String,
    val gender: Char,
    val school: String,
    val grade: Char,
    val status: String
)