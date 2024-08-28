package com.banghuazhao.swiftcomp.HomogenizationResult.Model

import android.util.Log
import com.beust.klaxon.JsonObject
import java.io.Serializable

class HomSolidResult(): Serializable {

    var effectiveSolidStiffnessArray: MutableList<HomResultMatrix> = mutableListOf()
    var engineeringConstantsArray: MutableList<HomResultProperty> = mutableListOf()
    var swiftcompCwd: String = ""
    var route: String =""

    constructor(routeText: String, jsonData: JsonObject): this() {
        route = routeText

        Log.d("jsonData", jsonData["solidModelResult"].toString())

        swiftcompCwd = jsonData["swiftcompCwd"] as String

        val effectiveSolidStiffness =
            (jsonData["solidModelResult"] as JsonObject)["effectiveSolidStiffness"] as JsonObject

        val engineeringConstants =
            (jsonData["solidModelResult"] as JsonObject)["engineeringConstants"] as JsonObject

        effectiveSolidStiffnessArray = mutableListOf(
            HomResultMatrix(effectiveSolidStiffness["C11"].toString()),
            HomResultMatrix(effectiveSolidStiffness["C12"].toString()),
            HomResultMatrix(effectiveSolidStiffness["C13"].toString()),
            HomResultMatrix(effectiveSolidStiffness["C14"].toString()),
            HomResultMatrix(effectiveSolidStiffness["C15"].toString()),
            HomResultMatrix(effectiveSolidStiffness["C16"].toString()),

            HomResultMatrix(effectiveSolidStiffness["C12"].toString()),
            HomResultMatrix(effectiveSolidStiffness["C22"].toString()),
            HomResultMatrix(effectiveSolidStiffness["C23"].toString()),
            HomResultMatrix(effectiveSolidStiffness["C24"].toString()),
            HomResultMatrix(effectiveSolidStiffness["C25"].toString()),
            HomResultMatrix(effectiveSolidStiffness["C26"].toString()),

            HomResultMatrix(effectiveSolidStiffness["C13"].toString()),
            HomResultMatrix(effectiveSolidStiffness["C23"].toString()),
            HomResultMatrix(effectiveSolidStiffness["C33"].toString()),
            HomResultMatrix(effectiveSolidStiffness["C34"].toString()),
            HomResultMatrix(effectiveSolidStiffness["C35"].toString()),
            HomResultMatrix(effectiveSolidStiffness["C36"].toString()),

            HomResultMatrix(effectiveSolidStiffness["C14"].toString()),
            HomResultMatrix(effectiveSolidStiffness["C24"].toString()),
            HomResultMatrix(effectiveSolidStiffness["C34"].toString()),
            HomResultMatrix(effectiveSolidStiffness["C44"].toString()),
            HomResultMatrix(effectiveSolidStiffness["C45"].toString()),
            HomResultMatrix(effectiveSolidStiffness["C46"].toString()),

            HomResultMatrix(effectiveSolidStiffness["C15"].toString()),
            HomResultMatrix(effectiveSolidStiffness["C25"].toString()),
            HomResultMatrix(effectiveSolidStiffness["C35"].toString()),
            HomResultMatrix(effectiveSolidStiffness["C45"].toString()),
            HomResultMatrix(effectiveSolidStiffness["C55"].toString()),
            HomResultMatrix(effectiveSolidStiffness["C56"].toString()),

            HomResultMatrix(effectiveSolidStiffness["C16"].toString()),
            HomResultMatrix(effectiveSolidStiffness["C26"].toString()),
            HomResultMatrix(effectiveSolidStiffness["C36"].toString()),
            HomResultMatrix(effectiveSolidStiffness["C46"].toString()),
            HomResultMatrix(effectiveSolidStiffness["C56"].toString()),
            HomResultMatrix(effectiveSolidStiffness["C66"].toString())
        )

        engineeringConstantsArray = mutableListOf(
            HomResultProperty("Young's Modulus E₁", engineeringConstants["E1"].toString()),
            HomResultProperty("Young's Modulus E₂", engineeringConstants["E2"].toString()),
            HomResultProperty("Young's Modulus E₃", engineeringConstants["E3"].toString()),
            HomResultProperty("Shear Modulus G₁₂", engineeringConstants["G12"].toString()),
            HomResultProperty("Shear Modulus G₁₃", engineeringConstants["G13"].toString()),
            HomResultProperty("Shear Modulus G₂₃", engineeringConstants["G23"].toString()),
            HomResultProperty("Poisson's Ratio ν₁₂", engineeringConstants["nu12"].toString()),
            HomResultProperty("Poisson's Ratio ν₁₃", engineeringConstants["nu13"].toString()),
            HomResultProperty("Poisson's Ratio ν₂₃", engineeringConstants["nu23"].toString())
        )
    }


}