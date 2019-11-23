package com.devsanmiaderibigbe.tasks.di.module

import com.devsanmiaderibigbe.tasks.data.repo.FirebaseRepository
import com.devsanmiaderibigbe.tasks.data.repo.FirebaseRepositoryImp
import com.devsanmiaderibigbe.tasks.di.scope.ActivityScope
import com.devsanmiaderibigbe.tasks.di.scope.ApplicationScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @ApplicationScope
    @Binds
    abstract fun providesFirebaseRepository(firebaseRepository: FirebaseRepositoryImp) : FirebaseRepository


}