package gotopark.com.IndiaLotto;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import gotopark.com.IndiaLotto.module.RssFragment;
import gotopark.com.IndiaLotto.module.Card;
import gotopark.com.IndiaLotto.module.CardArrayAdapter;

/**
 * Created by User on 12/27/2017.
 */

public class ActivityThree extends AppCompatActivity {

    private static final String TAG = "ActivityThree";
    public ListView listView;
    public CardArrayAdapter CardArrayAdapter;
    public ProgressDialog mProgressDialog;
    public InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        listView = (ListView) findViewById(R.id.card_listView);
        CardArrayAdapter = new CardArrayAdapter(getApplicationContext(), R.layout.list_item_card);
        listView.addFooterView(new View(this));
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ic_arrow:
                        Intent intent0 = new Intent(ActivityThree.this, MainActivity.class);
                        startActivity(intent0);
                        break;

                    case R.id.ic_android:
                        Intent intent1 = new Intent(ActivityThree.this, ActivityOne.class);
                        startActivity(intent1);
                        break;

                    case R.id.ic_books:
                        Intent intent3 = new Intent(ActivityThree.this, ActivityTwo.class);
                        startActivity(intent3);
                        break;

                    case R.id.ic_center_focus:

                        break;

                    case R.id.ic_backup:
                        Intent intent4 = new Intent(ActivityThree.this, ActivityFour.class);
                        startActivity(intent4);
                        break;
                }
                return false;
            }
        });
        Admob_is ();
    }


    public void Admob_is() {
        mInterstitialAd = new InterstitialAd(this);
//         admob
        AdView mAdView = (AdView) findViewById (R.id.adView);
        MobileAds.initialize (getApplicationContext (), getString (R.string.google_banner_id));
        AdRequest adRequest = new AdRequest.Builder ().build ();
        mAdView.loadAd (adRequest);
        mInterstitialAd.setAdUnitId(getString (R.string.interstitial_ad_unit_id));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onStart() {
        super.onStart();
        Context context = this;
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        assert cm != null;
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null) { // connected to the internet
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                // connected to wifi
                Toast.makeText(context, activeNetwork.getTypeName(), Toast.LENGTH_SHORT).show();
                /** 와이 파이 인터넷 연결시 시도 */
                XMLpase();
            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                // connected to the mobile provider's data plan
                Toast.makeText(context, activeNetwork.getTypeName(), Toast.LENGTH_SHORT).show();
                /** 모바일 연결시 시도  */
                XMLpase();

            }

        } else

        {
            /** 네트웍 문제 메세지 출력 */
            String iInfo1 = "Network Error!";
            String iInfo2 = "Please ON Wifi OR Mobile Network";
            String iInfo3 = "Need Internet!!!";
            Card card = new Card(iInfo1, iInfo2, iInfo3, "^.^;;", "", "");
            CardArrayAdapter.add(card);
            listView.setAdapter(CardArrayAdapter);
        }
    }

    public void XMLpase() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
//                Log.d("TAG", "The interstitial wasn't loaded yet.");
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.rlContainer, RssFragment.newInstance(getString(R.string.FeedLink3)))
                    .addToBackStack(null)
                    .commit();

        }

    }

}