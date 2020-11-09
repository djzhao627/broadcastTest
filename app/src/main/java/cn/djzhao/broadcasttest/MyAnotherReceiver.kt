package cn.djzhao.broadcasttest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyAnotherReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, "received in my MyAnotherReceiver", Toast.LENGTH_SHORT).show()
    }
}
