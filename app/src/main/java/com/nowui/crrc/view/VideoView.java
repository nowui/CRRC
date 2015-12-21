package com.nowui.crrc.view;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
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
import com.nowui.crrc.utility.Helper;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class VideoView extends RelativeLayout {

    private Context myContext;
    private RelativeLayout contentRelativeLayout;
    private SurfaceView surfaceView;
    private SurfaceHolder holder;
    private MediaPlayer mediaPlayer;
    private ImageButton skipImageButton;
    private Handler handler = new Handler();

    private OnOnCompletionListener onOnCompletionListener;

    public interface OnOnCompletionListener {
        public void OnTrigger();
    }

    public void setOnOnCompletionListener(OnOnCompletionListener listener) {
        onOnCompletionListener = listener;
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

        contentRelativeLayout = new RelativeLayout(myContext);
        contentRelativeLayout.setClickable(true);
        contentRelativeLayout.setFocusable(true);

        RelativeLayout.LayoutParams contentRelativeLayoutParams = new RelativeLayout.LayoutParams(Helper.Width, Helper.Height);
        contentRelativeLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        contentRelativeLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        contentRelativeLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        this.addView(contentRelativeLayout, contentRelativeLayoutParams);

        surfaceView = new SurfaceView(context);

        RelativeLayout.LayoutParams surfaceViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        surfaceViewLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        surfaceViewLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        contentRelativeLayout.addView(surfaceView, surfaceViewLayoutParams);

        holder = surfaceView.getHolder();
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        holder.setFixedSize(surfaceViewLayoutParams.width, surfaceViewLayoutParams.height);
        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mediaPlayer.setDisplay(holder);
                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {

                    }
                });
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        if (onOnCompletionListener != null) {
                            onOnCompletionListener.OnTrigger();
                        }
                    }
                });

                try {
                    //AssetFileDescriptor fd = fd = myContext.getAssets().openFd("video_" + Helper.Version + ".mp4");
                    //mediaPlayer.setDataSource(fd.getFileDescriptor(), fd.getStartOffset(), fd.getLength());
                    mediaPlayer.setDataSource(Environment.getExternalStorageDirectory().getPath() + "/crrc/video_" + Helper.Version + ".mp4");
                    mediaPlayer.prepare();
                    mediaPlayer.setVolume(1.0F, 1.0F);
                    mediaPlayer.start();

                    handler.postDelayed(skipRunnable, 13700);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
                mediaPlayer.release();
            }
        });

        skipImageButton = new ImageButton(context);
        skipImageButton.setImageDrawable(getResources().getDrawable(R.mipmap.skip_button));
        skipImageButton.getBackground().setAlpha(0);
        skipImageButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                skipImageButton.setVisibility(INVISIBLE);

                mediaPlayer.seekTo(13700);
            }
        });

        RelativeLayout.LayoutParams skipImageButtonLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        skipImageButtonLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        skipImageButtonLayoutParams.bottomMargin = Helper.formatPix(myContext, 10);
        skipImageButtonLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        skipImageButtonLayoutParams.rightMargin = Helper.formatPix(myContext, 10);
        contentRelativeLayout.addView(skipImageButton, skipImageButtonLayoutParams);
    }

    private Runnable skipRunnable = new Runnable() {
        public void run() {
            skipImageButton.setVisibility(INVISIBLE);
        }
    };

}
