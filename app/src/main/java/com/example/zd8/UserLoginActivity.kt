package com.example.zd8

import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class UserLoginActivity : AppCompatActivity() {

    private val APP_PREFERENCES = "settings"
    private val pref_email="email"
    private val pref_login="login"
    private val pref_psswd="psswd"

    lateinit var login: EditText
    lateinit var psswd: EditText
    lateinit var email: EditText
    lateinit var pref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_login)
        email = findViewById(R.id.Email)
        login = findViewById(R.id.Login)
        psswd = findViewById(R.id.Psswd)
        pref = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)
    }

    fun setPreferences(view: View) {
        val message = AlertDialog.Builder(this)
        message.setTitle("Сообщение")
        message.setMessage("Сохранить данные для следующего входа?")
        message.setPositiveButton("OK") { dialog, which ->
            val Psswd = psswd.text.toString()
            val Login = login.text.toString()
            val Email = email.text.toString()

            if (Psswd.isNotEmpty() && Login.isNotEmpty() && Email.isNotEmpty()) {
                val prefEditor = pref.edit()
                prefEditor.putString(pref_email, Email)
                prefEditor.putString(pref_login, Login)
                prefEditor.putString(pref_psswd, Psswd)
                prefEditor.apply()

                val duration = Toast.LENGTH_SHORT
                Toast.makeText(
                    applicationContext,
                    "Вы успешно сохранили данные для входа",
                    duration
                ).show()
            } else {
                val duration = Toast.LENGTH_SHORT
                Toast.makeText(applicationContext, "Обнаружены пустые поля", duration).show()
            }
        }

        message.setNegativeButton("Нет") { dialog, which ->
            val duration = Toast.LENGTH_SHORT
            Toast.makeText(applicationContext, "Вы отказались от сохранения", duration).show()
        }

        val dialog = message.create()
        message.show()
    }

    fun getPreferences(view: View) {
        val enteredEmail = email.text.toString()
        val enteredLogin=login.text.toString()
        val enteredPsswd=psswd.text.toString()

        val savedEmail=pref.getString(pref_email,"")
        val savedLogin=pref.getString(pref_login,"")
        val savedPsswd=pref.getString(pref_psswd,"")

        if ((enteredPsswd.isNotEmpty() && enteredLogin.isNotEmpty()) || (enteredPsswd.isNotEmpty() && enteredEmail.isNotEmpty())){
            if (enteredPsswd.isNotEmpty() && enteredEmail.isNotEmpty()){
                if (enteredPsswd == savedPsswd && enteredEmail == savedEmail){
                    email.setText(savedEmail)
                    login.setText(savedLogin)
                    psswd.setText(savedPsswd)

                    val duration = Toast.LENGTH_SHORT
                    Toast.makeText(applicationContext, "Успешная авторизация" , duration).show()

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else{
                    val duration = Toast.LENGTH_SHORT
                    Toast.makeText(applicationContext, "Введёные неверные данные для авторизации" , duration).show()
                }
            } else if (enteredPsswd.isNotEmpty() && enteredLogin.isNotEmpty()) {
                if (enteredPsswd == savedPsswd && enteredLogin == savedLogin){
                    email.setText(savedEmail)
                    login.setText(savedLogin)
                    psswd.setText(savedPsswd)

                    val duration = Toast.LENGTH_SHORT
                    Toast.makeText(applicationContext, "Успешная авторизация" , duration).show()

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    val duration = Toast.LENGTH_SHORT
                    Toast.makeText(applicationContext, "Введёные неверные данные для авторизации" , duration).show()
                }
            } else {
                val duration = Toast.LENGTH_SHORT
                Toast.makeText(applicationContext, "Поля не могут быть пустыми" , duration).show()
            }
        } else {
            val duration = Toast.LENGTH_SHORT
            Toast.makeText(applicationContext, "Поля не могут быть пустыми" , duration).show()
        }
    }
}