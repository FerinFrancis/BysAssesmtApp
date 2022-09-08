package com.ferin.bysassesmtapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var editOrgIdVar: EditText
    lateinit var editUsernameVar: EditText
    lateinit var editPasswordVar: EditText
    lateinit var loginButtonVar: Button
    lateinit var dontHaveAccountButtonVar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editOrgIdVar = findViewById(R.id.editOrgId)
        editUsernameVar = findViewById(R.id.editUsername)
        editPasswordVar = findViewById(R.id.editPassword)
        loginButtonVar = findViewById(R.id.loginButton)
        dontHaveAccountButtonVar = findViewById(R.id.dontHaveAccountButton)

        val sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)

        editUsernameVar.setText(sharedPref.getString("regUserName","def val"))

        editOrgIdVar.isEnabled = false


        loginButtonVar.setOnClickListener{
            val loginUserName = editUsernameVar.text.toString()
            val loginPasswrd = editPasswordVar.text.toString()

            if(TextUtils.isEmpty(loginUserName)||TextUtils.isEmpty(loginPasswrd)){
                Toast.makeText(this,"Please enter login details",Toast.LENGTH_SHORT).show()
            }
            else{
                if(loginUserName == sharedPref.getString("regUserName",null) && loginPasswrd == sharedPref.getString("regPassWord",null)){
                    startActivity(Intent(this,HomePageAct::class.java))
                }
                else{
                    Toast.makeText(this, "Please enter valid details",Toast.LENGTH_SHORT).show()
                }
            }
        }

        dontHaveAccountButtonVar.setOnClickListener{
            startActivity(Intent(this, RegistrationPageAct::class.java))

        }
    }

    override fun onBackPressed() {
        finishAffinity()
        super.onBackPressed()
    }
}