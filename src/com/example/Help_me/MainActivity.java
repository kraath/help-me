package com.example.Help_me;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity implements OnMenuItemClickListener{
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
//        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
//        globalVariable.setName("Khadim Raath");
        Button socialbtn = (Button) findViewById(R.id.button1);
        socialbtn.setOnClickListener(new OnClickListener()
        {
          public void onClick(View v)
          { 
        	  Intent i = new Intent(getApplicationContext(), SocialApps.class);  
        	  startActivity(i);  
              Toast.makeText(getApplicationContext(),  "Button is clicked", Toast.LENGTH_LONG).show();
          }
        });
        Button gallerybtn = (Button) findViewById(R.id.button2);
        gallerybtn.setOnClickListener(new OnClickListener()
        {
          public void onClick(View v)
          {
        	  Intent i = new Intent(getApplicationContext(), Pictures.class);  
              startActivity(i);  
              Toast.makeText(getApplicationContext(),  "Button is clicked", Toast.LENGTH_LONG).show();
          }
        });
//        //////////////////////////////////////////////
        Button settings = (Button) findViewById(R.id.button3);
        settings.setOnClickListener(new OnClickListener()
        {
          public void onClick(View v)
          {
        	  Intent i = new Intent(getApplicationContext(), Settings.class);  
              startActivity(i);  
              Toast.makeText(getApplicationContext(),  "Button is clicked", Toast.LENGTH_LONG).show();
          }
        });
        settings.setOnLongClickListener(new OnLongClickListener() {
     	   @Override
     	   public boolean onLongClick(View v) {
     		  PopupMenu popupMenu = new PopupMenu(MainActivity.this, v);
				popupMenu.setOnMenuItemClickListener(MainActivity.this);
				popupMenu.inflate(R.menu.popup_menu);
				popupMenu.show();
				return true;
     	   }
     	  });
        ///////////////////////////////////////////////////////////
        
        
        Button contactus = (Button) findViewById(R.id.button4);
        contactus.setOnClickListener(new OnClickListener()
        {
          public void onClick(View v)
          {
        	  Intent i = new Intent(getApplicationContext(), HipMob.class);  
              startActivity(i);  
              Toast.makeText(getApplicationContext(),  "Button is clicked", Toast.LENGTH_LONG).show();
          }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        
        switch (item.getItemId()) {
        case R.id.action_search:
            // search action
            return true;
        case R.id.action_location_found:
            // location found

            return true;
        case R.id.action_refresh:
            // refresh
            return true;
        case R.id.action_help:
        	Intent i = new Intent(MainActivity.this, Pictures.class);
            startActivity(i);
            return true;
        case R.id.action_check_updates:
            // check for updates action
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }


	@Override
	public boolean onMenuItemClick(MenuItem item) {
		switch (item.getItemId()) {

		case R.id.item_comedy:
			Toast.makeText(this, "Comedy Clicked", Toast.LENGTH_SHORT).show();
			return true;
		case R.id.item_movies:
			Toast.makeText(this, "Movies Clicked", Toast.LENGTH_SHORT).show();
			return true;
		case R.id.item_music:
			Toast.makeText(this, "Music Clicked", Toast.LENGTH_SHORT).show();
			return true;
		default:
			return false;
		}
	}
}
