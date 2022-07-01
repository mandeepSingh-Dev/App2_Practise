package com.mandeep.app2_practise

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mandeep.app2_practise.databinding.AFragmentBinding
import com.mandeep.app2_practise.databinding.CFragmentBinding


class C_Fragment : Fragment() {

    lateinit var binding:CFragmentBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = CFragmentBinding.inflate(LayoutInflater.from(requireContext()))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentA = Fragment_A()
        val fragmentB = B_Fragment()

        val manager = activity?.supportFragmentManager

        binding.CTextview.setOnClickListener {
           // activity?.supportFragmentManager?.beginTransaction()?.
            for(i in 0..manager?.backStackEntryCount!!)
            {
                manager.popBackStack()
            }
           // manager.beginTransaction().replace(R.id.containerFragment,fragmentA).commit()
            manager.beginTransaction().replace(R.id.containerFragment,fragmentB).addToBackStack(null).commit()

        }
    }
}