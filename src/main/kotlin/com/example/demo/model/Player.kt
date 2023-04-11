package com.example.demo.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "tb_player")
data class Player(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long,
    val name: String,
    val age: Int,
    val nationality: String
) {
    constructor() : this(0, "", 0, "")
}