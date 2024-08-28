package com.banghuazhao.swiftcomp.HomogenizationResult.View

import android.app.AlertDialog
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.banghuazhao.swiftcomp.HomogenizationResult.Model.HomPlateResult
import com.banghuazhao.swiftcomp.R
import kotlinx.android.synthetic.main.row_plate_result_homogenization.view.*

class HomPlateResultViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    fun bind(homPlateResult: HomPlateResult) {
        view.effective_solid_c11.text = homPlateResult.effectivePlateStiffnessArray[0].valueText
        view.effective_solid_c12.text = homPlateResult.effectivePlateStiffnessArray[1].valueText
        view.effective_solid_c13.text = homPlateResult.effectivePlateStiffnessArray[2].valueText
        view.effective_solid_c14.text = homPlateResult.effectivePlateStiffnessArray[3].valueText
        view.effective_solid_c15.text = homPlateResult.effectivePlateStiffnessArray[4].valueText
        view.effective_solid_c16.text = homPlateResult.effectivePlateStiffnessArray[5].valueText
        view.effective_solid_c21.text = homPlateResult.effectivePlateStiffnessArray[6].valueText
        view.effective_solid_c22.text = homPlateResult.effectivePlateStiffnessArray[7].valueText
        view.effective_solid_c23.text = homPlateResult.effectivePlateStiffnessArray[8].valueText
        view.effective_solid_c24.text = homPlateResult.effectivePlateStiffnessArray[9].valueText
        view.effective_solid_c25.text = homPlateResult.effectivePlateStiffnessArray[10].valueText
        view.effective_solid_c26.text = homPlateResult.effectivePlateStiffnessArray[11].valueText
        view.effective_solid_c31.text = homPlateResult.effectivePlateStiffnessArray[12].valueText
        view.effective_solid_c32.text = homPlateResult.effectivePlateStiffnessArray[13].valueText
        view.effective_solid_c33.text = homPlateResult.effectivePlateStiffnessArray[14].valueText
        view.effective_solid_c34.text = homPlateResult.effectivePlateStiffnessArray[15].valueText
        view.effective_solid_c35.text = homPlateResult.effectivePlateStiffnessArray[16].valueText
        view.effective_solid_c36.text = homPlateResult.effectivePlateStiffnessArray[17].valueText
        view.effective_solid_c41.text = homPlateResult.effectivePlateStiffnessArray[18].valueText
        view.effective_solid_c42.text = homPlateResult.effectivePlateStiffnessArray[19].valueText
        view.effective_solid_c43.text = homPlateResult.effectivePlateStiffnessArray[20].valueText
        view.effective_solid_c44.text = homPlateResult.effectivePlateStiffnessArray[21].valueText
        view.effective_solid_c45.text = homPlateResult.effectivePlateStiffnessArray[22].valueText
        view.effective_solid_c46.text = homPlateResult.effectivePlateStiffnessArray[23].valueText
        view.effective_solid_c51.text = homPlateResult.effectivePlateStiffnessArray[24].valueText
        view.effective_solid_c52.text = homPlateResult.effectivePlateStiffnessArray[25].valueText
        view.effective_solid_c53.text = homPlateResult.effectivePlateStiffnessArray[26].valueText
        view.effective_solid_c54.text = homPlateResult.effectivePlateStiffnessArray[27].valueText
        view.effective_solid_c55.text = homPlateResult.effectivePlateStiffnessArray[28].valueText
        view.effective_solid_c56.text = homPlateResult.effectivePlateStiffnessArray[29].valueText
        view.effective_solid_c61.text = homPlateResult.effectivePlateStiffnessArray[30].valueText
        view.effective_solid_c62.text = homPlateResult.effectivePlateStiffnessArray[31].valueText
        view.effective_solid_c63.text = homPlateResult.effectivePlateStiffnessArray[32].valueText
        view.effective_solid_c64.text = homPlateResult.effectivePlateStiffnessArray[33].valueText
        view.effective_solid_c65.text = homPlateResult.effectivePlateStiffnessArray[34].valueText
        view.effective_solid_c66.text = homPlateResult.effectivePlateStiffnessArray[35].valueText

        view.e1_value.text = homPlateResult.inPlanePropertiesArray[0].valueText
        view.e2_value.text = homPlateResult.inPlanePropertiesArray[1].valueText
        view.g12_value.text = homPlateResult.inPlanePropertiesArray[2].valueText
        view.nu12_value.text = homPlateResult.inPlanePropertiesArray[3].valueText
        view.eta121_value.text = homPlateResult.inPlanePropertiesArray[4].valueText
        view.eta122_value.text = homPlateResult.inPlanePropertiesArray[5].valueText

        view.e1_f_value.text = homPlateResult.flexuralPropertiesArray[0].valueText
        view.e2_f_value.text = homPlateResult.flexuralPropertiesArray[1].valueText
        view.g12_f_value.text = homPlateResult.flexuralPropertiesArray[2].valueText
        view.nu12_f_value.text = homPlateResult.flexuralPropertiesArray[3].valueText
        view.eta121_f_value.text = homPlateResult.flexuralPropertiesArray[4].valueText
        view.eta122_f_value.text = homPlateResult.flexuralPropertiesArray[5].valueText

        view.explain_button.setOnClickListener  {
            val dialog: AlertDialog = AlertDialog.Builder(view.context)
                .setTitle(R.string.plate_properties_title)
                .setMessage(R.string.plate_properties_explain)
                .setCancelable(true)
                .create()
            dialog.show()
        }
    }
}