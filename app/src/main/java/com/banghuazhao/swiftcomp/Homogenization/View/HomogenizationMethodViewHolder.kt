package com.banghuazhao.swiftcomp.Homogenization.View

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.banghuazhao.swiftcomp.Homogenization.Model.Method
import kotlinx.android.synthetic.main.row_analysis_setting_homogenization.view.*

class HomogenizationMethodViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    fun bind(method: Method) {
        view.view_title.text = "Method"
        view.analysis_button.text = "SwiftComp"
    }

}