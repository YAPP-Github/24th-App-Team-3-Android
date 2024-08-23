package com.alreadyoccupiedseat.showpot

import android.annotation.SuppressLint
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import androidx.core.app.NotificationChannelCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.alreadyoccupiedseat.datastore.AccountDataStore
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class ShowPotFcmService @Inject constructor() : FirebaseMessagingService() {

    @Inject
    lateinit var accountDataStore: AccountDataStore

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        sendNotification(remoteMessage.notification!!)
    }

    override fun onNewToken(token: String) {
        CoroutineScope(Dispatchers.Default).launch {
            accountDataStore.updateFcmToken(token)
        }
    }

    @SuppressLint("MissingPermission", "SuspiciousIndentation")
    private fun sendNotification(notification: RemoteMessage.Notification) {
        val requestCode = 0
        val intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        val pendingIntent = PendingIntent.getActivity(
            this,
            requestCode,
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT,
        )

        val channelId = FCM_CHANNEL.toString()

        val notificationManager = NotificationManagerCompat.from(this)

        val channel =
            NotificationChannelCompat
                .Builder(channelId, NotificationManager.IMPORTANCE_HIGH)
                .setName(FCM_SERVICE_CHANNEL)
                .build()

        val notificationBuilder = NotificationCompat
            .Builder(this, channel.id)
            .setPriority(NotificationManagerCompat.IMPORTANCE_HIGH)
            .setSmallIcon(R.drawable.notification_icon)
            .setContentTitle(notification.title)
            .setContentText(notification.body)
            .setDefaults(NotificationCompat.DEFAULT_SOUND or NotificationCompat.DEFAULT_VIBRATE)
            .setAutoCancel(true)
            .setFullScreenIntent(pendingIntent, true)

        notificationManager.createNotificationChannel(channel)

        notificationManager.notify(
            (System.currentTimeMillis()).toInt(),
            notificationBuilder.build()
        )
    }

    companion object {
        private const val FCM_CHANNEL = 123456789
        private const val FCM_SERVICE_CHANNEL = "FCM_SERVICE_CHANNEL"
        private const val TAG = "ShowPotFcmService"
    }
}