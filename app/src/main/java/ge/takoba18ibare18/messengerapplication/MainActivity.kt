package ge.takoba18ibare18.messengerapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newIntent = Intent(this, LoginActivity::class.java)
        startActivity(newIntent)
        initButtons()
        sharedPreferences = getSharedPreferences("PREF_NAME", Context.MODE_PRIVATE)
        //sharedPreferences.edit().clear().commit()
    }

    private fun initButtons() {
        initButton(R.id.login_button, LoginActivity::class.java)
        initButton(R.id.register_button, SignUpActivity::class.java)
        initButton(R.id.main_button, MainPageActivity::class.java)
        initButton(R.id.search_button, FriendsActivity::class.java)
        initButton(R.id.profile_button, ProfileActivity::class.java)
        initButton(R.id.chat_button, ChatActivity::class.java)
    }

    private fun initButton(buttonId: Int, activityClass: Class<out AppCompatActivity>) {
        findViewById<Button>(buttonId).setOnClickListener {
            startActivity(Intent(this, activityClass))
        }
    }

}