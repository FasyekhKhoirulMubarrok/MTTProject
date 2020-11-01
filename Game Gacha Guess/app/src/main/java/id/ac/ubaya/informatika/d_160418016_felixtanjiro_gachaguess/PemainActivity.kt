package id.ac.ubaya.informatika.d_160418016_felixtanjiro_gachaguess

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_pemain.*

class PemainActivity : AppCompatActivity() {
    companion object{
        val pemain1 = "pemain1"
        val pemain2 = "pemain2"
        val tipeSoal ="tipeSoal"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pemain)

<<<<<<< HEAD
        val adapter = ArrayAdapter(this, R.layout.my_spinner_layout, Global.tipeKategoriSoal)
        adapter.setDropDownViewResource(R.layout.my_spinner_item_layout)
        spinnerKategori.adapter = adapter
=======
        buttonGachaGuess.setOnClickListener {
            if(editTextTextPersonName1.text.isNotEmpty() && editTextTextPersonName2.text.isNotEmpty())
            {
                val pemain = Intent(this, MainActivity::class.java)
                pemain.putExtra(pemain1, editTextTextPersonName1.text.toString())
                pemain.putExtra(pemain2, editTextTextPersonName2.text.toString())
                pemain.putExtra(tipeSoal, spinnerKategori.selectedItem.toString())
                startActivity(pemain)
                finish()
            }
            else
            {
                Toast.makeText(this, "Masukkan Nama Pemain Terlebih Dahulu", Toast.LENGTH_SHORT).show()
            }
        }
>>>>>>> kirim-data-pemain
    }
}