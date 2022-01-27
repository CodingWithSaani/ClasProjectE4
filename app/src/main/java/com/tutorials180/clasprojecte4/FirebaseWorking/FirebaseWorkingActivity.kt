package com.tutorials180.clasprojecte4.FirebaseWorking

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.WriteBatch
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.tutorials180.clasprojecte4.R
import com.tutorials180.clasprojecte4.databinding.ActivityFirebaseWorkingBinding

class FirebaseWorkingActivity : AppCompatActivity()
{
    private lateinit var mFBWBinding:ActivityFirebaseWorkingBinding
    private lateinit var mFirebaseFireStore:FirebaseFirestore

    private lateinit var mProgressDialog: ProgressDialog
    private lateinit var mWriteBatch : WriteBatch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFBWBinding= ActivityFirebaseWorkingBinding.inflate(layoutInflater)

        setContentView(mFBWBinding.root)
        //mFirebaseFireStore= FirebaseFirestore.getInstance()
        mFirebaseFireStore= Firebase.firestore
        mWriteBatch = mFirebaseFireStore.batch()

        mProgressDialog=ProgressDialog(this)
        mProgressDialog.setMessage("Please wait")

        mProgressDialog.setTitle("Network Call")
        mProgressDialog.setCancelable(false)

        mFBWBinding.fbAddSingleDocumentBtn.setOnClickListener {
            addSingleDocument()
        }

        mFBWBinding.fbAddSingleDocumentIdBtn.setOnClickListener {
            addSingleDocumentWithId()
        }

        mFBWBinding.fbGetSingleDocumentIdBtn.setOnClickListener {
            getSingleRecord()
        }

        mFBWBinding.fbGetDocumentsBtn.setOnClickListener {
            getRecords()
        }

        mFBWBinding.fbPerformBatchBtn.setOnClickListener {
            performBatch()
        }
    }


    private fun addSingleDocument()
    {
        try
        {
            mProgressDialog.show()
            var userHashMap=HashMap<String,Any>()
            userHashMap["studname"]="Ali Raza"

            userHashMap["age"]=20;
            userHashMap["address"]="Lahore"

            mFirebaseFireStore.collection("StudentInfo")
                .add(userHashMap)
                .addOnSuccessListener {
                    mProgressDialog.dismiss()
                    Toast.makeText(applicationContext,"Record Inserted",Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {ex->
                    mProgressDialog.dismiss()
                    Toast.makeText(applicationContext,"Record Not Inserted:${ex.message}",Toast.LENGTH_SHORT).show()
                }
        }
        catch(ex:Exception)
        {
            mProgressDialog.dismiss()
            Toast.makeText(applicationContext,ex.message,Toast.LENGTH_SHORT).show()
        }
    }

    private fun addSingleDocumentWithId()
    {
        try
        {
            mProgressDialog.show()
            var userHashMap=HashMap<String,Any>()
            userHashMap["studname"]="Raza Ali"

            userHashMap["age"]=40;
            userHashMap["address"]="Lahore,Pakistan"

            mFirebaseFireStore.collection("StudentInfo")
                .document("razaali")
                .set(userHashMap)
                .addOnSuccessListener {_:Void?->
                    mProgressDialog.dismiss()
                    Toast.makeText(applicationContext,"Record Inserted",Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {ex->
                    mProgressDialog.dismiss()
                    Toast.makeText(applicationContext,"Record Not Inserted:${ex.message}",Toast.LENGTH_SHORT).show()
                }
        }
        catch(ex:Exception)
        {
            mProgressDialog.dismiss()
            Toast.makeText(applicationContext,ex.message,Toast.LENGTH_SHORT).show()
        }
    }

    private fun getSingleRecord()
    {
        try
        {
            mFirebaseFireStore.collection("StudentInfo")
                .document("razaali")
                .get()
                .addOnSuccessListener { document->
                    Toast.makeText(applicationContext,document["studname"].toString(),Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {ex->
                    Toast.makeText(applicationContext,ex.message,Toast.LENGTH_SHORT).show()
                }
        }
        catch(ex:Exception)
        {
            mProgressDialog.dismiss()
            Toast.makeText(applicationContext,ex.message,Toast.LENGTH_SHORT).show()
        }
    }

    private fun getRecords()
    {
        try
        {
            mFirebaseFireStore.collection("StudentInfo")
                .get()
                .addOnSuccessListener { listOfDocuments->
                    for(document in listOfDocuments)
                    {
                        Toast.makeText(applicationContext,document["studname"].toString(),Toast.LENGTH_SHORT).show()
                    }
                    //Toast.makeText(applicationContext,document["studname"].toString(),Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {ex->
                    Toast.makeText(applicationContext,ex.message,Toast.LENGTH_SHORT).show()
                }
        }
        catch(ex:Exception)
        {
            mProgressDialog.dismiss()
            Toast.makeText(applicationContext,ex.message,Toast.LENGTH_SHORT).show()
        }
    }

    private fun performBatch()
    {
        try
        {
            mProgressDialog.show()
            val doc1Id = mFirebaseFireStore.collection("Student").document()
            val doc1Data = hashMapOf("name" to "Usama CR","age" to 40,"marks" to 1)

            val doc2Id = mFirebaseFireStore.collection("Student").document()
            val doc2Data = hashMapOf("name" to "Rai Usama CR","age" to 16,"marks" to 100)

            mWriteBatch.set(doc1Id,doc1Data)
            mWriteBatch.set(doc2Id,doc2Data)

            mWriteBatch.commit()
                .addOnSuccessListener { _:Void?->
                    mProgressDialog.dismiss()
                    Toast.makeText(applicationContext, "Batch is successful", Toast.LENGTH_SHORT).show();
                }
                .addOnFailureListener {
                    mProgressDialog.dismiss()
                    Toast.makeText(applicationContext, "${it.message}", Toast.LENGTH_SHORT).show();
                }
        }
        catch (ex:Exception)
        {
            mProgressDialog.dismiss()
            Toast.makeText(applicationContext, "${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }






}