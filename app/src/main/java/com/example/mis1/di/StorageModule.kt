package com.example.mis1.di

import android.content.Context
import android.content.SharedPreferences
import com.example.mis1.common.Constants
import com.example.mis1.repository.SettingsRepository
import com.example.mis1.repository.TokenRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class StorageModule {
    @Provides
    @Singleton
    fun provideSharedPreferences( @ApplicationContext  context: Context):SharedPreferences{
        return context.getSharedPreferences(Constants.SHARED_PREFS_NAME,Context.MODE_PRIVATE)
    }
    @Provides
    @Singleton
    fun provideTokenRepository(sharedPreferences: SharedPreferences): TokenRepository {
        return TokenRepository(sharedPreferences)
    }
    @Provides
    @Singleton
    fun provideSettingsRepository(sharedPreferences: SharedPreferences): SettingsRepository {
        return SettingsRepository(sharedPreferences)
    }
}