package com.nowui.crrc.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nowui.crrc.R;
import com.nowui.crrc.utility.Helper;

public class MenuView extends RelativeLayout {

    private Context myContext;
    private String typeString;
    private String titleString;

    private OnClickMenuViewListener onClickMenuViewListener;

    public interface OnClickMenuViewListener {
        public void OnClick(int position);
    }

    public void setOnClickMenuViewListener(OnClickMenuViewListener listener) {
        onClickMenuViewListener = listener;
    }

    public MenuView(Context context, String type, String title) {
        super(context);

        myContext = context;

        typeString = type;

        titleString = title;

        initView(context);
    }

    public MenuView(Context context, AttributeSet attrs) {
        super(context, attrs);

        myContext = context;

        initView(context);
    }

    public MenuView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        myContext = context;

        initView(context);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    private void initView(Context context) {
        View.inflate(context, R.layout.view_menu, this);

        initBottom();

        initTitle();

        initLocation();
    }

    private void initBottom() {
        ImageView bottomImageView = new ImageView(myContext);
        bottomImageView.setImageDrawable(getResources().getDrawable(R.mipmap.menu_bottom));

        RelativeLayout.LayoutParams bottomImageViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        if(typeString.equals("bottom")) {
            bottomImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            bottomImageViewLayoutParams.bottomMargin = Helper.formatPix(myContext, 55);
        } else {
            bottomImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            bottomImageViewLayoutParams.topMargin = Helper.formatPix(myContext, 55);
        }
        if(typeString.equals("left")) {
            bottomImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            bottomImageViewLayoutParams.leftMargin = Helper.formatPix(myContext, -5);
        } else if(typeString.equals("right")) {
            bottomImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            bottomImageViewLayoutParams.rightMargin = Helper.formatPix(myContext, -5);
        } else if(typeString.equals("bottom")) {
            bottomImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            bottomImageViewLayoutParams.leftMargin = Helper.formatPix(myContext, -3);
        }
        this.addView(bottomImageView, bottomImageViewLayoutParams);

        AnimationSet set = new AnimationSet(true);

        ScaleAnimation scaleAnimation = new ScaleAnimation(0.5f, 1.0f, 0.5f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(1000);
        scaleAnimation.setRepeatCount(Animation.INFINITE);
        scaleAnimation.setRepeatMode(Animation.RESTART);
        set.addAnimation(scaleAnimation);

        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(1000);
        alphaAnimation.setRepeatCount(Animation.INFINITE);
        alphaAnimation.setRepeatMode(Animation.RESTART);
        set.addAnimation(alphaAnimation);

        bottomImageView.startAnimation(set);
        set.start();
    }

    private void initTitle() {
        ImageButton titleImageButton = new ImageButton(myContext);
        titleImageButton.setImageDrawable(getResources().getDrawable(getResources().getIdentifier(titleString, "mipmap", "com.nowui.crrc")));
        titleImageButton.getBackground().setAlpha(0);
        titleImageButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickMenuViewListener != null) {
                    onClickMenuViewListener.OnClick((int) getTag());
                }
            }
        });

        RelativeLayout.LayoutParams titleImageButtonLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        if(typeString.equals("bottom")) {
            titleImageButtonLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            titleImageButtonLayoutParams.topMargin = Helper.formatPix(myContext, 25);
        } else {
            titleImageButtonLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            titleImageButtonLayoutParams.bottomMargin = Helper.formatPix(myContext, 20);
        }
        if(typeString.equals("left")) {
            titleImageButtonLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            titleImageButtonLayoutParams.leftMargin = Helper.formatPix(myContext, 10);
        } else if(typeString.equals("right")) {
            titleImageButtonLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            titleImageButtonLayoutParams.rightMargin = Helper.formatPix(myContext, 10);
        } else if(typeString.equals("bottom")) {
            titleImageButtonLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            titleImageButtonLayoutParams.leftMargin = Helper.formatPix(myContext, 10);
        }
        this.addView(titleImageButton, titleImageButtonLayoutParams);
    }

    private void initLocation() {
        ImageButton locationImageButton = new ImageButton(myContext);
        locationImageButton.setImageDrawable(getResources().getDrawable(R.mipmap.menu_location_top));
        if(typeString.equals("bottom")) {
            locationImageButton.setImageDrawable(getResources().getDrawable(R.mipmap.menu_location_bottom));
        }
        locationImageButton.getBackground().setAlpha(0);
        locationImageButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickMenuViewListener != null) {
                    onClickMenuViewListener.OnClick((int) getTag());
                }
            }
        });

        RelativeLayout.LayoutParams locationImageViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        if(typeString.equals("bottom")) {
            locationImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            locationImageViewLayoutParams.topMargin = Helper.formatPix(myContext, 20);
        } else {
            locationImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            locationImageViewLayoutParams.bottomMargin = Helper.formatPix(myContext, 25);
        }
        if(typeString.equals("left")) {
            locationImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            locationImageViewLayoutParams.leftMargin = Helper.formatPix(myContext, -17);
        } else if(typeString.equals("right")) {
            locationImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            locationImageViewLayoutParams.rightMargin = Helper.formatPix(myContext, -17);
        } else if(typeString.equals("bottom")) {
            locationImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            locationImageViewLayoutParams.leftMargin = Helper.formatPix(myContext, -17);
        }
        this.addView(locationImageButton, locationImageViewLayoutParams);

        AnimationSet set = new AnimationSet(true);

        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, 0, Helper.formatPix(myContext, 10));
        translateAnimation.setDuration(500);
        translateAnimation.setRepeatCount(Animation.INFINITE);
        translateAnimation.setRepeatMode(Animation.REVERSE);
        set.addAnimation(translateAnimation);

        locationImageButton.startAnimation(set);
        set.start();
    }

}
