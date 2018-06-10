# EditTextTag

实现选择技能标签的效果
[image](https://img-blog.csdn.net/20171130105233018?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvdTAxMzg5NDcxMQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


#实现思路

采用edittext图文混标的思路，在edittext中插入图片，这样可以实现一次添加，一次删除。edittext中插入的图片可以是bitmap或者drawable。因为drawable的可塑性比较强，而且tag中的内容是动态的，所以选择drawable来做处理



