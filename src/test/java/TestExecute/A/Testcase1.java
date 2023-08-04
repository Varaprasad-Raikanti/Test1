package TestExecute.A;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import TestComponent.SampleComponent1.AHelper;
import TestLib.Common;
import TestLib.Login;

public class Testcase1 {

	String datafile = "A//A.xlsx";
	AHelper A = new AHelper(datafile,"DataSet");

	@Test(retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void ValidateTestcase1() throws Exception {
//      for(int i=0;i<3;i++)
//      {
		try {
			A.verifingHomePage();
			
		} catch (Exception e) {

			Assert.fail(e.getMessage(), e);
		}
	}


	@AfterTest
	public void clearBrowser() {
		Common.closeAll();

	}

	@BeforeTest
	public void startTest() throws Exception {
		System.setProperty("configFile", "A//config.properties");
        Login.signIn("chrome");

	}

}