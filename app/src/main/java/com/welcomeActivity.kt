package com

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.tp_1.R

class welcomeActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var emailText : TextView
    lateinit var button : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        val email = intent.getStringExtra("email")
        emailText=findViewById<TextView>(R.id.textView)
        emailText.textSize = 40F
        emailText.text=email
        button =findViewById<Button>(R.id.button2)
        button.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        println("hello")
        val intent = Intent(p0?.context, GalleryActivity::class.java)
        if( p0?.id==R.id.button2) {
            startActivity(intent)
        }
    }

}