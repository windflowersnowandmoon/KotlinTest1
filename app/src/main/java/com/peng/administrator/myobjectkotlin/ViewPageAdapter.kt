package com.peng.administrator.myobjectkotlin

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 *   $desc$
 *   作   者 :彭付林
 *   邮   箱 :pengfl@kingchannels.com
 *   日   期 :2019/12/2
 *   描   述 :个人信息
 */
class ViewPageAdapter constructor(context: Context, mySupportFragmentManager: FragmentManager) :
    FragmentPagerAdapter(mySupportFragmentManager) {


    private val context: Context = context
    private var mySupportFragmentManager: FragmentManager = mySupportFragmentManager
    public var fragments: MutableList<Fragment> = ArrayList<Fragment>()


    constructor(context: Context, mySupportFragmentManager: FragmentManager, fragments: ArrayList<Fragment>) : this(
        context,
        mySupportFragmentManager
    ) {
        this.fragments = fragments
    }

//    constructor(context: Context, mySupportFragmentManager: FragmentManager) : this(context) {
//        this.mySupportFragmentManager = mySupportFragmentManager
//    }

//    init {
//        this.context = context
//    }

//    public var pageList = mutableListOf<Fragment>()


    override fun getItem(p0: Int): Fragment {
        return fragments?.get(p0)
    }

    override fun getCount(): Int {
        return fragments?.size
    }


    public fun updataList(fragments: MutableList<Fragment>) {
        this.fragments = fragments
        notifyDataSetChanged()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> {
                return "title1"
            }
            1 -> return "title2"
            2 -> return "title3"
        }
        return super.getPageTitle(position)
    }
}