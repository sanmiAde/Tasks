package com.devsanmiaderibigbe.tasks.di.component

import com.devsanmiaderibigbe.tasks.di.scope.ActivityScope
import com.devsanmiaderibigbe.tasks.di.scope.FragmentScope
import com.devsanmiaderibigbe.tasks.ui.login.LoginFragment
import dagger.Subcomponent

@FragmentScope
@Subcomponent
interface LoginComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create() : LoginComponent
    }

    fun inject(loginFragment: LoginFragment)
}