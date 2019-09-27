package com.joyrun.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.grouter.RouterComponent
import com.joyrun.base.http.ResponseCallback
import com.joyrun.home.adapter.HomeAdapter
import com.joyrun.base.entity.home.WelfareInfo
import com.joyrun.home.mvvm.HomeViewModel
import kotlinx.android.synthetic.main.home_fragment_home.*

/**
 * author: wneJie
 * date: 2019-09-24 16:55
 * desc:
 */
@RouterComponent(protocol = Fragment::class)
class HomeFragment : Fragment(), SwipeRefreshLayout.OnRefreshListener {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var homeAdapter: HomeAdapter

    override fun onRefresh() {
        srl.isRefreshing = true
        homeViewModel.getdata2()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        homeViewModel.getdata2()
        return inflater.inflate(R.layout.home_fragment_home , container , false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        srl.isRefreshing = true
        srl.setOnRefreshListener(this)
        homeAdapter = HomeAdapter()
        rv_fl.layoutManager = StaggeredGridLayoutManager(2 , StaggeredGridLayoutManager.VERTICAL)
        rv_fl.adapter = homeAdapter

        homeViewModel.mutableLiveData.observe(this , object : ResponseCallback<List<WelfareInfo>>(){
            override fun success(data: List<WelfareInfo>) {
                srl.isRefreshing = false
                homeAdapter.setNewData(data)
            }

            override fun error(msg: String?) {
                Log.e("asd" , msg)
            }

        })
    }

}