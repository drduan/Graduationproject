package com.example.xudong.myapplication.behavior;

/**                              _
 *  _._ _..._ .-',     _.._(`))
 * '-. `     '  /-._.-'    ',/
 *    )         \            '.
 *   / _    _    |             \
 *  |  a    a    /              |
 *  \   .-.                     ;
 *   '-('' ).-'       ,'       ;
 *      '-;           |      .'
 *         \           \    /
 *         | 7  .__  _.-\   \
 *         | |  |  ``/  /`  /
 *        /,_|  |   /,_/   /
 *           /,_/      '`-'
 */



import android.animation.ValueAnimator;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.example.xudong.myapplication.R;



/**
 * Created by SidHu on 2016/8/17.
 */
public class HideHeadBehavior extends BaseBehavior implements NestedScrollingChild {

    private boolean isHeadHide = false;
    private boolean isAnimating = false;
    private final int UP_SCROOL_VALUE = 100;
    private final int DOWN_SCROOL_VALUE = 100;
    private int childHeight;
    private final int animationDuration = 500;

    private NestedScrollingChildHelper childHelper;

    public HideHeadBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {






        if (target.getId() == R.id.rel_body) {
            if (childHeight == 0) {
                childHeight = child.getHeight();
            }
            if (childHelper == null) {
                childHelper = new NestedScrollingChildHelper(child);
            }

            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        if (isAnimating) {
            return;
        }



        if (dy > UP_SCROOL_VALUE && !isHeadHide && behaviorcontext.FirstShow) {
            hide(child, target);
            isHeadHide = true;
            behaviorcontext.FirstShow = false;

        }

        else if (dy < -DOWN_SCROOL_VALUE && isHeadHide && behaviorcontext.SecondSHow) {

//            Log.d("@@",""+dy+"\t"+isHeadHide+"\t"+behaviorcontext.SecondSHow);
            show(child, target);
            isHeadHide = false;
            behaviorcontext.FirstShow = true;
        }
    }


    public void hide(final View child, final View target) {

        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, childHeight);
        valueAnimator.setDuration(animationDuration);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                if (child.getBottom() > 0) {
                    int value = (int) animation.getAnimatedValue();
                    isAnimating = value != childHeight;
                    child.layout(child.getLeft(), -value, child.getRight(), -value + childHeight);
                    target.layout(target.getLeft(), -value + childHeight, target.getRight(), target.getBottom());
                    Log.d("@@@@@","-value"+ -value+childHeight+"targetbottom"+target.getBottom());
                }
            }
        });
        valueAnimator.start();

    }

    public void show(final View child, final View target) {

        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, childHeight);
        valueAnimator.setDuration(animationDuration);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                if (child.getBottom() < childHeight) {
                    int value = (int) animation.getAnimatedValue();
                    isAnimating = value != childHeight;
                    child.layout(child.getLeft(), value - childHeight, child.getRight(), value);
                    target.layout(target.getLeft(), value, target.getRight(), target.getBottom());
                }
            }
        });
        valueAnimator.start();

    }

    @Override
    public void setNestedScrollingEnabled(boolean enabled) {
        childHelper.setNestedScrollingEnabled(enabled);
    }

    @Override
    public boolean isNestedScrollingEnabled() {
        return childHelper.isNestedScrollingEnabled();
    }




    @Override
    public boolean startNestedScroll(int axes) {
        return childHelper.startNestedScroll(axes);
    }

    @Override
    public void stopNestedScroll() {
        childHelper.stopNestedScroll();
    }

    @Override
    public boolean hasNestedScrollingParent() {
        return childHelper.hasNestedScrollingParent();
    }

    @Override
    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow) {
        return childHelper.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow);
    }

    @Override
    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow) {


        return childHelper.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow);
    }

    @Override
    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
        return childHelper.dispatchNestedFling(velocityX, velocityY, consumed);
    }

    @Override
    public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
        return childHelper.dispatchNestedPreFling(velocityX, velocityY);
    }
}