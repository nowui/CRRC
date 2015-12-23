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

public class DetailView extends RelativeLayout {

    private Context myContext;
    private RelativeLayout contentRelativeLayout;
    private RelativeLayout pointRelativeLayout;
    private List<View> viewList = new ArrayList<View>();
    private int tag;
    private int position;
    private int parent;

    private OnClickDetailViewCloseButtonListener onClickDetailViewCloseButtonListener;

    public interface OnClickDetailViewCloseButtonListener {
        public void OnClick();
    }

    public void setOnClickDetailViewCloseButtonListener(OnClickDetailViewCloseButtonListener listener) {
        onClickDetailViewCloseButtonListener = listener;
    }

    public DetailView(Context context, int position, int parent) {
        super(context);

        myContext = context;
        this.tag = position;
        this.position = position;
        this.parent = parent;


        initView(context);
    }

    public DetailView(Context context, AttributeSet attrs) {
        super(context, attrs);

        myContext = context;

        initView(context);
    }

    public DetailView(Context context, AttributeSet attrs, int defStyleAttr) {
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

        int total = 1;

        if (Helper.Version == "all" && tag == 1 && parent == 2) {
            total = 3;
        } else if (Helper.Version == "all" && tag == 2 && parent == 2) {
            total = 2;
        }

        for(int i = 0; i < total; i++) {
            AlertView alertView = new AlertView(myContext, this.tag, parent, i);
            alertView.setOnClickAlertViewCloseButtonListener(new AlertView.OnClickAlertViewCloseButtonListener() {
                @Override
                public void OnClick() {
                    if (onClickDetailViewCloseButtonListener != null) {
                        onClickDetailViewCloseButtonListener.OnClick();
                    }
                }
            });

            viewList.add(alertView);
        }

        ViewPager viewPager = new ViewPager(myContext);
        viewPager.setOffscreenPageLimit(total - 1);
        viewPager.setAdapter(new BasePagerAdapter(viewList));
        viewPager.setCurrentItem(0, false);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                checkPoint(position);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        RelativeLayout.LayoutParams viewPagerLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);

        contentRelativeLayout.addView(viewPager, viewPagerLayoutParams);

        pointRelativeLayout = new RelativeLayout(myContext);

        if (total > 1) {
            RelativeLayout.LayoutParams pointRelativeLayoutParams = new RelativeLayout.LayoutParams(Helper.formatPix(myContext, 50 * total), Helper.formatPix(myContext, 20));
            pointRelativeLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
            pointRelativeLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            pointRelativeLayoutParams.topMargin = Helper.formatPix(myContext, 847);
            contentRelativeLayout.addView(pointRelativeLayout, pointRelativeLayoutParams);

            for (int i = 0; i < total; i++) {
                ImageView pointImageView = new ImageView(context);
                pointImageView.setTag(i);

                RelativeLayout.LayoutParams pointImageViewParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                pointImageViewParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
                pointImageViewParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                pointImageViewParams.leftMargin = Helper.formatPix(myContext, 19 + i * 50);
                pointRelativeLayout.addView(pointImageView, pointImageViewParams);
            }

            checkPoint(0);
        }
    }

    public void checkPoint(int position) {
        for(int i = 0; i < pointRelativeLayout.getChildCount(); i++) {
            View view = pointRelativeLayout.getChildAt(i);
            if(view instanceof ImageView) {
                ((ImageView)view).setImageDrawable(getResources().getDrawable(getResources().getIdentifier("point" + (position == (int) view.getTag() ? "_active" : ""), "mipmap", Helper.defPackage)));
            }
        }
    }

    public class BasePagerAdapter extends PagerAdapter {

        private List<View> viewList;

        public BasePagerAdapter(List<View> viewList) {
            this.viewList = viewList;
        }

        @Override
        public int getCount() {
            return viewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(View view, int position) {
            ((ViewPager) view).addView(viewList.get(position));
            return viewList.get(position);
        }

        @Override
        public void destroyItem(View view, int position, Object object) {
            ((ViewPager) view).removeView((View) viewList.get(position));
        }
    }

}
