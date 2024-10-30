package org.example.model

import jakarta.persistence.*

@Entity
@Table(name = "usuarios")
class Usuario(
    @Id
    val nombre_usuario: String,
    @Column(nullable = false, length = 20)
    val password: String
) {
}