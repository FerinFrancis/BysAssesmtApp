package com.ferin.bysassesmtapp

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

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

        val sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
        val editor = sharedPref.edit()

        regSignupButtonVar.setOnClickListener{
            val regUserNameString = regUsernameEditVar.text.toString()
            val regPassString = regPasswordEditVar.text.toString()

            if(TextUtils.isEmpty(regUserNameString)||TextUtils.isEmpty(regPassString)){
                Toast.makeText(this,"Please fill details to proceed",Toast.LENGTH_SHORT).show()
            }
            else{

                editor.apply{
                    putString("regUserName",regUserNameString)
                    putString("regPassWord",regPassString)
                    apply()
                }

                val alertDialog = AlertDialog.Builder(this)
                alertDialog.setTitle("Registration Completed").setMessage("User details saved \nPlease login again to proceed")
                alertDialog.setPositiveButton("Proceed", DialogInterface.OnClickListener { dialogInterface, i -> startActivity(Intent(this,MainActivity::class.java)) })
                alertDialog.setNegativeButton("Cancel",null).show()
            }
        }

    }
}