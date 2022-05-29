package me.jimmyberg.ams.student

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import me.jimmyberg.ams.common.PageableModel
import org.springframework.data.domain.Page

@ApiModel("학생 정보")
data class StudentModel(
    @ApiModelProperty( "학생 ID", required = true)
    val id: Int,
    @ApiModelProperty("학생 명", required = true)
    val name: String,
    @ApiModelProperty("휴대폰 번호", required = true)
    val mobileNumber: String,
    @ApiModelProperty("생년 월일", required = true)
    val dateOfBirth: String,
    @ApiModelProperty("성별", required = true)
    val gender: Char,
    @ApiModelProperty("학교", required = true)
    val school: String,
    @ApiModelProperty("학년", required = true)
    val grade: Char,
    @ApiModelProperty("상태", required = true)
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

@ApiModel("학생 단건 조회 응답 정보")
data class FindStudentResponse(
    @ApiModelProperty("학생 정보", required = true)
    val student: StudentModel
)
@ApiModel("학생 다건 조회 응답 정보")
data class FindStudentsResponse(
    override val number: Int,
    override val size: Int,
    override val numberOfElements: Int,
    override val totalPages: Int,
    override val totalElements: Long,
    override val first: Boolean,
    override val last: Boolean,
    override val empty: Boolean,
    override val content: List<StudentModel>
) : PageableModel<StudentModel>() {
    companion object {
        fun of(pageable: Page<StudentModel>) = PageableModel(pageable)
    }
}