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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement

WebUI.callTestCase(findTestCase('Pendaftaran/TC-DFTR-02-01'), [('id') : 'Daphnee', ('password') : '+wFSVlolvcJfO6os+KmCCg=='], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('Edit Toko/a_tombol menu toko'))

WebUI.click(findTestObject('Edit Toko/a_Pengaturan'))

WebUI.click(findTestObject('Edit Toko/a_tombol edit toko'))

WebUI.selectOptionByLabel(findTestObject('Edit Toko/select_- Pilih Provinsi -'), prov, false)

WebUI.selectOptionByLabel(findTestObject('Edit Toko/dropdown nama kabupaten'), kota, false)

WebUI.selectOptionByLabel(findTestObject('Edit Toko/dropdown nama kecamatan'), kecamatan, false)

WebUI.click(findTestObject('Edit Toko/tombol simpan perubahan'))

WebDriver webDriver = DriverFactory.getWebDriver()

List<WebElement> elementsToCheck = [webDriver.findElement(By.xpath('//select[@id="list_provinsi"]')), webDriver.findElement(
        By.xpath('//select[@id="list_kotakab"]')), webDriver.findElement(By.xpath('//select[@id="list_kecamatan"]'))]

def errorMessages = []

for (WebElement element : elementsToCheck) {
    def errorMessage = ((webDriver) as JavascriptExecutor).executeScript('return arguments[0].validationMessage', element)

    errorMessages.add(errorMessage)
}

assert errorMessages.contains('Please select an item in the list.')

