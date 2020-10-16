package com.app.socialapp.custom.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import com.app.socialapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class CustomBottomNavigationView : BottomNavigationView {

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context) : super(context)

    init {
        init()
    }

    companion object {

        const val CURVE_CIRCLE_RADIUS = 128 / 2

    }

    private lateinit var path: Path
    private lateinit var paint: Paint

    private var firstCurveStartPoint: Point = Point()
    private var firstCurveEndPoint: Point = Point()
    private var firstCurveControlPoint1: Point = Point()
    private var firstCurveControlPoint2: Point = Point()

    private var secondCurveStartPoint: Point = Point()
    private var secondCurveEndPoint: Point = Point()
    private var secondCurveControlPoint1: Point = Point()
    private var secondCurveControlPoint2: Point = Point()
    private var navigationBarWidth = 0
    private var navigationBarHeight = 0

    private fun init() {
        path = Path()
        paint = Paint()
        paint.style = Paint.Style.FILL_AND_STROKE
        paint.color = ContextCompat.getColor(context, R.color.lb_tv_white)
        setBackgroundColor(Color.TRANSPARENT)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        // get width and height of navigation bar
        // Navigation bar bounds (width & height)
        navigationBarWidth = width
        navigationBarHeight = height
        // the coordinates (x,y) of the start point before curve
        // the coordinates (x,y) of the start point before curve
        firstCurveStartPoint.set(navigationBarWidth / 2 - CURVE_CIRCLE_RADIUS * 2 - CURVE_CIRCLE_RADIUS / 3, 0)
        // the coordinates (x,y) of the end point after curve
        // the coordinates (x,y) of the end point after curve
        firstCurveEndPoint.set(navigationBarWidth / 2, CURVE_CIRCLE_RADIUS + CURVE_CIRCLE_RADIUS / 4)
        // same thing for the second curve
        // same thing for the second curve
        secondCurveStartPoint = firstCurveEndPoint
        secondCurveEndPoint.set(navigationBarWidth / 2 + CURVE_CIRCLE_RADIUS * 2 + CURVE_CIRCLE_RADIUS / 3, 0)

        // the coordinates (x,y)  of the 1st control point on a cubic curve

        // the coordinates (x,y)  of the 1st control point on a cubic curve
        firstCurveControlPoint1.set(firstCurveStartPoint.x + CURVE_CIRCLE_RADIUS + CURVE_CIRCLE_RADIUS / 4, firstCurveStartPoint.y)
        // the coordinates (x,y)  of the 2nd control point on a cubic curve
        // the coordinates (x,y)  of the 2nd control point on a cubic curve
        firstCurveControlPoint2.set(firstCurveEndPoint.x - CURVE_CIRCLE_RADIUS * 2 + CURVE_CIRCLE_RADIUS, firstCurveEndPoint.y)

        secondCurveControlPoint1.set(secondCurveStartPoint.x + CURVE_CIRCLE_RADIUS * 2 - CURVE_CIRCLE_RADIUS, secondCurveStartPoint.y)
        secondCurveControlPoint2.set(secondCurveEndPoint.x - (CURVE_CIRCLE_RADIUS + CURVE_CIRCLE_RADIUS / 4), secondCurveEndPoint.y)

        path.reset()
        path.moveTo(0F, 0F)
        path.lineTo(firstCurveStartPoint.x.toFloat(), firstCurveStartPoint.y.toFloat())

        path.cubicTo(firstCurveControlPoint1.x.toFloat(), firstCurveControlPoint1.y.toFloat(),
                firstCurveControlPoint2.x.toFloat(), firstCurveControlPoint2.y.toFloat(),
                firstCurveEndPoint.x.toFloat(), firstCurveEndPoint.y.toFloat())

        path.cubicTo(secondCurveControlPoint1.x.toFloat(), secondCurveControlPoint1.y.toFloat(),
                secondCurveControlPoint2.x.toFloat(), secondCurveControlPoint2.y.toFloat(),
                secondCurveEndPoint.x.toFloat(), secondCurveEndPoint.y.toFloat())

        path.lineTo(navigationBarWidth.toFloat(), 0F)
        path.lineTo(navigationBarWidth.toFloat(), navigationBarHeight.toFloat())
        path.lineTo(0F, navigationBarHeight.toFloat())
        path.close()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawPath(path, paint)
    }
}