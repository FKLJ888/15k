package maple.story.xdy.mvp.base

import io.reactivex.Observable
import io.reactivex.Observer

/**
 * Created by XP on 2017/11/23.
 */
interface IModle {
    //Rxjava2改变线程的方法
    fun threadChange(observable:Observable<Any>,observer: Observer<Any>)
}