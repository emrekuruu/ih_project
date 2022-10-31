package com.example.letslearnactivities

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = getSharedPreferences("My_Preferences", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        val enter = findViewById<Button>(R.id.enterbtn)
        enter.setOnClickListener{

            val EmailView = findViewById<EditText>(R.id.email)
            val email = EmailView.text.toString()
            val PassView = findViewById<EditText>(R.id.password)
            val password = PassView.text.toString()
            val isAdult = findViewById<CheckBox>(R.id.adult).isChecked

            editor.apply{
                putString("email",email)
                putString("password",password)
                putBoolean("isAdult",isAdult)
                apply()
            }
        }

            val remember = findViewById<Button>(R.id.rememberbutton)

            remember.setOnClickListener{
            val email = sharedPref.getString("email",null)
            val password = sharedPref.getString("password",null)
            val isAdult = sharedPref.getBoolean("isAdult",false)

            val EmailView = findViewById<EditText>(R.id.email)
            val PassView = findViewById<EditText>(R.id.password)

            EmailView.setText(email)
            PassView.setText(password)
            findViewById<CheckBox>(R.id.adult).isChecked = isAdult
        }

        val switchButton : Button = findViewById(R.id.switchButton)
        switchButton.setOnClickListener{
            Intent(this,SecondActivity::class.java).also {
                startActivity(it)
            }
        }

        val openGallery : Button = findViewById(R.id.openGalery)
        openGallery.setOnClickListener{
            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type = "image/*"
                startActivityForResult(it,0)
            }
        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == 0) {
            val uri = data?.data
            val myImage: ImageView = findViewById(R.id.imageView)
            myImage.setImageURI(uri)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu,menu)
        //I use the next button on the seventh activity no need to show it here!
        if (menu != null) {
            menu.findItem(R.id.next).isVisible = false
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.miSettings -> Toast.makeText(this,"Clicked on Settings",Toast.LENGTH_SHORT).show()
            R.id.miFavorite -> Toast.makeText(this,"Clicked on Favorites",Toast.LENGTH_SHORT).show()
        }
        return true
    }






}