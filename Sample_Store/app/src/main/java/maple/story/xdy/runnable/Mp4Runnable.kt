package maple.story.xdy.runnable

import android.util.Log
import java.io.File
import java.io.InputStream
import java.io.RandomAccessFile
import java.net.HttpURLConnection
import java.net.URL

/**
 * Created by XP on 2017/11/30.
 */
class Mp4Runnable(threadId:Int,head:Int,tail:Int,file:File,url:URL) : Runnable{
    private val threadId=threadId
    private val head=head
    private val tail=tail
    private val file=file
    private val url=url

    override fun run() {
        Log.i("xxx","线程$threadId 开始")
        val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
        connection.requestMethod="GET"
        connection.readTimeout=10000
        connection.connectTimeout=10000
        connection.setRequestProperty("Range","bytes=${head}-${tail}")      //添加Range字段
        if (connection.responseCode==200||connection.responseCode==206)
        {
            var inputStream=connection.inputStream
            var accessFile= RandomAccessFile(file,"rwd")
            accessFile.seek(head.toLong())
            var len=0
            var buffer:ByteArray=kotlin.ByteArray(2048)
            while (true){
                len=inputStream.read(buffer)
                Log.i("xxx","线程"+threadId+"下载中")
                if (len!=-1)
                {
                    accessFile.write(buffer,0,len)
                }
            }
            accessFile.close()
            Log.i("xxx","线程"+threadId+"over")
        }
    }
}