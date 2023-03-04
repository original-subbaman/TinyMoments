package com.example.tinymoments

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import com.example.tinymoments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpToolbar()
        setUpDrawerLayout()
    }

    private fun setUpToolbar(){
        val toolbar = findViewById<Toolbar>(R.id.main_activity_toolbar)
        setSupportActionBar(toolbar)
    }

    private fun setUpDrawerLayout(){
        val toggle = ActionBarDrawerToggle(this, binding.drawerLayout, binding.mainActivityToolbar,
        R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onBackPressed() {
        if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else{
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
       return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       return when(item.itemId){
           R.id.main_activity_toolbar -> {
               true
           }
           else -> super.onOptionsItemSelected(item)
       }
    }
}