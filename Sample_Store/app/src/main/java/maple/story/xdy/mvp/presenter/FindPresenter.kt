package maple.story.xdy.mvp.presenter

import com.tt.lvruheng.eyepetizer.mvp.model.bean.FindBean
import maple.story.xdy.fragment.FindFragment
import maple.story.xdy.mvp.base.BasePresenter
import maple.story.xdy.mvp.contract.FindContract
import maple.story.xdy.mvp.modle.FindModle
import maple.story.xdy.retrofit.observer.BaseListObserver

/**
 * Created by XP on 2017/11/27.
 */
class FindPresenter : BasePresenter<FindFragment, FindModle>(),FindContract.FindPresenter{
    override fun getData() {
        modle.getData(object : BaseListObserver<FindPresenter,MutableList<FindBean>>(this,view.activity){
            override fun onSuccess(bean: MutableList<FindBean>) {
                view.showData(bean)
            }

            override fun onErrorable(e: Throwable) {
            }

        })
    }

}