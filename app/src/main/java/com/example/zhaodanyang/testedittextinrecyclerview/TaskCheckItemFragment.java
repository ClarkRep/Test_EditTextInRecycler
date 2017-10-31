
package com.example.zhaodanyang.testedittextinrecyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class TaskCheckItemFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task_check_item_layout, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        TaskCheckItemAdapter adapter = new TaskCheckItemAdapter();
        recyclerView.setAdapter(adapter);
        List<TaskCheckItemEntity.ItemEntity> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            TaskCheckItemEntity.ItemEntity itemEntity = new TaskCheckItemEntity.ItemEntity();
            itemEntity.name = "测试";
            list.add(itemEntity);
        }
        adapter.bindData(true, list);
        return view;
    }
}
