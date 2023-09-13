package com.example.taxi_control_20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnIngresar = findViewById<Button>(R.id.btn_ingresar)
        btnIngresar.setOnClickListener {
            // Ir a la ventana del login
            val ingresar = Intent(this@MainActivity, Login::class.java)
            startActivity(ingresar)
        }
    }


}
