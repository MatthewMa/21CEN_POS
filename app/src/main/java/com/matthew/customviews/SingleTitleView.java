package com.matthew.customviews;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kvprasad.zbarbarcodescanner.R;

/**
 * Created by Sihua Ma on 2016/11/17.
 * Single line title content control
 * setitem_title(Strins s)  set title
 * setitem_content(String s) set content
 * setDanwei（String s）set unit
 */

public class SingleTitleView extends LinearLayout {

    private TextView title_tv;
    private TextView content_tv;
    private TextView danwei_tv;

    public SingleTitleView(Context context) {
        super(context);

        initView(context);
    }



    private void initView(Context context) {
        View.inflate(context, R.layout.single_title_view, this);
        title_tv = ((TextView) findViewById(R.id.single_item_title));
        content_tv = ((TextView) findViewById(R.id.single_item_content));
        danwei_tv = ((TextView) findViewById(R.id.single_item_danwei));
    }


    public void setitem_title(String title) {
        if (isNotNull(title, title_tv)) {
            title_tv.setText(title);
        }
    }


    public void setitem_content(String content) {
        if (isNotNull(content, content_tv)) {
            content_tv.setText(content);
        }
    }

    public void setDanwei(String danwei){
        if (isNotNull(danwei,danwei_tv)){
            danwei_tv.setVisibility(View.VISIBLE);
            danwei_tv.setText(danwei);
            if (">".equals(danwei)) {
                danwei_tv.setTextColor(Color.parseColor("#057dff"));
            }
        }
    }

    public void setContentColor(int s){
        content_tv.setTextColor(s);
    }


    private boolean isNotNull(String s, TextView t) {
        return (s!=null&&!"".equals(s)&&!"null".equals(s)&&t!=null);
    }
}
