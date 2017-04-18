package com.venus.android.presenter;

import android.content.Context;

import com.venus.android.data.repository.EnvironmentDataRepository;
import com.venus.android.view.NoAssetsView.InteractionListener;
import com.venus.android.view.NoAssetsView;

import javax.inject.Inject;

/**
 * Created by lev on 5/30/16.
 */
public class NoAssetsPresenter extends BasePresenter {

    private Context context;
    private EnvironmentDataRepository environmentDataRepository;
    private InteractionListener interactionListener;
    private NoAssetsView view;

    public NoAssetsView getView() {
        return view;
    }

    public void setView(NoAssetsView view) {
        this.view = view;
    }

    public InteractionListener getInteractionListener() {
        return interactionListener;
    }

    public void setInteractionListener(InteractionListener interactionListener) {
        this.interactionListener = interactionListener;
    }


    @Inject
    public NoAssetsPresenter( Context context, EnvironmentDataRepository environmentDataRepository) {
        this.context = context;
        this.environmentDataRepository = environmentDataRepository;
    }

}