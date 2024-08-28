package com.banghuazhao.swiftcomp.Homogenization.View

import android.app.AlertDialog
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.banghuazhao.swiftcomp.Homogenization.Model.StackingSequence
import com.banghuazhao.swiftcomp.R
import kotlinx.android.synthetic.main.row_analysis_setting_homogenization.view.*
import kotlinx.android.synthetic.main.row_stacking_sequence_homogenization.view.*
import kotlinx.android.synthetic.main.row_stacking_sequence_homogenization.view.explain_button
import kotlinx.android.synthetic.main.row_stacking_sequence_homogenization.view.view_title

class HomogenizationStackingSequenceViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    fun bind(stackingSequence: StackingSequence) {
        view.view_title.text = stackingSequence.sectionTitle
        view.stacking_sequence_editText.setText(stackingSequence.stackingSequenceText)
        view.stacking_sequence_editText.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val newStackingSequence = s.toString()
                stackingSequence.changeChackingSequence(newStackingSequence)
            }

        })

        view.layer_thickness_editText.setText(stackingSequence.layerThicknessText)
        view.layer_thickness_editText.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val newLayerThickness = s.toString()
                stackingSequence.changeLayerThickness(newLayerThickness)
            }

        })

        view.explain_button.setOnClickListener  {
            val dialog: AlertDialog = AlertDialog.Builder(view.context)
                .setTitle(R.string.stacking_sequence_title)
                .setMessage(R.string.stacking_sequence_explain)
                .setCancelable(true)
                .create()

            dialog.show()
        }
    }
}
