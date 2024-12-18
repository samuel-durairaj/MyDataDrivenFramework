/**
 * 
 */
package com.myapp.actiondriver;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.myapp.base.BaseClass;

/**
 * @author Samuel Durairaj added on 13th March2019
 *
 */

public class Action extends BaseClass {

	public static void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollintoview();", ele);
	}
	
	public static void click(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).click().build().perform();
	}
	
	public boolean findElement(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			ele.isDisplayed();
			flag = true;
		} catch (Exception e) {
			flag = false;
		}finally {
		if(flag) {
			System.out.println("Successfully found element at");
		}
		else {
			System.out.println("Unable to locate element at");
		  }
		}
		return flag;
	}
	
	public boolean isDisplayed(WebDriver driver, WebElement ele) {
		boolean flag = false;
		flag = findElement(driver,ele);
		if(flag) {
			flag = ele.isDisplayed();
			if(flag) {
				System.out.println("The element is displayed");
			}else {
				System.out.println("The element is not displayed");
			}
		}else {
			System.out.println("Not displayed");
		}
		return flag;
	}
	
	public boolean isSelected(WebDriver driver, WebElement ele) {
		boolean flag = false;
		flag = findElement(driver,ele);
		if(flag) {
			flag = ele.isSelected();
			if(flag) {
				System.out.println("The element is Selected");
			}else {
				System.out.println("The element is not Selected");
			}
		}else {
			System.out.println("Not selected");
		}
		return flag;
	}
	
	public boolean isEnabled(WebDriver driver, WebElement ele) {
		boolean flag = false;
		flag = findElement(driver, ele);
		if(flag) {
			flag = ele.isEnabled();
			if(flag) {
				System.out.println("The element is Enabled");
			}else {
				System.out.println("The element is not Enabled");
			}
		}else {
			System.out.println("Not enabled");
		}
		return flag;
	}
	
	/**
	 * Type text at location
	 * 
	 * @param locatorName
	 * @param text
	 * @return - true/false
	 */
	
	public boolean type(WebElement ele, String text) {
		boolean flag = false;
		try {
			flag = ele.isDisplayed();
			ele.clear();
			ele.sendKeys(text);
			flag = true;
		} catch (Exception e) {
			System.out.println("Location Not found");
			flag = false;
		}finally {
			if(flag) {
				System.out.println("Successfully entered value");
			}else {
				System.out.println("Unable to enter value");
			}
		}
		return flag;
	}
	
	public boolean selectBySendKeys(WebElement ele, String value) {
		boolean flag = false;
		try {
			ele.sendKeys(value);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}finally {
			if(flag) {
				System.out.println("Select value from the Dropdown");
			}else {
				System.out.println("Not selected value from the Dropdown");
			}
		}
	}
	
	/**
	 * select value from DropDown by using selectByIndex
	 * 
	 * @param locator     : Action to be performed on element (Get it from Object
	 *                    repository)
	 * 
	 * @param index       : Index of value wish to select from dropdown list.
	 * 
	 * @param locatorName : Meaningful name to the element (Ex:Year Dropdown, items
	 *                    Listbox etc..)
	 * 
	 */
	
	public boolean selectByIndex(WebElement ele, int index) {
		boolean flag = false;
		try {
			Select s = new Select(ele);
			s.selectByIndex(index);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}finally {
			if(flag) {
				System.out.println("Option selected by Index");
			}else {
				System.out.println("Option not selected by Index");
			}
		}
	}
	
	/**
	 * select value from DD by using value
	 * 
	 * @param locator     : Action to be performed on element (Get it from Object
	 *                    repository)
	 * 
	 * @param value       : Value wish to select from dropdown list.
	 * 
	 * @param locatorName : Meaningful name to the element (Ex:Year Dropdown, items
	 *                    Listbox etc..)
	 */
	
	public boolean selectByValue(WebElement ele, String value) {
		boolean flag = false;
		try {
			Select s = new Select(ele);
			s.selectByValue(value);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}finally {
			if(flag) {
				System.out.println("Option selected by Value");
			}
			else {
				System.out.println("Option not selected by Value");
			}
		}
	}
	
	/**
	 * select value from DropDown by using selectByVisibleText
	 * 
	 * @param locator     : Action to be performed on element (Get it from Object
	 *                    repository)
	 * 
	 * @param visibletext : VisibleText wish to select from dropdown list.
	 * 
	 * @param locatorName : Meaningful name to the element (Ex:Year Dropdown, items
	 *                    Listbox etc..)
	 */
	
	public boolean selectByVisibleText(WebElement ele, String visibleText) {
		boolean flag = false;
		try {
			Select s = new Select(ele);
			s.selectByVisibleText(visibleText);
			flag = true;
			return true;
		}catch(Exception e) {
			return false;
		}finally {
			if(flag) {
				System.out.println();
			}else {
			    System.out.println();	
			}
		}
	}
	
	public boolean mouseHoverByJavaScript(WebElement ele) {
		boolean flag = false;
		try {
			WebElement mo = ele;
			String javascript = "var evObj = document.createEvent('MouseEvents');"
					+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
					+ "arguments[0].dispatchEvent(evObj);";
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript(javascript, mo);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}finally {
			if(flag) {
				System.out.println("Mouse hover action is performed");
			}else {
				System.out.println("Mouse hover action is not performed");
			}
			
		}
	}
	
	public boolean JSClick(WebElement ele, WebDriver driver) throws Exception {
		boolean flag = false;
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", ele);
			flag = true;
		} 
		finally {
			if(flag) {
				System.out.println("Click action is performed");
			}else {
				System.out.println("Click action is not performed");
			}
		}
		return flag;
	}
	
	public boolean switchToFramByIndex(WebDriver driver, int index) {
		boolean flag = false;
		try {
			new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}finally {
			if(flag) {
				System.out.println("Frame with index \"" + index + "\" is selected");
			}else {
				System.out.println("Frame with index \"" + index + "\" is not selected");
			}
		}
	}
	

	/**
	 * This method switch the to frame using frame ID.
	 * 
	 * @param idValue : Frame ID wish to switch
	 * 
	 */
	
	public boolean switchToFramByID(WebDriver driver, String idValue) {
		boolean flag = false;
		try {
		driver.switchTo().frame(idValue);
		flag = true;
		return true;
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}finally {
			if(flag) {
				System.out.println("Frame with Id \"" + idValue + "\" is selected");
			}else {
				System.out.println("Frame with Id \"" + idValue + "\" is not selected");
			}
		}
	}
	
	/**
	 * This method switch the to frame using frame Name.
	 * 
	 * @param nameValue : Frame Name wish to switch
	 * 
	 */
	
	public boolean switchToFrameByName(WebDriver driver, String nameValue) {
		boolean flag = false;
		try {
			driver.switchTo().frame(nameValue);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}finally {
			if (flag) {
				System.out.println("Frame with Name \"" + nameValue + "\" is selected");
			} else if (!flag) {
				System.out.println("Frame with Name \"" + nameValue + "\" is not selected");
			}
		}
	}
	
	public boolean switchToDefaultFrame(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			driver.switchTo().defaultContent();
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}finally {
			if(flag) {
				// SuccessReport("SelectFrame ","Frame with Name is selected");
			}else {
				// failureReport("SelectFrame ","The Frame is not selected");
			}
		}
	}
	
	public void mouseOverElement(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			new Actions(driver).moveToElement(ele).build().perform();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(flag) {
				System.out.println(" MouserOver Action is performed on ");
			}else {
				System.out.println(" MouserOver Action is not performed on ");
			}
		}
	}
	
	public boolean moveToElement(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", ele);
			
			Actions action = new Actions(driver);
			action.moveToElement(ele).build().perform();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean mouseover(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			new Actions(driver).moveToElement(ele).build().perform();
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean draggable(WebDriver driver, WebElement source, int x, int y) {
		boolean flag = false;
		try {
			new Actions(driver).dragAndDropBy(source, x, y).build().perform();
			flag = true;
			return true;
		}catch (Exception e){
			return false;
		}finally {
			if (flag) {
				System.out.println("Draggable Action is performed on \""+source+"\"");			
			} else if(!flag) {
				System.out.println("Draggable action is not performed on \""+source+"\"");
			}
		}
	}
	
	public boolean draganddrop(WebDriver driver, WebElement source, WebElement target) {
		boolean flag = false;
		try {
			new Actions(driver).dragAndDrop(source, target).build().perform();
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}finally {
			if(flag) {
				System.out.println("Drag and Drop action is performed");
			}else {
				System.out.println("Drag and Drop action is not performed");
			}
		}
	}
	
	public boolean slider(WebDriver driver, WebElement ele, int x, int y) {
		boolean flag = false;
		try {
			new Actions(driver).dragAndDropBy(ele, x, y).build().perform();
			Thread.sleep(5000);
			flag = true;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			if(flag) {
				System.out.println("Slider action is performed");
			}else {
				System.out.println("Slider action is not performed");
			}	
		}
	}
	
	public boolean rightClick(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			Actions action = new Actions(driver);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}finally {
			if(flag) {
				System.out.println("Right Click action is performed");
			}else {
				System.out.println("Right Click action is not performed");
			}
		}
	}
	
	public boolean switchWindowByTitle(WebDriver driver, String windowTitle, int count) {
		boolean flag = false;
		try {
			Set<String> windowList = driver.getWindowHandles();
			String[] array = windowList.toArray(new String[0]);
			driver.switchTo().window(array[count-1]);
			
			if(driver.getTitle().contains(windowTitle)) {
				return true;
			}else {
			    return false;	
			}
		} catch (Exception e) {
			return false;
		}finally {
			if(flag) {
				System.out.println("Navigated to the window with Title");
			}else {
				System.out.println("The Window with the title is not selected");
			}
		}
	}
	
	public boolean switchToNewWindow(WebDriver driver) {
		boolean flag = false;
		try {
			Set<String> set = driver.getWindowHandles();
			Object[] popup = set.toArray();
			driver.switchTo().window(popup[1].toString());
			
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}finally {
			if(flag) {
				System.out.println("Window is Navigated with title");
			}else {
				System.out.println("The Window with title: is not Selected");
			}
		}
	}
	
	public boolean switchToOldWindow(WebDriver driver) {
		boolean flag = false;
		try {
			Set<String> set = driver.getWindowHandles();
			Object[] popup = set.toArray();
			driver.switchTo().window(popup[0].toString());
			
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}finally {
			if(flag) {
			    System.out.println("Focus navigated to the window with title");	
			}else {
				System.out.println("The Window with title: is not Selected");
			}
		}
	}
	
	public int getColumnCount(WebElement col) {
		List<WebElement> columns = col.findElements(By.tagName("td"));
		int colSize = columns.size();
		System.out.println(columns.size());
		
		for(WebElement column: columns) {
			System.out.print(column.getText());
			System.out.print("|");
		}
		return colSize;
	}
	
	public int getRowCount(WebElement row) {
		List<WebElement> rows = row.findElements(By.tagName("tr"));
		int rowSize = rows.size()-1;
		return rowSize;
	}
}
