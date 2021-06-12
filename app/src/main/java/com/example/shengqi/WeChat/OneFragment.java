package com.example.shengqi.WeChat;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shengqi.R;

import java.util.ArrayList;
import java.util.List;

public class OneFragment extends Fragment {

    private RecyclerView recyclerView;

    public OneFragment() {
    }

    public OneFragment(int contentLayoutId) {
        super(contentLayoutId);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.wechat_one,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        recyclerView = view.findViewById(R.id.one_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new MyDecoration(getContext()));

        OneAdapter adapter = new OneAdapter(initModel(), new OneAdapter.OnItemClick() {
            @Override
            public void onclick(oneModel model) {
                Toast.makeText(getContext(),model.getText(),Toast.LENGTH_LONG).show();
            }
        });


        recyclerView.setAdapter(adapter);

    }

    class MyDecoration extends RecyclerView.ItemDecoration{
        private Paint dividerPaint;


        public MyDecoration(Context context) {
            dividerPaint = new Paint();
            dividerPaint.setColor(context.getResources().getColor(R.color.colorAccent));
        }

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            int lastCount = parent.getAdapter().getItemCount() - 1;

            outRect.set(0,0,0,getResources().getDimensionPixelOffset(R.dimen.dividerhHeight));

        }

        @Override
        public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
            int childCount = parent.getChildCount();
            int left = parent.getPaddingLeft();
            int right = parent.getWidth() - parent.getPaddingRight();

            for (int i = 0; i < childCount - 1; i++) {
                View view = parent.getChildAt(i);
                float top = view.getBottom();
                float bottom = view.getBottom() + getResources().getDimensionPixelOffset(R.dimen.dividerhHeight);
                c.drawRect(left, top, right, bottom, dividerPaint);
            }
        }

        @Override
        public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.onDrawOver(c, parent, state);
        }
    }


    public List<oneModel> initModel(){
        List<oneModel> list = new ArrayList<>();

        list.add(new oneModel("张三", "我是张三", R.drawable.mao));
        list.add(new oneModel("李四", "我是李四", R.drawable.mao));
        list.add(new oneModel("王五", "我是王五", R.drawable.mao));
        list.add(new oneModel("赵六", "过来玩呀啊", R.drawable.mao));
        list.add(new oneModel("刘七", "你真棒", R.drawable.mao));
        list.add(new oneModel("孙八", "可厉害了", R.drawable.mao));
        list.add(new oneModel("马九", "Android", R.drawable.mao));
        list.add(new oneModel("钱十", "JavaScript", R.drawable.mao));
        list.add(new oneModel("钱十", "JavaScript", R.drawable.mao));
        list.add(new oneModel("钱十", "JavaScript", R.drawable.mao));
        list.add(new oneModel("钱十", "JavaScript", R.drawable.mao));
        list.add(new oneModel("钱十", "JavaScript", R.drawable.mao));
        list.add(new oneModel("钱十", "JavaScript", R.drawable.mao));
        list.add(new oneModel("钱十", "JavaScript", R.drawable.mao));
        list.add(new oneModel("钱十", "JavaScript", R.drawable.mao));
        list.add(new oneModel("钱十", "JavaScript", R.drawable.mao));
        list.add(new oneModel("钱十", "JavaScript", R.drawable.mao));

        return list;
    }

}
