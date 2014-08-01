package com.example.jnapisu;

import java.util.Vector;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TimePicker;
import android.os.Build;

public class MainActivity extends Activity {

	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
	
	Vector<TaskStorage> TaskList = new Vector<TaskStorage>();
	EditText editText;
	TimePicker timePicker;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}
	
	public void addTask(View view){
	    //Intent intent = new Intent(this, DisplayTaskActivity.class);
	    editText     = (EditText) findViewById(R.id.edit_task);
	    timePicker = (TimePicker)findViewById(R.id.timePicker1);
	    //String message = editText.getText().toString();
	    //intent.putExtra(EXTRA_MESSAGE, message);
	    //startActivity(intent);
	    
	    //Store the message in a data structure and also write it to file
	    //On loading new activity/list view - reload from file or data structure
	    //Show all/only those done/only those pending
	    //Sorted by order of completion date
	    
	    
	    TaskStorage Task = new TaskStorage();
	    Task.text    	 = editText.getText().toString();
	    Task.hour    	 = timePicker.getCurrentHour();
	    Task.minute  	 = timePicker.getCurrentMinute();
	    TaskList.addElement(Task); 
	    //Log.v(EXTRA_MESSAGE, TaskList.get(0).text);
	    //Log.v(EXTRA_MESSAGE, TaskList.get(0).hour.toString());
	    //Log.v(EXTRA_MESSAGE, TaskList.get(0).minute.toString());
	}
	
	public void viewTaskList(View view){
		Intent intent = new Intent(this, DisplayTaskActivity.class);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
