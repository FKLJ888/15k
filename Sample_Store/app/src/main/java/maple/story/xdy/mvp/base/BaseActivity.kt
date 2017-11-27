package maple.story.xdy.mvp.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import maple.story.xdy.utils.CreateObjUtil

/**
 * Created by XP on 2017/11/23.
 */
abstract class BaseActivity<P : IPresenter> : AppCompatActivity(), IView {
    protected lateinit var presenter:P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //通过泛型获取P层对象,或者创建对象
        presenter = CreateObjUtil.getT(this, 0)!!
        if (presenter != null) {
            //P层与V层绑定
            presenter.attachView(this)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (presenter!=null)
        {
            presenter.detachView()
        }
    }
}