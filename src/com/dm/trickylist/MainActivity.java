package com.dm.trickylist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.dm.trickylist.adapter.TrickyListAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.view.DragEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnDragListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity
{

	private ListView lv;
	private ArrayList<HashMap<String, String>> items;
	private TrickyListAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		lv = (ListView) findViewById(R.id.llMain);
		items = new ArrayList<HashMap<String, String>>();

		HashMap<String, String> notes;
		int j = 0;
		for (int i = 1; i <= 25; i++)
		{
			notes = new HashMap<String, String>();

			notes.put("first", "value " + j++);
			notes.put("second", "value " + j++);
			notes.put("third", "value " + j++);
			notes.put("fourth", "value " + j++);
			notes.put("fifth", "value " + j++);

			items.add(notes);
		}

		adapter = new TrickyListAdapter(this, items);

		lv.setAdapter(adapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
