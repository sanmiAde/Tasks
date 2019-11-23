package com.devsanmiaderibigbe.tasks.data.repo

import com.google.firebase.auth.AuthResult
import io.reactivex.Maybe

interface FirebaseRepository {

    val isLoggedIn : Boolean

    fun signUp(email : String, password : String): Maybe<AuthResult>

    fun login(email : String , password: String): Maybe<AuthResult>

    fun signOut()
}