package maple.story.xdy.fragment

import android.content.Context
import android.content.Intent
import android.view.View
import com.tt.lvruheng.eyepetizer.mvp.model.bean.FindBean
import kotlinx.android.synthetic.main.fragment_find.*
import maple.story.xdy.R
import maple.story.xdy.activity.FindItemActivity
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
    val intent = Intent()
    override fun showData(findBean: MutableList<FindBean>) {
        findAdapter = FindAdapter(activity, findBean)
        find_gridView.adapter = findAdapter
        find_gridView.setOnItemClickListener { adapterView, view, i, l ->
            intent.putExtra("categoryName",findBean[i].name)
            startActivity(intent.setClass(activity,FindItemActivity::class.java))
        }
    }

    override fun initEvent(context: Context) {
        presenter.getData()

    }

    override fun initData(context: Context) {
    }

    override fun initContentView(): Int {
        return R.layout.fragment_find
    }

    override fun initView(view: View) {
    }
}