/***
	Copyright (c) 2009 
	Author: Stefan Klumpp <stefan.klumpp@gmail.com>
	Web: http://stefanklumpp.com
		
	Licensed under the Apache License, Version 2.0 (the "License"); you may
	not use this file except in compliance with the License. You may obtain
	a copy of the License at
		http://www.apache.org/licenses/LICENSE-2.0
	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
*/


package com.devstream.http;

import org.json.JSONException;
import org.json.JSONObject;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
	private static final String TAG = "MainActivity";
	private static final String URL = "http://www.yourdomain.com:80";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// JSON object to hold the information, which is sent to the server
		JSONObject jsonObjSend = new JSONObject();

		try {
			// Add key/value pairs
			jsonObjSend.put("key_1", "value_1");
			jsonObjSend.put("key_2", "value_2");

			// Add a nested JSONObject (e.g. for header information)
			JSONObject header = new JSONObject();
			header.put("deviceType","Android"); // Device type
			header.put("deviceVersion","2.0"); // Device OS version
			header.put("language", "es-es");	// Language of the Android client
			jsonObjSend.put("header", header);
			
			// Output the JSON object we're sending to Logcat:
			Log.i(TAG, jsonObjSend.toString(2));

		} catch (JSONException e) {
			e.printStackTrace();
		}

		// Send the HttpPostRequest and receive a JSONObject in return
		JSONObject jsonObjRecv = HttpClient.SendHttpPost(URL, jsonObjSend);

		/*
		 *  From here on do whatever you want with your JSONObject, e.g.
		 *  1) Get the value for a key: jsonObjRecv.get("key");
		 *  2) Get a nested JSONObject: jsonObjRecv.getJSONObject("key")
		 *  3) Get a nested JSONArray: jsonObjRecv.getJSONArray("key") 
		 */


	}
}