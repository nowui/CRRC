package com.nowui.crrc.view;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextPaint;
import android.text.method.ScrollingMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.nowui.crrc.R;
import com.nowui.crrc.utility.Helper;

public class DetailView extends RelativeLayout {

    private Context myContext;
    private int tag;
    private int parent;
    private int selectInt = -1;
    private ImageButton tab00ImageButton;
    private ImageButton tab01ImageButton;
    private ImageButton tab02ImageButton;
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

        initBackground();

        initContent();
    }

    private void initBackground() {
        ImageView backgroundImageView = new ImageView(myContext);
        backgroundImageView.setImageDrawable(getResources().getDrawable(R.mipmap.detail_background));
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
        titleImageView.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("detail_title_" + parent + "_" + tag, "mipmap", "com.nowui.crrc")));

        RelativeLayout.LayoutParams titleImageViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        titleImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        titleImageViewLayoutParams.topMargin = Helper.dip2px(myContext, 86);
        titleImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        titleImageViewLayoutParams.leftMargin = Helper.dip2px(myContext, 52);
        contentRelativeLayout.addView(titleImageView, titleImageViewLayoutParams);

        RelativeLayout pictureContentRelativeLayout = new RelativeLayout(myContext);

        RelativeLayout.LayoutParams pictureContentRelativeLayoutLayoutParams = new RelativeLayout.LayoutParams(Helper.dip2px(myContext, 260), Helper.dip2px(myContext, 180));
        pictureContentRelativeLayoutLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        pictureContentRelativeLayoutLayoutParams.topMargin = Helper.dip2px(myContext, 88);
        pictureContentRelativeLayoutLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        pictureContentRelativeLayoutLayoutParams.leftMargin = Helper.dip2px(myContext, 315);
        contentRelativeLayout.addView(pictureContentRelativeLayout, pictureContentRelativeLayoutLayoutParams);

        ImageView pictureImageView = new ImageView(myContext);
        pictureImageView.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("detail_picture_" + parent + "_" + tag, "mipmap", "com.nowui.crrc")));
        pictureImageView.setScaleType(ImageView.ScaleType.CENTER);

        RelativeLayout.LayoutParams pictureImageViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        pictureImageViewLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        pictureImageViewLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        pictureContentRelativeLayout.addView(pictureImageView, pictureImageViewLayoutParams);

        tab00ImageButton = new ImageButton(myContext);
        tab00ImageButton.setImageDrawable(getResources().getDrawable(R.mipmap.detail_tab_00));
        tab00ImageButton.getBackground().setAlpha(0);
        tab00ImageButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                checkTabImageButton(0);
            }
        });

        RelativeLayout.LayoutParams tab00ImageButtonLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        tab00ImageButtonLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        tab00ImageButtonLayoutParams.topMargin = Helper.dip2px(myContext, 270);
        tab00ImageButtonLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        tab00ImageButtonLayoutParams.leftMargin = Helper.dip2px(myContext, 52);
        contentRelativeLayout.addView(tab00ImageButton, tab00ImageButtonLayoutParams);

        tab01ImageButton = new ImageButton(myContext);
        tab01ImageButton.setImageDrawable(getResources().getDrawable(R.mipmap.detail_tab_01));
        tab01ImageButton.getBackground().setAlpha(0);
        tab01ImageButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                checkTabImageButton(1);
            }
        });

        RelativeLayout.LayoutParams tab01ImageButtonLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        tab01ImageButtonLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        tab01ImageButtonLayoutParams.topMargin = Helper.dip2px(myContext, 270);
        tab01ImageButtonLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        tab01ImageButtonLayoutParams.leftMargin = Helper.dip2px(myContext, 92);
        contentRelativeLayout.addView(tab01ImageButton, tab01ImageButtonLayoutParams);

        tab02ImageButton = new ImageButton(myContext);
        tab02ImageButton.setImageDrawable(getResources().getDrawable(R.mipmap.detail_tab_02));
        tab02ImageButton.getBackground().setAlpha(0);
        tab02ImageButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                checkTabImageButton(2);
            }
        });

        RelativeLayout.LayoutParams tab02ImageButtonLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        tab02ImageButtonLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        tab02ImageButtonLayoutParams.topMargin = Helper.dip2px(myContext, 270);
        tab02ImageButtonLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        tab02ImageButtonLayoutParams.leftMargin = Helper.dip2px(myContext, 132);
        contentRelativeLayout.addView(tab02ImageButton, tab02ImageButtonLayoutParams);

        introductionScrollView = new ScrollView(myContext);

        RelativeLayout.LayoutParams introductionScrollViewLayoutParams = new RelativeLayout.LayoutParams(Helper.dip2px(myContext, 250), Helper.dip2px(myContext, 130));
        introductionScrollViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        introductionScrollViewLayoutParams.topMargin = Helper.dip2px(myContext, 125);
        introductionScrollViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        introductionScrollViewLayoutParams.leftMargin = Helper.dip2px(myContext, 55);
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
        closeImageButtonLayoutParams.bottomMargin = Helper.dip2px(myContext, 12);
        contentRelativeLayout.addView(closeImageButton, closeImageButtonLayoutParams);

        checkTabImageButton(0);
    }

    private void checkTabImageButton(int position) {
        if(selectInt == position) {
            return;
        }

        selectInt = position;

        if(selectInt == 0) {
            tab00ImageButton.setImageDrawable(getResources().getDrawable(R.mipmap.detail_tab_00_active));

            tab01ImageButton.setImageDrawable(getResources().getDrawable(R.mipmap.detail_tab_01));

            tab02ImageButton.setImageDrawable(getResources().getDrawable(R.mipmap.detail_tab_02));
        } else if(selectInt == 1) {
            tab00ImageButton.setImageDrawable(getResources().getDrawable(R.mipmap.detail_tab_00));

            tab01ImageButton.setImageDrawable(getResources().getDrawable(R.mipmap.detail_tab_01_active));

            tab02ImageButton.setImageDrawable(getResources().getDrawable(R.mipmap.detail_tab_02));
        } else if(selectInt == 2) {
            tab00ImageButton.setImageDrawable(getResources().getDrawable(R.mipmap.detail_tab_00));

            tab01ImageButton.setImageDrawable(getResources().getDrawable(R.mipmap.detail_tab_01));

            tab02ImageButton.setImageDrawable(getResources().getDrawable(R.mipmap.detail_tab_02_active));
        }

        checkIntroductionScrollView(position);
    }

    private void checkIntroductionScrollView(int position) {
        introductionScrollView.removeAllViews();

        ImageView introductionImageView = new ImageView(myContext);
        introductionImageView.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("detail_introduction_" + parent + "_" + tag + "_" + position, "mipmap", "com.nowui.crrc")));
        introductionImageView.setScaleType(ImageView.ScaleType.CENTER);

        introductionScrollView.addView(introductionImageView);
    }

}
