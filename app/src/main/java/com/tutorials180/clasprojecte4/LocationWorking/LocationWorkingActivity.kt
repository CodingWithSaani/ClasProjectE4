package com.tutorials180.clasprojecte4.LocationWorking

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.tutorials180.clasprojecte4.R
import com.tutorials180.clasprojecte4.databinding.ActivityLocationWorkingBinding
import java.util.*

class LocationWorkingActivity : AppCompatActivity(),LocationListener
{
    private lateinit var mLocationWorkingBinding:ActivityLocationWorkingBinding  //Declaration
    private lateinit var mLocationManager:LocationManager  //Declare

    private lateinit var mGeoCoder:Geocoder  //Declare
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mLocationWorkingBinding= ActivityLocationWorkingBinding.inflate(layoutInflater)  //Initialized
        setContentView(mLocationWorkingBinding.root)

        mGeoCoder= Geocoder(LocationWorkingActivity@this, Locale.getDefault())

        mLocationManager=getSystemService(Context.LOCATION_SERVICE) as LocationManager  //Initialized
        mLocationWorkingBinding.lwGetLatLngBtn.setOnClickListener { getLocationDetails() }
    }

    //Step 1 create a separate function to getLocation
    private fun getLocationDetails()
    {
        //Step 2: include try-catch block
        try
        {
           //Step3: request for permission
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(LocationWorkingActivity@this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),Constants.requestCode)
                return
            }
            mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,5000,5f,this)
        }
        catch (ex:Exception)
        {
            Toast.makeText(applicationContext,ex.message,Toast.LENGTH_SHORT).show()
        }
    }

    override fun onLocationChanged(currentLocation: Location)
    {
        mLocationWorkingBinding.lwLatTv.text=currentLocation.latitude.toString()
        mLocationWorkingBinding.lwLngTv.text=currentLocation.longitude.toString()

        doReverseGeoCoding(currentLocation)
    }


    override fun onRequestPermissionsResult(requestCode: Int,permissions: Array<out String>,grantResults: IntArray)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==Constants.requestCode)
        {
            if(grantResults.isNotEmpty() && grantResults[0]==PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(applicationContext,"Permission Granted",Toast.LENGTH_SHORT).show()
            }
            else
            {
                Toast.makeText(applicationContext,"Permission Not Granted",Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun doReverseGeoCoding(currentLocation: Location)
    {
        try
        {
            val addressDetails=mGeoCoder.getFromLocation(currentLocation.latitude,currentLocation.longitude,1)
            //14S1
            val add=addressDetails[0].getAddressLine(0)
            val town=addressDetails[0].subLocality

            val city=addressDetails[0].locality
            val province=addressDetails[0].adminArea

            val zipCode=addressDetails[0].postalCode
            val country=addressDetails[0].countryName
            val addressFinal="Address:${add}\nTown:${town}\n" +
                    "City:${city}\nZipCode:${zipCode}Province:${province}" +
                    "Country:${country}"

            mLocationWorkingBinding.lwAddressDetailsTv.text=addressFinal

        }
        catch (ex:Exception)
        {
            Toast.makeText(applicationContext,"Permission Not Granted",Toast.LENGTH_SHORT).show()
        }
    }

















}