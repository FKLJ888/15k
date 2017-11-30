package maple.story.xdy.utils

import android.os.Environment
import android.system.Os.mkdir
import java.io.File


/**
 * Created by XP on 2017/11/30.
 */
class CreateFileUtil {
    companion object {  //修饰静态的内容
        //创建标题创建对应的文件
        fun createFile(title:String):File{
            val file = File(Environment.getExternalStorageDirectory(), "/KaiEyeVideo")
            if (!file.isDirectory()) {
                file.mkdir()
            }
            val file1 = File(file, title+".mp4")
            file1.createNewFile()
            return file1
        }
    }

}