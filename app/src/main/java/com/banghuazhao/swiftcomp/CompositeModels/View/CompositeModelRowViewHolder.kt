package com.banghuazhao.swiftcomp.CompositeModels.View

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat.getDrawable
import androidx.recyclerview.widget.RecyclerView
import com.banghuazhao.swiftcomp.CompositeModels.Model.CompositeModel
import com.banghuazhao.swiftcomp.Supporting.MetricsUtil
import com.banghuazhao.swiftcomp.R
import kotlinx.android.synthetic.main.row_composite_model.view.*

@Suppress("NAME_SHADOWING")
class CompositeModelRowViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    fun bind(compositeModel: CompositeModel) {
        view.name_label.text = compositeModel.name
        view.subname_label.text = compositeModel.subname
        view.cover_image_view.setImageResource(compositeModel.image)

        val constraintLayout = view as ConstraintLayout

        val beamTag = TextView(view.context)
        beamTag.id = View.generateViewId()
        beamTag.text = "Beam"
        beamTag.textSize = 12.toFloat()
        beamTag.background = getDrawable(view.context,
            R.drawable.sc_tag_rounded_corner
        )
        beamTag.setPadding(
            MetricsUtil.convertDpToPixel(
                8.toFloat(),
                view.context
            ).toInt(),
            MetricsUtil.convertDpToPixel(
                2.toFloat(),
                view.context
            ).toInt(),
            MetricsUtil.convertDpToPixel(
                8.toFloat(),
                view.context
            ).toInt(),
            MetricsUtil.convertDpToPixel(
                2.toFloat(),
                view.context
            ).toInt())

        val plateTag = TextView(view.context)
        plateTag.id = View.generateViewId()
        plateTag.text = "Plate"
        plateTag.textSize = 12.toFloat()
        plateTag.background = getDrawable(view.context,
            R.drawable.sc_tag_rounded_corner
        )
        plateTag.setPadding(
            MetricsUtil.convertDpToPixel(
                8.toFloat(),
                view.context
            ).toInt(),
            MetricsUtil.convertDpToPixel(
                2.toFloat(),
                view.context
            ).toInt(),
            MetricsUtil.convertDpToPixel(
                8.toFloat(),
                view.context
            ).toInt(),
            MetricsUtil.convertDpToPixel(
                2.toFloat(),
                view.context
            ).toInt())

        val solidTag = TextView(view.context)
        solidTag.id = View.generateViewId()
        solidTag.text = "Solid"
        solidTag.textSize = 12.toFloat()
        solidTag.background = getDrawable(view.context,
            R.drawable.sc_tag_rounded_corner
        )
        solidTag.setPadding(
            MetricsUtil.convertDpToPixel(
                8.toFloat(),
                view.context
            ).toInt(),
            MetricsUtil.convertDpToPixel(
                2.toFloat(),
                view.context
            ).toInt(),
            MetricsUtil.convertDpToPixel(
                8.toFloat(),
                view.context
            ).toInt(),
            MetricsUtil.convertDpToPixel(
                2.toFloat(),
                view.context
            ).toInt())


        if (compositeModel.beamModel) {
            constraintLayout.addView(beamTag)
            val set = ConstraintSet()
            set.clone(constraintLayout)
            set.connect(
                beamTag.id, ConstraintSet.LEFT, view.cover_image_view.id, ConstraintSet.RIGHT,
                MetricsUtil.convertDpToPixel(
                    16.toFloat(),
                    view.context
                ).toInt()
            )
            set.connect(
                beamTag.id, ConstraintSet.TOP, view.subname_label.id, ConstraintSet.BOTTOM,
                MetricsUtil.convertDpToPixel(
                    8.toFloat(),
                    view.context
                ).toInt()
            )
            set.applyTo(constraintLayout)

            if (compositeModel.plateModel) {
                constraintLayout.addView(plateTag)
                val set2 = ConstraintSet()
                set2.clone(constraintLayout)
                set2.connect(
                    plateTag.id, ConstraintSet.LEFT, beamTag.id, ConstraintSet.RIGHT,
                    MetricsUtil.convertDpToPixel(
                        10.toFloat(),
                        view.context
                    ).toInt()
                )
                set2.connect(
                    plateTag.id, ConstraintSet.TOP, view.subname_label.id, ConstraintSet.BOTTOM,
                    MetricsUtil.convertDpToPixel(
                        8.toFloat(),
                        view.context
                    ).toInt()
                )
                set2.applyTo(constraintLayout)

                if (compositeModel.solidModel) {
                    constraintLayout.addView(solidTag)
                    val set3 = ConstraintSet()
                    set3.clone(constraintLayout)
                    set3.connect(
                        solidTag.id, ConstraintSet.LEFT, plateTag.id, ConstraintSet.RIGHT,
                        MetricsUtil.convertDpToPixel(
                            10.toFloat(),
                            view.context
                        ).toInt()
                    )
                    set3.connect(
                        solidTag.id, ConstraintSet.TOP, view.subname_label.id, ConstraintSet.BOTTOM,
                        MetricsUtil.convertDpToPixel(
                            8.toFloat(),
                            view.context
                        ).toInt()
                    )
                    set3.applyTo(constraintLayout)
                }
            }
        } else if (compositeModel.plateModel) {
            constraintLayout.addView(plateTag)
            val set = ConstraintSet()
            set.clone(constraintLayout)
            set.connect(
                plateTag.id, ConstraintSet.LEFT, view.cover_image_view.id, ConstraintSet.RIGHT,
                MetricsUtil.convertDpToPixel(
                    16.toFloat(),
                    view.context
                ).toInt()
            )
            set.connect(
                plateTag.id, ConstraintSet.TOP, view.subname_label.id, ConstraintSet.BOTTOM,
                MetricsUtil.convertDpToPixel(
                    8.toFloat(),
                    view.context
                ).toInt()
            )
            set.applyTo(constraintLayout)
            if (compositeModel.solidModel) {
                constraintLayout.addView(solidTag)
                val set2 = ConstraintSet()
                set2.clone(constraintLayout)
                set2.connect(
                    solidTag.id, ConstraintSet.LEFT, plateTag.id, ConstraintSet.RIGHT,
                    MetricsUtil.convertDpToPixel(
                        10.toFloat(),
                        view.context
                    ).toInt()
                )
                set2.connect(
                    solidTag.id, ConstraintSet.TOP, view.subname_label.id, ConstraintSet.BOTTOM,
                    MetricsUtil.convertDpToPixel(
                        8.toFloat(),
                        view.context
                    ).toInt()
                )
                set2.applyTo(constraintLayout)
            }
        } else {
            constraintLayout.addView(solidTag)
            val set = ConstraintSet()
            set.clone(constraintLayout)
            set.connect(
                solidTag.id, ConstraintSet.LEFT, view.cover_image_view.id, ConstraintSet.RIGHT,
                MetricsUtil.convertDpToPixel(
                    16.toFloat(),
                    view.context
                ).toInt()
            )
            set.connect(
                solidTag.id, ConstraintSet.TOP, view.subname_label.id, ConstraintSet.BOTTOM,
                MetricsUtil.convertDpToPixel(
                    8.toFloat(),
                    view.context
                ).toInt()
            )
            set.applyTo(constraintLayout)
        }

    }

}