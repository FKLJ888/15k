package maple.story.xdy.mvp.base

/**
 * Created by XP on 2017/11/23.
 */
interface IPresenter {
    //绑定view
    fun attachView(iView: IView)

    //解绑view
    fun detachView()
}