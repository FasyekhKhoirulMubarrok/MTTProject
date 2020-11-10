package id.ac.ubaya.informatika.d_160418016_felixtanjiro_gachaguess

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
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

        val adapter = ArrayAdapter(this, R.layout.my_spinner_layout, Global.tipeKategoriSoal)
        adapter.setDropDownViewResource(R.layout.my_spinner_item_layout)
        spinnerKategori.adapter = adapter

        buttonGachaGuess.setOnClickListener {
            if(editTextTextPersonName1.text.isNotEmpty() && editTextTextPersonName2.text.isNotEmpty())
            {
                val pemain = Intent(this, MainActivity::class.java)
                pemain.putExtra(pemain1, editTextTextPersonName1.text.toString())
                pemain.putExtra(pemain2, editTextTextPersonName2.text.toString())
                pemain.putExtra(tipeSoal, spinnerKategori.selectedItem.toString())
                startActivity(pemain)
                finish()

                var q = Volley.newRequestQueue(this)
                val url = "http://10.0.2.2/mtt/addPlayer.php"
                var stringRequest = object: StringRequest(com.android.volley.Request.Method.POST, url,
                    {
                        Log.d("insert",it)
                    },
                    {
                        Log.d("insert",it.message.toString())
                    }
                ){
                    override  fun  getParams(): MutableMap<String,String>{
                        var params = HashMap<String,String>()
                        params.put("namapemain1",editTextTextPersonName1.text.toString())
                        params.put("namapemain2",editTextTextPersonName2.text.toString())
                        params.put("kategori", spinnerKategori.selectedItem.toString())
                        return  params
                    }
                }
                q.add(stringRequest)
            }
            else
            {
                Toast.makeText(this, "Masukkan Nama Pemain Terlebih Dahulu", Toast.LENGTH_SHORT).show()
            }
        }
    }
}