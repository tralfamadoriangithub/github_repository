package com.dm.trickylist.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import com.dm.trickylist.MainActivity;
import com.dm.trickylist.R;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemLongClickListener;

public class TrickyListAdapter extends BaseAdapter
{
	private MainActivity activity;
	private LayoutInflater inflater;
	private ArrayList<HashMap<String, String>> items;
	private Random rd;

	public TrickyListAdapter(MainActivity activity,
			ArrayList<HashMap<String, String>> items)
	{
		this.activity = activity;
		this.items = items;
		inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		rd = new Random();

	}

	@Override
	public int getCount()
	{
		// TODO Auto-generated method stub
		return items == null ? 0 : items.size();
	}

	@Override
	public Object getItem(int position)
	{
		return items.get(position);
	}

	@Override
	public long getItemId(int position)
	{
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		// TODO Auto-generated method stub
		View v;
		if (convertView != null)
		{
			v = convertView;
		} else
		{
			v = inflater.inflate(R.layout.list_item, parent, false);
		}

		HashMap<String, String> item = items.get(position);

		TextView tv1 = (TextView) v.findViewById(R.id.textView1);
		TextView tv2 = (TextView) v.findViewById(R.id.textView2);
		TextView tv3 = (TextView) v.findViewById(R.id.textView3);
		TextView tv4 = (TextView) v.findViewById(R.id.textView4);
		TextView tv5 = (TextView) v.findViewById(R.id.textView5);

		((LinearLayout) v.findViewById(R.id.llMain)).setOnLongClickListener(listener);

		tv1.setText(item.get("first") + "");
		tv2.setText(item.get("second") + "");
		tv3.setText(item.get("third") + "");
		tv4.setText(item.get("fourth") + "");
		tv5.setText(item.get("fifth") + "");

		tv1.setBackgroundColor(Color.rgb(rd.nextInt(255), rd.nextInt(255),
				rd.nextInt(255)));
		tv2.setBackgroundColor(Color.rgb(rd.nextInt(255), rd.nextInt(255),
				rd.nextInt(255)));
		tv3.setBackgroundColor(Color.rgb(rd.nextInt(255), rd.nextInt(255),
				rd.nextInt(255)));
		tv4.setBackgroundColor(Color.rgb(rd.nextInt(255), rd.nextInt(255),
				rd.nextInt(255)));
		tv5.setBackgroundColor(Color.rgb(rd.nextInt(255), rd.nextInt(255),
				rd.nextInt(255)));

		tv1.setTag(UUID.randomUUID().getMostSignificantBits());
		tv2.setTag(UUID.randomUUID().getMostSignificantBits());
		tv3.setTag(UUID.randomUUID().getMostSignificantBits());
		tv4.setTag(UUID.randomUUID().getMostSignificantBits());
		tv5.setTag(UUID.randomUUID().getMostSignificantBits());

		tv1.setOnClickListener(click);
		tv2.setOnClickListener(click);
		tv3.setOnClickListener(click);
		tv4.setOnClickListener(click);
		tv5.setOnClickListener(click);
		
		Log.d("list", "position " + position);

		return v;
	}

	OnLongClickListener listener = new OnLongClickListener()
	{

		@Override
		public boolean onLongClick(View v)
		{
			Toast.makeText(activity, "Long Click",
					Toast.LENGTH_SHORT).show();
			return false;
		}

	};

	OnClickListener click = new OnClickListener()
	{

		@Override
		public void onClick(View v)
		{
			Toast.makeText(activity, "" + (Long) v.getTag(), Toast.LENGTH_SHORT)
					.show();
		}
	};

	class Holder
	{
		long tv1Tag, tv2Tag, tv3Tag, tv4Tag, tv5Tag;
		int tv1color, tv2color, tv3color, tv4color, tv5color;
	}

}
