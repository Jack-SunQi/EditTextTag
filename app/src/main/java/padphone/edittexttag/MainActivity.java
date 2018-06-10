package padphone.edittexttag;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = findViewById(R.id.editText);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TagDrawable randomTagDrawable = getRandomTagDrawable();

                ImageSpan imageSpan = new ImageSpan(randomTagDrawable, ImageSpan.ALIGN_BASELINE);
                String tempDrawableText = randomTagDrawable.getTag().getText();
                SpannableString spannableString = new SpannableString(tempDrawableText);
                //用drawable替换相应的文字
                spannableString.setSpan(imageSpan, 0, tempDrawableText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                int index = editText.getSelectionStart();
                Editable editableText = editText.getEditableText();
                if (index < 0 || index > editText.getText().length()) {
                    editableText.append(spannableString);
                } else {
                    editableText.insert(index, spannableString);
                }

                System.out.println("length==============" + editText.getText().toString().length());

            }
        });

    }

    /**
     * 随机获取一个tag
     * @return
     */
    private TagDrawable getRandomTagDrawable() {
        String text = Math.random() + "";
        Tag tag = new Tag.Builder().bgColor(Color.RED).text(text).textColor(Color.BLACK).textSize(60).build();
        TagDrawable tagDrawable = new TagDrawable(tag);
        //drawable在使用前需要重新测量宽高
        tagDrawable.setBounds(0, 0, tagDrawable.getIntrinsicWidth(), tagDrawable.getIntrinsicHeight());
        return tagDrawable;
    }
}
