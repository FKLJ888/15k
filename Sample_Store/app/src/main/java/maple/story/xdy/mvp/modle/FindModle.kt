package maple.story.xdy.mvp.modle

import com.tt.lvruheng.eyepetizer.mvp.model.bean.FindBean
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import maple.story.xdy.mvp.base.BaseModle
import maple.story.xdy.mvp.contract.FindContract
import maple.story.xdy.mvp.presenter.FindPresenter
import maple.story.xdy.retrofit.observer.BaseListObserver

/**
 * Created by XP on 2017/11/27.
 */
class FindModle : BaseModle(),FindContract.FindModle {
    override fun getData(observer: BaseListObserver<FindPresenter, MutableList<FindBean>>) {
        apiService!!.getFindData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)

    }


}