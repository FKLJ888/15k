package maple.story.xdy.retrofit.observer

import android.content.Context
import android.widget.Toast
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import maple.story.xdy.mvp.base.IPresenter
import maple.story.xdy.retrofit.base.BaseBean
import retrofit2.HttpException
import java.io.IOException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.net.UnknownServiceException

/**
 * Created by XP on 2017/11/27.
 */
abstract class BaseObserver<P : IPresenter,B : BaseBean> (presenterObj:P,context: Context) :Observer<BaseBean> {
    private val presenter:P=presenterObj
    private val context:Context=context

    abstract fun onSuccess(bean:B)

    abstract fun onErrorable(e: Throwable)

    override fun onError(e: Throwable) {
        if (e is HttpException) {
            Toast.makeText(context, "http请求错误Json,无法解析", Toast.LENGTH_SHORT).show()
        } else if (e is SocketTimeoutException) {  //VPN open
            Toast.makeText(context, "服务器响应超时", Toast.LENGTH_SHORT).show()
        } else if (e is ConnectException) {
            Toast.makeText(context, "网络连接异常，请检查网络", Toast.LENGTH_SHORT).show()
        } else if (e is RuntimeException) {
            Toast.makeText(context, "运行时错误", Toast.LENGTH_SHORT).show()
        } else if (e is UnknownHostException) {
            Toast.makeText(context, "无法解析主机，请检查网络连接", Toast.LENGTH_SHORT).show()
        } else if (e is UnknownServiceException) {
            Toast.makeText(context, "未知的服务器错误", Toast.LENGTH_SHORT).show()
        } else if (e is IOException) {  //飞行模式等
            Toast.makeText(context, "没有网络，请检查网络连接", Toast.LENGTH_SHORT).show()
        }
        onErrorable(e)
    }

    override fun onNext(t: BaseBean) {
        var bean:B= t as B
        onSuccess(bean)
    }

    override fun onComplete() {
    }

    override fun onSubscribe(d: Disposable) {
        presenter.addDisposable(d)
    }
}