package com.nowui.crrc.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.nowui.crrc.R;
import com.nowui.crrc.utility.Helper;

import java.util.ArrayList;
import java.util.List;

public class AlertView extends RelativeLayout {

    private Context myContext;
    private RelativeLayout contentRelativeLayout;
    private int tag;
    private int pagerTag;
    private int parent;
    private int selectInt = -1;
    private ImageView titleImageView;
    private RelativeLayout tabContentRelativeLayout;
    private ScrollView introductionScrollView;

    private OnClickAlertViewCloseButtonListener onClickAlertViewCloseButtonListener;

    public interface OnClickAlertViewCloseButtonListener {
        public void OnClick();
    }

    public void setOnClickAlertViewCloseButtonListener(OnClickAlertViewCloseButtonListener listener) {
        onClickAlertViewCloseButtonListener = listener;
    }

    public AlertView(Context context, int tag, int parent, int position) {
        super(context);

        myContext = context;
        this.tag = tag;
        this.pagerTag = position;
        this.parent = parent;

        initView(context);
    }

    public AlertView(Context context, AttributeSet attrs) {
        super(context, attrs);

        myContext = context;

        initView(context);
    }

    public AlertView(Context context, AttributeSet attrs, int defStyleAttr) {
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
        contentRelativeLayout.setClickable(true);
        contentRelativeLayout.setFocusable(true);

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
        titleImageView = new ImageView(myContext);
        titleImageView.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("detail_title_" + Helper.Language + "_" + Helper.Version + "_" + parent + "_" + tag + "_" + pagerTag, "mipmap", Helper.defPackage)));

        RelativeLayout.LayoutParams titleImageViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        titleImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        titleImageViewLayoutParams.topMargin = Helper.formatPix(myContext, 255);
        titleImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        titleImageViewLayoutParams.leftMargin = Helper.formatPix(myContext, 160);
        contentRelativeLayout.addView(titleImageView, titleImageViewLayoutParams);

        RelativeLayout pictureContentRelativeLayout = new RelativeLayout(myContext);

        RelativeLayout.LayoutParams pictureContentRelativeLayoutParams = new RelativeLayout.LayoutParams(Helper.formatPix(myContext, 750), Helper.formatPix(myContext, 535));
        pictureContentRelativeLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        pictureContentRelativeLayoutParams.topMargin = Helper.formatPix(myContext, 267);
        pictureContentRelativeLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        pictureContentRelativeLayoutParams.leftMargin = Helper.formatPix(myContext, 958);
        contentRelativeLayout.addView(pictureContentRelativeLayout, pictureContentRelativeLayoutParams);

        ImageView pictureImageView = new ImageView(myContext);
        pictureImageView.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("detail_picture_" + Helper.Language + "_" + Helper.Version + "_" + parent + "_" + tag + "_" + pagerTag, "mipmap", Helper.defPackage)));

        RelativeLayout.LayoutParams pictureImageViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        pictureImageViewLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        pictureImageViewLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        pictureContentRelativeLayout.addView(pictureImageView, pictureImageViewLayoutParams);

        tabContentRelativeLayout = new RelativeLayout(myContext);

        RelativeLayout.LayoutParams tabContentRelativeLayoutParams = new RelativeLayout.LayoutParams(Helper.formatPix(myContext, 700), Helper.formatPix(myContext, 100));
        tabContentRelativeLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        tabContentRelativeLayoutParams.topMargin = Helper.formatPix(myContext, 800);
        tabContentRelativeLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        tabContentRelativeLayoutParams.leftMargin = Helper.formatPix(myContext, 200);
        contentRelativeLayout.addView(tabContentRelativeLayout, tabContentRelativeLayoutParams);

        int total = 3;

        if (Helper.Version == "all") {
            total = 4;
        }

        for(int i = 0; i < total; i++) {
            ImageButton tabImageButton = new ImageButton(myContext);
            tabImageButton.setTag(i);
            tabImageButton.getBackground().setAlpha(0);
            tabImageButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkTabImageButton((int) v.getTag());
                }
            });

            RelativeLayout.LayoutParams tabImageButtonLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            tabImageButtonLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            tabImageButtonLayoutParams.leftMargin = Helper.formatPix(myContext, 120 * i);
            tabContentRelativeLayout.addView(tabImageButton, tabImageButtonLayoutParams);
        }

        introductionScrollView = new ScrollView(myContext);

        RelativeLayout.LayoutParams introductionScrollViewLayoutParams = new RelativeLayout.LayoutParams(Helper.formatPix(myContext, 700), Helper.formatPix(myContext, 295));
        introductionScrollViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        introductionScrollViewLayoutParams.topMargin = Helper.formatPix(myContext, 420);
        introductionScrollViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        introductionScrollViewLayoutParams.leftMargin = Helper.formatPix(myContext, 183);
        contentRelativeLayout.addView(introductionScrollView, introductionScrollViewLayoutParams);

        ImageButton closeImageButton = new ImageButton(myContext);
        closeImageButton.setImageDrawable(getResources().getDrawable(R.mipmap.close_button));
        closeImageButton.getBackground().setAlpha(0);
        closeImageButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickAlertViewCloseButtonListener != null) {
                    onClickAlertViewCloseButtonListener.OnClick();
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

        if (selectInt == 0) {
            titleImageView.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("detail_title_" + Helper.Language + "_" + Helper.Version + "_" + parent + "_" + tag + "_" + pagerTag, "mipmap", Helper.defPackage)));
        } else {
            titleImageView.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("detail_title_" + Helper.Language + "_" + selectInt, "mipmap", Helper.defPackage)));
        }

        for(int i = 0; i < tabContentRelativeLayout.getChildCount(); i++) {
            View view = tabContentRelativeLayout.getChildAt(i);
            if(view instanceof ImageButton) {
                int temp = i;

                if (Helper.Version == "all" && parent == 2 && i == 0) {
                    temp = 10;
                }

                ((ImageButton)view).setImageDrawable(getResources().getDrawable(getResources().getIdentifier("detail_tab_" + Helper.Language + "_" + Helper.Version + "_" + temp + (selectInt == (int) view.getTag() ? "_active" : ""), "mipmap", Helper.defPackage)));
            }
        }

        checkIntroductionScrollView(position);
    }

    private void checkIntroductionScrollView(int position) {
        introductionScrollView.removeAllViews();

        ImageView introductionImageView = new ImageView(myContext);
        introductionImageView.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("detail_introduction_" + Helper.Language + "_" + Helper.Version + "_" + parent + "_" + tag + "_" + pagerTag + "_" + position, "mipmap", Helper.defPackage)));

        introductionScrollView.addView(introductionImageView);
    }

}
