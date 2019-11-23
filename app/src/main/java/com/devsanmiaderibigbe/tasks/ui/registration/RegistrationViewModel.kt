package com.devsanmiaderibigbe.tasks.ui.registration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.devsanmiaderibigbe.tasks.data.remote.Resource
import com.devsanmiaderibigbe.tasks.data.repo.FirebaseRepositoryImp
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


class RegistrationViewModel @Inject constructor(val firebaseRepositoryImp: FirebaseRepositoryImp) {

    private val compositeDisposable = CompositeDisposable()
    private val _registrationStatus = MutableLiveData<Resource<Boolean>>()

    val registrationState: LiveData<Resource<Boolean>>
        get() {
            return _registrationStatus
        }

    fun createNewUser(email: String, password: String) {
        _registrationStatus.value = Resource.loading()
        compositeDisposable.add(firebaseRepositoryImp
            .signUp(email, password)
            .map { authResult ->
                authResult.user != null
            }.subscribe({
                _registrationStatus.value = Resource.success(it)

            }, {
                _registrationStatus.value = Resource.error(it.localizedMessage, false)

            })
        )
    }
}