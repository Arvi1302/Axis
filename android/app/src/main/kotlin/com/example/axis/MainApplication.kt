package com.example.axis

import android.util.Log
import com.netcore.android.Smartech
import com.netcore.android.smartechpush.SmartPush
import com.netcore.smartech_base.SmartechBasePlugin
import com.netcore.smartech_push.SmartechPushPlugin
//import io.flutter.Log
import io.flutter.app.FlutterApplication
import java.lang.ref.WeakReference

class MainApplication : FlutterApplication() {
    override fun onCreate() {
        super.onCreate()

        // Initialize Smartech Sdk
        Smartech.getInstance(WeakReference(applicationContext)).initializeSdk(this)
        Smartech.getInstance(WeakReference(applicationContext)).setDebugLevel(9)
        Smartech.getInstance(WeakReference(applicationContext)).trackAppInstallUpdateBySmartech()

        // Initialize Flutter Smartech Base Plugin
        SmartechBasePlugin.initializePlugin(this)

        // Initialize Flutter Smartech Push Plugin
        SmartechPushPlugin.initializePlugin(this)

        //Fetching already generated or available token
//        try {
//            SmartPush.getInstance(WeakReference(applicationContext)).fetchAlreadyGeneratedTokenFromFCM();
//        } catch (e : Exception) {
//            Log.e("Fetching Failed", "Fetching FCM token failed.")
//        }


    }

    override fun onTerminate() {
        super.onTerminate()
        Log.d("onTerminate", "onTerminate")
    }
}