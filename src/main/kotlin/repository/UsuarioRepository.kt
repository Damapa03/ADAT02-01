package org.example.repository

import utils.HibernateUtils
import jakarta.persistence.EntityManager
import org.example.model.Producto
import org.example.model.Usuario

class UsuarioRepository {

    private fun getEntityManager(): EntityManager {
        return HibernateUtils.getEntityManager("unidadMySQL")
    }
    fun login(userInput:String, passwordInput:String): Boolean{
        val em = getEntityManager()
        var flag = false
        try {
            val user = em.find(Usuario::class.java, userInput)
            if (user.password == passwordInput) {
                flag = true
            }else print("Contraseña incorrecta")
        } catch (e: Exception) {
            print("Usuario o contraseña incorrecta")
        }
        return flag
    }
}