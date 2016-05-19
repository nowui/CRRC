package com.nowui.crrc.view;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nowui.crrc.R;
import com.nowui.crrc.utility.Helper;

public class IndexlView extends RelativeLayout {

    private Context myContext;
    private RelativeLayout contentRelativeLayout;
    ImageView frameImageView;
    private AnimationDrawable frameAnim;
    private Handler handler = new Handler();
    private int tag;

    private OnClickIndexViewCloseButtonListener onClickIndexViewCloseButtonListener;

    public interface OnClickIndexViewCloseButtonListener {
        public void OnClick();
    }

    public void setOnClickIndexViewCloseButtonListener(OnClickIndexViewCloseButtonListener listener) {
        onClickIndexViewCloseButtonListener = listener;
    }

    public IndexlView(Context context, int position) {
        super(context);

        myContext = context;

        tag = position;

        initView(context);
    }

    public IndexlView(Context context, AttributeSet attrs) {
        super(context, attrs);

        myContext = context;

        initView(context);
    }

    public IndexlView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        myContext = context;

        initView(context);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    private void initView(Context context) {
        View.inflate(context, R.layout.view_index, this);

        contentRelativeLayout = new RelativeLayout(myContext);
        contentRelativeLayout.setClickable(true);
        contentRelativeLayout.setFocusable(true);

        RelativeLayout.LayoutParams contentRelativeLayoutParams = new RelativeLayout.LayoutParams(Helper.Width, Helper.Height);
        contentRelativeLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        contentRelativeLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        contentRelativeLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        this.addView(contentRelativeLayout, contentRelativeLayoutParams);

        initBackground();

        if (Helper.Version == "all" && tag == 4) {
            frameImageView = new ImageView(myContext);
            frameImageView.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("frame_0", "mipmap", Helper.defPackage)));

            RelativeLayout.LayoutParams frameImageViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
            frameImageViewLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
            frameImageViewLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
            contentRelativeLayout.addView(frameImageView, frameImageViewLayoutParams);

            handler.postDelayed(frameRunnable, 0);

