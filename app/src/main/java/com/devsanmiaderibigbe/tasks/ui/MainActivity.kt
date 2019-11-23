package com.devsanmiaderibigbe.tasks.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.devsanmiaderibigbe.tasks.MyApplicatoin
import com.devsanmiaderibigbe.tasks.R
import com.devsanmiaderibigbe.tasks.di.component.AppComponent

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    lateinit var  appComponent: AppComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        initNavWithToolbar(navController)
    }


    private fun initNavWithToolbar(navController: NavController){
        val  appBarConfiguration = AppBarConfiguration(navController.graph)
        findViewById<Toolbar>(R.id.toolbar)
            .setupWithNavController(navController, appBarConfiguration)

    }

    override fun onSupportNavigateUp(): Boolean {// Up button will work on this method
        return navController.navigateUp()
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {

        super.onCreate(savedInstanceState, persistentState)
    }
}
