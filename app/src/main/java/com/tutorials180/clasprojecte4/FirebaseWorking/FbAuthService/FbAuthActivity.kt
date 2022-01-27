package com.tutorials180.clasprojecte4.FirebaseWorking.FbAuthService

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.tutorials180.clasprojecte4.R
import java.lang.Exception

class FbAuthActivity : AppCompatActivity()
{
    private lateinit var mFirebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fb_auth)

        mFirebaseAuth = Firebase.auth
    }

    private fun createUser()
    {
        try
        {
            mFirebaseAuth.createUserWithEmailAndPassword("farrukh@yahoo.com","12345678")
                .addOnCompleteListener {
                    if(it.isSuccessful)
                    {
                        Toast.makeText(applicationContext, "User is registered", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(applicationContext, "${it.exception?.message}", Toast.LENGTH_SHORT).show();
                    }
                }
        }
        catch (ex:Exception)
        {
            Toast.makeText(applicationContext, "${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }
}