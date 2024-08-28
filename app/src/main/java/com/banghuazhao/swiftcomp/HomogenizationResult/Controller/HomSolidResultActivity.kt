package com.banghuazhao.swiftcomp.HomogenizationResult.Controller

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.banghuazhao.swiftcomp.Homogenization.Controller.HomSolidResultAdapter
import com.banghuazhao.swiftcomp.Homogenization.Controller.LaminateAdapter
import com.banghuazhao.swiftcomp.Homogenization.Model.StructuralModel
import com.banghuazhao.swiftcomp.HomogenizationResult.Model.HomPlateResult
import com.banghuazhao.swiftcomp.HomogenizationResult.Model.HomSolidResult
import com.banghuazhao.swiftcomp.R
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import kotlinx.android.synthetic.main.activity_hom_result.*
import kotlinx.android.synthetic.main.activity_homogenization.*
import okhttp3.*
import java.io.IOException
import java.lang.StringBuilder

class HomSolidResultActivity : AppCompatActivity() {

    var homSolidResult = HomSolidResult()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hom_result)
        title = "Homogenization Result"
        homSolidResult = intent.getSerializableExtra("homSolidResult") as HomSolidResult
        val homSolidResultAdapter = HomSolidResultAdapter(homSolidResult)
        recycler_view_hom_result.layoutManager = LinearLayoutManager(this)
        recycler_view_hom_result.adapter = homSolidResultAdapter
        recycler_view_hom_result.setBackgroundColor(
            ContextCompat.getColor(
                this,
                R.color.SCBackground
            )
        )
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onBackPressed()

        Log.d("onOptionsItemSelected", "onOptionsItemSelected")

        val deleteUrl: HttpUrl = HttpUrl.Builder()
            .scheme("http")
            .host("128.46.6.100")
            .port(8888)
            .addPathSegment(homSolidResult.route)
            .addPathSegment("delete")
            .addQueryParameter("userDirectory", homSolidResult.swiftcompCwd)
            .build()
        val client = OkHttpClient()
        val request = Request.Builder().url(deleteUrl).build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {

                Log.d("http", "homogenization files delete failed")
            }

            override fun onResponse(call: Call, response: Response) {

                val body = response.body?.string() ?: ""

                Log.d("http", body)

            }

        })

        return true
    }
}