package maple.story.xdy.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import maple.story.xdy.R
import maple.story.xdy.mvp.base.BaseActivity
import maple.story.xdy.mvp.presenter.HomePresenter

/**
 * Created by XP on 2017/11/27.
 */
class HomeActivity: BaseActivity<HomePresenter>(){
    private lateinit var fragments:List<Fragment>

    override fun initContextView(): Int {
        return R.layout.activity_home
    }

    override fun initData() {
    }

    override fun initListener() {
    }


}