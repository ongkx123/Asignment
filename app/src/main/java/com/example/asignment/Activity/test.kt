package com.example.asignment.Activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.asignment.R
import kotlinx.android.synthetic.main.activity_test.*

class test : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        var correctAns = 0
        var q1 = 0
        var q2 = 0
        var q3 = 0
        var q4 = 0
        var q5 = 0
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.radioOne) {
                if (q1 == 1) {
                    correctAns--
                    q1--
                }

            }
            if (checkedId == R.id.radioTwo) {

                correctAns++
                q1++
            }
            if (checkedId == R.id.radioThree) {
                if (q1 == 1) {
                    correctAns--
                    q1--
                }
            }
            if (checkedId == R.id.radioFour) {
                if (q1 == 1) {
                    correctAns--
                    q1--
                }
            }

        }
        radioGroupQ2.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.radioOneQ2) {
                correctAns++
                q2++

            }
            if (checkedId == R.id.radioTwoQ2) {
                if (q2 == 1) {
                    correctAns--
                    q2--
                }
            }
            if (checkedId == R.id.radioThreeQ2) {
                if (q2 == 1) {
                    correctAns--
                    q2--
                }
            }
            if (checkedId == R.id.radioFourQ2) {
                if (q2 == 1) {
                    correctAns--
                    q2--
                }
            }

        }

        radioGroupQ3.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.radioOneQ3) {
                if (q3 == 1) {
                    correctAns--
                    q3--
                }
            }
            if (checkedId == R.id.radioTwoQ3) {
                if (q3 == 1) {
                    correctAns--
                    q3--
                }
            }
            if (checkedId == R.id.radioThreeQ3) {

                    correctAns++
                    q3++

            }
            if (checkedId == R.id.radioFourQ3) {
                if (q3 == 1) {
                    correctAns--
                    q3--
                }
            }

        }
        radioGroupQ4.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.radioOneQ4) {
                if (q4 == 1) {
                    correctAns--
                    q4--
                }

            }
            if (checkedId == R.id.radioTwoQ4) {
                if (q4 == 1) {
                    correctAns--
                    q4--
                }
            }
            if (checkedId == R.id.radioThreeQ4) {
                if (q4 == 1) {
                    correctAns--
                    q4--
                }
            }
            if (checkedId == R.id.radioFourQ4) {

                    correctAns++
                    q4++

            }

        }
        radioGroupQ5.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.radioOneQ5) {
                correctAns++
                q5++

            }
            if (checkedId == R.id.radioTwoQ5) {
                if (q5 == 1) {
                    correctAns--
                    q5--
                }
            }
            if (checkedId == R.id.radioThreeQ5) {
                if (q5 == 1) {
                    correctAns--
                    q5--
                }
            }
            if (checkedId == R.id.radioFourQ5) {
                if (q5 == 1) {
                    correctAns--
                    q5--
                }
            }

        }

        val sharedPreferences=getSharedPreferences("correctAns",Context.MODE_PRIVATE)
            buttonConfirm.setOnClickListener{

            val crtAns=Integer.parseInt(correctAns.toString())

            val editor=sharedPreferences.edit()
            editor.putInt("correctAns",crtAns)
            editor.apply()

                val intent= Intent(this, reward::class.java)
                startActivity(intent)
       }
    }




}





