package maple.story.xdy.view

import android.content.Context
import android.graphics.Canvas
import android.widget.RelativeLayout
import android.view.ViewGroup
import android.view.Gravity
import android.widget.TextView
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import maple.story.xdy.R


/**
 * Created by XP on 2017/11/28.
 */
class TopBar(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : RelativeLayout(context, attrs, defStyleAttr) {
    private var right_iv: ImageView
    private var title_tv: TextView
    private var left_iv: ImageView

    private var rightParams: RelativeLayout.LayoutParams
    private var titleParams: RelativeLayout.LayoutParams
    private var leftParams: RelativeLayout.LayoutParams


    private var title: String       //标题
    private var titleColor: Int     //标题颜色
    private var titleSize: Float   //标题大小
    private var rightImageSrc: Drawable  //右侧图片
    private var topBarWidth: Float   //标题大小
    private var leftImageSrc: Drawable   //左侧图片

    private var clickListener: TopBarClickListener? = null

    constructor(context: Context):this(context,null,0)

    constructor(context: Context, attrs: AttributeSet?):this(context,attrs,0)

    init {
        //获取自定义属性
        val ta = context.obtainStyledAttributes(attrs, R.styleable.TopBar)
        //取出对应的值
        title = ta.getString(R.styleable.TopBar_title)
        titleColor = ta.getColor(R.styleable.TopBar_titleColor, 0x000)
        titleSize = ta.getDimension(R.styleable.TopBar_titleSize, 14f)
        rightImageSrc = ta.getDrawable(R.styleable.TopBar_rightImageSrc)
        topBarWidth=ta.getDimension(R.styleable.TopBar_TopBarWidth,100f)
        leftImageSrc=ta.getDrawable(R.styleable.TopBar_leftImageSrc)
        //调用recycle()  避免重复创建时有误
        ta.recycle()

        setBackgroundColor(resources.getColor(R.color.beige))
        //初始化控件
        right_iv = ImageView(context)
        title_tv = TextView(context)
        left_iv = ImageView(context)

        //给控件赋值
        title_tv.text = title
        title_tv.setTextColor(titleColor)
        title_tv.textSize = titleSize
        title_tv.gravity = Gravity.CENTER

        if (rightImageSrc != null) {
            right_iv.setImageDrawable(rightImageSrc)
        }
        if (leftImageSrc != null) {
            left_iv.setImageDrawable(leftImageSrc)
        }

        leftParams = RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE)
        leftParams.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE)
        val toLeft : Int = (topBarWidth/15).toInt()
        leftParams.setMargins(toLeft, 0, 0, 0)
        addView(left_iv, leftParams)

        rightParams = RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE)
        rightParams.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE)
        val toRight : Int = (topBarWidth/15).toInt()
        rightParams.setMargins(0, 0, toRight, 0)
        addView(right_iv, rightParams)

        titleParams = RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
        titleParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE)
        addView(title_tv, titleParams)

    }

    fun setOnTopBarClickListener(listener: TopBarClickListener) {
        this.clickListener = listener
        right_iv.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                clickListener!!.rightClick(view as ImageView)
            }
        })
        left_iv.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                clickListener!!.leftClick(v as ImageView)
            }
        })
    }
    fun setTitle(title:String){
        title_tv.setText(title)
    }
    fun setRightImage(resId:Int)
    {
        right_iv.setImageResource(resId)
    }
    fun setLeftImage(resId : Int)
    {
        left_iv.setImageResource(resId)
    }

    interface TopBarClickListener {
        fun rightClick(imageView: ImageView)
        fun leftClick(imageView: ImageView)
    }
}