package maple.story.xdy.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.facebook.drawee.view.SimpleDraweeView
import com.tt.lvruheng.eyepetizer.mvp.model.bean.HomeBean
import maple.story.xdy.R

/**
 * Created by Love_you on 2017/11/28 0028.
 */
class HomeAdapter(context: Context, list: MutableList<HomeBean.IssueListBean.ItemListBean.DataBean>?) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>(),View.OnClickListener {


    var context : Context? = context
    var list : MutableList<HomeBean.IssueListBean.ItemListBean.DataBean>? = list
    var inflater : LayoutInflater? = LayoutInflater.from(context)

    var mOnItemClickListener: OnItemClickListener? = null

    //绑定数据
    override fun onBindViewHolder(holder: HomeViewHolder?, position: Int) {
        holder!!.tv_title!!.setText(list!!.get(position).title)
        holder.tv_detail!!.setText(list!!.get(position).category)
        holder.iv_photo!!.setImageURI(list!!.get(position).cover!!.feed)
        holder.iv_user!!.setImageURI("http://img.kaiyanapp.com/27c223e61df5b647d061e41ee995e8f6.jpeg?imageMogr2/quality/60/format/jpg")

    }

    //加载布局
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): HomeViewHolder? {
//        HomeViewHolder(inflater?.inflate(R.layout.item_home,parent,false), context!!)
        var view = LayoutInflater.from(parent!!.getContext()).inflate(R.layout.item_home, null)
        val holder = HomeViewHolder(view)
        view.setOnClickListener(this)
        return holder
    }

    override fun onClick(v: View?) {
        if(mOnItemClickListener!=null){
            //注意这里使用getTag方法获取position
            mOnItemClickListener!!.onItemClick(v!!, v.getTag() as Int)
        }
    }

    //item的个数
    override fun getItemCount(): Int {
        return list!!.size
    }

    //viewHolder复用控件
    class HomeViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var tv_detail : TextView?= null
        var tv_title : TextView? = null
        var iv_photo : SimpleDraweeView? = null
        var iv_user : SimpleDraweeView? = null
        init {
            tv_detail = itemView?.findViewById(R.id.tv_detail)
            tv_title = itemView?.findViewById(R.id.tv_title)
            iv_photo = itemView?.findViewById(R.id.iv_photo)
            iv_user =  itemView?.findViewById(R.id.iv_user)
        }
    }
    interface OnItemClickListener{
        fun onItemClick(view:View,position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.mOnItemClickListener = listener
    }
}