package com.ozlem.handlerrunnableproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
// MainActivity ve XML arasındaki senkronizasyonu sağlamak için:
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var number = 0

    // Runnable'ın tanımlamasını yapalım:
    var runnable : Runnable = Runnable {}
    // Handler'ın tanımlamasını yapalım:
    // Handler tanımlarken bir android birde java seçeneği çıkıyor biz android seçeneğini seçeceğiz.
    // Handler tanımlarken hata verirse parantez içine "Looper.myLooper()!!" yazabiliriz:
    var handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickStart(view : View){

        // Şimdi runnable işlemlerini yapalım:
        runnable = object : Runnable {
            override fun run() {
                number = number + 1
                textViewID.text = "TIMER: ${number}"
                // Kaç saniyede bir çalıştırılacağını veriyoruz:
                handler.postDelayed(runnable,1000)
            }
        }
        // Bu satır runnable'ı çalıştırıyor:
        handler.post(runnable)
    }

    fun onClickStop(view : View){
        // runnable'ı kaldır:
        handler.removeCallbacks(runnable)
        number = 0
        textViewID.text = "TIMER: 0"

    }
}