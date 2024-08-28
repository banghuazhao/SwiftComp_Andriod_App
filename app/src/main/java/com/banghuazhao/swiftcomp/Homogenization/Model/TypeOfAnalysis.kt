package com.banghuazhao.swiftcomp.Homogenization.Model

class TypeOfAnalysis(var type: Type) {

    enum class Type {
        Elastic,
        ThermoElastic
    }

    val typeOfAnalysisAPI: String
        get() {
            return if (type == Type.Elastic) {
                "Elastic"
            } else {
                "Thermoelastic"
            }
        }

}