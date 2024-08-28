package com.banghuazhao.swiftcomp.Homogenization.View

import android.app.AlertDialog
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.banghuazhao.swiftcomp.HomogenizationResult.Model.HomSolidResult
import com.banghuazhao.swiftcomp.R
import kotlinx.android.synthetic.main.row_analysis_setting_homogenization.view.*
import kotlinx.android.synthetic.main.row_solid_result_homogenization.*
import kotlinx.android.synthetic.main.row_solid_result_homogenization.view.*
import kotlinx.android.synthetic.main.row_solid_result_homogenization.view.explain_button


class HomSolidResultViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    fun bind(homSolidResult: HomSolidResult) {
        view.effective_solid_c11.text = homSolidResult.effectiveSolidStiffnessArray[0].valueText
        view.effective_solid_c12.text = homSolidResult.effectiveSolidStiffnessArray[1].valueText
        view.effective_solid_c13.text = homSolidResult.effectiveSolidStiffnessArray[2].valueText
        view.effective_solid_c14.text = homSolidResult.effectiveSolidStiffnessArray[3].valueText
        view.effective_solid_c15.text = homSolidResult.effectiveSolidStiffnessArray[4].valueText
        view.effective_solid_c16.text = homSolidResult.effectiveSolidStiffnessArray[5].valueText
        view.effective_solid_c21.text = homSolidResult.effectiveSolidStiffnessArray[6].valueText
        view.effective_solid_c22.text = homSolidResult.effectiveSolidStiffnessArray[7].valueText
        view.effective_solid_c23.text = homSolidResult.effectiveSolidStiffnessArray[8].valueText
        view.effective_solid_c24.text = homSolidResult.effectiveSolidStiffnessArray[9].valueText
        view.effective_solid_c25.text = homSolidResult.effectiveSolidStiffnessArray[10].valueText
        view.effective_solid_c26.text = homSolidResult.effectiveSolidStiffnessArray[11].valueText
        view.effective_solid_c31.text = homSolidResult.effectiveSolidStiffnessArray[12].valueText
        view.effective_solid_c32.text = homSolidResult.effectiveSolidStiffnessArray[13].valueText
        view.effective_solid_c33.text = homSolidResult.effectiveSolidStiffnessArray[14].valueText
        view.effective_solid_c34.text = homSolidResult.effectiveSolidStiffnessArray[15].valueText
        view.effective_solid_c35.text = homSolidResult.effectiveSolidStiffnessArray[16].valueText
        view.effective_solid_c36.text = homSolidResult.effectiveSolidStiffnessArray[17].valueText
        view.effective_solid_c41.text = homSolidResult.effectiveSolidStiffnessArray[18].valueText
        view.effective_solid_c42.text = homSolidResult.effectiveSolidStiffnessArray[19].valueText
        view.effective_solid_c43.text = homSolidResult.effectiveSolidStiffnessArray[20].valueText
        view.effective_solid_c44.text = homSolidResult.effectiveSolidStiffnessArray[21].valueText
        view.effective_solid_c45.text = homSolidResult.effectiveSolidStiffnessArray[22].valueText
        view.effective_solid_c46.text = homSolidResult.effectiveSolidStiffnessArray[23].valueText
        view.effective_solid_c51.text = homSolidResult.effectiveSolidStiffnessArray[24].valueText
        view.effective_solid_c52.text = homSolidResult.effectiveSolidStiffnessArray[25].valueText
        view.effective_solid_c53.text = homSolidResult.effectiveSolidStiffnessArray[26].valueText
        view.effective_solid_c54.text = homSolidResult.effectiveSolidStiffnessArray[27].valueText
        view.effective_solid_c55.text = homSolidResult.effectiveSolidStiffnessArray[28].valueText
        view.effective_solid_c56.text = homSolidResult.effectiveSolidStiffnessArray[29].valueText
        view.effective_solid_c61.text = homSolidResult.effectiveSolidStiffnessArray[30].valueText
        view.effective_solid_c62.text = homSolidResult.effectiveSolidStiffnessArray[31].valueText
        view.effective_solid_c63.text = homSolidResult.effectiveSolidStiffnessArray[32].valueText
        view.effective_solid_c64.text = homSolidResult.effectiveSolidStiffnessArray[33].valueText
        view.effective_solid_c65.text = homSolidResult.effectiveSolidStiffnessArray[34].valueText
        view.effective_solid_c66.text = homSolidResult.effectiveSolidStiffnessArray[35].valueText

        view.e1_value.text = homSolidResult.engineeringConstantsArray[0].valueText
        view.e2_value.text = homSolidResult.engineeringConstantsArray[1].valueText
        view.e3_value.text = homSolidResult.engineeringConstantsArray[2].valueText
        view.g12_value.text = homSolidResult.engineeringConstantsArray[3].valueText
        view.g13_value.text = homSolidResult.engineeringConstantsArray[4].valueText
        view.g23_value.text = homSolidResult.engineeringConstantsArray[5].valueText
        view.nu12_value.text = homSolidResult.engineeringConstantsArray[6].valueText
        view.nu13_value.text = homSolidResult.engineeringConstantsArray[7].valueText
        view.nu23_value.text = homSolidResult.engineeringConstantsArray[8].valueText

        view.explain_button.setOnClickListener  {
            val dialog: AlertDialog = AlertDialog.Builder(view.context)
                .setTitle(R.string.solid_properties_title)
                .setMessage(R.string.solid_properties_explain)
                .setCancelable(true)
                .create()
            dialog.show()
        }
    }
}