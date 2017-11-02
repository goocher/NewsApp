package com.example.gooch.newspractice;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    private RecyclerView mRvContent;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mains, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        mRvContent = view.findViewById(R.id.rv_main_content);
        initData();
    }

    private void initData() {
        EasyHttp.get(ApiConfig.CARD_LIST)
                .execute(new SimpleCallBack<List<CardBean.CardListEntity>>() {
                    @Override
                    public void onError(ApiException e) {

                    }

                    @Override
                    public void onSuccess(List<CardBean.CardListEntity> cardListEntities) {

                    }
                });
    }

}
