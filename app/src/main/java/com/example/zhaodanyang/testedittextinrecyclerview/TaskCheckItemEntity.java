package com.example.zhaodanyang.testedittextinrecyclerview;

import android.text.TextUtils;

import java.io.Serializable;
import java.util.List;

public class TaskCheckItemEntity implements Serializable {

    public List<ItemEntity> items;

    public static class ItemEntity {
        public String id;
        public String taskId;
        public String name;
        public boolean state;//是否完成     true:完成   false:未完成

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ItemEntity itemEntity = (ItemEntity) o;

            return !TextUtils.isEmpty(id) && id.equals(itemEntity.id);
        }
    }

}
