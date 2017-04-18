package com.venus.android.ui.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ToxicBakery.viewpager.transforms.ABaseTransformer;
import com.ToxicBakery.viewpager.transforms.DefaultTransformer;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.venus.android.R;
import com.venus.android.custom.AppBar;
import com.venus.android.custom.banner.LocalImageHolderView;
import com.venus.android.di.components.MainComponent;
import com.venus.android.presenter.HomePresenter;
import com.venus.android.ui.BaseFragment;
import com.venus.android.view.HomeView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class HomeFragment extends BaseFragment<HomePresenter> implements HomeView ,AdapterView.OnItemClickListener, ViewPager.OnPageChangeListener, OnItemClickListener {

    @InjectView(R.id.convenientBanner)
    ConvenientBanner convenientBanner;

    @InjectView(R.id.lv_product)
    ListView lvProduct;

    @InjectView(R.id.rl_marquee)
    RelativeLayout rlMaquee;
    @InjectView(R.id.tv_marquee_msg)
    TextView tvMarqueeMsg;
    @InjectView(R.id.iv_marquee)
    ImageView ivMarquee;


    private String[] images = {"http://img2.imgtn.bdimg.com/it/u=3093785514,1341050958&fm=21&gp=0.jpg",
            "http://img2.3lian.com/2014/f2/37/d/40.jpg",
            "http://d.3987.com/sqmy_131219/001.jpg",
            "http://img2.3lian.com/2014/f2/37/d/39.jpg",
            "http://www.8kmm.com/UploadFiles/2012/8/201208140920132659.jpg",
            "http://f.hiphotos.baidu.com/image/h%3D200/sign=1478eb74d5a20cf45990f9df460b4b0c/d058ccbf6c81800a5422e5fdb43533fa838b4779.jpg",
            "http://f.hiphotos.baidu.com/image/pic/item/09fa513d269759ee50f1971ab6fb43166c22dfba.jpg"
    };


    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainComponent) getComponent(MainComponent.class)).inject(this);
        if (activity != null) {
            ((HomePresenter) this.presenter).setView(this);
            ((HomePresenter) this.presenter).setInteractionListener((InteractionListener) getActivity());
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_home, null);
//        View headView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home_headview, null);
//        this.recommendAdapter = new RecommendProductAdapter(getContext(), mDatas, R.layout.item_home_product, this);
//        lvProduct.addHeaderView(headView);
//        this.lvProduct.setAdapter(this.recommendAdapter);
        ButterKnife.inject((Object) this, inflate);
        return inflate;
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        ((HomePresenter) this.presenter).init();
        convenientBanner.setPages(new CBViewHolderCreator<LocalImageHolderView>() {
            @Override
            public LocalImageHolderView createHolder() {
                return new LocalImageHolderView();
            }
        }, this.presenter.getInitImage())
                .setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused})
                .setOnItemClickListener(this);
    }

    public void onInitAppBar(AppBar appBar) {
        super.onInitAppBar(appBar);
        setHasAppBar(false);
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (!z) {
            setHasAppBar(false);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    // 开始自动翻页
    @Override
    public void onResume() {
        super.onResume();
        //开始自动翻页
        convenientBanner.startTurning(5000);
    }

    // 停止自动翻页
    @Override
    public void onPause() {
        super.onPause();
        //停止翻页
        convenientBanner.stopTurning();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //控制是否循环
        convenientBanner.setCanLoop(!convenientBanner.isCanLoop());
        String transforemerName = DefaultTransformer.class.getSimpleName();
        try {
            Class cls = Class.forName("com.ToxicBakery.viewpager.transforms." + transforemerName);
            ABaseTransformer transforemer= (ABaseTransformer)cls.newInstance();
            convenientBanner.getViewPager().setPageTransformer(true,transforemer);

            //部分3D特效需要调整滑动速度
            if(transforemerName.equals("StackTransformer")){
                convenientBanner.setScrollDuration(1200);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(getContext(),"点击了第"+position+"个",Toast.LENGTH_SHORT).show();
    }
}
