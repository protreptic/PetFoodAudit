package org.javaprotrepticon.petproducts.view.base;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public abstract class AbsView extends RelativeLayout {

	public AbsView(Context context) {
		super(context);
		
		init();
	}

	protected void init() {
		ViewGroup.LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		setLayoutParams(layoutParams);
		
		int padding = 20;
		
		setPadding(padding, padding, padding, padding);
	}

}
