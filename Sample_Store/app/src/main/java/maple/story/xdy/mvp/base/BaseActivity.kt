package maple.story.xdy.mvp.base

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import maple.story.xdy.utils.CreateObjUtil
import android.support.v4.content.ContextCompat
import android.view.WindowManager
import maple.story.xdy.R
import org.zackratos.ultimatebar.UltimateBar


/**
 * Created by XP on 2017/11/23.
 */
abstract class BaseActivity<P : IPresenter> : AppCompatActivity(), IView {
    protected lateinit var presenter:P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }

        setContentView(initContextView())

        val ultimateBar = UltimateBar(this)
        ultimateBar.setColorBar(ContextCompat.getColor(this,R.color.abc_primary_text_material_dark))
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
    }
}