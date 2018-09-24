

package com.qa.quickstart.SomeWebSite;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;



public class homepage 
{
//	public enum webPage
//	{
//		WOMEN,
//		DRESSES,
//		TSHIRTS
//	};
	@FindBy( xpath = "/html/body")
	private WebElement button;
	
	public void drawTesting(Actions action) throws InterruptedException
	{
		action.moveByOffset(200, 300).perform();
		//action.dragAndDropBy(button, 200, 100).perform();
		//action.moveByOffset(900,0 ).click().perform();
		// t
//		for(int i = 0; i < 50;i++)
//		{
//			action.moveByOffset(1, 0).release().click().perform();
//			ChangeColour(action);
//		}
//		action.moveByOffset(-25, 0).perform();
//		for(int i = 0; i < 50;i++)
//		{
//			action.moveByOffset(0, 1).release().click().perform();
//			ChangeColour(action);
//		}
//		action.moveByOffset(50, -50).perform();
		
		
//		// N
//		action.moveByOffset(50, -50).perform();
//		for(int i = 0; i < 50;i++)
//		{
//			action.moveByOffset(0, 1).release().click().perform();
//			ChangeColour(action);
//		}
//		action.moveByOffset(0, -50).perform();
//		for(int i = 0; i < 50;i++)
//		{
//			action.moveByOffset(1, 0).release().click().perform();
//			ChangeColour(action);
//		}
//		for(int i = 0; i < 50;i++)
//		{
//			action.moveByOffset(0, 1).release().click().perform();
//			ChangeColour(action);
//		}
//		// S
//		action.moveByOffset(50, -50).perform();
//		for(int i = 0; i < 50;i++)
//		{
//			action.moveByOffset(1, 0).release().click().perform();
//			ChangeColour(action);
//		}
//		action.moveByOffset(-50, 0).perform();
//		for(int i = 0; i < 25;i++)
//		{
//			action.moveByOffset(0, 1).release().click().perform();
//			ChangeColour(action);
//		}
//		for(int i = 0; i < 50;i++)
//		{
//			action.moveByOffset(1, 0).release().click().perform();
//			ChangeColour(action);
//		}
//		for(int i = 0; i < 25;i++)
//		{
//			action.moveByOffset(0, 1).release().click().perform();
//			ChangeColour(action);
//		}
//		for(int i = 0; i < 50;i++)
//		{
//			action.moveByOffset(-1, 0).release().click().perform();
//			ChangeColour(action);
//		}
//		action.moveByOffset(100, -50).perform();
//		
//		//T
//		for(int i = 0; i < 50;i++)
//		{
//			action.moveByOffset(1, 0).release().click().perform();
//			ChangeColour(action);
//		}
//		action.moveByOffset(-25, 0).perform();
//		for(int i = 0; i < 50;i++)
//		{
//			action.moveByOffset(0, 1).release().click().perform();
//			ChangeColour(action);
//		}
//		action.moveByOffset(75, -50).perform();
//		//E
//		for(int i = 0; i < 50;i++)
//		{
//			action.moveByOffset(1, 0).release().click().perform();
//			ChangeColour(action);
//		}
//		action.moveByOffset(-50, 0).perform();
//		for(int i = 0; i < 25;i++)
//		{
//			action.moveByOffset(0, 1).release().click().perform();
//			ChangeColour(action);
//		}
//		for(int i = 0; i < 50;i++)
//		{
//			action.moveByOffset(1, 0).release().click().perform();
//			ChangeColour(action);
//		}
//		action.moveByOffset(-50, 0).perform();
//		for(int i = 0; i < 25;i++)
//		{
//			action.moveByOffset(0, 1).release().click().perform();
//			ChangeColour(action);
//		}
//		for(int i = 0; i < 50;i++)
//		{
//			action.moveByOffset(1, 0).release().click().perform();
//			ChangeColour(action);
//		}
//		// I
//		for(int i = 0; i < 50;i++)
//		{
//			action.moveByOffset(0, 1).release().click().perform();
//			ChangeColour(action);
//		}
		
		
//		Thread.sleep(3000);
		
	}
	public void draw(Actions action) throws InterruptedException
	{
		int turns = 10;
		int size = 100;
		int itr = 0;
		action.moveByOffset(200, 300).perform();
		for(int i = 0; i < turns;)
		{
			for(int j =0; j <size;j++ )
			{
				if(itr ==0)
				{
					action.click().moveByOffset(1, 0).release().click().click().perform();
				}
				else if(itr ==1)
				{
					action.click().moveByOffset(0, -1).release().click().click().perform();
				}
				else if(itr ==2)
				{
					action.click().moveByOffset(-1, 0).release().click().click().perform();
				}
				else if(itr ==3)
				{
					action.click().moveByOffset(0, 1).release().click().click().perform();
				}
				
			}
			if(itr++ == 4)
			{
				i++;
				size += 30;
				itr =0;
			}
		}
		
		
		
		
//		// Left
//		for (int i = 0 ; i < 100 ; i ++) {
//			
//			action.click().moveByOffset(0, -1).release().click().click().perform();
//			
//			
//			}
//		action.moveByOffset(0, 100).perform();
//		for (int i = 0 ; i < 100 ; i ++) {
//		
//		action.click().moveByOffset(1, 0).release().click().click().perform();
//		
//		
//		}
//		action.moveByOffset(-100, 0).perform();
//		for (int i = 0 ; i < 100 ; i ++) {
//		
//		action.click().moveByOffset(1, 0).release().click().click().perform();
		
		
		//}
		Thread.sleep(3000);
		
	}
	public void ChangeColour(Actions action)
	{
		Random r = new Random();
		int Low = 10;
		int High = 200;
		int Result = r.nextInt(High-Low) + Low;
		action.moveByOffset(900 + Result,Result ).click().perform();
		action.moveByOffset(-900 - Result,-Result).click().perform();
	}
	//@FindBy( xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a")
	//private WebElement dressesButton;
	
	//@FindBy( xpath = "//*[@id=\"block_top_menu\"]/ul/li[3]/a")
	//private WebElement tshirtsButton;
	
	
//	public void clickPage(webPage page)
//	{
//		if(page == webPage.WOMEN)
//		{
//			womenButton.click();
//		}
//		else if(page == webPage.DRESSES)
//		{
//			dressesButton.click();
//		}
//		else if(page == webPage.TSHIRTS)
//		{
//			tshirtsButton.click();
//		}
//			
//	}

}
