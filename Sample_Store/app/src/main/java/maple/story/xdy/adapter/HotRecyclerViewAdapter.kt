package maple.story.xdy.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.facebook.drawee.view.SimpleDraweeView
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
        return ViewHolder(inflater?.inflate(R.layout.item_hot,parent,false))
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.image!!.setImageURI(list!!.get(position).cover!!.detail)
        holder!!.tv!!.setText(list!!.get(position).title)
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var image : SimpleDraweeView?= itemView?.findViewById(R.id.hotlist_img)
        var tv:TextView?=itemView!!.findViewById(R.id.hotlist_tv)
    }
}
//很冒险的梦  输了你赢了世界又如何