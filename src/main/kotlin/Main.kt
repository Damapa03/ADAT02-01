package org.example

import org.example.repository.ProductoRepository
import org.example.repository.ProveedorRepository
import org.example.repository.UsuarioRepository

fun main() {
    val usuarioRepository = UsuarioRepository()
    val proveedorRepository = ProveedorRepository()
    val productoRepository = ProductoRepository()
    var flag = true
    var idProducto = ""


    print("Bienvenido a la aplicacion de gestion de productos y proveedores")
    println("Por favor incie sesion \n\t Introduce el usuario:")
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

                    } else if (seleccion == 2) {

                    } else if (seleccion == 3) {

                    } else if (seleccion == 4) {

                    } else if (seleccion == 5) {
                        println("Introduce la id del producto del proveedor")
                        idProducto = readln()
                        println(productoRepository.getProducto(idProducto))
                    } else if (seleccion == 6) {

                    } else if (seleccion == 7) {

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
