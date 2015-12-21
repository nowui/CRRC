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

        RelativeLayout.LayoutParams contentRelativeLayoutParams = new RelativeLayout.LayoutParams(Helper.Width, Helper.Height);
        contentRelativeLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        contentRelativeLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        contentRelativeLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        this.addView(contentRelativeLayout, contentRelativeLayoutParams);

        ImageView backgroundImageView = new ImageView(context);
        backgroundImageView.setImageDrawable(getResources().getDrawable(R.mipmap.start_background));
        backgroundImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

        RelativeLayout.LayoutParams backgroundImageViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        backgroundImageViewLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        backgroundImageViewLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        contentRelativeLayout.addView(backgroundImageView, backgroundImageViewLayoutParams);

        ImageButton startImageButton = new ImageButton(context);
        startImageButton.setImageDrawable(getResources().getDrawable(R.mipmap.start_button));
        startImageButton.getBackground().setAlpha(0);
        startImageButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            if(onClickStartButtonListener != null) {
                onClickStartButtonListener.OnClick();
            }
            }
        });

        RelativeLayout.LayoutParams startImageButtonLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        startImageButtonLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        startImageButtonLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        startImageButtonLayoutParams.topMargin = Helper.formatPix(myContext, 210);
        contentRelativeLayout.addView(startImageButton, startImageButtonLayoutParams);
    }

}
