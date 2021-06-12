package com.example.shengqi.WeChat;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.shengqi.R;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.ImageViewerPopupView;
import com.lxj.xpopup.interfaces.OnSrcViewUpdateListener;
import com.lxj.xpopup.interfaces.XPopupImageLoader;

import java.io.File;
import java.util.List;

public class CAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    List<Object> list;

    public CAdapter(List<Object> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapterViewHolder1(LayoutInflater.from(parent.getContext()).inflate(R.layout.img_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        AdapterViewHolder1 holder1 = (AdapterViewHolder1) holder;

        holder1.m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new XPopup.Builder(view.getContext()).asImageViewer(holder1.m1, position, list, new OnSrcViewUpdateListener() {
                    @Override
                    public void onSrcViewUpdate(ImageViewerPopupView popupView, int position) {
                        // 作用是当Pager切换了图片，需要更新源View
                        popupView.updateSrcView(holder1.m1);
                    }
                }, new ImageLoader())
                        .show();
            }
        });

        Glide.with(holder.itemView).load(list.get(position)).into(holder1.m1);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class AdapterViewHolder1 extends RecyclerView.ViewHolder {


        private ImageView m1;

        public AdapterViewHolder1(@NonNull View itemView) {
            super(itemView);
            m1 = itemView.findViewById(R.id.duoyulan);

        }
    }
    // 图片加载器，XPopup不负责加载图片，需要你实现一个图片加载器传给我，这里以Glide为例（可直接复制到项目中）:
    class ImageLoader implements XPopupImageLoader {
        private RequestOptions buildOptions() {
            return new RequestOptions()
                    .dontAnimate()
                    .dontTransform()
                    .skipMemoryCache(false)
                    .diskCacheStrategy(DiskCacheStrategy.ALL);
        }

        @Override
        public void loadImage(final int position, @NonNull final Object url, @NonNull final ImageView imageView) {
            //如果你确定你的图片没有超级大的，直接这样写就行
            //Glide.with(imageView).load(url).apply(new RequestOptions().override(Target.SIZE_ORIGINAL)).into(imageView);

            //下面的写法，可以加载超级大图,比如1280 x 28000的大图
            Glide.with(imageView).load(url).apply(buildOptions()).into(new CustomTarget<Drawable>() {
                @Override
                public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                    if (resource != null && resource instanceof BitmapDrawable) {
                        BitmapDrawable bd = (BitmapDrawable) resource;
                        int unit10M = 10 * 1024 * 1024;
                        int r = bd.getBitmap().getByteCount() / unit10M;
                        if (r >= 1) {
                            int w = resource.getIntrinsicWidth() / r;
                            int h = resource.getIntrinsicHeight() / r;
                            Glide.with(imageView).load(url).apply(buildOptions().override(w, h)).into(imageView);
                        } else {
                            imageView.setImageDrawable(resource);
                        }
                    } else {
                        imageView.setImageDrawable(resource);
                    }
                }

                @Override
                public void onLoadCleared(@Nullable Drawable placeholder) {
                }
            });
        }

        //实现这个方法，返回uri对应的缓存文件，可参照下面的实现，内部保存图片会用到。如果你不需要保存图片这个功能，可以返回null。
        @Override
        public File getImageFile(@NonNull Context context, @NonNull Object uri) {
            try {
                return Glide.with(context).downloadOnly().load(uri).submit().get();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
