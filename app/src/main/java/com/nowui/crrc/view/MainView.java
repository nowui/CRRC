package com.nowui.crrc.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
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
    private ImageView homeImageView;
    private ImageView videoImageView;
    private ImageView quitImageView;

    private OnClickHomeButtonListener onClickHomeButtonListener;

    public interface OnClickHomeButtonListener {
        public void OnClick();
    }

    public void setOnClickHomeButtonListener(OnClickHomeButtonListener listener) {
        onClickHomeButtonListener = listener;
    }

    private OnClickVideoButtonListener onClickVideoButtonListener;

    public interface OnClickVideoButtonListener {
        public void OnClick();
    }

    public void setOnClickVideoButtonListener(OnClickVideoButtonListener listener) {
        onClickVideoButtonListener = listener;
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
        contentRelativeLayout.setClickable(true);
        contentRelativeLayout.setFocusable(true);
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

        if (Helper.Version == "all") {
            initVideoButton();
        }

        initQuitButton();
    }

    private void initBackground() {
        ImageView backgroundImageView = new ImageView(myContext);
        backgroundImageView.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("main_background_" + Helper.Version, "mipmap", Helper.defPackage)));

        RelativeLayout.LayoutParams backgroundImageViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        backgroundImageViewLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        backgroundImageViewLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        backgroundImageViewLayoutParams.width = Helper.formatPix(myContext, 1920);
        backgroundImageViewLayoutParams.height = Helper.formatPix(myContext, 1080);
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

                        homeImageView.setVisibility(View.VISIBLE);
                        if (videoImageView != null) {
                            videoImageView.setVisibility(View.VISIBLE);
                        }
                        quitImageView.setVisibility(View.VISIBLE);
                    }
                });

                RelativeLayout.LayoutParams indexlViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
                indexlViewLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
                indexlViewLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
                addView(indexlView, indexlViewLayoutParams);

                homeImageView.setVisibility(View.INVISIBLE);
                if (videoImageView != null) {
                    videoImageView.setVisibility(View.INVISIBLE);
                }
                quitImageView.setVisibility(View.INVISIBLE);
            }
        };

        String jsonString = "[";
        if(Helper.Version == "all") {
            if (Helper.Language == "zh") {
                jsonString += "{\"type\": \"left\", \"tag\": 0, \"title\": \"main_menu_title_zh_all_0\", \"top\": 430, \"left\": 120, \"width\": 120, \"height\": 31 }";
                jsonString += ", {\"type\": \"left\", \"tag\": 1, \"title\": \"main_menu_title_zh_all_1\", \"top\": 5, \"left\": 705, \"width\": 120, \"height\": 31 }";
                jsonString += ", {\"type\": \"left\", \"tag\": 2, \"title\": \"main_menu_title_zh_all_2\", \"top\": 690, \"left\": 365, \"width\": 139, \"height\": 31 }";
                jsonString += ", {\"type\": \"left\", \"tag\": 3, \"title\": \"main_menu_title_zh_all_3\", \"top\": 580, \"left\": 600, \"width\": 110, \"height\": 31 }";
                jsonString += ", {\"type\": \"right_right\", \"tag\": 4, \"title\": \"main_menu_title_zh_all_4\", \"top\": 655, \"left\": 720, \"width\": 140, \"height\": 31 }";
            } else if (Helper.Language == "en") {
                jsonString += "{\"type\": \"left\", \"tag\": 0, \"title\": \"main_menu_title_en_all_0\", \"top\": 430, \"left\": 120, \"width\": 214, \"height\": 31 }";
                jsonString += ", {\"type\": \"left\", \"tag\": 1, \"title\": \"main_menu_title_en_all_1\", \"top\": 5, \"left\": 705, \"width\": 152, \"height\": 31 }";
                jsonString += ", {\"type\": \"left\", \"tag\": 2, \"title\": \"main_menu_title_en_all_2\", \"top\": 690, \"left\": 365, \"width\": 231, \"height\": 31 }";
                jsonString += ", {\"type\": \"left\", \"tag\": 3, \"title\": \"main_menu_title_en_all_3\", \"top\": 580, \"left\": 600, \"width\": 152, \"height\": 31 }";
                jsonString += ", {\"type\": \"right_right\", \"tag\": 4, \"title\": \"main_menu_title_en_all_4\", \"top\": 655, \"left\": 720, \"width\": 276, \"height\": 31 }";
            }
        } else if(Helper.Version == "cut") {
                if (Helper.Language == "zh") {
                    jsonString += "{\"type\": \"left\", \"tag\": 0, \"title\": \"main_menu_title_zh_cut_0\", \"top\": 750, \"left\": 190, \"width\": 140, \"height\": 31 }";
                    jsonString += ", {\"type\": \"left\", \"tag\": 1, \"title\": \"main_menu_title_zh_cut_1\", \"top\": 615, \"left\": 485, \"width\": 120, \"height\": 31 }";
                } else if (Helper.Language == "en") {
                    jsonString += "{\"type\": \"left\", \"tag\": 0, \"title\": \"main_menu_title_en_cut_0\", \"top\": 750, \"left\": 190, \"width\": 222, \"height\": 31 }";
                    jsonString += ", {\"type\": \"left\", \"tag\": 1, \"title\": \"main_menu_title_en_cut_1\", \"top\": 615, \"left\": 485, \"width\": 166, \"height\": 31 }";
                }
        }
        jsonString += "]";

        System.out.println(jsonString);

        JSONArray jsonArray = JSON.parseArray(jsonString);

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            MenuView menuView = new MenuView(myContext, jsonObject.get("type").toString(), jsonObject.get("title").toString(), (int) jsonObject.get("width"), (int) jsonObject.get("height"));
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

    private void initLogo() {
        ImageView logoImageView = new ImageView(myContext);
        logoImageView.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("logo_" + Helper.Language, "mipmap", Helper.defPackage)));

        RelativeLayout.LayoutParams logoImageViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        logoImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        logoImageViewLayoutParams.topMargin = Helper.formatPix(myContext, 30);
        logoImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        logoImageViewLayoutParams.leftMargin = Helper.formatPix(myContext, 30);
        logoImageViewLayoutParams.width = Helper.formatPix(myContext, 227);
        logoImageViewLayoutParams.height = Helper.formatPix(myContext, 100);
        contentRelativeLayout.addView(logoImageView, logoImageViewLayoutParams);
    }

    private void initHomeButton() {
        homeImageView = new ImageView(myContext);
        homeImageView.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("home_button_" + Helper.Language, "mipmap", Helper.defPackage)));
        homeImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickHomeButtonListener != null) {
                    onClickHomeButtonListener.OnClick();
                }
            }
        });

        RelativeLayout.LayoutParams homeImageViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        homeImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        homeImageViewLayoutParams.bottomMargin = Helper.formatPix(myContext, 30);
        homeImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        if (Helper.Version == "cut") {
            homeImageViewLayoutParams.rightMargin = Helper.formatPix(myContext, 30 + 76 + 30);
        } else {
            homeImageViewLayoutParams.rightMargin = Helper.formatPix(myContext, 30 + 76 + 30 + 76 + 30);
        }
        homeImageViewLayoutParams.width = Helper.formatPix(myContext, (float)(76 * 1.2));
        homeImageViewLayoutParams.height = Helper.formatPix(myContext, (float)(76 * 1.2));
        contentRelativeLayout.addView(homeImageView, homeImageViewLayoutParams);
    }

    private void initVideoButton() {
        videoImageView = new ImageView(myContext);
        videoImageView.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("video_button_" + Helper.Language, "mipmap", Helper.defPackage)));
        videoImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickVideoButtonListener != null) {
                    onClickVideoButtonListener.OnClick();
                }
            }
        });

        RelativeLayout.LayoutParams videoImageViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        videoImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        videoImageViewLayoutParams.bottomMargin = Helper.formatPix(myContext, 30);
        videoImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        videoImageViewLayoutParams.rightMargin = Helper.formatPix(myContext, 30 + 76 + 30);
        videoImageViewLayoutParams.width = Helper.formatPix(myContext, (float)(76 * 1.2));
        videoImageViewLayoutParams.height = Helper.formatPix(myContext, (float)(76 * 1.2));
        contentRelativeLayout.addView(videoImageView, videoImageViewLayoutParams);
    }

    private void initQuitButton() {
        quitImageView = new ImageView(myContext);
        quitImageView.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("quit_button_" + Helper.Language, "mipmap", Helper.defPackage)));
        quitImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickQuitButtonListener != null) {
                    onClickQuitButtonListener.OnClick();
                }
            }
        });

        RelativeLayout.LayoutParams quitImageViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        quitImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        quitImageViewLayoutParams.bottomMargin = Helper.formatPix(myContext, 30);
        quitImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        quitImageViewLayoutParams.rightMargin = Helper.formatPix(myContext, 30);
        quitImageViewLayoutParams.width = Helper.formatPix(myContext, (float)(76 * 1.2));
        quitImageViewLayoutParams.height = Helper.formatPix(myContext, (float)(76 * 1.2));
        contentRelativeLayout.addView(quitImageView, quitImageViewLayoutParams);


    }

    public void show() {
        for(int i = 0; i < contentRelativeLayout.getChildCount(); i++) {
            View view = contentRelativeLayout.getChildAt(i);
            if(view instanceof MenuView) {
                AlphaAnimation alphaAnim = new AlphaAnimation(0.0f, 1.0f);
                alphaAnim.setDuration(1000);
                alphaAnim.setRepeatCount(0);
                view.startAnimation(alphaAnim);
            }
        }
    }

    public void hide() {

    }

}
