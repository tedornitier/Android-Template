package app.alessandrotedesco.template.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.DrawableRes
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import app.alessandrotedesco.template.R

fun Context.createNotificationChannel(
    id: String,
    name: String,
    description: String,
    importance: Int = NotificationManager.IMPORTANCE_DEFAULT
) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channel = NotificationChannel(id, name, importance).apply {
            this.description = description
        }
        val notificationManager: NotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}

fun Context.showNotification(
    @DrawableRes icon: Int = R.drawable.ic_launcher_foreground,
    title: String = getString(R.string.app_name),
    content: String,
    channelId: String,
    notificationId: Int = 0,
    priority: Int = NotificationCompat.PRIORITY_DEFAULT
) = NotificationCompat.Builder(this, channelId)
    .setSmallIcon(icon)
    .setContentTitle(title)
    .setContentText(content)
    .setPriority(priority)
    .also {
        NotificationManagerCompat.from(this).notify(notificationId, it.build())
    }