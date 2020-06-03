package com.example.gdevkotlinproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var username = findViewById(R.id.username) as EditText
        var password =findViewById<EditText>(R.id.password)
        var signin=findViewById<Button>(R.id.signin)

        signin.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                //your implementation goes here
//                Toast.makeText(applicationContext,"hello:$i",Toast.LENGTH_LONG).show()
                val intent= Intent(this@MainActivity,SideNav::class.java)
                intent.putExtra("user",username.text.toString())
                intent.putExtra("pass",password.text.toString())
                startActivity(intent)
                finish()
            }
        })
    }
}
