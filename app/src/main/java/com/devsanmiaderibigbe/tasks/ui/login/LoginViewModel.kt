package com.devsanmiaderibigbe.tasks.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.devsanmiaderibigbe.tasks.data.remote.Resource
import com.devsanmiaderibigbe.tasks.data.repo.FirebaseRepository
import com.devsanmiaderibigbe.tasks.data.repo.FirebaseRepositoryImp
import com.devsanmiaderibigbe.tasks.di.scope.ActivityScope
import com.devsanmiaderibigbe.tasks.di.scope.FragmentScope
import com.devsanmiaderibigbe.tasks.ui.common.Authentication
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@ActivityScope
class LoginViewModel @Inject constructor(val firebaseRepositoryImp: FirebaseRepository) {

    private val compositeDisposable = CompositeDisposable()

    private val _loginStatus = MutableLiveData<Resource<Authentication>>()

    init {
        when (firebaseRepositoryImp.isLoggedIn){
            true -> _loginStatus.value = Resource.loaded(Authentication.AUTHENTICATED)
            false -> _loginStatus.value = Resource.loaded(Authentication.UNAUTHENTICATED)
        }
    }



    val loginStatusLiveData: LiveData<Resource<Authentication>>
        get() {
            return _loginStatus
        }

    fun login(email: String, password: String) {
        _loginStatus.value = Resource.loading()
        compositeDisposable
            .add(firebaseRepositoryImp
                .login(email, password)
                .map { result -> result.user != null }
                .subscribe({
                _loginStatus.value = Resource.success(Authentication.AUTHENTICATED)
                }, {
               _loginStatus.value = Resource.error(it.localizedMessage, Authentication.UNAUTHENTICATED)
                })
            )
    }


}