package com.joyrun.study

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.grouter.GComponentCenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mContent: Fragment
    private var homeFragment: Fragment? = null
    private var newsFragment: Fragment? = null
    private var personalFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        homeFragment = GComponentCenter.HomeFragment()
//        mContent = homeFragment!!
//        val ft = supportFragmentManager.beginTransaction()
//        ft.add(R.id.fl_content, homeFragment!!)
//        ft.commit()
        mContent = GComponentCenter.HomeFragment()
        val ft= supportFragmentManager.beginTransaction()
        ft.add(R.id.fl_content, mContent)
        ft.commit()

        bottom_bar.setOnNavigationItemSelectedListener {
            Log.e("asd", it.title.toString())
            when (it.itemId) {
                R.id.home -> {
                    homeFragment ?: let {
                        homeFragment = GComponentCenter.HomeFragment()
                    }
                    switchContent(homeFragment!!)
                }
                R.id.news -> {
                    newsFragment ?: let {
                        newsFragment = GComponentCenter.WechatFragment()

                    }
                    switchContent(newsFragment!!)
                }
                R.id.personal -> {
                    personalFragment ?: let {
                        personalFragment = GComponentCenter.MineFragment()
                    }
                    switchContent(personalFragment!!)
                }
            }
            return@setOnNavigationItemSelectedListener true
        }

    }


    private fun switchContent(to: Fragment) {
        if (mContent !== to) {
            val transaction = supportFragmentManager.beginTransaction()
            if (!to.isAdded) { // 先判断是否被add过
                transaction.hide(mContent).add(R.id.fl_content, to)
                    .commit() // 隐藏当前的fragment，add下一个到Activity中
            } else {
                transaction.hide(mContent).show(to).commit() // 隐藏当前的fragment，显示下一个
            }
            mContent = to
        }
    }
}
