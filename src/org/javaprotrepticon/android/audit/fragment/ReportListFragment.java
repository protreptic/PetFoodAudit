package org.javaprotrepticon.android.audit.fragment;

import java.sql.SQLException;

import org.javaprotrepticon.android.audit.R;
import org.javaprotrepticon.android.audit.fragment.base.BaseEntityListFragment;
import org.javaprotrepticon.android.audit.storage.Storage;
import org.javaprotrepticon.android.audit.storage.model.Report;

import com.j256.ormlite.dao.Dao;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class ReportListFragment extends BaseEntityListFragment<Report> {

	@Override
	protected Adapter<?> createAdapter() {
		return new DefaultAdapter() {
			
			@Override
			public void onBindViewHolder(DefaultViewHolder holder, int position) {
				final Report report = mEntityList.get(position);
				
				holder.title.setText(report.getId().toString());
				holder.title.setTypeface(mRobotoCondensedBold);
				
				holder.subtitle.setText(report.getData());
				holder.subtitle.setTypeface(mRobotoCondensedLight);
				
				holder.description.setText(""); 
				holder.description.setTypeface(mRobotoCondensedLight);

				holder.itemView.setOnClickListener(new OnClickListener() { 
					
					@Override
					public void onClick(View view) {
						Bundle arguments = new Bundle();
						arguments.putParcelable("account", mAccount);

						Fragment fragment = new ReportFragment();
						fragment.setArguments(arguments); 
						
			            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
			            fragmentTransaction.replace(R.id.content_frame, fragment);
			            fragmentTransaction.addToBackStack(null);
			            fragmentTransaction.commit();	
					}
				});
			}
			
		};
	}
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
		
		inflater.inflate(R.menu.report_list_fragment_menu, menu);
	}
	
	private class CreateNewReport extends AsyncTask<Void, Void, Void> {
		
		@Override
		protected Void doInBackground(Void... params) {
			Storage storage = new Storage(getActivity());
			
			@SuppressWarnings("unchecked")
			Dao<Report, Integer> dao = (Dao<Report, Integer>) storage.createDao(Report.class);
			
			Report report = new Report();
			report.setData("asdasdasdasdasdasdasd"); 
			
			try {
				dao.create(report);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			storage.closeConnection();
			
			return null;
		}
		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int itemId = item.getItemId();
		switch (itemId) {
			case R.id.createReport: {
				new CreateNewReport().execute();
			} break;
			default: {
				super.onOptionsItemSelected(item);
			}
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	protected void refreshData() {
		new DataLoader() {

			@Override
			protected Void doInBackground(Void... params) {
				try {
					mEntityList.addAll(mDao.queryForAll());
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				return null;
			}
			
		}.execute();
	}

	@Override
	protected Class<Report> getType() {
		return Report.class;
	}
	
}