package com.devsanmiaderibigbe.tasks

import com.devsanmiaderibigbe.tasks.data.model.User
import com.google.android.gms.tasks.OnFailureListener
import org.mockito.ArgumentCaptor
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import org.mockito.Mockito.`when`
import android.icu.lang.UCharacter.GraphemeClusterBreak.T







object TestUtil {

//    var testOnCompleteListener: ArgumentCaptor<OnCompleteListener> =
//        ArgumentCaptor.forClass(OnCompleteListener::class.java)
//    var testOnSuccessListener: ArgumentCaptor<OnSuccessListener<*>> =
//        ArgumentCaptor.forClass(OnSuccessListener::class.java)
//    var testOnFailureListener = ArgumentCaptor.forClass(OnFailureListener::class.java)

    fun getTestUserCrendential(): User {
        return User("test@gmail.com", "1234")
    }

//    fun <T> setupTask(task: Task<T>) {
//        `when`(task.addOnCompleteListener(testOnCompleteListener.capture())).thenReturn(task)
//        `when`(task.addOnSuccessListener(testOnSuccessListener.capture())).thenReturn(task)
//        `when`(task.addOnFailureListener(testOnFailureListener.capture())).thenReturn(task)
//    }
}