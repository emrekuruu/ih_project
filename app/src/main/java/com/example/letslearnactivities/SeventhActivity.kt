package com.example.letslearnactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class SeventhActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seventh)

        val images = listOf(
            R.drawable.afet,
            R.drawable.eh_logo,
            R.drawable.ih
        )

        val adapter : ViewPagerAdapter = ViewPagerAdapter(images)
        val pager : ViewPager2 = findViewById(R.id.ViewPager2)
        pager.adapter = adapter

        //if you want to swipe Vertically
        //pager.orientation = ViewPager2.ORIENTATION_VERTICAL

        val tab : TabLayout = findViewById(R.id.tabLayout)
        TabLayoutMediator(tab,pager){ tab ,position ->
            tab.text = "Tab ${position+1}"
        }.attach()


        tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(this@SeventhActivity,"You Select ed ${tab?.text}",Toast.LENGTH_SHORT).show( )
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })

    }






    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu,menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.miSettings -> Toast.makeText(this,"Clicked on Settings", Toast.LENGTH_SHORT).show()
            R.id.next -> {Intent(this,EightActivity::class.java).also { startActivity(it) }}
            R.id.miFavorite -> Toast.makeText(this,"Clicked on Favorites", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}