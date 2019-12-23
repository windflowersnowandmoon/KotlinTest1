package com.peng.administrator.myobjectkotlin

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.widget.LinearLayout

/**
 *   $
 *   作   者 :彭付林
 *   邮   箱 :pengfl@kingchannels.com
 *   日   期 :2019/12/11
 *   描   述 :个人信息
 */
class MyLinearLayout : LinearLayout {
    constructor(context: Context) : super(context)
    //    Context context, @Nullable AttributeSet attrs, int defStyleAttr
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        Log.i("MyLinearLayout","------->MyLinearLayout  widthMeasureSpec = $widthMeasureSpec    heightMeasureSpec =  $heightMeasureSpec")
//        measure(widthMeasureSpec , heightMeasureSpec)
    }

}