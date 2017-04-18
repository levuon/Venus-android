package com.venus.android.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.venus.android.R;
import com.venus.android.custom.AppBar;
import com.venus.android.custom.listener.AssetTradeRecordClick;
import com.venus.android.di.components.MainComponent;
import com.venus.android.presenter.NoAssetsPresenter;
import com.venus.android.ui.BaseFragment;
import com.venus.android.view.NoAssetsView;

import butterknife.ButterKnife;



/**
 * Created by lev on 6/2/16.
 */
public class NoAssetsFragment extends BaseFragment<NoAssetsPresenter> implements NoAssetsView {



	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
	}

	@Nullable
	public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
		View inflate = layoutInflater.inflate(R.layout.fragment_noassets, null);
		ButterKnife.inject((Object) this, inflate);
		return inflate;
	}

	public void onAttach(Activity activity) {
		super.onAttach(activity);
		((MainComponent) getComponent(MainComponent.class)).inject(this);
		if (activity != null) {
			((NoAssetsPresenter) this.presenter).setView(this);
			((NoAssetsPresenter) this.presenter).setInteractionListener((NoAssetsView.InteractionListener) activity);
		}
	}

	public void onActivityCreated(@Nullable Bundle bundle) {
		super.onActivityCreated(bundle);
//		((NoAssetsPresenter) this.presenter).init();
	}

	public void onInitAppBar(AppBar appBar) {
		super.onInitAppBar(appBar);
		setHasAppBar(true);
        appBar.setTitle(getActivity().getString(R.string.my_asset));
		appBar.setRightNavigation("交易记录", new AssetTradeRecordClick(this));
	}

	public void onDestroyView() {
		super.onDestroyView();
		ButterKnife.reset(this);
	}


	public void goTradeRecord(){

	}


}
