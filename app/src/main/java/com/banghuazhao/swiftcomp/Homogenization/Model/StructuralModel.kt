package com.banghuazhao.swiftcomp.Homogenization.Model

class StructuralModel(var macModel: MacModel, var subModel: SubModel) {

    enum class MacModel(val UIName: String) {
        Beam("Beam"),
        Plate("Plate"),
        Solid("Solid")
    }

    enum class SubModel(val UIName: String) {
        EulerBernoulli("Euler Bernoulli Model"),
        Timoshenko("Timoshenko Model"),
        KirchhoffLove("kirchhoff Love Model"),
        ReissnerMindlin("Reissner Mindlin Model"),
        CauchyContinuum("Cauchy Continuum Model")
    }

    val structrualModelAPI: String
        get() {
            return when (macModel) {
                MacModel.Beam -> "Beam"
                MacModel.Plate -> "Plate"
                MacModel.Solid -> "Solid"
            }
        }

    val structrualSubmodelAPI: String
        get() {
            return when (subModel) {
                SubModel.EulerBernoulli -> "EulerBernoulliBeamModel"
                SubModel.Timoshenko -> "TimoshenkoBeamModel"
                SubModel.KirchhoffLove -> "KirchhoffLovePlateShellModel"
                SubModel.ReissnerMindlin -> "ReissnerMindlinPlateShellModel"
                SubModel.CauchyContinuum -> "CauchyContinuumModel"
            }
        }
}