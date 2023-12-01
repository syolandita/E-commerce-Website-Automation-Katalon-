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
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement

WebUI.openBrowser(GlobalVariable.WebURL)

WebUI.maximizeWindow()

WebUI.mouseOver(findTestObject('Zakat/a_dropDownDonasi'))

WebUI.click(findTestObject('Zakat/a_tombolJemputZakat'))

WebUI.selectOptionByValue(findTestObject('Zakat/select_dropDownPilihanZakat'), jenisZakat, false)

WebUI.setText(findTestObject('Zakat/input_nama'), nama)

WebUI.setText(findTestObject('Zakat/input_noHP'), noHP)

WebUI.setText(findTestObject('Zakat/input_email'), email)

WebUI.selectOptionByLabel(findTestObject('Zakat/select_dropDownBank'), metode, false)

WebUI.setText(findTestObject('Zakat/input_alamatPenjemputan'), alamat)

WebUI.setText(findTestObject('Zakat/input_doa'), doa)

WebUI.setText(findTestObject('Zakat/input_2DigitNomorHP'), digit)

WebUI.click(findTestObject('Zakat/button_Jemput Zakat Sekarang'))

WebDriver webDriver = DriverFactory.getWebDriver()

WebElement email = webDriver.findElement(By.xpath('//input[@name="alamat_email"]'))

error_message = ((webDriver) as JavascriptExecutor).executeScript('return arguments[0].validationMessage', email)

println(error_message)

assert error_message == 'Please include an \'@\' in the email address. \'lilazzz.com\' is missing an \'@\'.'

