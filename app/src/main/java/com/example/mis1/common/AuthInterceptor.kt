package com.example.mis1.common

import com.example.mis1.repository.TokenRepository
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException


class AuthInterceptor(private val tokenRepository: TokenRepository) : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest: Request = chain.request()
        val token = tokenRepository.token
        if (token != null) {
            val builder: Request.Builder = originalRequest.newBuilder()
                .header("Authorization", "Bearer $token")
            val newRequest: Request = builder.build()
            return chain.proceed(newRequest)
        }
        return chain.proceed(originalRequest)
    }
}

