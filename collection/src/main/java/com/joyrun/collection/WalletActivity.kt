package com.joyrun.collection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.grouter.RouterActivity

@RouterActivity(value = "collection/WalletActivity",exported = false)
class WalletActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.collection_desc_activity)
    }
}
