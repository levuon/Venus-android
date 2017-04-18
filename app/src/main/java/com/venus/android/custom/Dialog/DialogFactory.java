package com.venus.android.custom.Dialog;



/**
 * Created by lev on 5/29/16.
 */

public class DialogFactory {
    public static DoubleBtnConfirmDialog.Builder getDoubleBtnDialogBuilder() {
        return DoubleBtnConfirmDialog.builder();
    }

//    public static SingleBtnConfirmDialog.Builder getSingelBtnDialogBuilder() {
//        return SingleBtnConfirmDialog.builder();
//    }

    public static LoadingDialog.Builder getLoadingDailogBuilder() {
        return LoadingDialog.a();
    }

//    public static TimeChooseDialog.Builder getTimeChooseDialogBuidler() {
//        return TimeChooseDialog.a();
//    }

//    public static ListDialog.Builder getListDialogBuidler() {
//        return ListDialog.a();
//    }
}
