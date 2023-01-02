package LakhanAdewar.AppiumAndroid;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class AppiumbasicLakhan extends BaseClassAndroid {

	@Test
	public void main() throws MalformedURLException {

		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
		driver.findElement(AppiumBy.id("android:id/checkbox")).click();

		driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String alertTitle = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
		String exp = "WiFi settings";

		System.out.println(alertTitle);
		Assert.assertEquals(exp, alertTitle);
		driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("LakhanSSDI");
		driver.findElement(AppiumBy.id("android:id/button1")).click();
	}

}
