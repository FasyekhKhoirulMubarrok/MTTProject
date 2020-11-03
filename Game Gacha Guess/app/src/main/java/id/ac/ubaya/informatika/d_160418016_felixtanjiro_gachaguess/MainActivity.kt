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

    var randSkorGacha = 0
    var tick = 0
    var tebakanBenar = 0
    var skorGacha = 0
    lateinit var countTebak : CountDownTimer
    lateinit var countGachaAntiCurang : CountDownTimer


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
                                textViewKondisi.text = "Jawab sekarang!"
                                tick--
                                textViewWaktu.text = tick.toString()
                                progressBarWaktu.progress = tick.toInt()*10
                            }
                            override fun onFinish() {
                                textViewWaktu.text = "Waktu habis!"
                                textViewKondisi.text = "Waktu habis!"
                                editTextTebak.isEnabled = false
                                buttonGuess.isEnabled = false
                                buttonGacha.isEnabled = true
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
                        }.start()
                    }
                }
            }.start()
        }
    }

    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Yakin mau keluar? Kamu otomatis kalah lho!")

        builder.setPositiveButton("KELUAR"){dialogInterface, i ->
            if(pemain == pemain1)
            {
                pemain = pemain2
            }
            else if(pemain == pemain2)
            {
                pemain = pemain1
            }

            val pemenang = Intent(this, PemenangActivity::class.java)
            pemenang.putExtra(nama, pemain.nama.toString())
            pemenang.putExtra(skor, pemain.skor.toString())
            startActivity(pemenang)
            finish()
        }
        builder.setNegativeButton("BATAL"){dialogInterface, i -> null }

        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(true)
        alertDialog.show()
    }

    fun gantiGiliran(giliran: Pemain){
        textViewGiliran.text = giliran.nama
        textViewScore.text = giliran.skor.toString()
        progressBarWaktu.setProgress(100)
        textViewWaktu.text = 10.toString()
        editTextTebak.setText("")

    fun kumpulanSoal(kategori:String): Array<Soal> {
        val kumpulanPertanyaan:Array<Soal>
        if(kategori == "Hewan"){
            kumpulanPertanyaan = arrayOf(
                Soal("Hewan yang memiliki belalai", "gajah"),
                Soal("Hewan yang bernafas menggunakan insang", "ikan"),
                Soal("Hewan yang tidur di siang hari", "kelelawar")
            )
        }
        else if(kategori == "Makanan"){
            kumpulanPertanyaan = arrayOf(
                Soal("Makanan khas lebaran", "ketupat"),
                Soal("Makanan yang bisa jadi ironman", "odading"),
                Soal("Makanan yang dipercaya bikin panjang umur", "mie")
            )
        }
        else{
            kumpulanPertanyaan = arrayOf(
                Soal("Sebutan untuk kota pahlawan", "surabaya"),
                Soal("Sebutan untuk kota lautan api", "bandung"),
                Soal("Ibukota negara Indonesia", "jakarta")
            )
        }
        return kumpulanPertanyaan

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