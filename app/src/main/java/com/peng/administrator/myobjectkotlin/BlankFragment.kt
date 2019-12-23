package com.peng.administrator.myobjectkotlin

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_blank.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class BlankFragment : Fragment(), View.OnClickListener {


    private var param1: String? = null
    private var param2: String? = null

    private val fragments: MutableList<Fragment> = ArrayList<Fragment>()
    private var currentIndex: Int = 0
    //    private var viewPageAdapter: ViewPageAdapter? = null
//    public lateinit var mySupportFragmentManager: FragmentManager
    private var ContainerId: Int = R.id.fragme_container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
//        fragments.add(BlankFragment1.newInstance("", ""))
//        fragments.add(BlankFragment2.newInstance("", ""))
//        fragments.add(BlankFragment3.newInstance("", ""))
//        mySupportFragmentManager = childFragmentManager
        fragments.add(BlankParentFragment.newInstance("", ""))
        fragments.add(TongChengFragment.newInstance("", ""))
        fragments.add(XiaoXiFragment.newInstance("", ""))
        fragments.add(WoDeFragment.newInstance("", ""))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        switchFragment(0)
        //第一次add到事物中的时候fragment是默认显示的，add几个显示几个，这样界面就显示的被叠加的界面。如果刚开始有多个fragment被add的话。需要调用hide，在单独调用show来显示某个fragment
        childFragmentManager!!.beginTransaction().add(
            ContainerId,
            fragments.get(0),
            fragments.get(0).javaClass.simpleName
        )/*.show(fragments.get(0))*/.commit()
        line1.setOnClickListener(this)
        line2.setOnClickListener(this)
        line3.setOnClickListener(this)
        line4.setOnClickListener(this)
        line4.setOnClickListener(this)
        line5.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        var id = v?.id
        when (id) {
            R.id.line1 -> switchFragment(0)
            R.id.line2 -> switchFragment(1)
            R.id.line3 -> {

            }
            R.id.line4 -> switchFragment(2)
            R.id.line5 -> {
                switchFragment(3)
            }

            else -> {
                switchFragment(0)
            }
        }
    }

    public fun switchFragment(tabIndex: Int) {
        if (currentIndex != tabIndex) {
            var transaction = childFragmentManager!!.beginTransaction()
            var formFragment = fragments.get(currentIndex)
            var toFragment = fragments.get(tabIndex)
            if (!toFragment.isAdded) {
                var simpleName = toFragment.javaClass.simpleName
                transaction.hide(formFragment).add(ContainerId, toFragment, simpleName)
            } else {
                transaction.hide(formFragment).show(toFragment)
            }
            transaction.addToBackStack(null)
            transaction.commit()
            currentIndex = tabIndex
        }
    }
//
//    private fun initView() {
//        mySupportFragmentManager = getChildFragmentManager()
//        viewPageAdapter = ViewPageAdapter(context!!, mySupportFragmentManager)
//        vpparent.adapter = viewPageAdapter
//        viewPageAdapter?.updataList(fragments)
//
//        tab_layout.setupWithViewPager(vpparent)
//    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
