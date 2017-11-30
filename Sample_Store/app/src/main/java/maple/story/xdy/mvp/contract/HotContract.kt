package maple.story.xdy.mvp.contract

import com.tt.lvruheng.eyepetizer.mvp.model.bean.HotBean
import maple.story.xdy.retrofit.observer.BaseObserver

/**
 * Created by XP on 2017/11/27.
 */
abstract class HotContract {
    //V层数据展示
    interface HotView{
        fun showData(bean: HotBean)
    }
    //P层逻辑处理
    interface HotPresenter{
        fun LogicProcess()
    }
    //M层请求数据
    interface HotModle{
        fun getData(observer: BaseObserver<maple.story.xdy.mvp.presenter.HotPresenter, HotBean>
        )
    }
}