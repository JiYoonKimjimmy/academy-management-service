package me.jimmyberg.ams.student

import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository: JpaRepository<Student, Int>