package maple.story.xdy.activity

import android.support.v4.app.Fragment
import maple.story.xdy.R
import maple.story.xdy.fragment.FindFragment
import maple.story.xdy.fragment.IndexFragment
import maple.story.xdy.mvp.base.BaseActivity
import maple.story.xdy.mvp.presenter.HomePresenter
import java.util.*

/**
 * Created by XP on 2017/11/27.
 */
class HomeActivity: BaseActivity<HomePresenter>(){
    var fragments= ArrayList<Fragment>()

    override fun initEvent() {
        //添加一个Fragment
        supportFragmentManager.beginTransaction().add(R.id.main_frameLayout, IndexFragment()).commit()
    }

    override fun initContextView(): Int {
        return R.layout.activity_home
    }

    override fun initData() {
    }

}