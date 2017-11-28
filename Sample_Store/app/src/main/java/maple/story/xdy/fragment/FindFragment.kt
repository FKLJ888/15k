package maple.story.xdy.fragment

import android.content.Context
import android.util.Log
import android.view.View
import maple.story.xdy.R
import com.tt.lvruheng.eyepetizer.mvp.model.bean.FindBean
import kotlinx.android.synthetic.main.fragment_find.*
import maple.story.xdy.adapter.FindAdapter
import maple.story.xdy.mvp.base.BaseFragment
import maple.story.xdy.mvp.contract.FindContract
import maple.story.xdy.mvp.presenter.FindPresenter

/**
 * Created by XP on 2017/11/27.
 */
class FindFragment : BaseFragment<FindPresenter>(), FindContract.FindView

{
    var findAdapter: FindAdapter? = null

    override fun showData(findBean: MutableList<FindBean>) {
        Log.e("aaa", findBean.toString())
        findAdapter = FindAdapter(activity, findBean)
        find_gridView.adapter = findAdapter

    }

    override fun initEvent(context: Context) {
        presenter.getData()

    }

    override fun initData(context: Context) {
    }

    override fun initContentView(): Int {
        return R.layout.fragment_index
        return R.layout.fragment_find
    }

    override fun initView(view: View) {
    }
}