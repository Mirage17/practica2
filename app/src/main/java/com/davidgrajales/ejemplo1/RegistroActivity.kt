package com.davidgrajales.ejemplo1

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class RegistroActivity : AppCompatActivity() {

    private lateinit var fecha: String
    private var cal = Calendar.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("OnCreate", "ok")


        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, month)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                val format = "dd-MM-yyyy"
                val simpleDateFormat = SimpleDateFormat(format, Locale.US)
                fecha = simpleDateFormat.format(cal.time).toString()
                tv_calendar.text = fecha

            }

        }

        ib_calendar.setOnClickListener {

            DatePickerDialog(
                this,
                dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()

        }

        b_save.setOnClickListener {
            var n = 0
            val nombre = et_nombre.text.toString()
            val celular = et_cel.text.toString()
            val email = et_email.text.toString()
            val fecha = tv_fecha.text.toString()
            val pass = et_pass.text.toString()
            val pass2 = et_pass2.text.toString()
            val lugar = tv_LugarDeNacimiento.text.toString()

            if (cb_ajedrez.isChecked || cb_apnea.isChecked || cb_judo.isChecked || cb_rugby.isChecked) {
                n = 1
            } else {
                n = 0
            }

            if (n == 0 || nombre.isEmpty() || celular.isEmpty() || email.isEmpty() || fecha.isEmpty() || pass.isEmpty() || pass2.isEmpty() || lugar.isEmpty()) {

                tv_show.text = "Faltan campos por llenar. Por favor verifique la información."

            } else {

                if (pass == pass2) {
                    tv_show.text = "Su nombre es: $nombre \n " +
                            "Su célular es: $celular \n" +
                            "Su correo electrónico es: $email \n" +
                            "Su fecha de nacimiento es: $fecha \n" +
                            "su contraseña es $pass"
                } else {
                    tv_show.text =
                        "las contraseñas no son iguales. Por favor verifique la información"
                }


            }


        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.mActivity2) {
            Log.d("Menu", "Login")

            // val intent: Intent=Intent(this,LoginActivity::class.java)
            val intent = Intent()

            intent.putExtra("nombre", et_nombre.toString())
            intent.putExtra("celular", et_cel.toString())
            setResult(Activity.RESULT_OK)
            finish()
        } else {
            Log.d("Menu", "presionado_actividad3")
            val intent: Intent = Intent(this, SplashActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)

    }

    override fun onStart() {
        super.onStart()
        Log.d("onStart", "ok")

    }

    override fun onStop() {
        super.onStop()
        Log.d("onStop", "ok")

    }

    override fun onResume() {
        super.onResume()
        Log.d("inResume", "ok")

    }

    override fun onPause() {
        super.onPause()

        Log.d("onPause", "ok")
    }

    override fun onRestart() {
        super.onRestart()

        Log.d("onRestart", "ok")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("onDestroy", "ok")
    }
}
