package com.peng.administrator.myobjectkotlin;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * $desc$
 * 作   者 :彭付林
 * 邮   箱 :pengfl@kingchannels.com
 * 日   期 :2019/12/5
 * 描   述 :个人信息
 */
public class UMExpandLayout extends RelativeLayout {
    private View layoutView;
    private int viewHeight;
    private boolean isExpand;
    private long animationDuation;

    public UMExpandLayout(@NonNull Context context) {
        super(context);
        initView();
    }

    public UMExpandLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public UMExpandLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }

    private void initView() {
        layoutView = this;
        isExpand = false;
        animationDuation = 300;
//        reSetViewDimensions();
        setViewDimensions();
    }

    public void initExpand(boolean isExpand) {
        this.isExpand = isExpand;
        if (!isExpand) {
            animateToggle(10);
        }
    }

    /**
     * 设置动画时间
     */
    public void setAnimationDuation(long animationDuation) {
        this.animationDuation = animationDuation;
    }

    private void setViewDimensions() {
        layoutView.post(new Runnable() {
            @Override
            public void run() {
                if (viewHeight <= 0)
//                viewHeight = layoutView.getMeasuredHeight();
                    viewHeight = 200;
            }
        });
    }

    public static void setViewHeight(View view, int height) {
        final ViewGroup.LayoutParams params = view.getLayoutParams();
        params.height = height;
        view.requestLayout();
    }

    /**
     * 切换动画实现
     */
    private void animateToggle(long animationDuation) {
        ValueAnimator heightAnimation = isExpand ?
                ValueAnimator.ofFloat(0f, viewHeight) : ValueAnimator.ofFloat(viewHeight, 0f);
        heightAnimation.setDuration(animationDuation / 2);
        //延迟1000ms后执行,需要在start()前调用
        heightAnimation.setStartDelay(animationDuation / 2);
        heightAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float var = (float) animation.getAnimatedValue();
                Log.i("onAnimationUpdate", "---->onAnimationUpdate = " + var);
                setViewHeight(layoutView, (int) var);
            }
        });
        heightAnimation.start();
    }

    public boolean isExpand() {
        return isExpand;
    }

    /**
     * 折叠view
     */
    public void collapse() {
        isExpand = false;
        animateToggle(animationDuation);
    }

    /**
     * 展开view
     */
    public void expand() {
        isExpand = true;
        animateToggle(animationDuation);
    }

    public void toggleExpend() {
        if (isExpand) {
            collapse();
        } else {
            expand();
        }
    }

    public void reSetViewDimensions() {
        layoutView.post(new Runnable() {
            @Override
            public void run() {
                viewHeight = layoutView.getMeasuredHeight();
            }
        });
    }
}
