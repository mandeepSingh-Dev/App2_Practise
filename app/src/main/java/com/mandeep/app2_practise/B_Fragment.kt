package com.mandeep.app2_practise

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mandeep.app2_practise.databinding.AFragmentBinding
import com.mandeep.app2_practise.databinding.BFragmentBinding


class B_Fragment : Fragment() {

    lateinit var binding: BFragmentBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding =BFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentC = C_Fragment()

        binding.BTextview.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.containerFragment,fragmentC)?.addToBackStack(null)?.commit()
        }
    }


}