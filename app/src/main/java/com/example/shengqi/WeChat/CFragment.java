package com.example.shengqi.WeChat;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.shengqi.R;
import com.lxj.xpopup.interfaces.XPopupImageLoader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CFragment extends Fragment {

    private ImageView imageView;
    private RecyclerView recyclerView;
    List<Object> list = new ArrayList<Object>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.cfragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        imageView = view.findViewById(R.id.yulan);

        list.add("https://s.lingman.tech/dev/uploadfiles/20210419/cYKEd7zKPkXmBAWDDfSthxKwXRXQ8NYQ.png");
        list.add("https://s.lingman.tech/dev/uploadfiles/20210425/ihXhjNwGAjDJfttRp6R8SPpBm6BbS7PR.png");
        list.add("https://s.lingman.tech/dev/uploadfiles/20210425/WwZYiZXkhpmhQJcQSRBPYJNpSfJEdQN4.png");

        recyclerView = view.findViewById(R.id.one_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        CAdapter adapter = new CAdapter(list);

        recyclerView.setAdapter(adapter);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                new XPopup.Builder(getContext())
//                        .asImageViewer(imageView, imageView.getDrawable(), new ImageLoader())
//                        .show();



            }
        });

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
