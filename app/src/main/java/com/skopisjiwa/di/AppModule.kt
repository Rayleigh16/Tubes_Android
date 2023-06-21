package com.skopisjiwa.di

import android.content.Context
import com.google.firebase.firestore.FirebaseFirestore
import com.skopisjiwa.data.repository.admin.AdminRepository
import com.skopisjiwa.data.repository.user.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideContext(@ApplicationContext appContext: Context): Context = appContext

    @Provides
    @Singleton
    fun provideUserRepository() = UserRepository()

    @Provides
    @Singleton
    fun provideAdminRepository(
        firestore: FirebaseFirestore
    ) = AdminRepository(firestore)

    @Provides
    @Singleton
    fun provideFiresStoreDB() = FirebaseFirestore.getInstance()
}