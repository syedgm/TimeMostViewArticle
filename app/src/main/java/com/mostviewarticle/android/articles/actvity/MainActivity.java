package com.mostviewarticle.android.articles.actvity;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.mostviewarticle.android.R;
import com.mostviewarticle.android.articles.adapter.DrawerMenuItemsAdapter;
import com.mostviewarticle.android.articles.fragment.MostViewArticleFragment;
import com.mostviewarticle.android.articles.fragment.SettingsFragment;
import com.mostviewarticle.android.data.model.DrawerModel;
import com.mostviewarticle.android.util.NestedListView;
import com.mostviewarticle.android.util.Utils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseFragmentActivity implements View.OnClickListener, AdapterView.OnItemClickListener, SettingsFragment.OnFragmentInteractionListener{


    @BindView(R.id.action_bar)
    Toolbar actionBar;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.toolbar_progress_bar)
    ProgressBar toolbarProgressBar;

    ActionBarDrawerToggle drawerToggle;
    View.OnClickListener originalToggleEvent;
    @BindView(R.id.menu_items)
    NestedListView menuItems;
    int iconCount = 0;
    String language[];
    DrawerMenuItemsAdapter drawerMenuItemsAdapter;
    ArrayList<DrawerModel> drawerModelArrayList;

    String title = "";
    @BindView(R.id.drawer_left)
    LinearLayout drawerLeft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        inits();
        setEvents();
    }

    @Override
    public void setEvents() {
        menuItems.setOnItemClickListener(this);
    }



    @Override
    public void inits() {

        ReplaceFragment(new MostViewArticleFragment());
        initActionBar();
        setDrawerMenuItemsAdapter("en");

    }



    private void initActionBar() {
        setSupportActionBar(actionBar);
        drawerToggle = new ActionBarDrawerToggle(
                this, drawerLayout, actionBar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close
        );

        drawerLayout.setDrawerListener(drawerToggle);
        getSupportActionBar().setHomeButtonEnabled(true);
        drawerToggle.syncState();

        }




    public void setDrawerMenuItemsAdapter(String lang) {




        drawerModelArrayList = new ArrayList<>();
        if (lang.equals("en")) {
            Utils.savelanguage(MainActivity.this,"en");
            getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            getSupportActionBar().setTitle(title);
            language = getResources().getStringArray(R.array.menu_item_en);
        } else {
            getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
            getSupportActionBar().setTitle(title);
            language = getResources().getStringArray(R.array.menu_item_ar);
        }
        int icons[] = {R.mipmap.icon_events, R.mipmap.icon_events};

        for (String menuTitles : language) {
            DrawerModel drawerModel = new DrawerModel();
            drawerModel.setIcon(icons[iconCount]);
            drawerModel.setTitle(menuTitles);
            drawerModelArrayList.add(drawerModel);
            iconCount++;
        }

        drawerMenuItemsAdapter = new DrawerMenuItemsAdapter(MainActivity.this, drawerModelArrayList);
        menuItems.setAdapter(drawerMenuItemsAdapter);
    }




    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        DrawerModel drawerModel = drawerModelArrayList.get(position);


        if(position==1) {
            ReplaceFragment(new SettingsFragment());

        }else{
            ReplaceFragment(new MostViewArticleFragment());

        }
        drawerLayout.closeDrawer(GravityCompat.START);

    }

    @Override
    public void onClick(View v) {


    }


    @Override
    public void onFragmentInteraction(String title) {

        iconCount = 0;
        setDrawerMenuItemsAdapter(title);
        String actionTitle = (title.equals("en")) ? "Settings" : "إعدادات";

        getSupportActionBar().setTitle(actionTitle);


    }


    public void showLoader() {
        toolbarProgressBar.setVisibility(View.VISIBLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }

    public void hideLoader() {
        toolbarProgressBar.setVisibility(View.GONE);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }

}
