package com.banghuazhao.swiftcomp.CompositeModels.Controller

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.banghuazhao.swiftcomp.R
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_composite_model.*

// Banner ads
// ca-app-pub-4766086782456413/8636379908

// Test Banner ads
// ca-app-pub-3940256099942544/6300978111


class CompositeModelActivity : AppCompatActivity() {

    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_composite_model)

        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        title = "Composite Models"
        recycler_view_composite_model.layoutManager = LinearLayoutManager(this)
        recycler_view_composite_model.adapter =
            CompositeModelAdapter()
        recycler_view_composite_model.setBackgroundColor(ContextCompat.getColor(this,
            R.color.SCBackground
        ))
        recycler_view_composite_model.addItemDecoration(
            DividerItemDecoration(
                recycler_view_composite_model.context,
                DividerItemDecoration.VERTICAL
            )
        )

    }

}


