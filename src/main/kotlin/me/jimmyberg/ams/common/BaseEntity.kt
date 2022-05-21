package me.jimmyberg.ams.common

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.Column

open class BaseEntity(
    @Column(name = "CREATED")
    @CreatedDate
    val created: LocalDateTime? = null,
    @Column(name = "UPDATED")
    @LastModifiedDate
    val updated: LocalDateTime? = null
)