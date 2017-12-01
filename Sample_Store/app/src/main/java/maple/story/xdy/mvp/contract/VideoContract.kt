package maple.story.xdy.mvp.contract

import maple.story.xdy.runnable.MyRunnable
import java.net.URL

/**
 * Created by XP on 2017/11/30.
 */
class VideoContract {
    interface VideoView{
        //显示进度条
        fun showProgress(progress:Int)
    }
    interface VideoPresenter{
        //传递数据去M层
        fun requestModle(url:URL,title:String)
    }
    interface VideoModle
    {
        fun request(runnable: MyRunnable)
    }
}