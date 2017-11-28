package maple.story.xdy.fragment

import android.content.Context
import android.view.View
import kotlinx.android.synthetic.main.fragment_index.view.*
import maple.story.xdy.R
import maple.story.xdy.mvp.base.BaseFragment
import maple.story.xdy.mvp.presenter.HotPresenter

/**
 * Created by XP on 2017/11/27.
 */
class HotFragment : BaseFragment<HotPresenter>() {
    override fun initEvent(context: Context) {
    }

    override fun initData(context: Context) {
    }

    override fun initContentView(): Int {
        return R.layout.fragment_index
    }

    override fun initView(view: View) {
    }
}