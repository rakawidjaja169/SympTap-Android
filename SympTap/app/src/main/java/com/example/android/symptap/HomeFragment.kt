package com.example.android.symptap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        diagnose_card.setOnClickListener{
            view.findNavController().navigate(R.id.action_homeFragment_to_symptomsFragment)
        }

        article_card.setOnClickListener{
            view.findNavController().navigate(R.id.action_homeFragment_to_articleFragment)
        }

        consultation_card.setOnClickListener{
            view.findNavController().navigate(R.id.action_homeFragment_to_consultationFragment)
        }

        about_card.setOnClickListener{
            view.findNavController().navigate(R.id.action_homeFragment_to_aboutFragment)
        }
    }
}