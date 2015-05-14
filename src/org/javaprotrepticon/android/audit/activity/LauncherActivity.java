package org.javaprotrepticon.android.audit.activity;

import java.sql.SQLException;

import org.javaprotrepticon.android.audit.R;
import org.javaprotrepticon.android.audit.storage.Storage;
import org.javaprotrepticon.android.audit.storage.model.Address;
import org.javaprotrepticon.android.audit.storage.model.Brand;
import org.javaprotrepticon.android.audit.storage.model.Channel;
import org.javaprotrepticon.android.audit.storage.model.Cluster;
import org.javaprotrepticon.android.audit.storage.model.ExtraFile;
import org.javaprotrepticon.android.audit.storage.model.MrNblData;
import org.javaprotrepticon.android.audit.storage.model.Picture;
import org.javaprotrepticon.android.audit.storage.model.Product;
import org.javaprotrepticon.android.audit.storage.model.Report;
import org.javaprotrepticon.android.audit.storage.model.ReportGroup;
import org.javaprotrepticon.android.audit.storage.model.ReportGroupItem;
import org.javaprotrepticon.android.audit.storage.model.Screen;
import org.javaprotrepticon.android.audit.storage.model.ScreenItem;
import org.javaprotrepticon.android.audit.storage.model.StoreType;
import org.javaprotrepticon.android.audit.storage.model.SubChannel;

import com.j256.ormlite.table.TableUtils;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class LauncherActivity extends ActionBarActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.launcher_activity);
		
		new PrepareStorage().execute();
	}
	
	public class PrepareStorage extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... params) {
			Storage storage = new Storage(getBaseContext());
			
			try {
				TableUtils.createTableIfNotExists(storage.getConnection(), Address.class);
				TableUtils.createTableIfNotExists(storage.getConnection(), Brand.class);
				TableUtils.createTableIfNotExists(storage.getConnection(), Channel.class);
				TableUtils.createTableIfNotExists(storage.getConnection(), Cluster.class);
				TableUtils.createTableIfNotExists(storage.getConnection(), SubChannel.class);
				TableUtils.createTableIfNotExists(storage.getConnection(), StoreType.class);
				TableUtils.createTableIfNotExists(storage.getConnection(), Product.class);
				TableUtils.createTableIfNotExists(storage.getConnection(), Screen.class);
				TableUtils.createTableIfNotExists(storage.getConnection(), ScreenItem.class);
				TableUtils.createTableIfNotExists(storage.getConnection(), MrNblData.class);
				TableUtils.createTableIfNotExists(storage.getConnection(), Report.class);
				TableUtils.createTableIfNotExists(storage.getConnection(), ReportGroupItem.class);
				TableUtils.createTableIfNotExists(storage.getConnection(), ReportGroup.class);
				TableUtils.createTableIfNotExists(storage.getConnection(), ExtraFile.class);
				TableUtils.createTableIfNotExists(storage.getConnection(), Picture.class);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			storage.closeConnection();
			
			return null;
		}
		
		@Override
		protected void onPostExecute(Void result) {
			Intent intent = new Intent(getBaseContext(), MainActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_TASK_ON_HOME);
			
			startActivity(intent); 
		}
		
	}
	
}
