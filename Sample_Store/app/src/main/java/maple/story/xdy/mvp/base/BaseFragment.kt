package maple.story.xdy.mvp.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import maple.story.xdy.utils.CreateObjUtil

/**
 * Created by XP on 2017/11/27.
 */
abstract class BaseFragment<P : IPresenter> : Fragment(),IView{
    protected lateinit var presenter:P
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        presenter=CreateObjUtil.getT(this,0)!!
        if(presenter!=null)
        {
            presenter.attachView(this)
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (presenter!=null)
        {
            presenter.detachView()
        }
    }
}