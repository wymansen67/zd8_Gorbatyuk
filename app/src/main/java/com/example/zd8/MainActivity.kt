package com.example.zd8

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var onetext: TextView
    lateinit var twotext: TextView
    lateinit var threetext: TextView
    lateinit var fourtext: TextView
    lateinit var fivetext: TextView
    lateinit var sixtext: TextView
    
    private var func ="-1"
    private var task="0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onetext=findViewById(R.id.Task0)
        twotext=findViewById(R.id.TaskDescription0)
        threetext=findViewById(R.id.Task1)
        fourtext=findViewById(R.id.TaskDescription1)
        fivetext=findViewById(R.id.Task2)
        sixtext=findViewById(R.id.TaskDescription2)
        func = intent.getStringExtra("scan").toString()
        task = intent.getStringExtra("t").toString()

        if (func == "2" && task == "1")
        {
            onetext.text = intent.getStringExtra("edited0").toString()
            twotext.text = intent.getStringExtra("edited1").toString()
        }
        else if (func == "2" && task == "2")
        {
            threetext.text = intent.getStringExtra("edited0").toString()
            fourtext.text = intent.getStringExtra("edited1").toString()
        }
        else if (func == "2" && task == "3")
        {
            fivetext.text = intent.getStringExtra("edited0").toString()
            sixtext.text = intent.getStringExtra("edited1").toString()
        }
    }

    fun EditFirst(view: View) {
        val intent =  Intent(this@MainActivity, EditTextActivity::class.java)
        intent.putExtra("tsk", "1")
        startActivity(intent)
    }

    fun EditSecond(view: View) {
        val intent =  Intent(this@MainActivity, EditTextActivity::class.java)
        intent.putExtra("tsk", "2")
        startActivity(intent)
    }
    fun EditThird(view: View) {
        val intent =  Intent(this@MainActivity, EditTextActivity::class.java)
        intent.putExtra("ztsk", "3")
        startActivity(intent)
    }
}