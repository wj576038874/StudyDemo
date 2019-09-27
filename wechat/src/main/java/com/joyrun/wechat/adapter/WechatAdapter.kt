package com.joyrun.wechat.adapter

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.joyrun.base.entity.news.NewsInfo
import com.joyrun.base.entity.wechat.WxArticleBean
import com.joyrun.wechat.GlideRoundTransform
import com.joyrun.wechat.R

/**
 * author: wneJie
 * date: 2019-09-24 19:37
 * desc:
 */
class WechatAdapter : BaseQuickAdapter<NewsInfo, BaseViewHolder>(R.layout.wechat_item_news) {



//    override fun convert(helper: BaseViewHolder, item: NewsInfo?) {
//
//
//        /**
//         * helper.setText(R.id.tv_title, Html.fromHtml(item.getTitle()));
//        helper.setText(R.id.tv_author, item.getAuthor());
//        helper.setText(R.id.tv_time, item.getNiceDate());
//        helper.setText(R.id.tv_super_chapter_name, item.getSuperChapterName());
//        helper.setText(R.id.tv_chapter_name, item.getChapterName());
//        LinearLayout ll_new = helper.getView(R.id.ll_new);
//        if (item.isFresh()) {
//        ll_new.setVisibility(View.VISIBLE);
//        } else {
//        ll_new.setVisibility(View.GONE);
//        }
//        ImageView iv_img = helper.getView(R.id.iv_img);
//         */
//
//        item?.apply {
//            helper.setText(R.id.tv_title, title)
//            helper.setText(R.id.tv_author, author)
//            helper.setText(R.id.tv_time, niceDate)
//            helper.setText(R.id.tv_super_chapter_name, superChapterName)
////            val m = MultiTransformation(Cir)
//            Glide.with(mContext).applyDefaultRequestOptions(
//                RequestOptions.bitmapTransform(
//                    GlideRoundTransform()
//                ).placeholder(R.mipmap.wechat_ic_launcher).error(R.mipmap.wechat_ic_launcher)
//            ).load(envelopePic).into(helper.getView(R.id.iv_img))
//        }
//
//    }





    override fun convert(helper: BaseViewHolder, item: NewsInfo?) {
        item?.apply {
            helper.setText(R.id.node_name, node_name)
            helper.setText(R.id.title, title)
            helper.setText(R.id.host_name, address)
            helper.setText(R.id.time, created_at)
//            val m = MultiTransformation(Cir)
            Glide.with(mContext).applyDefaultRequestOptions(
                RequestOptions.bitmapTransform(
                    GlideRoundTransform()
                ).placeholder(R.mipmap.wechat_ic_launcher).error(R.mipmap.wechat_ic_launcher)
            ).load(user?.avatar_url).into(helper.getView(R.id.avatar))
        }
    }
}