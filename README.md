# EditTextTag

实现选择技能标签的效果
[image](https://img-blog.csdn.net/20171130105233018?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvdTAxMzg5NDcxMQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


#实现思路

采用edittext图文混标的思路，在edittext中插入图片，这样可以实现一次添加，一次删除。edittext中插入的图片可以是bitmap或者drawable。因为drawable的可塑性比较强，而且tag中的内容是动态的，所以选择drawable来做处理

1.自定义一个drawable
````
 public class TagDrawable extends Drawable {
   
   @Override
   public void draw(@NonNull Canvas canvas) {
       //TODO 画图
   }
   
   @Override
   public void setAlpha(int i) {
       //TODO 设置画笔的透明度
   }
   
   @Override
   public void setColorFilter(@Nullable ColorFilter colorFilter) {
       //TODO 设置画笔的颜色过滤器
   }
   
   @Override
   public int getOpacity() {
       return PixelFormat.TRANSLUCENT;
   }
   
 }
 
 `````
 
 2.测量文字的高度
 
 ````//测量文字的宽高
     Rect textRect = new Rect();
     textPaint.getTextBounds(text, 0, text.length(), textRect);
     //背景宽度要比文字宽度宽一些
     width = textRect.width() + (textRect.width() / text.length() * 2);
     //背景高度是文字高度的1.5倍
     height = (int) (textRect.height() * 1.5);
 
 ````
 
 3.文字居中显示
 ````
 Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
 float top = fontMetrics.top;//为基线到字体上边框的距离,即上图中的top
 float bottom = fontMetrics.bottom;//为基线到字体下边框的距离,即上图中的bottom
 int baseLineY = (int) (rectF.centerY() - top / 2 - bottom / 2);//基线中间点的y轴计算公式
 canvas.drawText(text, rectF.centerX(), baseLineY, textPaint);
 ````
 
 
 

 
