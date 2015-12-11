package com.nowui.crrc.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Environment;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.nowui.crrc.R;

import java.io.IOException;

public class VideoView extends RelativeLayout {

    private Context myContext;
    private SurfaceView surfaceView;
    private SurfaceHolder holder;
    private MediaPlayer mediaPlayer;
    private View maskView;
    private Handler handler = new Handler();

    private OnClickSkipButtonListener onClickSkipButtonListener;

    public interface OnClickSkipButtonListener {
        public void OnClick();
    }

    public void setOnClickSkipButtonListener(OnClickSkipButtonListener listener) {
        onClickSkipButtonListener = listener;
    }

    public VideoView(Context context) {
        super(context);

        myContext = context;

        initView(context);
    }

    public VideoView(Context context, AttributeSet attrs) {
        super(context, attrs);

        myContext = context;

        initView(context);
    }

    public VideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        myContext = context;

        initView(context);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    private void initView(Context context) {
        View.inflate(context, R.layout.view_video, this);

        surfaceView = new SurfaceView(context);

        RelativeLayout.LayoutParams surfaceViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        surfaceViewLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        surfaceViewLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        this.addView(surfaceView, surfaceViewLayoutParams);

        holder = surfaceView.getHolder();
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        holder.setFixedSize(surfaceViewLayoutParams.width, surfaceViewLayoutParams.height);
        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                mediaPlayer = new MediaPlayer();
                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {

                    }
                });
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        if (onClickSkipButtonListener != null) {
                            onClickSkipButtonListener.OnClick();
                        }
                    }
                });
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mediaPlayer.setDisplay(holder);

                try {
                    mediaPlayer.setDataSource(Environment.getExternalStorageDirectory().getPath() + "/crrc/video.mp4");
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });

        ImageButton skipImageButton = new ImageButton(context);
        skipImageButton.setImageDrawable(getResources().getDrawable(R.mipmap.skip_button));
        skipImageButton.getBackground().setAlpha(0);
        skipImageButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickSkipButtonListener != null) {
                    onClickSkipButtonListener.OnClick();
                }
            }
        });

        RelativeLayout.LayoutParams skipImageButtonLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        skipImageButtonLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        skipImageButtonLayoutParams.bottomMargin = 10;
        skipImageButtonLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        skipImageButtonLayoutParams.rightMargin = 10;
        this.addView(skipImageButton, skipImageButtonLayoutParams);

        maskView = new View(context);
        maskView.setBackgroundColor(getResources().getColor(R.color.mask_color));

        RelativeLayout.LayoutParams maskViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        this.addView(maskView, maskViewLayoutParams);
    }

    public void play() {
        mediaPlayer.start();

        handler.postDelayed(task, 100);
    }

    public void stop() {
        mediaPlayer.stop();
        mediaPlayer.reset();

        maskView.setVisibility(VISIBLE);

        try {
            mediaPlayer.setDataSource(Environment.getExternalStorageDirectory().getPath() + "/crrc/video.mp4");
            mediaPlayer.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Runnable task = new Runnable() {
        public void run() {
            maskView.setVisibility(INVISIBLE);
        }
    };

}
