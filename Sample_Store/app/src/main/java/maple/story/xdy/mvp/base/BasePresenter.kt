package maple.story.xdy.mvp.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import maple.story.xdy.utils.CreateObjUtil
import java.lang.ref.WeakReference

/**
 * Created by XP on 2017/11/23.
 */
abstract class BasePresenter<V : IView,M : IModle> : IPresenter {
    private lateinit var reference:WeakReference<V>
    private var disposable: CompositeDisposable

    protected var modle:M
    protected lateinit var view:V

    init {
        modle= CreateObjUtil.getT(this,1)!!
        disposable= CompositeDisposable()
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
        if (disposable.size()>0)
        {
            disposable.dispose()
            disposable.clear()
        }
    }

    override fun addDisposable(d:Disposable){
        disposable.add(d)
    }
}