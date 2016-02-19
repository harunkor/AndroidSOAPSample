/**
 * 
 */
package com.harunkor.androidsoapsample;

import java.io.IOException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.ksoap2.transport.HttpTransportSE;
import org.ksoap2.transport.HttpsTransportSE;
import org.ksoap2.transport.KeepAliveHttpsTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import android.os.AsyncTask;
import android.os.Debug;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;

/**
 * @author KorHarun soapAsyncTaskParameters.java Feb 19, 20162016
 *         soapAsyncTaskParameters.java follow me on github
 *         https://github.com/harunkor
 */
public class soapAsyncTaskParameters  {

	
	
	
	String nameParam1;
	String nameValue1;
//	String nameParam2;
//	String nameValue2;
	

	/**
	 * You can add other params.
	 */
	public soapAsyncTaskParameters(String nameParam1,String nameValue1)
			//,String nameParam2,String nameValue2) 
			{
		// TODO Auto-generated constructor stub
		this.nameParam1 = nameParam1;
		this.nameValue1 = nameValue1;
//		this.nameParam2 = nameParam2;
//		this.nameValue2 = nameValue2;
		/**
		 * You can add other this method params.
		 */

	}

	
	public  static   class soapAsyncTask extends
			AsyncTask<soapAsyncTaskParameters, Void, Void>

	{

		
		SoapPrimitive myResult;
		
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
		}
		
		
		@Override
		protected Void doInBackground(soapAsyncTaskParameters... params) {
			// TODO Auto-generated method stub

			String SOAP_ACTION="http://www.w3schools.com/xml/CelsiusToFahrenheit";
			String METHOD_NAME="CelsiusToFahrenheit";
			String NAME_SPACE="http://www.w3schools.com/xml/";
			String URL="http://www.w3schools.com/xml/tempconvert.asmx";
			
			
			
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
					.permitAll().build();
			StrictMode.setThreadPolicy(policy);
			
		
				SoapObject mRequest = new SoapObject(NAME_SPACE,METHOD_NAME);
				
				 PropertyInfo PI = new PropertyInfo();
				//PI.setType(double.class);
				 PI.setName(params[0].nameParam1);
				 PI.setValue(params[0].nameValue1);
//				 PI.setName(params[0].nameParam2);
//				 PI.setValue(params[0].nameValue2);
				 /*
				  * You can add property.
				  * 
				  */ 
				 mRequest.addProperty(PI);
				
				SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11); // soap version 
				envelope.dotNet=true;
				envelope.setOutputSoapObject(mRequest);
				
				
				HttpTransportSE transportSE= new HttpTransportSE(URL);
				transportSE.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"); 
				transportSE.debug = true;
				try {
					transportSE.call(SOAP_ACTION, envelope);
				} catch (HttpResponseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (XmlPullParserException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				try {
					myResult=(SoapPrimitive)envelope.getResponse();
					
				} catch (SoapFault e) {
					// TODO Auto-generated catch block
					Log.i("ERROR SOAP FAULT",e.toString());
					
					e.printStackTrace();
				}
				
				
				
			
				
		      			
			
			
			return null;
		}
		
		
		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			if(myResult!=null)
			MainActivity.rtxt.setText("Response : " + myResult.toString());
			
			super.onPostExecute(result);
		}
		
		
		
		

	}
	
	
	
	

}
