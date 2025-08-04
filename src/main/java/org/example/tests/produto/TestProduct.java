package org.example.tests.produto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestProduct {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4200/products/create");

        driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]")).sendKeys("COCA-COLA");
        driver.findElement(By.xpath("//*[@id=\"mat-input-1\"]")).sendKeys("2.50");
        driver.findElement(By.xpath("//*[@id=\"mat-input-2\"]")).sendKeys("5.00");
        driver.findElement(By.xpath("//*[@id=\"mat-input-3\"]")).sendKeys("60");
        driver.findElement(By.xpath("//*[@id=\"mat-input-4\"]")).sendKeys("Bebidas");
        driver.findElement(By.xpath("//*[@id=\"mat-input-5\"]")).sendKeys("123423423");

        // 1. Clica para abrir o dropdown
       // WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mat-select-value-1\"]/span")));
        //menu.click();

        // 2. Espera e clica na opção desejada
        //WebElement opcao = wait.until(ExpectedConditions.elementToBeClickable(
          //      By.xpath("//li[text()='Eletrônicos']")));
        //opcao.click();

        //driver.quit();

        driver.findElement(By.xpath("//*[@id=\"mat-option-5\"]/span")).click();

        driver.findElement(By.xpath("//*[@id=\"mat-option-8\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"mat-input-6\"]")).sendKeys("Coca-Cola");
        driver.findElement(By.xpath("//*[@id=\"mat-input-7\"]")).sendKeys("Litros");

        driver.findElement(By.xpath("//*[@id=\"mat-select-value-11\"]/span")).click();

        driver.findElement(By.xpath("//*[@id=\"mat-option-6\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"mat-input-8\"]")).sendKeys("COCA-COLA 1L");

        try{

            Thread.sleep(5000);

        }catch (InterruptedException e){

            e.printStackTrace();
        }

        driver.close();

    }

}
