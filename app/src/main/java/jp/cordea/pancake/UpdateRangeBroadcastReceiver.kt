package jp.cordea.pancake

import android.app.slice.Slice
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class UpdateRangeBroadcastReceiver : BroadcastReceiver() {

    companion object {
        const val MAX = 100
    }

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.getIntExtra(Slice.EXTRA_RANGE_VALUE, 0) >= MAX) {
            Toast.makeText(
                    context,
                    "You already like a pancake, don't you?",
                    Toast.LENGTH_SHORT
            ).show()
        }
    }
}
