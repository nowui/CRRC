package com.nowui.crrc.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nowui.crrc.R;
import com.nowui.crrc.utility.Helper;

public class IndexlView extends RelativeLayout {

    private Context myContext;
    private RelativeLayout contentRelativeLayout;
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

        contentRelativeLayout = new RelativeLayout(myContext);
        contentRelativeLayout.setClickable(true);
        contentRelativeLayout.setFocusable(true);

        RelativeLayout.LayoutParams contentRelativeLayoutParams = new RelativeLayout.LayoutParams(Helper.Width, Helper.Height);
        contentRelativeLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        contentRelativeLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        contentRelativeLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        this.addView(contentRelativeLayout, contentRelativeLayoutParams);

        initBackground();

        initContent();

        initBackButton();
    }

    private void initBackground() {
        ImageView backgroundImageView = new ImageView(myContext);
        backgroundImageView.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("index_background_" + tag, "mipmap", "com.nowui.crrc")));

        RelativeLayout.LayoutParams backgroundImageViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        backgroundImageViewLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        backgroundImageViewLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        contentRelativeLayout.addView(backgroundImageView, backgroundImageViewLayoutParams);
    }

    private void initContent() {
        ImageView titleImageView = new ImageView(myContext);
        titleImageView.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("index_title_" + Helper.Language + "_" + Helper.Version + "_" + tag, "mipmap", "com.nowui.crrc")));

        RelativeLayout.LayoutParams titleImageViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        titleImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        titleImageViewLayoutParams.topMargin = Helper.formatPix(myContext, 40);
        titleImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        titleImageViewLayoutParams.leftMargin = Helper.formatPix(myContext, 0);
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

        String jsonString = "[{\"type\": \"left\", \"tag\": 0, \"title\": \"menu_title_" + Helper.Language + "_" + Helper.Version + "_0_0\", \"top\": 650, \"left\": 648 }, {\"type\": \"left\", \"tag\": 1, \"title\": \"menu_title_" + Helper.Language + "_" + Helper.Version + "_0_1\", \"top\": 560, \"left\": 820 }, {\"type\": \"right\", \"tag\": 2, \"title\": \"menu_title_" + Helper.Language + "_" + Helper.Version + "_0_2\", \"top\": 360, \"left\": 845 }, {\"type\": \"left\", \"tag\": 3, \"title\": \"menu_title_" + Helper.Language + "_" + Helper.Version + "_0_3\", \"top\": 320, \"left\": 1233 }, {\"type\": \"right_right\", \"tag\": 4, \"title\": \"menu_title_" + Helper.Language + "_" + Helper.Version + "_0_4\", \"top\": 440, \"left\": 1272 }]";

        if (tag == 1) {
            jsonString = "[{\"type\": \"bottom\", \"tag\": 0, \"title\": \"menu_title_" + Helper.Language + "_" + Helper.Version + "_1_0\", \"top\": 672, \"left\": 720 }, {\"type\": \"right\", \"tag\": 1, \"title\": \"menu_title_" + Helper.Language + "_" + Helper.Version + "_1_1\", \"top\": 570, \"left\": 605 }, {\"type\": \"right\", \"tag\": 2, \"title\": \"menu_title_" + Helper.Language + "_" + Helper.Version + "_1_2\", \"top\": 527, \"left\": 803 }, {\"type\": \"bottom\", \"tag\": 3, \"title\": \"menu_title_" + Helper.Language + "_" + Helper.Version + "_1_3\", \"top\": 565, \"left\": 1193 }, {\"type\": \"right\", \"tag\": 4, \"title\": \"menu_title_" + Helper.Language + "_" + Helper.Version + "_1_4\", \"top\": 480, \"left\": 950 }, {\"type\": \"right_right\", \"tag\": 5, \"title\": \"menu_title_" + Helper.Language + "_" + Helper.Version + "_1_5\", \"top\": 512, \"left\": 1345 }]";
        }

        JSONArray jsonArray = JSON.parseArray(jsonString);

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            MenuView menuView = new MenuView(myContext, jsonObject.get("type").toString(), jsonObject.get("title").toString());
            menuView.setTag(jsonObject.get("tag"));
            menuView.setOnClickMenuViewListener(onClickMenuViewListener);

            RelativeLayout.LayoutParams menuViewLayoutParams = new RelativeLayout.LayoutParams(Helper.formatPix(myContext, 400), Helper.formatPix(myContext, 100));
            menuViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            menuViewLayoutParams.topMargin = Helper.formatPix(myContext, Float.parseFloat(jsonObject.get("top").toString()));
            menuViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            menuViewLayoutParams.leftMargin = Helper.formatPix(myContext, Float.parseFloat(jsonObject.get("left").toString()));
            contentRelativeLayout.addView(menuView, menuViewLayoutParams);
        }
    }

    private void initBackButton() {
        ImageButton backImageButton = new ImageButton(myContext);
        backImageButton.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("back_button_" + Helper.Language, "mipmap", "com.nowui.crrc")));
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
        backImageButtonLayoutParams.bottomMargin = Helper.formatPix(myContext, 0);
        backImageButtonLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        backImageButtonLayoutParams.rightMargin = Helper.formatPix(myContext, 0);
        contentRelativeLayout.addView(backImageButton, backImageButtonLayoutParams);
    }

}
