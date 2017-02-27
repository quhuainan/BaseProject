package com.qhn.bhne.baseproject.mvp.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qhn.bhne.baseproject.R;
import com.qhn.bhne.baseproject.di.scope.ContextLife;
import com.qhn.bhne.baseproject.mvp.entity.RecommendContent;
import com.qhn.bhne.baseproject.mvp.ui.adapter.base.BaseRecyclerViewAdapter;
import com.qhn.bhne.baseproject.mvp.ui.fragment.RecommendMusicFragment;
import com.qhn.bhne.baseproject.utils.MyUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by qhn
 * on 2016/11/3 0003.
 */

public class HotMusicRecyclerAdapter extends BaseRecyclerViewAdapter {




    @Inject
    public HotMusicRecyclerAdapter() {
        super(null);
        category = getCategory();
    }

    @ContextLife("Fragment")
    @Inject
    Context context;

    private int category;

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = getView(parent, R.layout.item_hot_music);
        return new ItemViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);

        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;

        switch (category) {
            case RecommendMusicFragment.HOT_ADAPTER:
                RecommendContent.DataBean.InfoBean.RecommendBean recommendBeanBean =
                        (RecommendContent.DataBean.InfoBean.RecommendBean) getList().get(position);

                RecommendContent.DataBean.InfoBean.RecommendBean.ExtraBean extraBean = recommendBeanBean.getExtra();
                itemViewHolder.txtMusicAlbumName.setText(extraBean.getSpecialname());
                itemViewHolder.txtListen.setText(MyUtils.dealBigNum(extraBean.getPlay_count()));
                MyUtils.loadImageFormNet(extraBean.getImgurl().replace("{size}", "400"), itemViewHolder.imgPic, context);
                break;
            case RecommendMusicFragment.NEW_ADAPTER:
                RecommendContent.DataBean.InfoBean.AlbumBean albumBean =
                        (RecommendContent.DataBean.InfoBean.AlbumBean) getList().get(position);
                itemViewHolder.txtListen.setVisibility(View.GONE);
                itemViewHolder.txtMusicAlbumName.setText(albumBean.getAlbumname());
                itemViewHolder.txtAlbumAuthor.setVisibility(View.VISIBLE);
                itemViewHolder.txtAlbumAuthor.setText(albumBean.getSingername());
                MyUtils.loadImageFormNet(albumBean.getImgurl().replace("{size}", "400"), itemViewHolder.imgPic, context);

                break;
            case RecommendMusicFragment.REPORT_ADAPTER:

                itemViewHolder.txtListen.setVisibility(View.GONE);
                break;
            case RecommendMusicFragment.GOOD_MV_ADAPTER:

                RecommendContent.DataBean.InfoBean.VlistBean vlistBean =
                        (RecommendContent.DataBean.InfoBean.VlistBean) getList().get(position);
                itemViewHolder.txtMusicAlbumName.setText(vlistBean.getTitle());
                MyUtils.loadImageFormNet(vlistBean.getMobile_banner(), itemViewHolder.imgPic, context);
                break;
        }

    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_music_album_name)
        public TextView txtMusicAlbumName;
        @BindView(R.id.txt_album_author)
        public TextView txtAlbumAuthor;
        @BindView(R.id.txt_listen)
        public TextView txtListen;
        @BindView(R.id.img_pic)
        public ImageView imgPic;

        public ItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
