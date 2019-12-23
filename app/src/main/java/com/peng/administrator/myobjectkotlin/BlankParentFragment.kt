package com.peng.administrator.myobjectkotlin

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_blank_parent.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [BlankParentFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [BlankParentFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankParentFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val fragments: MutableList<Fragment> = ArrayList<Fragment>()
    private var viewPageAdapter: ViewPageAdapter? = null
    public lateinit var mySupportFragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        fragments.add(BlankFragment1.newInstance("", ""))
        fragments.add(BlankFragment2.newInstance("", ""))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank_parent, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
    }

    private fun initView() {
        mySupportFragmentManager = getChildFragmentManager()
        viewPageAdapter = ViewPageAdapter(context!!, mySupportFragmentManager)
        vpparent.adapter = viewPageAdapter
        viewPageAdapter?.updataList(fragments)

        tab_layout.setupWithViewPager(vpparent)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankParentFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankParentFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (hidden){
            (activity as MainActivity ).setViewPageScroll(false)
        }else{
            (activity as MainActivity ).setViewPageScroll(true)
        }
    }
}
