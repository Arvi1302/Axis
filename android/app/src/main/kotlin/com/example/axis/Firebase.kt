package com.example.axis

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.netcore.android.smartechpush.SmartPush
import java.lang.ref.WeakReference

class Firebase : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        SmartPush.getInstance(WeakReference(this)).setDevicePushToken(token)
        Log.e("deeplinktoken",token)
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        val isPushFromSmartech:Boolean = SmartPush.getInstance(WeakReference(this)).isRemoteNotificationFromSmartech(message)
        if(isPushFromSmartech){
            SmartPush.getInstance(WeakReference(this)).handleRemotePushNotification(message)
        } else{

        }
    }
}