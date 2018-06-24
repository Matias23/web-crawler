package com;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import application.WebCrawler;
import org.junit.Test;

/**
 * Unit test for simple WebCrawler.
 */
public class AppTest 
{
    /**
     * Test to check whether the element is found in the first HTML document
     */
    @Test
    public void firstHTMLSearchWorksFine() {
        WebCrawler wc = new WebCrawler(); // WebCrawler is tested

        // assert statements
        assertEquals("html > body > div > div > div > div > div > div > a",
                wc.getPathToElement("https://agileengine.bitbucket.io/beKIvpUlPMtzhfAy/samples/sample-0-origin.html",
                        "https://agileengine.bitbucket.io/beKIvpUlPMtzhfAy/samples/sample-1-evil-gemini.html",
                        "make-everything-ok-button"));
    }

    /**
     * Test to check whether the element is found in the second HTML document
     */
    @Test
    public void secondHTMLSearchWorksFine() {
        WebCrawler wc = new WebCrawler(); // WebCrawler is tested

        // assert statements
        assertEquals("html > body > div > div > div > div > div > div > div > a",
                wc.getPathToElement("https://agileengine.bitbucket.io/beKIvpUlPMtzhfAy/samples/sample-0-origin.html",
                        "https://agileengine.bitbucket.io/beKIvpUlPMtzhfAy/samples/sample-2-container-and-clone.html",
                        "make-everything-ok-button"));
    }

    /**
     * Test to check whether the element is found in third HTML document
     */
    @Test
    public void thirdHTMLSearchWorksFine() {
        WebCrawler wc = new WebCrawler(); // WebCrawler is tested

        // assert statements
        assertEquals("html > body > div > div > div > div > div > div > a",
                wc.getPathToElement("https://agileengine.bitbucket.io/beKIvpUlPMtzhfAy/samples/sample-0-origin.html",
                        "https://agileengine.bitbucket.io/beKIvpUlPMtzhfAy/samples/sample-3-the-escape.html",
                        "make-everything-ok-button"));
    }

    /**
     * Test to check whether the element is found in fourth HTML document
     */
    @Test
    public void fourthHTMLSearchWorksFine() {
        WebCrawler wc = new WebCrawler(); // WebCrawler is tested

        // assert statements
        assertEquals("html > body > div > div > div > div > div > div > a",
                wc.getPathToElement("https://agileengine.bitbucket.io/beKIvpUlPMtzhfAy/samples/sample-0-origin.html",
                        "https://agileengine.bitbucket.io/beKIvpUlPMtzhfAy/samples/sample-4-the-mash.html",
                        "make-everything-ok-button"));
    }
}
