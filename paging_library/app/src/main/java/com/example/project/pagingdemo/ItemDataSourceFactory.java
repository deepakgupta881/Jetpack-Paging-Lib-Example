package com.example.project.pagingdemo;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;
import android.arch.paging.PageKeyedDataSource;

public class ItemDataSourceFactory extends DataSource.Factory{

private MutableLiveData<PageKeyedDataSource<Integer,Item>> itemDataSourceList=new MutableLiveData<>();

    @Override
    public DataSource create() {
        ItemDataSource itemDataSource=new ItemDataSource();
        itemDataSourceList.postValue(itemDataSource);
        return itemDataSource;
    }

    public MutableLiveData<PageKeyedDataSource<Integer,Item>> getItemDataSourceList(){
        return itemDataSourceList;
    }
}
