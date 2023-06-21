package com.skopisjiwa.presentation.user.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.skopisjiwa.R
import com.skopisjiwa.databinding.FragmentLoginBinding
import com.skopisjiwa.presentation.user.home.HomeActivity
import com.skopisjiwa.utils.USER
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LoginViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.btnLogin.setOnClickListener {
            loginUser()
        }
    }

    private fun loginUser() {
        with(binding) {
            val email = edtEmailUsername.text?.trim().toString()
            val password = edtPassword.text?.trim().toString()

            when {
                email.isEmpty() -> edtEmailUsername.error = "Field is required"
                password.isEmpty() -> edtPassword.error = "Field is Required"
                password.length < 6 -> edtPassword.error = "Minimal 6 characters"
                else -> login(email, password)
            }
        }
    }

    private fun login(email: String, password: String) {
        viewModel.login(Firebase.firestore, email, password,
            successToast = {
//            ambil dan cek rol data user
                val userDocRef = Firebase.firestore.collection(USER).whereEqualTo("email", email)
                userDocRef.get()
                    .addOnSuccessListener { querySnapshot ->
                        if (!querySnapshot.isEmpty) {
                            val document = querySnapshot.documents[0]
                            val role = document.getLong("roleId")
                            if (role == 1L) {
                                Toast.makeText(
                                    requireContext(),
                                    "Login berhasil As Admin",
                                    Toast.LENGTH_SHORT
                                ).show()
//                                put roleId with argument
//                                val action =
//                                    LoginFragmentDirections.actionLoginFragmentToHomeActivity(role)
//                                findNavController().navigate(action)
                                val intent = Intent(requireContext(), HomeActivity::class.java)
                                intent.putExtra("roleId", role)
                                startActivity(intent)
                            } else {
                                Toast.makeText(
                                    requireContext(),
                                    "Login berhasil",
                                    Toast.LENGTH_SHORT
                                ).show()
//                                findNavController().navigate(R.id.action_loginFragment_to_homeActivity)
                                val intent = Intent(requireContext(), HomeActivity::class.java)
                                intent.putExtra("roleId", role)
                                startActivity(intent)
                            }
                        }
                    }
            }, failureToast = {
                Toast.makeText(
                    requireContext(),
                    "email atau password anda salah",
                    Toast.LENGTH_SHORT
                ).show()
            })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }


}