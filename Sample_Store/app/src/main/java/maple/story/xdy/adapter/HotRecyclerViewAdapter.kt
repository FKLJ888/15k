package maple.story.xdy.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.tt.lvruheng.eyepetizer.mvp.model.bean.HotBean
import maple.story.xdy.R

/**
 * desc:
 * name: 徐晓倩
 * time： 2017/11/29.
 */
class HotRecyclerViewAdapter (context : Context, list: ArrayList<HotBean.ItemListBean.DataBean>) : RecyclerView.Adapter<HotRecyclerViewAdapter.ViewHolder>() {
    var context : Context? = context
    var list : ArrayList<HotBean.ItemListBean.DataBean>? = list
    var inflater : LayoutInflater? = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): HotRecyclerViewAdapter.ViewHolder {
        return ViewHolder(inflater?.inflate(R.layout.item_hot,parent,false), context!!)
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        Picasso.with(context).load(list!!.get(position).provider!!.icon).into(holder!!.image)
        holder.tv!!.setText(list!!.get(position).title)

    }

    class ViewHolder(itemView: View?, context: Context) : RecyclerView.ViewHolder(itemView) {
        var image : ImageView?= null
        var tv:TextView?=null
        init {
            tv=itemView!!.findViewById(R.id.hotlist_tv)
            image = itemView?.findViewById(R.id.hotlist_img)
        }
    }
}