package com.skopisjiwa.presentation.user.login

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.skopisjiwa.utils.Resource
import com.skopisjiwa.utils.USER
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    fun login(
        firestore: FirebaseFirestore,
        email : String,
        password : String,
        successToast : () -> Unit,
        failureToast : () -> Unit,
    ) {
        firestore.collection(USER)
            .whereEqualTo("email", email)
            .whereEqualTo("password", password)
            .get()
            .addOnSuccessListener {
                successToast()
            }
            .addOnFailureListener {
                failureToast()
            }
    }
}