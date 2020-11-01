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

    var skorPemain1 = 0
    var skorPemain2 = 0
    var tipeSoal = ""
    var random = 0
    var garisBantuJawaban = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}