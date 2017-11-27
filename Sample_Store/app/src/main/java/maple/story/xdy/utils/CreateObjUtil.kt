package maple.story.xdy.utils

import java.lang.reflect.ParameterizedType

/**
 * Created by XP on 2017/11/27.
 */
class CreateObjUtil{

    companion object {
        fun <T> getT(o: Any, i: Int): T? {
            try {
                val parameterizedType = o.javaClass.genericSuperclass as ParameterizedType
                val clazz = parameterizedType.actualTypeArguments[i] as Class<T>
                return clazz.newInstance()
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return null
        }
    }
}