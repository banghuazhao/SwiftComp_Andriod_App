package com.banghuazhao.swiftcomp.Homogenization.Model

class MaterialOrthotropic(
    var e1: Double?,
    var e2: Double?,
    var e3: Double?,
    var g12: Double?,
    var g13: Double?,
    var g23: Double?,
    var nu12: Double?,
    var nu13: Double?,
    var nu23: Double?
) {

    fun isMaterialValide(): Boolean {
        if ((e1 != null) &&
            (e2 != null) &&
            (e3 != null) &&
            (g12 != null) &&
            (g13 != null) &&
            (g23 != null) &&
            (nu12 != null) &&
            (nu13 != null) &&
            (nu23 != null)
        ) {
            if ((nu12!! > -1) &&
                (nu12!! < 0.5) &&
                (nu13!! > -1) &&
                (nu13!! < 0.5) &&
                (nu23!! > -1) &&
                (nu23!! < 0.5)
            ) {
                return true
            }
        }

        return false
    }

}