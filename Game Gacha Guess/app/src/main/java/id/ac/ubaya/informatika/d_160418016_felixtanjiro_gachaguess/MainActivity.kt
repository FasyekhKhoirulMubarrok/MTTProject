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
        pemain1 = Pemain(intent.getStringExtra(PemainActivity.pemain1).toString(), skorPemain1)
        pemain2 = Pemain(intent.getStringExtra(PemainActivity.pemain2).toString(),skorPemain2)
        tipeSoal = intent.getStringExtra(PemainActivity.tipeSoal).toString()
        textViewKategori.text = tipeSoal
        pemain = pemain1
        gantiGiliran(pemain1)
        val pertanyaan = kumpulanSoal(tipeSoal)
        random = Random.nextInt(0,pertanyaan.count())
        textViewHint.text = pertanyaan[random].soal
    }
}