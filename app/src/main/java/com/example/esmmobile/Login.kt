package com.example.esmmobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.esmmobile.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class Login : AppCompatActivity() {

    private lateinit var dbRef : DatabaseReference
    private lateinit var auth : FirebaseAuth
    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

//        auth = FirebaseAuth.getInstance()
//        dbRef = FirebaseDatabase.getInstance().getReference("UserData")
//        dbRef.addValueEventListener(object : ValueEventListener{
//            override fun onDataChange(snapshot: DataSnapshot) {
//                snapshot.children.forEach{
//                    loginInfo = it.getValue(LoginInfo::class.java)!!
//                }
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                Log.d("LoginInfoError", error.toString())
//            }
//
//        })

//        binding.login.setOnClickListener {
//            val matricNo = binding.matricNo.text
//            val password = binding.loginPassword.text
//
//            //Authenticating user and sign in.
//            if (matricNo != null && password != null) {
//                if (matricNo.toString() == loginInfo.matricNo && password.toString() == loginInfo.password) {
//                    auth.signInWithEmailAndPassword(loginInfo.email, loginInfo.password)
//                        .addOnSuccessListener {
//                            startActivity(Intent(this, MainActivity::class.java))
//                            finish()
//                        }
//                }
//                else {
//                    Toast.makeText(this, "User does not Exist!", Toast.LENGTH_SHORT)
//                        .show()
//                }
//            }
//            else {
//                Toast.makeText(this, "Fill in required fields", Toast.LENGTH_SHORT)
//                    .show()
//            }
//        }
    }

}