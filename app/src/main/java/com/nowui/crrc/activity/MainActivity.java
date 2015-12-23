package com.nowui.crrc.activity;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.nowui.crrc.R;
import com.nowui.crrc.utility.Helper;
import com.nowui.crrc.view.LoadView;
import com.nowui.crrc.view.MainView;
import com.nowui.crrc.view.StartView;
import com.nowui.crrc.view.VideoView;

public class MainActivity extends Activity {

    private static final int SHOW_ANOTHER_ACTIVITY = 99;
    private RelativeLayout mainRelativeLayout;
    StartView startView;
    VideoView videoView;
    MainView mainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        setContentView(R.layout.activity_main);

        int width = Helper.getScreenWidth(this);
        int height = Helper.getScreenHeight(this);

        System.out.println("version:" + android.os.Build.VERSION.SDK_INT);

        System.out.println("width:" + width);
        System.out.println("height:" + height);

        System.out.println(this.getResources().getDisplayMetrics().density);

        if (this.getResources().getDisplayMetrics().density == 2) {
            Helper.Width = 1280;
            Helper.Height = 720;

            if(width < Helper.Width) {
                Helper.Height = (int) Math.round(width * 1.0 / Helper.Width * Helper.Height);
                Helper.Width = width;
            }
        } else if (this.getResources().getDisplayMetrics().density == 3) {
            Helper.Width = 1920;
            Helper.Height = 1080;
        } else if (this.getResources().getDisplayMetrics().density == 4) {
            Helper.Width = 2560;
            Helper.Height = 1440;

            Helper.Height = (int) Math.round(width * 1.0 / Helper.Width * Helper.Height);
            Helper.Width = width;
        }

        System.out.println("Helper.Width:" + Helper.Width);
        System.out.println("Helper.Height:" + Helper.Height);

        mainRelativeLayout = (RelativeLayout) findViewById(R.id.mainRelativeLayout);

        initMainView();
        mainView.setVisibility(View.VISIBLE);

        //initStartView();
    }

    @Override
    protected void onResume() {
        if(getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }

        super.onResume();
    }

    private void initStartView() {
        startView = new StartView(this);
        startView.setOnClickStartButtonListener(new StartView.OnClickStartButtonListener() {
            @Override
            public void OnClick() {
                initVideoView();
            }
        });

        RelativeLayout.LayoutParams startViewPagerLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        mainRelativeLayout.addView(startView, startViewPagerLayoutParams);
    }

    private void initVideoView() {
        videoView = new VideoView(this);
        videoView.setOnOnCompletionListener(new VideoView.OnOnCompletionListener() {
            @Override
            public void OnTrigger() {
                showMainView();

                videoView.setVisibility(View.GONE);

                handler.postDelayed(closeVideoViewRunnable, 300);
            }
        });

        RelativeLayout.LayoutParams videoViewPagerLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        mainRelativeLayout.addView(videoView, 2, videoViewPagerLayoutParams);
    }

    private void initMainView() {
        mainView = new MainView(this);
        mainView.setVisibility(View.INVISIBLE);
        mainView.setOnClickHomeButtonListener(new MainView.OnClickHomeButtonListener() {
            @Override
            public void OnClick() {
                showStartView();
            }
        });
        mainView.setOnClickVideoButtonListener(new MainView.OnClickVideoButtonListener() {
            @Override
            public void OnClick() {
                initLoadView();
            }
        });
        mainView.setOnClickQuitButtonListener(new MainView.OnClickQuitButtonListener() {
            @Override
            public void OnClick() {
                finish();
            }
        });

        RelativeLayout.LayoutParams mainViewPagerLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        mainRelativeLayout.addView(mainView, mainViewPagerLayoutParams);
    }

    private void initLoadView() {
        System.out.println("init load view");

        final LoadView loadView = new LoadView(this);
        loadView.setVisibility(View.VISIBLE);
        loadView.setOnOnCompletionListener(new LoadView.OnOnCompletionListener() {
            @Override
            public void OnTrigger() {
                mainRelativeLayout.removeView(loadView);
            }
        });

        RelativeLayout.LayoutParams loadViewPagerLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        mainRelativeLayout.addView(loadView, loadViewPagerLayoutParams);
    }

    private void showStartView() {
        startView.setVisibility(View.VISIBLE);
        mainView.setVisibility(View.INVISIBLE);
    }

    private void showMainView() {
        startView.setVisibility(View.INVISIBLE);
        mainView.setVisibility(View.VISIBLE);
    }

    private Runnable closeVideoViewRunnable = new Runnable() {
        public void run() {
            mainRelativeLayout.removeView(videoView);
        }
    };

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case SHOW_ANOTHER_ACTIVITY:
                    initLoadView();

                    break;
            }
            super.handleMessage(msg);
        }
    };

    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch(ev.getAction()){
            case MotionEvent.ACTION_DOWN: {
                handler.removeMessages(SHOW_ANOTHER_ACTIVITY);
                break;
            }
            case MotionEvent.ACTION_UP: {
                if (mainView.getVisibility() == View.VISIBLE) {
                    handler.sendEmptyMessageDelayed(SHOW_ANOTHER_ACTIVITY, 1000 * 60);
                }
                break;
            }
        }

        return super.dispatchTouchEvent(ev);
    }

}
