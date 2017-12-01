package maple.story.xdy.mvp.modle

import android.util.Log
import maple.story.xdy.mvp.base.BaseModle
import maple.story.xdy.mvp.contract.VideoContract
import maple.story.xdy.runnable.MyRunnable
import maple.story.xdy.utils.CreateFileUtil
import java.io.File
import java.io.RandomAccessFile
import java.net.HttpURLConnection
import java.net.URL

/**
 * Created by XP on 2017/11/27.
 */
class VideoModle : BaseModle(),VideoContract.VideoModle {

    override fun request(runnable: MyRunnable) {
        Thread(runnable).start()
    }
}