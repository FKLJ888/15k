package maple.story.xdy.retrofit.entity

import maple.story.xdy.retrofit.base.BaseBean

/**
 *    作用：
 *    作者： 郑旭东
 *    日期：2017/11/29
 */

data class FindItemBean(
		val itemList: List<Item>,
		val count: Int, //10
		val total: Int, //0
		val nextPageUrl: String //http://baobab.kaiyanapp.com/api/v3/videos?start=10&num=10&categoryName=%E6%97%B6%E5%B0%9A&strategy=date
):BaseBean()

data class Item(
		val type: String, //video
		val data: Data,
		val tag: Any, //null
		val id: Int //0
)

data class Data(
		val dataType: String, //VideoBeanForClient
		val id: Int, //63220
		val title: String, //少年企画| 宋茜 透明纯净的心
		val slogan: Any, //null
		val description: String, //少年企画诚意制作 带着透明纯净的心 宋茜洒脱自在执着拼搏，更多内容关注少年企画官方微博：少年企画NEWS 官方微信：shaonianqihua 官方微信公众号：少年企画NEWS
		val provider: Provider,
		val category: String, //时尚
		val author: Author,
		val cover: Cover,
		val playUrl: String, //http://baobab.kaiyanapp.com/api/v1/playUrl?vid=63220&editionType=default&source=qcloud
		val thumbPlayUrl: Any, //null
		val duration: Int, //64
		val webUrl: WebUrl,
		val releaseTime: Long, //1511866890000
		val library: String, //DEFAULT
		val playInfo: List<Any>,
		val consumption: Consumption,
		val campaign: Any, //null
		val waterMarks: Any, //null
		val adTrack: Any, //null
		val tags: List<Tag>,
		val type: String, //NORMAL
		val titlePgc: String, //少年企画| 宋茜 透明纯净的心
		val descriptionPgc: String, //少年企画诚意制作 带着透明纯净的心 宋茜洒脱自在执着拼搏，更多内容关注少年企画官方微博：少年企画NEWS 官方微信：shaonianqihua 官方微信公众号：少年企画NEWS
		val remark: String,
		val idx: Int, //0
		val shareAdTrack: Any, //null
		val favoriteAdTrack: Any, //null
		val webAdTrack: Any, //null
		val date: Long, //1511866890000
		val promotion: Any, //null
		val label: Any, //null
		val labelList: List<Any>,
		val descriptionEditor: String,
		val collected: Boolean, //false
		val played: Boolean, //false
		val subtitles: List<Any>,
		val lastViewTime: Any, //null
		val playlists: Any //null
)

data class Tag(
		val id: Int, //544
		val name: String, //美女
		val actionUrl: String, //eyepetizer://tag/544/?title=%E7%BE%8E%E5%A5%B3
		val adTrack: Any, //null
		val desc: Any, //null
		val bgPicture: String, //http://img.kaiyanapp.com/4f8c478d7753f65e4ec3407b3d055edf.jpeg?imageMogr2/quality/100
		val headerImage: String, //http://img.kaiyanapp.com/c1e1357770cc194272e735f3b1469868.jpeg?imageMogr2/quality/100
		val tagRecType: String //NORMAL
)

data class Provider(
		val name: String, //PGC
		val alias: String, //PGC
		val icon: String
)

data class Author(
		val id: Int, //1625
		val icon: String, //http://img.kaiyanapp.com/c62a24c52588c6ba36c5c3ac3f4d2143.png?imageMogr2/quality/60/format/jpg
		val name: String, //少年企画NEWS
		val description: String, //国际化时尚视觉影像团队
		val link: String,
		val latestReleaseTime: Long, //1511866890000
		val videoNum: Int, //71
		val adTrack: Any, //null
		val follow: Follow,
		val shield: Shield,
		val approvedNotReadyVideoCount: Int, //0
		val ifPgc: Boolean //true
)

data class Follow(
		val itemType: String, //author
		val itemId: Int, //1625
		val followed: Boolean //false
)

data class Shield(
		val itemType: String, //author
		val itemId: Int, //1625
		val shielded: Boolean //false
)

data class WebUrl(
		val raw: String, //http://www.eyepetizer.net/detail.html?vid=63220
		val forWeibo: String //http://www.eyepetizer.net/detail.html?vid=63220
)

data class Cover(
		val feed: String, //http://img.kaiyanapp.com/515b17f722ae97c04427a9a7cf67c2ce.png?imageMogr2/quality/60/format/jpg
		val detail: String, //http://img.kaiyanapp.com/515b17f722ae97c04427a9a7cf67c2ce.png?imageMogr2/quality/60/format/jpg
		val blurred: String, //http://img.kaiyanapp.com/8cacce2b2e215ea6d53b58d408b9f3d3.jpeg?imageMogr2/quality/60/format/jpg
		val sharing: Any, //null
		val homepage: Any //null
)

data class Consumption(
		val collectionCount: Int, //13
		val shareCount: Int, //10
		val replyCount: Int //0
)