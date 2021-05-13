package com.pluto.intentpractice_doowon

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQUEST_FOR_NICKNAME = 1005

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        naverWebBtn.setOnClickListener {

            val myUri = Uri.parse("http://naver.com/")
            val myIntent = Intent(Intent.ACTION_VIEW, myUri)
            startActivity(myIntent)
        }

        kakaoStoreBtn.setOnClickListener {

            val myUri = Uri.parse("market://details?id=com.kakao.talk")
            val myIntent = Intent(Intent.ACTION_VIEW, myUri)
            startActivity(myIntent)
        }

        smsBtn.setOnClickListener {

            val inputPhoneNumber = phoneNumberEdt.text.toString()
            val myUri = Uri.parse("smsto:${inputPhoneNumber}")
            val myIntent = Intent(Intent.ACTION_SENDTO, myUri)
            myIntent.putExtra("sms_body", "미리 내용 입력")
            startActivity(myIntent)
        }

        callBtn.setOnClickListener {

            val inputPhoneNumber = phoneNumberEdt.text.toString()
            val myUri = Uri.parse("tel:${inputPhoneNumber}")
            val myIntent = Intent(Intent.ACTION_CALL, myUri)
            startActivity(myIntent)
        }

        dialBtn.setOnClickListener {

            val inputPhoneNumber = phoneNumberEdt.text.toString()
            val myUri = Uri.parse("tel:${inputPhoneNumber}")
            val myIntent = Intent(Intent.ACTION_DIAL, myUri)
            startActivity(myIntent)
        }

        editNicknameBtn.setOnClickListener {

            val myIntent = Intent(this, EditNicknameActivity::class.java)

            startActivityForResult(myIntent, REQUEST_FOR_NICKNAME)

        }

        sendMessageBtn.setOnClickListener {

            val inputMessage = messageEdt.text.toString()

            val myIntent = Intent(this, MessageActivity::class.java)

            myIntent.putExtra("message", inputMessage)

            startActivity(myIntent)

        }

        moveToOtherBtn.setOnClickListener {

            val myIntent = Intent(this, OtherActivity::class.java)
            startActivity(myIntent)

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_FOR_NICKNAME) {

            if (resultCode == RESULT_OK) {

                val newNickname = data?.getStringExtra("nickname")
                nicknameTxt.text = newNickname
            }
        }

    }

}