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
import android.widget.ImageView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nowui.crrc.R;
import com.nowui.crrc.utility.Helper;

public class MenuView extends RelativeLayout {

    private Context myContext;
    private String typeString;
    private String titleString;
    private int widthInt;
    private int heightInt;

    private OnClickMenuViewListener onClickMenuViewListener;
    private ImageView titleImageView;

    public interface OnClickMenuViewListener {
        public void OnClick(int position);
    }

    public void setOnClickMenuViewListener(OnClickMenuViewListener listener) {
        onClickMenuViewListener = listener;
    }

    public MenuView(Context context, String type, String title, int width, int height) {
        super(context);

        myContext = context;

        typeString = type;

        titleString = title;

        widthInt = width;

        heightInt = height;

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

        //this.setBackgroundColor(Color.parseColor("#ff0000"));

        initBottom();

        initTitle();

        initLocation();
    }

    private void initBottom() {
        ImageView bottomImageView = new ImageView(myContext);
        bottomImageView.setImageDrawable(getResources().getDrawable(R.mipmap.menu_bottom));
        if(typeString.equals("right_right")) {
            bottomImageView.setImageDrawable(getResources().getDrawable(R.mipmap.menu_bottom_right));
        }

        RelativeLayout.LayoutParams bottomImageViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        if(typeString.equals("bottom")) {
            bottomImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            bottomImageViewLayoutParams.topMargin = Helper.formatPix(myContext, 0);
        } else if(typeString.equals("right_right")) {
            bottomImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            bottomImageViewLayoutParams.topMargin = Helper.formatPix(myContext, 0);
        } else {
            bottomImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            bottomImageViewLayoutParams.topMargin = Helper.formatPix(myContext, 40);
        }

        if(typeString.equals("left")) {
            bottomImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            bottomImageViewLayoutParams.leftMargin = Helper.formatPix(myContext, 0);
        } else if(typeString.equals("right")) {
            bottomImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            bottomImageViewLayoutParams.rightMargin = Helper.formatPix(myContext, 0);
        } else if(typeString.equals("bottom")) {
            bottomImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            bottomImageViewLayoutParams.leftMargin = Helper.formatPix(myContext, 14);
        }

        bottomImageViewLayoutParams.width = Helper.formatPix(myContext, 90);
        bottomImageViewLayoutParams.height = Helper.formatPix(myContext, 61);
        if(typeString.equals("right_right")) {
            bottomImageViewLayoutParams.width = Helper.formatPix(myContext, 61);
            bottomImageViewLayoutParams.height = Helper.formatPix(myContext, 90);
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
        ImageView titleImageView = new ImageView(myContext);
        titleImageView.setImageDrawable(getResources().getDrawable(getResources().getIdentifier(titleString, "mipmap", Helper.defPackage)));
        titleImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickMenuViewListener != null) {
                    onClickMenuViewListener.OnClick((int) getTag());
                }
            }
        });

        RelativeLayout.LayoutParams titleImageViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        if(typeString.equals("bottom")) {
            titleImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            titleImageViewLayoutParams.topMargin = Helper.formatPix(myContext, 55);
        } else if(typeString.equals("right_right")) {
            titleImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            titleImageViewLayoutParams.topMargin = Helper.formatPix(myContext, 28);
        } else {
            titleImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            titleImageViewLayoutParams.topMargin = Helper.formatPix(myContext, 15);
        }

        if(typeString.equals("left")) {
            titleImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            titleImageViewLayoutParams.leftMargin = Helper.formatPix(myContext, 52);
        } else if(typeString.equals("right")) {
            titleImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            titleImageViewLayoutParams.rightMargin = Helper.formatPix(myContext, 52);
        } else if(typeString.equals("bottom")) {
            titleImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            titleImageViewLayoutParams.leftMargin = Helper.formatPix(myContext, 62);
        } else if(typeString.equals("right_right")) {
            titleImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            titleImageViewLayoutParams.leftMargin = Helper.formatPix(myContext, 70);
        }

        titleImageViewLayoutParams.width = Helper.formatPix(myContext, widthInt);
        titleImageViewLayoutParams.height = Helper.formatPix(myContext, heightInt);

        this.addView(titleImageView, titleImageViewLayoutParams);
    }

    private void initLocation() {
        ImageView locationImageView = new ImageView(myContext);
        if(typeString.equals("bottom")) {
            locationImageView.setImageDrawable(getResources().getDrawable(R.mipmap.menu_location_bottom));
        } else if(typeString.equals("right_right")) {
            locationImageView.setImageDrawable(getResources().getDrawable(R.mipmap.menu_location_right));
        } else {
            locationImageView.setImageDrawable(getResources().getDrawable(R.mipmap.menu_location_top));
        }
        locationImageView.setOnClickListener(new OnClickListener() {
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
            locationImageViewLayoutParams.topMargin = Helper.formatPix(myContext, 33);
        } else if(typeString.equals("right_right")) {
            locationImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            locationImageViewLayoutParams.topMargin = Helper.formatPix(myContext, 22);
        } else {
            locationImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            locationImageViewLayoutParams.topMargin = Helper.formatPix(myContext, 0);
        }

        if(typeString.equals("left")) {
            locationImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            locationImageViewLayoutParams.leftMargin = Helper.formatPix(myContext, 22);
        } else if(typeString.equals("right")) {
            locationImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            locationImageViewLayoutParams.rightMargin = Helper.formatPix(myContext, 22);
        } else if(typeString.equals("bottom")) {
            locationImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            locationImageViewLayoutParams.leftMargin = Helper.formatPix(myContext, 37);
        } else if(typeString.equals("right_right")) {
            locationImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            locationImageViewLayoutParams.leftMargin = Helper.formatPix(myContext, 35);
        }

        if(typeString.equals("bottom")) {
            locationImageViewLayoutParams.width = Helper.formatPix(myContext, 44);
            locationImageViewLayoutParams.height = Helper.formatPix(myContext, 57);
        } else if(typeString.equals("right_right")) {
            locationImageViewLayoutParams.width = Helper.formatPix(myContext, 57);
            locationImageViewLayoutParams.height = Helper.formatPix(myContext, 44);
        } else {
            locationImageViewLayoutParams.width = Helper.formatPix(myContext, 44);
            locationImageViewLayoutParams.height = Helper.formatPix(myContext, 57);
        }

        this.addView(locationImageView, locationImageViewLayoutParams);

        AnimationSet set = new AnimationSet(true);

        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, 0, Helper.formatPix(myContext, 10));
        if(typeString.equals("right_right")) {
            translateAnimation = new TranslateAnimation(0, Helper.formatPix(myContext, 10), 0, 0);
        }
        translateAnimation.setDuration(500);
        translateAnimation.setRepeatCount(Animation.INFINITE);
        translateAnimation.setRepeatMode(Animation.REVERSE);
        set.addAnimation(translateAnimation);

        locationImageView.startAnimation(set);
        set.start();
    }

}
