package com.personal.project.URL.Data.Extractor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class UrlDataExtractorApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlDataExtractorApplication.class, args);
		
		Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the URL to extract data from:");
        String inputUrl = scanner.nextLine();
        
        try {
        	// Fetch the HTML document from the URL
        	Document document = Jsoup.connect(inputUrl).get();
        	
        	//Extract and display the title
        	String title = document.title();
        	System.out.println("\nPage Title: " + title);
        	
        	//Extract and display all links
        	System.out.println("\nLinks found on the page:");
        	Elements links = document.select("a[href]");
        	for(Element link : links)
        		System.out.println(link.attr("abs:href") + " (Text: " + link.text() + ")");
        	
        	// Extract and display all image sources
        	System.out.println("\nImages found on the page:");
        	Elements images = document.select("img[src]");
        	for(Element img : images) 
        		System.out.println(img.attr("abs:src") + " (Alt: " + img.attr("alt") + ")");
        	
        	// Extract and display paragraphs
            System.out.println("\nParagraphs found on the page:");
            Elements paragraphs = document.select("p");
            for(Element paragraph : paragraphs)
            	System.out.println(paragraph.text());
        } catch(IOException e) {
        	System.out.println("Failed to fetch data from the URL. Error: " + e.getMessage());
        }
        finally {
        	scanner.close();
        }
	}

}
