import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

WebUI.openBrowser(GlobalVariable.WebURL)

WebUI.maximizeWindow()

WebUI.mouseOver(findTestObject('Zakat/a_dropDownDonasi'))

WebUI.click(findTestObject('Zakat/a_tombolJemputZakat'))

WebUI.click(findTestObject('Zakat/button_Jemput Zakat Sekarang'))

WebDriver webDriver = DriverFactory.getWebDriver()

List<WebElement> elementsToCheck = [webDriver.findElement(By.xpath('//input[@name="nama_lengkap"]')), webDriver.findElement(
		By.xpath('//input[@name="no_handphone"]')), webDriver.findElement(By.xpath('//input[@name="alamat_email"]')), 
		webDriver.findElement(By.xpath('//textarea[@name="doa_terbaik"]')), webDriver.findElement(By.xpath('//input[@name="alamat"]')),
		webDriver.findElement(By.xpath('//input[@name="validasi"]'))]

def errorMessages = []

for (WebElement element : elementsToCheck) {
	def errorMessage = ((webDriver) as JavascriptExecutor).executeScript('return arguments[0].validationMessage', element)

	errorMessages.add(errorMessage)
}

assert errorMessages.contains('Please fill out this field.')