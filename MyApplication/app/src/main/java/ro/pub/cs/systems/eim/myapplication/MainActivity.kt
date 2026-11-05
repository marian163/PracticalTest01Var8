package ro.pub.cs.systems.eim.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    fun invokeActivity(view: View) {
        val riddle = findViewById<EditText>(R.id.editTextText2).text.toString()
        val answer = findViewById<EditText>(R.id.editTextText).text.toString()
        if (riddle.isEmpty() || answer.isEmpty()) return
        val intent = Intent(this, PracticalTest01Var08PlayActivity::class.java)
        intent.putExtra("riddle", riddle)
        intent.putExtra("answer", answer)

        startActivity(intent)
    }
}