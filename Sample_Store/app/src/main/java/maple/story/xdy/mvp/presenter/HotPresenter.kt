package maple.story.xdy.mvp.presenter

import com.tt.lvruheng.eyepetizer.mvp.model.bean.HotBean
import maple.story.xdy.fragment.HotListFragment
import maple.story.xdy.mvp.base.BasePresenter
import maple.story.xdy.mvp.contract.HotContract
import maple.story.xdy.mvp.modle.HotModle
import maple.story.xdy.retrofit.observer.BaseObserver

/**
 * Created by XP on 2017/11/27.
 */
class HotPresenter : BasePresenter<HotListFragment, HotModle>(), HotContract.HotPresenter{
    override fun LogicProcess() {
        modle.getData(object : BaseObserver<HotPresenter,HotBean>(this,view.context){
            override fun onSuccess(bean: HotBean) {
                view.showData(bean)
            }

            override fun onErrorable(e: Throwable) {
            }

        })
    }

}