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

WebUI.click(findTestObject('Register/tombolRegister'))

WebUI.setText(findTestObject('Register/input_username'), username)

WebUI.setText(findTestObject('Register/input_email'), email)

WebUI.setText(findTestObject('Register/input_nomorHP'), noHP)

if (jenisKelamin == 'pria') {
	WebUI.check(findTestObject('Object Repository/Register/radioButtonPria'))
} else if (jenisKelamin == 'wanita') {
	WebUI.check(findTestObject('Object Repository/Register/radioButtonWanitaa'))
}

WebUI.setEncryptedText(findTestObject('Register/input_password'), password)

WebUI.setEncryptedText(findTestObject('Register/input_repassword'), confPass)

if (username =~ "^[a-zA-Z0-9]") {
	WebUI.click(findTestObject('Register/button_Daftar'))
	WebUI.verifyElementPresent(findTestObject('Register/validasiRegisterSukses'), 0)
	WebUI.verifyTextPresent('Terima kasih, anda sudah terdaftar di https://tajalapak.com silahkan cek email untuk verifikasi!',
		false)
} else {
	WebUI.verifyTextPresent('username tidak valid!',false)
}



