package maple.story.xdy.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
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
    var mOnItemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): HotRecyclerViewAdapter.ViewHolder {

        var view = LayoutInflater.from(parent!!.getContext()).inflate(R.layout.item_hot, null)
        var holder = ViewHolder(view)

        return holder
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.image!!.setImageURI(list!!.get(position).cover!!.detail)
        holder!!.tv!!.setText(list!!.get(position).title)
        holder.itemView.setTag(position)
    }

    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView),View.OnClickListener {
        override fun onClick(v: View?) {
            if(mOnItemClickListener!=null){
                val tag = itemView.getTag() as Int
                mOnItemClickListener!!.onItemClick(itemView, tag)
            }
        }

        var image: SimpleDraweeView? =null
        var tv : TextView?=null
        init {
            image = itemView!!.findViewById(R.id.hotlist_img)
            tv = itemView.findViewById(R.id.hotlist_tv)
            itemView?.setOnClickListener(this)
        }
    }

    //定义接口
    interface OnItemClickListener{
        fun onItemClick(view:View,position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.mOnItemClickListener = listener
    }
}
//很冒险的梦  输了你赢了世界又如何
