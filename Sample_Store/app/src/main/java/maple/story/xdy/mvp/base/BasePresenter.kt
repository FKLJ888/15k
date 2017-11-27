package maple.story.xdy.mvp.base

import maple.story.xdy.utils.CreateObjUtil
import java.lang.ref.WeakReference

/**
 * Created by XP on 2017/11/23.
 */
abstract class BasePresenter<V : IView,M : IModle> : IPresenter {
    private lateinit var reference:WeakReference<V>

    protected var modle:M
    protected lateinit var view:V

    init {
        modle= CreateObjUtil.getT(this,1)!!
    }

    override fun attachView(iView: IView) {
        view=iView as V
        reference= WeakReference(view)
    }
    override fun detachView() {
        if(reference!=null)
        {
            reference.clear()
        }
    }
}