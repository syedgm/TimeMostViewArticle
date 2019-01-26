package com.mostviewarticle.android.articles.fragment;
import com.mostviewarticle.android.R;
import com.mostviewarticle.android.util.Utils;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;


import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Saad on 2/2/2016.
 */
public class SettingsFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.radioButton)
    RadioButton engRadioBtn;
    @BindView(R.id.radioButton2)
    RadioButton arabicRadioBtn;


    private OnFragmentInteractionListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.settings_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (Exception ex) {

        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        inits();
        setEvents();

    }

    @Override
    public void onClick(View v) {

        if (v == arabicRadioBtn) {
            context.getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
            Utils.savelanguage(context, "ar");
            setLanguage("ar");
            if (mListener != null) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.detach(this).attach(this).commit();
                mListener.onFragmentInteraction(Utils.getlanguage(context));
            }

        }
        if (v == engRadioBtn) {
            context.getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            Utils.savelanguage(context, "en");
            setLanguage("en");
            if (mListener != null) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.detach(this).attach(this).commit();
                mListener.onFragmentInteraction(Utils.getlanguage(context));
            }

        }


    }

    @Override
    public void inits() {


        if (Utils.getlanguage(context).equals("en")) {
            engRadioBtn.setChecked(true);
            arabicRadioBtn.setChecked(false);

        } else {

            arabicRadioBtn.setChecked(true);
            engRadioBtn.setChecked(false);
        }
        setLanguage(Utils.getlanguage(context));
    }

    @Override
    public void setEvents() {

        arabicRadioBtn.setOnClickListener(this);
        engRadioBtn.setOnClickListener(this);



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    private void setLanguage(String language) {
        if (language.equals("en")) {
              textView2.setText("Language");
        } else {
            textView2.setText("لغة");
        }
    }


    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(String title);
    }




}
