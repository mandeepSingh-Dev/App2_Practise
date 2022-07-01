package com.mandeep.app2_practise

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputBinding
import android.widget.ArrayAdapter
import com.mandeep.app2_practise.databinding.AFragmentBinding


class Fragment_A : Fragment() {

lateinit var binding: AFragmentBinding
   lateinit var fragmentaListener: FragmentA_Listener

    override fun onAttach(context: Context) {
        super.onAttach(context)
          if(context is FragmentA_Listener)
          {
              fragmentaListener = context as FragmentA_Listener
          }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = AFragmentBinding.inflate(layoutInflater)
        return binding.root

       }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragmentB = B_Fragment()

        val manager = activity?.supportFragmentManager
       // manager?.popBackStackImmediate()
        binding.ATextview.setOnClickListener {
            manager?.beginTransaction()?.replace(R.id.containerFragment, fragmentB)?.addToBackStack(null)?.commit()

            fragmentaListener.onSendFragmentA("HELLO FROM FRAGMENT A")
        }


    }

   // for communicate data between activity and this fragment
   interface FragmentA_Listener{
        fun onSendFragmentA(string:String)
    }


}