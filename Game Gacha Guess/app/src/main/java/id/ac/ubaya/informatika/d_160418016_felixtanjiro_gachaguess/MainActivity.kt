package id.ac.ubaya.informatika.d_160418016_felixtanjiro_gachaguess

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    companion object{
        val nama = "nama"
        val skor = "skor"
    }

    lateinit var pemain : Pemain
    lateinit var pemain1 : Pemain
    lateinit var pemain2 : Pemain

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonGacha.setOnClickListener {
            countGachaAntiCurang.cancel()
            editTextTebak.setText("")
            editTextTebak.isFocusable = true
            val countGacha = object: CountDownTimer(3000, 100){
                override fun onTick(p0: Long) {
                    randSkorGacha = Random.nextInt(0, gambarSkorGacha.count())
                    imageViewNilai.setImageResource(gambarSkorGacha[randSkorGacha])
                }
                override fun onFinish() {
                    randSkorGacha = Random.nextInt(0, gambarSkorGacha.count())
                    imageViewNilai.setImageResource(gambarSkorGacha[randSkorGacha])
                    skorGachaFun(randSkorGacha)

                    if(randSkorGacha == 0 || randSkorGacha == 1)
                    {
                        textViewKondisi.text = "Ganti giliran!"
                        pemain.skor = 0
                        if(pemain == pemain1)
                        {
                            gantiGiliran(pemain2)
                            pemain = pemain2
                            tick = 4
                            progressBarWaktu.setProgress(100)
                            countGachaAntiCurang.start()
                        }
                        else
                        {
                            gantiGiliran(pemain1)
                            pemain = pemain1
                            tick = 4
                            progressBarWaktu.setProgress(100)
                            countGachaAntiCurang.start()
                        }
                    }
                    else
                    {
                        buttonGacha.isEnabled = false
                        buttonGuess.isEnabled = true
                        editTextTebak.isEnabled = true

                        tick = 11
                        progressBarWaktu.setProgress(100)
                        countTebak = object : CountDownTimer(10000,1000){
                            override fun onTick(p0: Long) {

                            }
                            override fun onFinish() {

                            }
                        }.start()
                    }
                }
            }.start()
        }
    }
}