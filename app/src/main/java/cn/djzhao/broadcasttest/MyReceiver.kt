package cn.djzhao.broadcasttest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, "received in my MyReceiver", Toast.LENGTH_SHORT).show()
        // 终止有序广播继续传递
        abortBroadcast()
    }
}
