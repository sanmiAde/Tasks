package com.devsanmiaderibigbe.tasks.data.repo

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.devsanmiaderibigbe.tasks.TestUtil
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
import com.nhaarman.mockito_kotlin.*
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.internal.configuration.MockAnnotationProcessor
import org.mockito.junit.MockitoJUnitRunner
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class FirebaseRepositoryImpTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var firebaseDatabase: FirebaseDatabase

    @Mock
    lateinit var firebaseAuth: FirebaseAuth

    @Mock
    lateinit var authResultTask: Task<AuthResult>

    @Mock
    lateinit var authResult: AuthResult

    @Mock
    lateinit var firebaseUser: FirebaseUser

    private lateinit var firebaseRepositoryImp: FirebaseRepositoryImp


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        this.firebaseRepositoryImp = FirebaseRepositoryImp(firebaseDatabase, firebaseAuth)

        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setNewThreadSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }

    }

    @Test
    fun signUp_whenUserCreateAccount_UserAccountIsCreatedSuccessfully() {
        val onSuccessListenerCaptor: KArgumentCaptor<OnSuccessListener<AuthResult>> =
            argumentCaptor()

        val onCompleteListenerCaptor: KArgumentCaptor<OnCompleteListener<AuthResult>> =
            argumentCaptor()

        doAnswer {
            val arguement= it.arguments
            arguement.forEach {a->
                print(a)
            }
        }.`when`(object: Task<AuthResult>(){})

        val authTestObserver = firebaseRepositoryImp.signUp(
            TestUtil.getTestUserCrendential().email,
            TestUtil.getTestUserCrendential().password
        ).test()



        verify(firebaseAuth).createUserWithEmailAndPassword(
            TestUtil.getTestUserCrendential().email,
            TestUtil.getTestUserCrendential().password
        )

       // authTestObserver.assertNoErrors()
        //    .assertValueCount(1)
         //   .assertValueSet(Collections.singletonList(authResult)).dispose()
    }

    @After
    fun tearDown() {
    }
}