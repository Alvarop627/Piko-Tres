package com.pikotres.app.utils

import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

class ApiConnectionConstants {
    companion object {
        const val BASE_URL = "https://piko-tres.com/"
        const val API_KEY = "example"
        const val PRIVATE_KEY = "example"
        val timeStamp = Timestamp(System.currentTimeMillis()).time.toString()

        fun hash(): String {
            val input = "$timeStamp$PRIVATE_KEY$API_KEY"
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
        }
    }
}