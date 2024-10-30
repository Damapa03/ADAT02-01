package org.example

import org.example.model.Producto
import org.example.model.Proveedor
import org.example.repository.ProductoRepository
import org.example.repository.ProveedorRepository
import org.example.repository.UsuarioRepository
import org.example.service.ProductoService

fun main() {
    val usuarioRepository = UsuarioRepository()
    val proveedorRepository = ProveedorRepository()
    val productoRepository = ProductoRepository()
    val productoService = ProductoService()
    var flag = true
    var idProducto = ""


    println("Bienvenido a la aplicacion de gestion de productos y proveedores")
    println("Por favor inicie sesion \n\t Introduce el usuario:")
    val usuario = readln()
    println("\t -Introduce la contraseña:")
    val contraseña = readln()

    if (usuarioRepository.login(usuario, contraseña)){
        println("\rBienvenido al sistema")
        while (flag) {
            var seleccion = 0
            println("Que deseas realizar: \n\t1. Gestionar Productos \n\t2. Gestionar Proveedores \n\t3. Salir")
            seleccion = readln().toInt()

            if (seleccion == 1) {
                while (true){
                    println("Que quiere hacer con los productos: \n\t1. Dar de alta \n\t2. Dar de baja \n\t3. Modificar el nombre \n\t4. Modificar el stock \n\t5. Buscar producto \n\t6. Buscar productos con stock \n\t7. Buscar productos sin stock \n\t8. Atras")
                    seleccion = readln().toInt()
                    if (seleccion == 1) {
                        println("Introduce el nombre del producto")
                        val nombreProducto = readln()
                        println("Introduce la categoria del producto")
                        val categoria = readln()
                        println("Introduce la descripcion del producto")
                        val descripcion = readln()
                        println("Introduce el precio sin iva del producto")
                        val precioSinIva = readln().toDouble()

                        println("Introduce el id del proveedor")
                        val idProveedor = readln().toLong()
                        println("Introduce el nombre del proveedor")
                        val nombreProveedor = readln()
                        println("Introduce la direccion del proveedor")
                        val direccion = readln()

                        val id = productoService.idCreate(categoria, nombreProducto, nombreProveedor)

                        productoRepository.altaProducto(id, nombreProveedor, categoria, precioSinIva, descripcion, idProveedor, nombreProveedor, direccion)
                    } else if (seleccion == 2) {
                        println("Introduce la id del producto a dar de baja")
                        val id = readln()
                        productoRepository.bajaProducto(id)
                    } else if (seleccion == 3) {
                        println("Introduce la id del producto a modificar")
                        val id = readln()
                        println("Introduce el nuevo nombre del producto")
                        val nombre = readln()
                        productoRepository.modificarNombreProducto(id,nombre)
                    } else if (seleccion == 4) {
                        println("Introduce la id del producto a modificar")
                        val id = readln()
                        println("Introduce el nuevo stock del producto")
                        val stock = readln().toInt()
                        productoRepository.modificarStockProducto(id,stock)
                    } else if (seleccion == 5) {
                        println("Introduce la id del producto del proveedor")
                        idProducto = readln()
                        println(productoRepository.getProducto(idProducto))
                    } else if (seleccion == 6) {
                        productoRepository.getProductosConStock()
                    } else if (seleccion == 7) {
                        productoRepository.getProductosSinStock()
                    } else break
                }

            } else if (seleccion == 2) {
                while (true){
                    println("Que quiere hacer con los proveedores: \n\t1. Obtener proveedor de un producto \n\t2. Obtener todos los proveedores \n\t3. Atras")
                    seleccion = readln().toInt()
                    if (seleccion == 1) {
                        println("Introduce la id del producto del proveedor")
                        idProducto = readln()
                        println(proveedorRepository.getProveedorProducto(idProducto))
                    } else if (seleccion == 2) {
                        proveedorRepository.getTodosProveedores()
                    } else break
                }

            } else flag = false
        }
    }

}
