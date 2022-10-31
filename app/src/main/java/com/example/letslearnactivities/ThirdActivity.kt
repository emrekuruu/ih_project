package com.example.letslearnactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import java.text.FieldPosition

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)



        val spinner : Spinner = findViewById(R.id.spMonths)
        // if you dont know the items of the spanner before hand using adapters you can add it
        // val customList = arrayOf("first","second","third")
        // val adapter = ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,customList)
        // spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, p3: Long) {
                Toast.makeText(this@ThirdActivity,"You Selected ${adapterView?.getItemAtPosition(position).toString()}",
                    Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }


        val button : Button = findViewById(R.id.button)
        button.setOnClickListener{
            Intent(this,ForthActivity::class.java).also {
                startActivity(it)
            }
        }


    }
}