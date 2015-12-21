package com.nowui.crrc.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.nowui.crrc.R;
import com.nowui.crrc.utility.Helper;

public class DetailView extends RelativeLayout {

    private Context myContext;
    private RelativeLayout contentRelativeLayout;
    private int tag;
    private int parent;
    private int selectInt = -1;
    private ImageButton tab0ImageButton;
    private ImageButton tab1ImageButton;
    private ImageButton tab2ImageButton;
    private ScrollView introductionScrollView;

    private OnClickDetailViewCloseButtonListener onClickDetailViewCloseButtonListener;

    public interface OnClickDetailViewCloseButtonListener {
        public void OnClick();
    }

    public void setOnClickDetailViewCloseButtonListener(OnClickDetailViewCloseButtonListener listener) {
        onClickDetailViewCloseButtonListener = listener;
    }

    public DetailView(Context context, int position, int parent) {
        super(context);

        myContext = context;
        this.parent = parent;

        tag = position;

        initView(context);
    }

    public DetailView(Context context, AttributeSet attrs) {
        super(context, attrs);

        myContext = context;

        initView(context);
    }

    public DetailView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        myContext = context;

        initView(context);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    private void initView(Context context) {
        View.inflate(context, R.layout.view_detail, this);

        contentRelativeLayout = new RelativeLayout(myContext);

        RelativeLayout.LayoutParams contentRelativeLayoutParams = new RelativeLayout.LayoutParams(Helper.Width, Helper.Height);
        contentRelativeLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        contentRelativeLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        contentRelativeLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        this.addView(contentRelativeLayout, contentRelativeLayoutParams);

        initBackground();

        initContent();
    }

    private void initBackground() {
        ImageView backgroundImageView = new ImageView(myContext);
        backgroundImageView.setImageDrawable(getResources().getDrawable(R.mipmap.detail_background));

        RelativeLayout.LayoutParams backgroundImageViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        backgroundImageViewLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        backgroundImageViewLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        contentRelativeLayout.addView(backgroundImageView, backgroundImageViewLayoutParams);
    }

