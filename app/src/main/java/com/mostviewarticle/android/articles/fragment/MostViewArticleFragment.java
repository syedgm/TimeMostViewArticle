package com.mostviewarticle.android.articles.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mostviewarticle.android.R;
import com.mostviewarticle.android.articles.adapter.MostViewArticleAdapter;
import com.mostviewarticle.android.util.Contract;
import com.mostviewarticle.android.data.retrofit.WebService;
import com.mostviewarticle.android.data.retrofit.WebServiceFactory;
import com.mostviewarticle.android.data.retrofit.WebResponse;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MostViewArticleFragment extends BaseFragment implements View.OnClickListener{


    public ArrayList<Contract.mostViewArticle> mostviewArrayList;
    @BindView(R.id.rc_mostview)
     RecyclerView mostView_recyleview;
    MostViewArticleAdapter adapter;
    private Activity activity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.mostview_fragment, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void inits() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mostView_recyleview.setLayoutManager(linearLayoutManager);
        adapter = new MostViewArticleAdapter(getActivity(), this);
        mostView_recyleview.setAdapter(adapter);

        getDataServer();
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity = getActivity();



    }


    private void getDataServer() {


        getMainActivity().showLoader();

        Retrofit client= WebServiceFactory.getClient();
        WebService apiInterface=client.create(WebService.class);
        Call<WebResponse<Contract.mostViewArticle>> call = apiInterface.mostViewHolder();



        call.enqueue(new Callback<WebResponse<Contract.mostViewArticle>>() {
            @Override
            public void onResponse(Call<WebResponse<Contract.mostViewArticle>> call, Response<WebResponse<Contract.mostViewArticle>> response) {

                getMainActivity().hideLoader();
                mostviewArrayList = response.body().results;
                adapter.addItems(mostviewArrayList);

            }

            @Override
            public void onFailure(Call<WebResponse<Contract.mostViewArticle>> call, Throwable t) {
                getMainActivity().hideLoader();

            }
        });




    }



    @Override
    public void onClick(View v) {

    }

    @Override
    public void setEvents() {

    }
}
