package com.example.zd8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class EditTextActivity : AppCompatActivity() {

    lateinit var edittext0: TextView
    lateinit var edittext1: TextView
    private var t = "-1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_text)
        edittext0 = findViewById(R.id.title)
        edittext1 = findViewById(R.id.main)
        t = intent.getStringExtra("tsk").toString()
    }

    fun SaveChanges(view: View) {
        if (edittext0.text.isNotEmpty() && edittext1.text.isNotEmpty())
        {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("edited0", edittext0.text.toString())
            intent.putExtra("edited1", edittext1.text.toString())
            intent.putExtra("scan", "2")
            intent.putExtra("t",t)
            startActivity(intent)

        } else {
            val length = Toast.LENGTH_SHORT
            Toast.makeText(applicationContext, "Строки не могут быть пустыми $t", length).show()
        }
    }
}