package org.javaprotrepticon.android.audit.activity;

import java.io.File;

import org.javaprotrepticon.android.androidutils.Fonts;
import org.javaprotrepticon.android.audit.R;
import org.javaprotrepticon.android.audit.fragment.ReportListFragment;
import org.javaprotrepticon.android.audit.util.SyncManager;
import org.javaprotrepticon.android.audit.util.SyncObserver;
import org.javaprotrepticon.android.audit.util.SyncStatus;
import org.javaprotrepticon.petproducts.widget.BackgroundOperation;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements SyncObserver {

	protected ActionBarDrawerToggle mDrawerToggle;
	protected DrawerLayout mDrawerLayout;
	protected LinearLayout mLeftDrawer;
	protected ListView mRightDrawer;
	protected ListView mLeftDrawerList;
	
	protected Toolbar mToolBar;
	
    private int[] mMenuIcons = new int[] { R.drawable.info };
    private int[] mMenuItems = new int[] { R.string.crashMessage };
	
	public static class MenuItemViewHolder {

		public ImageView image1;
		public TextView textView;
		
	}
	
    private class MenuItemAdapter extends BaseAdapter {

		private Typeface mRobotoCondensedBold;
		
		public MenuItemAdapter() {
			mRobotoCondensedBold = Fonts.get(getBaseContext()).getTypeface("Rotonda-Bold"); 
		}
    	
		@Override
		public int getCount() {
			return mMenuItems.length;
		}
		
		@Override
		public Object getItem(int position) {
			return mMenuItems[position];
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			MenuItemViewHolder holder;
			
			if (convertView == null) {
				convertView = getLayoutInflater().inflate(R.layout.drawer_list_item, parent, false);
				
				holder = new MenuItemViewHolder();
				holder.image1 = (ImageView) convertView.findViewById(R.id.image1);
				
				holder.textView = (TextView) convertView.findViewById(R.id.text1);
				holder.textView.setTypeface(mRobotoCondensedBold);
				
				convertView.setTag(holder); 
			} else {
				holder = (MenuItemViewHolder) convertView.getTag();
			}
			
			holder.textView.setText(getString((Integer) getItem(position))); 
			holder.image1.setImageDrawable(getResources().getDrawable(mMenuIcons[position])); 
			
			return convertView;
		}
    	
    }
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main_activity);
		
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        mDrawerLayout.setDrawerListener(new DefaultDrawerListener());
        mDrawerLayout.setDrawerTitle(GravityCompat.START, getString(R.string.drawer_title));
        
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close);
        
        mLeftDrawer = (LinearLayout) findViewById(R.id.left_drawer);
        
        mLeftDrawerList = (ListView) findViewById(R.id.left_drawer_list);
        mLeftDrawerList.setAdapter(new MenuItemAdapter()); 
        mLeftDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        initToolbar();
        
        selectItem(0);
	}

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        mDrawerToggle.syncState();
    }
    
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
	
    @Override
    public void onBackPressed() {
    	if (mDrawerLayout.isDrawerOpen(mLeftDrawer)) {
    		mDrawerLayout.closeDrawer(mLeftDrawer); return;
    	}
    	
    	super.onBackPressed();
    }
    
	private void initToolbar() {
		mToolBar = (Toolbar) findViewById(R.id.toolbar);
		mToolBar.setTitle("");
		mToolBar.setSubtitle("");
		mToolBar.setBackgroundColor(getResources().getColor(R.color.bg_actionbar_green));  
		
	    setSupportActionBar(mToolBar);
	}
	
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
    	
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
        
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main_activity_menu, menu);
	    
	    return true;
	}

	private ReportListFragment mReportListFragment;
	
	private void selectItem(int position) {
    	mLeftDrawerList.setItemChecked(position, true);
        mDrawerLayout.closeDrawer(mLeftDrawer);
    	      
        Fragment fragment = null;
        
        switch (position) {
			case 0: {
				if (mReportListFragment == null) {
					mReportListFragment = new ReportListFragment();
				}
				
				fragment = mReportListFragment;
			} break;
			default: {
				return;
			}
		}
        
        while (getSupportFragmentManager().getBackStackEntryCount() > 0) {
        	getSupportFragmentManager().popBackStackImmediate();
        }
        
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.replace(R.id.content_frame, fragment);
        fragmentTransaction.commit();
    }
    
	public class DefaultDrawerListener implements DrawerLayout.DrawerListener {
		
        @Override
        public void onDrawerOpened(View drawerView) {
            mDrawerToggle.onDrawerOpened(drawerView);
        }

        @Override
        public void onDrawerClosed(View drawerView) {
            mDrawerToggle.onDrawerClosed(drawerView);
        }

        @Override
        public void onDrawerSlide(View drawerView, float slideOffset) {
            mDrawerToggle.onDrawerSlide(drawerView, slideOffset);
        }

        @Override
        public void onDrawerStateChanged(int newState) {
            mDrawerToggle.onDrawerStateChanged(newState);
        }
    }
	
	public class EmailExportTask extends BackgroundOperation {
		
		public EmailExportTask(Context context) {
			super(context);
		}
		
		@Override
		protected String doInBackground(Object... params) {
			String path = "";
			
			try {
				Intent intent = new Intent(Intent.ACTION_SEND);
				intent.setType("message/rfc822");
				intent.putExtra(Intent.EXTRA_EMAIL, new String[] {});
				intent.putExtra(Intent.EXTRA_CC, new String[]{});
				intent.putExtra(Intent.EXTRA_BCC, new String[]{});
				intent.putExtra(Intent.EXTRA_SUBJECT, "");
				intent.putExtra(Intent.EXTRA_TEXT, "");
				intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(path)));
				
				mContext.startActivity(Intent.createChooser(intent, mContext.getResources().getString(R.string.message6)));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return path;
		}
		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int itemId = item.getItemId();
		switch (itemId) {
			case android.R.id.home: {
				mDrawerLayout.openDrawer(mLeftDrawer);
			} break;
			case R.id.export_email: {
				new EmailExportTask(this).execute();
			} break;
			default: {
				super.onOptionsItemSelected(item);
			}
		}
		
		return super.onOptionsItemSelected(item);
	}

	private SyncManager mSynchronizationManager = new SyncManager(null); 
	
    public void registerSyncObserver(SyncObserver observer) {
    	mSynchronizationManager.registerSyncObserver(observer); 
    }
    
    public void unregisterSyncObserver(SyncObserver observer) {
    	mSynchronizationManager.unregisterSyncObserver(observer); 
    }
	
	@Override
	public void onStatusChanged(SyncStatus status) {
		
	}

}
