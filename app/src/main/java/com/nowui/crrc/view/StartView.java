package com.nowui.crrc.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.nowui.crrc.R;

public class StartView extends RelativeLayout {

    private Context myContext;

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

        ImageView backgroundImageView = new ImageView(context);
        backgroundImageView.setImageDrawable(getResources().getDrawable(R.mipmap.start_background));
        backgroundImageView.setScaleType(ImageView.ScaleType.CENTER);

        RelativeLayout.LayoutParams backgroundImageViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        backgroundImageViewLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        backgroundImageViewLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        this.addView(backgroundImageView, backgroundImageViewLayoutParams);

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
        startImageButtonLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        startImageButtonLayoutParams.bottomMargin = 300;
        this.addView(startImageButton, startImageButtonLayoutParams);
    }

}
