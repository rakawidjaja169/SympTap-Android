package com.example.android.symptap

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_consultation.*
import kotlin.math.log

/**
 * A simple [Fragment] subclass.
 */
class ConsultationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_consultation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bt_send.setOnClickListener {
            val email = Intent(Intent.ACTION_SEND)
            email.putExtra(Intent.EXTRA_EMAIL, arrayOf("raka.widjaja169@gmail.com"))
            email.putExtra(Intent.EXTRA_SUBJECT, et_subject.text)
            Log.d("Consultation", "et_subject: ${et_subject.text}")
            email.putExtra(Intent.EXTRA_TEXT, et_message.text)
            email.type = "text/plain"
            startActivity(email)
        }
    }
}