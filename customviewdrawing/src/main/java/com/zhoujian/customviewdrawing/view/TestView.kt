package com.zhoujian.customviewdrawing.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PathMeasure
import android.util.AttributeSet
import android.view.View
import com.zhoujian.customviewdrawing.utils.px

//半径
private val RADIUS = 100f.px

class TestView(context: Context?, attributes: AttributeSet?) : View(context, attributes) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private lateinit var pathMeasure: PathMeasure
    private val path = Path()

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        path.reset()
        path.addCircle(width / 2f, height / 2f, RADIUS, Path.Direction.CCW)
        path.addRect(
            width / 2f - RADIUS,
            height / 2f,
            width / 2f + RADIUS,
            height / 2f + 2 * RADIUS,
            Path.Direction.CW
        )
        path.fillType = Path.FillType.EVEN_ODD

        pathMeasure = PathMeasure(path, false)
        //获取path的长度
        pathMeasure.length
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //画线
        //canvas.drawLine(100f,100f,200f,200f,paint)
        //画圆
        //canvas.drawCircle(width/2f,height/2f,RADIUS,paint)

        //画path
        canvas.drawPath(path, paint)

    }
}