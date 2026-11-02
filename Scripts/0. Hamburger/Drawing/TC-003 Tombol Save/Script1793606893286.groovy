import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.llm.keyword.LlmKeywords as LLM
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

Mobile.startExistingApplication(GlobalVariable.apkPackage, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Main Menu/Catalog/5. Products Header'), 3)

Mobile.tap(findTestObject('Main Menu/Catalog/2. Hamburger Menu'), 3)

Mobile.verifyElementExist(findTestObject('Main Menu/Hamburger Menu/05. Drawing'), 3)

Mobile.tap(findTestObject('Main Menu/Hamburger Menu/05. Drawing'), 3)

Mobile.verifyElementExist(findTestObject('Hamburger Click/05. Drawing/Drawing Header'), 3)

padX = Mobile.getElementLeftPosition(findTestObject('Hamburger Click/05. Drawing/Drawing Pad'), 3)

padY = Mobile.getElementTopPosition(findTestObject('Hamburger Click/05. Drawing/Drawing Pad'), 3)

padW = Mobile.getElementWidth(findTestObject('Hamburger Click/05. Drawing/Drawing Pad'), 3)

padH = Mobile.getElementHeight(findTestObject('Hamburger Click/05. Drawing/Drawing Pad'), 3)

int x1 = ((padX + (padW * 0.2)) as int)

int y1 = ((padY + (padH * 0.3)) as int)

int x2 = ((padX + (padW * 0.8)) as int)

int y2 = ((padY + (padH * 0.7)) as int)

Mobile.swipe(x1, y1, x2, y2)

Mobile.tap(findTestObject('Hamburger Click/05. Drawing/Button Save'), 3)

Mobile.closeApplication()

