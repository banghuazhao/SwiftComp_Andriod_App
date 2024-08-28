package com.banghuazhao.swiftcomp.Homogenization.View

import android.app.AlertDialog
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.banghuazhao.swiftcomp.Homogenization.Model.MaterialOrthotropic
import com.banghuazhao.swiftcomp.R
import kotlinx.android.synthetic.main.row_material_orthotropic_homogenization.view.*
import kotlinx.android.synthetic.main.row_material_orthotropic_homogenization.view.view_title

class HomogenizationMaterialOrthotropicViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    fun bind(materialOrthotropic: MaterialOrthotropic, materialName: String) {
        view.view_title.text = materialName
        view.e1_value.setText(materialOrthotropic.e1.toString())
        view.e2_value.setText(materialOrthotropic.e2.toString())
        view.e3_value.setText(materialOrthotropic.e3.toString())
        view.g12_value.setText(materialOrthotropic.g12.toString())
        view.g13_value.setText(materialOrthotropic.g13.toString())
        view.g23_value.setText(materialOrthotropic.g23.toString())
        view.nu12_value.setText(materialOrthotropic.nu12.toString())
        view.nu13_value.setText(materialOrthotropic.nu13.toString())
        view.nu23_value.setText(materialOrthotropic.nu23.toString())

        view.e1_value.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                materialOrthotropic.e1 = s.toString().toDoubleOrNull()
            }
        })

        view.e2_value.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                materialOrthotropic.e2 = s.toString().toDoubleOrNull()
            }
        })


        view.e3_value.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                materialOrthotropic.e3 = s.toString().toDoubleOrNull()
            }
        })

        view.g12_value.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                materialOrthotropic.g12 = s.toString().toDoubleOrNull()
            }
        })

        view.g13_value.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                materialOrthotropic.g13 = s.toString().toDoubleOrNull()
            }
        })

        view.g23_value.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                materialOrthotropic.g23 = s.toString().toDoubleOrNull()
            }
        })

        view.nu12_value.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                materialOrthotropic.nu12 = s.toString().toDoubleOrNull()
            }
        })

        view.nu13_value.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                materialOrthotropic.nu13 = s.toString().toDoubleOrNull()
            }
        })

        view.nu23_value.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                materialOrthotropic.nu23 = s.toString().toDoubleOrNull()
            }
        })

        view.explain_button.setOnClickListener  {
            val dialog: AlertDialog = AlertDialog.Builder(view.context)
                .setTitle(R.string.material_title)
                .setMessage(R.string.material_explain)
                .setCancelable(true)
                .create()
            dialog.show()
        }

    }

}