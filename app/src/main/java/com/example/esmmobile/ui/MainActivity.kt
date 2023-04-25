package com.example.esmmobile.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.navigateUp
import com.example.esmmobile.R
import com.example.esmmobile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController : NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController
        setupWithNavController(binding.bottomNavView, navController)
        appBarConfiguration = AppBarConfiguration(navController.graph)
    }

    //This sets the up-back button on the appbar to always return to the main HomePage.
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) ||  super.onSupportNavigateUp()
    }
}