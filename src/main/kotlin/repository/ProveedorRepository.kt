package org.example.repository

import utils.HibernateUtils
import jakarta.persistence.EntityManager
import org.example.model.Producto
import org.example.model.Proveedor

class ProveedorRepository{
    private fun getEntityManager(): EntityManager {
        return HibernateUtils.getEntityManager("unidadMySQL")
    }

    fun getProveedorProducto(idProducto:String){
        val em = getEntityManager()
        em.transaction.begin()
        val producto = em.find(Producto::class.java, idProducto)
        em.close()
        println(producto.proveedor)
    }

    fun getTodosProveedores(){
        val em = getEntityManager()
        em.transaction.begin()
        val q = em.createQuery("FROM Proveedor", Proveedor::class.java)
        val listaProveedor = q.resultList
        listaProveedor.forEach {
            println(it)
        }
    }
}