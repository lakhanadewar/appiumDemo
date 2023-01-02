package LakhanAdewar.AppiumAndroid;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClassAndroid {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass
	public void ConfigAppium() throws MalformedURLException {

		service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C:\\Users\\lakha\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();

		UiAutomator2Options options = new UiAutomator2Options();

		options.setDeviceName("lakhanAndroid");
		// options.setDeviceName("Xiaomi Redmi Note 9 Pro Max");
		options.setApp(
				"C:\\Users\\lakha\\eclipse\\Fresh-eclipse-workspace\\AppiumAndroid\\src\\test\\java\\Resources\\ApiDemos-debug.apk");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterClass
	public void stopServices() {

		service.stop();
		driver.quit();
	}

}
