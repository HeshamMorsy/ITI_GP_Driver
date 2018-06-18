package app.iti.driver.screens.home

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import app.iti.driver.R
import app.iti.driver.contracts.HomeContract.*
import app.iti.driver.screens.about.AboutActivity
import app.iti.driver.utilities.PreferenceHelper
import app.iti.driver.utilities.PreferenceHelper.get
import app.iti.driver.utilities.PreferenceHelper.defaultPrefs
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.app_bar_home.*

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener,View {
    // reference to presenter
    lateinit var mPresenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        mPresenter = HomePresenter()
        mPresenter.initPresenter(this)

        val sharedPreferences = PreferenceHelper.defaultPrefs(this)
        val latitude = sharedPreferences.get("latitude",0.0)!!.toDouble()
        val longitude = sharedPreferences.get("longitude",0.0)!!.toDouble()
        Toast.makeText(this,"$latitude --- $longitude",Toast.LENGTH_SHORT).show()

//        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.home -> {
                // Handle the camera action
            }
            R.id.myHistory -> {

            }
            R.id.aboutUs -> {
                // go to about us
                val myIntent = Intent(this,AboutActivity::class.java)
                startActivity(myIntent)
            }
            R.id.termsAndConditions -> {

            }

        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
