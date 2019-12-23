package com.peng.administrator.myobjectkotlin

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_blank_fragment4.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [BlankFragment4.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [BlankFragment4.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class BlankFragment4 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var fragments: MutableList<Fragment> = ArrayList<Fragment>()
    private var viewPageAdapter: ViewPageAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        fragments.add(BlankFragment5.newInstance("", ""))
        fragments.add(BlankFragment6.newInstance("", ""))
        fragments.add(BlankFragment7.newInstance("", ""))
        viewPageAdapter = ViewPageAdapter(context!!, childFragmentManager)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank_fragment4, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        pzv.setIsParallax(true)
        pzv.setIsZoomEnable(true)
        pzv.setSensitive(1.5f)
        pzv.setZoomTime(500)

        myvp.adapter = viewPageAdapter
        viewPageAdapter?.updataList(fragments)
        tab_layout.setupWithViewPager(myvp)
        myvp.post {
            val child = myvp.getChildAt(0)
            var vpHeight = child.measuredHeight
            Log.i("onPageSelected", "----->vpHeight = $vpHeight")
        }
        myvp.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(p0: Int) {
            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
            }

            override fun onPageSelected(p0: Int) {
                var count = myvp.getChildCount()
                val child = myvp.getChildAt(p0)
                var vpHeight = child?.measuredHeight
                Log.i("onPageSelected", "----->onPageSelected1 = $p0    vpHeight =  $vpHeight")
            }

        })
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment4.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment4().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
