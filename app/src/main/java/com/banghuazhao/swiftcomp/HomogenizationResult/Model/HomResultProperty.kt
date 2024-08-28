package com.banghuazhao.swiftcomp.HomogenizationResult.Model

import java.io.Serializable
import kotlin.math.abs


class HomResultProperty(var name: String, var valueText: String): Serializable {

    init {
        setupValueText()
    }

    private fun setupValueText() {
        val value = valueText.toDoubleOrNull()
        if (value == null) {
            valueText = "Not available"
            return
        }

        valueText = when {
            abs(value!!) >= 1e6 -> {
                String.format("%.3e", value)
            }
            abs(value!!) >= 0.001 -> {
                String.format( "%.3f", value)
            }
            value == 0.0 -> {
                "0"
            }
            else -> {
                String.format( "%.3e", value)
            }
        }
    }

}