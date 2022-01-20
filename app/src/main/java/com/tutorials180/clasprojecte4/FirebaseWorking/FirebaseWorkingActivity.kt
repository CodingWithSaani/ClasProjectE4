package com.tutorials180.clasprojecte4.FirebaseWorking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.tutorials180.clasprojecte4.R
import com.tutorials180.clasprojecte4.databinding.ActivityFirebaseWorkingBinding

class FirebaseWorkingActivity : AppCompatActivity()
{
    private lateinit var mFBWBinding:ActivityFirebaseWorkingBinding
    private lateinit var mFirebaseFireStore:FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFBWBinding= ActivityFirebaseWorkingBinding.inflate(layoutInflater)

        setContentView(mFBWBinding.root)
        //mFirebaseFireStore= FirebaseFirestore.getInstance()
        mFirebaseFireStore= Firebase.firestore
    }
}