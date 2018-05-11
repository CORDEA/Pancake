package jp.cordea.pancake

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class StartActivityBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        context?.startActivity(Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        })
    }
}
