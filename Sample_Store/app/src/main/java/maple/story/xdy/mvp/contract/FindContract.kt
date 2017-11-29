package maple.story.xdy.mvp.contract

import com.tt.lvruheng.eyepetizer.mvp.model.bean.FindBean
import maple.story.xdy.mvp.presenter.FindPresenter
import maple.story.xdy.retrofit.observer.BaseListObserver

/**
 * Created by XP on 2017/11/27.
 */
abstract class FindContract {
    interface FindView{
        fun showData(findBean: MutableList<FindBean>)
    }
    interface FindPresenter{
        fun getData()
    }
    interface FindModle{
        fun getData(observer: BaseListObserver<maple.story.xdy.mvp.presenter.FindPresenter, MutableList<FindBean>>)
    }
}