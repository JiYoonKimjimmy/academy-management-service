package me.jimmyberg.ams.parents

import com.fasterxml.jackson.annotation.JsonBackReference
import me.jimmyberg.ams.common.BaseEntity
import me.jimmyberg.ams.student.Student
import javax.persistence.*

@Entity
@Table(name = "PARENTS")
class Parents(

    @Id
    @Column(name = "ID")
    val id: Int,
    @Column(name = "NAME")
    val name: String,
    @Column(name = "MOBILE_NUMBER")
    val mobileNumber: String,
    @Column(name = "GENDER")
    val gender: Char,
    @Column(name = "STATUS")
    val status: String = "ACTIVE",

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STUDENT_ID")
    val student: Student? = null

) : BaseEntity()