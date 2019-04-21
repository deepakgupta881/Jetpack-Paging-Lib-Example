package com.example.project.pagingdemo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PageKeyedDataSource;
import android.arch.paging.PagedList;

public class ItemViewModel extends ViewModel {
    LiveData<PagedList<Item>> itPagedListLiveData;
    LiveData<PageKeyedDataSource<Integer, Item>> liveData;

    public ItemViewModel() {

        ItemDataSourceFactory itemDataSourceFactory = new ItemDataSourceFactory();
        liveData = itemDataSourceFactory.getItemDataSourceList();

        PagedList.Config config = (new PagedList.Config.Builder()).setEnablePlaceholders(false)
                .setPageSize(ItemDataSource.PAGE_SIZE).build();
        itPagedListLiveData = (new LivePagedListBuilder(itemDataSourceFactory, config)).build();
    }
}
