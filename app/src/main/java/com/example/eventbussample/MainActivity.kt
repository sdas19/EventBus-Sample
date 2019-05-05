package com.example.eventbussample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.eventbussample.Fragments.FragmentA
import com.example.eventbussample.Model.SendItemModel
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

class MainActivity : AppCompatActivity() {

    val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.container,FragmentA(),FragmentA::class.java.simpleName).commit()
    }

    @Subscribe
    fun onEvent(sendItemModel: SendItemModel){
        Log.i(TAG,sendItemModel?.data)
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }
}
