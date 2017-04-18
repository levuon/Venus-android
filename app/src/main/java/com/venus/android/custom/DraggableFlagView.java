//package com.venus.android.custom;
//
//import android.app.Activity;
//import android.content.Context;
//import android.content.res.TypedArray;
//import android.graphics.Canvas;
//import android.graphics.Paint;
//import android.graphics.Paint.Align;
//import android.graphics.Paint.FontMetrics;
//import android.graphics.Path;
//import android.graphics.Point;
//import android.support.v4.internal.view.SupportMenu;
//import android.support.v4.widget.AutoScrollHelper;
//import android.text.TextPaint;
//import android.util.AttributeSet;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.WindowManager;
//import android.widget.RelativeLayout.LayoutParams;
//
//import com.nineoldandroids.animation.ValueAnimator;
//import com.venus.android.R;
//
//import timber.log.Timber;
//
//public class DraggableFlagView extends View {
//    private static final String f = DraggableFlagView.class.getSimpleName();
//    LayoutParams a;
//    LayoutParams b;
//    Path c = new Path();
//    float d = AutoScrollHelper.NO_MAX;
//    float e = AutoScrollHelper.NO_MAX;
//    private OnDraggableFlagViewListener g;
//    private int h = SupportMenu.CATEGORY_MASK;
//    private Context i;
//    private int j;
//    private int k;
//    private int l;
//    private int m;
//    private boolean n;
//    private int o;
//    private int p;
//    private Point q = new Point();
//    private Point r = new Point();
//    private Paint s;
//    private TextPaint t;
//    private FontMetrics u;
//    private int[] v;
//    private boolean w;
////    private byn x = new byn(this);
//    private String y = "";
//    private boolean z = true;
//
//    public interface OnDraggableFlagViewListener {
//        void onFlagDismiss(DraggableFlagView draggableFlagView);
//    }
//
//    public void setOnDraggableFlagViewListener(OnDraggableFlagViewListener onDraggableFlagViewListener) {
//        this.g = onDraggableFlagViewListener;
//    }
//
//    public DraggableFlagView(Context context) {
//        super(context);
//        a(context);
//    }
//
//    public DraggableFlagView(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DraggableFlagView);
//        int indexCount = obtainStyledAttributes.getIndexCount();
//        for (int i = 0; i < indexCount; i++) {
//            int index = obtainStyledAttributes.getIndex(i);
//            if (index == 0) {
//                this.h = obtainStyledAttributes.getColor(index, SupportMenu.CATEGORY_MASK);
//            }
//        }
//        obtainStyledAttributes.recycle();
//        a(context);
//    }
//
//    public DraggableFlagView(Context context, AttributeSet attributeSet, int i) {
//        super(context, attributeSet, i);
//        a(context);
//    }
//
//    private void a(Context context) {
//        this.i = context;
//        setBackgroundColor(0);
//        this.s = new Paint();
//        this.s.setColor(this.h);
//        this.s.setAntiAlias(true);
//        this.t = new TextPaint();
//        this.t.setAntiAlias(true);
//        this.t.setColor(-1);
////        this.t.setTextSize((float) ABTextUtil.sp2px(context, 10.0f));
//        this.t.setTextAlign(Align.CENTER);
//        this.u = this.t.getFontMetrics();
//    }
//
//    protected void onSizeChanged(int i, int i2, int i3, int i4) {
//        super.onSizeChanged(i, i2, i3, i4);
//        if (this.z && i > 0 && i2 > 0) {
//            this.z = false;
//            this.k = i;
//            this.l = i2;
//            this.j = Math.min(this.k, this.l) / 2;
//            this.o = this.j;
//            this.p = this.j;
//            this.m = getDeviceHeight(this.i) / 6;
//            a();
//            ViewGroup.LayoutParams layoutParams = getLayoutParams();
//            if (LayoutParams.class.isAssignableFrom(layoutParams.getClass())) {
//                this.a = (LayoutParams) layoutParams;
//            }
//            this.b = new LayoutParams(layoutParams.width, layoutParams.height);
//        }
//    }
//
//    public int getDeviceHeight(Context context) {
//        return ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getHeight();
//    }
//
//    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
//        super.setLayoutParams(layoutParams);
//        a();
//    }
//
//    private void a() {
//        this.v = new int[2];
//        getLocationInWindow(this.v);
//        try {
//            this.v[1] = this.v[1] - getTopBarHeight((Activity) this.i);
//        } catch (Exception e) {
//        }
//        this.q.set(this.v[0], this.v[1] + getMeasuredHeight());
//    }
//
//    public int getTopBarHeight(Activity activity) {
////        return activity.getWindow().findViewById(16908290).getTop();
//        return 1;
//    }
//
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        canvas.drawColor(0);
//        int i;
//        int i2;
//        if (this.w) {
//            i = this.q.x + this.o;
//            i2 = this.q.y - this.o;
//            canvas.drawCircle((float) i, (float) i2, (float) this.o, this.s);
//            int i3 = this.r.x;
//            int i4 = this.r.y;
//            canvas.drawCircle((float) i3, (float) i4, (float) this.j, this.s);
//            if (!this.n) {
//                this.c.reset();
////                double d = this.x.b / this.x.c;
////                double d2 = this.x.a / this.x.c;
////                this.c.moveTo((float) (((double) i) - (((double) this.o) * d)), (float) (((double) i2) - (((double) this.o) * d2)));
////                this.c.lineTo((float) (((double) i) + (((double) this.o) * d)), (float) (((double) i2) + (((double) this.o) * d2)));
////                this.c.quadTo((float) ((i + i3) / 2), (float) ((i2 + i4) / 2), (float) (((double) i3) + (((double) this.j) * d)), (float) (((double) i4) + (((double) this.j) * d2)));
////                this.c.lineTo((float) (((double) i3) - (((double) this.j) * d)), (float) (((double) i4) - (((double) this.j) * d2)));
////                this.c.quadTo((float) ((i + i3) / 2), (float) ((i2 + i4) / 2), (float) (((double) i) - (d * ((double) this.o))), (float) (((double) i2) - (d2 * ((double) this.o))));
//                canvas.drawPath(this.c, this.s);
//            }
//            float f = (-this.u.ascent) - this.u.descent;
//            canvas.drawText(this.y, (float) i3, (f / 2.0f) + ((float) i4), this.t);
//        } else if (this.o > 0) {
//            i = this.o;
//            i2 = this.l - this.o;
//            canvas.drawCircle((float) i, (float) i2, (float) this.o, this.s);
//            if (this.o == this.j) {
//                float f2 = (-this.u.ascent) - this.u.descent;
//                canvas.drawText(this.y, (float) i, ((float) i2) + (f2 / 2.0f), this.t);
//            }
//        }
//    }
//
//    public boolean onTouchEvent(MotionEvent motionEvent) {
//        super.onTouchEvent(motionEvent);
//        switch (motionEvent.getAction()) {
//            case 0:
//                this.w = true;
//                setLayoutParams(this.b);
//                this.r.x = (int) this.d;
//                this.r.y = (int) this.e;
//                a(this, -1, -1);
//                postInvalidate();
//                this.d = motionEvent.getX() + ((float) this.v[0]);
//                this.e = motionEvent.getY() + ((float) this.v[1]);
//                break;
//            case 1:
//                this.w = false;
//                setLayoutParams(this.a);
//                if (this.n) {
//                    a(this, this.k, this.l);
//                    postInvalidate();
//                    if (this.g != null) {
//                        this.g.onFlagDismiss(this);
//                    }
//                    Timber.d(f, "触发事件...");
//                    b();
//                } else {
//                    a(this, this.k, this.l);
//                    a(500);
//                }
//                this.d = AutoScrollHelper.NO_MAX;
//                this.e = AutoScrollHelper.NO_MAX;
//                break;
//            case 2:
////                this.x.a = (double) (motionEvent.getX() - this.d);
////                this.x.b = (double) (-1.0f * (motionEvent.getY() - this.e));
////                double sqrt = Math.sqrt((this.x.a * this.x.a) + (this.x.b * this.x.b));
////                this.x.c = sqrt;
////                a((int) sqrt);
//                this.r.x = (int) motionEvent.getX();
//                this.r.y = (int) motionEvent.getY();
//                postInvalidate();
//                break;
//        }
//        return true;
//    }
//
//    private void b() {
//        setVisibility(INVISIBLE);
//        this.y = "";
//        this.n = false;
//        this.o = this.j;
//        postInvalidate();
//    }
//
//    private void a(int i) {
//        if (i > this.m) {
//            this.n = true;
//            this.o = 0;
//            return;
//        }
//        this.n = false;
////        this.o = (int) Math.max((1.0f - ((((float) i) * 1.0f) / ((float) this.m))) * ((float) this.j), (float) ABTextUtil.dip2px(this.i, 2.0f));
//    }
//
//    private void a(View view, int i, int i2) {
//        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
//        if (layoutParams == null) {
//            layoutParams = this.a;
//        }
//        layoutParams.width = i;
//        layoutParams.height = i2;
//        view.setLayoutParams(layoutParams);
//    }
//
//    private void a(long j) {
//        ValueAnimator ofFloat = ValueAnimator.ofFloat((float) this.o, (float) this.j);
////        ofFloat.addUpdateListener(new byl(this));
////        ofFloat.setInterpolator(new BounceInterpolator());
////        ofFloat.addListener(new bym(this));
//        ofFloat.setDuration(j);
//        ofFloat.start();
//    }
//
//    public String getText() {
//        return this.y;
//    }
//
//    public void setText(String str) {
//        this.y = str;
//        setVisibility(0);
//        postInvalidate();
//    }
//}
