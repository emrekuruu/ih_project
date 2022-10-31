package com.example.letslearnactivities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         setContentView(R.layout.activity_second)


        val thirdView : Button = findViewById(R.id.goToThird)
        thirdView.setOnClickListener{
            Intent(this,ThirdActivity::class.java).also {
                startActivity(it)
            }


            val back : Button = findViewById(R.id.buttonBack)
            back.setOnClickListener{
                Intent(this,MainActivity::class.java).also{
                    finish()
                }
            }

        }


        val firstAlert = AlertDialog.Builder(this)
            .setTitle("Add Contact")
            .setMessage("Would You Like To Add This Contract To Your List")
            .setIcon(R.drawable.ic_add_contract)
            .setPositiveButton("Yes"){_,_ -> Toast.makeText(this,"Added To Contracts",Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No"){_,_ -> Toast.makeText(this,"Not Added To Contracts",Toast.LENGTH_SHORT).show()
            }.create()


        val first : Button = findViewById(R.id.first)
        first.setOnClickListener{
            firstAlert.show()
        }

        val options = arrayOf("First Option","Second Option","Third Option")
        val secondAlert = AlertDialog.Builder(this)
            .setTitle("Choose One")
            .setSingleChoiceItems(options,0) { dialogInterface, i ->
                Toast.makeText(this, "You Clicked on ${options[i]}", Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Accept"){_,_ -> Toast.makeText(this,"Accepted",Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Decline"){_,_ -> Toast.makeText(this,"Not Accepted",Toast.LENGTH_SHORT).show()
            }
            .create()


        val second : Button = findViewById(R.id.second)
        second.setOnClickListener{
            secondAlert.show()
        }


        val thirdAlert = AlertDialog.Builder(this)
            .setTitle("Choose One Or More")
            .setMultiChoiceItems(options, booleanArrayOf(false,false,false)){_,i,isChecked ->
                if(isChecked)Toast.makeText(this, "You Checked ${options[i]}", Toast.LENGTH_SHORT).show()
                else{Toast.makeText(this, "You Unchecked  ${options[i]}", Toast.LENGTH_SHORT).show()}
            }
            .setPositiveButton("Accept"){_,_ -> Toast.makeText(this,"Accepted",Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Decline"){_,_ -> Toast.makeText(this,"Not Accepted",Toast.LENGTH_SHORT).show()
            }
            .create()

        val third : Button = findViewById(R.id.third)
        third.setOnClickListener{
            thirdAlert.show()
        }






    }

}