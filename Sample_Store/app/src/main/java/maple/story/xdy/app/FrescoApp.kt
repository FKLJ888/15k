package maple.story.xdy.app

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

/**
 *    作用：
 *    作者： 郑旭东
 *    日期：2017/11/28
 */
class FrescoApp :Application() {
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }
}