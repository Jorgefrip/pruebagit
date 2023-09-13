package com.example.taxi_control_20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase






class Login : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var pt_usuario: TextView
    private lateinit var pt_contraseña: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()
        pt_usuario = findViewById(R.id.pt_usuario)
        pt_contraseña = findViewById(R.id.pt_contraseña)
    }

    // Ir a la ventana del registro
    fun onClickRegistrarse(view: View) {
        val ingresar = Intent(this@Login, Registro::class.java)
        startActivity(ingresar)
    }

    // Iniciar sesion
    fun iniciarSesion(view: View) {
        mAuth.signInWithEmailAndPassword(pt_usuario.text.toString(), pt_contraseña.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val i = Intent(applicationContext, Home::class.java)
                    startActivity(i)
                    val user = mAuth.currentUser
                    // updateUI(user);
                } else {
                    Toast.makeText(applicationContext, "Usuario o contraseña incorrecto",
                        Toast.LENGTH_SHORT).show()
                    // updateUI(null);
                }
            }
    }
}




