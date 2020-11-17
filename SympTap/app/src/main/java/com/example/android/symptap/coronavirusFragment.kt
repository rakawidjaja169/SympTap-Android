package com.example.android.symptap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.fragment_coronavirus.*
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass.
 */
class coronavirusFragment : Fragment() {

    private val aR by lazy { ArticleRepository.getInstance(requireContext ()) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_coronavirus, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            coronavirusArticle.text = aR.getArticle(1).Article
            causeArticle.text = aR.getArticle(1).Cause
            sympArticle.text = aR.getArticle(1).Symptoms
            preventArticle.text = aR.getArticle(1).Prevention
        }
    }
}