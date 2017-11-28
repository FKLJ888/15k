package maple.story.xdy.mvp.base

import android.content.Context
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
        var view:View=View.inflate(activity,initContentView(),null)
        initView(view)
        initData(activity)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initEvent(activity)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (presenter!=null)
        {
            presenter.detachView()
        }
    }

    abstract fun initEvent(context: Context)
    abstract fun initData(context: Context)
    abstract fun initContentView():Int
    abstract fun initView(view: View)
}