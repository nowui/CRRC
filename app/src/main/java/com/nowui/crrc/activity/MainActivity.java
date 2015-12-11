package com.nowui.crrc.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.nowui.crrc.R;
import com.nowui.crrc.utility.Helper;
import com.nowui.crrc.view.MainView;
import com.nowui.crrc.view.StartView;
import com.nowui.crrc.view.VideoView;

public class MainActivity extends Activity {

    private RelativeLayout mainRelativeLayout;
    StartView startView;
    VideoView videoView;
    MainView mainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        System.out.println(Helper.getScreenWidth(this));
        System.out.println(Helper.getScreenHeight(this));

        mainRelativeLayout = (RelativeLayout) findViewById(R.id.mainRelativeLayout);

        initMainView();
        mainView.setVisibility(View.VISIBLE);

        //initVideoView();

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
                showVideoView();
            }
        });

        RelativeLayout.LayoutParams startViewPagerLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        mainRelativeLayout.addView(startView, startViewPagerLayoutParams);
    }

    private void initVideoView() {
        videoView = new VideoView(this);
        videoView.setVisibility(View.INVISIBLE);
        videoView.setOnClickSkipButtonListener(new VideoView.OnClickSkipButtonListener() {
            @Override
            public void OnClick() {
                showMainView();
            }
        });

        RelativeLayout.LayoutParams videoViewPagerLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        mainRelativeLayout.addView(videoView, videoViewPagerLayoutParams);
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
        mainView.setOnClickQuitButtonListener(new MainView.OnClickQuitButtonListener() {
            @Override
            public void OnClick() {
                finish();
            }
        });

        RelativeLayout.LayoutParams mainViewPagerLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        mainRelativeLayout.addView(mainView, mainViewPagerLayoutParams);
    }

    private void showStartView() {
        startView.setVisibility(View.VISIBLE);
        videoView.setVisibility(View.INVISIBLE);
        mainView.setVisibility(View.INVISIBLE);
    }

    private void showVideoView() {
        startView.setVisibility(View.INVISIBLE);
        videoView.setVisibility(View.VISIBLE);
        mainView.setVisibility(View.INVISIBLE);

        videoView.play();
    }

    private void showMainView() {
        startView.setVisibility(View.INVISIBLE);
        videoView.setVisibility(View.INVISIBLE);
        mainView.setVisibility(View.VISIBLE);

        videoView.stop();
    }

}
