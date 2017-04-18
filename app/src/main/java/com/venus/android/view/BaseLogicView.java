package com.venus.android.view;

import android.content.Context;

public interface BaseLogicView {
    Context getContext();

    void hideLoading();

    void hideSoftKeyBoard();

    void showSoftKeyBoard();

    void loadToastFail();

    void loadToastSuccess();

    void showLoadToast(String str);

    void setErrorPageVisible(boolean z);

    void showError(String str);

    void showFormFilterDialog(String str);

    void showLoading();

    void showLoading(String str);

    void showToast(String str);
}
