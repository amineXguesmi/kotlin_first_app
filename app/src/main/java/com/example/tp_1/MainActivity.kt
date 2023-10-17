package com.example.tp_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.welcomeActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var btnLogin : Button
    lateinit var email : EditText
    lateinit var password : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        email = findViewById<EditText>(R.id.editTextTextEmailAddress)
        email.hint = "Enter your email address"
        password = findViewById<EditText>(R.id.editTextTextPassword)
        password.hint = "Enter your password"
        btnLogin = findViewById(R.id.button)
        btnLogin.setOnClickListener(this)



    }

    override fun onClick(p0: View?) {
        val intent = Intent(p0?.context, welcomeActivity::class.java)
        if( p0?.id==R.id.button){
            if(email.text.toString() == "gl4@insat.tn" &&(password.text.toString() == "insat2022")){

                intent.putExtra("email",email.text.toString())
                startActivity(intent)

            }else{
                println("wrong password")
            }
        }else{
            println("out")
        }
    }

}