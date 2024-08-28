package com.banghuazhao.swiftcomp.HomogenizationResult.Model

import android.util.Log
import com.beust.klaxon.JsonObject
import java.io.Serializable

class HomPlateResult(): Serializable {

    var effectivePlateStiffnessArray: MutableList<HomResultMatrix> = mutableListOf()
    var inPlanePropertiesArray: MutableList<HomResultProperty> = mutableListOf()
    var flexuralPropertiesArray: MutableList<HomResultProperty> = mutableListOf()
    var swiftcompCwd: String = ""
    var route: String =""

    constructor(routeText: String, jsonData: JsonObject): this() {
        route = routeText

        Log.d("jsonData", jsonData["plateModelResult"].toString())

        swiftcompCwd = jsonData["swiftcompCwd"] as String

        val effectivePlateStiffness =
            (jsonData["plateModelResult"] as JsonObject)["effectivePlateStiffness"] as JsonObject

        val inPlaneProperties =
            (jsonData["plateModelResult"] as JsonObject)["inPlaneProperties"] as JsonObject

        val flexuralProperties =
            (jsonData["plateModelResult"] as JsonObject)["flexuralProperties"] as JsonObject

        effectivePlateStiffnessArray = mutableListOf(
            HomResultMatrix(effectivePlateStiffness["A11"].toString()),
            HomResultMatrix(effectivePlateStiffness["A12"].toString()),
            HomResultMatrix(effectivePlateStiffness["A16"].toString()),
            HomResultMatrix(effectivePlateStiffness["B11"].toString()),
            HomResultMatrix(effectivePlateStiffness["B12"].toString()),
            HomResultMatrix(effectivePlateStiffness["B16"].toString()),

            HomResultMatrix(effectivePlateStiffness["A12"].toString()),
            HomResultMatrix(effectivePlateStiffness["A22"].toString()),
            HomResultMatrix(effectivePlateStiffness["A26"].toString()),
            HomResultMatrix(effectivePlateStiffness["B12"].toString()),
            HomResultMatrix(effectivePlateStiffness["B22"].toString()),
            HomResultMatrix(effectivePlateStiffness["B26"].toString()),

            HomResultMatrix(effectivePlateStiffness["A16"].toString()),
            HomResultMatrix(effectivePlateStiffness["A26"].toString()),
            HomResultMatrix(effectivePlateStiffness["A66"].toString()),
            HomResultMatrix(effectivePlateStiffness["B16"].toString()),
            HomResultMatrix(effectivePlateStiffness["B26"].toString()),
            HomResultMatrix(effectivePlateStiffness["B66"].toString()),

            HomResultMatrix(effectivePlateStiffness["B11"].toString()),
            HomResultMatrix(effectivePlateStiffness["B12"].toString()),
            HomResultMatrix(effectivePlateStiffness["B16"].toString()),
            HomResultMatrix(effectivePlateStiffness["D11"].toString()),
            HomResultMatrix(effectivePlateStiffness["D12"].toString()),
            HomResultMatrix(effectivePlateStiffness["D16"].toString()),

            HomResultMatrix(effectivePlateStiffness["B12"].toString()),
            HomResultMatrix(effectivePlateStiffness["B22"].toString()),
            HomResultMatrix(effectivePlateStiffness["B26"].toString()),
            HomResultMatrix(effectivePlateStiffness["D12"].toString()),
            HomResultMatrix(effectivePlateStiffness["D22"].toString()),
            HomResultMatrix(effectivePlateStiffness["D26"].toString()),

            HomResultMatrix(effectivePlateStiffness["B16"].toString()),
            HomResultMatrix(effectivePlateStiffness["B26"].toString()),
            HomResultMatrix(effectivePlateStiffness["B66"].toString()),
            HomResultMatrix(effectivePlateStiffness["D16"].toString()),
            HomResultMatrix(effectivePlateStiffness["D26"].toString()),
            HomResultMatrix(effectivePlateStiffness["D66"].toString())
        )

        inPlanePropertiesArray = mutableListOf(
            HomResultProperty("Young's Modulus E₁", inPlaneProperties["E1"].toString()),
            HomResultProperty("Young's Modulus E₂", inPlaneProperties["E2"].toString()),
            HomResultProperty("Shear Modulus G₁₂", inPlaneProperties["G12"].toString()),
            HomResultProperty("Poisson's Ratio ν₁₂", inPlaneProperties["nu12"].toString()),
            HomResultProperty("Poisson's Ratio ν₁₂", inPlaneProperties["nu12"].toString()),
            HomResultProperty("Mutual Influence η₁₂,₁", inPlaneProperties["eta121"].toString()),
            HomResultProperty("Mutual Influence η₁₂,2", inPlaneProperties["eta122"].toString())
        )

        flexuralPropertiesArray = mutableListOf(
            HomResultProperty("Young's Modulus E₁", flexuralProperties["E1"].toString()),
            HomResultProperty("Young's Modulus E₂", flexuralProperties["E2"].toString()),
            HomResultProperty("Shear Modulus G₁₂", flexuralProperties["G12"].toString()),
            HomResultProperty("Poisson's Ratio ν₁₂", flexuralProperties["nu12"].toString()),
            HomResultProperty("Poisson's Ratio ν₁₂", flexuralProperties["nu12"].toString()),
            HomResultProperty("Mutual Influence η₁₂,₁", flexuralProperties["eta121"].toString()),
            HomResultProperty("Mutual Influence η₁₂,2", flexuralProperties["eta122"].toString())
        )
    }
}

