package com.Desailly.kotlindelivery.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.Desailly.kotlindelivery.R

class RegisterActivity : AppCompatActivity() {

    val TAG = "RegisterActivity"

    var imageViewGoToLogin:ImageView?=null
    var editTextName:EditText?=null
    var editTextLastname:EditText?=null
    var editTextEmail:EditText?=null
    var editTextPhone:EditText?=null
    var editTextPassword:EditText?=null
    var editTextConfirmpassword:EditText?=null
    var buttonRegister:Button?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        imageViewGoToLogin=findViewById(R.id.imageview_go_to_login)
        editTextName=findViewById(R.id.edittext_name)
        editTextLastname=findViewById(R.id.edittext_lastname)
        editTextEmail=findViewById(R.id.edittext_email)
        editTextPhone=findViewById(R.id.edittext_phone)
        editTextPassword=findViewById(R.id.edittext_password)
        editTextConfirmpassword=findViewById(R.id.edittext_confirm_password)
        buttonRegister=findViewById(R.id.btn_register)

        imageViewGoToLogin?.setOnClickListener { goToLogin() }
        buttonRegister?.setOnClickListener{register()}
    }
    private fun register(){
        val name=editTextName?.text.toString()
        val lastname=editTextLastname?.text.toString()
        val phone=editTextPhone?.text.toString()
        val email=editTextEmail?.text.toString()
        val password=editTextPassword?.text.toString()
        val confirmpassword=editTextConfirmpassword?.text.toString()


        if (isValidForm(phone = phone, lastname = lastname, email = email, password = password, confirmPassword = confirmpassword, name = name)){
            Toast.makeText(this, "exitoso", Toast.LENGTH_SHORT).show()
        }

        Log.d(TAG, "El Nombre es: $name")
        Log.d(TAG, "El Apellido es: $lastname")
        Log.d(TAG, "El telefono es: $phone")
        Log.d(TAG, "El email es: $email")
        Log.d(TAG, "El password es: $password")
        Log.d(TAG, "El confirmacion es: $confirmpassword")


    }
    fun String.isEmailValid():Boolean{
        return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }

    private fun isValidForm(
        name:String,
        lastname:String,
        email:String,
        phone:String,
        password:String,
        confirmPassword:String

        ):Boolean{
        if(name.isBlank()){
            Toast.makeText(this, "Ingrese Nombre", Toast.LENGTH_SHORT).show()
            return false
        }
        if(lastname.isBlank()){
            Toast.makeText(this, "Ingrese Apellido", Toast.LENGTH_SHORT).show()
            return false
        }
        if(phone.isBlank()){
            Toast.makeText(this, "Ingrese Telefono", Toast.LENGTH_SHORT).show()
            return false
        }
        if(email.isBlank()){
            Toast.makeText(this, "Ingrese Email", Toast.LENGTH_SHORT).show()
            return false
        }
        if(password.isBlank()){
            Toast.makeText(this, "Ingrese Pssword", Toast.LENGTH_SHORT).show()
            return false
        }
        if(confirmPassword.isBlank()){
            Toast.makeText(this, "Ingrese Confirmacion", Toast.LENGTH_SHORT).show()
            return false
        }
        if (!email.isEmailValid()){
            Toast.makeText(this, "Email Invalido", Toast.LENGTH_SHORT).show()
            return false
        }
        if(password != confirmPassword){
            Toast.makeText(this, "Las Contraseñas No Coinciden", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }



    private fun goToLogin(){
        val i = Intent(this,MainActivity::class.java)
        startActivity(i)
    }
}