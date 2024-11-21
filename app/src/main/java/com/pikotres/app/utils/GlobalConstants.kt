package com.ejemplo.pruebamarvel.utils

import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

class GlobalConstants {
    companion object {
        const val BASE_URL = "https://gateway.marvel.com/"
        val timeStamp = Timestamp(System.currentTimeMillis()).time.toString()
        const val API_KEY = "9aa2d5c19958ee1e378d637a891ac07f"
        const val PRIVATE_KEY = "0e5a42c64f37a7912f782f3c0e19981298894552"
        const val TEXTO_VACIO = ""
        const val MENSAJE_GENERICO_ERROR =
            "Se ha producido un error. Por favor vuelve a intentarlo más tarde."
        fun hash(): String {
            val input = "$timeStamp$PRIVATE_KEY$API_KEY"
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1,md.digest(input.toByteArray())).toString(16).padStart(32,'0')
        }
    }
}
