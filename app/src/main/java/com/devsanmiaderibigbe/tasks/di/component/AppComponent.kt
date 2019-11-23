package com.devsanmiaderibigbe.tasks.di.component

import android.app.Application
import com.devsanmiaderibigbe.tasks.di.module.AppModule
import com.devsanmiaderibigbe.tasks.di.module.FirebaseModule
import com.devsanmiaderibigbe.tasks.di.scope.ApplicationScope
import com.devsanmiaderibigbe.tasks.ui.MainActivity
import com.devsanmiaderibigbe.tasks.ui.addtask.AddTaskFragment
import com.devsanmiaderibigbe.tasks.ui.task.HomeFragment
import dagger.BindsInstance
import dagger.Component


@ApplicationScope
@Component(modules = [FirebaseModule::class, AppModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application) : AppComponent
    }

    fun inject(mainActivity: MainActivity)
    fun inject(addTaskFragment: AddTaskFragment)
    fun inject(homeFragment: HomeFragment)

    fun loginComponent() : LoginComponent.Factory
}