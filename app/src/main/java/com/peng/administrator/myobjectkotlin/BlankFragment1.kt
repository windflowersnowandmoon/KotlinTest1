package com.peng.administrator.myobjectkotlin

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.PagerSnapHelper
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_blank_fragment1.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [BlankFragment1.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [BlankFragment1.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class BlankFragment1 : Fragment() , View.OnClickListener{

    private var param1: String? = null
    private var param2: String? = null
    private var list: MutableList<String>? = ArrayList<String>()
    private var recycleView2Adapter: RecycleView2Adapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        list = ArrayList<String>()
        recycleView2Adapter = RecycleView2Adapter(context!!)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank_fragment1, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        list?.add("1")
        list?.add("2")
        list?.add("3")
        var layoutManager: LinearLayoutManager = object : LinearLayoutManager(context){
            override fun generateDefaultLayoutParams(): RecyclerView.LayoutParams {
                return RecyclerView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            }
        }
        layoutManager.orientation = LinearLayoutManager.VERTICAL

//        var linearSnapHelper: LinearSnapHelper = LinearSnapHelper()
        var pagerSnapHelper = PagerSnapHelper()
        pagerSnapHelper.attachToRecyclerView(rec1)
        rec1.layoutManager = layoutManager
        rec1.adapter = recycleView2Adapter
        recycleView2Adapter?.updataList(list!!)
        text2.setOnClickListener(this)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment1().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onClick(v: View?) {
        var id = v?.id
        when (id){
            R.id.text2 -> {
                expanded_menu.toggleExpend()
            }
        }
    }
}
