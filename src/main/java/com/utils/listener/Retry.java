package com.utils.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer  {
	private int count =0;
	private static int maxTry =3;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
					
		if(!result.isSuccess()) {
			if(count++ <maxTry) {
				result.setStatus(result.FAILURE);
				return true;
			} else {
				result.setStatus(result.FAILURE);
			}			
		}else {
			result.setStatus(result.SUCCESS);
		}
		return false;
	}

}
