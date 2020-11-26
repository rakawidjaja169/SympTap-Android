package com.example.android.symptap

object ConstantCoronavirus {

    const val TOTAL_QUESTION: String = "total_questions"
    const val CORRECT_ANSWER: String = "correct_answers"

    fun getQuestion(): ArrayList<QuestionCoronavirus>{
        val questionList = ArrayList<QuestionCoronavirus>()

        val que1 = QuestionCoronavirus(1, "Apakah anda mengalami Demam?", "Yes", "No", 1)

        questionList.add(que1)

        val que2 = QuestionCoronavirus(2, "Apakah anda mengalami Batuk Kering?", "Yes", "No", 1)

        questionList.add(que2)

        val que3 = QuestionCoronavirus(3, "Apakah anda mengalami Sesak Napas?", "Yes", "No", 1)

        questionList.add(que3)

        val que4 = QuestionCoronavirus(4, "Apakah anda mengalami Kelelahan?", "Yes", "No", 1)

        questionList.add(que4)

        val que5 = QuestionCoronavirus(5, "Apakah anda mengalami Nyeri Tenggorokan?", "Yes", "No", 1)

        questionList.add(que5)

        val que6 = QuestionCoronavirus(6, "Apakah anda mengalami Diare?", "Yes", "No", 1)

        questionList.add(que6)

        val que7 = QuestionCoronavirus(7, "Apakah anda mengalami Konjungtivitis (mata merah)?", "Yes", "No", 1)

        questionList.add(que7)

        val que8 = QuestionCoronavirus(8, "Apakah anda mengalami Sakit Kepala?", "Yes", "No", 1)

        questionList.add(que8)

        val que9 = QuestionCoronavirus(9, "Apakah anda mengalami Hilangnya indera perasa atau penciuman?", "Yes", "No", 1)

        questionList.add(que9)

        val que10 = QuestionCoronavirus(10, "Apakah anda mengalami Ruam pada Kulit?", "Yes", "No", 1)

        questionList.add(que10)

        return questionList

    }

}