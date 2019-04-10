package com.mouqukeji.myvideo.ui;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.mouqukeji.myvideo.R;
import com.mouqukeji.myvideo.ui.widget.AnimatorPath;
import com.mouqukeji.myvideo.ui.widget.PathEvaluator;
import com.mouqukeji.myvideo.ui.widget.PathPoint;
import com.mouqukeji.myvideo.utils.HyBounceInterpolator;

public class SplashActvitiy extends Activity  {
    private TextView fab;
    private TextView fab1;
    private TextView fab2;
    private AnimatorPath path;//声明动画集合
    private AnimatorPath otherpath;//声明动画集合
    private AnimatorPath other1path;//声明动画集合
    private Button button;
    private FrameLayout framelayout;
    private ImageView iv;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        this.fab = (TextView) findViewById(R.id.fab);
        this.fab1 = (TextView) findViewById(R.id.fab1);
        this.fab2 = (TextView) findViewById(R.id.fab2);
        framelayout = (FrameLayout) findViewById(R.id.framelayout);
        tv = (TextView) findViewById(R.id.tv);
        iv = (ImageView) findViewById(R.id.iv);
        button = (Button) findViewById(R.id.button);

        setPath();
        setOtherPath();
        setOther1Path();

        fab.setVisibility(View.VISIBLE);
        fab1.setVisibility(View.VISIBLE);
        fab2.setVisibility(View.VISIBLE);
        startAnimatorPath(fab, "fab", path);
        startAnimatorPath1(fab1, "fab1", otherpath);
        startAnimatorPath1(fab2, "fab2", other1path);
        WindowManager wm1 = this.getWindowManager();
        final int width1 = wm1.getDefaultDisplay().getWidth();
        final int height1 = wm1.getDefaultDisplay().getHeight();

        final Handler mHandler = new Handler();
        Runnable r = new Runnable() {

            @Override
            public void run() {
                //do something
                framelayout.setVisibility(View.VISIBLE);
                Animator animator = ViewAnimationUtils.createCircularReveal(framelayout, width1 / 2,
                        height1 / 2, 40f,
                        (float) Math.hypot(width1 / 2, height1 / 2));
                animator.setDuration(500);
                animator.setInterpolator(new AccelerateInterpolator());
                animator.start();
                Animation animation = AnimationUtils.loadAnimation(SplashActvitiy.this, R.anim.map_anim);
                animation.setInterpolator(new HyBounceInterpolator());
                iv.startAnimation(animation);
                //定义Animation对象
                Animation a = AnimationUtils.loadAnimation(SplashActvitiy.this,R.anim.scale);
                //开始动画
                tv.startAnimation(a);

            }
        };
        mHandler.postDelayed(r, 1000);//延时100毫秒
    }




    private void setOther1Path() {
        WindowManager wm1 = this.getWindowManager();
        int width1 = wm1.getDefaultDisplay().getWidth();
        int height1 = wm1.getDefaultDisplay().getHeight();
        other1path = new AnimatorPath();
        other1path.moveTo(width1 + width1 / 4, height1 / 2 + height1 / 4);
        other1path.secondBesselCurveTo(width1 - width1 / 3, height1 / 2-100 , width1 - width1 / 3 +350, height1 / 2 - 100); //订单
        other1path.thirdBesselCurveTo(width1/2 + 250, height1 / 2-150, width1 / 2 +350, height1 / 2 -350, width1 / 2+540, height1 / 2 -420);
    }


    private void setOtherPath() {
        WindowManager wm1 = this.getWindowManager();
        int width1 = wm1.getDefaultDisplay().getWidth();
        int height1 = wm1.getDefaultDisplay().getHeight();
        otherpath = new AnimatorPath();
        otherpath.moveTo(width1 + width1 / 4, height1 / 2 + height1 / 4);
        otherpath.secondBesselCurveTo(width1 - width1 / 4, height1 / 2 - 50, width1 - width1 / 3 - 200, height1 / 2 - 50); //订单
        otherpath.thirdBesselCurveTo(width1 / 2 - 200, height1 / 2 - 100, width1 / 2 - 200, height1 / 2 + 100, width1 / 2 - 50, height1 / 2 - 50);
    }

    /*设置动画路径*/
    public void setPath() {
        WindowManager wm1 = this.getWindowManager();
        int width1 = wm1.getDefaultDisplay().getWidth();
        int height1 = wm1.getDefaultDisplay().getHeight();
        path = new AnimatorPath();
        path.moveTo(-width1 / 4, height1 / 4);
        path.secondBesselCurveTo(width1 / 4, height1 / 2 + 50, width1 / 3 + 200, height1 / 2 + 50); //订单
        path.thirdBesselCurveTo(width1 / 2 + 200, height1 / 2 + 100, width1 / 2 + 200, height1 / 2 - 100, width1 / 2 - 50, height1 / 2 - 50);
    }

    /**
     * 设置动画
     *
     * @param view
     * @param propertyName
     * @param path
     */
    private void startAnimatorPath(View view, String propertyName, AnimatorPath path) {
        ObjectAnimator anim = ObjectAnimator.ofObject(this, propertyName, new PathEvaluator(), path.getPoints().toArray());
        anim.setInterpolator(new DecelerateInterpolator());//动画插值器
        anim.setDuration(1000);
        anim.start();
    }

    private void startAnimatorPath1(View view, String propertyName, AnimatorPath path) {
        ObjectAnimator anim = ObjectAnimator.ofObject(this, propertyName, new PathEvaluator(), path.getPoints().toArray());
        anim.setInterpolator(new DecelerateInterpolator());//动画插值器
        anim.setDuration(1000);
        anim.start();
    }


    /**
     * 设置View的属性通过ObjectAnimator.ofObject()的反射机制来调用
     *
     * @param newLoc
     */
    public void setFab(PathPoint newLoc) {
        fab.setTranslationX(newLoc.mX);
        fab.setTranslationY(newLoc.mY);
    }

    public void setFab1(PathPoint newLoc) {
        fab1.setTranslationX(newLoc.mX);
        fab1.setTranslationY(newLoc.mY);
    }
    public void setFab2(PathPoint newLoc) {
        fab2.setTranslationX(newLoc.mX);
        fab2.setTranslationY(newLoc.mY);
    }



}
