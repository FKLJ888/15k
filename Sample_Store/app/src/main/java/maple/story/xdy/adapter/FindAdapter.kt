package maple.story.xdy.adapter

import android.content.Context
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.facebook.drawee.view.SimpleDraweeView
import com.tt.lvruheng.eyepetizer.mvp.model.bean.FindBean
import maple.story.xdy.R

/**
 *    作用：
 *    作者： 郑旭东
 *    日期：2017/11/28
 */
class FindAdapter(var context: Context, var list: MutableList<FindBean>) : BaseAdapter() {
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var holder: ViewHolder
        var view: View
        if (p1 == null) {
            holder = ViewHolder()
            view = LayoutInflater.from(context).inflate(R.layout.for_fragment_find, p2, false)
            holder.img = view.findViewById(R.id.find_img)
            holder.img = view.findViewById(R.id.find_img)
            holder.name = view.findViewById(R.id.find_name)
            view.tag = holder
        } else {
            view = p1
            holder = view.tag as ViewHolder
        }
        holder.img?.setImageURI(Uri.parse(list[p0].bgPicture))
        holder.name?.text = list[p0].name
        return view
    }

    override fun getItem(p0: Int): Any {
        return list[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }

    class ViewHolder {
        var img: SimpleDraweeView? = null
        var name: TextView? = null
    }

}