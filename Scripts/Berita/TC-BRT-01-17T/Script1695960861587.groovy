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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

WebUI.openBrowser('https://10.9.2.63/ecommerce/administrator/')

WebUI.maximizeWindow()

WebUI.setText(findTestObject('administrator/input_ADMIN_a'), 'admin')

WebUI.setText(findTestObject('administrator/input_ADMIN_b'), '123admin123')

WebUI.delay(10)

WebUI.click(findTestObject('administrator/input_Remember Me_submit'))

WebUI.click(findTestObject('Berita/a_Modul Berita'))

WebUI.click(findTestObject('Berita/a_Berita'))

WebUI.doubleClick(findTestObject('Object Repository/Berita/th_Tanggal'))

List<WebElement> dataList = WebUI.findWebElements(findTestObject('Object Repository/Berita/data_Tanggal'), 10);
int panjangDataListTanggal = dataList.size();

String[] arrOriT = new String[panjangDataListTanggal];
String[] arrSortT = new String[panjangDataListTanggal];

DateFormat inputFormat = new SimpleDateFormat("dd MMMM yyyy");
DateFormat outputFormat = new SimpleDateFormat("yyyyMMdd");

for (int i = 0; i < dataList.size(); i++) {
    String text = dataList.get(i).text;

    try {
        Date date = inputFormat.parse(text);
        String formatTanggal = outputFormat.format(date);
        arrOriT[i] = formatTanggal;
        arrSortT[i] = formatTanggal;
    } catch (ParseException e) {
		
        e.printStackTrace();
    }
}

Arrays.sort(arrSortT, Comparator.reverseOrder());

assert arrOriT == arrSortT
