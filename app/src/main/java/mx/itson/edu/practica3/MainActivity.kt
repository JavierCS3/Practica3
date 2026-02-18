package mx.itson.edu.practica3

import android.content.Intent
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState : Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById<Button>(R.id.btn_get_started)

        button.setOnClickListener {
            var intent: Intent=Intent(this, activity_register::class.java)
            startActivity(intent)
        }
    }
}