            handler.postDelayed(menuRunnable, 5500);
        }

        initContent();

        initBackButton();
    }

    private void initBackground() {
        ImageView backgroundImageView = new ImageView(myContext);
        backgroundImageView.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("index_background_" + Helper.Version + "_" + tag, "mipmap", Helper.defPackage)));

        RelativeLayout.LayoutParams backgroundImageViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        backgroundImageViewLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        backgroundImageViewLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        backgroundImageViewLayoutParams.width = Helper.formatPix(myContext, 1920);
        backgroundImageViewLayoutParams.height = Helper.formatPix(myContext, 1080);
        contentRelativeLayout.addView(backgroundImageView, backgroundImageViewLayoutParams);
    }

    private void initContent() {
        ImageView titleImageView = new ImageView(myContext);
        titleImageView.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("index_title_" + Helper.Language + "_" + Helper.Version + "_" + tag, "mipmap", Helper.defPackage)));

        int width = 0;
        int height = 0;

        if(Helper.Version == "all") {
            if (Helper.Language == "zh") {
                if (tag == 0) {
                    width = 229;
                    height = 165;
                } else if (tag == 1) {
                    width = 229;
                    height = 165;
                } else if (tag == 2) {
                    width = 309;
                    height = 165;
                } else if (tag == 3) {
                    width = 229;
                    height = 165;
                } else if (tag == 4) {
                    width = 269;
                    height = 165;
                }
            } else if (Helper.Language == "en") {
                if (tag == 0) {
                    width = 463;
                    height = 165;
                } else if (tag == 1) {
                    width = 324;
                    height = 165;
                } else if (tag == 2) {
                    width = 534;
                    height = 165;
                } else if (tag == 3) {
                    width = 352;
                    height = 165;
                } else if (tag == 4) {
                    width = 853;
                    height = 165;
                }
            }
        } else if(Helper.Version == "cut") {
            if (Helper.Language == "zh") {
                if (tag == 0) {
                    width = 309;
                    height = 207;
                } else if (tag == 1) {
                    width = 229;
                    height = 207;
                }
            } else if (Helper.Language == "en") {
                if (tag == 0) {
                    width = 514;
                    height = 207;
                } else if (tag == 1) {
                    width = 360;
                    height = 207;
                }
            }
        }

        RelativeLayout.LayoutParams titleImageViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        titleImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        titleImageViewLayoutParams.topMargin = Helper.formatPix(myContext, 40);
        titleImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        titleImageViewLayoutParams.leftMargin = Helper.formatPix(myContext, 0);
        titleImageViewLayoutParams.width = Helper.formatPix(myContext, width);
        titleImageViewLayoutParams.height = Helper.formatPix(myContext, height);
        contentRelativeLayout.addView(titleImageView, titleImageViewLayoutParams);

        if (Helper.Version == "all") {
            width = 0;
            height = 0;

            if (Helper.Language == "zh") {
                if (tag == 0) {
                    width = 580;
                    height = 161;
                } else if (tag == 1) {
                    width = 460;
                    height = 371;
                } else if (tag == 2) {
                    width = 620;
                    height = 77;
                } else if (tag == 3) {
                    width = 580;
                    height = 387;
                } else if (tag == 4) {
                    width = 580;
                    height = 119;
                }
            } else if (Helper.Language == "en") {
                if (tag == 0) {
                    width = 480;
                    height = 371;
                } else if (tag == 1) {
                    width = 460;
                    height = 620;
                } else if (tag == 2) {
                    width = 620;
                    height = 161;
                } else if (tag == 3) {
                    width = 400;
                    height = 553;
                } else if (tag == 4) {
                    width = 580;
                    height = 245;
                }
            }

            ImageView textImageView = new ImageView(myContext);
            textImageView.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("index_text_" + Helper.Language + "_" + Helper.Version + "_" + tag, "mipmap", Helper.defPackage)));

            RelativeLayout.LayoutParams textImageViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            textImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            textImageViewLayoutParams.topMargin = Helper.formatPix(myContext, 250);
            textImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            textImageViewLayoutParams.leftMargin = Helper.formatPix(myContext, 75);
            textImageViewLayoutParams.width = Helper.formatPix(myContext, (float)(width * 1.2));
            textImageViewLayoutParams.height = Helper.formatPix(myContext, (float)(height * 1.2));
            contentRelativeLayout.addView(textImageView, textImageViewLayoutParams);
        }

        MenuView.OnClickMenuViewListener onClickMenuViewListener = new MenuView.OnClickMenuViewListener() {
            @Override
            public void OnClick(int position) {
                final DetailView detailView = new DetailView(myContext, position, tag);
                detailView.setOnClickDetailViewCloseButtonListener(new DetailView.OnClickDetailViewCloseButtonListener() {
                    @Override
                    public void OnClick() {
                        removeView(detailView);
                    }
                });

                RelativeLayout.LayoutParams detailViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
                detailViewLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
                detailViewLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
                addView(detailView, detailViewLayoutParams);
            }
        };

        String jsonString = "[";

        if (Helper.Version == "cut") {
            if (tag == 0) {
                if (Helper.Language == "zh") {
                    jsonString += "{\"type\": \"left\", \"tag\": 0, \"title\": \"index_menu_title_zh_cut_0_0\", \"top\": 650, \"left\": 648, \"width\": 171, \"height\": 31 }";
                    jsonString += ", {\"type\": \"left\", \"tag\": 1, \"title\": \"index_menu_title_zh_cut_0_1\", \"top\": 560, \"left\": 820, \"width\": 224, \"height\": 31 }";
                    jsonString += ", {\"type\": \"right\", \"tag\": 2, \"title\": \"index_menu_title_zh_cut_0_2\", \"top\": 360, \"left\": 645, \"width\": 181, \"height\": 31 }";
                    jsonString += ", {\"type\": \"left\", \"tag\": 3, \"title\": \"index_menu_title_zh_cut_0_3\", \"top\": 320, \"left\": 1233, \"width\": 140, \"height\": 31 }";
                    jsonString += ", {\"type\": \"right_right\", \"tag\": 4, \"title\": \"index_menu_title_zh_cut_0_4\", \"top\": 440, \"left\": 1272, \"width\": 227, \"height\": 31 }";
                } else if (Helper.Language == "en") {
                    jsonString += "{\"type\": \"left\", \"tag\": 0, \"title\": \"index_menu_title_en_cut_0_0\", \"top\": 650, \"left\": 648, \"width\": 98, \"height\": 31 }";
                    jsonString += ", {\"type\": \"left\", \"tag\": 1, \"title\": \"index_menu_title_en_cut_0_1\", \"top\": 560, \"left\": 820, \"width\": 98, \"height\": 31 }";
                    jsonString += ", {\"type\": \"right\", \"tag\": 2, \"title\": \"index_menu_title_en_cut_0_2\", \"top\": 360, \"left\": 645, \"width\": 108, \"height\": 31 }";
                    jsonString += ", {\"type\": \"left\", \"tag\": 3, \"title\": \"index_menu_title_en_cut_0_3\", \"top\": 320, \"left\": 1233, \"width\": 98, \"height\": 31 }";
                    jsonString += ", {\"type\": \"right_right\", \"tag\": 4, \"title\": \"index_menu_title_en_cut_0_4\", \"top\": 440, \"left\": 1272, \"width\": 98, \"height\": 31 }";
                }
            } else if(tag == 1) {
                if (Helper.Language == "zh") {
                    jsonString += "{\"type\": \"bottom\", \"tag\": 0, \"title\": \"index_menu_title_zh_cut_1_0\", \"top\": 672, \"left\": 720, \"width\": 141, \"height\": 31 }";
                    jsonString += ", {\"type\": \"right\", \"tag\": 1, \"title\": \"index_menu_title_zh_cut_1_1\", \"top\": 570, \"left\": 405, \"width\": 129, \"height\": 31 }";
                    jsonString += ", {\"type\": \"right\", \"tag\": 2, \"title\": \"index_menu_title_zh_cut_1_2\", \"top\": 527, \"left\": 603, \"width\": 154, \"height\": 31 }";
                    jsonString += ", {\"type\": \"bottom\", \"tag\": 3, \"title\": \"index_menu_title_zh_cut_1_3\", \"top\": 565, \"left\": 1193, \"width\": 141, \"height\": 31 }";
                    jsonString += ", {\"type\": \"right\", \"tag\": 4, \"title\": \"index_menu_title_zh_cut_1_4\", \"top\": 480, \"left\": 750, \"width\": 175, \"height\": 31 }";
                    jsonString += ", {\"type\": \"right_right\", \"tag\": 5, \"title\": \"index_menu_title_zh_cut_1_5\", \"top\": 512, \"left\": 1345, \"width\": 141, \"height\": 31 }";
                } else if (Helper.Language == "en") {
                    jsonString += "{\"type\": \"bottom\", \"tag\": 0, \"title\": \"index_menu_title_en_cut_1_0\", \"top\": 672, \"left\": 720, \"width\": 198, \"height\": 31 }";
                    jsonString += ", {\"type\": \"right\", \"tag\": 1, \"title\": \"index_menu_title_en_cut_1_1\", \"top\": 570, \"left\": 405, \"width\": 200, \"height\": 31 }";
                    jsonString += ", {\"type\": \"right\", \"tag\": 2, \"title\": \"index_menu_title_en_cut_1_2\", \"top\": 527, \"left\": 603, \"width\": 154, \"height\": 31 }";
                    jsonString += ", {\"type\": \"bottom\", \"tag\": 3, \"title\": \"index_menu_title_en_cut_1_3\", \"top\": 565, \"left\": 1193, \"width\": 175, \"height\": 31 }";
                    jsonString += ", {\"type\": \"right\", \"tag\": 4, \"title\": \"index_menu_title_en_cut_1_4\", \"top\": 480, \"left\": 750, \"width\": 310, \"height\": 31 }";
                    jsonString += ", {\"type\": \"right_right\", \"tag\": 5, \"title\": \"index_menu_title_en_cut_1_5\", \"top\": 512, \"left\": 1345, \"width\": 158, \"height\": 31 }";
                }
            }
        } else if(Helper.Version == "all") {
            if (tag == 0) {
                if (Helper.Language == "zh") {
                    jsonString += "{\"type\": \"left\", \"tag\": 0, \"title\": \"index_menu_title_zh_all_0_0\", \"top\": 520, \"left\": 680, \"width\": 120, \"height\": 31 }";
                    jsonString += ", {\"type\": \"left\", \"tag\": 1, \"title\": \"index_menu_title_zh_all_0_1\", \"top\": 340, \"left\": 700, \"width\": 170, \"height\": 31 }";
                    jsonString += ", {\"type\": \"left\", \"tag\": 2, \"title\": \"index_menu_title_zh_all_0_2\", \"top\": 170, \"left\": 1000, \"width\": 171, \"height\": 31 }";
                    jsonString += ", {\"type\": \"left\", \"tag\": 3, \"title\": \"index_menu_title_zh_all_0_3\", \"top\": 590, \"left\": 1000, \"width\": 123, \"height\": 31 }";
                    jsonString += ", {\"type\": \"left\", \"tag\": 4, \"title\": \"index_menu_title_zh_all_0_4\", \"top\": 405, \"left\": 1300, \"width\": 94, \"height\": 31 }";
                } else if (Helper.Language == "en") {
                    jsonString += "{\"type\": \"left\", \"tag\": 0, \"title\": \"index_menu_title_en_all_0_0\", \"top\": 520, \"left\": 680, \"width\": 171, \"height\": 31 }";
                    jsonString += ", {\"type\": \"left\", \"tag\": 1, \"title\": \"index_menu_title_en_all_0_1\", \"top\": 340, \"left\": 700, \"width\": 307, \"height\": 31 }";
                    jsonString += ", {\"type\": \"left\", \"tag\": 2, \"title\": \"index_menu_title_en_all_0_2\", \"top\": 170, \"left\": 1000, \"width\": 334, \"height\": 31 }";
                    jsonString += ", {\"type\": \"left\", \"tag\": 3, \"title\": \"index_menu_title_en_all_0_3\", \"top\": 590, \"left\": 1000, \"width\": 182, \"height\": 31 }";
                    jsonString += ", {\"type\": \"left\", \"tag\": 4, \"title\": \"index_menu_title_en_all_0_4\", \"top\": 405, \"left\": 1300, \"width\": 112, \"height\": 31 }";
                }
            } else if(tag == 1) {
                if (Helper.Language == "zh") {
                    jsonString += "{\"type\": \"left\", \"tag\": 0, \"title\": \"index_menu_title_zh_all_1_0\", \"top\": 278, \"left\": 570, \"width\": 84, \"height\": 31 }";
                    jsonString += ", {\"type\": \"left\", \"tag\": 1, \"title\": \"index_menu_title_zh_all_1_1\", \"top\": 205, \"left\": 680, \"width\": 218, \"height\": 31 }";
                    jsonString += ", {\"type\": \"left\", \"tag\": 2, \"title\": \"index_menu_title_zh_all_1_2\", \"top\": 745, \"left\": 1100, \"width\": 82, \"height\": 31 }";
                    jsonString += ", {\"type\": \"right_right\", \"tag\": 3, \"title\": \"index_menu_title_zh_all_1_3\", \"top\": 500, \"left\": 1265, \"width\": 84, \"height\": 31 }";
                } else if (Helper.Language == "en") {
                    jsonString += "{\"type\": \"left\", \"tag\": 0, \"title\": \"index_menu_title_en_all_1_0\", \"top\": 278, \"left\": 570, \"width\": 84, \"height\": 31 }";
                    jsonString += ", {\"type\": \"left\", \"tag\": 1, \"title\": \"index_menu_title_en_all_1_1\", \"top\": 205, \"left\": 680, \"width\": 334, \"height\": 31 }";
                    jsonString += ", {\"type\": \"left\", \"tag\": 2, \"title\": \"index_menu_title_en_all_1_2\", \"top\": 745, \"left\": 1100, \"width\": 82, \"height\": 31 }";
                    jsonString += ", {\"type\": \"right_right\", \"tag\": 3, \"title\": \"index_menu_title_en_all_1_3\", \"top\": 500, \"left\": 1265, \"width\": 84, \"height\": 31 }";
                }
            } else if(tag == 2) {
                if (Helper.Language == "zh") {
                    jsonString += "{\"type\": \"left\", \"tag\": 0, \"title\": \"index_menu_title_zh_all_2_0\", \"top\": 590, \"left\": 780, \"width\": 147, \"height\": 31 }";
                    jsonString += ", {\"type\": \"left\", \"tag\": 1, \"title\": \"index_menu_title_zh_all_2_1\", \"top\": 550, \"left\": 970, \"width\": 117, \"height\": 31 }";
                    jsonString += ", {\"type\": \"left\", \"tag\": 2, \"title\": \"index_menu_title_zh_all_2_2\", \"top\": 440, \"left\": 1230, \"width\": 199, \"height\": 31 }";
                } else if (Helper.Language == "en") {
                    jsonString += "{\"type\": \"right\", \"tag\": 0, \"title\": \"index_menu_title_en_all_2_0\", \"top\": 590, \"left\": 280, \"width\": 270, \"height\": 31 }";
                    jsonString += ", {\"type\": \"left\", \"tag\": 1, \"title\": \"index_menu_title_en_all_2_1\", \"top\": 550, \"left\": 970, \"width\": 166, \"height\": 31 }";
                    jsonString += ", {\"type\": \"left\", \"tag\": 2, \"title\": \"index_menu_title_en_all_2_2\", \"top\": 440, \"left\": 1230, \"width\": 306, \"height\": 31 }";
                }
            } else if(tag == 3) {
                if (Helper.Language == "zh") {
                    jsonString += "{\"type\": \"left\", \"tag\": 0, \"title\": \"index_menu_title_zh_all_3_0\", \"top\": 630, \"left\": 635, \"width\": 139, \"height\": 31 }";
                    jsonString += ", {\"type\": \"right\", \"tag\": 1, \"title\": \"index_menu_title_zh_all_3_1\", \"top\": 590, \"left\": 350, \"width\": 132, \"height\": 31 }";
                    jsonString += ", {\"type\": \"left\", \"tag\": 2, \"title\": \"index_menu_title_zh_all_3_2\", \"top\": 560, \"left\": 1000, \"width\": 100, \"height\": 31 }";
                    jsonString += ", {\"type\": \"left\", \"tag\": 3, \"title\": \"index_menu_title_zh_all_3_3\", \"top\": 500, \"left\": 1260, \"width\": 106, \"height\": 31 }";
                } else if (Helper.Language == "en") {
                    jsonString += "{\"type\": \"right\", \"tag\": 0, \"title\": \"index_menu_title_en_all_3_0\", \"top\": 630, \"left\": 135, \"width\": 234, \"height\": 31 }";
                    jsonString += ", {\"type\": \"right\", \"tag\": 1, \"title\": \"index_menu_title_en_all_3_1\", \"top\": 590, \"left\": 350, \"width\": 179, \"height\": 31 }";
                    jsonString += ", {\"type\": \"left\", \"tag\": 2, \"title\": \"index_menu_title_en_all_3_2\", \"top\": 560, \"left\": 1000, \"width\": 166, \"height\": 31 }";
                    jsonString += ", {\"type\": \"left\", \"tag\": 3, \"title\": \"index_menu_title_en_all_3_3\", \"top\": 500, \"left\": 1260, \"width\": 234, \"height\": 31 }";
                }
            } else if(tag == 4) {
                if (Helper.Language == "zh") {
                    jsonString += "{\"type\": \"right_right\", \"tag\": 0, \"title\": \"index_menu_title_zh_all_4_0\", \"top\": 560, \"left\": 1025, \"width\": 199, \"height\": 31 }";
                } else if (Helper.Language == "en") {
                    jsonString += "{\"type\": \"right_right\", \"tag\": 0, \"title\": \"index_menu_title_en_all_4_0\", \"top\": 560, \"left\": 1025, \"width\": 354, \"height\": 31 }";
                }
            }
        }
        jsonString += "]";

        System.out.println(jsonString);

        JSONArray jsonArray = JSON.parseArray(jsonString);

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            MenuView menuView = new MenuView(myContext, jsonObject.get("type").toString(), jsonObject.get("title").toString(), (int) jsonObject.get("width"), (int) jsonObject.get("height"));
            menuView.setTag(jsonObject.get("tag"));
            menuView.setOnClickMenuViewListener(onClickMenuViewListener);

            if (Helper.Version == "all" && tag == 4) {
                menuView.setVisibility(INVISIBLE);
            }

            RelativeLayout.LayoutParams menuViewLayoutParams = new RelativeLayout.LayoutParams(Helper.formatPix(myContext, 600), Helper.formatPix(myContext, 100));
            menuViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            menuViewLayoutParams.topMargin = Helper.formatPix(myContext, Float.parseFloat(jsonObject.get("top").toString()));
            menuViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            menuViewLayoutParams.leftMargin = Helper.formatPix(myContext, Float.parseFloat(jsonObject.get("left").toString()));
            contentRelativeLayout.addView(menuView, menuViewLayoutParams);
        }
    }

    private void initBackButton() {
        ImageView backImageButton = new ImageView(myContext);
        backImageButton.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("back_button_" + Helper.Language, "mipmap", Helper.defPackage)));
        backImageButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickIndexViewCloseButtonListener != null) {
                    onClickIndexViewCloseButtonListener.OnClick();
                }
            }
        });

        RelativeLayout.LayoutParams backImageButtonLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        backImageButtonLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        backImageButtonLayoutParams.bottomMargin = Helper.formatPix(myContext, 30);
        backImageButtonLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        backImageButtonLayoutParams.rightMargin = Helper.formatPix(myContext, 30);
        backImageButtonLayoutParams.width = Helper.formatPix(myContext, (float)(76 * 1.2));
        backImageButtonLayoutParams.height = Helper.formatPix(myContext, (float)(76 * 1.2));
        contentRelativeLayout.addView(backImageButton, backImageButtonLayoutParams);
    }

    private void initFrameAnim() {
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inSampleSize = 3;

        frameAnim = new AnimationDrawable();
        for (int i = 0; i < 61; i++) {
            frameAnim.addFrame(new BitmapDrawable(BitmapFactory.decodeResource(getResources(), getResources().getIdentifier("frame_" + i, "mipmap", Helper.defPackage), opts)), 61);
        }

        frameImageView.setImageDrawable(frameAnim);

        frameAnim.setOneShot(true);
        frameAnim.start();
    }

    private Runnable frameRunnable = new Runnable() {
        public void run() {
            initFrameAnim();
        }
    };

    private Runnable menuRunnable = new Runnable() {
        public void run() {
            for(int i = 0; i < contentRelativeLayout.getChildCount(); i++) {
                View view = contentRelativeLayout.getChildAt(i);
                if(view instanceof MenuView) {
                    AlphaAnimation alphaAnim = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnim.setDuration(1000);
                    alphaAnim.setRepeatCount(0);
                    view.startAnimation(alphaAnim);

                    view.setVisibility(VISIBLE);
                }
            }
        }
    };
}
