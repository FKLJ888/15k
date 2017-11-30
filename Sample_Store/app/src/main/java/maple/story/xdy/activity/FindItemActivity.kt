package maple.story.xdy.activity

import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.find_item.*
import maple.story.xdy.R
import maple.story.xdy.adapter.FindItemAdapter
import maple.story.xdy.mvp.base.BaseActivity
import maple.story.xdy.mvp.contract.FindItemContract
import maple.story.xdy.mvp.presenter.FindItemPresenter
import maple.story.xdy.retrofit.entity.FindItemBean

class FindItemActivity : BaseActivity<FindItemPresenter>() ,FindItemContract.FindItemView{
    var findItemAdapter:FindItemAdapter? = null
    override fun showData(findItemBean: FindItemBean) {
        find_rv.layoutManager = LinearLayoutManager(this)
        val itemList = findItemBean.itemList
        findItemAdapter = FindItemAdapter(this,itemList)
        find_rv.adapter = findItemAdapter
    }

    override fun initContextView(): Int {
        return R.layout.find_item
    }

    override fun initData() {
    }

    override fun initEvent() {
        var categoryName = intent.extras.get("categoryName")
        find_tv.text = categoryName as String?
        presenter.getData(categoryName as String)
    }



}
