package maple.story.xdy.mvp.contract

import com.tt.lvruheng.eyepetizer.mvp.model.bean.HomeBean
import maple.story.xdy.mvp.presenter.IndexPresenter
import maple.story.xdy.retrofit.observer.BaseObserver

/**
 * Created by XP on 2017/11/27.
 *
 * 首页MVP的总接口
 */
abstract class IndexContract {
    //V层的接口
    interface IndexView{
        fun dataSucc(bean:HomeBean)
        fun dataSucc2(bean:HomeBean)
    }
    //P层的接口
    interface IndexPresenter{
        fun requestData()
        fun requestData2(date:String)
    }
    //M层的接口
    interface IndexModle{
        fun getData(observer:BaseObserver<maple.story.xdy.mvp.presenter.IndexPresenter,HomeBean>)
        fun getData2(date:String,observer:BaseObserver<maple.story.xdy.mvp.presenter.IndexPresenter,HomeBean>)
    }
}