package com.banghuazhao.swiftcomp.Homogenization.Controller

import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupWindow
import androidx.recyclerview.widget.RecyclerView
import com.banghuazhao.swiftcomp.Homogenization.Model.*
import com.banghuazhao.swiftcomp.Homogenization.View.*
import com.banghuazhao.swiftcomp.R
import kotlinx.android.synthetic.main.row_analysis_setting_homogenization.view.*

class LaminateAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val HEADER = 1
        const val METHOD = 2
        const val STRUCTURAL_MODEL = 3
        const val TYPE_OF_ANALYSIS = 4
        const val STACKING_SEQUENCE = 5
        const val LAMINATE_MATERIAL = 6
    }


    val models = listOf(
        "Analysis Setting",
        StructuralModel(StructuralModel.MacModel.Solid, StructuralModel.SubModel.CauchyContinuum),
        TypeOfAnalysis(TypeOfAnalysis.Type.Elastic),
        "Geometry Setting",
        StackingSequence("[0/90/45/-45]s","1.0",200),
        "Material Setting",
        MaterialOrthotropic(161.0,11.38,11.38,5.17,5.17,3.98,0.32,0.32,0.44))


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            HEADER -> {
                val layoutInflater = LayoutInflater.from(parent.context)
                val cellForRow = layoutInflater.inflate(R.layout.header_homogenization, parent, false)
                HomogenizationHeaderViewHolder(
                    cellForRow
                )
            }
            METHOD -> {
                val layoutInflater = LayoutInflater.from(parent.context)
                val cellForRow = layoutInflater.inflate(R.layout.row_analysis_setting_homogenization, parent, false)
                HomogenizationMethodViewHolder(
                    cellForRow
                )
            }
            STRUCTURAL_MODEL -> {
                val layoutInflater = LayoutInflater.from(parent.context)
                val cellForRow = layoutInflater.inflate(R.layout.row_analysis_setting_homogenization, parent, false)
                HomogenizationStructuralModelViewHolder(
                    cellForRow
                )
            }
            TYPE_OF_ANALYSIS -> {
                val layoutInflater = LayoutInflater.from(parent.context)
                val cellForRow = layoutInflater.inflate(R.layout.row_analysis_setting_homogenization, parent, false)
                HomogenizationTypeOfAnalysisViewHolder(
                    cellForRow
                )
            }
            STACKING_SEQUENCE -> {
                val layoutInflater = LayoutInflater.from(parent.context)
                val cellForRow = layoutInflater.inflate(R.layout.row_stacking_sequence_homogenization, parent, false)
                HomogenizationStackingSequenceViewHolder(
                    cellForRow
                )
            }
            else -> {
                val layoutInflater = LayoutInflater.from(parent.context)
                val cellForRow = layoutInflater.inflate(R.layout.row_material_orthotropic_homogenization, parent, false)
                HomogenizationMaterialOrthotropicViewHolder(
                    cellForRow
                )
            }
        }
    }

    override fun getItemCount(): Int {
        return models.size
    }

    override fun getItemViewType(position: Int): Int {
        val model = models[position]
        return when (model) {
            is String -> {
                HEADER
            }
            is Method -> {
                METHOD
            }
            is StructuralModel -> {
                STRUCTURAL_MODEL
            }
            is TypeOfAnalysis -> {
                TYPE_OF_ANALYSIS
            }
            is StackingSequence -> {
                STACKING_SEQUENCE
            }
            else -> {
                LAMINATE_MATERIAL
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            HEADER -> {
                val title = models[position] as String
                (holder as HomogenizationHeaderViewHolder).bind(title)
            }
            METHOD -> {
                val method = models[position] as Method
                (holder as HomogenizationMethodViewHolder).bind(method)
            }
            STRUCTURAL_MODEL -> {
                val structuralModel = models[position] as StructuralModel
                (holder as HomogenizationStructuralModelViewHolder).bind(structuralModel)
            }
            TYPE_OF_ANALYSIS -> {
                val typeOfAnalysis = models[position] as TypeOfAnalysis
                (holder as HomogenizationTypeOfAnalysisViewHolder).bind(typeOfAnalysis)
            }
            STACKING_SEQUENCE -> {
                val stackingSequence = models[position] as StackingSequence
                (holder as HomogenizationStackingSequenceViewHolder).bind(stackingSequence)

            }
            else -> {
                val materialOrthotropic = models[position] as MaterialOrthotropic
                (holder as HomogenizationMaterialOrthotropicViewHolder).bind(
                    materialOrthotropic,
                    "Laminate Material")
            }
        }
    }
}