package com.banghuazhao.swiftcomp.HomogenizationResult.Controller

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.banghuazhao.swiftcomp.Homogenization.View.HomogenizationHeaderViewHolder
import com.banghuazhao.swiftcomp.HomogenizationResult.Model.HomPlateResult
import com.banghuazhao.swiftcomp.HomogenizationResult.View.HomPlateResultViewHolder
import com.banghuazhao.swiftcomp.R

class HomPlateResultAdapter(homPlateResult: HomPlateResult): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val HEADER = 1
        const val HOM_PLATE_RESULT = 2
    }


    val models = listOf(
        "Plate Properties Result",
        homPlateResult
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            HEADER -> {
                val layoutInflater = LayoutInflater.from(parent.context)
                val cellForRow = layoutInflater.inflate(R.layout.header_homogenization, parent, false)
                HomogenizationHeaderViewHolder(
                    cellForRow
                )
            }
            else -> {
                val layoutInflater = LayoutInflater.from(parent.context)
                val cellForRow = layoutInflater.inflate(R.layout.row_plate_result_homogenization, parent, false)
                HomPlateResultViewHolder(
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
            else -> {
                HOM_PLATE_RESULT
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            HEADER -> {
                val title = models[position] as String
                (holder as HomogenizationHeaderViewHolder).bind(title)
            }
            else -> {
                val homPlateResult = models[position] as HomPlateResult
                (holder as HomPlateResultViewHolder).bind(homPlateResult)
            }
        }
    }
}