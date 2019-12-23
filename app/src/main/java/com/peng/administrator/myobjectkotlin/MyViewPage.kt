package com.peng.administrator.myobjectkotlin

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.util.Log

class MyViewPage : ViewPager, ViewPager.OnPageChangeListener {
    private var vpHeight: Int = 0

    init {
//        addOnPageChangeListener(this)
    }

    override fun onPageScrollStateChanged(p0: Int) {

    }

    override fun onPageSelected(p0: Int) {
        var count = getChildCount()
//        for (int i = 0; i < count; i++) {
//            final View child = getChildAt(i);
//            if (child.getVisibility() != GONE) {
//                child.measure(widthMeasureSpec , heightMeasureSpec);
//            }
//        }
        for (index in 0..count) {
            val child = getChildAt(index)
//            vpHeight =
        }
        Log.i("onPageSelected", "----->onPageSelected = $p0")
    }

    override fun onPageScrolled(position: Int, offset: Float, offsetPixels: Int) {
        super.onPageScrolled(position, offset, offsetPixels)

    }

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        Log.i(
            "onMeasure",
            "----->MyViewPage  widthMeasureSpec = $widthMeasureSpec    heightMeasureSpec = $heightMeasureSpec"
        )
    }


    override fun addOnPageChangeListener(listener: OnPageChangeListener) {
        super.addOnPageChangeListener(listener)
    }
}