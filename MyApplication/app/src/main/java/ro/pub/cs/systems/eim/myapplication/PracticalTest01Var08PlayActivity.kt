package ro.pub.cs.systems.eim.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PracticalTest01Var08PlayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var08_play)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        findViewById<EditText>(R.id.riddle).setText(intent.getStringExtra("riddle"))
        findViewById<Button>(R.id.check).setOnClickListener {
            val answer = findViewById<EditText>(R.id.answer).text.toString()
            val ok = answer == intent.getStringExtra("answer")
            Toast.makeText(this, if (ok) "Yes" else "No", Toast.LENGTH_SHORT).show()
        }
    }
}