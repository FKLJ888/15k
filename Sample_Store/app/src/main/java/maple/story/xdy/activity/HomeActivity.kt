package maple.story.xdy.activity

import android.support.v4.app.Fragment
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*
import maple.story.xdy.R
import maple.story.xdy.fragment.FindFragment
import maple.story.xdy.fragment.HotFragment
import maple.story.xdy.fragment.IndexFragment
import maple.story.xdy.fragment.MineFragment
import maple.story.xdy.mvp.base.BaseActivity
import maple.story.xdy.mvp.presenter.HomePresenter
import maple.story.xdy.view.TopBar

/**
 * Created by XP on 2017/11/27.
 */
class HomeActivity: BaseActivity<HomePresenter>(),View.OnClickListener, TopBar.TopBarClickListener {
    private lateinit var indexFragment:IndexFragment
    private lateinit var findFragment:FindFragment
    private lateinit var hotFragment: HotFragment
    private lateinit var mineFragment:MineFragment

    override fun initEvent() {
        //添加一个Fragment
        supportFragmentManager.beginTransaction().add(R.id.main_frameLayout, indexFragment)
                .add(R.id.main_frameLayout, hotFragment)
                .add(R.id.main_frameLayout, mineFragment)
                .add(R.id.main_frameLayout, findFragment)
                .commit()

        showFragment(indexFragment,main_footer_index_iv,R.mipmap.home_selected)

        main_footer_find.setOnClickListener(this)
        main_footer_hot.setOnClickListener(this)
        main_footer_index.setOnClickListener(this)
        main_footer_mine.setOnClickListener(this)

        main_topbar.setTitle("Monday")
        main_topbar.setRightImage(R.mipmap.icon_search)
        main_topbar.setOnTopBarClickListener(this)
    }

    override fun initContextView(): Int {
        return R.layout.activity_home
    }

    override fun initData() {
        indexFragment = IndexFragment()
        findFragment = FindFragment()
        hotFragment = HotFragment()
        mineFragment = MineFragment()


    }

    private fun showFragment(showFragment: Fragment, iv: ImageView, resId: Int) {
        supportFragmentManager.beginTransaction().hide(indexFragment)
                .hide(findFragment)
                .hide(hotFragment)
                .hide(mineFragment)
                .show(showFragment)
                .commit()

        main_footer_find_iv.setImageResource(R.mipmap.find_normal)
        main_footer_index_iv.setImageResource(R.mipmap.home_normal)
        main_footer_hot_iv.setImageResource(R.mipmap.hot_normal)
        main_footer_mine_iv.setImageResource(R.mipmap.mine_normal)
        iv.setImageResource(resId)
    }

    override fun onClick(v: View?) {
        var id:Int=v!!.id
        when(id)
        {
            R.id.main_footer_index -> {
                showFragment(indexFragment,main_footer_index_iv,R.mipmap.home_selected)
                main_topbar.setTitle("Monday")
                main_topbar.setRightImage(R.mipmap.icon_search)
                main_topbar.setOnTopBarClickListener(this)
            }
            R.id.main_footer_find ->
            {
                showFragment(findFragment,main_footer_find_iv,R.mipmap.find_selected)
                main_topbar.setTitle("Find")
                main_topbar.setRightImage(R.mipmap.icon_search)
                main_topbar.setOnTopBarClickListener(this)
            }
            R.id.main_footer_hot ->
            {
                showFragment(hotFragment,main_footer_hot_iv,R.mipmap.hot_selected)
                main_topbar.setTitle("hot")
                main_topbar.setRightImage(R.mipmap.icon_search)
                main_topbar.setOnTopBarClickListener(this)
            }
            R.id.main_footer_mine ->
            {
                showFragment(mineFragment,main_footer_mine_iv,R.mipmap.mine_selected)
                main_topbar.setTitle("mine")
                main_topbar.setRightImage(R.mipmap.icon_setting)
                main_topbar.setOnTopBarClickListener(object : TopBar.TopBarClickListener{
                    override fun rightClick(imageView: ImageView) {
                        Toast.makeText(context,"跳到设置页面",Toast.LENGTH_SHORT).show()
                        /**
                         * 设置页面
                         */
                    }
                })
            }
        }
    }

    override fun rightClick(imageView: ImageView) {
        Toast.makeText(context,"跳到搜索页面",Toast.LENGTH_SHORT).show()
        /**
         * 搜索页面
         */
    }

}