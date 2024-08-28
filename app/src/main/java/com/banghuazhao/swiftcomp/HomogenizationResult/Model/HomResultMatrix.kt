package com.banghuazhao.swiftcomp.HomogenizationResult.Model

import java.io.Serializable
import kotlin.math.abs

class HomResultMatrix(var valueText: String): Serializable {
    private var maxValue: Double = 0.0

    init {
        setupValueText()
    }

    constructor(valueText: String, valueDict: HashMap<String, String>): this(valueText) {
        maxValue = valueDict.values.map { it.toDouble() }?.max() ?: 0.0
        setupValueText()
    }

    private fun setupValueText() {
        val value = valueText.toDoubleOrNull()
        if (value == null) {
            valueText = "Not available"
            return
        }

        valueText = if (abs(value) >= 1e6) {
            String.format( "%.3e", value)
        } else if (abs(value) >= 0.001) {
            String.format( "%.3f", value)
        } else if (value == 0.0) {
            "0"
        } else {
            String.format( "%.3e", value)
        }

        if (value != 0.0) {
            if (abs(maxValue / value) > 1e12) {
                valueText = "0"
            }
        } else {
            valueText = "0"
        }
    }
}