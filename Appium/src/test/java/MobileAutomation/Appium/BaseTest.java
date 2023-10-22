package MobileAutomation.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	
	public AppiumDriver driver;
	public AppiumDriverLocalService service;
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException {
		
		//To start the server Programatically
		service=new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\dell\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		
		//Device & App Configuration
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("Shahbaz");
		options.setApp("C:\\Users\\dell\\eclipse-workspace\\Appium\\src\\test\\java\\Resources\\ApiDemos-debug.apk");
		
		
		driver=new AppiumDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@AfterClass
	public void teardown() {
		
		driver.quit();
		service.stop();
	}

}
