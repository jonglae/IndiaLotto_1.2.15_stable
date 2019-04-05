package gotopark.com.IndiaLotto;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

import gotopark.com.IndiaLotto.module.Card;
import gotopark.com.IndiaLotto.module.CardArrayAdapter;


/**
 * Created by User on 4/15/2017.
 */

public class ActivityOne extends Activity {

    public ListView listView;
    public CardArrayAdapter cardArrayAdapter;
    public ProgressDialog mProgressDialog;
    public InterstitialAd mInterstitialAd;

    private static final String TAG = "ActivityOne";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        listView = (ListView) findViewById(R.id.card_listView);

        cardArrayAdapter = new CardArrayAdapter(getApplicationContext(), R.layout.list_item_card);

        listView.addHeaderView(new View(this));
        listView.addFooterView(new View(this));


    BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
    Menu menu = bottomNavigationView.getMenu();
    MenuItem menuItem = menu.getItem(1);
    menuItem.setChecked(true);

    bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.ic_arrow:
                    Intent intent0 = new Intent(ActivityOne.this, MainActivity.class);
                    startActivity(intent0);
                    break;

                case R.id.ic_android:

                    break;

                case R.id.ic_books:
                    Intent intent2 = new Intent(ActivityOne.this, ActivityTwo.class);
                    startActivity(intent2);
                    break;

                case R.id.ic_center_focus:
                    Intent intent3 = new Intent(ActivityOne.this, ActivityThree.class);
                    startActivity(intent3);
                    break;

                case R.id.ic_backup:
                    Intent intent4 = new Intent(ActivityOne.this, ActivityFour.class);
                    startActivity(intent4);
                    break;
            }
            return false;
            }
        });

        Admob_is ();
    }



    public void Admob_is() {

        mInterstitialAd = new InterstitialAd (this);
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
                new LotonumCall().execute();

            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                // connected to the mobile provider's data plan
                Toast.makeText(context, activeNetwork.getTypeName(), Toast.LENGTH_SHORT).show();

                /** 모바일 연결시 시도  */
                new LotonumCall().execute();
            }

            } else

            {
               /** 네트웍 문제 메세지 출력 */

                String iInfo1 = "Network Error!";
                String iInfo2 = "Please ON Wifi OR Mobile Network";
                String iInfo3 = "Need Internet!!!";

                Card card = new Card(iInfo1, iInfo2, iInfo3, "i", "", "");
                cardArrayAdapter.add(card);
                listView.setAdapter(cardArrayAdapter);

            }
//        Ad_inter ();

    }


    @SuppressLint("StaticFieldLeak")
    private class LotonumCall extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute ();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog (ActivityOne.this);
            // Set progressdialog title
            mProgressDialog.setTitle ("India Lotto Result");
            // Set progressdialog message
            mProgressDialog.setMessage ("Please Wait...");
            mProgressDialog.setIndeterminate (false);
            // Show progressdialog
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
//                Log.d("TAG", "The interstitial wasn't loaded yet.");
                mProgressDialog.show ();
            }
        }

        Elements winperson1;
        Elements winperson2;
        Elements winperson3;
        Elements winperson4;
        Elements winperson5;
        String Error13;

        @Override
        public Void doInBackground(Void... params) {
            String url = getString(R.string.lotto_results);
            try {
                // Connect to the web site
                Document document = Jsoup.connect(url)
                        .timeout(7000)
                        .get();

                if (document != null) {
                    // Get the html document title
                    winperson1 = document.select(".headRow");
                    winperson2 = document.select(".lottery-title");
                    winperson3 = document.select(".blueTable table");
                    winperson4 = document.select("title");
                    winperson5 = document.select(".next-jackpot-small");
                    Error13 = document.text();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public void onPostExecute(Void result) {

            String Error14 = "ERROR 13: fmcFmtDate - Type mismatch";

            if ( Error13.equals (Error14)){
                for (int i = 0; i < 3 ; i++) {

                    String iInfo1 = "Network Error!! ^.^;";
                    String iInfo2 = "The network connection is poor.";
                    String iInfo3 = "Try again later!!!";
                    String iInfo4 = "If you To check your Lottery Number";

                    Card card = new Card (iInfo1, iInfo2, iInfo3, iInfo4, "", "");
                    cardArrayAdapter.add (card);
                    listView.setAdapter (cardArrayAdapter);
                }


            } else {

                    /** 로또 번호 */
                    String[] pbnum1 = new String[winperson1.size()];
                    for (int i = 0; i < winperson1.size(); i++) {
                        pbnum1[i] = winperson1.get(i).text();
                    }

                    String[] pbnum2 = new String[winperson2.size()];
                    for (int i = 0; i < winperson2.size(); i++) {
                        pbnum2[i] = winperson2.get(i).text();
                    }

                    String[] pbnum3 = new String[winperson3.size()];
                    for (int i = 0; i < winperson3.size(); i++) {
                        pbnum3[i] = winperson3.get(i).text();
                    }

                    String[] pbnum5 = new String[winperson5.size()];
                    for (int i = 0; i < winperson5.size(); i++) {
                        pbnum5[i] = winperson5.get(i).text();
                    }
                    /** 리스트 뷰 출력 출력 */


                    String Next1=null;
                    String Next2=null;

                    for (int i = 0; i < pbnum2.length-1; i++) {

                        Card card = new Card(pbnum2[i],pbnum1[i],pbnum3[i],"","Next Jackpot : "+pbnum5[i],"");
                        cardArrayAdapter.add(card);

                    }

                    Next1 = pbnum3[4].substring(0,pbnum3[4].length()-2);
                    Next2 = pbnum3[4].substring(pbnum3[4].length()-2);

                    // 로또 번호 보너스 번호에 + 집어 넣기

                    pbnum3[4] = null;
                    pbnum3[4] = Next1 + " + " + Next2;

                    Card card = new Card(pbnum2[4],pbnum1[4],pbnum3[4],"","Next Jackpot : "+pbnum5[4],"(Last Number is TB number)");
                    cardArrayAdapter.add(card);
                    listView.setAdapter(cardArrayAdapter);
                    mProgressDialog.dismiss ();
                    listView.setAdapter (cardArrayAdapter);

                }

            }

        }
    }