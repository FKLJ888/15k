package maple.story.xdy.mvp.modle

import com.tt.lvruheng.eyepetizer.mvp.model.bean.HotBean
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import maple.story.xdy.mvp.base.BaseModle
import maple.story.xdy.mvp.contract.HotContract
import maple.story.xdy.mvp.presenter.HotPresenter
import maple.story.xdy.retrofit.observer.BaseObserver

/**
 * Created by XP on 2017/11/27.
 */
class HotModle : BaseModle(), HotContract.HotModle{
    override fun getData(observer: BaseObserver<HotPresenter, HotBean>) {
        apiService!!.getHotData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
    }
}