package com.tutorials180.clasprojecte4.FirebaseWorking.FbAuthService

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.tutorials180.clasprojecte4.R
import com.tutorials180.clasprojecte4.databinding.ActivityFbAuthBinding
import java.lang.Exception

class FbAuthActivity : AppCompatActivity()
{
    private lateinit var mFirebaseAuth: FirebaseAuth
    private lateinit var mFbAuthBinding: ActivityFbAuthBinding

    private lateinit var mProgressDialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFbAuthBinding = ActivityFbAuthBinding.inflate(layoutInflater)

        setContentView(mFbAuthBinding.root)
        mFirebaseAuth = Firebase.auth

        mProgressDialog = ProgressDialog(this)
        mFbAuthBinding.fbAuthSignUpUserBtn.setOnClickListener {
            if(mFbAuthBinding.fbAuthUserEmailEt.text.isNotBlank() &&
                    mFbAuthBinding.fbAuthUserPasswordEt.text.isNotBlank())
            {
                createUser(mFbAuthBinding.fbAuthUserEmailEt.text.toString(),
                mFbAuthBinding.fbAuthUserPasswordEt.text.toString())
            }
            else
            {
                Toast.makeText(applicationContext, "Please fill all fields", Toast.LENGTH_SHORT).show();
            }
        }

        mFbAuthBinding.fbAuthSignInUserBtn.setOnClickListener {
            if(mFbAuthBinding.fbAuthUserEmailEt.text.isNotBlank() &&
                mFbAuthBinding.fbAuthUserPasswordEt.text.isNotBlank())
            {
                signInUser(mFbAuthBinding.fbAuthUserEmailEt.text.toString(),
                    mFbAuthBinding.fbAuthUserPasswordEt.text.toString())
            }
            else
            {
                Toast.makeText(applicationContext, "Please fill all fields", Toast.LENGTH_SHORT).show();
            }
        }
        mFbAuthBinding.fbAuthSignOutUserBtn.setOnClickListener {
            val currentUser = FirebaseAuth.getInstance().currentUser
            if(currentUser!=null)
            {
                FirebaseAuth.getInstance().signOut()
                Toast.makeText(applicationContext, "User is logged out", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(applicationContext, "Currently !, No user is logged in", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private fun createUser(email:String,password:String)
    {
        try
        {
            mProgressDialog.show()
            mFirebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener {
                    mProgressDialog.dismiss()
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
            mProgressDialog.dismiss()
            Toast.makeText(applicationContext, "${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }

    private fun signInUser(email:String,password:String)
    {
        try
        {
            val currentLoggedInUser = FirebaseAuth.getInstance().currentUser
            mProgressDialog.show()
            if(currentLoggedInUser==null)
            {
                mFirebaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        mProgressDialog.dismiss()
                        if(it.isSuccessful)
                        {
                            Toast.makeText(applicationContext, "User is logged in", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(applicationContext, "${it.exception?.message}", Toast.LENGTH_SHORT).show();
                        }
                    }
            }
            else
            {
                mProgressDialog.dismiss()
                Toast.makeText(applicationContext, "User is already logged in", Toast.LENGTH_SHORT).show();
            }
        }
        catch (ex:Exception)
        {
            mProgressDialog.dismiss()
            Toast.makeText(applicationContext, "${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }










}