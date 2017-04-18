package com.venus.android.custom;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.venus.android.R;
import com.venus.android.custom.listener.AppBarClick;
import com.venus.android.custom.listener.AppBarLeftClick;
import com.venus.android.custom.listener.AppBarRightClick;
import com.venus.android.custom.listener.AppBarTitleClick;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by lev on 5/24/16.
 */
public class AppBar extends FrameLayout {
    private Context context;
    private View view;
    @InjectView(R.id.iv_base_divider)
    ImageView ivBaseDivider;
    @InjectView(R.id.iv_navigation_header_left)
    ImageView ivNavigationHeaderLeft;
    @InjectView(R.id.iv_navigation_header_right)
    ImageView ivNavigationHeaderRight;
    @InjectView(R.id.iv_title_image)
    ImageView ivTitleImage;
    @InjectView(R.id.iv_trade_list_down_arrow)
    ImageView ivTradeListDownArrow;
    @InjectView(R.id.layout_navigation_header)
    RelativeLayout layoutNavigationHeader;
    @InjectView(R.id.ll_title)
    LinearLayout llTitle;
    @InjectView(R.id.rl_navigation_left)
    RelativeLayout rlNavigationLeft;
    @InjectView(R.id.rl_navigation_right)
    RelativeLayout rlNavigationRight;
    @InjectView(R.id.rl_title_date)
    RelativeLayout rlTitleDate;
    @InjectView(R.id.tv_date)
    TextView tvDate;
    @InjectView(R.id.tv_navigation_header_left)
    TextView tvNavigationHeaderLeft;
    @InjectView(R.id.tv_navigation_header_right)
    TextView tvNavigationHeaderRight;
    @InjectView(R.id.tv_naviation_title)
    TextView tvNavigationTitle;


    public interface OnLeftClickListener {
        void onClick(View view);
    }

    public interface OnRightClickListener {
        void onClick(View view);
    }

    public interface OnTitleClickListener {
        void onClick(View view);
    }

    public AppBar(Context context) {
        super(context);
        setContext(context);
    }

    public AppBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setContext(context);
    }

    public AppBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContext(context);
    }

    private void setContext(Context context) {
        this.context = context;
        this.view = LayoutInflater.from(this.context).inflate(R.layout.include_layout_header, this);
        ButterKnife.inject(this.view);
    }

    public void setLeftNavigation(String str, OnLeftClickListener onLeftClickListener) {
        this.tvNavigationHeaderLeft.setVisibility(VISIBLE);
        this.ivNavigationHeaderLeft.setVisibility(INVISIBLE);
        this.tvNavigationHeaderLeft.setText(str);
        this.rlNavigationLeft.setOnClickListener(AppBarLeftClick.getLeftClickListener(onLeftClickListener));
    }

    public void setLeftNavigation(int i, OnLeftClickListener onLeftClickListener) throws Resources.NotFoundException {
        if (this.context.getResources().getDrawable(i) == null) {
            throw new Resources.NotFoundException("the resource id not found in drawable");
        }
        this.ivNavigationHeaderLeft.setVisibility(VISIBLE);
        this.tvNavigationHeaderLeft.setVisibility(INVISIBLE);
        this.ivNavigationHeaderLeft.setImageResource(i);
        this.rlNavigationLeft.setOnClickListener(AppBarLeftClick.getLeftClickListener(onLeftClickListener));
    }

    public void setRightNavigation(String str, OnRightClickListener onRightClickListener) {
        this.tvNavigationHeaderRight.setVisibility(VISIBLE);
        this.tvNavigationHeaderRight.setText(str);
        this.rlNavigationRight.setOnClickListener(AppBarRightClick.getRightClickListener(onRightClickListener));
    }

    public void setRightNavigation(int i, OnRightClickListener onRightClickListener) throws Resources.NotFoundException {
        if (this.context.getResources().getDrawable(i) == null) {
            throw new Resources.NotFoundException("the resource id not found in drawable");
        }
        this.ivNavigationHeaderRight.setVisibility(VISIBLE);
        this.ivNavigationHeaderRight.setImageResource(i);
        this.rlNavigationRight.setOnClickListener(AppBarRightClick.getRightClickListener(onRightClickListener));
    }

    public void setRightBackgroundNavigation(int i, OnRightClickListener onRightClickListener) throws Resources.NotFoundException {
        if (this.context.getResources().getDrawable(i) == null) {
            throw new Resources.NotFoundException("the resource id not found in drawable");
        }
        this.ivNavigationHeaderRight.setVisibility(VISIBLE);
        this.ivNavigationHeaderRight.setBackgroundResource(i);
        this.rlNavigationRight.setOnClickListener(AppBarRightClick.getRightClickListener(onRightClickListener));
    }

    public void setShowLeft(boolean z) {
        if (z) {
            this.tvNavigationHeaderLeft.setVisibility(VISIBLE);
            this.ivNavigationHeaderLeft.setVisibility(VISIBLE);
            return;
        }
        this.tvNavigationHeaderLeft.setVisibility(INVISIBLE);
        this.ivNavigationHeaderLeft.setVisibility(INVISIBLE);
    }

    public void setShowRight(boolean z) {
        if (z) {
            this.tvNavigationHeaderRight.setVisibility(VISIBLE);
            this.ivNavigationHeaderRight.setVisibility(VISIBLE);
            return;
        }
        this.tvNavigationHeaderRight.setVisibility(INVISIBLE);
        this.ivNavigationHeaderRight.setVisibility(INVISIBLE);
    }

    public void setTitle(String str) {
        this.llTitle.setVisibility(VISIBLE);
        this.rlTitleDate.setVisibility(INVISIBLE);
        this.tvNavigationTitle.setText(str);
    }

    public void setTitle(int i) {
        this.llTitle.setVisibility(VISIBLE);
        this.rlTitleDate.setVisibility(INVISIBLE);
        this.tvNavigationTitle.setText(i);
        this.tvNavigationTitle.setOnClickListener(AppBarClick.onClick());
    }

    public static /* synthetic */ void setView(View view) {
    }

    public void setTitle(String str, OnTitleClickListener onTitleClickListener) {
        this.llTitle.setVisibility(VISIBLE);
        this.rlTitleDate.setVisibility(INVISIBLE);
        this.tvNavigationTitle.setText(str);
        this.llTitle.setOnClickListener(AppBarTitleClick.getTitleClickListner(onTitleClickListener));
    }

    public void setTradeTitle(String str, OnTitleClickListener onTitleClickListener) {
        this.llTitle.setVisibility(INVISIBLE);
        this.rlTitleDate.setVisibility(VISIBLE);
        this.tvDate.setText(str);
        this.rlTitleDate.setOnClickListener(AppBarTitleClick.getTitleClickListner(onTitleClickListener));
    }

    public void setShowTitleImage(boolean flag) {
        if (flag) {
            this.ivTitleImage.setVisibility(VISIBLE);
        } else {
            this.ivTitleImage.setVisibility(INVISIBLE);
        }
    }

    public void setBackgroundResourceX(int i) {
        this.view.setBackgroundResource(i);
    }

    public void setBackgroundColorX(int i) {
        this.view.setBackgroundColor(i);
    }

    public void setAlphaX(float f) {
        this.view.setAlpha(f);
    }
}
