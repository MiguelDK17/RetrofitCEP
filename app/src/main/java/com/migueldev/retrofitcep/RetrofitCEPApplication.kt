package com.migueldev.retrofitcep

import android.app.Application
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class RetrofitCEPApplication : Application(){
    override fun onCreate() {
        super.onCreate()
    }
}