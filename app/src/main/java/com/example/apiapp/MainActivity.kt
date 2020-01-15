package com.example.apiapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class MainActivity : AppCompatActivity() {

    internal lateinit var list: List<POJO>
    internal lateinit var customAdapter: CustomAdapter
    internal lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)


        val retrofit =
            Retrofit.Builder().baseUrl(NasaApi.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        val api = retrofit.create(NasaApi::class.java)

        val cal = Calendar.getInstance()
        cal.timeZone = TimeZone.getTimeZone("GMT")

        val todayDate = getDate(cal)

        cal.add(Calendar.DATE, -7)
        val weekBeforeDate = getDate(cal)

        val call = api.getApods(weekBeforeDate, todayDate)
        call.enqueue(object : Callback<List<POJO>> {
            override fun onResponse(call: Call<List<POJO>>, response: Response<List<POJO>>) {
                list = response.body()
                customAdapter = CustomAdapter(list, applicationContext)
                recyclerView.adapter = customAdapter
                recyclerView.layoutManager = LinearLayoutManager(applicationContext)
            }

            override fun onFailure(call: Call<List<POJO>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Fail", Toast.LENGTH_SHORT).show()
            }
        })


    }

    fun getDate(cal: Calendar): String {
        return "" + cal.get(Calendar.YEAR) + "-" +
                (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DATE)
    }
}
