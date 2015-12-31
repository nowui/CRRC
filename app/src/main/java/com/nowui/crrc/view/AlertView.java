package com.nowui.crrc.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.nowui.crrc.R;
import com.nowui.crrc.utility.Helper;

import java.util.ArrayList;
import java.util.List;

public class AlertView extends RelativeLayout {

    private Context myContext;
    private RelativeLayout contentRelativeLayout;
    private int tag;
    private int pagerTag;
    private int parent;
    private int selectInt = -1;
    private ImageView titleImageView;
    private RelativeLayout tabContentRelativeLayout;
    private RelativeLayout scrollViewContentRelativeLayout;

    private OnClickAlertViewCloseButtonListener onClickAlertViewCloseButtonListener;

    public interface OnClickAlertViewCloseButtonListener {
        public void OnClick();
    }

    public void setOnClickAlertViewCloseButtonListener(OnClickAlertViewCloseButtonListener listener) {
        onClickAlertViewCloseButtonListener = listener;
    }

    public AlertView(Context context, int tag, int parent, int position) {
        super(context);

        myContext = context;
        this.tag = tag;
        this.pagerTag = position;
        this.parent = parent;

        initView(context);
    }

    public AlertView(Context context, AttributeSet attrs) {
        super(context, attrs);

        myContext = context;

        initView(context);
    }

    public AlertView(Context context, AttributeSet attrs, int defStyleAttr) {
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

        initBackground();

        initContent();
    }

    private void initBackground() {
        ImageView backgroundImageView = new ImageView(myContext);
        backgroundImageView.setImageDrawable(getResources().getDrawable(R.mipmap.detail_background));

        RelativeLayout.LayoutParams backgroundImageViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        backgroundImageViewLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        backgroundImageViewLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        backgroundImageViewLayoutParams.width = Helper.formatPix(myContext, 1920);
        backgroundImageViewLayoutParams.height = Helper.formatPix(myContext, 1080);
        contentRelativeLayout.addView(backgroundImageView, backgroundImageViewLayoutParams);
    }

