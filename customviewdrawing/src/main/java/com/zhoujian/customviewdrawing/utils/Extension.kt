package com.zhoujian.customviewdrawing.utils

import android.content.res.Resources
import android.util.TypedValue

//扩展属性 dp转px

val Float.px
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this,
        Resources.getSystem().displayMetrics
    )