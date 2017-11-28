package maple.story.xdy.fragment

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.TextView
import com.tt.lvruheng.eyepetizer.mvp.model.bean.HomeBean
import maple.story.xdy.R
import maple.story.xdy.mvp.base.BaseFragment
import maple.story.xdy.mvp.contract.IndexContract
import maple.story.xdy.mvp.presenter.IndexPresenter

/**
 * Created by XP on 2017/11/27.
 */
class IndexFragment :BaseFragment<IndexPresenter>(),IndexContract.IndexView{
    lateinit var tv: TextView

    //V层的接口
    override fun dataSucc(bean: HomeBean) {
        println("下一页的网址 : "+bean.nextPageUrl)
        Log.i("xxx","下一页的网址 : "+bean.nextPageUrl)
    }

    //初始化事件
    override fun initEvent(context: Context) {
        Log.i("xxx","IndexFragment的初始化事件的方法")
        presenter.requestData()
    }

    //初始化数据
    override fun initData(context: Context) {
        Log.i("xxx","IndexFragment的初始化数据的方法")
    }

    //初始化布局
    override fun initContentView(): Int {
        return R.layout.fragment_index
    }

    //findById用的
    override fun initView(view: View) {
        Log.i("xxx","IndexFragment的获取控件的方法")
        tv= view.findViewById(R.id.fragment_home_tv) as TextView
    }
}