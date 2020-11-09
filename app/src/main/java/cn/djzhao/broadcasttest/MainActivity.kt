package cn.djzhao.broadcasttest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var timeChangeReceiver: TimeChangeReceiver
    private lateinit var mainText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainText = helloTXT
        val intentFilter = IntentFilter()
        intentFilter.addAction("android.intent.action.TIME_TICK")
        timeChangeReceiver = TimeChangeReceiver()
        registerReceiver(timeChangeReceiver, intentFilter)
        sendBroadcast.setOnClickListener {
            val intent = Intent("cn.djzhao.broadcasttest.MY_BROADCAST")
            // 自定义的隐式广播通过setPackage设置为显示广播，否则Android8以后静态注册(AndroidManifest中)的BroadcastReceiver无法收到广播
            intent.setPackage(packageName)
            // 发送标准广播
            // sendBroadcast(intent)
            // 发送有序广播
            sendOrderedBroadcast(intent, null)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(timeChangeReceiver)
    }

    inner class TimeChangeReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            mainText.text = "${mainText.text}\n${Date()}"
            Toast.makeText(context, "Time is changed", Toast.LENGTH_SHORT).show()
        }
    }
}