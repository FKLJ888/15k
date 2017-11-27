package maple.story.xdy.mvp.base

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import maple.story.xdy.retrofit.base.ApiService
import maple.story.xdy.retrofit.base.RetrofitUtils

/**
 * Created by XP on 2017/11/23.
 */
abstract class BaseModle : IModle {
    protected var apiService:ApiService?=null

    init {
        apiService=RetrofitUtils.getService()
    }

    override fun threadChange(observable: Observable<Any>, observer: Observer<Any>) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
    }
}