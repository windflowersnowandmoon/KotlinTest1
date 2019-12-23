package com.peng.administrator.myobjectkotlin

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val fragments: MutableList<Fragment> = ArrayList<Fragment>()
    private var viewPageAdapter: ViewPageAdapter? = null
    public lateinit var mySupportFragmentManager: FragmentManager
    //    private lateinit var viewPageAdapter: ViewPageAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        Log.i("MainActivity", "---->onCreate")
    }

    init {
        fragments.add(BlankFragment.newInstance("", ""))
        fragments.add(BlankFragment4.newInstance("", ""))
//        fragments.add(BlankFragment3.newInstance("", ""))
    }

    init {
        Log.i("MainActivity", "---->onCreate2")
    }

    init {
        Log.i("MainActivity", "---->onCreate3")
    }

    private fun initView() {
        mySupportFragmentManager = getSupportFragmentManager()
        viewPageAdapter = ViewPageAdapter(this, mySupportFragmentManager)
        vp.adapter = viewPageAdapter
//        vp.onSc()
        viewPageAdapter?.updataList(fragments)
//        tab_layout.setupWithViewPager(vp)

    }

    public fun setViewPageScroll(noScroll : Boolean){
        vp.noScroll = noScroll
    }
}
