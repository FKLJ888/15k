package maple.story.xdy.mvp.base

import io.reactivex.Observable
import io.reactivex.Observer
import maple.story.xdy.retrofit.base.BaseBean

/**
 * Created by XP on 2017/11/23.
 */
interface IModle {
    //Rxjava2改变线程的方法
    fun threadChange(observable:Observable<BaseBean>,observer: Observer<BaseBean>)
}