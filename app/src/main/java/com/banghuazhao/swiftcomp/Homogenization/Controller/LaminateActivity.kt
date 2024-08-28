package com.banghuazhao.swiftcomp.Homogenization.Controller

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.banghuazhao.swiftcomp.Homogenization.Model.MaterialOrthotropic
import com.banghuazhao.swiftcomp.Homogenization.Model.StackingSequence
import com.banghuazhao.swiftcomp.Homogenization.Model.StructuralModel
import com.banghuazhao.swiftcomp.Homogenization.Model.TypeOfAnalysis
import com.banghuazhao.swiftcomp.HomogenizationResult.Controller.HomPlateResultActivity
import com.banghuazhao.swiftcomp.HomogenizationResult.Controller.HomSolidResultActivity
import com.banghuazhao.swiftcomp.HomogenizationResult.Model.HomPlateResult
import com.banghuazhao.swiftcomp.HomogenizationResult.Model.HomSolidResult
import com.banghuazhao.swiftcomp.R
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import com.satyajit.thespotsdialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_homogenization.*
import okhttp3.*
import okhttp3.HttpUrl
import java.io.IOException
import java.lang.StringBuilder


class LaminateActivity : AppCompatActivity() {

    private val laminateAdapter = LaminateAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homogenization)
        title = "Laminate"
        recycler_view_homogenizaiton.layoutManager = LinearLayoutManager(this)
        recycler_view_homogenizaiton.adapter = laminateAdapter
        recycler_view_homogenizaiton.setBackgroundColor(
            ContextCompat.getColor(
                this,
                R.color.SCBackground
            )
        )

        homogenization_button.setOnClickListener {

            val structuralModel = laminateAdapter.models[1] as StructuralModel
            val typeOfAnalysis = laminateAdapter.models[2] as TypeOfAnalysis
            val stackingSequence = laminateAdapter.models[4] as StackingSequence
            val laminateMaterial = laminateAdapter.models[6] as MaterialOrthotropic

            if (stackingSequence.tooManyLayers) {
                Toast.makeText(
                    this@LaminateActivity,
                    "Too many layers. The maximum number of layers is ${stackingSequence.maxNumOfLayers}.",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            if (stackingSequence.stackingSequence == null) {
                Toast.makeText(
                    this@LaminateActivity,
                    "The stacking Sequence is wrong. Please double check.",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            val layerThickness = stackingSequence.layerThicknessText.toDoubleOrNull()
            if (layerThickness == null || layerThickness <= 0.0) {
                Toast.makeText(
                    this@LaminateActivity,
                    "The layer thickness should be a positive double number",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }


            if (!laminateMaterial.isMaterialValide()) {
                Toast.makeText(
                    this@LaminateActivity,
                    "The lamina material is wrong. Please double check.",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            val homogenizationUrl:HttpUrl

            if (structuralModel.macModel == StructuralModel.MacModel.Solid) {

                homogenizationUrl = HttpUrl.Builder()
                    .scheme("http")
                    .host("128.46.6.100")
                    .port(8888)
                    .addPathSegment("Laminate")
                    .addPathSegment("homogenization")
                    .addQueryParameter("typeOfAnalysis", typeOfAnalysis.typeOfAnalysisAPI)
                    .addQueryParameter("structuralModel", structuralModel.structrualModelAPI)
                    .addQueryParameter("structuralSubmodel", structuralModel.structrualSubmodelAPI)
                    .addQueryParameter("stackingSequence", stackingSequence.stackingSequenceAPI)
                    .addQueryParameter("layerThickness", stackingSequence.layerThicknessText)
                    .addQueryParameter("laminaMaterialType", "Orthotropic")
                    .addQueryParameter("E1", laminateMaterial.e1?.toString() ?: "0")
                    .addQueryParameter("E2", laminateMaterial.e2?.toString() ?: "0")
                    .addQueryParameter("E3", laminateMaterial.e3?.toString() ?: "0")
                    .addQueryParameter("G12", laminateMaterial.g12?.toString() ?: "0")
                    .addQueryParameter("G13", laminateMaterial.g13?.toString() ?: "0")
                    .addQueryParameter("G23", laminateMaterial.g23?.toString() ?: "0")
                    .addQueryParameter("nu12", laminateMaterial.nu12?.toString() ?: "0")
                    .addQueryParameter("nu13", laminateMaterial.nu13?.toString() ?: "0")
                    .addQueryParameter("nu23", laminateMaterial.nu23?.toString() ?: "0")
                    .build()
            } else {
                homogenizationUrl = HttpUrl.Builder()
                    .scheme("http")
                    .host("128.46.6.100")
                    .port(8888)
                    .addPathSegment("Laminate")
                    .addPathSegment("homogenization")
                    .addQueryParameter("typeOfAnalysis", typeOfAnalysis.typeOfAnalysisAPI)
                    .addQueryParameter("structuralModel", structuralModel.structrualModelAPI)
                    .addQueryParameter("structuralSubmodel", structuralModel.structrualSubmodelAPI)
                    .addQueryParameter("k12_plate", "0.0")
                    .addQueryParameter("k21_plate", "0.0")
                    .addQueryParameter("stackingSequence", stackingSequence.stackingSequenceAPI)
                    .addQueryParameter("layerThickness", stackingSequence.layerThicknessText)
                    .addQueryParameter("laminaMaterialType", "Orthotropic")
                    .addQueryParameter("E1", laminateMaterial.e1?.toString() ?: "0")
                    .addQueryParameter("E2", laminateMaterial.e2?.toString() ?: "0")
                    .addQueryParameter("E3", laminateMaterial.e3?.toString() ?: "0")
                    .addQueryParameter("G12", laminateMaterial.g12?.toString() ?: "0")
                    .addQueryParameter("G13", laminateMaterial.g13?.toString() ?: "0")
                    .addQueryParameter("G23", laminateMaterial.g23?.toString() ?: "0")
                    .addQueryParameter("nu12", laminateMaterial.nu12?.toString() ?: "0")
                    .addQueryParameter("nu13", laminateMaterial.nu13?.toString() ?: "0")
                    .addQueryParameter("nu23", laminateMaterial.nu23?.toString() ?: "0")
                    .build()
            }

            Log.d("homogenizationUrl", homogenizationUrl.toString())
            println(homogenizationUrl.toString())

            val request = Request.Builder().url(homogenizationUrl).build()

            val client = OkHttpClient()

            val dialog: AlertDialog = SpotsDialog.Builder()
                .setContext(this)
                .setMessage("Calculating")
                .setCancelable(false)
                .build()

            dialog.show()

            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    dialog.dismiss()

                    runOnUiThread {
                        Toast.makeText(
                            this@LaminateActivity,
                            "Calculation failed. Please double check the input and the Internet.",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                    Log.d("http", "laminate homogenization failed")
                }

                override fun onResponse(call: Call, response: Response) {

                    dialog.dismiss()

                    val body = response.body?.string() ?: ""

                    Log.d("http",body)

                    if (body.contains("error")) {
                        runOnUiThread {
                            Toast.makeText(
                                this@LaminateActivity,
                                "Calculation failed. Please double check the input.",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                        return
                    }

                    val jsonData: JsonObject =
                        Parser.default().parse(StringBuilder(body)) as JsonObject

                    if (structuralModel.macModel == StructuralModel.MacModel.Plate) {
                        val homPlateResult = HomPlateResult("Laminate", jsonData)

                        val intent = Intent(
                            this@LaminateActivity,
                            HomPlateResultActivity::class.java
                        )
                        intent.putExtra("homPlateResult", homPlateResult)
                        startActivity(intent)
                    } else if (structuralModel.macModel == StructuralModel.MacModel.Solid) {
                        val homSolidResult = HomSolidResult("Laminate", jsonData)

                        val intent = Intent(
                            this@LaminateActivity,
                            HomSolidResultActivity::class.java
                        )
                        intent.putExtra("homSolidResult", homSolidResult)
                        startActivity(intent)
                    }

                }

            })
        }
    }

}