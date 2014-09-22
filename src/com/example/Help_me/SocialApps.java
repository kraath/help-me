package com.example.Help_me;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.ExpandableListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Toast;

public class SocialApps extends ExpandableListActivity  {
	ListView list;
	  String[] web = {
		  "Google Plus",
	      "Windows",
	      "Line",
	      "chat on",
	      "FaceBook",
	      "Skype",
	      "Twitter",
	      "Imo"
	  } ;
	  String[] urls = {
			  "https://plus.google.com/up/accounts/upgrade/?continue=https://plus.google.com/",
		      "http://windows.microsoft.com/en-us/windows-live/sign-in-how",
		      "http://line.me/en/",
		      "http://chatango.com/login",
		      "https://www.facebook.com/",
		      "https://login.skype.com/login",
		      "https://twitter.com/login",
		      "https://imo.im/register"
		  } ;
	  Integer[] imageId = {
	      R.drawable.google,
	      R.drawable.windows,
	      R.drawable.line,
	      R.drawable.chaton,
	      R.drawable.fb,
	      R.drawable.skype,
	      R.drawable.twitter,
	      R.drawable.imp
	  };
	   
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_social_apps);
		///expandle list view
		 SimpleExpandableListAdapter expListAdapter = new SimpleExpandableListAdapter
				 		(
		                    this,
		                    createGroupList(),              // Creating group List.
		                    R.layout.list_single,             // Group item layout XML.
		                    new String[] { "Group Item" },  // the key of group item.
		                    new int[] {R.id.txt},    // ID of each group item.-Data under the key goes into this TextView.
		                    createChildList(),              // childData describes second-level entries.
		                    R.layout.list_single_child,             // Layout for sub-level entries(second level).
		                    new String[] {"Sub Item"},      // Keys in childData maps to display.
		                    new int[] { R.id.grp_child}     // Data under the keys above go into these TextViews.
		                );
		            setListAdapter( expListAdapter );
		 
		 
		//////////////////// for customList View change the ExpandableListActivity to ActionBArActivity///////////
		             ////// ALso change the view from activity_social_apps.xml
//		CustomList adapter = new CustomList(SocialApps.this, web, imageId);
// 		    list=(ListView)findViewById(R.id.list);
// 		    list.setAdapter(adapter);
// 		    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
// 		                @Override
// 		                public void onItemClick(AdapterView<?> parent, View view,
// 		                                        int position, long id) {
// 		                    Toast.makeText(SocialApps.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
// 		                   Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse(urls[position]));
// 		                  startActivity(viewIntent);  
// 		                }
// 		            });
	}
	///////////////////////////////////////////////////////////////////////
	/* Creating the Hashmap for the row */
    @SuppressWarnings("unchecked")
    private List createGroupList() {
          ArrayList result = new ArrayList();
          for( int i = 0 ; i < web.length ; ++i ) { // 15 groups........
            HashMap m = new HashMap();
            m.put("Group Item", web[i]);
            result.add( m );
          }
          return (List)result;
    }
 
    /* creatin the HashMap for the children */
    @SuppressWarnings("unchecked")
    private List createChildList() {
        ArrayList result = new ArrayList();
        for( int i = 0 ; i < web.length ; ++i ) { // this -15 is the number of groups(Here it's fifteen)
          /* each group need each HashMap-Here for each group we have 3 subgroups */
          ArrayList secList = new ArrayList();
         
            HashMap child = new HashMap();
            child.put( "Sub Item", "Home");
            secList.add( child );
            
            child = new HashMap();
            child.put( "Sub Item", "Login");
            secList.add( child );
            
            child = new HashMap();
            child.put( "Sub Item", "Sign up");
            secList.add( child );
          
         result.add( secList );
        }
        return result;
    }
    public void  onContentChanged  () {
        System.out.println("onContentChanged");
        super.onContentChanged();
    }
    /* This function is called on each child click */
    public boolean onChildClick( ExpandableListView parent, View v, int groupPosition,int childPosition,long id) {
       // System.out.println("Inside onChildClick at groupPosition = " + groupPosition +" Child clicked at position " + childPosition);
    	Toast.makeText(getApplicationContext(), "child item "+childPosition, Toast.LENGTH_LONG).show();
        return true;
    }
 
    /* This function is called on expansion of the group */
    public void  onGroupExpand  (int groupPosition) {
        try{
             System.out.println("Group exapanding Listener => groupPosition = " + groupPosition);
        }catch(Exception e){
            System.out.println(" groupPosition Errrr +++ " + e.getMessage());
        }
    }
	//////////////////////////////////////////////////////////////////////////
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pictures, menu);
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
