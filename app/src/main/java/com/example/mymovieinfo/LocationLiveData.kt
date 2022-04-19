package com.example.mymovieinfo

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.mymovieinfo.dto.LocationDetails
import com.google.android.gms.location.LocationServices

class LocationLiveData(var context: Context) : LiveData<LocationDetails>(){

    private var fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)

    override fun onActive(){
        super.onActive()
    }

    override fun onInactive() {
        super.onInactive()
    }
}