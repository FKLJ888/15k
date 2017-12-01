package maple.story.xdy.mvp.presenter

import android.util.Log
import com.tt.lvruheng.eyepetizer.mvp.model.bean.HomeBean
import maple.story.xdy.fragment.FindFragment
import maple.story.xdy.fragment.IndexFragment
import maple.story.xdy.mvp.base.BasePresenter
import maple.story.xdy.mvp.contract.IndexContract
import maple.story.xdy.mvp.modle.FindModle
import maple.story.xdy.mvp.modle.IndexModle
import maple.story.xdy.retrofit.observer.BaseObserver

/**
 * Created by XP on 2017/11/27.
 */
class IndexPresenter : BasePresenter<IndexFragment, IndexModle>(),IndexContract.IndexPresenter{

    override fun requestData() {
        //验证V层传递过来的参数
        Log.i("xxx","IndexP层验证数据")
        /**
         * ....
         */
        //调用M层获取数据的方法   //
        modle.getData(object : BaseObserver<IndexPresenter,HomeBean>(this, view.activity!!){
            override fun onSuccess(bean: HomeBean) {
                Log.i("xxx","Index获取数据成功")
                view.dataSucc(bean)
            }
            override fun onErrorable(e: Throwable) {
            }
        })
    }

    override fun requestData2(date: String) {
        //请求加载更多的数据
        modle.getData2(date,object : BaseObserver<IndexPresenter,HomeBean>(this,view.activity!!){
            override fun onSuccess(bean: HomeBean) {
                view.dataSucc2(bean)
            }
            override fun onErrorable(e: Throwable) {
            }

        })
    }
}
