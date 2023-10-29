package com.example.activity_20231029

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.activity_20231029.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//         버튼이 눌리면 = > SecondActivity화면으로 이동
        binding.btnMoveToSecond.setOnClickListener {

//        화면 이동시키기 : Intent 클래스 활용
//        1. 어디서 출발해서 어디로 도착할지 정보 명시 (티켓)
            val myIntent = Intent(this, SecondActivity::class.java)

//        2. myIntent에 적힌대로 실제 화면 이동
            startActivity(myIntent)
        }

        binding.btnMoveToThird.setOnClickListener {
            val myIntent = Intent(this, ThirdActivity::class.java)

//            화면 이동하기 전에, 데이터를 myIntent에 첨부
//            edtMessage에 적힌 값을 변수에 저장 => 이 변수를 첨부
            val inputMessage = binding.edtMessage.text.toString()

            myIntent.putExtra("message", inputMessage)

//            edtNumber에 적힌 값도 Int로 변환해서 첨부
            val inputNumber = binding.edtNumber.text.toString().toInt()


            myIntent.putExtra("number", inputNumber)

            startActivity(myIntent)
        }
    }
}