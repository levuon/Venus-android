//package com.venus.android.view;
//
//import android.content.Context;
//import android.content.res.TypedArray;
//import android.graphics.Canvas;
//import android.graphics.Rect;
//import android.graphics.drawable.Drawable;
//import android.os.Build.VERSION;
//import android.os.Parcel;
//import android.os.Parcelable;
//import android.os.SystemClock;
//import android.support.annotation.CallSuper;
//import android.support.annotation.DrawableRes;
//import android.support.v4.os.ParcelableCompat;
//import android.support.v4.view.KeyEventCompat;
//import android.support.v4.view.MotionEventCompat;
//import android.support.v4.view.PagerAdapter;
//import android.support.v4.view.VelocityTrackerCompat;
//import android.support.v4.view.ViewCompat;
//import android.support.v4.view.ViewConfigurationCompat;
//import android.support.v4.widget.AutoScrollHelper;
//import android.support.v4.widget.EdgeEffectCompat;
//import android.util.AttributeSet;
//import android.util.Log;
//import android.view.FocusFinder;
//import android.view.KeyEvent;
//import android.view.MotionEvent;
//import android.view.SoundEffectConstants;
//import android.view.VelocityTracker;
//import android.view.View;
//import android.view.ViewConfiguration;
//import android.view.ViewGroup;
//import android.view.ViewParent;
//import android.view.accessibility.AccessibilityEvent;
//import android.view.animation.Interpolator;
//import android.widget.Scroller;
//
//import java.lang.reflect.Method;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.List;
//
//import defpackage.tz;
//import defpackage.ua;
//import defpackage.ub;
//import defpackage.uc;
//import defpackage.ud;
//import defpackage.ue;
//import defpackage.uf;
//import defpackage.ug;
//import defpackage.uh;
//import defpackage.ui;
//import defpackage.uj;
//import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
//
//public class ViewPager extends ViewGroup {
//    public static final int SCROLL_STATE_DRAGGING = 1;
//    public static final int SCROLL_STATE_IDLE = 0;
//    public static final int SCROLL_STATE_SETTLING = 2;
//    private static final int[] a = new int[]{16842931};
//    private static final uj aj = new uj();
//    private static final Comparator<ue> c = new tz();
//    private static final Interpolator d = new ua();
//    private int A = 1;
//    private boolean B;
//    private boolean C;
//    private int D;
//    private int E;
//    private int F;
//    private float G;
//    private float H;
//    private float I;
//    private float J;
//    private int K = -1;
//    private VelocityTracker L;
//    private int M;
//    private int N;
//    private int O;
//    private int P;
//    private boolean Q;
//    private long R;
//    private EdgeEffectCompat S;
//    private EdgeEffectCompat T;
//    private boolean U = true;
//    private boolean V = false;
//    private boolean W;
//    private int aa;
//    private List<OnPageChangeListener> ab;
//    private OnPageChangeListener ac;
//    private OnPageChangeListener ad;
//    private ug ae;
//    private PageTransformer af;
//    private Method ag;
//    private int ah;
//    private ArrayList<View> ai;
//    private final Runnable ak = new ub(this);
//    private int al = 0;
//    private int b;
//    private final ArrayList<ue> e = new ArrayList();
//    private final ue f = new ue();
//    private final Rect g = new Rect();
//    private PagerAdapter h;
//    private int i;
//    private int j = -1;
//    private Parcelable k = null;
//    private ClassLoader l = null;
//    private Scroller m;
//    private boolean n;
//    private uh o;
//    private int p;
//    private Drawable q;
//    private int r;
//    private int s;
//    private float t = -3.4028235E38f;
//    private float u = AutoScrollHelper.NO_MAX;
//    private int v;
//    private int w;
//    private boolean x;
//    private boolean y;
//    private boolean z;
//
//    public interface OnPageChangeListener {
//        void onPageScrollStateChanged(int i);
//
//        void onPageScrolled(int i, float f, int i2);
//
//        void onPageSelected(int i);
//    }
//
//    public class LayoutParams extends ViewGroup.LayoutParams {
//        float a = 0.0f;
//        boolean b;
//        public int c;
//        int d;
//        public int gravity;
//        public boolean isDecor;
//
//        public LayoutParams() {
//            super(-1, -1);
//        }
//
//        public LayoutParams(Context context, AttributeSet attributeSet) {
//            super(context, attributeSet);
//            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v4.view.ViewPager.a);
//            this.gravity = obtainStyledAttributes.getInteger(0, 48);
//            obtainStyledAttributes.recycle();
//        }
//    }
//
//    public interface PageTransformer {
//        void transformPage(View view, float f);
//    }
//
//    public static class SavedState extends BaseSavedState {
//        public static final Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ui());
//        int a;
//        Parcelable b;
//        ClassLoader c;
//
//        public SavedState(Parcelable parcelable) {
//            super(parcelable);
//        }
//
//        public void writeToParcel(Parcel parcel, int i) {
//            super.writeToParcel(parcel, i);
//            parcel.writeInt(this.a);
//            parcel.writeParcelable(this.b, i);
//        }
//
//        public String toString() {
//            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.a + "}";
//        }
//
//        public SavedState(Parcel parcel, ClassLoader classLoader) {
//            super(parcel);
//            if (classLoader == null) {
//                classLoader = getClass().getClassLoader();
//            }
//            this.a = parcel.readInt();
//            this.b = parcel.readParcelable(classLoader);
//            this.c = classLoader;
//        }
//    }
//
//    public class SimpleOnPageChangeListener implements OnPageChangeListener {
//        public void onPageScrolled(int i, float f, int i2) {
//        }
//
//        public void onPageSelected(int i) {
//        }
//
//        public void onPageScrollStateChanged(int i) {
//        }
//    }
//
//    public ViewPager(Context context) {
//        super(context);
//        a();
//    }
//
//    public ViewPager(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//        a();
//    }
//
//    void a() {
//        setWillNotDraw(false);
//        setDescendantFocusability(262144);
//        setFocusable(true);
//        Context context = getContext();
//        this.m = new Scroller(context, d);
//        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
//        float f = context.getResources().getDisplayMetrics().density;
//        this.F = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
//        this.M = (int) (400.0f * f);
//        this.N = viewConfiguration.getScaledMaximumFlingVelocity();
//        this.S = new EdgeEffectCompat(context);
//        this.T = new EdgeEffectCompat(context);
//        this.O = (int) (25.0f * f);
//        this.P = (int) (2.0f * f);
//        this.D = (int) (16.0f * f);
//        ViewCompat.setAccessibilityDelegate(this, new uf(this));
//        if (ViewCompat.getImportantForAccessibility(this) == 0) {
//            ViewCompat.setImportantForAccessibility(this, 1);
//        }
//        ViewCompat.setOnApplyWindowInsetsListener(this, new uc(this));
//    }
//
//    protected void onDetachedFromWindow() {
//        removeCallbacks(this.ak);
//        if (!(this.m == null || this.m.isFinished())) {
//            this.m.abortAnimation();
//        }
//        super.onDetachedFromWindow();
//    }
//
//    private void setScrollState(int i) {
//        if (this.al != i) {
//            this.al = i;
//            if (this.af != null) {
//                b(i != 0);
//            }
//            e(i);
//        }
//    }
//
//    public void setAdapter(PagerAdapter pagerAdapter) {
//        if (this.h != null) {
//            this.h.a(null);
//            this.h.startUpdate((ViewGroup) this);
//            for (int i = 0; i < this.e.size(); i++) {
//                ue ueVar = (ue) this.e.get(i);
//                this.h.destroyItem((ViewGroup) this, ueVar.b, ueVar.a);
//            }
//            this.h.finishUpdate((ViewGroup) this);
//            this.e.clear();
//            g();
//            this.i = 0;
//            scrollTo(0, 0);
//        }
//        PagerAdapter pagerAdapter2 = this.h;
//        this.h = pagerAdapter;
//        this.b = 0;
//        if (this.h != null) {
//            if (this.o == null) {
//                this.o = new uh();
//            }
//            this.h.a(this.o);
//            this.z = false;
//            boolean z = this.U;
//            this.U = true;
//            this.b = this.h.getCount();
//            if (this.j >= 0) {
//                this.h.restoreState(this.k, this.l);
//                a(this.j, false, true);
//                this.j = -1;
//                this.k = null;
//                this.l = null;
//            } else if (z) {
//                requestLayout();
//            } else {
//                c();
//            }
//        }
//        if (this.ae != null && pagerAdapter2 != pagerAdapter) {
//            this.ae.a(pagerAdapter2, pagerAdapter);
//        }
//    }
//
//    private void g() {
//        int i = 0;
//        while (i < getChildCount()) {
//            if (!((LayoutParams) getChildAt(i).getLayoutParams()).isDecor) {
//                removeViewAt(i);
//                i--;
//            }
//            i++;
//        }
//    }
//
//    public PagerAdapter getAdapter() {
//        return this.h;
//    }
//
//    void setOnAdapterChangeListener(ug ugVar) {
//        this.ae = ugVar;
//    }
//
//    private int getClientWidth() {
//        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
//    }
//
//    public void setCurrentItem(int i) {
//        boolean z;
//        this.z = false;
//        if (this.U) {
//            z = false;
//        } else {
//            z = true;
//        }
//        a(i, z, false);
//    }
//
//    public void setCurrentItem(int i, boolean z) {
//        this.z = false;
//        a(i, z, false);
//    }
//
//    public int getCurrentItem() {
//        return this.i;
//    }
//
//    void a(int i, boolean z, boolean z2) {
//        a(i, z, z2, 0);
//    }
//
//    void a(int i, boolean z, boolean z2, int i2) {
//        boolean z3 = false;
//        if (this.h == null || this.h.getCount() <= 0) {
//            setScrollingCacheEnabled(false);
//        } else if (z2 || this.i != i || this.e.size() == 0) {
//            if (i < 0) {
//                i = 0;
//            } else if (i >= this.h.getCount()) {
//                i = this.h.getCount() - 1;
//            }
//            int i3 = this.A;
//            if (i > this.i + i3 || i < this.i - i3) {
//                for (int i4 = 0; i4 < this.e.size(); i4++) {
//                    ((ue) this.e.get(i4)).c = true;
//                }
//            }
//            if (this.i != i) {
//                z3 = true;
//            }
//            if (this.U) {
//                this.i = i;
//                if (z3) {
//                    d(i);
//                }
//                requestLayout();
//                return;
//            }
//            a(i);
//            a(i, z, i2, z3);
//        } else {
//            setScrollingCacheEnabled(false);
//        }
//    }
//
//    private void a(int i, boolean z, int i2, boolean z2) {
//        int max;
//        ue b = b(i);
//        if (b != null) {
//            max = (int) (Math.max(this.t, Math.min(b.e, this.u)) * ((float) getClientWidth()));
//        } else {
//            max = 0;
//        }
//        if (z) {
//            a(max, 0, i2);
//            if (z2) {
//                d(i);
//                return;
//            }
//            return;
//        }
//        if (z2) {
//            d(i);
//        }
//        a(false);
//        scrollTo(max, 0);
//        c(max);
//    }
//
//    @Deprecated
//    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
//        this.ac = onPageChangeListener;
//    }
//
//    public void addOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
//        if (this.ab == null) {
//            this.ab = new ArrayList();
//        }
//        this.ab.add(onPageChangeListener);
//    }
//
//    public void removeOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
//        if (this.ab != null) {
//            this.ab.remove(onPageChangeListener);
//        }
//    }
//
//    public void clearOnPageChangeListeners() {
//        if (this.ab != null) {
//            this.ab.clear();
//        }
//    }
//
//    public void setPageTransformer(boolean z, PageTransformer pageTransformer) {
//        int i = 1;
//        if (VERSION.SDK_INT >= 11) {
//            boolean z2;
//            boolean z3 = pageTransformer != null;
//            if (this.af != null) {
//                z2 = true;
//            } else {
//                z2 = false;
//            }
//            int i2 = z3 != z2 ? 1 : 0;
//            this.af = pageTransformer;
//            setChildrenDrawingOrderEnabledCompat(z3);
//            if (z3) {
//                if (z) {
//                    i = 2;
//                }
//                this.ah = i;
//            } else {
//                this.ah = 0;
//            }
//            if (i2 != 0) {
//                c();
//            }
//        }
//    }
//
//    void setChildrenDrawingOrderEnabledCompat(boolean z) {
//        if (VERSION.SDK_INT >= 7) {
//            if (this.ag == null) {
//                try {
//                    this.ag = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
//                } catch (Throwable e) {
//                    Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e);
//                }
//            }
//            try {
//                this.ag.invoke(this, new Object[]{Boolean.valueOf(z)});
//            } catch (Throwable e2) {
//                Log.e("ViewPager", "Error changing children drawing order", e2);
//            }
//        }
//    }
//
//    protected int getChildDrawingOrder(int i, int i2) {
//        if (this.ah == 2) {
//            i2 = (i - 1) - i2;
//        }
//        return ((LayoutParams) ((View) this.ai.get(i2)).getLayoutParams()).d;
//    }
//
//    OnPageChangeListener a(OnPageChangeListener onPageChangeListener) {
//        OnPageChangeListener onPageChangeListener2 = this.ad;
//        this.ad = onPageChangeListener;
//        return onPageChangeListener2;
//    }
//
//    public int getOffscreenPageLimit() {
//        return this.A;
//    }
//
//    public void setOffscreenPageLimit(int i) {
//        if (i < 1) {
//            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to " + 1);
//            i = 1;
//        }
//        if (i != this.A) {
//            this.A = i;
//            c();
//        }
//    }
//
//    public void setPageMargin(int i) {
//        int i2 = this.p;
//        this.p = i;
//        int width = getWidth();
//        a(width, width, i, i2);
//        requestLayout();
//    }
//
//    public int getPageMargin() {
//        return this.p;
//    }
//
//    public void setPageMarginDrawable(Drawable drawable) {
//        this.q = drawable;
//        if (drawable != null) {
//            refreshDrawableState();
//        }
//        setWillNotDraw(drawable == null);
//        invalidate();
//    }
//
//    public void setPageMarginDrawable(@DrawableRes int i) {
//        setPageMarginDrawable(getContext().getResources().getDrawable(i));
//    }
//
//    protected boolean verifyDrawable(Drawable drawable) {
//        return super.verifyDrawable(drawable) || drawable == this.q;
//    }
//
//    protected void drawableStateChanged() {
//        super.drawableStateChanged();
//        Drawable drawable = this.q;
//        if (drawable != null && drawable.isStateful()) {
//            drawable.setState(getDrawableState());
//        }
//    }
//
//    float a(float f) {
//        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
//    }
//
//    void a(int i, int i2, int i3) {
//        if (getChildCount() == 0) {
//            setScrollingCacheEnabled(false);
//            return;
//        }
//        int i4;
//        boolean z = (this.m == null || this.m.isFinished()) ? false : true;
//        if (z) {
//            int currX = this.n ? this.m.getCurrX() : this.m.getStartX();
//            this.m.abortAnimation();
//            setScrollingCacheEnabled(false);
//            i4 = currX;
//        } else {
//            i4 = getScrollX();
//        }
//        int scrollY = getScrollY();
//        int i5 = i - i4;
//        int i6 = i2 - scrollY;
//        if (i5 == 0 && i6 == 0) {
//            a(false);
//            c();
//            setScrollState(0);
//            return;
//        }
//        setScrollingCacheEnabled(true);
//        setScrollState(2);
//        currX = getClientWidth();
//        int i7 = currX / 2;
//        float a = (((float) i7) * a(Math.min(1.0f, (((float) Math.abs(i5)) * 1.0f) / ((float) currX)))) + ((float) i7);
//        int abs = Math.abs(i3);
//        if (abs > 0) {
//            currX = Math.round(1000.0f * Math.abs(a / ((float) abs))) * 4;
//        } else {
//            currX = (int) (((((float) Math.abs(i5)) / ((((float) currX) * this.h.getPageWidth(this.i)) + ((float) this.p))) + 1.0f) * 100.0f);
//        }
//        i7 = Math.min(currX, SettingsJsonConstants.ANALYTICS_FLUSH_INTERVAL_SECS_DEFAULT);
//        this.n = false;
//        this.m.startScroll(i4, scrollY, i5, i6, i7);
//        ViewCompat.postInvalidateOnAnimation(this);
//    }
//
//    ue a(int i, int i2) {
//        ue ueVar = new ue();
//        ueVar.b = i;
//        ueVar.a = this.h.instantiateItem((ViewGroup) this, i);
//        ueVar.d = this.h.getPageWidth(i);
//        if (i2 < 0 || i2 >= this.e.size()) {
//            this.e.add(ueVar);
//        } else {
//            this.e.add(i2, ueVar);
//        }
//        return ueVar;
//    }
//
//    public void b() {
//        int count = this.h.getCount();
//        this.b = count;
//        boolean z = this.e.size() < (this.A * 2) + 1 && this.e.size() < count;
//        boolean z2 = false;
//        int i = this.i;
//        boolean z3 = z;
//        int i2 = 0;
//        while (i2 < this.e.size()) {
//            int i3;
//            boolean z4;
//            int i4;
//            boolean z5;
//            ue ueVar = (ue) this.e.get(i2);
//            int itemPosition = this.h.getItemPosition(ueVar.a);
//            if (itemPosition == -1) {
//                i3 = i2;
//                z4 = z2;
//                i4 = i;
//                z5 = z3;
//            } else if (itemPosition == -2) {
//                this.e.remove(i2);
//                i2--;
//                if (!z2) {
//                    this.h.startUpdate((ViewGroup) this);
//                    z2 = true;
//                }
//                this.h.destroyItem((ViewGroup) this, ueVar.b, ueVar.a);
//                if (this.i == ueVar.b) {
//                    i3 = i2;
//                    z4 = z2;
//                    i4 = Math.max(0, Math.min(this.i, count - 1));
//                    z5 = true;
//                } else {
//                    i3 = i2;
//                    z4 = z2;
//                    i4 = i;
//                    z5 = true;
//                }
//            } else if (ueVar.b != itemPosition) {
//                if (ueVar.b == this.i) {
//                    i = itemPosition;
//                }
//                ueVar.b = itemPosition;
//                i3 = i2;
//                z4 = z2;
//                i4 = i;
//                z5 = true;
//            } else {
//                i3 = i2;
//                z4 = z2;
//                i4 = i;
//                z5 = z3;
//            }
//            z3 = z5;
//            i = i4;
//            z2 = z4;
//            i2 = i3 + 1;
//        }
//        if (z2) {
//            this.h.finishUpdate((ViewGroup) this);
//        }
//        Collections.sort(this.e, c);
//        if (z3) {
//            i4 = getChildCount();
//            for (i2 = 0; i2 < i4; i2++) {
//                LayoutParams layoutParams = (LayoutParams) getChildAt(i2).getLayoutParams();
//                if (!layoutParams.isDecor) {
//                    layoutParams.a = 0.0f;
//                }
//            }
//            a(i, false, true);
//            requestLayout();
//        }
//    }
//
//    public void c() {
//        a(this.i);
//    }
//
//    /* JADX WARNING: inconsistent code. */
//    /* Code decompiled incorrectly, please refer to instructions dump. */
//    void a(int r18) {
//        /*
//        r17 = this;
//        r2 = 0;
//        r0 = r17;
//        r3 = r0.i;
//        r0 = r18;
//        if (r3 == r0) goto L_0x0323;
//    L_0x0009:
//        r0 = r17;
//        r2 = r0.i;
//        r0 = r17;
//        r2 = r0.b(r2);
//        r0 = r18;
//        r1 = r17;
//        r1.i = r0;
//        r3 = r2;
//    L_0x001a:
//        r0 = r17;
//        r2 = r0.h;
//        if (r2 != 0) goto L_0x0024;
//    L_0x0020:
//        r17.h();
//    L_0x0023:
//        return;
//    L_0x0024:
//        r0 = r17;
//        r2 = r0.z;
//        if (r2 == 0) goto L_0x002e;
//    L_0x002a:
//        r17.h();
//        goto L_0x0023;
//    L_0x002e:
//        r2 = r17.getWindowToken();
//        if (r2 == 0) goto L_0x0023;
//    L_0x0034:
//        r0 = r17;
//        r2 = r0.h;
//        r0 = r17;
//        r2.startUpdate(r0);
//        r0 = r17;
//        r2 = r0.A;
//        r4 = 0;
//        r0 = r17;
//        r5 = r0.i;
//        r5 = r5 - r2;
//        r10 = java.lang.Math.max(r4, r5);
//        r0 = r17;
//        r4 = r0.h;
//        r11 = r4.getCount();
//        r4 = r11 + -1;
//        r0 = r17;
//        r5 = r0.i;
//        r2 = r2 + r5;
//        r12 = java.lang.Math.min(r4, r2);
//        r0 = r17;
//        r2 = r0.b;
//        if (r11 == r2) goto L_0x00cb;
//    L_0x0064:
//        r2 = r17.getResources();	 Catch:{ NotFoundException -> 0x00c1 }
//        r3 = r17.getId();	 Catch:{ NotFoundException -> 0x00c1 }
//        r2 = r2.getResourceName(r3);	 Catch:{ NotFoundException -> 0x00c1 }
//    L_0x0070:
//        r3 = new java.lang.IllegalStateException;
//        r4 = new java.lang.StringBuilder;
//        r4.<init>();
//        r5 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ";
//        r4 = r4.append(r5);
//        r0 = r17;
//        r5 = r0.b;
//        r4 = r4.append(r5);
//        r5 = ", found: ";
//        r4 = r4.append(r5);
//        r4 = r4.append(r11);
//        r5 = " Pager id: ";
//        r4 = r4.append(r5);
//        r2 = r4.append(r2);
//        r4 = " Pager class: ";
//        r2 = r2.append(r4);
//        r4 = r17.getClass();
//        r2 = r2.append(r4);
//        r4 = " Problematic adapter: ";
//        r2 = r2.append(r4);
//        r0 = r17;
//        r4 = r0.h;
//        r4 = r4.getClass();
//        r2 = r2.append(r4);
//        r2 = r2.toString();
//        r3.<init>(r2);
//        throw r3;
//    L_0x00c1:
//        r2 = move-exception;
//        r2 = r17.getId();
//        r2 = java.lang.Integer.toHexString(r2);
//        goto L_0x0070;
//    L_0x00cb:
//        r5 = 0;
//        r2 = 0;
//        r4 = r2;
//    L_0x00ce:
//        r0 = r17;
//        r2 = r0.e;
//        r2 = r2.size();
//        if (r4 >= r2) goto L_0x0320;
//    L_0x00d8:
//        r0 = r17;
//        r2 = r0.e;
//        r2 = r2.get(r4);
//        r2 = (defpackage.ue) r2;
//        r6 = r2.b;
//        r0 = r17;
//        r7 = r0.i;
//        if (r6 < r7) goto L_0x01bc;
//    L_0x00ea:
//        r6 = r2.b;
//        r0 = r17;
//        r7 = r0.i;
//        if (r6 != r7) goto L_0x0320;
//    L_0x00f2:
//        if (r2 != 0) goto L_0x031d;
//    L_0x00f4:
//        if (r11 <= 0) goto L_0x031d;
//    L_0x00f6:
//        r0 = r17;
//        r2 = r0.i;
//        r0 = r17;
//        r2 = r0.a(r2, r4);
//        r9 = r2;
//    L_0x0101:
//        if (r9 == 0) goto L_0x016d;
//    L_0x0103:
//        r8 = 0;
//        r7 = r4 + -1;
//        if (r7 < 0) goto L_0x01c1;
//    L_0x0108:
//        r0 = r17;
//        r2 = r0.e;
//        r2 = r2.get(r7);
//        r2 = (defpackage.ue) r2;
//    L_0x0112:
//        r13 = r17.getClientWidth();
//        if (r13 > 0) goto L_0x01c4;
//    L_0x0118:
//        r5 = 0;
//    L_0x0119:
//        r0 = r17;
//        r6 = r0.i;
//        r6 = r6 + -1;
//        r15 = r6;
//        r6 = r8;
//        r8 = r15;
//        r16 = r7;
//        r7 = r4;
//        r4 = r16;
//    L_0x0127:
//        if (r8 < 0) goto L_0x0131;
//    L_0x0129:
//        r14 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1));
//        if (r14 < 0) goto L_0x0203;
//    L_0x012d:
//        if (r8 >= r10) goto L_0x0203;
//    L_0x012f:
//        if (r2 != 0) goto L_0x01d3;
//    L_0x0131:
//        r5 = r9.d;
//        r8 = r7 + 1;
//        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
//        r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1));
//        if (r2 >= 0) goto L_0x0168;
//    L_0x013b:
//        r0 = r17;
//        r2 = r0.e;
//        r2 = r2.size();
//        if (r8 >= r2) goto L_0x0239;
//    L_0x0145:
//        r0 = r17;
//        r2 = r0.e;
//        r2 = r2.get(r8);
//        r2 = (defpackage.ue) r2;
//        r6 = r2;
//    L_0x0150:
//        if (r13 > 0) goto L_0x023c;
//    L_0x0152:
//        r2 = 0;
//        r4 = r2;
//    L_0x0154:
//        r0 = r17;
//        r2 = r0.i;
//        r2 = r2 + 1;
//        r15 = r2;
//        r2 = r6;
//        r6 = r8;
//        r8 = r15;
//    L_0x015e:
//        if (r8 >= r11) goto L_0x0168;
//    L_0x0160:
//        r10 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1));
//        if (r10 < 0) goto L_0x0283;
//    L_0x0164:
//        if (r8 <= r12) goto L_0x0283;
//    L_0x0166:
//        if (r2 != 0) goto L_0x0249;
//    L_0x0168:
//        r0 = r17;
//        r0.a(r9, r7, r3);
//    L_0x016d:
//        r0 = r17;
//        r3 = r0.h;
//        r0 = r17;
//        r4 = r0.i;
//        if (r9 == 0) goto L_0x02cd;
//    L_0x0177:
//        r2 = r9.a;
//    L_0x0179:
//        r0 = r17;
//        r3.setPrimaryItem(r0, r4, r2);
//        r0 = r17;
//        r2 = r0.h;
//        r0 = r17;
//        r2.finishUpdate(r0);
//        r4 = r17.getChildCount();
//        r2 = 0;
//        r3 = r2;
//    L_0x018d:
//        if (r3 >= r4) goto L_0x02d0;
//    L_0x018f:
//        r0 = r17;
//        r5 = r0.getChildAt(r3);
//        r2 = r5.getLayoutParams();
//        r2 = (android.support.v4.view.ViewPager.LayoutParams) r2;
//        r2.d = r3;
//        r6 = r2.isDecor;
//        if (r6 != 0) goto L_0x01b8;
//    L_0x01a1:
//        r6 = r2.a;
//        r7 = 0;
//        r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1));
//        if (r6 != 0) goto L_0x01b8;
//    L_0x01a8:
//        r0 = r17;
//        r5 = r0.a(r5);
//        if (r5 == 0) goto L_0x01b8;
//    L_0x01b0:
//        r6 = r5.d;
//        r2.a = r6;
//        r5 = r5.b;
//        r2.c = r5;
//    L_0x01b8:
//        r2 = r3 + 1;
//        r3 = r2;
//        goto L_0x018d;
//    L_0x01bc:
//        r2 = r4 + 1;
//        r4 = r2;
//        goto L_0x00ce;
//    L_0x01c1:
//        r2 = 0;
//        goto L_0x0112;
//    L_0x01c4:
//        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
//        r6 = r9.d;
//        r5 = r5 - r6;
//        r6 = r17.getPaddingLeft();
//        r6 = (float) r6;
//        r14 = (float) r13;
//        r6 = r6 / r14;
//        r5 = r5 + r6;
//        goto L_0x0119;
//    L_0x01d3:
//        r14 = r2.b;
//        if (r8 != r14) goto L_0x01fd;
//    L_0x01d7:
//        r14 = r2.c;
//        if (r14 != 0) goto L_0x01fd;
//    L_0x01db:
//        r0 = r17;
//        r14 = r0.e;
//        r14.remove(r4);
//        r0 = r17;
//        r14 = r0.h;
//        r2 = r2.a;
//        r0 = r17;
//        r14.destroyItem(r0, r8, r2);
//        r4 = r4 + -1;
//        r7 = r7 + -1;
//        if (r4 < 0) goto L_0x0201;
//    L_0x01f3:
//        r0 = r17;
//        r2 = r0.e;
//        r2 = r2.get(r4);
//        r2 = (defpackage.ue) r2;
//    L_0x01fd:
//        r8 = r8 + -1;
//        goto L_0x0127;
//    L_0x0201:
//        r2 = 0;
//        goto L_0x01fd;
//    L_0x0203:
//        if (r2 == 0) goto L_0x021d;
//    L_0x0205:
//        r14 = r2.b;
//        if (r8 != r14) goto L_0x021d;
//    L_0x0209:
//        r2 = r2.d;
//        r6 = r6 + r2;
//        r4 = r4 + -1;
//        if (r4 < 0) goto L_0x021b;
//    L_0x0210:
//        r0 = r17;
//        r2 = r0.e;
//        r2 = r2.get(r4);
//        r2 = (defpackage.ue) r2;
//        goto L_0x01fd;
//    L_0x021b:
//        r2 = 0;
//        goto L_0x01fd;
//    L_0x021d:
//        r2 = r4 + 1;
//        r0 = r17;
//        r2 = r0.a(r8, r2);
//        r2 = r2.d;
//        r6 = r6 + r2;
//        r7 = r7 + 1;
//        if (r4 < 0) goto L_0x0237;
//    L_0x022c:
//        r0 = r17;
//        r2 = r0.e;
//        r2 = r2.get(r4);
//        r2 = (defpackage.ue) r2;
//        goto L_0x01fd;
//    L_0x0237:
//        r2 = 0;
//        goto L_0x01fd;
//    L_0x0239:
//        r6 = 0;
//        goto L_0x0150;
//    L_0x023c:
//        r2 = r17.getPaddingRight();
//        r2 = (float) r2;
//        r4 = (float) r13;
//        r2 = r2 / r4;
//        r4 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
//        r2 = r2 + r4;
//        r4 = r2;
//        goto L_0x0154;
//    L_0x0249:
//        r10 = r2.b;
//        if (r8 != r10) goto L_0x0318;
//    L_0x024d:
//        r10 = r2.c;
//        if (r10 != 0) goto L_0x0318;
//    L_0x0251:
//        r0 = r17;
//        r10 = r0.e;
//        r10.remove(r6);
//        r0 = r17;
//        r10 = r0.h;
//        r2 = r2.a;
//        r0 = r17;
//        r10.destroyItem(r0, r8, r2);
//        r0 = r17;
//        r2 = r0.e;
//        r2 = r2.size();
//        if (r6 >= r2) goto L_0x0281;
//    L_0x026d:
//        r0 = r17;
//        r2 = r0.e;
//        r2 = r2.get(r6);
//        r2 = (defpackage.ue) r2;
//    L_0x0277:
//        r15 = r5;
//        r5 = r2;
//        r2 = r15;
//    L_0x027a:
//        r8 = r8 + 1;
//        r15 = r2;
//        r2 = r5;
//        r5 = r15;
//        goto L_0x015e;
//    L_0x0281:
//        r2 = 0;
//        goto L_0x0277;
//    L_0x0283:
//        if (r2 == 0) goto L_0x02a8;
//    L_0x0285:
//        r10 = r2.b;
//        if (r8 != r10) goto L_0x02a8;
//    L_0x0289:
//        r2 = r2.d;
//        r5 = r5 + r2;
//        r6 = r6 + 1;
//        r0 = r17;
//        r2 = r0.e;
//        r2 = r2.size();
//        if (r6 >= r2) goto L_0x02a6;
//    L_0x0298:
//        r0 = r17;
//        r2 = r0.e;
//        r2 = r2.get(r6);
//        r2 = (defpackage.ue) r2;
//    L_0x02a2:
//        r15 = r5;
//        r5 = r2;
//        r2 = r15;
//        goto L_0x027a;
//    L_0x02a6:
//        r2 = 0;
//        goto L_0x02a2;
//    L_0x02a8:
//        r0 = r17;
//        r2 = r0.a(r8, r6);
//        r6 = r6 + 1;
//        r2 = r2.d;
//        r5 = r5 + r2;
//        r0 = r17;
//        r2 = r0.e;
//        r2 = r2.size();
//        if (r6 >= r2) goto L_0x02cb;
//    L_0x02bd:
//        r0 = r17;
//        r2 = r0.e;
//        r2 = r2.get(r6);
//        r2 = (defpackage.ue) r2;
//    L_0x02c7:
//        r15 = r5;
//        r5 = r2;
//        r2 = r15;
//        goto L_0x027a;
//    L_0x02cb:
//        r2 = 0;
//        goto L_0x02c7;
//    L_0x02cd:
//        r2 = 0;
//        goto L_0x0179;
//    L_0x02d0:
//        r17.h();
//        r2 = r17.hasFocus();
//        if (r2 == 0) goto L_0x0023;
//    L_0x02d9:
//        r2 = r17.findFocus();
//        if (r2 == 0) goto L_0x0316;
//    L_0x02df:
//        r0 = r17;
//        r2 = r0.b(r2);
//    L_0x02e5:
//        if (r2 == 0) goto L_0x02ef;
//    L_0x02e7:
//        r2 = r2.b;
//        r0 = r17;
//        r3 = r0.i;
//        if (r2 == r3) goto L_0x0023;
//    L_0x02ef:
//        r2 = 0;
//    L_0x02f0:
//        r3 = r17.getChildCount();
//        if (r2 >= r3) goto L_0x0023;
//    L_0x02f6:
//        r0 = r17;
//        r3 = r0.getChildAt(r2);
//        r0 = r17;
//        r4 = r0.a(r3);
//        if (r4 == 0) goto L_0x0313;
//    L_0x0304:
//        r4 = r4.b;
//        r0 = r17;
//        r5 = r0.i;
//        if (r4 != r5) goto L_0x0313;
//    L_0x030c:
//        r4 = 2;
//        r3 = r3.requestFocus(r4);
//        if (r3 != 0) goto L_0x0023;
//    L_0x0313:
//        r2 = r2 + 1;
//        goto L_0x02f0;
//    L_0x0316:
//        r2 = 0;
//        goto L_0x02e5;
//    L_0x0318:
//        r15 = r5;
//        r5 = r2;
//        r2 = r15;
//        goto L_0x027a;
//    L_0x031d:
//        r9 = r2;
//        goto L_0x0101;
//    L_0x0320:
//        r2 = r5;
//        goto L_0x00f2;
//    L_0x0323:
//        r3 = r2;
//        goto L_0x001a;
//        */
//        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.a(int):void");
//    }
//
//    private void h() {
//        if (this.ah != 0) {
//            if (this.ai == null) {
//                this.ai = new ArrayList();
//            } else {
//                this.ai.clear();
//            }
//            int childCount = getChildCount();
//            for (int i = 0; i < childCount; i++) {
//                this.ai.add(getChildAt(i));
//            }
//            Collections.sort(this.ai, aj);
//        }
//    }
//
//    private void a(ue ueVar, int i, ue ueVar2) {
//        float f;
//        float f2;
//        int i2;
//        ue ueVar3;
//        int i3;
//        int count = this.h.getCount();
//        int clientWidth = getClientWidth();
//        if (clientWidth > 0) {
//            f = ((float) this.p) / ((float) clientWidth);
//        } else {
//            f = 0.0f;
//        }
//        if (ueVar2 != null) {
//            clientWidth = ueVar2.b;
//            int i4;
//            if (clientWidth < ueVar.b) {
//                f2 = (ueVar2.e + ueVar2.d) + f;
//                i4 = clientWidth + 1;
//                i2 = 0;
//                while (i4 <= ueVar.b && i2 < this.e.size()) {
//                    ueVar3 = (ue) this.e.get(i2);
//                    while (i4 > ueVar3.b && i2 < this.e.size() - 1) {
//                        i2++;
//                        ueVar3 = (ue) this.e.get(i2);
//                    }
//                    while (i4 < ueVar3.b) {
//                        f2 += this.h.getPageWidth(i4) + f;
//                        i4++;
//                    }
//                    ueVar3.e = f2;
//                    f2 += ueVar3.d + f;
//                    i4++;
//                }
//            } else if (clientWidth > ueVar.b) {
//                i2 = this.e.size() - 1;
//                f2 = ueVar2.e;
//                i4 = clientWidth - 1;
//                while (i4 >= ueVar.b && i2 >= 0) {
//                    ueVar3 = (ue) this.e.get(i2);
//                    while (i4 < ueVar3.b && i2 > 0) {
//                        i2--;
//                        ueVar3 = (ue) this.e.get(i2);
//                    }
//                    while (i4 > ueVar3.b) {
//                        f2 -= this.h.getPageWidth(i4) + f;
//                        i4--;
//                    }
//                    f2 -= ueVar3.d + f;
//                    ueVar3.e = f2;
//                    i4--;
//                }
//            }
//        }
//        int size = this.e.size();
//        float f3 = ueVar.e;
//        i2 = ueVar.b - 1;
//        this.t = ueVar.b == 0 ? ueVar.e : -3.4028235E38f;
//        this.u = ueVar.b == count + -1 ? (ueVar.e + ueVar.d) - 1.0f : AutoScrollHelper.NO_MAX;
//        for (i3 = i - 1; i3 >= 0; i3--) {
//            ueVar3 = (ue) this.e.get(i3);
//            f2 = f3;
//            while (i2 > ueVar3.b) {
//                f2 -= this.h.getPageWidth(i2) + f;
//                i2--;
//            }
//            f3 = f2 - (ueVar3.d + f);
//            ueVar3.e = f3;
//            if (ueVar3.b == 0) {
//                this.t = f3;
//            }
//            i2--;
//        }
//        f3 = (ueVar.e + ueVar.d) + f;
//        i2 = ueVar.b + 1;
//        for (i3 = i + 1; i3 < size; i3++) {
//            ueVar3 = (ue) this.e.get(i3);
//            f2 = f3;
//            while (i2 < ueVar3.b) {
//                f2 = (this.h.getPageWidth(i2) + f) + f2;
//                i2++;
//            }
//            if (ueVar3.b == count - 1) {
//                this.u = (ueVar3.d + f2) - 1.0f;
//            }
//            ueVar3.e = f2;
//            f3 = f2 + (ueVar3.d + f);
//            i2++;
//        }
//        this.V = false;
//    }
//
//    public Parcelable onSaveInstanceState() {
//        Parcelable savedState = new SavedState(super.onSaveInstanceState());
//        savedState.a = this.i;
//        if (this.h != null) {
//            savedState.b = this.h.saveState();
//        }
//        return savedState;
//    }
//
//    public void onRestoreInstanceState(Parcelable parcelable) {
//        if (parcelable instanceof SavedState) {
//            SavedState savedState = (SavedState) parcelable;
//            super.onRestoreInstanceState(savedState.getSuperState());
//            if (this.h != null) {
//                this.h.restoreState(savedState.b, savedState.c);
//                a(savedState.a, false, true);
//                return;
//            }
//            this.j = savedState.a;
//            this.k = savedState.b;
//            this.l = savedState.c;
//            return;
//        }
//        super.onRestoreInstanceState(parcelable);
//    }
//
//    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
//        ViewGroup.LayoutParams layoutParams2;
//        if (checkLayoutParams(layoutParams)) {
//            layoutParams2 = layoutParams;
//        } else {
//            layoutParams2 = generateLayoutParams(layoutParams);
//        }
//        LayoutParams layoutParams3 = (LayoutParams) layoutParams2;
//        layoutParams3.isDecor |= view instanceof ud;
//        if (!this.x) {
//            super.addView(view, i, layoutParams2);
//        } else if (layoutParams3 == null || !layoutParams3.isDecor) {
//            layoutParams3.b = true;
//            addViewInLayout(view, i, layoutParams2);
//        } else {
//            throw new IllegalStateException("Cannot add pager decor view during layout");
//        }
//    }
//
//    public void removeView(View view) {
//        if (this.x) {
//            removeViewInLayout(view);
//        } else {
//            super.removeView(view);
//        }
//    }
//
//    ue a(View view) {
//        for (int i = 0; i < this.e.size(); i++) {
//            ue ueVar = (ue) this.e.get(i);
//            if (this.h.isViewFromObject(view, ueVar.a)) {
//                return ueVar;
//            }
//        }
//        return null;
//    }
//
//    ue b(View view) {
//        while (true) {
//            android.support.v4.view.ViewPager parent = view.getParent();
//            if (parent == this) {
//                return a(view);
//            }
//            if (parent != null && (parent instanceof View)) {
//                view = parent;
//            }
//        }
//        return null;
//    }
//
//    ue b(int i) {
//        for (int i2 = 0; i2 < this.e.size(); i2++) {
//            ue ueVar = (ue) this.e.get(i2);
//            if (ueVar.b == i) {
//                return ueVar;
//            }
//        }
//        return null;
//    }
//
//    protected void onAttachedToWindow() {
//        super.onAttachedToWindow();
//        this.U = true;
//    }
//
//    protected void onMeasure(int i, int i2) {
//        LayoutParams layoutParams;
//        int i3;
//        int i4;
//        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
//        int measuredWidth = getMeasuredWidth();
//        this.E = Math.min(measuredWidth / 10, this.D);
//        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
//        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
//        int childCount = getChildCount();
//        for (int i5 = 0; i5 < childCount; i5++) {
//            View childAt = getChildAt(i5);
//            if (childAt.getVisibility() != 8) {
//                layoutParams = (LayoutParams) childAt.getLayoutParams();
//                if (layoutParams != null && layoutParams.isDecor) {
//                    int i6 = layoutParams.gravity & 7;
//                    int i7 = layoutParams.gravity & 112;
//                    i3 = Integer.MIN_VALUE;
//                    i4 = Integer.MIN_VALUE;
//                    Object obj = (i7 == 48 || i7 == 80) ? 1 : null;
//                    Object obj2 = (i6 == 3 || i6 == 5) ? 1 : null;
//                    if (obj != null) {
//                        i3 = 1073741824;
//                    } else if (obj2 != null) {
//                        i4 = 1073741824;
//                    }
//                    if (layoutParams.width != -2) {
//                        i7 = 1073741824;
//                        i3 = layoutParams.width != -1 ? layoutParams.width : paddingLeft;
//                    } else {
//                        i7 = i3;
//                        i3 = paddingLeft;
//                    }
//                    if (layoutParams.height != -2) {
//                        i4 = 1073741824;
//                        if (layoutParams.height != -1) {
//                            measuredWidth = layoutParams.height;
//                            childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i4));
//                            if (obj != null) {
//                                measuredHeight -= childAt.getMeasuredHeight();
//                            } else if (obj2 != null) {
//                                paddingLeft -= childAt.getMeasuredWidth();
//                            }
//                        }
//                    }
//                    measuredWidth = measuredHeight;
//                    childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i4));
//                    if (obj != null) {
//                        measuredHeight -= childAt.getMeasuredHeight();
//                    } else if (obj2 != null) {
//                        paddingLeft -= childAt.getMeasuredWidth();
//                    }
//                }
//            }
//        }
//        this.v = MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
//        this.w = MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
//        this.x = true;
//        c();
//        this.x = false;
//        i3 = getChildCount();
//        for (i4 = 0; i4 < i3; i4++) {
//            View childAt2 = getChildAt(i4);
//            if (childAt2.getVisibility() != 8) {
//                layoutParams = (LayoutParams) childAt2.getLayoutParams();
//                if (layoutParams == null || !layoutParams.isDecor) {
//                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (layoutParams.a * ((float) paddingLeft)), 1073741824), this.w);
//                }
//            }
//        }
//    }
//
//    protected void onSizeChanged(int i, int i2, int i3, int i4) {
//        super.onSizeChanged(i, i2, i3, i4);
//        if (i != i3) {
//            a(i, i3, this.p, this.p);
//        }
//    }
//
//    private void a(int i, int i2, int i3, int i4) {
//        if (i2 <= 0 || this.e.isEmpty()) {
//            ue b = b(this.i);
//            int min = (int) ((b != null ? Math.min(b.e, this.u) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
//            if (min != getScrollX()) {
//                a(false);
//                scrollTo(min, getScrollY());
//            }
//        } else if (this.m.isFinished()) {
//            scrollTo((int) (((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3)) * (((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)))), getScrollY());
//        } else {
//            this.m.setFinalX(getCurrentItem() * getClientWidth());
//        }
//    }
//
//    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
//        int max;
//        int childCount = getChildCount();
//        int i5 = i3 - i;
//        int i6 = i4 - i2;
//        int paddingLeft = getPaddingLeft();
//        int paddingTop = getPaddingTop();
//        int paddingRight = getPaddingRight();
//        int paddingBottom = getPaddingBottom();
//        int scrollX = getScrollX();
//        int i7 = 0;
//        int i8 = 0;
//        while (i8 < childCount) {
//            LayoutParams layoutParams;
//            int measuredWidth;
//            View childAt = getChildAt(i8);
//            if (childAt.getVisibility() != 8) {
//                layoutParams = (LayoutParams) childAt.getLayoutParams();
//                if (layoutParams.isDecor) {
//                    int i9 = layoutParams.gravity & 112;
//                    switch (layoutParams.gravity & 7) {
//                        case 1:
//                            max = Math.max((i5 - childAt.getMeasuredWidth()) / 2, paddingLeft);
//                            break;
//                        case 3:
//                            max = paddingLeft;
//                            paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
//                            break;
//                        case 5:
//                            measuredWidth = (i5 - paddingRight) - childAt.getMeasuredWidth();
//                            paddingRight += childAt.getMeasuredWidth();
//                            max = measuredWidth;
//                            break;
//                        default:
//                            max = paddingLeft;
//                            break;
//                    }
//                    int i10;
//                    switch (i9) {
//                        case 16:
//                            measuredWidth = Math.max((i6 - childAt.getMeasuredHeight()) / 2, paddingTop);
//                            i10 = paddingBottom;
//                            paddingBottom = paddingTop;
//                            paddingTop = i10;
//                            break;
//                        case 48:
//                            measuredWidth = childAt.getMeasuredHeight() + paddingTop;
//                            i10 = paddingTop;
//                            paddingTop = paddingBottom;
//                            paddingBottom = measuredWidth;
//                            measuredWidth = i10;
//                            break;
//                        case 80:
//                            measuredWidth = (i6 - paddingBottom) - childAt.getMeasuredHeight();
//                            i10 = paddingBottom + childAt.getMeasuredHeight();
//                            paddingBottom = paddingTop;
//                            paddingTop = i10;
//                            break;
//                        default:
//                            measuredWidth = paddingTop;
//                            i10 = paddingBottom;
//                            paddingBottom = paddingTop;
//                            paddingTop = i10;
//                            break;
//                    }
//                    max += scrollX;
//                    childAt.layout(max, measuredWidth, childAt.getMeasuredWidth() + max, childAt.getMeasuredHeight() + measuredWidth);
//                    measuredWidth = i7 + 1;
//                    i7 = paddingBottom;
//                    paddingBottom = paddingTop;
//                    paddingTop = paddingRight;
//                    paddingRight = paddingLeft;
//                    i8++;
//                    paddingLeft = paddingRight;
//                    paddingRight = paddingTop;
//                    paddingTop = i7;
//                    i7 = measuredWidth;
//                }
//            }
//            measuredWidth = i7;
//            i7 = paddingTop;
//            paddingTop = paddingRight;
//            paddingRight = paddingLeft;
//            i8++;
//            paddingLeft = paddingRight;
//            paddingRight = paddingTop;
//            paddingTop = i7;
//            i7 = measuredWidth;
//        }
//        max = (i5 - paddingLeft) - paddingRight;
//        for (paddingRight = 0; paddingRight < childCount; paddingRight++) {
//            View childAt2 = getChildAt(paddingRight);
//            if (childAt2.getVisibility() != 8) {
//                layoutParams = (LayoutParams) childAt2.getLayoutParams();
//                if (!layoutParams.isDecor) {
//                    ue a = a(childAt2);
//                    if (a != null) {
//                        i5 = ((int) (a.e * ((float) max))) + paddingLeft;
//                        if (layoutParams.b) {
//                            layoutParams.b = false;
//                            childAt2.measure(MeasureSpec.makeMeasureSpec((int) (layoutParams.a * ((float) max)), 1073741824), MeasureSpec.makeMeasureSpec((i6 - paddingTop) - paddingBottom, 1073741824));
//                        }
//                        childAt2.layout(i5, paddingTop, childAt2.getMeasuredWidth() + i5, childAt2.getMeasuredHeight() + paddingTop);
//                    }
//                }
//            }
//        }
//        this.r = paddingTop;
//        this.s = i6 - paddingBottom;
//        this.aa = i7;
//        if (this.U) {
//            a(this.i, false, 0, false);
//        }
//        this.U = false;
//    }
//
//    public void computeScroll() {
//        this.n = true;
//        if (this.m.isFinished() || !this.m.computeScrollOffset()) {
//            a(true);
//            return;
//        }
//        int scrollX = getScrollX();
//        int scrollY = getScrollY();
//        int currX = this.m.getCurrX();
//        int currY = this.m.getCurrY();
//        if (!(scrollX == currX && scrollY == currY)) {
//            scrollTo(currX, currY);
//            if (!c(currX)) {
//                this.m.abortAnimation();
//                scrollTo(0, currY);
//            }
//        }
//        ViewCompat.postInvalidateOnAnimation(this);
//    }
//
//    private boolean c(int i) {
//        if (this.e.size() == 0) {
//            this.W = false;
//            onPageScrolled(0, 0.0f, 0);
//            if (this.W) {
//                return false;
//            }
//            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
//        }
//        ue j = j();
//        int clientWidth = getClientWidth();
//        int i2 = this.p + clientWidth;
//        float f = ((float) this.p) / ((float) clientWidth);
//        int i3 = j.b;
//        float f2 = ((((float) i) / ((float) clientWidth)) - j.e) / (j.d + f);
//        clientWidth = (int) (((float) i2) * f2);
//        this.W = false;
//        onPageScrolled(i3, f2, clientWidth);
//        if (this.W) {
//            return true;
//        }
//        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
//    }
//
//    @CallSuper
//    protected void onPageScrolled(int i, float f, int i2) {
//        int paddingLeft;
//        int paddingRight;
//        int i3;
//        if (this.aa > 0) {
//            int scrollX = getScrollX();
//            paddingLeft = getPaddingLeft();
//            paddingRight = getPaddingRight();
//            int width = getWidth();
//            int childCount = getChildCount();
//            i3 = 0;
//            while (i3 < childCount) {
//                int i4;
//                View childAt = getChildAt(i3);
//                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
//                if (layoutParams.isDecor) {
//                    int max;
//                    switch (layoutParams.gravity & 7) {
//                        case 1:
//                            max = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
//                            i4 = paddingRight;
//                            paddingRight = paddingLeft;
//                            paddingLeft = i4;
//                            break;
//                        case 3:
//                            max = childAt.getWidth() + paddingLeft;
//                            i4 = paddingLeft;
//                            paddingLeft = paddingRight;
//                            paddingRight = max;
//                            max = i4;
//                            break;
//                        case 5:
//                            max = (width - paddingRight) - childAt.getMeasuredWidth();
//                            i4 = paddingRight + childAt.getMeasuredWidth();
//                            paddingRight = paddingLeft;
//                            paddingLeft = i4;
//                            break;
//                        default:
//                            max = paddingLeft;
//                            i4 = paddingRight;
//                            paddingRight = paddingLeft;
//                            paddingLeft = i4;
//                            break;
//                    }
//                    max = (max + scrollX) - childAt.getLeft();
//                    if (max != 0) {
//                        childAt.offsetLeftAndRight(max);
//                    }
//                } else {
//                    i4 = paddingRight;
//                    paddingRight = paddingLeft;
//                    paddingLeft = i4;
//                }
//                i3++;
//                i4 = paddingLeft;
//                paddingLeft = paddingRight;
//                paddingRight = i4;
//            }
//        }
//        a(i, f, i2);
//        if (this.af != null) {
//            paddingRight = getScrollX();
//            i3 = getChildCount();
//            for (paddingLeft = 0; paddingLeft < i3; paddingLeft++) {
//                View childAt2 = getChildAt(paddingLeft);
//                if (!((LayoutParams) childAt2.getLayoutParams()).isDecor) {
//                    this.af.transformPage(childAt2, ((float) (childAt2.getLeft() - paddingRight)) / ((float) getClientWidth()));
//                }
//            }
//        }
//        this.W = true;
//    }
//
//    private void a(int i, float f, int i2) {
//        if (this.ac != null) {
//            this.ac.onPageScrolled(i, f, i2);
//        }
//        if (this.ab != null) {
//            int size = this.ab.size();
//            for (int i3 = 0; i3 < size; i3++) {
//                OnPageChangeListener onPageChangeListener = (OnPageChangeListener) this.ab.get(i3);
//                if (onPageChangeListener != null) {
//                    onPageChangeListener.onPageScrolled(i, f, i2);
//                }
//            }
//        }
//        if (this.ad != null) {
//            this.ad.onPageScrolled(i, f, i2);
//        }
//    }
//
//    private void d(int i) {
//        if (this.ac != null) {
//            this.ac.onPageSelected(i);
//        }
//        if (this.ab != null) {
//            int size = this.ab.size();
//            for (int i2 = 0; i2 < size; i2++) {
//                OnPageChangeListener onPageChangeListener = (OnPageChangeListener) this.ab.get(i2);
//                if (onPageChangeListener != null) {
//                    onPageChangeListener.onPageSelected(i);
//                }
//            }
//        }
//        if (this.ad != null) {
//            this.ad.onPageSelected(i);
//        }
//    }
//
//    private void e(int i) {
//        if (this.ac != null) {
//            this.ac.onPageScrollStateChanged(i);
//        }
//        if (this.ab != null) {
//            int size = this.ab.size();
//            for (int i2 = 0; i2 < size; i2++) {
//                OnPageChangeListener onPageChangeListener = (OnPageChangeListener) this.ab.get(i2);
//                if (onPageChangeListener != null) {
//                    onPageChangeListener.onPageScrollStateChanged(i);
//                }
//            }
//        }
//        if (this.ad != null) {
//            this.ad.onPageScrollStateChanged(i);
//        }
//    }
//
//    private void a(boolean z) {
//        int scrollX;
//        boolean z2 = this.al == 2;
//        if (z2) {
//            boolean z3;
//            setScrollingCacheEnabled(false);
//            if (this.m.isFinished()) {
//                z3 = false;
//            } else {
//                z3 = true;
//            }
//            if (z3) {
//                this.m.abortAnimation();
//                scrollX = getScrollX();
//                int scrollY = getScrollY();
//                int currX = this.m.getCurrX();
//                int currY = this.m.getCurrY();
//                if (!(scrollX == currX && scrollY == currY)) {
//                    scrollTo(currX, currY);
//                    if (currX != scrollX) {
//                        c(currX);
//                    }
//                }
//            }
//        }
//        this.z = false;
//        boolean z4 = z2;
//        for (scrollX = 0; scrollX < this.e.size(); scrollX++) {
//            ue ueVar = (ue) this.e.get(scrollX);
//            if (ueVar.c) {
//                ueVar.c = false;
//                z4 = true;
//            }
//        }
//        if (!z4) {
//            return;
//        }
//        if (z) {
//            ViewCompat.postOnAnimation(this, this.ak);
//        } else {
//            this.ak.run();
//        }
//    }
//
//    private boolean a(float f, float f2) {
//        return (f < ((float) this.E) && f2 > 0.0f) || (f > ((float) (getWidth() - this.E)) && f2 < 0.0f);
//    }
//
//    private void b(boolean z) {
//        int childCount = getChildCount();
//        for (int i = 0; i < childCount; i++) {
//            int i2;
//            if (z) {
//                i2 = 2;
//            } else {
//                i2 = 0;
//            }
//            ViewCompat.setLayerType(getChildAt(i), i2, null);
//        }
//    }
//
//    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
//        int action = motionEvent.getAction() & 255;
//        if (action == 3 || action == 1) {
//            i();
//            return false;
//        }
//        if (action != 0) {
//            if (this.B) {
//                return true;
//            }
//            if (this.C) {
//                return false;
//            }
//        }
//        switch (action) {
//            case 0:
//                float x = motionEvent.getX();
//                this.I = x;
//                this.G = x;
//                x = motionEvent.getY();
//                this.J = x;
//                this.H = x;
//                this.K = MotionEventCompat.getPointerId(motionEvent, 0);
//                this.C = false;
//                this.n = true;
//                this.m.computeScrollOffset();
//                if (this.al == 2 && Math.abs(this.m.getFinalX() - this.m.getCurrX()) > this.P) {
//                    this.m.abortAnimation();
//                    this.z = false;
//                    c();
//                    this.B = true;
//                    c(true);
//                    setScrollState(1);
//                    break;
//                }
//                a(false);
//                this.B = false;
//                break;
//            case 2:
//                action = this.K;
//                if (action != -1) {
//                    action = MotionEventCompat.findPointerIndex(motionEvent, action);
//                    float x2 = MotionEventCompat.getX(motionEvent, action);
//                    float f = x2 - this.G;
//                    float abs = Math.abs(f);
//                    float y = MotionEventCompat.getY(motionEvent, action);
//                    float abs2 = Math.abs(y - this.J);
//                    if (f == 0.0f || a(this.G, f) || !canScroll(this, false, (int) f, (int) x2, (int) y)) {
//                        if (abs > ((float) this.F) && 0.5f * abs > abs2) {
//                            this.B = true;
//                            c(true);
//                            setScrollState(1);
//                            this.G = f > 0.0f ? this.I + ((float) this.F) : this.I - ((float) this.F);
//                            this.H = y;
//                            setScrollingCacheEnabled(true);
//                        } else if (abs2 > ((float) this.F)) {
//                            this.C = true;
//                        }
//                        if (this.B && b(x2)) {
//                            ViewCompat.postInvalidateOnAnimation(this);
//                            break;
//                        }
//                    }
//                    this.G = x2;
//                    this.H = y;
//                    this.C = true;
//                    return false;
//                }
//                break;
//            case 6:
//                a(motionEvent);
//                break;
//        }
//        if (this.L == null) {
//            this.L = VelocityTracker.obtain();
//        }
//        this.L.addMovement(motionEvent);
//        return this.B;
//    }
//
//    public boolean onTouchEvent(MotionEvent motionEvent) {
//        boolean z = false;
//        if (this.Q) {
//            return true;
//        }
//        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
//            return false;
//        }
//        if (this.h == null || this.h.getCount() == 0) {
//            return false;
//        }
//        if (this.L == null) {
//            this.L = VelocityTracker.obtain();
//        }
//        this.L.addMovement(motionEvent);
//        float x;
//        int xVelocity;
//        switch (motionEvent.getAction() & 255) {
//            case 0:
//                this.m.abortAnimation();
//                this.z = false;
//                c();
//                x = motionEvent.getX();
//                this.I = x;
//                this.G = x;
//                x = motionEvent.getY();
//                this.J = x;
//                this.H = x;
//                this.K = MotionEventCompat.getPointerId(motionEvent, 0);
//                break;
//            case 1:
//                if (this.B) {
//                    VelocityTracker velocityTracker = this.L;
//                    velocityTracker.computeCurrentVelocity(1000, (float) this.N);
//                    xVelocity = (int) VelocityTrackerCompat.getXVelocity(velocityTracker, this.K);
//                    this.z = true;
//                    int clientWidth = getClientWidth();
//                    int scrollX = getScrollX();
//                    ue j = j();
//                    a(a(j.b, ((((float) scrollX) / ((float) clientWidth)) - j.e) / j.d, xVelocity, (int) (MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.K)) - this.I)), true, true, xVelocity);
//                    z = i();
//                    break;
//                }
//                break;
//            case 2:
//                if (!this.B) {
//                    xVelocity = MotionEventCompat.findPointerIndex(motionEvent, this.K);
//                    if (xVelocity == -1) {
//                        z = i();
//                        break;
//                    }
//                    float x2 = MotionEventCompat.getX(motionEvent, xVelocity);
//                    float abs = Math.abs(x2 - this.G);
//                    float y = MotionEventCompat.getY(motionEvent, xVelocity);
//                    x = Math.abs(y - this.H);
//                    if (abs > ((float) this.F) && abs > x) {
//                        this.B = true;
//                        c(true);
//                        if (x2 - this.I > 0.0f) {
//                            x = this.I + ((float) this.F);
//                        } else {
//                            x = this.I - ((float) this.F);
//                        }
//                        this.G = x;
//                        this.H = y;
//                        setScrollState(1);
//                        setScrollingCacheEnabled(true);
//                        ViewParent parent = getParent();
//                        if (parent != null) {
//                            parent.requestDisallowInterceptTouchEvent(true);
//                        }
//                    }
//                }
//                if (this.B) {
//                    z = false | b(MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.K)));
//                    break;
//                }
//                break;
//            case 3:
//                if (this.B) {
//                    a(this.i, true, 0, false);
//                    z = i();
//                    break;
//                }
//                break;
//            case 5:
//                xVelocity = MotionEventCompat.getActionIndex(motionEvent);
//                this.G = MotionEventCompat.getX(motionEvent, xVelocity);
//                this.K = MotionEventCompat.getPointerId(motionEvent, xVelocity);
//                break;
//            case 6:
//                a(motionEvent);
//                this.G = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.K));
//                break;
//        }
//        if (z) {
//            ViewCompat.postInvalidateOnAnimation(this);
//        }
//        return true;
//    }
//
//    private boolean i() {
//        this.K = -1;
//        k();
//        return this.S.onRelease() | this.T.onRelease();
//    }
//
//    private void c(boolean z) {
//        ViewParent parent = getParent();
//        if (parent != null) {
//            parent.requestDisallowInterceptTouchEvent(z);
//        }
//    }
//
//    private boolean b(float f) {
//        boolean z;
//        float f2;
//        boolean z2 = true;
//        boolean z3 = false;
//        float f3 = this.G - f;
//        this.G = f;
//        float scrollX = ((float) getScrollX()) + f3;
//        int clientWidth = getClientWidth();
//        float f4 = ((float) clientWidth) * this.t;
//        float f5 = ((float) clientWidth) * this.u;
//        ue ueVar = (ue) this.e.get(0);
//        ue ueVar2 = (ue) this.e.get(this.e.size() - 1);
//        if (ueVar.b != 0) {
//            f4 = ueVar.e * ((float) clientWidth);
//            z = false;
//        } else {
//            z = true;
//        }
//        if (ueVar2.b != this.h.getCount() - 1) {
//            f2 = ueVar2.e * ((float) clientWidth);
//            z2 = false;
//        } else {
//            f2 = f5;
//        }
//        if (scrollX < f4) {
//            if (z) {
//                z3 = this.S.onPull(Math.abs(f4 - scrollX) / ((float) clientWidth));
//            }
//        } else if (scrollX > f2) {
//            if (z2) {
//                z3 = this.T.onPull(Math.abs(scrollX - f2) / ((float) clientWidth));
//            }
//            f4 = f2;
//        } else {
//            f4 = scrollX;
//        }
//        this.G += f4 - ((float) ((int) f4));
//        scrollTo((int) f4, getScrollY());
//        c((int) f4);
//        return z3;
//    }
//
//    private ue j() {
//        float f;
//        int clientWidth = getClientWidth();
//        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
//        if (clientWidth > 0) {
//            f = ((float) this.p) / ((float) clientWidth);
//        } else {
//            f = 0.0f;
//        }
//        float f2 = 0.0f;
//        float f3 = 0.0f;
//        int i = -1;
//        int i2 = 0;
//        Object obj = 1;
//        ue ueVar = null;
//        while (i2 < this.e.size()) {
//            int i3;
//            ue ueVar2;
//            ue ueVar3 = (ue) this.e.get(i2);
//            ue ueVar4;
//            if (obj != null || ueVar3.b == i + 1) {
//                ueVar4 = ueVar3;
//                i3 = i2;
//                ueVar2 = ueVar4;
//            } else {
//                ueVar3 = this.f;
//                ueVar3.e = (f2 + f3) + f;
//                ueVar3.b = i + 1;
//                ueVar3.d = this.h.getPageWidth(ueVar3.b);
//                ueVar4 = ueVar3;
//                i3 = i2 - 1;
//                ueVar2 = ueVar4;
//            }
//            f2 = ueVar2.e;
//            f3 = (ueVar2.d + f2) + f;
//            if (obj == null && scrollX < f2) {
//                return ueVar;
//            }
//            if (scrollX < f3 || i3 == this.e.size() - 1) {
//                return ueVar2;
//            }
//            f3 = f2;
//            i = ueVar2.b;
//            obj = null;
//            f2 = ueVar2.d;
//            ueVar = ueVar2;
//            i2 = i3 + 1;
//        }
//        return ueVar;
//    }
//
//    private int a(int i, float f, int i2, int i3) {
//        if (Math.abs(i3) <= this.O || Math.abs(i2) <= this.M) {
//            i = (int) ((i >= this.i ? 0.4f : 0.6f) + (((float) i) + f));
//        } else if (i2 <= 0) {
//            i++;
//        }
//        if (this.e.size() <= 0) {
//            return i;
//        }
//        return Math.max(((ue) this.e.get(0)).b, Math.min(i, ((ue) this.e.get(this.e.size() - 1)).b));
//    }
//
//    public void draw(Canvas canvas) {
//        super.draw(canvas);
//        int i = 0;
//        int overScrollMode = ViewCompat.getOverScrollMode(this);
//        if (overScrollMode == 0 || (overScrollMode == 1 && this.h != null && this.h.getCount() > 1)) {
//            int height;
//            int width;
//            if (!this.S.isFinished()) {
//                overScrollMode = canvas.save();
//                height = (getHeight() - getPaddingTop()) - getPaddingBottom();
//                width = getWidth();
//                canvas.rotate(270.0f);
//                canvas.translate((float) ((-height) + getPaddingTop()), this.t * ((float) width));
//                this.S.setSize(height, width);
//                i = 0 | this.S.draw(canvas);
//                canvas.restoreToCount(overScrollMode);
//            }
//            if (!this.T.isFinished()) {
//                overScrollMode = canvas.save();
//                height = getWidth();
//                width = (getHeight() - getPaddingTop()) - getPaddingBottom();
//                canvas.rotate(90.0f);
//                canvas.translate((float) (-getPaddingTop()), (-(this.u + 1.0f)) * ((float) height));
//                this.T.setSize(width, height);
//                i |= this.T.draw(canvas);
//                canvas.restoreToCount(overScrollMode);
//            }
//        } else {
//            this.S.finish();
//            this.T.finish();
//        }
//        if (i != 0) {
//            ViewCompat.postInvalidateOnAnimation(this);
//        }
//    }
//
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        if (this.p > 0 && this.q != null && this.e.size() > 0 && this.h != null) {
//            int scrollX = getScrollX();
//            int width = getWidth();
//            float f = ((float) this.p) / ((float) width);
//            ue ueVar = (ue) this.e.get(0);
//            float f2 = ueVar.e;
//            int size = this.e.size();
//            int i = ueVar.b;
//            int i2 = ((ue) this.e.get(size - 1)).b;
//            int i3 = 0;
//            int i4 = i;
//            while (i4 < i2) {
//                float f3;
//                while (i4 > ueVar.b && i3 < size) {
//                    i3++;
//                    ueVar = (ue) this.e.get(i3);
//                }
//                if (i4 == ueVar.b) {
//                    f3 = (ueVar.e + ueVar.d) * ((float) width);
//                    f2 = (ueVar.e + ueVar.d) + f;
//                } else {
//                    float pageWidth = this.h.getPageWidth(i4);
//                    f3 = (f2 + pageWidth) * ((float) width);
//                    f2 += pageWidth + f;
//                }
//                if (((float) this.p) + f3 > ((float) scrollX)) {
//                    this.q.setBounds((int) f3, this.r, (int) ((((float) this.p) + f3) + 0.5f), this.s);
//                    this.q.draw(canvas);
//                }
//                if (f3 <= ((float) (scrollX + width))) {
//                    i4++;
//                } else {
//                    return;
//                }
//            }
//        }
//    }
//
//    public boolean beginFakeDrag() {
//        if (this.B) {
//            return false;
//        }
//        this.Q = true;
//        setScrollState(1);
//        this.G = 0.0f;
//        this.I = 0.0f;
//        if (this.L == null) {
//            this.L = VelocityTracker.obtain();
//        } else {
//            this.L.clear();
//        }
//        long uptimeMillis = SystemClock.uptimeMillis();
//        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
//        this.L.addMovement(obtain);
//        obtain.recycle();
//        this.R = uptimeMillis;
//        return true;
//    }
//
//    public void endFakeDrag() {
//        if (this.Q) {
//            if (this.h != null) {
//                VelocityTracker velocityTracker = this.L;
//                velocityTracker.computeCurrentVelocity(1000, (float) this.N);
//                int xVelocity = (int) VelocityTrackerCompat.getXVelocity(velocityTracker, this.K);
//                this.z = true;
//                int clientWidth = getClientWidth();
//                int scrollX = getScrollX();
//                ue j = j();
//                a(a(j.b, ((((float) scrollX) / ((float) clientWidth)) - j.e) / j.d, xVelocity, (int) (this.G - this.I)), true, true, xVelocity);
//            }
//            k();
//            this.Q = false;
//            return;
//        }
//        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
//    }
//
//    public void fakeDragBy(float f) {
//        if (!this.Q) {
//            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
//        } else if (this.h != null) {
//            float f2;
//            float f3;
//            this.G += f;
//            float scrollX = ((float) getScrollX()) - f;
//            int clientWidth = getClientWidth();
//            float f4 = ((float) clientWidth) * this.t;
//            float f5 = ((float) clientWidth) * this.u;
//            ue ueVar = (ue) this.e.get(0);
//            ue ueVar2 = (ue) this.e.get(this.e.size() - 1);
//            if (ueVar.b != 0) {
//                f2 = ueVar.e * ((float) clientWidth);
//            } else {
//                f2 = f4;
//            }
//            if (ueVar2.b != this.h.getCount() - 1) {
//                f3 = ueVar2.e * ((float) clientWidth);
//            } else {
//                f3 = f5;
//            }
//            if (scrollX >= f2) {
//                if (scrollX > f3) {
//                    f2 = f3;
//                } else {
//                    f2 = scrollX;
//                }
//            }
//            this.G += f2 - ((float) ((int) f2));
//            scrollTo((int) f2, getScrollY());
//            c((int) f2);
//            MotionEvent obtain = MotionEvent.obtain(this.R, SystemClock.uptimeMillis(), 2, this.G, 0.0f, 0);
//            this.L.addMovement(obtain);
//            obtain.recycle();
//        }
//    }
//
//    public boolean isFakeDragging() {
//        return this.Q;
//    }
//
//    private void a(MotionEvent motionEvent) {
//        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
//        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.K) {
//            actionIndex = actionIndex == 0 ? 1 : 0;
//            this.G = MotionEventCompat.getX(motionEvent, actionIndex);
//            this.K = MotionEventCompat.getPointerId(motionEvent, actionIndex);
//            if (this.L != null) {
//                this.L.clear();
//            }
//        }
//    }
//
//    private void k() {
//        this.B = false;
//        this.C = false;
//        if (this.L != null) {
//            this.L.recycle();
//            this.L = null;
//        }
//    }
//
//    private void setScrollingCacheEnabled(boolean z) {
//        if (this.y != z) {
//            this.y = z;
//        }
//    }
//
//    public boolean canScrollHorizontally(int i) {
//        boolean z = true;
//        if (this.h == null) {
//            return false;
//        }
//        int clientWidth = getClientWidth();
//        int scrollX = getScrollX();
//        if (i < 0) {
//            if (scrollX <= ((int) (((float) clientWidth) * this.t))) {
//                z = false;
//            }
//            return z;
//        } else if (i <= 0) {
//            return false;
//        } else {
//            if (scrollX >= ((int) (((float) clientWidth) * this.u))) {
//                z = false;
//            }
//            return z;
//        }
//    }
//
//    protected boolean canScroll(View view, boolean z, int i, int i2, int i3) {
//        if (view instanceof ViewGroup) {
//            ViewGroup viewGroup = (ViewGroup) view;
//            int scrollX = view.getScrollX();
//            int scrollY = view.getScrollY();
//            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
//                View childAt = viewGroup.getChildAt(childCount);
//                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
//                    if (canScroll(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
//                        return true;
//                    }
//                }
//            }
//        }
//        if (z && ViewCompat.canScrollHorizontally(view, -i)) {
//            return true;
//        }
//        return false;
//    }
//
//    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
//        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
//    }
//
//    public boolean executeKeyEvent(KeyEvent keyEvent) {
//        if (keyEvent.getAction() != 0) {
//            return false;
//        }
//        switch (keyEvent.getKeyCode()) {
//            case 21:
//                return arrowScroll(17);
//            case 22:
//                return arrowScroll(66);
//            case 61:
//                if (VERSION.SDK_INT < 11) {
//                    return false;
//                }
//                if (KeyEventCompat.hasNoModifiers(keyEvent)) {
//                    return arrowScroll(2);
//                }
//                if (KeyEventCompat.hasModifiers(keyEvent, 1)) {
//                    return arrowScroll(1);
//                }
//                return false;
//            default:
//                return false;
//        }
//    }
//
//    public boolean arrowScroll(int i) {
//        View view;
//        boolean d;
//        View findFocus = findFocus();
//        if (findFocus == this) {
//            view = null;
//        } else {
//            if (findFocus != null) {
//                Object obj;
//                for (android.support.v4.view.ViewPager parent = findFocus.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
//                    if (parent == this) {
//                        obj = 1;
//                        break;
//                    }
//                }
//                obj = null;
//                if (obj == null) {
//                    StringBuilder stringBuilder = new StringBuilder();
//                    stringBuilder.append(findFocus.getClass().getSimpleName());
//                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
//                        stringBuilder.append(" => ").append(parent2.getClass().getSimpleName());
//                    }
//                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + stringBuilder.toString());
//                    view = null;
//                }
//            }
//            view = findFocus;
//        }
//        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
//        if (findNextFocus == null || findNextFocus == view) {
//            if (i == 17 || i == 1) {
//                d = d();
//            } else {
//                if (i == 66 || i == 2) {
//                    d = e();
//                }
//                d = false;
//            }
//        } else if (i == 17) {
//            d = (view == null || a(this.g, findNextFocus).left < a(this.g, view).left) ? findNextFocus.requestFocus() : d();
//        } else {
//            if (i == 66) {
//                d = (view == null || a(this.g, findNextFocus).left > a(this.g, view).left) ? findNextFocus.requestFocus() : e();
//            }
//            d = false;
//        }
//        if (d) {
//            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
//        }
//        return d;
//    }
//
//    private Rect a(Rect rect, View view) {
//        Rect rect2;
//        if (rect == null) {
//            rect2 = new Rect();
//        } else {
//            rect2 = rect;
//        }
//        if (view == null) {
//            rect2.set(0, 0, 0, 0);
//            return rect2;
//        }
//        rect2.left = view.getLeft();
//        rect2.right = view.getRight();
//        rect2.top = view.getTop();
//        rect2.bottom = view.getBottom();
//        android.support.v4.view.ViewPager parent = view.getParent();
//        while ((parent instanceof ViewGroup) && parent != this) {
//            ViewGroup viewGroup = parent;
//            rect2.left += viewGroup.getLeft();
//            rect2.right += viewGroup.getRight();
//            rect2.top += viewGroup.getTop();
//            rect2.bottom += viewGroup.getBottom();
//            parent = viewGroup.getParent();
//        }
//        return rect2;
//    }
//
//    boolean d() {
//        if (this.i <= 0) {
//            return false;
//        }
//        setCurrentItem(this.i - 1, true);
//        return true;
//    }
//
//    boolean e() {
//        if (this.h == null || this.i >= this.h.getCount() - 1) {
//            return false;
//        }
//        setCurrentItem(this.i + 1, true);
//        return true;
//    }
//
//    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
//        int size = arrayList.size();
//        int descendantFocusability = getDescendantFocusability();
//        if (descendantFocusability != 393216) {
//            for (int i3 = 0; i3 < getChildCount(); i3++) {
//                View childAt = getChildAt(i3);
//                if (childAt.getVisibility() == 0) {
//                    ue a = a(childAt);
//                    if (a != null && a.b == this.i) {
//                        childAt.addFocusables(arrayList, i, i2);
//                    }
//                }
//            }
//        }
//        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
//            return;
//        }
//        if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
//            arrayList.add(this);
//        }
//    }
//
//    public void addTouchables(ArrayList<View> arrayList) {
//        for (int i = 0; i < getChildCount(); i++) {
//            View childAt = getChildAt(i);
//            if (childAt.getVisibility() == 0) {
//                ue a = a(childAt);
//                if (a != null && a.b == this.i) {
//                    childAt.addTouchables(arrayList);
//                }
//            }
//        }
//    }
//
//    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
//        int i2;
//        int i3 = -1;
//        int childCount = getChildCount();
//        if ((i & 2) != 0) {
//            i3 = 1;
//            i2 = 0;
//        } else {
//            i2 = childCount - 1;
//            childCount = -1;
//        }
//        while (i2 != childCount) {
//            View childAt = getChildAt(i2);
//            if (childAt.getVisibility() == 0) {
//                ue a = a(childAt);
//                if (a != null && a.b == this.i && childAt.requestFocus(i, rect)) {
//                    return true;
//                }
//            }
//            i2 += i3;
//        }
//        return false;
//    }
//
//    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
//        if (accessibilityEvent.getEventType() == 4096) {
//            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
//        }
//        int childCount = getChildCount();
//        for (int i = 0; i < childCount; i++) {
//            View childAt = getChildAt(i);
//            if (childAt.getVisibility() == 0) {
//                ue a = a(childAt);
//                if (a != null && a.b == this.i && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
//        return new LayoutParams();
//    }
//
//    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
//        return generateDefaultLayoutParams();
//    }
//
//    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
//        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
//    }
//
//    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
//        return new LayoutParams(getContext(), attributeSet);
//    }
//}
