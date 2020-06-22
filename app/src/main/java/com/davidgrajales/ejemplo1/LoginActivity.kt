package com.davidgrajales.ejemplo1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var datosRecibidos = intent.extras

        button.setOnClickListener {
            val intent = Intent(this, RegistroActivity::class.java)
            startActivityForResult(intent, 1234)
        }

        /* var nombre=datosRecibidos?.getString("nombre")
         var celular=datosRecibidos?.getLong("celular")

         Toast.makeText(this, "nombre: $nombre. Celular: $celular",Toast.LENGTH_SHORT).show()*/
        button.setOnClickListener {
            //onBackPressed()
        }


        button3.setOnClickListener {
            val intent: Intent = Intent(this, SplashActivity::class.java)
            startActivity(intent)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1234 && resultCode == Activity.RESULT_OK) {

            val nombre = data?.extras?.getString("nombre")
            val celular = data?.extras?.getLong("celular")
        }
    }


}