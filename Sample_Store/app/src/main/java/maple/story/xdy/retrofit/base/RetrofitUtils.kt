package maple.story.xdy.retrofit.base

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by XP on 2017/11/23.
 */
class RetrofitUtils {
    companion object {
        @Volatile
        private var apiService: ApiService?=null

        fun getService():ApiService {
            if(apiService==null)
            {
                synchronized(this)
                {
                    if(apiService==null)
                    {
                        var interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor(object:HttpLoggingInterceptor.Logger{
                            override fun log(message: String?) {
                                Log.i("xxx",message)
                            }
                        })
                        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

                        var okHttpClient:OkHttpClient=OkHttpClient.Builder()
                                .addInterceptor(interceptor)
                                .writeTimeout(30,TimeUnit.SECONDS)
                                .readTimeout(30,TimeUnit.SECONDS)
                                .connectTimeout(30,TimeUnit.SECONDS)
                                .build()
                        var retrofit:Retrofit=Retrofit.Builder()
                                .baseUrl("http://baobab.wandoujia.com/api/")
                                .client(okHttpClient)
                                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                                .addConverterFactory(GsonConverterFactory.create())
                                .build()
                        apiService=retrofit.create(ApiService::class.java)
                    }
                }
            }
            return apiService!!
        }
    }
}