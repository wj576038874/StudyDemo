package com.joyrun.home.adapter

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.joyrun.home.R
import com.joyrun.base.entity.home.WelfareInfo
import com.joyrun.base.coroutine.dip2px


/**
 * author: wneJie
 * date: 2019-09-25 10:59
 * desc:
 */
class HomeAdapter : BaseQuickAdapter<WelfareInfo, BaseViewHolder>(R.layout.home_home_item) {
    override fun convert(helper: BaseViewHolder, item: WelfareInfo?) {
        val layoutParams = helper.itemView.layoutParams
        val mHeight = (Math.random() * dip2px(mContext,50f) + dip2px(mContext,200f)).toInt()

        item?.apply {
            val image = helper.getView<ImageView>(R.id.iv_item_image)
            layoutParams.height = height
            helper.itemView.layoutParams = layoutParams
            Glide.with(mContext).load(url).into(helper.getView(R.id.iv_item_image))
        }
    }

}