    private void initContent() {
        int width = 0;
        int height = 0;

        if(Helper.Version == "all") {
            if (Helper.Language == "zh") {
                if (parent == 0) {
                    if (tag == 0) {
                        width = 158;
                        height = 55;
                    } else if (tag == 1) {
                        width = 276;
                        height = 55;
                    } else if (tag == 2) {
                        width = 276;
                        height = 55;
                    } else if (tag == 3) {
                        width = 174;
                        height = 55;
                    } else if (tag == 4) {
                        width = 106;
                        height = 55;
                    }
                } else if (parent == 1) {
                    if (tag == 0) {
                        width = 61;
                        height = 55;
                    } else if (tag == 1) {
                        width = 366;
                        height = 55;
                    } else if (tag == 2) {
                        width = 63;
                        height = 55;
                    } else if (tag == 3) {
                        width = 66;
                        height = 55;
                    }
                } else if (parent == 2) {
                    if (tag == 0) {
                        width = 434;
                        height = 55;
                    } else if (tag == 1) {
                        if (pagerTag == 0) {
                            width = 434;
                            height = 55;
                        } else if (pagerTag == 1) {
                            width = 434;
                            height = 55;
                        } else if (pagerTag == 2) {
                            width = 174;
                            height = 55;
                        }
                    } else if (tag == 2) {
                        if (pagerTag == 0) {
                            width = 378;
                            height = 55;
                        } else if (pagerTag == 1) {
                            width = 616;
                            height = 108;
                        }
                    }
                } else if (parent == 3) {
                    if (tag == 0) {
                        width = 208;
                        height = 55;
                    } else if (tag == 1) {
                        width = 208;
                        height = 55;
                    } else if (tag == 2) {
                        width = 106;
                        height = 55;
                    } else if (tag == 3) {
                        width = 140;
                        height = 55;
                    }
                } else if (parent == 4) {
                    if (tag == 0) {
                        width = 310;
                        height = 55;
                    }
                }
            } else if (Helper.Language == "en") {
                if (parent == 0) {
                    if (tag == 0) {
                        width = 230;
                        height = 55;
                    } else if (tag == 1) {
                        width = 541;
                        height = 55;
                    } else if (tag == 2) {
                        width = 625;
                        height = 55;
                    } else if (tag == 3) {
                        width = 275;
                        height = 55;
                    } else if (tag == 4) {
                        width = 130;
                        height = 55;
                    }
                } else if (parent == 1) {
                    if (tag == 0) {
                        width = 61;
                        height = 55;
                    } else if (tag == 1) {
                        width = 604;
                        height = 55;
                    } else if (tag == 2) {
                        width = 63;
                        height = 55;
                    } else if (tag == 3) {
                        width = 66;
                        height = 55;
                    }
                } else if (parent == 2) {
                    if (tag == 0) {
                        width = 264;
                        height = 55;
                    } else if (tag == 1) {
                        if (pagerTag == 0) {
                            width = 671;
                            height = 52;
                        } else if (pagerTag == 1) {
                            width = 666;
                            height = 52;
                        } else if (pagerTag == 2) {
                            width = 257;
                            height = 55;
                        }
                    } else if (tag == 2) {
                        if (pagerTag == 0) {
                            width = 672;
                            height = 55;
                        } else if (pagerTag == 1) {
                            width = 634;
                            height = 108;
                        }
                    }
                } else if (parent == 3) {
                    if (tag == 0) {
                        width = 399;
                        height = 55;
                    } else if (tag == 1) {
                        width = 285;
                        height = 55;
                    } else if (tag == 2) {
                        width = 240;
                        height = 55;
                    } else if (tag == 3) {
                        width = 410;
                        height = 55;
                    }
                } else if (parent == 4) {
                    if (tag == 0) {
                        width = 664;
                        height = 55;
                    }
                }
            }
        } else if(Helper.Version == "cut") {
            if (parent == 0) {
                if (tag == 0) {
                    width = 66;
                    height = 55;
                } else if (tag == 1) {
                    width = 86;
                    height = 55;
                } else if (tag == 2) {
                    width = 91;
                    height = 55;
                } else if (tag == 3) {
                    width = 67;
                    height = 55;
                } else if (tag == 4) {
                    width = 96;
                    height = 55;
                }
            } else if (parent == 1) {
                if (tag == 0) {
                    width = 306;
                    height = 55;
                } else if (tag == 1) {
                    width = 313;
                    height = 55;
                } else if (tag == 2) {
                    width = 204;
                    height = 55;
                } else if (tag == 3) {
                    width = 256;
                    height = 55;
                } else if (tag == 4) {
                    width = 576;
                    height = 55;
                } else if (tag == 5) {
                    width = 257;
                    height = 55;
                }
            }
        }

        if (width < 300) {
            width = 300;
        }

        titleImageView = new ImageView(myContext);
        titleImageView.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("detail_title_" + Helper.Language + "_" + Helper.Version + "_" + parent + "_" + tag + "_" + pagerTag, "mipmap", Helper.defPackage)));
        titleImageView.setScaleType(ImageView.ScaleType.FIT_START);

        RelativeLayout.LayoutParams titleImageViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        titleImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        titleImageViewLayoutParams.topMargin = Helper.formatPix(myContext, 255);
        titleImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        titleImageViewLayoutParams.leftMargin = Helper.formatPix(myContext, 160);
        titleImageViewLayoutParams.width = Helper.formatPix(myContext, width);
        titleImageViewLayoutParams.height = Helper.formatPix(myContext, height);
        contentRelativeLayout.addView(titleImageView, titleImageViewLayoutParams);

        RelativeLayout pictureContentRelativeLayout = new RelativeLayout(myContext);

        RelativeLayout.LayoutParams pictureContentRelativeLayoutParams = new RelativeLayout.LayoutParams(Helper.formatPix(myContext, 750), Helper.formatPix(myContext, 535));
        pictureContentRelativeLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        pictureContentRelativeLayoutParams.topMargin = Helper.formatPix(myContext, 267);
        pictureContentRelativeLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        pictureContentRelativeLayoutParams.leftMargin = Helper.formatPix(myContext, 958);
        contentRelativeLayout.addView(pictureContentRelativeLayout, pictureContentRelativeLayoutParams);

        width = 0;
        height = 0;

        if(Helper.Version == "all") {
            if (Helper.Language == "zh") {
                if (parent == 0) {
                    if (tag == 0) {
                        width = 461;
                        height = 464;
                    } else if (tag == 1) {
                        width = 565;
                        height = 458;
                    } else if (tag == 2) {
                        width = 495;
                        height = 471;
                    } else if (tag == 3) {
                        width = 599;
                        height = 436;
                    } else if (tag == 4) {
                        width = 625;
                        height = 388;
                    }
                } else if (parent == 1) {
                    if (tag == 0) {
                        width = 628;
                        height = 499;
                    } else if (tag == 1) {
                        width = 301;
                        height = 466;
                    } else if (tag == 2) {
                        width = 281;
                        height = 455;
                    } else if (tag == 3) {
                        width = 575;
                        height = 353;
                    }
                } else if (parent == 2) {
                    if (tag == 0) {
                        width = 668;
                        height = 306;
                    } else if (tag == 1) {
                        if (pagerTag == 0) {
                            width = 600;
                            height = 297;
                        } else if (pagerTag == 1) {
                            width = 600;
                            height = 353;
                        } else if (pagerTag == 2) {
                            width = 600;
                            height = 277;
                        }
                    } else if (tag == 2) {
                        if (pagerTag == 0) {
                            width = 447;
                            height = 419;
                        } else if (pagerTag == 1) {
                            width = 600;
                            height = 361;
                        }
                    }
                } else if (parent == 3) {
                    if (tag == 0) {
                        width = 365;
                        height = 423;
                    } else if (tag == 1) {
                        width = 603;
                        height = 292;
                    } else if (tag == 2) {
                        width = 663;
                        height = 166;
                    } else if (tag == 3) {
                        width = 441;
                        height = 486;
                    }
                } else if (parent == 4) {
                    if (tag == 0) {
                        width = 630;
                        height = 499;
                    }
                }
            } else if (Helper.Language == "en") {
                if (parent == 0) {
                    if (tag == 0) {
                        width = 461;
                        height = 464;
                    } else if (tag == 1) {
                        width = 565;
                        height = 458;
                    } else if (tag == 2) {
                        width = 495;
                        height = 471;
                    } else if (tag == 3) {
                        width = 599;
                        height = 436;
                    } else if (tag == 4) {
                        width = 625;
                        height = 388;
                    }
                } else if (parent == 1) {
                    if (tag == 0) {
                        width = 628;
                        height = 499;
                    } else if (tag == 1) {
                        width = 301;
                        height = 466;
                    } else if (tag == 2) {
                        width = 281;
                        height = 455;
                    } else if (tag == 3) {
                        width = 575;
                        height = 353;
                    }
                } else if (parent == 2) {
                    if (tag == 0) {
                        width = 668;
                        height = 306;
                    } else if (tag == 1) {
                        if (pagerTag == 0) {
                            width = 600;
                            height = 297;
                        } else if (pagerTag == 1) {
                            width = 600;
                            height = 353;
                        } else if (pagerTag == 2) {
                            width = 600;
                            height = 277;
                        }
                    } else if (tag == 2) {
                        if (pagerTag == 0) {
                            width = 447;
                            height = 419;
                        } else if (pagerTag == 1) {
                            width = 600;
                            height = 361;
                        }
                    }
                } else if (parent == 3) {
                    if (tag == 0) {
                        width = 365;
                        height = 423;
                    } else if (tag == 1) {
                        width = 603;
                        height = 292;
                    } else if (tag == 2) {
                        width = 663;
                        height = 166;
                    } else if (tag == 3) {
                        width = 441;
                        height = 486;
                    }
                } else if (parent == 4) {
                    if (tag == 0) {
                        width = 630;
                        height = 499;
                    }
                }
            }
        } else if(Helper.Version == "cut") {
            if (parent == 0) {
                if (tag == 0) {
                    width = 647;
                    height = 513;
                } else if (tag == 1) {
                    width = 507;
                    height = 483;
                } else if (tag == 2) {
                    width = 299;
                    height = 479;
                } else if (tag == 3) {
                    width = 304;
                    height = 483;
                } else if (tag == 4) {
                    width = 297;
                    height = 477;
                }
            } else if (parent == 1) {
                if (tag == 0) {
                    width = 662;
                    height = 380;
                } else if (tag == 1) {
                    width = 565;
                    height = 453;
                } else if (tag == 2) {
                    width = 611;
                    height = 475;
                } else if (tag == 3) {
                    width = 590;
                    height = 422;
                } else if (tag == 4) {
                    width = 611;
                    height = 437;
                } else if (tag == 5) {
                    width = 643;
                    height = 347;
                }
            }
        }

        ImageView pictureImageView = new ImageView(myContext);
        pictureImageView.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("detail_picture_" + Helper.Language + "_" + Helper.Version + "_" + parent + "_" + tag + "_" + pagerTag, "mipmap", Helper.defPackage)));

        RelativeLayout.LayoutParams pictureImageViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        pictureImageViewLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        pictureImageViewLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        pictureImageViewLayoutParams.width = Helper.formatPix(myContext, width);
        pictureImageViewLayoutParams.height = Helper.formatPix(myContext, height);
        pictureContentRelativeLayout.addView(pictureImageView, pictureImageViewLayoutParams);

        tabContentRelativeLayout = new RelativeLayout(myContext);

        RelativeLayout.LayoutParams tabContentRelativeLayoutParams = new RelativeLayout.LayoutParams(Helper.formatPix(myContext, 700), Helper.formatPix(myContext, 100));
        tabContentRelativeLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        tabContentRelativeLayoutParams.topMargin = Helper.formatPix(myContext, 810);
        tabContentRelativeLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        tabContentRelativeLayoutParams.leftMargin = Helper.formatPix(myContext, 200);
        contentRelativeLayout.addView(tabContentRelativeLayout, tabContentRelativeLayoutParams);

        int total = 3;

        if (Helper.Version == "all") {
            total = 4;
        }

        for(int i = 0; i < total; i++) {
            ImageView tabImageView = new ImageView(myContext);
            tabImageView.setTag(i);
            tabImageView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkTabImageView((int) v.getTag());
                }
            });

            RelativeLayout.LayoutParams tabImageViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            tabImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            tabImageViewLayoutParams.leftMargin = Helper.formatPix(myContext, 120 * i);
            tabImageViewLayoutParams.width = Helper.formatPix(myContext, 75);
            tabImageViewLayoutParams.height = Helper.formatPix(myContext, 75);
            tabContentRelativeLayout.addView(tabImageView, tabImageViewLayoutParams);
        }

        ScrollView introductionScrollView = new ScrollView(myContext);

        RelativeLayout.LayoutParams introductionScrollViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        introductionScrollViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        introductionScrollViewLayoutParams.topMargin = Helper.formatPix(myContext, 420);
        introductionScrollViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        introductionScrollViewLayoutParams.leftMargin = Helper.formatPix(myContext, 183);
        introductionScrollViewLayoutParams.width = Helper.formatPix(myContext, 700);
        introductionScrollViewLayoutParams.height = Helper.formatPix(myContext, 295);
        contentRelativeLayout.addView(introductionScrollView, introductionScrollViewLayoutParams);

        scrollViewContentRelativeLayout = new RelativeLayout(myContext);

        RelativeLayout.LayoutParams scrollViewContentRelativeLayoutParams = new RelativeLayout.LayoutParams(Helper.formatPix(myContext, 700), Helper.formatPix(myContext, 295));
        scrollViewContentRelativeLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        scrollViewContentRelativeLayoutParams.topMargin = Helper.formatPix(myContext, 0);
        scrollViewContentRelativeLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        scrollViewContentRelativeLayoutParams.leftMargin = Helper.formatPix(myContext, 0);
        introductionScrollView.addView(scrollViewContentRelativeLayout, scrollViewContentRelativeLayoutParams);

        ImageView closeImageView = new ImageView(myContext);
        closeImageView.setImageDrawable(getResources().getDrawable(R.mipmap.close_button));
        closeImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickAlertViewCloseButtonListener != null) {
                    onClickAlertViewCloseButtonListener.OnClick();
                }
            }
        });

        RelativeLayout.LayoutParams closeImageViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        closeImageViewLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        closeImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        closeImageViewLayoutParams.bottomMargin = Helper.formatPix(myContext, 65);
        closeImageViewLayoutParams.width = Helper.formatPix(myContext, 120);
        closeImageViewLayoutParams.height = Helper.formatPix(myContext, 120);
        contentRelativeLayout.addView(closeImageView, closeImageViewLayoutParams);

        checkTabImageView(0);
    }

    private void checkTabImageView(int position) {
        if(selectInt == position) {
            return;
        }

        selectInt = position;

        if (selectInt == 0) {
            titleImageView.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("detail_title_" + Helper.Language + "_" + Helper.Version + "_" + parent + "_" + tag + "_" + pagerTag, "mipmap", Helper.defPackage)));
        } else {
            titleImageView.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("detail_title_" + Helper.Language + "_" + selectInt, "mipmap", Helper.defPackage)));
        }

        for(int i = 0; i < tabContentRelativeLayout.getChildCount(); i++) {
            View view = tabContentRelativeLayout.getChildAt(i);
            if(view instanceof ImageView) {
                int temp = i;

                if (Helper.Version == "all" && parent == 2 && i == 0) {
                    temp = 10;
                }

                ((ImageView)view).setImageDrawable(getResources().getDrawable(getResources().getIdentifier("detail_tab_" + Helper.Language + "_" + Helper.Version + "_" + temp + (selectInt == (int) view.getTag() ? "_active" : ""), "mipmap", Helper.defPackage)));
            }
        }

        checkIntroductionScrollView(position);
    }

    private void checkIntroductionScrollView(int position) {
        scrollViewContentRelativeLayout.removeAllViews();

        ImageView introductionImageView = new ImageView(myContext);
        introductionImageView.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("detail_introduction_" + Helper.Language + "_" + Helper.Version + "_" + parent + "_" + tag + "_" + pagerTag + "_" + position, "mipmap", Helper.defPackage)));

        int width = 0;
        int height = 0;

        System.out.println("parent:" + parent);
        System.out.println("tag:" + tag);
        System.out.println("pagerTag:" + pagerTag);
        System.out.println("position:" + position);

        if(Helper.Version == "all") {
            if (Helper.Language == "zh") {
                if (parent == 0) {
                    if (tag == 0) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 289;
                            } else if (position == 1) {
                                width = 570;
                                height = 448;
                            } else if (position == 2) {
                                width = 508;
                                height = 432;
                            } else if (position == 3) {
                                width = 570;
                                height = 289;
                            }
                        }
                    } else if (tag == 1) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 686;
                                height = 295;
                            } else if (position == 1) {
                                width = 570;
                                height = 717;
                            } else if (position == 2) {
                                width = 508;
                                height = 611;
                            } else if (position == 3) {
                                width = 570;
                                height = 289;
                            }
                        }
                    } else if (tag == 2) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 325;
                            } else if (position == 1) {
                                width = 570;
                                height = 457;
                            } else if (position == 2) {
                                width = 508;
                                height = 648;
                            } else if (position == 3) {
                                width = 570;
                                height = 509;
                            }
                        }
                    } else if (tag == 3) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 766;
                            } else if (position == 1) {
                                width = 570;
                                height = 264;
                            } else if (position == 2) {
                                width = 453;
                                height = 398;
                            } else if (position == 3) {
                                width = 570;
                                height = 215;
                            }
                        }
                    } else if (tag == 4) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 289;
                            } else if (position == 1) {
                                width = 570;
                                height = 615;
                            } else if (position == 2) {
                                width = 453;
                                height = 324;
                            } else if (position == 3) {
                                width = 570;
                                height = 509;
                            }
                        }
                    }
                } else if (parent == 1) {
                    if (tag == 0) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 105;
                            } else if (position == 1) {
                                width = 570;
                                height = 577;
                            } else if (position == 2) {
                                width = 548;
                                height = 146;
                            } else if (position == 3) {
                                width = 570;
                                height = 227;
                            }
                        }
                    } else if (tag == 1) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 68;
                            } else if (position == 1) {
                                width = 570;
                                height = 562;
                            } else if (position == 2) {
                                width = 548;
                                height = 473;
                            } else if (position == 3) {
                                width = 570;
                                height = 105;
                            }
                        }
                    } else if (tag == 2) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 68;
                            } else if (position == 1) {
                                width = 570;
                                height = 337;
                            } else if (position == 2) {
                                width = 548;
                                height = 182;
                            } else if (position == 3) {
                                width = 570;
                                height = 32;
                            }
                        }
                    } else if (tag == 3) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 68;
                            } else if (position == 1) {
                                width = 570;
                                height = 301;
                            } else if (position == 2) {
                                width = 548;
                                height = 146;
                            } else if (position == 3) {
                                width = 570;
                                height = 32;
                            }
                        }
                    }
                } else if (parent == 2) {
                    if (tag == 0) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 105;
                            } else if (position == 1) {
                                width = 570;
                                height = 1110;
                            } else if (position == 2) {
                                width = 559;
                                height = 2597;
                            } else if (position == 3) {
                                width = 570;
                                height = 2725;
                            }
                        }
                    } else if (tag == 1) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 68;
                            } else if (position == 1) {
                                width = 570;
                                height = 758;
                            } else if (position == 2) {
                                width = 453;
                                height = 466;
                            } else if (position == 3) {
                                width = 570;
                                height = 3082;
                            }
                        } else if (pagerTag == 1) {
                            if (position == 0) {
                                width = 570;
                                height = 68;
                            } else if (position == 1) {
                                width = 570;
                                height = 856;
                            } else if (position == 2) {
                                width = 453;
                                height = 472;
                            } else if (position == 3) {
                                width = 570;
                                height = 3082;
                            }
                        } else if (pagerTag == 2) {
                            if (position == 0) {
                                width = 570;
                                height = 68;
                            } else if (position == 1) {
                                width = 686;
                                height = 766;
                            } else if (position == 2) {
                                width = 453;
                                height = 799;
                            } else if (position == 3) {
                                width = 570;
                                height = 2725;
                            }
                        }
                    } else if (tag == 2) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 179;
                            } else if (position == 1) {
                                width = 570;
                                height = 1236;
                            } else if (position == 2) {
                                width = 548;
                                height = 473;
                            } else if (position == 3) {
                                width = 570;
                                height = 856;
                            }
                        } else if (pagerTag == 1) {
                            if (position == 0) {
                                width = 570;
                                height = 179;
                            } else if (position == 1) {
                                width = 570;
                                height = 1272;
                            } else if (position == 2) {
                                width = 548;
                                height = 763;
                            } else if (position == 3) {
                                width = 570;
                                height = 856;
                            }
                        }
                    }
                } else if (parent == 3) {
                    if (tag == 0) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 68;
                            } else if (position == 1) {
                                width = 570;
                                height = 232;
                            } else if (position == 2) {
                                width = 453;
                                height = 149;
                            } else if (position == 3) {
                                width = 570;
                                height = 142;
                            }
                        }
                    } else if (tag == 1) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 105;
                            } else if (position == 1) {
                                width = 570;
                                height = 274;
                            } else if (position == 2) {
                                width = 453;
                                height = 186;
                            } else if (position == 3) {
                                width = 570;
                                height = 142;
                            }
                        }
                    } else if (tag == 2) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 105;
                            } else if (position == 1) {
                                width = 570;
                                height = 227;
                            } else if (position == 2) {
                                width = 453;
                                height = 186;
                            } else if (position == 3) {
                                width = 570;
                                height = 142;
                            }
                        }
                    } else if (tag == 3) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 105;
                            } else if (position == 1) {
                                width = 570;
                                height = 227;
                            } else if (position == 2) {
                                width = 453;
                                height = 112;
                            } else if (position == 3) {
                                width = 570;
                                height = 105;
                            }
                        }
                    }
                } else if (parent == 4) {
                    if (tag == 0) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 105;
                            } else if (position == 1) {
                                width = 570;
                                height = 1190;
                            } else if (position == 2) {
                                width = 548;
                                height = 291;
                            } else if (position == 3) {
                                width = 570;
                                height = 362;
                            }
                        }
                    }
                }
            } else if (Helper.Language == "en") {
                if (parent == 0) {
                    if (tag == 0) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 435;
                            } else if (position == 1) {
                                width = 570;
                                height = 704;
                            } else if (position == 2) {
                                width = 509;
                                height = 1228;
                            } else if (position == 3) {
                                width = 570;
                                height = 472;
                            }
                        }
                    } else if (tag == 1) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 509;
                            } else if (position == 1) {
                                width = 570;
                                height = 1084;
                            } else if (position == 2) {
                                width = 507;
                                height = 1130;
                            } else if (position == 3) {
                                width = 570;
                                height = 546;
                            }
                        }
                    } else if (tag == 2) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 546;
                            } else if (position == 1) {
                                width = 570;
                                height = 674;
                            } else if (position == 2) {
                                width = 510;
                                height = 1482;
                            } else if (position == 3) {
                                width = 570;
                                height = 802;
                            }
                        }
                    } else if (tag == 3) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 949;
                            } else if (position == 1) {
                                width = 570;
                                height = 374;
                            } else if (position == 2) {
                                width = 546;
                                height = 875;
                            } else if (position == 3) {
                                width = 570;
                                height = 399;
                            }
                        }
                    } else if (tag == 4) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 435;
                            } else if (position == 1) {
                                width = 570;
                                height = 798;
                            } else if (position == 2) {
                                width = 538;
                                height = 541;
                            } else if (position == 3) {
                                width = 570;
                                height = 619;
                            }
                        }
                    }
                } else if (parent == 1) {
                    if (tag == 0) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 142;
                            } else if (position == 1) {
                                width = 570;
                                height = 1022;
                            } else if (position == 2) {
                                width = 540;
                                height = 233;
                            } else if (position == 3) {
                                width = 570;
                                height = 294;
                            }
                        }
                    } else if (tag == 1) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 105;
                            } else if (position == 1) {
                                width = 570;
                                height = 966;
                            } else if (position == 2) {
                                width = 545;
                                height = 1058;
                            } else if (position == 3) {
                                width = 570;
                                height = 179;
                            }
                        }
                    } else if (tag == 2) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 105;
                            } else if (position == 1) {
                                width = 570;
                                height = 558;
                            } else if (position == 2) {
                                width = 544;
                                height = 357;
                            } else if (position == 3) {
                                width = 570;
                                height = 32;
                            }
                        }
                    } else if (tag == 3) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 105;
                            } else if (position == 1) {
                                width = 570;
                                height = 411;
                            } else if (position == 2) {
                                width = 548;
                                height = 326;
                            } else if (position == 3) {
                                width = 570;
                                height = 32;
                            }
                        }
                    }
                } else if (parent == 2) {
                    if (tag == 0) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 252;
                            } else if (position == 1) {
                                width = 570;
                                height = 1473;
                            } else if (position == 2) {
                                width = 523;
                                height = 1080;
                            } else if (position == 3) {
                                width = 564;
                                height = 5085;
                            }
                        }
                    } else if (tag == 1) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 142;
                            } else if (position == 1) {
                                width = 570;
                                height = 1190;
                            } else if (position == 2) {
                                width = 543;
                                height = 602;
                            } else if (position == 3) {
                                width = 570;
                                height = 6070;
                            }
                        } else if (pagerTag == 1) {
                            if (position == 0) {
                                width = 570;
                                height = 142;
                            } else if (position == 1) {
                                width = 570;
                                height = 1200;
                            } else if (position == 2) {
                                width = 543;
                                height = 673;
                            } else if (position == 3) {
                                width = 570;
                                height = 6070;
                            }
                        } else if (pagerTag == 2) {
                            if (position == 0) {
                                width = 570;
                                height = 142;
                            } else if (position == 1) {
                                width = 570;
                                height = 980;
                            } else if (position == 2) {
                                width = 570;
                                height = 980;
                            } else if (position == 3) {
                                width = 570;
                                height = 6070;
                            }
                        }
                    } else if (tag == 2) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 215;
                            } else if (position == 1) {
                                width = 570;
                                height = 1892;
                            } else if (position == 2) {
                                width = 550;
                                height = 926;
                            } else if (position == 3) {
                                width = 555;
                                height = 2805;
                            }
                        } else if (pagerTag == 1) {
                            if (position == 0) {
                                width = 570;
                                height = 215;
                            } else if (position == 1) {
                                width = 570;
                                height = 1890;
                            } else if (position == 2) {
                                width = 545;
                                height = 770;
                            } else if (position == 3) {
                                width = 569;
                                height = 2534;
                            }
                        }
                    }
                } else if (parent == 3) {
                    if (tag == 0) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 142;
                            } else if (position == 1) {
                                width = 570;
                                height = 232;
                            } else if (position == 2) {
                                width = 545;
                                height = 234;
                            } else if (position == 3) {
                                width = 570;
                                height = 142;
                            }
                        }
                    } else if (tag == 1) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 179;
                            } else if (position == 1) {
                                width = 570;
                                height = 274;
                            } else if (position == 2) {
                                width = 550;
                                height = 236;
                            } else if (position == 3) {
                                width = 570;
                                height = 142;
                            }
                        }
                    } else if (tag == 2) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 215;
                            } else if (position == 1) {
                                width = 570;
                                height = 227;
                            } else if (position == 2) {
                                width = 544;
                                height = 222;
                            } else if (position == 3) {
                                width = 570;
                                height = 142;
                            }
                        }
                    } else if (tag == 3) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 179;
                            } else if (position == 1) {
                                width = 570;
                                height = 264;
                            } else if (position == 2) {
                                width = 541;
                                height = 149;
                            } else if (position == 3) {
                                width = 570;
                                height = 105;
                            }
                        }
                    }
                } else if (parent == 4) {
                    if (tag == 0) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 179;
                            } else if (position == 1) {
                                width = 570;
                                height = 1893;
                            } else if (position == 2) {
                                width = 543;
                                height = 738;
                            } else if (position == 3) {
                                width = 570;
                                height = 399;
                            }
                        }
                    }
                }
            }
        } else if(Helper.Version == "cut") {
            if (Helper.Language == "zh") {
                if (parent == 0) {
                    if (tag == 0) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 68;
                            } else if (position == 1) {
                                width = 570;
                                height = 337;
                            } else if (position == 2) {
                                width = 548;
                                height = 364;
                            }
                        }
                    } else if (tag == 1) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 68;
                            } else if (position == 1) {
                                width = 570;
                                height = 364;
                            } else if (position == 2) {
                                width = 548;
                                height = 690;
                            }
                        }
                    } else if (tag == 2) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 289;
                            } else if (position == 1) {
                                width = 570;
                                height = 496;
                            } else if (position == 2) {
                                width = 548;
                                height = 364;
                            }
                        }
                    } else if (tag == 3) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 179;
                            } else if (position == 1) {
                                width = 570;
                                height = 161;
                            } else if (position == 2) {
                                width = 548;
                                height = 219;
                            }
                        }
                    } else if (tag == 4) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 289;
                            } else if (position == 1) {
                                width = 570;
                                height = 227;
                            } else if (position == 2) {
                                width = 548;
                                height = 291;
                            }
                        }
                    }
                } else if (parent == 1) {
                    if (tag == 0) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 105;
                            } else if (position == 1) {
                                width = 570;
                                height = 521;
                            } else if (position == 2) {
                                width = 548;
                                height = 1696;
                            }
                        }
                    } else if (tag == 1) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 105;
                            } else if (position == 1) {
                                width = 570;
                                height = 452;
                            } else if (position == 2) {
                                width = 548;
                                height = 290;
                            }
                        }
                    } else if (tag == 2) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 68;
                            } else if (position == 1) {
                                width = 570;
                                height = 374;
                            } else if (position == 2) {
                                width = 548;
                                height = 290;
                            }
                        }
                    } else if (tag == 3) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 105;
                            } else if (position == 1) {
                                width = 570;
                                height = 411;
                            } else if (position == 2) {
                                width = 548;
                                height = 253;
                            }
                        }
                    } else if (tag == 4) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 105;
                            } else if (position == 1) {
                                width = 570;
                                height = 411;
                            } else if (position == 2) {
                                width = 548;
                                height = 253;
                            }
                        }
                    } else if (tag == 5) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 105;
                            } else if (position == 1) {
                                width = 570;
                                height = 531;
                            } else if (position == 2) {
                                width = 548;
                                height = 799;
                            }
                        }
                    }
                }
            } else if (Helper.Language == "en") {
                if (parent == 0) {
                    if (tag == 0) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 142;
                            } else if (position == 1) {
                                width = 570;
                                height = 533;
                            } else if (position == 2) {
                                width = 544;
                                height = 562;
                            }
                        }
                    } else if (tag == 1) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 142;
                            } else if (position == 1) {
                                width = 570;
                                height = 577;
                            } else if (position == 2) {
                                width = 520;
                                height = 1080;
                            }
                        }
                    } else if (tag == 2) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 435;
                            } else if (position == 1) {
                                width = 570;
                                height = 606;
                            } else if (position == 2) {
                                width = 544;
                                height = 642;
                            }
                        }
                    } else if (tag == 3) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 252;
                            } else if (position == 1) {
                                width = 570;
                                height = 161;
                            } else if (position == 2) {
                                width = 541;
                                height = 352;
                            }
                        }
                    } else if (tag == 4) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 435;
                            } else if (position == 1) {
                                width = 570;
                                height = 264;
                            } else if (position == 2) {
                                width = 546;
                                height = 538;
                            }
                        }
                    }
                } else if (parent == 1) {
                    if (tag == 0) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 179;
                            } else if (position == 1) {
                                width = 570;
                                height = 741;
                            } else if (position == 2) {
                                width = 549;
                                height = 2819;
                            }
                        }
                    } else if (tag == 1) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 179;
                            } else if (position == 1) {
                                width = 570;
                                height = 783;
                            } else if (position == 2) {
                                width = 545;
                                height = 514;
                            }
                        }
                    } else if (tag == 2) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 105;
                            } else if (position == 1) {
                                width = 570;
                                height = 558;
                            } else if (position == 2) {
                                width = 542;
                                height = 394;
                            }
                        }
                    } else if (tag == 3) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 179;
                            } else if (position == 1) {
                                width = 570;
                                height = 668;
                            } else if (position == 2) {
                                width = 548;
                                height = 401;
                            }
                        }
                    } else if (tag == 4) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 105;
                            } else if (position == 1) {
                                width = 570;
                                height = 558;
                            } else if (position == 2) {
                                width = 539;
                                height = 442;
                            }
                        }
                    } else if (tag == 5) {
                        if (pagerTag == 0) {
                            if (position == 0) {
                                width = 570;
                                height = 142;
                            } else if (position == 1) {
                                width = 570;
                                height = 898;
                            } else if (position == 2) {
                                width = 546;
                                height = 1062;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("width:" + width);
        System.out.println("height:" + height);

        RelativeLayout.LayoutParams introductionImageViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        introductionImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        introductionImageViewLayoutParams.topMargin = Helper.formatPix(myContext, 0);
        introductionImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        introductionImageViewLayoutParams.leftMargin = Helper.formatPix(myContext, 0);
        introductionImageViewLayoutParams.width = Helper.formatPix(myContext, width);
        introductionImageViewLayoutParams.height = Helper.formatPix(myContext, height);

        scrollViewContentRelativeLayout.addView(introductionImageView, introductionImageViewLayoutParams);
    }

}
