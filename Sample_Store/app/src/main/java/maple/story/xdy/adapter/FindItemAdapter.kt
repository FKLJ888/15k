package maple.story.xdy.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.facebook.drawee.view.SimpleDraweeView
import kotlinx.android.synthetic.main.for_find_item.view.*
import maple.story.xdy.R
import maple.story.xdy.retrofit.entity.Item

/**
 *    作用：
 *    作者： 郑旭东
 *    日期：2017/11/29
 */
class FindItemAdapter(var context: Context, var list: List<Item>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.for_find_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if (list[position].data.title != "") {
            holder!!.itemView!!.find_item_img!!.setImageURI(list[position].data.cover.detail)
            holder!!.itemView!!.find_item_name.text = list[position].data.title
        }else{
            holder!!.itemView!!.find_item_img!!.setImageURI(list[list.size-1].data.cover.detail)
            holder!!.itemView!!.find_item_name.text = list[list.size-1].data.title
        }
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var img: SimpleDraweeView = itemView?.findViewById(R.id.find_item_img)!!
        var tv: TextView = itemView?.findViewById(R.id.find_item_name)!!
    }
}