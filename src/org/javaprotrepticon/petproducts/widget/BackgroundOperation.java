package org.javaprotrepticon.petproducts.widget;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public abstract class BackgroundOperation extends AsyncTask<Object, Object, Object> {

	protected Context mContext;
	protected ProgressDialog mProgressDialog;
	
	public BackgroundOperation(Context context) {
		mContext = context;
		
		mProgressDialog = new ProgressDialog(context);
		mProgressDialog.setMessage("Операция выполняется");
		mProgressDialog.setCancelable(false); 
	}
	
	@Override
	protected void onPreExecute() {
		mProgressDialog.show();
	}
	
	@Override
	protected void onPostExecute(Object result) {
		mProgressDialog.dismiss();
	}
	
}
