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

}