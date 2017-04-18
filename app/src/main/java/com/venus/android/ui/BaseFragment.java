package com.venus.android.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.venus.android.R;
import com.venus.android.custom.AppBar;
import com.venus.android.custom.Dialog.DialogFactory;
import com.venus.android.di.HasComponent;
import com.venus.android.presenter.BasePresenter;
import com.venus.android.utils.InputTypeUtil;
import com.venus.android.utils.ScreenUtil;
import com.venus.android.utils.Toaster;
import com.venus.android.view.BaseLogicView;

import net.steamcrafted.loadtoast.LoadToast;

import javax.inject.Inject;

import butterknife.InjectView;
import butterknife.Optional;
import timber.log.Timber;

public class BaseFragment<T extends BasePresenter> extends Fragment implements BaseLogicView {
    private LoadToast loadToast;
    public AppBar appBar;
    private Dialog dialog;
    protected BackHandlerInterface backHandlerInterface;
    @InjectView(R.id.common_v_error)
    @Optional
    public View mErrorPage;
    @Inject
    public T presenter;

    public interface BackHandlerInterface {
        void setSelectedFragment(BaseFragment baseFragment);
    }

    public void onResume() {
        super.onResume();
        if (this.presenter != null) {
            this.presenter.resume();
        }
    }

    public void onPause() {
        super.onPause();
        if (this.presenter != null) {
            this.presenter.pause();
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Timber.i("fragment-onAttach", new Object[0]);
        if (getActivity() instanceof BackHandlerInterface) {
            this.backHandlerInterface = (BackHandlerInterface) getActivity();
            return;
        }
        throw new ClassCastException("Hosting activity must implement BackHandlerInterface or you Host Activity must extends from BaseActivity");
    }

    public void onStart() {
        super.onStart();
        this.backHandlerInterface.setSelectedFragment(this);
    }

    public void onHiddenChanged(boolean z) {
        Timber.d("onHiddenChanged() called with: hidden = [" + z + "]", new Object[0]);
        super.onHiddenChanged(z);
        if (!z && getActivity() != null) {
            if (getActivity() instanceof BackHandlerInterface) {
                this.backHandlerInterface = (BackHandlerInterface) getActivity();
                this.backHandlerInterface.setSelectedFragment(this);
                return;
            }
            throw new ClassCastException("Hosting activity must implement BackHandlerInterface");
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Timber.i("fragment-onCreateView", new Object[0]);
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onViewStateRestored(@Nullable Bundle bundle) {
        Timber.i("fragment-onViewStateRestored", new Object[0]);
        super.onViewStateRestored(bundle);
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        Timber.i("fragment-onActivityCreated", new Object[0]);
        if (this.presenter != null) {
            this.presenter.create();
        }
        if (getActivity() != null && (getActivity() instanceof BaseActivity)) {
            this.appBar = ((BaseActivity) getActivity()).getAppBar();
            onInitAppBar(this.appBar);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Timber.i("fragment-onSaveInstanceState", new Object[0]);
    }

    public void onDestroyView() {
        Timber.i("fragment-onDestroyView", new Object[0]);
        super.onDestroyView();
        if (this.presenter != null) {
            this.presenter.destroy();
        }
    }

    public void onDetach() {
        Timber.i("fragment-onDetach", new Object[0]);
        super.onDetach();
    }

    public void setHasAppBar(boolean z) {
        if (this.appBar != null) {
            if (z) {
                this.appBar.setVisibility(View.VISIBLE);
            } else {
                this.appBar.setVisibility(View.GONE);
            }
        }
    }

    public void onInitAppBar(AppBar appBar) {
    }

    public void initFragment(Fragment fragment) {
        if (fragment.getArguments() == null) {
            fragment.setArguments(new Bundle());
        }
        ((BaseActivity) getActivity()).initFragment(fragment);
    }

    public void changeFragment(Fragment fragment) {
        if (fragment.getArguments() == null) {
            fragment.setArguments(new Bundle());
        }
        ((BaseActivity) getActivity()).changeFragment(fragment);
    }

    public void addFragment(Fragment fragment) {
        if (fragment.getArguments() == null) {
            fragment.setArguments(new Bundle());
        }
        ((BaseActivity) getActivity()).addFragment(fragment);
    }

    public boolean onFragmentBackPressed() {
        return false;
    }

    public Context getContext() {
        return getActivity();
    }

    public void showError(String str) {
        Toaster.shortShow(getContext(), str);
//        SnackBarUtils.showShortSnackBar(this.appBar, str);
    }

    public void showLoading(String str) {
        Timber.i("showLoading----------------------", new Object[0]);
        if (this.dialog != null && this.dialog.isShowing()) {
            this.dialog.dismiss();
        }
        this.dialog = DialogFactory.getLoadingDailogBuilder().setMsg(str).setTouchOutDismss(false).build(getContext());
        this.dialog.show();
    }

    @Override
    public void showToast(String str) {
        if (getActivity() != null) {
            Toaster.shortShow(getContext(), str);
        }
    }

    public void showLoading() {
        if (this.dialog != null && this.dialog.isShowing()) {
            this.dialog.dismiss();
        }
        this.dialog = DialogFactory.getLoadingDailogBuilder().setMsg("正在加载,请稍等...").setTouchOutDismss(false).build(getContext());
        this.dialog.show();
    }
    public void hideLoading() {
        if (this.dialog != null && this.dialog.isShowing()) {
            this.dialog.dismiss();
        }
    }

    public void showSoftKeyBoard() {
        InputTypeUtil.openSoftKeyBoard(getContext().getApplicationContext(), this.appBar);
    }

    @Override
    public void loadToastFail() {
        if (this.loadToast != null) {
            this.loadToast.error();
        }
    }

    @Override
    public void loadToastSuccess() {
        if(this.loadToast != null) {
            this.loadToast.success();
        }
    }

    @Override
    public void showLoadToast(String str) {
        if (getActivity() != null) {
            if (this.loadToast == null) {
                this.loadToast = new LoadToast(getActivity());
                this.loadToast.setBackgroundColor(getResources().getColor(R.color.palette_white))
                        .setProgressColor(getResources()
                                .getColor(R.color.palette_red))
                        .setTextColor(getResources()
                                .getColor(R.color.palette_red));
                this.loadToast.setTranslationY(ScreenUtil.dip2px(getContext().getApplicationContext(), 50.0f));
            }
            this.loadToast.setText(str);
            this.loadToast.show();
        }
    }

    public void hideSoftKeyBoard() {
        if (getContext() != null) {
            InputTypeUtil.closeSoftKeyBoard(getContext().getApplicationContext(), this.appBar);
        }
    }

    public void showFormFilterDialog(String str) {
//        new Builder(getActivity()).setMessage((CharSequence) str).setPositiveButton((CharSequence) "确认", new but(this)).create().show();
    }

    public void setErrorPageVisible(boolean z) {
        if (this.mErrorPage == null) {
            return;
        }
        if (z) {
            this.mErrorPage.setVisibility(View.VISIBLE);
        } else {
            this.mErrorPage.setVisibility(View.INVISIBLE);
        }
    }

    public <C> C getComponent(Class<C> cls) {
        return cls.cast(((HasComponent) getActivity()).getComponent());
    }

    public T getPresenter() {
        return this.presenter;
    }
}
