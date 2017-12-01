package maple.story.xdy.fragment

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.Toast
import com.tt.lvruheng.eyepetizer.mvp.model.bean.HotBean
import maple.story.xdy.R
import maple.story.xdy.adapter.HotRecyclerViewAdapter
import maple.story.xdy.mvp.base.BaseFragment
import maple.story.xdy.mvp.contract.HotContract
import maple.story.xdy.mvp.presenter.HotPresenter

/**
 * desc:
 * name: 徐晓倩
 * time： 2017/11/29.
 */
class HotListFragment : BaseFragment<HotPresenter>(), HotContract.HotView{

    lateinit var hotRecyclerviewada :HotRecyclerViewAdapter
    lateinit var recycler: RecyclerView

    override fun showData(hotbean: HotBean) {
        var list : ArrayList<HotBean.ItemListBean.DataBean>? = ArrayList()
        for (bean in hotbean.itemList!!)
        {
            val playInfo = bean.data!!.playInfo
            if(playInfo!!.size>0){
                list!!.add(bean.data!!)
            }
        }
        hotRecyclerviewada = HotRecyclerViewAdapter(context, list!!)
        recycler.adapter = hotRecyclerviewada

        hotRecyclerviewada!!.setOnItemClickListener(object : HotRecyclerViewAdapter.OnItemClickListener{
            override fun onItemClick(view: View, position: Int) {
                Log.i("hhh","点击了第"+position)
                Toast.makeText(context,"点击的是第"+position,Toast.LENGTH_SHORT).show()
            }
        })

        var stagger = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
        recycler.layoutManager = stagger
    }

    override fun initEvent(context: Context) {
        presenter.LogicProcess()
    }

    override fun initData(context: Context) {
    }

    override fun initContentView(): Int {
        return R.layout.hotlist_fragment
    }

    override fun initView(view: View) {

        recycler = view.findViewById(R.id.recycler)

    }

}