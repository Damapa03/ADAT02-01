package org.example.model

import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "productos")
class Producto(
    @Id
    val id: String,
    @Column(nullable = false, length = 10)
    val categoria: String,
    @Column(nullable = false, length = 50)
    var nombre: String,
    @Column
    val descripcion: String,
    @Column(nullable = false)
    val precio_sin_iva: Double,
    @Column(nullable = false)
    val precio_con_iva: Double,
    @Column(nullable = false)
    val fecha_alta: Date,
    @Column(nullable = false)
    var stock: Int,
    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    val proveedor: Proveedor?
) {
    override fun toString(): String {
        return "Id: $id, categoria: $categoria, nombre: $nombre, descripccion: $descripcion, precio sin iva: $precio_sin_iva, precio con iva: $precio_con_iva, fecha_alta: $fecha_alta, stock: $stock, proveedor: $proveedor"
    }
}