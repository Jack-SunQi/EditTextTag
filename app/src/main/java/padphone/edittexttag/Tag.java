package padphone.edittexttag;

/**
 * Created by sunqi on 2018/6/10.
 */

public class Tag {

    private int bgColor;
    private int textColor;
    private String text;
    private float textSize;

    Tag(Builder builder) {
        this.bgColor = builder.bgColor;
        this.textColor = builder.textColor;
        this.text = builder.text;
        this.textSize = builder.textSize;
    }

    public void setBgColor(int bgColor) {
        this.bgColor = bgColor;
    }

    public int getBgColor() {
        return bgColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setTextSize(float textSize) {
        this.textSize = textSize;
    }

    public float getTextSize() {
        return textSize;
    }

    public static class Builder {
        private int bgColor;
        private int textColor;
        private String text;
        private float textSize;

        public Builder bgColor(int bgColor) {
            this.bgColor = bgColor;
            return this;
        }

        public Builder textColor(int textColor) {
            this.textColor = textColor;
            return this;
        }

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Builder textSize(int textSize) {
            this.textSize = textSize;
            return this;
        }

        public Tag build() {
            return new Tag(this);
        }
    }

}
