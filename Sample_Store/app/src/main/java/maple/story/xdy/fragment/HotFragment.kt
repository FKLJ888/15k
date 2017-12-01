package maple.story.xdy.fragment

import android.content.Context
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.view.View
import maple.story.xdy.R
import maple.story.xdy.mvp.base.BaseFragment
import maple.story.xdy.mvp.presenter.HotPresenter

/**
 * Created by XP on 2017/11/27.
 */
class HotFragment : BaseFragment<HotPresenter>(){

    var isOk = true
    lateinit var tab : TabLayout
    lateinit var viewpager: ViewPager

    override fun initEvent(context: Context) {
    }

    override fun initData(context: Context) {
    }

    override fun initContentView(): Int {
        return R.layout.fragment_hot
    }

    override fun initView(view: View) {
        val titles = ArrayList<String>()
        titles.clear()
        titles.add("周排行")
        titles.add("月排行")
        titles.add("总排行")

        tab = view.findViewById(R.id.tab)
        tab.tabMode = TabLayout.MODE_FIXED
//        tab.setTabTextColors(R.color.burlywood,R.color.burlywood)
        viewpager = view.findViewById(R.id.viewpager)

        for (i in titles.indices) {
            tab!!.addTab(tab!!.newTab().setText(titles[i]))
        }

        val fragments = ArrayList<Fragment>()

        /**
         * 循环遍历添加ViewPager的Fragment
         */
        for (i in titles.indices) {
            val listFragment = HotListFragment()
            val bundle = Bundle()
            val sb = StringBuffer()
            for (j in 1..8) {
                sb.append(titles[i]).append(" ")
            }
            bundle.putString("content", sb.toString())
            listFragment.arguments = bundle
            fragments.add(listFragment)
        }

        val mFragmentAdapteradapter = FragmentAdapter(fragmentManager, fragments, titles)
        viewpager!!.adapter = mFragmentAdapteradapter
        tab!!.setupWithViewPager(viewpager)
        tab!!.setTabsFromPagerAdapter(mFragmentAdapteradapter)
    }

    class FragmentAdapter(fm : FragmentManager, val mFragments : List<Fragment>, val mTitles : List<String>) : FragmentStatePagerAdapter(fm) {
        override fun getItem(position: Int): Fragment {
            return mFragments[position]
        }
        override fun getCount(): Int {
            return mFragments.size
        }
        override fun getPageTitle(position: Int): CharSequence {
            return mTitles[position]
        }
    }


}