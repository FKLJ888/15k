package maple.story.xdy.mvp.modle

import android.util.Log
import com.tt.lvruheng.eyepetizer.mvp.model.bean.HomeBean
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import maple.story.xdy.mvp.base.BaseModle
import maple.story.xdy.mvp.contract.IndexContract
import maple.story.xdy.mvp.presenter.IndexPresenter
import maple.story.xdy.retrofit.base.BaseBean
import maple.story.xdy.retrofit.observer.BaseObserver

/**
 * Created by XP on 2017/11/27.
 *
 * 耗时操作:请求数据
 *
 * 请求参数,Observer(观察者)
 */
class IndexModle : BaseModle(),IndexContract.IndexModle{
    override fun getData2(date:String,observer: BaseObserver<IndexPresenter, HomeBean>) {
        apiService!!.getHomeMoreData(date,"2")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
    }

    override fun getData(observer: BaseObserver<IndexPresenter, HomeBean>) {

        Log.i("xxx","IndexM层获取数据")
        apiService!!.getHomeData().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
    }
}