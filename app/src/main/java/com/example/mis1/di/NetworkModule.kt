package com.example.mis1.di

import android.annotation.SuppressLint
import com.example.mis1.common.AuthInterceptor
import com.example.mis1.common.Constants
import com.example.mis1.data.TokenManager
import com.example.mis1.data.remote.equipment.EquipmentApi
import com.example.mis1.data.remote.inventory.InventoryApi
import com.example.mis1.data.remote.machine.MachineApi
import com.example.mis1.data.remote.user.UserApi
import com.example.mis1.repository.EquipmentRepository
import com.example.mis1.repository.InventoryRepository
import com.example.mis1.repository.MachineRepository
import com.example.mis1.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule{
    @Provides
    @Singleton
    fun provideAuthInterceptor(
        tokenManager: TokenManager
    ):AuthInterceptor{
        return AuthInterceptor(tokenManager)
    }

//    @Provides
//    @Singleton
//    fun provideOkHttpClient(
//        authInterceptor: AuthInterceptor
//    ): OkHttpClient {
//        return OkHttpClient
//            .Builder()
//            .addInterceptor(authInterceptor)
//            .build()
//    }

    @Provides
    @Singleton
    fun providesOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
        val trustAllCerts = arrayOf<TrustManager>(
            @SuppressLint("CustomX509TrustManager")
            object : X509TrustManager {
                override fun getAcceptedIssuers(): Array<java.security.cert.X509Certificate> {
                    return arrayOf()
                }

                @SuppressLint("TrustAllX509TrustManager")
                override fun checkClientTrusted(
                    certs: Array<java.security.cert.X509Certificate>, authType: String) {
                }

                @SuppressLint("TrustAllX509TrustManager")
                override fun checkServerTrusted(
                    certs: Array<java.security.cert.X509Certificate>, authType: String) {
                }
            }
        )

        val sslContext = SSLContext.getInstance("SSL").apply {
            init(null, trustAllCerts, java.security.SecureRandom())
        }

        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .addInterceptor(authInterceptor)
            .sslSocketFactory(sslContext.socketFactory, trustAllCerts[0] as X509TrustManager)
            .hostnameVerifier { _, _ -> true }
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit
            .Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
    }

    @Provides
    @Singleton
    fun provideUserRepository(
        retrofit: Retrofit,
    ): UserRepository {
        val api  = retrofit.create(UserApi::class.java)
        return UserRepository(api)
    }

    @Provides
    @Singleton
    fun provideInventoryRepository(
        retrofit: Retrofit,
    ): InventoryRepository {
        val api  = retrofit.create(InventoryApi::class.java)
        return InventoryRepository(api)
    }

    @Provides
    @Singleton
    fun provideMachineRepository(
        retrofit: Retrofit,
    ): MachineRepository {
        val api  = retrofit.create(MachineApi::class.java)
        return MachineRepository(api)
    }

    @Provides
    @Singleton
    fun provideEquipmentRepository(
        retrofit: Retrofit,
    ): EquipmentRepository {
        val api  = retrofit.create(EquipmentApi::class.java)
        return EquipmentRepository(api)
    }
}