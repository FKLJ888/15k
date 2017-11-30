package maple.story.xdy.mvp.modle

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import maple.story.xdy.mvp.base.BaseModle
import maple.story.xdy.mvp.contract.FindItemContract
import maple.story.xdy.mvp.presenter.FindItemPresenter
import maple.story.xdy.retrofit.entity.FindItemBean
import maple.story.xdy.retrofit.observer.BaseObserver

/**
 *    作用：
 *    作者： 郑旭东
 *    日期：2017/11/29
 */
class FindItemModel:FindItemContract.FindItemModle,BaseModle() {
    override fun getData(categoryName:String,observer: BaseObserver<FindItemPresenter, FindItemBean>) {
        apiService!!.getFindDetailData(categoryName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
    }

}