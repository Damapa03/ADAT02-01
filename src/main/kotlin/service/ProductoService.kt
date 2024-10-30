package org.example.service

import java.time.Instant
import java.util.Date

class ProductoService {
    fun idCreate(categoria: String, nombre:String, proveedor:String): String{
        val id: String = "${categoria.substring(0, 3)}${nombre.substring(0,3)}${proveedor.substring(0,3)}"

        return id
    }
    fun checkCategory(categoria:String): String{
        if (categoria.length <= 50){
        }
            return categoria
    }
    fun checkName(nombre: String): String{
        if (nombre.length <= 50){
        }
            return nombre
    }

    fun calcPrecio_iva(precio_sin_iva: Double): Double{
        val iva =1.21
        val precioIva = precio_sin_iva * iva
        return precioIva
    }

    fun date(): Date{
        val fecha = Date.from(Instant.now())
        return fecha
    }

}