package maple.story.xdy.mvp.contract

import maple.story.xdy.retrofit.entity.FindItemBean
import maple.story.xdy.retrofit.observer.BaseObserver

/**
 *    作用：
 *    作者： 郑旭东
 *    日期：2017/11/29
 */
abstract class FindItemContract {
    interface FindItemView{
        fun showData(findItemBean: FindItemBean)
    }
    interface FindItemPresenter{
        fun getData(categoryName:String)
    }
    interface FindItemModle{
        fun getData(categoryName:String,observer: BaseObserver<maple.story.xdy.mvp.presenter.FindItemPresenter,FindItemBean>)
    }
}