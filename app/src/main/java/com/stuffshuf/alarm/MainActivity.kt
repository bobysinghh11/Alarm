package com.stuffshuf.alarm

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    val am by lazy {
        getSystemService(Context.ALARM_SERVICE) as AlarmManager
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun repeatingAlarm() {

        val intent = Intent(this, MainActivity::class.java)
        val pi = PendingIntent.getActivity(this, 123, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        val calenar = Calendar.getInstance()
        calenar.set(2019, 7, 18, 15, 3)

        am.setRepeating(
            AlarmManager.RTC,
            // calenar.timeInMillis,
            System.currentTimeMillis() + 15000,
            AlarmManager.INTERVAL_DAY * 7,
            pi


        )
    }

    fun nonRepeatingAlarms() {

        val intent = Intent(this, MainActivity::class.java)
        val pi = PendingIntent.getActivity(this, 123, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        val calenar = Calendar.getInstance()
        calenar.set(2019, 7, 18, 15, 3)

        am.set(
            AlarmManager.RTC_WAKEUP,
            // calenar.timeInMillis,
            System.currentTimeMillis() + 15000,
            pi


        )
    }
}
