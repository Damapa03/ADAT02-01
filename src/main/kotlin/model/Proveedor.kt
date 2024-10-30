package org.example.model

import jakarta.persistence.*

@Entity
@Table(name = "proveedores")
class Proveedor(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    @Column(unique = true, nullable = false, length = 50)
    val nombre: String,
    @Column(nullable = false)
    val direccion: String,
    @OneToMany(mappedBy = "proveedor", cascade = [CascadeType.ALL], orphanRemoval = true)
    val productos: List<Producto>?
) {
    override fun toString(): String {
        return "Id: $id, nombre: $nombre, direccion: $direccion"
    }
}