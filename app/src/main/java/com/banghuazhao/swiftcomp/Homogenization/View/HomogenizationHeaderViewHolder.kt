package com.banghuazhao.swiftcomp.Homogenization.View


import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.header_homogenization.view.*


class HomogenizationHeaderViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    fun bind(title: String) {
        view.title.text = title
    }

}