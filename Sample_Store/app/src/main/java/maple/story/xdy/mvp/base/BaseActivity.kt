package maple.story.xdy.mvp.base

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import maple.story.xdy.utils.CreateObjUtil
import android.support.v4.content.ContextCompat
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import com.gyf.barlibrary.ImmersionBar
import maple.story.xdy.R
import org.zackratos.ultimatebar.UltimateBar


/**
 * Created by XP on 2017/11/23.
 */
abstract class BaseActivity<P : IPresenter> : AppCompatActivity(), IView {
    protected lateinit var presenter:P
    protected lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ImmersionBar.with(this)
                .barColor(R.color.beige)
                .init()

        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(initContextView())

        context=applicationContext

        val conentFrameLayout = findViewById(Window.ID_ANDROID_CONTENT) as ViewGroup

        val parentView = conentFrameLayout.getChildAt(0)
        if (parentView != null && Build.VERSION.SDK_INT >= 14) {
            parentView.fitsSystemWindows = true
        }

        //通过泛型获取P层对象,或者创建对象
        presenter = CreateObjUtil.getT(this, 0)!!
        if (presenter != null) {
            //P层与V层绑定
            presenter.attachView(this)
        }

        initData()
        initEvent()
    }

    //初始化View
    abstract fun initContextView():Int

    //初始化数据
    abstract fun initData()

    //创建事件
    abstract fun initEvent()

    override fun onDestroy() {
        super.onDestroy()
        if (presenter!=null)
        {
            presenter.detachView()

        }
        ImmersionBar.with(this).destroy()
    }
}