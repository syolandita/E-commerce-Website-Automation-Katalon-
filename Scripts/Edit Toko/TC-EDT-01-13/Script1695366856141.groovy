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

WebUI.callTestCase(findTestCase('Pendaftaran/TC-DFTR-02-01'), [('id') : 'Daphnee', ('password') : '+wFSVlolvcJfO6os+KmCCg=='], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('Edit Toko/a_tombol menu toko'))

WebUI.click(findTestObject('Edit Toko/a_Pengaturan'))

WebUI.click(findTestObject('Edit Toko/a_tombol edit toko'))

WebUI.click(findTestObject('Edit Toko/dropdown pilihan kurir'))

WebDriver webDriver = DriverFactory.getWebDriver()

List<WebElement> checkboxes = DriverFactory.getWebDriver().findElements(By.xpath('/html/body/div[10]/div/div/div/div[2]/figure/div[5]/div/span/div/ul/li/a/label/input'))

for (WebElement checkbox : checkboxes) {
    checkbox.click()
}

WebUI.click(findTestObject('Edit Toko/tombol simpan perubahan'))

// Daftar nama-nama kurir yang diharapkan ada di checkbox
expectedCourierNames = 'JNE, J&T, TIKI, SiCepat Express, POS Indonesia, JET Express, Lion Parcel, Ninja Xpress, Wahana Prestasi Logistik, RPX Holding, Royal Express Indonesia (REX), ID Express (IDE), Sentral Cargo (SC), JNE Express,'

hasilKurir = WebUI.getText(findTestObject('Edit Toko/verifikasi kurir'))

assert expectedCourierNames == hasilKurir