    private void initContent() {
        ImageView titleImageView = new ImageView(myContext);
        titleImageView.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("detail_title_" + Helper.Language + "_" + Helper.Version + "_" + parent + "_" + tag, "mipmap", "com.nowui.crrc")));

        RelativeLayout.LayoutParams titleImageViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        titleImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        titleImageViewLayoutParams.topMargin = Helper.formatPix(myContext, 255);
        titleImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        titleImageViewLayoutParams.leftMargin = Helper.formatPix(myContext, 160);
        contentRelativeLayout.addView(titleImageView, titleImageViewLayoutParams);

        RelativeLayout pictureContentRelativeLayout = new RelativeLayout(myContext);

        RelativeLayout.LayoutParams pictureContentRelativeLayoutLayoutParams = new RelativeLayout.LayoutParams(Helper.formatPix(myContext, 750), Helper.formatPix(myContext, 535));
        pictureContentRelativeLayoutLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        pictureContentRelativeLayoutLayoutParams.topMargin = Helper.formatPix(myContext, 267);
        pictureContentRelativeLayoutLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        pictureContentRelativeLayoutLayoutParams.leftMargin = Helper.formatPix(myContext, 958);
        contentRelativeLayout.addView(pictureContentRelativeLayout, pictureContentRelativeLayoutLayoutParams);

        ImageView pictureImageView = new ImageView(myContext);
        pictureImageView.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("detail_picture_" + Helper.Language + "_" + Helper.Version + "_" + parent + "_" + tag, "mipmap", "com.nowui.crrc")));

        RelativeLayout.LayoutParams pictureImageViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        pictureImageViewLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        pictureImageViewLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        pictureContentRelativeLayout.addView(pictureImageView, pictureImageViewLayoutParams);

        tab0ImageButton = new ImageButton(myContext);
        tab0ImageButton.getBackground().setAlpha(0);
        tab0ImageButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                checkTabImageButton(0);
            }
        });

        RelativeLayout.LayoutParams tab0ImageButtonLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        tab0ImageButtonLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        tab0ImageButtonLayoutParams.topMargin = Helper.formatPix(myContext, 800);
        tab0ImageButtonLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        tab0ImageButtonLayoutParams.leftMargin = Helper.formatPix(myContext, 200);
        contentRelativeLayout.addView(tab0ImageButton, tab0ImageButtonLayoutParams);

        tab1ImageButton = new ImageButton(myContext);
        tab1ImageButton.getBackground().setAlpha(0);
        tab1ImageButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                checkTabImageButton(1);
            }
        });

        RelativeLayout.LayoutParams tab1ImageButtonLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        tab1ImageButtonLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        tab1ImageButtonLayoutParams.topMargin = Helper.formatPix(myContext, 800);
        tab1ImageButtonLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        tab1ImageButtonLayoutParams.leftMargin = Helper.formatPix(myContext, 320);
        contentRelativeLayout.addView(tab1ImageButton, tab1ImageButtonLayoutParams);

        tab2ImageButton = new ImageButton(myContext);
        tab2ImageButton.getBackground().setAlpha(0);
        tab2ImageButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                checkTabImageButton(2);
            }
        });

        RelativeLayout.LayoutParams tab2ImageButtonLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        tab2ImageButtonLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        tab2ImageButtonLayoutParams.topMargin = Helper.formatPix(myContext, 800);
        tab2ImageButtonLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        tab2ImageButtonLayoutParams.leftMargin = Helper.formatPix(myContext, 440);
        contentRelativeLayout.addView(tab2ImageButton, tab2ImageButtonLayoutParams);

        introductionScrollView = new ScrollView(myContext);

        RelativeLayout.LayoutParams introductionScrollViewLayoutParams = new RelativeLayout.LayoutParams(Helper.formatPix(myContext, 700), Helper.formatPix(myContext, 370));
        introductionScrollViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        introductionScrollViewLayoutParams.topMargin = Helper.formatPix(myContext, 405);
        introductionScrollViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        introductionScrollViewLayoutParams.leftMargin = Helper.formatPix(myContext, 183);
        contentRelativeLayout.addView(introductionScrollView, introductionScrollViewLayoutParams);

        ImageButton closeImageButton = new ImageButton(myContext);
        closeImageButton.setImageDrawable(getResources().getDrawable(R.mipmap.close_button));
        closeImageButton.getBackground().setAlpha(0);
        closeImageButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickDetailViewCloseButtonListener != null) {
                    onClickDetailViewCloseButtonListener.OnClick();
                }
            }
        });

        RelativeLayout.LayoutParams closeImageButtonLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        closeImageButtonLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        closeImageButtonLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        closeImageButtonLayoutParams.bottomMargin = Helper.formatPix(myContext, 42);
        contentRelativeLayout.addView(closeImageButton, closeImageButtonLayoutParams);

        checkTabImageButton(0);
    }

    private void checkTabImageButton(int position) {
        if(selectInt == position) {
            return;
        }

        selectInt = position;

        if(selectInt == 0) {
            tab0ImageButton.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("detail_tab_" + Helper.Language + "_0_active", "mipmap", "com.nowui.crrc")));

            tab1ImageButton.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("detail_tab_" + Helper.Language + "_1", "mipmap", "com.nowui.crrc")));

            tab2ImageButton.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("detail_tab_" + Helper.Language + "_2", "mipmap", "com.nowui.crrc")));
        } else if(selectInt == 1) {
            tab0ImageButton.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("detail_tab_" + Helper.Language + "_0", "mipmap", "com.nowui.crrc")));

            tab1ImageButton.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("detail_tab_" + Helper.Language + "_1_active", "mipmap", "com.nowui.crrc")));

            tab2ImageButton.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("detail_tab_" + Helper.Language + "_2", "mipmap", "com.nowui.crrc")));
        } else if(selectInt == 2) {
            tab0ImageButton.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("detail_tab_" + Helper.Language + "_0", "mipmap", "com.nowui.crrc")));

            tab1ImageButton.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("detail_tab_" + Helper.Language + "_1", "mipmap", "com.nowui.crrc")));

            tab2ImageButton.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("detail_tab_" + Helper.Language + "_2_active", "mipmap", "com.nowui.crrc")));
        }

        checkIntroductionScrollView(position);
    }

    private void checkIntroductionScrollView(int position) {
        introductionScrollView.removeAllViews();

        ImageView introductionImageView = new ImageView(myContext);
        introductionImageView.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("detail_introduction_" + Helper.Language + "_" + Helper.Version + "_" + parent + "_" + tag + "_" + position, "mipmap", "com.nowui.crrc")));

        introductionScrollView.addView(introductionImageView);
    }

}
