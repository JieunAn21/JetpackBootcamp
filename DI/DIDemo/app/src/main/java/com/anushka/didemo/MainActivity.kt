package com.anushka.didemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var smartPhone: SmartPhone

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerSmartPhoneComponent.create()
            .getSmartPhone()
            .makeACallWithRecording()

//        val smartPhone = SmartPhone(Battery(), SIMCard(ServiceProvider()), MemoryCard())
//        smartPhone.makeACallWithRecording()
    }
}