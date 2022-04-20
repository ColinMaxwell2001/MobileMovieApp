package com.example.mymovieinfo

import android.Manifest
import android.app.TaskStackBuilder.create
import android.content.Context
import android.content.IntentFilter.create
import android.content.pm.PackageManager
import android.database.sqlite.SQLiteDatabase.create
import android.location.Location
import android.location.LocationRequest
import android.media.MediaParser.create
import android.media.audiofx.AcousticEchoCanceler.create
import androidx.core.app.ActivityCompat
import androidx.lifecycle.LiveData
import com.example.mymovieinfo.dto.LocationDetails
import com.google.android.gms.location.LocationServices
import java.net.URI.create
import android.app.Application
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationResult


class LocationLiveData(var context: Context) : LiveData<LocationDetails>(){

    private var fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)

    override fun onActive() {
        super.onActive()
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        fusedLocationClient.lastLocation.addOnSuccessListener { location ->
            location.also {
                setLocationData(it)
            }
        }
        startLocationUpdates()
    }

    private fun startLocationUpdates() {
        //fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback)
    }


    private fun setLocationData(location: Location?) {
        location?.let{
            location ->
            value = LocationDetails(location.longitude.toString(), location.latitude.toString())
            }
        }
    override fun onInactive() {
        super.onInactive()
    }

    private val locationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            super.onLocationResult(locationResult)

            locationResult ?: return

            for (location in locationResult.locations) {
                setLocationData(location)
            }
        }
    }

    companion object {
        val ONE_MINUTE: Long = 60000
        val locationRequest: com.google.android.gms.location.LocationRequest =
            com.google.android.gms.location.LocationRequest.create().apply {
                interval = ONE_MINUTE
                fastestInterval = ONE_MINUTE / 4
                priority = com.google.android.gms.location.LocationRequest.PRIORITY_HIGH_ACCURACY
            }
    }
}


