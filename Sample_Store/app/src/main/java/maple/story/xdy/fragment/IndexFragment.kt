package maple.story.xdy.fragment

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.tt.lvruheng.eyepetizer.mvp.model.bean.HomeBean
import kotlinx.android.synthetic.main.fragment_index.*
import maple.story.xdy.R
import maple.story.xdy.adapter.HomeAdapter
import maple.story.xdy.mvp.base.BaseFragment
import maple.story.xdy.mvp.contract.IndexContract
import maple.story.xdy.mvp.presenter.IndexPresenter

/**
 * Created by XP on 2017/11/27.
 */
class IndexFragment :BaseFragment<IndexPresenter>(),IndexContract.IndexView{
    lateinit var tv: TextView
    var mAdapter: HomeAdapter? = null

    lateinit var list : ArrayList<HomeBean.IssueListBean.ItemListBean.DataBean>
    //V层的接口
    override fun dataSucc(bean: HomeBean) {
        list= ArrayList()
        var issList=bean.issueList

        for(i in 0..issList!!.size-1)
        {
            var itemlist=issList.get(i).itemList
            for (j in 0..itemlist!!.size-1)
            {
                if (j==0){
                    continue
                }
                list.add(itemlist.get(j).data!!)
                recyclerView.layoutManager = LinearLayoutManager(context)
                mAdapter= HomeAdapter(context,list)
                recyclerView.adapter=mAdapter
                mAdapter!!.setOnItemClickListener(object : HomeAdapter.OnItemClickListener{
                    override fun onItemClick(view: View, position: Int) {
                        Toast.makeText(context,"点击的是"+position+"个Item项",Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }

        Log.i("xxx","集合的数量 : "+list.size)
    }

    //初始化事件
    override fun initEvent(context: Context) {
        Log.i("xxx","IndexFragment的初始化事件的方法")
        presenter.requestData()
    }

    //初始化数据
    override fun initData(context: Context) {
        Log.i("xxx","IndexFragment的初始化数据的方法")
    }

    //初始化布局
    override fun initContentView(): Int {
        return R.layout.fragment_index
    }

    //findById用的
    override fun initView(view: View) {
        Log.i("xxx","IndexFragment的获取控件的方法")
        tv= view.findViewById(R.id.fragment_home_tv)
    }
}