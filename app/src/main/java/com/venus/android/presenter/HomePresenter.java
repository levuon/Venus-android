package com.venus.android.presenter;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.venus.android.R;
import com.venus.android.data.repository.EnvironmentDataRepository;
import com.venus.android.view.HomeView;
import com.venus.android.view.HomeView.InteractionListener;

import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by lev on 5/31/16.
 */
public class HomePresenter extends BasePresenter {

    private HomeView homeView;
    private InteractionListener interactionListener;
    private Context context;
    private EnvironmentDataRepository environmentDataRepository;
    private ArrayList<Integer> localImages = new ArrayList<Integer>();
    private ArrayAdapter transformerArrayAdapter;
    private ArrayList<String> transformerList = new ArrayList<String>();
    @Inject
    public HomePresenter(Context context, EnvironmentDataRepository environmentDataRepository) {
        this.environmentDataRepository = environmentDataRepository;
        this.context = context;
    }

    public void setInteractionListener(InteractionListener interactionListener) {
        this.interactionListener = interactionListener;
    }

    public void setView(HomeView view) {
        this.homeView = view;
    }

    public void init(){
        initImageLoader();
        loadTestDatas();
    }

    //初始化网络图片缓存库
    private void initImageLoader(){
        //网络图片例子,结合常用的图片缓存库UIL,你可以根据自己需求自己换其他网络图片库
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder().
                showImageForEmptyUri(R.drawable.ic_default_adimage)
                .cacheInMemory(true).cacheOnDisk(true).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                context).defaultDisplayImageOptions(defaultOptions)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .tasksProcessingOrder(QueueProcessingType.LIFO).build();
        ImageLoader.getInstance().init(config);
    }

    private void loadTestDatas() {
        //本地图片集合
        for (int position = 0; position < 7; position++)
            localImages.add(getResId("ic_test_" + position, R.drawable.class));
    }

    /**
     * 通过文件名获取资源id 例子：getResId("icon", R.drawable.class);
     *
     * @param variableName
     * @param c
     * @return
     */
    public static int getResId(String variableName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(variableName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    public ArrayList<Integer> getInitImage() {
        return localImages;
    }
}
