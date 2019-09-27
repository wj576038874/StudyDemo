package com.joyrun.mine

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.grouter.GActivityCenter
import com.grouter.RouterComponent
import com.joyrun.base.UserManager
import kotlinx.android.synthetic.main.mine_fragment_personal.*

/**
 * author: wneJie
 * date: 2019-09-24 18:10
 * desc:
 */
@RouterComponent(protocol = Fragment::class)
class MineFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.mine_fragment_personal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_1.setOnClickListener {
            GActivityCenter.UserActivity().name("123").start(this)
        }

        btn_4.setOnClickListener {
            UserManager.get().loginout()
            tv_loginstatus.text = if (UserManager.get().getLoginStatus()) {
                "已经登陆"
            } else {
                "未登录"
            }
        }

        btn_2.setOnClickListener {
            GActivityCenter.CollectionActivity().start(this)
        }

        btn_3.setOnClickListener {

        }


    }

    override fun onResume() {
        super.onResume()
        tv_loginstatus.text = if (UserManager.get().getLoginStatus()) {
            "已经登陆"
        } else {
            "未登录"
        }
    }
}