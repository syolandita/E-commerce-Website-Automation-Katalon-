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

if (noHP.length() < 10 || noHP.length() > 13) {
	
	WebUI.click(findTestObject('Zakat/button_Jemput Zakat Sekarang'))
    WebUI.verifyTextPresent('nomor HP tidak valid', false)
} else {
	
	WebUI.click(findTestObject('Zakat/button_Jemput Zakat Sekarang'))
	WebUI.verifyElementPresent(findTestObject('Object Repository/Zakat/verifikasiZakatBerhasil'), 0)
}
