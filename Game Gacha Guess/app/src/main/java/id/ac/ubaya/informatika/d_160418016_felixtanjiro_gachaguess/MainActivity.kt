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

    }
    fun skorGachaFun(idx: Int)
    {
        if(idx in 2 until 7)
        {
            skorGacha = 100
        }
        else if(idx in 7 until 11)
        {
            skorGacha = 200
        }
        else if(idx in 11 until 14)
        {
            skorGacha = 500
        }
        else if(idx in 14 until 16)
        {
            skorGacha = 1000
        }
        else if(idx == 16)
        {
            skorGacha = 2500
        }
    }
}