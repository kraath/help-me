package com.example.Help_me;

import com.hipmob.android.HipmobCore;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class HipMob extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hip_mob);
		
		// create an intent
//		Intent i = new Intent(this, com.hipmob.android.HipmobCore.class);
//		i.putExtra(HipmobCore.KEY_APPID, "32f29e4d0631465ab99121c5900a46d8");
//		i.putExtra(HipmobCore.KEY_USERID, "<userid>");
//		i.putExtra(HipmobCore.KEY_TITLE, "First app (khadimincubasys): Chat");
//		startActivity(i);
		  
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hip_mob, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
