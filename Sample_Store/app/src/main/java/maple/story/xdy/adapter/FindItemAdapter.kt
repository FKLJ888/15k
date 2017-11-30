package maple.story.xdy.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.facebook.drawee.view.SimpleDraweeView
import kotlinx.android.synthetic.main.for_find_item.view.*
import maple.story.xdy.R
import maple.story.xdy.activity.VideoActivity
import maple.story.xdy.retrofit.entity.Item

/**
 *    作用：
 *    作者： 郑旭东
 *    日期：2017/11/29
 */
class FindItemAdapter(var context: Context, var list: List<Item>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    lateinit var mRvListioner: RvListioner
    val intent = Intent()
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

        } else {
            holder!!.itemView!!.find_item_img!!.setImageURI(list[list.size - 1].data.cover.detail)
            holder!!.itemView!!.find_item_name.text = list[list.size - 1].data.title
        }

        holder.itemView.setOnClickListener {
            if (list[position].data.title != ""){
                intent.putExtra("playUrl", list.get(position).data.playUrl)//视频播放
                intent.putExtra("blurred", list.get(position).data.cover!!.blurred)//模糊图
                intent.putExtra("detail", list.get(position).data.cover!!.detail)//视频图
                intent.putExtra("description", list.get(position).data.description)//视频描述
                intent.putExtra("title", list.get(position).data.title)//视频标题
                intent.putExtra("duration", list.get(position).data.duration.toString())//视频时长
                intent.putExtra("collectionCount", list.get(position).data.consumption!!.collectionCount.toString())//收藏
                intent.putExtra("replyCount", list.get(position).data.consumption!!.replyCount.toString())//分享
                intent.putExtra("shareCount", list.get(position).data.consumption!!.shareCount.toString())//评论
            }else{
                intent.putExtra("playUrl", list.get(list.size - 1).data.playUrl)//视频播放
                intent.putExtra("blurred", list.get(list.size - 1).data.cover!!.blurred)//模糊图
                intent.putExtra("detail", list.get(list.size - 1).data.cover!!.detail)//视频图
                intent.putExtra("description", list.get(list.size - 1).data.description)//视频描述
                intent.putExtra("title", list.get(list.size - 1).data.title)//视频标题
                intent.putExtra("duration", list.get(list.size - 1).data.duration.toString())//视频时长
                intent.putExtra("collectionCount", list.get(list.size - 1).data.consumption!!.collectionCount.toString())//收藏
                intent.putExtra("replyCount", list.get(list.size - 1).data.consumption!!.replyCount.toString())//分享
                intent.putExtra("shareCount", list.get(list.size - 1).data.consumption!!.shareCount.toString())//评论
            }


            context.startActivity(intent.setClass(context, VideoActivity::class.java))
        }
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var img: SimpleDraweeView = itemView?.findViewById(R.id.find_item_img)!!
        var tv: TextView = itemView?.findViewById(R.id.find_item_name)!!
    }

    fun setRvListioner(rvListioner: RvListioner) {
        this.mRvListioner = rvListioner
    }

    interface RvListioner {
        fun onClick(view: View, position: Int)
    }
}