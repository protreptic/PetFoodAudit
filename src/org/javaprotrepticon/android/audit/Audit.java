package org.javaprotrepticon.android.audit;

import org.acra.ACRA;
import org.acra.ReportingInteractionMode;
import org.acra.annotation.ReportsCrashes;
import org.acra.sender.HttpSender.Method;

import android.app.Application;

@ReportsCrashes(formKey = "", formUri = "http://88.87.93.68:8080/qualityAssurance", mode = ReportingInteractionMode.TOAST, resToastText = R.string.crashMessage, httpMethod = Method.POST) 
public class Audit extends Application {
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		ACRA.init(this);
	}
	
}
