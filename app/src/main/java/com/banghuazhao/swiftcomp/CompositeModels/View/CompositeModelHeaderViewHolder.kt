package com.banghuazhao.swiftcomp.CompositeModels.View

import android.graphics.Color
import android.graphics.Typeface
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.banghuazhao.swiftcomp.R
import kotlinx.android.synthetic.main.header_composite_model.view.*

class CompositeModelHeaderViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    fun bind(title: String) {
        view.header_label.text = title
        view.header_label.setTextSize(
            TypedValue.COMPLEX_UNIT_PX,
            view.context.resources.getDimension(R.dimen.SCModelHeader))
        view.header_label.typeface = Typeface.DEFAULT_BOLD
        view.header_label.setTextColor(Color.BLACK)
    }

}