package com.orchsik.threadandservice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsMessage
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.

        // BroadCastReceiver 이름으로 분기
        when(intent.action) {
            "android.intent.action.BOOT_COMPLETED" -> {
                val toast = Toast.makeText(context, "부팅완료", Toast.LENGTH_LONG)
                toast.show()
            }
            "android.provider.Telephony.SMS_RECEIVED" -> {
                if(intent.extras != null) {
                    // 문자 메시지 정보 객체 추출
                    val pduObject = intent.extras?.get("pdus") as Array<Any?>
                    if(pduObject != null) {
                        for(obj in pduObject) {
                            // 문자메시지 양식 객체 추출
                            val format = intent.extras?.getString("format")
                            // 문자메시지 객체 생성
                            val currentSMS = SmsMessage.createFromPdu(obj as ByteArray, format)

                            val showMessage = "전화번호: ${currentSMS.displayOriginatingAddress}\n내용: ${currentSMS.displayMessageBody}"
                            val toast = Toast.makeText(context, showMessage, Toast.LENGTH_LONG)
                            toast.show()
                        }
                    }
                }
            }

        }



    }
}