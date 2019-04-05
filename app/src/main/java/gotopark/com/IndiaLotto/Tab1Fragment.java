package gotopark.com.IndiaLotto;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Random;

import gotopark.com.IndiaLotto.module.randomNum;

public class Tab1Fragment extends Fragment {

    private static final String TAG = "Tab1Fragment";

    TextView text1;
    private String ctextR;

    TextView F1TV1,F1TV2,F1TV3,F1TV4,F1TV5,F1TV6;
    TextView F2TV1,F2TV2,F2TV3,F2TV4,F2TV5,F2TV6;
    TextView F3TV1,F3TV2,F3TV3,F3TV4,F3TV5,F3TV6;
    TextView F4TV1,F4TV2,F4TV3,F4TV4,F4TV5,F4TV6;
    TextView F5TV1,F5TV2,F5TV3,F5TV4,F5TV5,F5TV6;

    int[] Lot1num1 = new int[6];
    int[] Lot1num2 = new int[6];
    int[] Lot1num3 = new int[6];
    int[] Lot1num4 = new int[6];
    int[] Lot1num5 = new int[6];


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1_layout,container,false);



        Button btnTEST = (Button) view.findViewById(R.id.btnTEST);
        btnTEST.setTextColor(Color.parseColor("#27af3c"));

        Button btnSHARE = (Button) view.findViewById(R.id.button2);
        text1 = (TextView) view.findViewById(R.id.textTab1);

        F1TV1 = (TextView) view.findViewById(R.id.F1TV1);
        F1TV2 = (TextView) view.findViewById(R.id.F1TV2);
        F1TV3 = (TextView) view.findViewById(R.id.F1TV3);
        F1TV4 = (TextView) view.findViewById(R.id.F1TV4);
        F1TV5 = (TextView) view.findViewById(R.id.F1TV5);
        F1TV6 = (TextView) view.findViewById(R.id.F1TV6);

        F2TV1 = (TextView) view.findViewById(R.id.F2TV1);
        F2TV2 = (TextView) view.findViewById(R.id.F2TV2);
        F2TV3 = (TextView) view.findViewById(R.id.F2TV3);
        F2TV4 = (TextView) view.findViewById(R.id.F2TV4);
        F2TV5 = (TextView) view.findViewById(R.id.F2TV5);
        F2TV6 = (TextView) view.findViewById(R.id.F2TV6);

        F3TV1 = (TextView) view.findViewById(R.id.F3TV1);
        F3TV2 = (TextView) view.findViewById(R.id.F3TV2);
        F3TV3 = (TextView) view.findViewById(R.id.F3TV3);
        F3TV4 = (TextView) view.findViewById(R.id.F3TV4);
        F3TV5 = (TextView) view.findViewById(R.id.F3TV5);
        F3TV6 = (TextView) view.findViewById(R.id.F3TV6);

        F4TV1 = (TextView) view.findViewById(R.id.F4TV1);
        F4TV2 = (TextView) view.findViewById(R.id.F4TV2);
        F4TV3 = (TextView) view.findViewById(R.id.F4TV3);
        F4TV4 = (TextView) view.findViewById(R.id.F4TV4);
        F4TV5 = (TextView) view.findViewById(R.id.F4TV5);
        F4TV6 = (TextView) view.findViewById(R.id.F4TV6);

        F5TV1 = (TextView) view.findViewById(R.id.F5TV1);
        F5TV2 = (TextView) view.findViewById(R.id.F5TV2);
        F5TV3 = (TextView) view.findViewById(R.id.F5TV3);
        F5TV4 = (TextView) view.findViewById(R.id.F5TV4);
        F5TV5 = (TextView) view.findViewById(R.id.F5TV5);
        F5TV6 = (TextView) view.findViewById(R.id.F5TV6);

        btnTEST.setOnClickListener(new View.OnClickListener() {
            @SuppressWarnings("MalformedFormatString")
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {

                Random rand = new Random();
                // 반복 회수 지정
                int Times_Ran[] ={250,350,650,850,950,1150};
                int xnum = rand.nextInt(5);
                int millisec = Times_Ran[xnum];
                // 반복 회수 끝

                CountDownTimer start = new CountDownTimer (millisec, 50) {
                    public void onTick(long millisUntilFinished) {
                        GenNumber();
                    }
                    public void onFinish() {
                        // 반복 후 작업은 아래에 라인



                    }

                }.start ();
            }
        });


        btnSHARE.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {

                String check1;
                check1 = F1TV1.getText ().toString ();

                if (check1 == ""){

                    showGuide (getString (R.string.tab_info1));
                    text1.setText (getString (R.string.tab_info1));

                    //안내 문구

                } else {

                LotCOPY();

                Intent msg = new Intent(Intent.ACTION_SEND);
                msg.addCategory(Intent.CATEGORY_DEFAULT);
                msg.putExtra(Intent.EXTRA_SUBJECT, "Super Lotto Number");
                msg.putExtra(Intent.EXTRA_TEXT, "India Lotto\n" + ctextR);
                msg.putExtra(Intent.EXTRA_TITLE, "SuperLotto Number");
                msg.setType("text/plain");
                startActivity(Intent.createChooser(msg, "Share"));
                showGuide("Lotto Number Share");
            }
            }
        });

        return view;

    }

    //함수 나열

    public void showGuide(String input1) {
        Toast.makeText(getActivity(), input1, Toast.LENGTH_SHORT).show();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void LotCOPY() {

        String App_links1 = getString (R.string.app_links);
        String App_Share = getString (R.string.app_share);
        String tab_info1 = getString (R.string.tab_text1);

        String[] SLot1num1 = new String[6];
        String[] SLot1num2 = new String[6];
        String[] SLot1num3 = new String[6];
        String[] SLot1num4 = new String[6];
        String[] SLot1num5 = new String[6];

        //텍스트 변환
        /** 숫자 고정 자리수 */
        DecimalFormat cure = new DecimalFormat ("##");
        cure.setMinimumIntegerDigits (2);

        for (int i = 0; i < 6; i++) {
            SLot1num1[i] = cure.format ((Lot1num1[i]));
            SLot1num2[i] = cure.format ((Lot1num2[i]));
            SLot1num3[i] = cure.format ((Lot1num3[i]));
            SLot1num4[i] = cure.format ((Lot1num4[i]));
            SLot1num5[i] = cure.format ((Lot1num5[i]));
        }


        ctextR = tab_info1+"\n";

        ctextR = ctextR + (SLot1num1[0] + ", " + SLot1num1[1] + ", " + SLot1num1[2] + ", " + SLot1num1[3] + ", " + SLot1num1[4] + ", " + SLot1num1[5] + "\n");
        ctextR = ctextR + (SLot1num2[0] + ", " + SLot1num2[1] + ", " + SLot1num2[2] + ", " + SLot1num2[3] + ", " + SLot1num2[4] + ", " + SLot1num2[5] + "\n");
        ctextR = ctextR + (SLot1num3[0] + ", " + SLot1num3[1] + ", " + SLot1num3[2] + ", " + SLot1num3[3] + ", " + SLot1num3[4] + ", " + SLot1num3[5] + "\n");
        ctextR = ctextR + (SLot1num4[0] + ", " + SLot1num4[1] + ", " + SLot1num4[2] + ", " + SLot1num4[3] + ", " + SLot1num4[4] + ", " + SLot1num4[5] + "\n");
        ctextR = ctextR + (SLot1num5[0] + ", " + SLot1num5[1] + ", " + SLot1num5[2] + ", " + SLot1num5[3] + ", " + SLot1num5[4] + ", " + SLot1num5[5]);

        ctextR = ctextR +"\n\n"+App_links1+"\n"+App_Share+"★Good Luck★";
    }

    public void GenNumber(){

        /**
         //                Toast.makeText(getActivity(), "TESTING BUTTON CLICK 1",Toast.LENGTH_SHORT).show();
         //                showGuide("안녕하세요");
         */

        randomNum Rnum = new randomNum();

        Lot1num1 = Rnum.lotArray(6, 49);
        Lot1num2 = Rnum.lotArray(6, 49);
        Lot1num3 = Rnum.lotArray(6, 49);
        Lot1num4 = Rnum.lotArray(6, 49);
        Lot1num5 = Rnum.lotArray(6, 49);

        F1TV1.setText(String.valueOf (Lot1num1[0]));
        F1TV2.setText(String.valueOf (Lot1num1[1]));
        F1TV3.setText(String.valueOf (Lot1num1[2]));
        F1TV4.setText(String.valueOf (Lot1num1[3]));
        F1TV5.setText(String.valueOf (Lot1num1[4]));
        F1TV6.setText(String.valueOf (Lot1num1[5]));

        F2TV1.setText(String.valueOf (Lot1num2[0]));
        F2TV2.setText(String.valueOf (Lot1num2[1]));
        F2TV3.setText(String.valueOf (Lot1num2[2]));
        F2TV4.setText(String.valueOf (Lot1num2[3]));
        F2TV5.setText(String.valueOf (Lot1num2[4]));
        F2TV6.setText(String.valueOf (Lot1num2[5]));

        F3TV1.setText(String.valueOf (Lot1num3[0]));
        F3TV2.setText(String.valueOf (Lot1num3[1]));
        F3TV3.setText(String.valueOf (Lot1num3[2]));
        F3TV4.setText(String.valueOf (Lot1num3[3]));
        F3TV5.setText(String.valueOf (Lot1num3[4]));
        F3TV6.setText(String.valueOf (Lot1num3[5]));

        F4TV1.setText(String.valueOf (Lot1num4[0]));
        F4TV2.setText(String.valueOf (Lot1num4[1]));
        F4TV3.setText(String.valueOf (Lot1num4[2]));
        F4TV4.setText(String.valueOf (Lot1num4[3]));
        F4TV5.setText(String.valueOf (Lot1num4[4]));
        F4TV6.setText(String.valueOf (Lot1num4[5]));

        F5TV1.setText(String.valueOf (Lot1num5[0]));
        F5TV2.setText(String.valueOf (Lot1num5[1]));
        F5TV3.setText(String.valueOf (Lot1num5[2]));
        F5TV4.setText(String.valueOf (Lot1num5[3]));
        F5TV5.setText(String.valueOf (Lot1num5[4]));
        F5TV6.setText(String.valueOf (Lot1num5[5]));

    }


}