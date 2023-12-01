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

WebUI.click(findTestObject('administrator/button master market'))

WebUI.click(findTestObject('administrator/button reseller'))

List<WebElement> dataList = WebUI.findWebElements(findTestObject('Object Repository/administrator/db nama toko'), 10);
String[] arrNamaToko = new String[dataList.size()];

for (int i = 0; i < dataList.size(); i++) {
    String listNamaToko = dataList.get(i).getText();
    println("ini listnya: " + listNamaToko);
    arrNamaToko[i] = listNamaToko;
}

for (int i = 0; i < arrNamaToko.length; i++) {
    println("final : " + arrNamaToko[i]);
}

WebUI.click(findTestObject('administrator/a_Logout'));
WebUI.callTestCase(findTestCase('Pendaftaran/TC-DFTR-02-01'), [('id') : 'Daphnee', ('password') : '+wFSVlolvcJfO6os+KmCCg=='], 
    FailureHandling.STOP_ON_FAILURE);
WebUI.mouseOver(findTestObject('Edit Toko/a_tombol menu toko'));
WebUI.click(findTestObject('Edit Toko/a_Pengaturan'));
WebUI.click(findTestObject('Edit Toko/a_tombol edit toko'));
WebUI.setText(findTestObject('Edit Toko/input_Nama Toko'), namaToko);

if (Arrays.asList(arrNamaToko).contains(namaToko)) {
    WebUI.verifyTextPresent('Nama toko sudah ada! gunakan nama toko yang lain!', false);
} else {
    WebUI.click(findTestObject('Edit Toko/tombol simpan perubahan'));
    println(arrNamaToko[i]);
}
