package maple.story.xdy.activity
import android.view.View
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_video.*

import maple.story.xdy.R
import maple.story.xdy.mvp.base.BaseActivity
import maple.story.xdy.mvp.presenter.VideoPresenter

class VideoActivity : BaseActivity<VideoPresenter>() {
    override fun initContextView(): Int {
        return R.layout.activity_video
    }
    override fun initData() {
    }
    override fun initEvent() {
        var playUrl = intent.getStringExtra("playUrl")//视频播放
        var blurred = intent.getStringExtra("blurred")//模糊图
        var detail = intent.getStringExtra("detail")//视频图
        var description = intent.getStringExtra("description")//视频描述
        var title = intent.getStringExtra("title")//视频标题
        var duration = intent.getStringExtra("duration")//视频时长
        var collectionCount = intent.getStringExtra("collectionCount")//收藏
        var replyCount = intent.getStringExtra("replyCount")//分享
        var shareCount = intent.getStringExtra("shareCount")//评论

        JCVideo.setUp(playUrl,"")
        Picasso.with(this).load(detail).into(JCVideo.ivThumb)
        Picasso.with(this).load(blurred).into(iv_bottom_bg)
        tv_video_title.setText(title)
        tv_video_time.setText(duration)
        tv_video_desc.setText(description)
        tv_video_favor.setText(collectionCount)
        tv_video_share.setText(replyCount)
        tv_video_reply.setText(shareCount)
        //下载点击事件
        iv_video_download.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {

            }
        })
    }

}
