package jp.cordea.pancake

import android.app.slice.Slice
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class RespondToQuestionBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.getBooleanExtra(Slice.EXTRA_TOGGLE_STATE, false)) {
            Toast.makeText(context, "Nice!", Toast.LENGTH_SHORT).show()
        }
    }
}
