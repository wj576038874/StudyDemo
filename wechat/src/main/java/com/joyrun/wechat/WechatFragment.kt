package com.joyrun.wechat

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.chad.library.adapter.base.BaseQuickAdapter
import com.grouter.RouterComponent
import com.joyrun.base.entity.news.NewsInfo
import com.joyrun.base.http.ResponseCallback
import com.joyrun.wechat.adapter.WechatAdapter
import com.joyrun.wechat.mvvm.NewsViewModel
import kotlinx.android.synthetic.main.wechat_fragment_news.*

/**
 * author: wneJie
 * date: 2019-09-24 18:07
 * desc:
 */
@RouterComponent(protocol = Fragment::class)
class WechatFragment : Fragment() ,BaseQuickAdapter.RequestLoadMoreListener,
    SwipeRefreshLayout.OnRefreshListener {
    override fun onRefresh() {
        swip.isRefreshing = true
        newsViewModel.getNews()
    }

    override fun onLoadMoreRequested() {
        //分页加载
    }



    private lateinit var newsAdapter: WechatAdapter

    private lateinit var newsViewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,

        savedInstanceState: Bundle?
    ): View? {
        newsViewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)
        newsViewModel.getNews()
        return inflater.inflate(R.layout.wechat_fragment_news , container , false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        swip.isRefreshing = true
        swip.setOnRefreshListener(this)
        newsAdapter = WechatAdapter()
        newsAdapter.setOnLoadMoreListener(this , rv_news)
        rv_news.layoutManager = LinearLayoutManager(context)
        rv_news.adapter = newsAdapter
        newsViewModel.mutableLiveData.observe(this , object : ResponseCallback<List<NewsInfo>>(){
            override fun success(data: List<NewsInfo>) {
                swip.isRefreshing = false
                newsAdapter.setNewData(data)
            }

            override fun error(msg: String?) {
                Log.e("asd" , msg)
            }

        })

    }
}