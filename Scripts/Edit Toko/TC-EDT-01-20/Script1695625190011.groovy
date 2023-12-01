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
import org.openqa.selenium.WebElement as WebElement

WebUI.callTestCase(findTestCase('Pendaftaran/TC-DFTR-02-01'), [('id') : 'Daphnee', ('password') : '+wFSVlolvcJfO6os+KmCCg=='], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('Edit Toko/a_tombol menu toko'))

WebUI.verifyElementPresent(findTestObject('Edit Toko/a_Pengaturan'), 10, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Edit Toko/a_Pengaturan'))

WebUI.click(findTestObject('Edit Toko/a_tombol edit toko'))

WebUI.verifyElementPresent(findTestObject('Edit Toko/dropdown kurir'), 10, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Edit Toko/dropdown kurir'))

WebUI.setText(findTestObject('Edit Toko/kolom search'), 'J&T')

//String hasilPencarianJNT = WebUI.getAttribute(findTestObject('Object Repository/Edit Toko/hasil search kurir'), 'innerText')
//boolean jikaJNT = hasilPencarianJNT.matches('J&T')
if (WebUI.verifyElementPresent(findTestObject('Object Repository/Edit Toko/checkbox jnt'), 0)) {
    WebUI.check(findTestObject('Object Repository/Edit Toko/checkbox jnt'))
} else {
    WebUI.verifyTextPresent('Keyword salah!', false)
}

WebUI.setText(findTestObject('Edit Toko/kolom search'), 'Pos Indonesia')

//String hasilPencarianPOS = WebUI.getAttribute(findTestObject('Object Repository/Edit Toko/hasil search kurir'), 'innerText')
//boolean jikaPOS = hasilPencarianPOS.matches('Pos Indonesia')
if (WebUI.verifyElementPresent(findTestObject('Object Repository/Edit Toko/checkboc pos'), 0)) {
    WebUI.check(findTestObject('Edit Toko/checkboc pos'))
} else {
    WebUI.verifyTextPresent('Keyword salah!', false)
}

WebUI.click(findTestObject('Edit Toko/tombol simpan perubahan'))

