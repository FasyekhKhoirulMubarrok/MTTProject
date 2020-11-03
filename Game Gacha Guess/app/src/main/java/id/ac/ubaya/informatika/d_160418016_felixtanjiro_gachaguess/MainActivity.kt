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

        buttonGuess.setOnClickListener {
            countTebak.cancel()

            if(editTextTebak.text.isNotEmpty())
            {
                var guessText = editTextTebak.text.toString().toCharArray()

                tebakanBenar = 0
                for (i in 0 until tampilJawaban.size) {
                    if (guessText[0] == tampilJawaban[i] && cekJawaban[i] != guessText[0] ) {
                        cekJawaban[i] =  tampilJawaban[i]
                        tebakanBenar++
                    } else {
                        if (tampilJawaban[i] != cekJawaban[i]) {
                            cekJawaban[i] = "_".single()
                        }
                    }
                }

                if(tebakanBenar > 0)
                {
                    pemain.skor += tebakanBenar*skorGacha
                    textViewScore.text = pemain.skor.toString()
                    textViewKondisi.text = "Benar! Gacha lagi!"

                    var jawabanTerbaru = ""
                    for(i in 0 until cekJawaban.size)
                    {
                        jawabanTerbaru += (cekJawaban[i] + " ").capitalize()
                    }
                    textViewJawaban.text = jawabanTerbaru

                    editTextTebak.isEnabled = false
                    buttonGuess.isEnabled = false
                    buttonGacha.isEnabled = true

                    if(textViewJawaban.text.equals(pertanyaan[random].jawaban.toCharArray().joinToString(separator = " ").toUpperCase() + " ")){
                        val builder = AlertDialog.Builder(this)
                        builder.setMessage("Permainan berakhir!")

                        builder.setPositiveButton("HORE!"){dialogInterface, i ->
                            if (pemain1.skor == pemain2.skor) {
                                pemain.nama = "Tidak ada!"
                            } else if (pemain1.skor > pemain2.skor) {
                                pemain = pemain1
                            } else if (pemain1.skor < pemain2.skor) {
                                pemain = pemain2
                            }

                            val pemenang = Intent(this, PemenangActivity::class.java)
                            pemenang.putExtra(nama, pemain.nama.toString())
                            pemenang.putExtra(skor, pemain.skor.toString())
                            startActivity(pemenang)
                            finish()
                        }

                        val alertDialog: AlertDialog = builder.create()
                        alertDialog.setCancelable(true)
                        alertDialog.show()
                    }
                    else
                    {
                        tick = 4
                        progressBarWaktu.setProgress(100)
                        countGachaAntiCurang.start()
                    }
                }
                else
                {
                    textViewKondisi.text = "Salah! Ganti giliran!"
                    editTextTebak.isEnabled = false
                    buttonGuess.isEnabled = false
                    buttonGacha.isEnabled = true
                }
            }
            else
            {
                Toast.makeText(this, "Masukkan Jawaban Terlebih Dahulu", Toast.LENGTH_SHORT).show()
            }
        }
    }
}