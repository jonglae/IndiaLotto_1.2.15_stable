package gotopark.com.IndiaLotto.module;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import gotopark.com.IndiaLotto.R;

public class CardArrayAdapter  extends ArrayAdapter<Card> {
    private static final String TAG = "CardArrayAdapter";
    private List<Card> cardList = new ArrayList<Card>();

    static class CardViewHolder {

        TextView line1;
        TextView line2;
        TextView line3;
        TextView line4;
        TextView line5;
        TextView line6;

    }

    public CardArrayAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);

    }

    @Override
    public void add(Card object) {

        cardList.add(object);

        super.add(object);

    }

    @Override
    public int getCount() {

        return this.cardList.size();

    }

    @Override
    public Card getItem(int index)
    {

        return this.cardList.get(index);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        CardViewHolder viewHolder;

        if (row == null) {


            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            row = inflater.inflate(R.layout.list_item_card, parent, false);

            viewHolder = new CardViewHolder();

            viewHolder.line1 = (TextView) row.findViewById(R.id.line1);
            viewHolder.line2 = (TextView) row.findViewById(R.id.line2);
            viewHolder.line3 = (TextView) row.findViewById(R.id.line3);
            viewHolder.line4 = (TextView) row.findViewById(R.id.line4);
            viewHolder.line5 = (TextView) row.findViewById(R.id.line5);
            viewHolder.line6 = (TextView) row.findViewById(R.id.line6);


            row.setTag(viewHolder);


        } else {


            viewHolder = (CardViewHolder)row.getTag();

        }

        Card card = getItem(position);

//        String link1 = card.getLine3();
//        link1 = link1.substring(link1.length()-2);


        assert card != null;
//        viewHolder.line1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        viewHolder.line1.setText(card.getLine1());

//        viewHolder.line2.setTextColor(Color.parseColor("#E31B32"));
//        viewHolder.line2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        viewHolder.line2.setText(card.getLine2());

//        viewHolder.line3.setTextColor(Color.parseColor("#27af3c"));
//        viewHolder.line3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 28);
        viewHolder.line3.setText(card.getLine3());


        viewHolder.line4.setText(card.getLine4());

//        viewHolder.line5.setTextColor(Color.parseColor("#094FA3"));
//        viewHolder.line5.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
        viewHolder.line5.setText(card.getLine5());
        viewHolder.line6.setText(card.getLine6());





        return row;

    }

    public Bitmap decodeToBitmap(byte[] decodedByte) {

        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);

    }
}
