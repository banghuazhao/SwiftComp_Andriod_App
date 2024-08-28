package com.banghuazhao.swiftcomp.Homogenization.View

import android.app.AlertDialog
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.banghuazhao.swiftcomp.Homogenization.Model.Method
import com.banghuazhao.swiftcomp.Homogenization.Model.TypeOfAnalysis
import com.banghuazhao.swiftcomp.R
import kotlinx.android.synthetic.main.row_analysis_setting_homogenization.view.*

class HomogenizationTypeOfAnalysisViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    fun bind(typeOfAnalysis: TypeOfAnalysis) {
        view.view_title.text = "Type of Output"
        view.analysis_button.text = "Elastic Properties"
        view.explain_button.setOnClickListener  {
            val dialog: AlertDialog = AlertDialog.Builder(view.context)
                .setTitle(R.string.type_of_output_title)
                .setMessage(R.string.type_of_output_explain)
                .setCancelable(true)
                .create()
            dialog.show()
        }
    }

}
