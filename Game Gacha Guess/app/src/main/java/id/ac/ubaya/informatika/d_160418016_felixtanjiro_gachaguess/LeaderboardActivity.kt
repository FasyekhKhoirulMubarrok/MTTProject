package id.ac.ubaya.informatika.d_160418016_felixtanjiro_gachaguess

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_leaderboard.*
import org.json.JSONObject

class LeaderboardActivity : AppCompatActivity() {
    var leaderboards:ArrayList<Leaderboard> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leaderboard)
        Bacadata()
        if(leaderboards.size >0) {
            txtPemain1.text = leaderboards[0].Pemain
            txtPemain2.text = leaderboards[1].Pemain
            txtPemain3.text = leaderboards[2].Pemain
            txtPemain4.text = leaderboards[3].Pemain
            txtPemain5.text = leaderboards[4].Pemain

            skor1.text = leaderboards[0].Skor.toString()
            skor2.text = leaderboards[1].Skor.toString()
            skor3.text = leaderboards[2].Skor.toString()
            skor4.text = leaderboards[3].Skor.toString()
            skor5.text = leaderboards[4].Skor.toString()
        }
        System.out.println(leaderboards.size)
        btnBack.setOnClickListener {
            val pemenang = Intent(this, PemainActivity::class.java)
            startActivity(pemenang)
            finish()
        }
    }
    fun Bacadata(){
        val q = Volley.newRequestQueue(this)
        val url = "http://ubaya.prototipe.net/nmp160418024/getPemenang.php"
        var stringRequest = StringRequest(
            Request.Method.POST, url,
            Response.Listener<String> {
                Log.d("apiresult", it)
                val obj = JSONObject(it)
                if(obj.getString("result") == "OK") {
                    val data = obj.getJSONArray("data")
                    for(i in 0 until data.length()) {
                        val playObj = data.getJSONObject(i)
                        val playlist = Leaderboard(
                            playObj.getInt("id"),
                            playObj.getString("namaPemenang"),
                            playObj.getInt("skor")
                        )
                        leaderboards.add(playlist)
                    }
                    Log.d("cekisiarray", leaderboards.toString())
                }
            },
            Response.ErrorListener {
                Log.e("apiresult", it.message.toString())
            })
        q.add(stringRequest)
    }
}