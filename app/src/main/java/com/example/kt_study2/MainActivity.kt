package com.example.kt_study2

import android.content.Context
import android.media.MediaPlayer
import android.media.Ringtone
import android.media.RingtoneManager
import android.net.Uri
import android.os.*
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.kt_study2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener {
            /* 안드로이드 시스템 알림 */
            val notification: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val ringtone : Ringtone = RingtoneManager.getRingtone(this, notification)
            ringtone.play()
            /* 앱에서 자체 음원을 재생, res/raw */
//            val player: MediaPlayer = MediaPlayer.create(this, R.raw.chicken)
//            player.start()

            /* 진동 알림
            * 31 이전 버전 : VIBRATOR_SERVICE로 식별되는 시스템 서비스 이용
            * 31 및 이후 버전 : VIBRATOR_MANAGER_SERVICE로 식별되는 VibratorManager이라는 시스템 서비스를 얻고
            이 서비스에서 Vibrator을 이용
             */
            val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S){
                val vibratorManager = this.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
                vibratorManager.defaultVibrator
            } else{
                getSystemService(VIBRATOR_SERVICE) as Vibrator
            }

            // 2. 진동 구현: 1000ms 동안 100의 강도로 울린다.
            vibrator.vibrate(VibrationEffect.createOneShot(1000, 100))
        }

    }

}