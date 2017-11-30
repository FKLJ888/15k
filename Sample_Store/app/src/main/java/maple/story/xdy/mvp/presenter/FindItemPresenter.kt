package maple.story.xdy.mvp.presenter

import maple.story.xdy.activity.FindItemActivity
import maple.story.xdy.mvp.base.BasePresenter
import maple.story.xdy.mvp.contract.FindItemContract
import maple.story.xdy.mvp.modle.FindItemModel
import maple.story.xdy.retrofit.entity.FindItemBean
import maple.story.xdy.retrofit.observer.BaseObserver

/**
 *    作用：
 *    作者： 郑旭东
 *    日期：2017/11/29
 */
class FindItemPresenter : BasePresenter<FindItemActivity, FindItemModel>(), FindItemContract.FindItemPresenter {
    override fun getData(categoryName: String) {
        modle.getData(categoryName, object : BaseObserver<FindItemPresenter, FindItemBean>(this, view) {
            override fun onErrorable(e: Throwable) {
            }

            override fun onSuccess(bean: FindItemBean) {
                view.showData(bean)
            }
        })
    }

}