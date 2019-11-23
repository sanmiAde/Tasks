package com.devsanmiaderibigbe.tasks

import android.app.Application
import com.devsanmiaderibigbe.tasks.di.component.DaggerAppComponent

class MyApplicatoin : Application() {

    val appComponent by lazy {
        DaggerAppComponent.factory().create(this)
    }
}