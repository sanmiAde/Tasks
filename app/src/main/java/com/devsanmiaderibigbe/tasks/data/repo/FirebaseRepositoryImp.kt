package com.devsanmiaderibigbe.tasks.data.repo

import com.devsanmiaderibigbe.tasks.data.remote.RxAuth
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import durdinapps.rxfirebase2.RxFirebaseAuth
import io.reactivex.Maybe
import javax.inject.Inject

class FirebaseRepositoryImp @Inject constructor(
    val firebaseDatabase: FirebaseDatabase,
    val firebaseAuth: FirebaseAuth
) : FirebaseRepository {
    override val isLoggedIn: Boolean
        get() = firebaseAuth.currentUser != null


    override fun signOut() {

    }


    override fun login(email: String, password: String): Maybe<AuthResult> {
        return RxFirebaseAuth.signInWithEmailAndPassword(firebaseAuth, email, password)
    }

    override fun signUp(email: String, password: String): Maybe<AuthResult> {
        return RxFirebaseAuth.createUserWithEmailAndPassword(firebaseAuth, email, password)
    }


}