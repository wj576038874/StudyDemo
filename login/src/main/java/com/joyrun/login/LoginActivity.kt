package com.joyrun.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.grouter.RouterActivity
import com.joyrun.base.UserManager
import com.joyrun.base.core.onTextChange
import com.joyrun.base.entity.login.UserInfo
import com.joyrun.base.http.ResponseCallback
import com.joyrun.login.mvvm.LoginViewModel
import kotlinx.android.synthetic.main.login_activity_login.*

@RouterActivity(value = "login/LoginActivity",exported = false)
class LoginActivity : AppCompatActivity() {


    private lateinit var loginViewModel: LoginViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity_login)

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        loginViewModel.mutableLiveData.observe(this , object : ResponseCallback<UserInfo>(){
            override fun success(data: UserInfo) {
                login_srl.isRefreshing = false
                UserManager.get().saveUserInfo(data)
                Toast.makeText(this@LoginActivity , "login success" , Toast.LENGTH_SHORT).show()
                finish()
            }

            override fun error(msg: String?) {
                Log.e("asd" , msg)
            }
        })

//        login_srl.setOnRefreshListener(this)

        login_btn.setOnClickListener {
            login_srl.isRefreshing = true
            loginViewModel.login()
        }
        login_phone_edit onTextChange {
            afterTextChanged {

            }

            beforeTextChanged { s, start, count, after ->

            }

            onTextChanged { s, start, before, count ->

            }
        }
    }
}
