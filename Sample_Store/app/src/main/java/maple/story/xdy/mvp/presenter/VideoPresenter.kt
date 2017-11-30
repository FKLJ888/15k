package maple.story.xdy.mvp.presenter

import android.widget.Toast
import maple.story.xdy.activity.VideoActivity
import maple.story.xdy.mvp.base.BasePresenter
import maple.story.xdy.mvp.contract.VideoContract
import maple.story.xdy.mvp.modle.VideoModle
import maple.story.xdy.runnable.MyRunnable
import java.net.URL

/**
 * Created by XP on 2017/11/27.
 */
class VideoPresenter : BasePresenter<VideoActivity, VideoModle>(),VideoContract.VideoPresenter{
    override fun requestModle(url:URL,title:String) {
        var runnable= MyRunnable(url,title)
        runnable.setListener(object : MyRunnable.ThreadListener{
            override fun start() {
            }
            override fun finish() {
                Toast.makeText(view,"下载完成",Toast.LENGTH_SHORT).show()
            }
        })
        modle.request(runnable)
    }

}