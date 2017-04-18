package com.venus.android.custom.listener;

import android.view.View;

import com.venus.android.custom.AppBar.OnRightClickListener;
import com.venus.android.ui.fragment.NoAssetsFragment;

/**
 * Created by lev on 6/6/16.
 */
public class AssetTradeRecordClick implements OnRightClickListener {
    final /* synthetic */ NoAssetsFragment NoAssetsFragment;

    public AssetTradeRecordClick(NoAssetsFragment NoAssetsFragment) {
        this.NoAssetsFragment = NoAssetsFragment;
    }

    public void onClick(View view) {
        this.NoAssetsFragment.goTradeRecord();
    }
}
