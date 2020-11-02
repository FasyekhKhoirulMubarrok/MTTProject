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
    }
}