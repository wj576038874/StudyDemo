package com.joyrun.collection.adapter

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.joyrun.collection.R
import com.joyrun.base.entity.collection.Topic
import com.utils.GlideRoundTransform

/**
 * author: wneJie
 * date: 2019-09-25 16:41
 * desc:
 */
class CollectionAdapter : BaseQuickAdapter<Topic, BaseViewHolder>(R.layout.collection_item_topic) {
    override fun convert(helper: BaseViewHolder, item: Topic?) {
        item?.apply {
            helper.setText(R.id.username , user.name)
            helper.setText(R.id.time , created_at)
            helper.setText(R.id.title , title)
            helper.setText(R.id.node_name , node_name)
            helper.setText(R.id.state,"阅读${replies_count} · 评论${replies_count}")
            Glide.with(mContext).applyDefaultRequestOptions(
                RequestOptions.bitmapTransform(
                    GlideRoundTransform()
                ).placeholder(R.mipmap.collection_ic_launcher).error(R.mipmap.collection_ic_launcher)
            ).load(user?.avatar_url).into(helper.getView(R.id.avatar))
        }
    }
}