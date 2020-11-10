package id.ac.ubaya.informatika.d_160418016_felixtanjiro_gachaguess

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_pemenang.*

class PemenangActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pemenang)

        textViewPemenang.text = intent.getStringExtra(MainActivity.nama).toString()
        textViewScorePemenang.text = intent.getStringExtra(MainActivity.skor).toString()
    }

    override fun onBackPressed() {
        val intent = Intent(this, PemainActivity::class.java)
        startActivity(intent)
        finish()
    }
}