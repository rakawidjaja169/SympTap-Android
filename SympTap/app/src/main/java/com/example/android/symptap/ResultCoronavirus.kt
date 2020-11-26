package com.example.android.symptap

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_quiz_corona_virus.*
import kotlinx.android.synthetic.main.fragment_result_coronavirus.*

class ResultCoronavirus : Fragment() {

    val args by navArgs<ResultCoronavirusArgs>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result_coronavirus, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        conclusioncoronavirus.text = "The percentage of you having Covid-19 is " + args.correctAnswer*10 + "%"

        finishcoronavirus.setOnClickListener() {
            view.findNavController().navigate(R.id.action_resultCoronavirus_to_homeFragment)
        }
    }
}