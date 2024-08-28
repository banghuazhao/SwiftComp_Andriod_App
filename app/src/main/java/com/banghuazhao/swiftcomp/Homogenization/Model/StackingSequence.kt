package com.banghuazhao.swiftcomp.Homogenization.Model

import android.util.Log
import androidx.annotation.ArrayRes
import okio.utf8Size
import java.io.File.separator
import kotlin.math.log

class StackingSequence(var stackingSequenceText: String, var layerThicknessText: String, val maxNumOfLayers: Int) {

    var sectionTitle: String = "Stacking Sequence"
    var rBefore: Int = 1
    var rAfter: Int = 1
    var symmetry: Boolean = false
    var tooManyLayers: Boolean = false
    var stackingSequence: MutableList<Double>?

    val stackingSequenceAPI: String
    get() {
        return stackingSequence?.joinToString(" ") { it.toString() } ?: ""
    }

    init {
        stackingSequence = parseStackingSequenceText(stackingSequenceText)
    }

    fun changeLayerThickness(newLayerThickness: String) {
        layerThicknessText = newLayerThickness
    }

    fun changeChackingSequence(newStackingSequence : String) {
        stackingSequenceText = newStackingSequence
        stackingSequence = parseStackingSequenceText(newStackingSequence)
    }

    private fun parseStackingSequenceText(stackingSequenceText: String) : MutableList<Double>? {
        var baseLayup: String
        var baseLayupSequence = mutableListOf<Double>()
        var layupSequence = mutableListOf<Double>()
        var numberOfLayers = 0

        if (stackingSequenceText == "") return null

        val str = stackingSequenceText

        if (str.split("]")[1].isNotBlank()) {
            baseLayup = str.split("]")[0].replace("[","")
            var rsr = str.split("]")[1]
            if (rsr.contains("s") && rsr.length >= 2) {
                symmetry = true
                val i = rsr.split("s")[0].toIntOrNull()
                val j = rsr.split("s")[1].toIntOrNull()
                if ((i != null) && (j != null)) {
                    rBefore = i
                    rAfter = j
                } else {
                    return null
                }
            } else if (rsr.contains("s")) {
                symmetry = true
                if ((rsr[0].toString() == "s") && (rsr == "s")) {
                    rAfter = 1
                    rBefore = 1
                } else if (rsr[0].toString() == "s") {
                    rBefore = 1
                    if (rsr.split("s").isNotEmpty()) {
                        val i = rsr.split("s")[0].toIntOrNull()
                        if (i != null) {
                            rAfter = i
                        } else {
                            return null
                        }
                    } else {
                        return null
                    }
                } else {
                    rAfter = 1
                    val i = rsr.split("s")[0].toIntOrNull()
                    if (i != null) {
                        rBefore = i
                    } else {
                        return null
                    }
                }
            } else {
                symmetry = false
                rBefore = 1
                val i = rsr.toIntOrNull()
                if (i != null) {
                    rAfter = i
                } else {
                    return null
                }
            }
        } else {
            baseLayup = str.replace("]","").replace("[","")
            rBefore = 1
            rAfter = 1
            symmetry = false
        }

        baseLayup.split("/")

        for (i in baseLayup.split( "/")) {
            val j = i.toDoubleOrNull()
            if (j != null) {
                baseLayupSequence.add(j)
            } else {
                return null
            }
        }

        numberOfLayers = if (symmetry)
            (baseLayupSequence.size * rBefore * 2 * rAfter) else
            (baseLayupSequence.size * rBefore * rAfter)

        if (numberOfLayers > maxNumOfLayers) {
            tooManyLayers = true
            return null
        }

        repeat(rBefore) {
            for (i in baseLayupSequence) {
                layupSequence.add(i)
            }
        }

        baseLayupSequence = layupSequence

        if (symmetry) {
            for (i in baseLayupSequence.reversed()) {
                layupSequence.add(i)
            }
        }

        baseLayupSequence = layupSequence

        if (rAfter > 1) {
            repeat(rAfter-1) {
                for (i in baseLayupSequence) {
                    layupSequence.add(i)
                }
            }
        }
        return layupSequence
    }

}