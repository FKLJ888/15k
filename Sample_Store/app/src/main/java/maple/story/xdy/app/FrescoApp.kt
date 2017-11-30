package maple.story.xdy.app

import android.app.Application
import android.os.Handler
import com.facebook.drawee.backends.pipeline.Fresco

/**
 *    作用：
 *    作者： 郑旭东
 *    日期：2017/11/28
 */
class FrescoApp :Application() {
    override fun onCreate() {
        super.onCreate()
        handler= Handler()
        Fresco.initialize(this)
    }
    companion object {
        lateinit var handler: Handler
    }
}