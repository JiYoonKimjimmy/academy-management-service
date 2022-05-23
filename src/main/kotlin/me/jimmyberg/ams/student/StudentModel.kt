package me.jimmyberg.ams.student

data class StudentModel(
    val id: Int,
    val name: String,
    val mobileNumber: String,
    val dateOfBirth: String,
    val gender: Char,
    val school: String,
    val grade: Char,
    val status: String
) {
    companion object {
        fun of(student: Student) =
            StudentModel(
                id = student.id,
                name = student.name,
                mobileNumber = student.mobileNumber,
                dateOfBirth = student.dateOfBirth,
                gender = student.gender,
                school = student.school,
                grade = student.grade,
                status = student.status
            )
    }
}