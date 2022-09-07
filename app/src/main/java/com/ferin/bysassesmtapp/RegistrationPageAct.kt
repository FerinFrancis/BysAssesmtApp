package com.ferin.bysassesmtapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegistrationPageAct : AppCompatActivity() {

    lateinit var regUsernameEditVar: EditText
    lateinit var regPasswordEditVar: EditText
    lateinit var regSignupButtonVar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_page)

        regUsernameEditVar = findViewById(R.id.regUsernameEdit)
        regPasswordEditVar = findViewById(R.id.regPasswordEdit)
        regSignupButtonVar = findViewById(R.id.regSignupButton)

        regSignupButtonVar.setOnClickListener{
            val regUserNameString = regUsernameEditVar.text.toString()
            val regPassString = regPasswordEditVar.text.toString()

            if(TextUtils.isEmpty(regUserNameString)||TextUtils.isEmpty(regPassString)){
                Toast.makeText(this,"Please enter to proceed",Toast.LENGTH_SHORT).show()
            }
            else{
                val toLoginPgIntent = Intent(this,MainActivity::class.java)
                toLoginPgIntent.putExtra("Username",regUserNameString)
                startActivity(toLoginPgIntent)
            }
        }

    }
}