package com.nowui.crrc.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.nowui.crrc.R;
import com.nowui.crrc.utility.Helper;

public class StartView extends RelativeLayout {

    private Context myContext;
    private RelativeLayout contentRelativeLayout;

    private OnClickStartButtonListener onClickStartButtonListener;

    public interface OnClickStartButtonListener {
        public void OnClick();
    }

    public void setOnClickStartButtonListener(OnClickStartButtonListener listener) {
        onClickStartButtonListener = listener;
    }

    public StartView(Context context) {
        super(context);

        myContext = context;

        initView(context);
    }

    public StartView(Context context, AttributeSet attrs) {
        super(context, attrs);

        myContext = context;

        initView(context);
    }

    public StartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        myContext = context;

        initView(context);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    private void initView(Context context) {
        View.inflate(context, R.layout.view_start, this);

        contentRelativeLayout = new RelativeLayout(myContext);
        contentRelativeLayout.setClickable(true);
        contentRelativeLayout.setFocusable(true);

        RelativeLayout.LayoutParams contentRelativeLayoutParams = new RelativeLayout.LayoutParams(Helper.Width, Helper.Height);
        contentRelativeLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        contentRelativeLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        contentRelativeLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        this.addView(contentRelativeLayout, contentRelativeLayoutParams);

        ImageView backgroundImageView = new ImageView(context);
        backgroundImageView.setImageDrawable(getResources().getDrawable(R.mipmap.start_background));

        RelativeLayout.LayoutParams backgroundImageViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        backgroundImageViewLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        backgroundImageViewLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        backgroundImageViewLayoutParams.width = Helper.formatPix(myContext, 1920);
        backgroundImageViewLayoutParams.height = Helper.formatPix(myContext, 1080);
        contentRelativeLayout.addView(backgroundImageView, backgroundImageViewLayoutParams);

        RelativeLayout logoRelativeLayout = new RelativeLayout(myContext);

        RelativeLayout.LayoutParams logoRelativeLayoutParams = new RelativeLayout.LayoutParams(Helper.formatPix(myContext, 504), Helper.formatPix(myContext, 197));
        logoRelativeLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        logoRelativeLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        logoRelativeLayoutParams.topMargin = Helper.formatPix(myContext, 400);
        contentRelativeLayout.addView(logoRelativeLayout, logoRelativeLayoutParams);

        ImageView startLogoBackgroundImageView = new ImageView(context);
        startLogoBackgroundImageView.setImageDrawable(getResources().getDrawable(R.mipmap.start_logo_background));

        RelativeLayout.LayoutParams startLogoBackgroundImageViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        startLogoBackgroundImageViewLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        startLogoBackgroundImageViewLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        startLogoBackgroundImageViewLayoutParams.width = Helper.formatPix(myContext, 504);
        startLogoBackgroundImageViewLayoutParams.height = Helper.formatPix(myContext, 197);
        logoRelativeLayout.addView(startLogoBackgroundImageView, startLogoBackgroundImageViewLayoutParams);

        ImageView startLogoImageView = new ImageView(context);
        startLogoImageView.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("start_logo_" + Helper.Language, "mipmap", Helper.defPackage)));

        RelativeLayout.LayoutParams startLogoImageViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        startLogoImageViewLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        startLogoImageViewLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        startLogoImageViewLayoutParams.width = Helper.formatPix(myContext, 328);
        startLogoImageViewLayoutParams.height = Helper.formatPix(myContext, 109);
        logoRelativeLayout.addView(startLogoImageView, startLogoImageViewLayoutParams);

        ImageView startImageView = new ImageView(context);
        startImageView.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("start_button", "mipmap", Helper.defPackage)));
        startImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickStartButtonListener != null) {
                    onClickStartButtonListener.OnClick();
                }
            }
        });

        RelativeLayout.LayoutParams startImageViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        startImageViewLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        startImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        startImageViewLayoutParams.topMargin = Helper.formatPix(myContext, 640);
        startImageViewLayoutParams.width = Helper.formatPix(myContext, 117);
        startImageViewLayoutParams.height = Helper.formatPix(myContext, 104);
        contentRelativeLayout.addView(startImageView, startImageViewLayoutParams);
    }

}
