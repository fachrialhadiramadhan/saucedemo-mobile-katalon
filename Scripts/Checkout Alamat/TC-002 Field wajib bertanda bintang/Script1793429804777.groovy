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

Mobile.verifyElementExist(findTestObject('Main Menu/Catalog/0. Product/Atas Kiri'), 3)

Mobile.tap(findTestObject('Main Menu/Catalog/0. Product/Atas Kiri'), 3)

Mobile.verifyElementExist(findTestObject('Main Menu/Detail Product/Header Detail Product'), 3)

Mobile.tap(findTestObject('Main Menu/Detail Product/Button Add to cart'), 3)

Mobile.tap(findTestObject('Main Menu/Catalog/4. Cart'), 3)

Mobile.verifyElementExist(findTestObject('Main Menu/Cart/1. Button Proceed To Checkout'), 3)

Mobile.tap(findTestObject('Main Menu/Cart/1. Button Proceed To Checkout'), 3)

Mobile.verifyElementExist(findTestObject('Hamburger Click/11. Login/Login Header'), 3)

Mobile.tap(findTestObject('Hamburger Click/11. Login/Username bodexample.com'), 3)

Mobile.tap(findTestObject('Hamburger Click/11. Login/Button Login'), 3)

Mobile.verifyElementExist(findTestObject('Main Menu/Cart/Checkout/Checkout Header'), 3)

Mobile.verifyElementExist(findTestObject('Main Menu/Cart/Checkout/Input Full Name'), 1)

Mobile.verifyElementExist(findTestObject('Main Menu/Cart/Checkout/Input Address Line 1'), 1)

Mobile.verifyElementExist(findTestObject('Main Menu/Cart/Checkout/Input City'), 1)

Mobile.verifyElementExist(findTestObject('Main Menu/Cart/Checkout/Input Zip Code'), 1)

Mobile.verifyElementExist(findTestObject('Main Menu/Cart/Checkout/Input Country'), 1)

Mobile.closeApplication()

