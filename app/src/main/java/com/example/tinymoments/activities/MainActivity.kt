package com.example.tinymoments.activities

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tinymoments.R
import com.example.tinymoments.adapters.DateItemAdapter
import com.example.tinymoments.databinding.ActivityMainBinding
import com.example.tinymoments.models.MonthDay
import java.time.LocalDate
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpToolbar()
        setUpDrawerLayout()
        setUpDateRecyclerView()
        Log.e("MainActivity", "Activity oncreate")
    }

    private fun setUpToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.main_activity_toolbar)
        setSupportActionBar(toolbar)
    }

    private fun setUpDrawerLayout() {
        val toggle = ActionBarDrawerToggle(
            this, binding.drawerLayout, binding.mainActivityToolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    private fun setUpDateRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.rv_date)
        val today = MonthDay(LocalDate.now().monthValue, LocalDate.now().dayOfMonth)
        recyclerView.adapter = DateItemAdapter(
            this@MainActivity,
            getDates(),
            today
        )
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        recyclerView.getLayoutManager()?.scrollToPosition(today.day - 4) //position the today's date card at the center

    }

    private fun getDates(): ArrayList<MonthDay> {
        val today = LocalDate.now()
        val daysInMonth = today.month.length(today.isLeapYear)
        val dates = ArrayList<MonthDay>()

        for (i in 1..daysInMonth) {
            dates.add(MonthDay(today.monthValue, i))
        }
        return dates
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.main_activity_toolbar -> {
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}