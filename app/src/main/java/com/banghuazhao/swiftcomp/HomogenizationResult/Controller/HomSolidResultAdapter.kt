package com.banghuazhao.swiftcomp.Homogenization.Controller

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.banghuazhao.swiftcomp.Homogenization.Model.*
import com.banghuazhao.swiftcomp.Homogenization.View.*
import com.banghuazhao.swiftcomp.HomogenizationResult.Model.HomSolidResult
import com.banghuazhao.swiftcomp.R

class HomSolidResultAdapter(homSolidResult: HomSolidResult): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val HEADER = 1
        const val HOM_SOLID_RESULT = 2
    }


    val models = listOf(
        "Solid Properties Result",
        homSolidResult
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
                val cellForRow = layoutInflater.inflate(R.layout.row_solid_result_homogenization, parent, false)
                HomSolidResultViewHolder(
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
                HOM_SOLID_RESULT
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
                val homSolidResult = models[position] as HomSolidResult
                (holder as HomSolidResultViewHolder).bind(homSolidResult)
            }
        }
    }
}