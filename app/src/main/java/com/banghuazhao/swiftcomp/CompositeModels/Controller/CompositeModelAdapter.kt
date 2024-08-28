package com.banghuazhao.swiftcomp.CompositeModels.Controller

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.banghuazhao.swiftcomp.CompositeModels.Model.CompositeModel
import com.banghuazhao.swiftcomp.CompositeModels.View.CompositeModelHeaderViewHolder
import com.banghuazhao.swiftcomp.CompositeModels.View.CompositeModelRowViewHolder
import com.banghuazhao.swiftcomp.Homogenization.Controller.LaminateActivity
import com.banghuazhao.swiftcomp.R


class CompositeModelAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val HEADER = 1
        const val ROW = 2
    }


    private val models = listOf(
        CompositeModel(
            "Laminate",
            "1D SG of laminate",
            R.drawable.laminate,
            beamModel = false,
            plateModel = true,
            solidModel = true
        ),
        CompositeModel(
            "Unidirectional Fiber Reinforced Composite (UDFRC)",
            "2D SG of square pack microstructure",
            R.drawable.spuare_pack,
            beamModel = true,
            plateModel = true,
            solidModel = true
        ),
        CompositeModel(
            "Honeycomb Sandwich Structure",
            "3D SG of honeycomb sandwich",
            R.drawable.honeycomb_sandwich,
            beamModel = true,
            plateModel = true,
            solidModel = false
        ),
        CompositeModel(
            "Particle Reinforced Composite (PRC)",
            "3D SG of spherical inclusion microstructure",
            R.drawable.particle_reinforced_composite,
            beamModel = true,
            plateModel = true,
            solidModel = true
        )
    )

    // numberOfItems
    override fun getItemCount(): Int {
        return models.size
    }

    override fun getItemViewType(position: Int): Int {
        return ROW
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        // how do we even create a view
        return if (viewType == HEADER) {
            val layoutInflater = LayoutInflater.from(parent.context)
            val cellForRow = layoutInflater.inflate(R.layout.header_composite_model, parent, false)
            CompositeModelHeaderViewHolder(
                cellForRow
            )
        } else {
            val layoutInflater = LayoutInflater.from(parent.context)
            val cellForRow = layoutInflater.inflate(R.layout.row_composite_model, parent, false)
            cellForRow.setBackgroundColor(Color.WHITE)
            CompositeModelRowViewHolder(
                cellForRow
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder.itemViewType == HEADER) {
            val title = models[position] as String
            (holder as CompositeModelHeaderViewHolder).bind(title)
        } else {
            val compositeModel = models[position] as CompositeModel
            (holder as CompositeModelRowViewHolder).bind(compositeModel)

            holder.view.setOnClickListener {
                if (position == 0) {
                    val intent = Intent(
                        holder.view.context,
                        LaminateActivity::class.java
                    )
                    holder.view.context.startActivity(intent)
                } else {
                    Toast.makeText(
                        holder.itemView.context,
                        "Under Construction",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}


