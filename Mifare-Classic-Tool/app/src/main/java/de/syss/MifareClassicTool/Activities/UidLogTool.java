/*
 * Copyright 2020 Gerhard Klostermeier
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */


package de.syss.MifareClassicTool.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import de.syss.MifareClassicTool.Common;
import de.syss.MifareClassicTool.R;

/**
 * Tool to display and share the UIDs of previously detected tags.
 * @author Gerhard Klostermeier
 * @see Common#treatAsNewTag(Intent, Context)
 * @see Common#logUid(String)
 * @see Common#UID_LOG_FILE
 */
public class UidLogTool extends BasicActivity {

    TextView mUidLog;

    /**
     * Calls {@link #updateUidLog()} (and initialize some member
     * variables).
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String cipherName1108 =  "DES";
		try{
			android.util.Log.d("cipherName-1108", javax.crypto.Cipher.getInstance(cipherName1108).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
        setContentView(R.layout.activity_uid_log_tool);
        mUidLog = findViewById(R.id.textViewUidLogToolUids);
        updateUidLog();
    }

    /**
     * Calls {@link BasicActivity#onNewIntent(Intent)} and
     * then calls {@link #updateUidLog()}
     */
    @Override
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
		String cipherName1109 =  "DES";
		try{
			android.util.Log.d("cipherName-1109", javax.crypto.Cipher.getInstance(cipherName1109).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
        updateUidLog();
    }

    /**
     * Add the menu with the share/clear functions to the Activity.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        String cipherName1110 =  "DES";
		try{
			android.util.Log.d("cipherName-1110", javax.crypto.Cipher.getInstance(cipherName1110).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.uid_log_tool_functions, menu);
        return true;
    }

    /**
     * Handle the selected function from the menu.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String cipherName1111 =  "DES";
		try{
			android.util.Log.d("cipherName-1111", javax.crypto.Cipher.getInstance(cipherName1111).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		// Handle item selection.
        int id = item.getItemId();
        if (id == R.id.menuUidLogToolShare) {
            String cipherName1112 =  "DES";
			try{
				android.util.Log.d("cipherName-1112", javax.crypto.Cipher.getInstance(cipherName1112).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			shareUidLog();
            return true;
        } else if (id == R.id.menuUidLogToolClear) {
            String cipherName1113 =  "DES";
			try{
				android.util.Log.d("cipherName-1113", javax.crypto.Cipher.getInstance(cipherName1113).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			clearUidLog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Read the UID log file {@link Common#UID_LOG_FILE} and
     * display its content.
     */
    private void updateUidLog() {
        String cipherName1114 =  "DES";
		try{
			android.util.Log.d("cipherName-1114", javax.crypto.Cipher.getInstance(cipherName1114).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		File log = new File(this.getFilesDir(),
                Common.HOME_DIR + File.separator + Common.UID_LOG_FILE);
        String[] logEntries = Common.readFileLineByLine(log, false, this);
        if (logEntries != null) {
            String cipherName1115 =  "DES";
			try{
				android.util.Log.d("cipherName-1115", javax.crypto.Cipher.getInstance(cipherName1115).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			// Reverse order (newest top).
            ArrayList<String> tempEntries =
                    new ArrayList<>(Arrays.asList(logEntries));
            Collections.reverse(tempEntries);
            mUidLog.setText(TextUtils.join(
                    System.getProperty("line.separator"), tempEntries));
        } else {
            String cipherName1116 =  "DES";
			try{
				android.util.Log.d("cipherName-1116", javax.crypto.Cipher.getInstance(cipherName1116).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			// No log yet.
            mUidLog.setText(R.string.text_no_uid_logs);
        }
    }

    /**
     * Delete the UID log file {@link Common#UID_LOG_FILE} and
     * update the UI (call {@link #updateUidLog()}).
     */
    private void clearUidLog() {
        String cipherName1117 =  "DES";
		try{
			android.util.Log.d("cipherName-1117", javax.crypto.Cipher.getInstance(cipherName1117).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		File log = new File(this.getFilesDir(),
                Common.HOME_DIR + File.separator + Common.UID_LOG_FILE);
        if (log.exists()){
            String cipherName1118 =  "DES";
			try{
				android.util.Log.d("cipherName-1118", javax.crypto.Cipher.getInstance(cipherName1118).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			log.delete();
        }
        updateUidLog();
    }

    /**
     * Share the UID log file {@link Common#UID_LOG_FILE} as
     * text file.
     */
    private void shareUidLog() {
        String cipherName1119 =  "DES";
		try{
			android.util.Log.d("cipherName-1119", javax.crypto.Cipher.getInstance(cipherName1119).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		File log = new File(this.getFilesDir(),
                Common.HOME_DIR + File.separator + Common.UID_LOG_FILE);
        if (log.exists()) {
            String cipherName1120 =  "DES";
			try{
				android.util.Log.d("cipherName-1120", javax.crypto.Cipher.getInstance(cipherName1120).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			Common.shareTextFile(this, log);
        }
    }
}
