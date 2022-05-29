package me.jimmyberg.ams.student

import me.jimmyberg.ams.Parents.Parents
import me.jimmyberg.ams.common.BaseEntity
import javax.persistence.*

@Entity
@Table(name = "STUDENTS")
class Student(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    val id: Int? = null,
    @Column(name = "NAME")
    val name: String,
    @Column(name = "MOBILE_NUMBER")
    val mobileNumber: String,
    @Column(name = "DATE_OF_BIRTH")
    val dateOfBirth: String,
    @Column(name = "GENDER")
    val gender: Char,
    @Column(name = "SCHOOL")
    val school: String,
    @Column(name = "GRADE")
    val grade: Char,
    @Column(name = "STATUS")
    val status: String = "ACTIVE",

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val parents: MutableList<Parents> = mutableListOf()

) : BaseEntity() {

    companion object {
        fun of(request: SaveStudentRequest) =
            Student(
                name = request.name,
                mobileNumber = request.mobileNumber,
                dateOfBirth = request.dateOfBirth,
                gender = request.gender,
                school = request.school,
                grade = request.grade
            )
    }

}