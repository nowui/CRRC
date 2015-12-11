package com.nowui.crrc.view;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nowui.crrc.R;
import com.nowui.crrc.utility.Helper;

import org.w3c.dom.Text;

public class IndexlView extends RelativeLayout {

    private Context myContext;
    private int tag;

    private OnClickIndexViewCloseButtonListener onClickIndexViewCloseButtonListener;

    public interface OnClickIndexViewCloseButtonListener {
        public void OnClick();
    }

    public void setOnClickIndexViewCloseButtonListener(OnClickIndexViewCloseButtonListener listener) {
        onClickIndexViewCloseButtonListener = listener;
    }

    public IndexlView(Context context, int position) {
        super(context);

        myContext = context;

        tag = position;

        initView(context);
    }

    public IndexlView(Context context, AttributeSet attrs) {
        super(context, attrs);

        myContext = context;

        initView(context);
    }

    public IndexlView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        myContext = context;

        initView(context);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    private void initView(Context context) {
        View.inflate(context, R.layout.view_index, this);

        initBackground();

        initContent();

        initBackButton();
    }

    private void initBackground() {
        ImageView backgroundImageView = new ImageView(myContext);
        backgroundImageView.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("index_background_" + tag, "mipmap", "com.nowui.crrc")));
        backgroundImageView.setScaleType(ImageView.ScaleType.CENTER);

        RelativeLayout.LayoutParams backgroundImageViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        backgroundImageViewLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        backgroundImageViewLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        this.addView(backgroundImageView, backgroundImageViewLayoutParams);
    }

    private void initContent() {
        RelativeLayout contentRelativeLayout = new RelativeLayout(myContext);

        RelativeLayout.LayoutParams contentRelativeLayoutParams = new RelativeLayout.LayoutParams(Helper.dip2px(myContext, Helper.Width), Helper.dip2px(myContext, Helper.Height));
        contentRelativeLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        contentRelativeLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        this.addView(contentRelativeLayout, contentRelativeLayoutParams);

        ImageView titleImageView = new ImageView(myContext);
        titleImageView.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("index_title_" + tag, "mipmap", "com.nowui.crrc")));

        RelativeLayout.LayoutParams titleImageViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        titleImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        titleImageViewLayoutParams.topMargin = Helper.dip2px(myContext, 40);
        titleImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        titleImageViewLayoutParams.leftMargin = Helper.dip2px(myContext, 0);
        contentRelativeLayout.addView(titleImageView, titleImageViewLayoutParams);

        MenuView.OnClickMenuViewListener onClickMenuViewListener = new MenuView.OnClickMenuViewListener() {
            @Override
            public void OnClick(int position) {
                final DetailView detailView = new DetailView(myContext, position, tag);
                detailView.setOnClickDetailViewCloseButtonListener(new DetailView.OnClickDetailViewCloseButtonListener() {
                    @Override
                    public void OnClick() {
                        removeView(detailView);
                    }
                });

                RelativeLayout.LayoutParams detailViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
                detailViewLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
                detailViewLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
                addView(detailView, detailViewLayoutParams);
            }
        };

        String jsonString = "[{\"type\": \"left\", \"tag\": 0, \"title\": \"menu_title_0_0\", \"top\": 160, \"left\": 205 }, {\"type\": \"left\", \"tag\": 1, \"title\": \"menu_title_0_1\", \"top\": 130, \"left\": 265 }, {\"type\": \"right\", \"tag\": 2, \"title\": \"menu_title_0_2\", \"top\": 50, \"left\": 338 }, {\"type\": \"left\", \"tag\": 3, \"title\": \"menu_title_0_3\", \"top\": 45, \"left\": 405 }, {\"type\": \"left\", \"tag\": 4, \"title\": \"menu_title_0_4\", \"top\": 75, \"left\": 402 }]";

        if (tag == 1) {
            jsonString = "[{\"type\": \"left\", \"tag\": 0, \"title\": \"menu_title_1_0\", \"top\": 158, \"left\": 238 }, {\"type\": \"left\", \"tag\": 1, \"title\": \"menu_title_1_1\", \"top\": 126, \"left\": 293 }, {\"type\": \"right\", \"tag\": 2, \"title\": \"menu_title_1_2\", \"top\": 75, \"left\": 324 }, {\"type\": \"left\", \"tag\": 3, \"title\": \"menu_title_1_3\", \"top\": 91, \"left\": 376 }, {\"type\": \"left\", \"tag\": 4, \"title\": \"menu_title_1_4\", \"top\": 55, \"left\": 392 }, {\"type\": \"left\", \"tag\": 5, \"title\": \"menu_title_1_5\", \"top\": 71, \"left\": 411 }]";
        }

        JSONArray jsonArray = JSON.parseArray(jsonString);

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            MenuView menuView = new MenuView(myContext, jsonObject.get("type").toString(), jsonObject.get("title").toString());
            menuView.setTag(jsonObject.get("tag"));
            menuView.setOnClickMenuViewListener(onClickMenuViewListener);

            RelativeLayout.LayoutParams menuViewLayoutParams = new RelativeLayout.LayoutParams(Helper.dip2px(myContext, 100), Helper.dip2px(myContext, 100));
            menuViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            menuViewLayoutParams.topMargin = Helper.dip2px(myContext, Float.parseFloat(jsonObject.get("top").toString()));
            menuViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            menuViewLayoutParams.leftMargin = Helper.dip2px(myContext, Float.parseFloat(jsonObject.get("left").toString()));
            contentRelativeLayout.addView(menuView, menuViewLayoutParams);
        }
    }

    private void initBackButton() {
        ImageButton backImageButton = new ImageButton(myContext);
        backImageButton.setImageDrawable(getResources().getDrawable(R.mipmap.back_button));
        backImageButton.getBackground().setAlpha(0);
        backImageButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickIndexViewCloseButtonListener != null) {
                    onClickIndexViewCloseButtonListener.OnClick();
                }
            }
        });

        RelativeLayout.LayoutParams backImageButtonLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        backImageButtonLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        backImageButtonLayoutParams.bottomMargin = Helper.dip2px(myContext, 0);
        backImageButtonLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        backImageButtonLayoutParams.rightMargin = Helper.dip2px(myContext, 0);
        this.addView(backImageButton, backImageButtonLayoutParams);
    }

}
