package maple.story.xdy.runnable

import android.os.Handler
import android.util.Log
import maple.story.xdy.app.FrescoApp
import maple.story.xdy.utils.CreateFileUtil
import java.io.File
import java.io.RandomAccessFile
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 * Created by XP on 2017/11/30.
 */
class MyRunnable(url: URL, title:String) : Runnable{
    private val url:URL=url
    private val title:String=title
    private val executorService: ExecutorService
        get() = Executors.newFixedThreadPool(THREAD_NUM)
    private val handler:Handler=FrescoApp.handler

    private lateinit var listener:ThreadListener

    //常量
    private val THREAD_NUM=Runtime.getRuntime().availableProcessors()

    fun setListener(listener: ThreadListener)
    {
        this.listener=listener
    }

    override fun run() {
        if (listener!=null)
        {
            handler.post(object :Runnable{
                override fun run() {
                    //调用开始方法
                    listener.start()
                }
            })
        }
        val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
        connection.requestMethod="GET"
        connection.readTimeout=10000
        connection.connectTimeout=10000
        if (connection.responseCode==200)
        {
            Log.i("xxx","线程数 : $THREAD_NUM")
            //请求成功   获取下载文件的大小
            var fileLength=connection.contentLength

            //根据标题创建文件
            var videoFile: File = CreateFileUtil.createFile(title)

            //创建一个与下载文件同样大小的本地文件
            var accessFile= RandomAccessFile(videoFile,"rwd")
            accessFile.setLength(fileLength.toLong())   //设置文件的大小
            accessFile.close()

            //每一个线程下载的字节数
            var threadLength=fileLength/THREAD_NUM
            var head:Int
            var tail:Int
            //获取到每一个线程下载的位置
            for (i in 0..THREAD_NUM-1)
            {
                head=i*threadLength
                tail=(i+1)*threadLength
                if (i==THREAD_NUM-1){
                    tail=fileLength-1
                }
                //开启线程池来执行每一个线程
                executorService.execute(Mp4Runnable(i,head,tail,videoFile,url))
            }
            executorService.shutdown()
            //下载完成,就关闭线程池
            while (true)
            {
                if (executorService.isTerminated)
                {
                    Log.i("xxx","所有的线程都执行完了")
                    break
                }
            }
            if (listener!=null)
            {
                handler.post(object :Runnable{
                    override fun run() {
                        //调用结束方法
                        listener.finish()
                    }
                })
            }
            val exit = Thread.interrupted()
            Log.i("xxx","总线程被挂起$exit")
        }
    }

    interface ThreadListener{
        fun start()
        fun finish()
    }
}