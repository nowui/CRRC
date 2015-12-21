package com.nowui.crrc.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
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

public class MainView extends RelativeLayout {

    private Context myContext;
    private RelativeLayout contentRelativeLayout;
    private ImageButton homeImageButton;
    private ImageButton quitImageButton;

    private OnClickHomeButtonListener onClickHomeButtonListener;

    public interface OnClickHomeButtonListener {
        public void OnClick();
    }

    public void setOnClickHomeButtonListener(OnClickHomeButtonListener listener) {
        onClickHomeButtonListener = listener;
    }

    private OnClickQuitButtonListener onClickQuitButtonListener;

    public interface OnClickQuitButtonListener {
        public void OnClick();
    }

    public void setOnClickQuitButtonListener(OnClickQuitButtonListener listener) {
        onClickQuitButtonListener = listener;
    }

    public MainView(Context context) {
        super(context);

        myContext = context;

        initView(context);
    }

    public MainView(Context context, AttributeSet attrs) {
        super(context, attrs);

        myContext = context;

        initView(context);
    }

    public MainView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        myContext = context;

        initView(context);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    private void initView(Context context) {
        View.inflate(context, R.layout.view_main, this);

        contentRelativeLayout = new RelativeLayout(myContext);
        //contentRelativeLayout.setBackgroundColor(Color.parseColor("#ff0000"));

        RelativeLayout.LayoutParams contentRelativeLayoutParams = new RelativeLayout.LayoutParams(Helper.Width, Helper.Height);
        contentRelativeLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        contentRelativeLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        contentRelativeLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        this.addView(contentRelativeLayout, contentRelativeLayoutParams);

        initBackground();

        initContent();

        initLogo();

        initHomeButton();

        initQuitButton();
    }

    private void initBackground() {
        ImageView backgroundImageView = new ImageView(myContext);
        backgroundImageView.setImageDrawable(getResources().getDrawable(R.mipmap.main_background));

        RelativeLayout.LayoutParams backgroundImageViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        backgroundImageViewLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        backgroundImageViewLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        contentRelativeLayout.addView(backgroundImageView, backgroundImageViewLayoutParams);
    }

    private void initContent() {

        MenuView.OnClickMenuViewListener onClickMenuViewListener = new MenuView.OnClickMenuViewListener() {
            @Override
            public void OnClick(int position) {
                final IndexlView indexlView = new IndexlView(myContext, position);
                indexlView.setOnClickIndexViewCloseButtonListener(new IndexlView.OnClickIndexViewCloseButtonListener() {
                    @Override
                    public void OnClick() {
                        removeView(indexlView);

                        homeImageButton.setVisibility(View.VISIBLE);
                        quitImageButton.setVisibility(View.VISIBLE);
                    }
                });

                RelativeLayout.LayoutParams indexlViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
                indexlViewLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
                indexlViewLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
                addView(indexlView, indexlViewLayoutParams);

                homeImageButton.setVisibility(View.INVISIBLE);
                quitImageButton.setVisibility(View.INVISIBLE);
            }
        };

        String jsonString = "[{\"type\": \"left\", \"tag\": 0, \"title\": \"menu_title_" + Helper.Language + "_" + Helper.Version + "_0\", \"top\": 565, \"left\": 670 }, {\"type\": \"left\", \"tag\": 1, \"title\": \"menu_title_" + Helper.Language + "_" + Helper.Version + "_1\", \"top\": 445, \"left\": 925 }]";

        JSONArray jsonArray = JSON.parseArray(jsonString);

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            MenuView menuView = new MenuView(myContext, jsonObject.get("type").toString(), jsonObject.get("title").toString());
            menuView.setTag(jsonObject.get("tag"));
            menuView.setOnClickMenuViewListener(onClickMenuViewListener);

            RelativeLayout.LayoutParams menuViewLayoutParams = new RelativeLayout.LayoutParams(Helper.formatPix(myContext, 300), Helper.formatPix(myContext, 100));
            menuViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            menuViewLayoutParams.topMargin = Helper.formatPix(myContext, Float.parseFloat(jsonObject.get("top").toString()));
            menuViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            menuViewLayoutParams.leftMargin = Helper.formatPix(myContext, Float.parseFloat(jsonObject.get("left").toString()));
            contentRelativeLayout.addView(menuView, menuViewLayoutParams);
        }
    }

    private void initLogo() {
        ImageView logoImageView = new ImageView(myContext);
        logoImageView.setImageDrawable(getResources().getDrawable(R.mipmap.logo));

        RelativeLayout.LayoutParams logoImageViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        logoImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        logoImageViewLayoutParams.topMargin = Helper.formatPix(myContext, 30);
        logoImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        logoImageViewLayoutParams.leftMargin = Helper.formatPix(myContext, 30);
        contentRelativeLayout.addView(logoImageView, logoImageViewLayoutParams);
    }

    private void initHomeButton() {
        homeImageButton = new ImageButton(myContext);
        homeImageButton.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("home_button_" + Helper.Language, "mipmap", "com.nowui.crrc")));
        homeImageButton.getBackground().setAlpha(0);
        homeImageButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickHomeButtonListener != null) {
                    onClickHomeButtonListener.OnClick();
                }
            }
        });

        RelativeLayout.LayoutParams homeImageButtonLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        homeImageButtonLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        homeImageButtonLayoutParams.bottomMargin = Helper.formatPix(myContext, 0);
        homeImageButtonLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        homeImageButtonLayoutParams.rightMargin = Helper.formatPix(myContext, 100);
        contentRelativeLayout.addView(homeImageButton, homeImageButtonLayoutParams);
    }

    private void initQuitButton() {
        quitImageButton = new ImageButton(myContext);
        quitImageButton.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("quit_button_" + Helper.Language, "mipmap", "com.nowui.crrc")));
        quitImageButton.getBackground().setAlpha(0);
        quitImageButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickQuitButtonListener != null) {
                    onClickQuitButtonListener.OnClick();
                }
            }
        });

        RelativeLayout.LayoutParams quitImageButtonLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        quitImageButtonLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        quitImageButtonLayoutParams.bottomMargin = Helper.formatPix(myContext, 0);
        quitImageButtonLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        quitImageButtonLayoutParams.rightMargin = Helper.formatPix(myContext, 0);
        contentRelativeLayout.addView(quitImageButton, quitImageButtonLayoutParams);
    }

}
