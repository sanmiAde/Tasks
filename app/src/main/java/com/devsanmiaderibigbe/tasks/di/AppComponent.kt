package com.devsanmiaderibigbe.tasks.di

import android.app.Application
import com.devsanmiaderibigbe.tasks.di.module.FirebaseModule
import dagger.BindsInstance
import dagger.Component


@ApplicationScope
@Component(modules = [FirebaseModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application) :AppComponent
    }
}