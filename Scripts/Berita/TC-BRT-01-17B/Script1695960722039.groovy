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

WebUI.openBrowser('https://10.9.2.63/ecommerce/administrator/')

WebUI.maximizeWindow()

WebUI.setText(findTestObject('administrator/input_ADMIN_a'), 'admin')

WebUI.setText(findTestObject('administrator/input_ADMIN_b'), '123admin123')

WebUI.delay(10)

WebUI.click(findTestObject('administrator/input_Remember Me_submit'))

WebUI.click(findTestObject('Berita/a_Modul Berita'))

WebUI.click(findTestObject('Berita/a_Berita'))

WebUI.doubleClick(findTestObject('Object Repository/Berita/th_Judul Berita'))

List<WebElement> dataList = WebUI.findWebElements(findTestObject('Object Repository/Berita/data_judul'), 10)

panjangDataListBerita = dataList.size()

String[] arrOriB = new String[panjangDataListBerita]

String[] arrSortB = new String[panjangDataListBerita]

for(int i = 0; i<dataList.size(); i++) {
	text = dataList.get(i).text
	
	(arrOriB[i]) = text.trim().toLowerCase()
	(arrSortB[i]) = text.trim().toLowerCase()
}

Arrays.sort(arrSortB,Comparator.reverseOrder())

assert arrOriB == arrSortB


