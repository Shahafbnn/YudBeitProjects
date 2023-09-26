package com.example.yudbeitprojects;

import android.content.Intent;

public class ActivityListViewItem<T> {
    private String name;
    private T genericItem;

    public ActivityListViewItem(String name, T genericItem) {
        this.name = name;
        this.genericItem = genericItem;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getGenericItem() {
        return genericItem;
    }

    public void setGenericItem(T genericItem) {
        this.genericItem = genericItem;
    }

    @Override
    public String toString() {
        return name;
    }
}
