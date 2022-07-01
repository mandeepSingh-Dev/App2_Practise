package com.mandeep.app2_practise

import android.app.NotificationManager
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mandeep.app2_practise.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),Fragment_A.FragmentA_Listener{
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val fragmentA = Fragment_A()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.containerFragment,fragmentA).commit()



    // val manager = getSystemService(NotificationManager::class.java)




    }

    // for communicate data between activity and this fragment
    override fun onSendFragmentA(string: String) {
        Toast.makeText(this,string+" ",Toast.LENGTH_SHORT).show()
    }
}