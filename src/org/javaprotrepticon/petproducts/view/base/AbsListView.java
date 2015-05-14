package org.javaprotrepticon.petproducts.view.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.javaprotrepticon.android.audit.R;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class AbsListView extends RelativeLayout {

	public AbsListView(Context context) {
		super(context);
		
		init();
	}
	
	private void init() {
		ViewGroup.LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		setLayoutParams(layoutParams);
		
		int padding = 20;
		
		setPadding(padding, padding, padding, padding);
		
		TextView emptyView = new TextView(getContext());
		emptyView.setText(getResources().getString(R.string.empty_list)); 
		
		ListView listView = new ListView(getContext());
		listView.setEmptyView(emptyView); 
		//listView.setBackgroundColor(getResources().getColor(R.color.bg_actionbar)); 
		listView.setLayoutParams(layoutParams); 
		
		List<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
		
		for (int i = 0; i < 100; i++) {
			HashMap<String, String> item = new HashMap<String, String>();
			item.put("1", "text1");
			item.put("2", "text2");
			
			data.add(item);
		}
		
		SimpleAdapter simpleAdapter = new SimpleAdapter(getContext(), data, android.R.layout.simple_list_item_2, new String[] { "1", "2" }, new int[] { android.R.id.text2, android.R.id.text1 });
		
		listView.setAdapter(simpleAdapter); 
		
		addView(listView); 
	}

}
