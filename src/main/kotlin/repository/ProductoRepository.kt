package org.example.repository

import com.mysql.cj.Query
import utils.HibernateUtils
import jakarta.persistence.EntityManager
import org.example.model.Producto
import org.example.model.Proveedor
import org.example.service.ProductoService
import org.example.service.ProveedorService

class ProductoRepository {
    private fun getEntityManager(): EntityManager {
        return HibernateUtils.getEntityManager("unidadMySQL")
    }
    private val productoService: ProductoService = ProductoService()
    private val proveedorService : ProveedorService = ProveedorService()

    fun altaProducto(
        idProducto: String,
        nombreProducto: String,
        categoria: String,
        precioSinIva: Double,
        descripcionProducto: String,
        idProveedor: Long,
        nombreProveedor: String,
        direccionProducto: String
    ) {
        val categoria = productoService.checkCategory(categoria)
        val nombreProducto = productoService.checkName(nombreProducto)
        val nombreProveedor = proveedorService.checkName(nombreProveedor)
        val idProducto = productoService.idCreate(categoria, nombreProducto, nombreProveedor)
        val precioConIva = productoService.calcPrecio_iva(precioSinIva)
        val fecha = productoService.date()
        val proveedor = Proveedor(idProveedor, nombreProveedor,direccionProducto, null)

        val producto: Producto = Producto(idProducto,categoria,nombreProducto,descripcionProducto,precioSinIva, precioConIva,fecha,1, proveedor)
        val em = getEntityManager()

        try {
            em.transaction.begin()
            em.persist(producto)
            em.transaction.commit()
        } catch (e: Exception) {
            em.transaction.rollback()
        } finally {
            em.close()
        }
    }

    fun bajaProducto(id: String) {
        val em = getEntityManager()
        try {
            val producto = em.find(Producto::class.java, id)
            em.transaction.begin()
            em.remove(producto)
            em.transaction.commit()
        } catch (e: Exception) {
            em.transaction.rollback()
        } finally {
            em.close()
        }

    }

    fun modificarNombreProducto(id: String, nuevoNombre: String) {
        val em = getEntityManager()
        try {
            var producto = em.find(Producto::class.java, id)
            em.transaction.begin()
            producto.nombre = nuevoNombre
            em.transaction.commit()
        } catch (e: Exception) {
            em.transaction.rollback()
        } finally {
            em.close()
        }
    }

    fun modificarStockProducto(id: String, nuevoStock: Int) {
        val em = getEntityManager()
        try {
            var producto = em.find(Producto::class.java, id)
            em.transaction.begin()
            producto.stock = nuevoStock
            em.transaction.commit()
        } catch (e: Exception) {
            em.transaction.rollback()
        } finally {
            em.close()
        }
    }

    fun getProducto(id: String) {
        val em = getEntityManager()
        try {
            val producto = em.find(Producto::class.java, id)
            println(producto.toString())
        } catch (e: Exception) {
            println("Producto no encontrado")
        } finally {
            em.close()
        }
    }

    fun getProductosConStock() {
        val em = getEntityManager()

        try {

        } catch (e: Exception) {
            em.transaction.rollback()
        } finally {
            em.close()
        }
    }

    fun getProductosSinStock() {
        val em = getEntityManager()

        try {

        } catch (e: Exception) {
            em.transaction.rollback()
        } finally {
            em.close()
        }
    }
}