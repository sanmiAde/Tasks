package com.devsanmiaderibigbe.tasks.data.remote

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import io.reactivex.Maybe
import io.reactivex.MaybeEmitter

object RxAuth {

    fun createUser(firebaseAuth : FirebaseAuth, email : String, password : String): Maybe<AuthResult> {
        return Maybe.create<AuthResult> {emitter: MaybeEmitter<AuthResult> ->
            firebaseAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {
                if (!emitter.isDisposed) {
                    emitter.onSuccess(it)
                }

            }.addOnFailureListener {
                if (!emitter.isDisposed){
                    emitter.onError(it)
                }

            }.addOnCompleteListener{
                if (!emitter.isDisposed) {
                    emitter.onComplete()
                }
            }

        }
    }
}