package com.example.android.symptap

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.fragment_quiz_corona_virus.*

class QuizCoronaVirusFragment : Fragment(), View.OnClickListener {

    private var mCurrentPosition:Int = 1
    private var mQuestionsList: ArrayList<QuestionCoronavirus>? = null
    private var mSelectedOptionPosition: Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quiz_corona_virus, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mQuestionsList = ConstantCoronavirus.getQuestion()

        setQuestion()

        tv_optionYes.setOnClickListener(this)
        tv_optionNo.setOnClickListener(this)
        btn_next.setOnClickListener(this)
    }

    private fun setQuestion() {
        val question = mQuestionsList!![mCurrentPosition - 1]

        defaultOptionsView()

        if(mCurrentPosition == mQuestionsList!!.size) {
            btn_next.text = context?.getString(R.string.finish)
        } else {
            btn_next.text = context?.getString(R.string.submit)
        }

        coronaProgressBar.progress = mCurrentPosition
        tv_coronaProgressBar.text = "$mCurrentPosition" + "/" + coronaProgressBar.max

        tv_coronaquestion.text = question!!.question
        tv_optionYes.text = question.optionYes
        tv_optionNo.text = question.optionNo
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()

        options.add(tv_optionYes)
        options.add(tv_optionNo)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.default_option_border_bg
            )
        }

    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            R.id.tv_optionYes -> {
                selectedOptionView(tv_optionYes, 1)
            }
            R.id.tv_optionNo -> {
                selectedOptionView(tv_optionNo, 2)
            }
            R.id.btn_next -> {
                mSelectedOptionPosition = 0
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        }
                    }
                }
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
                requireContext(),
                R.drawable.selected_option_border_bg
        )
    }

}