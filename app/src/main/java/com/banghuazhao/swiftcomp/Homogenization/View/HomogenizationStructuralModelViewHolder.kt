package com.banghuazhao.swiftcomp.Homogenization.View

import android.app.AlertDialog
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.banghuazhao.swiftcomp.Homogenization.Model.StructuralModel
import com.banghuazhao.swiftcomp.R
import kotlinx.android.synthetic.main.row_analysis_setting_homogenization.view.*


class HomogenizationStructuralModelViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    fun bind(structuralModel: StructuralModel) {
        view.view_title.text = "Output Result"
        view.analysis_button.text = "Solid Properties"

        view.analysis_button.setOnClickListener  {
            val builder = AlertDialog.Builder(view.context)
            builder.setTitle("Choose Output Result")
            builder.setItems(
                arrayOf<CharSequence>(
                    "Plate Properties",
                    "Solid Properties"
                )
            ) { dialog, which ->
                // The 'which' argument contains the index position
                // of the selected item
                when (which) {
                    0 -> {
                        structuralModel.macModel = StructuralModel.MacModel.Plate
                        structuralModel.subModel = StructuralModel.SubModel.KirchhoffLove
                        view.analysis_button.text = "Plate Properties"
                    }
                    1 -> {
                        structuralModel.macModel = StructuralModel.MacModel.Solid
                        structuralModel.subModel = StructuralModel.SubModel.CauchyContinuum
                        view.analysis_button.text = "Solid Properties"
                    }
                }
            }
            builder.create().show()
        }


        view.explain_button.setOnClickListener  {
            val dialog: AlertDialog = AlertDialog.Builder(view.context)
                .setTitle(R.string.output_result_title)
                .setMessage(R.string.output_result_explain)
                .setCancelable(true)
                .create()
            dialog.show()
        }
    }
}

