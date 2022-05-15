package me.jimmyberg.ams.student

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "STUDENTS")
class Student(
    @Id
    @Column(name = "ID")
    val id: Int,
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
    val status: String,
    @Column(name = "CREATED")
    val created: LocalDateTime,
    @Column(name = "UPDATED")
    val updated: LocalDateTime
)