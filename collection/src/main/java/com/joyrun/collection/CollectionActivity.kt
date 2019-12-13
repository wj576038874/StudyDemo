package com.joyrun.collection

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.grouter.GActivityCenter
import com.grouter.RouterActivity
import com.joyrun.base.UserManager
import com.joyrun.base.coroutine.BaseActivity
import com.joyrun.base.coroutine.log
import com.joyrun.base.coroutine.showToast
import com.joyrun.base.entity.login.UserInfo
import com.joyrun.base.http.ResponseCallback
import com.joyrun.collection.adapter.CollectionAdapter
import com.joyrun.base.entity.collection.Topic
import com.joyrun.base.entity.collection.TopicWithNews
import com.joyrun.collection.mvvm.CollectionViewModel
import kotlinx.android.synthetic.main.collection_activity_collection.*

/**
 * 我的收藏
 */
@RouterActivity(value = "collection/CollectionActivity", exported = false)
class CollectionActivity : BaseActivity<CollectionViewModel>() {
    override fun getViewModelClass(): Class<CollectionViewModel> = CollectionViewModel::class.java

//    private lateinit var collectionViewModel: CollectionViewModel

    private lateinit var collectionAdapter: CollectionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.collection_activity_collection)

//        collectionViewModel = ViewModelProviders.of(this).get(CollectionViewModel::class.java)

        collectionAdapter = CollectionAdapter()


        rv_collection.layoutManager = LinearLayoutManager(this)
        rv_collection.adapter = collectionAdapter
        collectionAdapter.setOnItemClickListener { adapter, view, position ->
            GActivityCenter.WalletActivity().start(this)
        }

        viewModel.mutableLiveData.observe(this, object : ResponseCallback<List<Topic>>() {

            override fun loading() {
                srl_collection.isRefreshing = true
            }

            override fun success(data: List<Topic>) {
                srl_collection.isRefreshing = false
                collectionAdapter.setNewData(data)
            }

            override fun error(msg: String?) {
                srl_collection.isRefreshing = false
                showToast(msg)
            }
        })
//        srl_collection.isEnabled = false
        srl_collection.isRefreshing = true
//        UserManager.get().getUserInfo()?.login?.log()
//        collectionViewModel.get("wj576038874")

//        collectionViewModel.get2("wj576038874")

        viewModel.getTopicWithNews()


        viewModel.userInfoLiveData.observe(this , object : ResponseCallback<UserInfo>(){

            override fun loading() {
                srl_collection.isRefreshing = true
            }
            override fun success(data: UserInfo) {
                srl_collection.isRefreshing = false
                showToast("登录成功${data.name}")
                data.log()
            }

            override fun error(msg: String?) {
                srl_collection.isRefreshing = false
                showToast(msg)
            }
        })

        viewModel.data.observe(this ,  object : ResponseCallback<TopicWithNews>(){


            override fun success(data: TopicWithNews) {
                srl_collection.isRefreshing = false
                collectionAdapter.setNewData(data.topic)
            }

            override fun error(msg: String?) {
                srl_collection.isRefreshing = false
                showToast(msg)
            }
        })

    }
}
