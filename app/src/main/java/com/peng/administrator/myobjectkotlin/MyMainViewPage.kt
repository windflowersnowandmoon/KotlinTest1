package com.peng.administrator.myobjectkotlin

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

/**
 *   $
 *   作   者 :彭付林
 *   邮   箱 :pengfl@kingchannels.com
 *   日   期 :2019/12/19
 *   描   述 :个人信息
 */
class MyMainViewPage(context: Context, attrs: AttributeSet?) : ViewPager(context, attrs) {

    public var noScroll = true

    constructor(context: Context) : this(context, null) {

    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        var touch = super.onTouchEvent(ev)
        if (!noScroll) touch = false
        return touch
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        var touch = super.onInterceptTouchEvent(ev)
        if (!noScroll) touch = false
        return touch
    }
}