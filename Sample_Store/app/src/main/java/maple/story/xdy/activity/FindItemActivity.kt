package maple.story.xdy.activity

import android.graphics.Color
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.widget.ImageView
import kotlinx.android.synthetic.main.find_item.*
import maple.story.xdy.R
import maple.story.xdy.adapter.FindItemAdapter
import maple.story.xdy.mvp.base.BaseActivity
import maple.story.xdy.mvp.contract.FindItemContract
import maple.story.xdy.mvp.presenter.FindItemPresenter
import maple.story.xdy.retrofit.entity.FindItemBean
import maple.story.xdy.view.TopBar

class FindItemActivity : BaseActivity<FindItemPresenter>(), FindItemContract.FindItemView {
    var findItemAdapter: FindItemAdapter? = null
    var handler = Handler()
    override fun showData(findItemBean: FindItemBean) {
        find_rv.layoutManager = LinearLayoutManager(this)
        val itemList = findItemBean.itemList
        findItemAdapter = FindItemAdapter(this, itemList)
        find_rv.adapter = findItemAdapter

    }

    override fun initContextView(): Int {
        return R.layout.find_item
    }

    override fun initData() {
    }

    override fun initEvent() {
        var categoryName = intent.extras.get("categoryName")
        find_topbar.setTitle(categoryName as String)
        find_topbar.setLeftImage(R.drawable.return_pic)
        find_topbar.setOnTopBarClickListener(object : TopBar.TopBarClickListener {
            override fun leftClick(imageView: ImageView) {
                finish()
            }

            override fun rightClick(imageView: ImageView) {
            }
        })
        presenter.getData(categoryName as String)
        sw.setColorSchemeColors(Color.RED,Color.BLUE,Color.YELLOW,Color.GREEN)
        sw.setOnRefreshListener {
            handler.postDelayed({

                sw.isRefreshing = false
            },2000)
        }
    }


}
