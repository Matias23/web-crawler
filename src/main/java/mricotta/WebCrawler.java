package mricotta;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class WebCrawler
{
    public static void main( String[] args ) {
        final String baseHTMLUrl = args[0];
        final String toBeSearchedHTMLUrl = args[1];
        final String elementIdSearched = args[2];
        System.out.println( "Starting crawler" );
        WebCrawler wc = new WebCrawler();
        System.out.println("The path to the desired element in the second file is: " + wc.getPathToElement(baseHTMLUrl,
                toBeSearchedHTMLUrl, elementIdSearched));
    }

    public String getPathToElement(String baseHTMLUrl, String toBeSearchedHTMLUrl, String idSearched){
        try {
            final Document baseDocument = Jsoup.connect(baseHTMLUrl).get();
            final Document toBeSearchedHTMLDocument = Jsoup.connect(toBeSearchedHTMLUrl).get();

            final Element elementSearched = baseDocument.getElementById(idSearched);

            HashMap<Element, Integer> hm = new HashMap<>();

            new ResolverById(new ResolverByText(new ResolverByTitle(
                    new ResolverByClass(new ResolverByHref(new ResolverOnClick())))))
                    .findMatchingElements(elementSearched, toBeSearchedHTMLDocument, hm);

            final Element expextedElem = getMostSimilarElement(hm);

            if (expextedElem == null){
                return "Element not found";
            }

            Iterator<Element> parents = expextedElem.parents().iterator();
            String xmlPath = expextedElem.tagName();
            while(parents.hasNext()){
                xmlPath = parents.next().tagName() + " > " + xmlPath;
            }
            return xmlPath;

        } catch (IOException io) {
            return null;
        }
    }

    private Element getMostSimilarElement(HashMap<Element, Integer> hm){
        Element maxElem = null;
        int max = 0;
        for (Element e : hm.keySet()){
            if (hm.get(e) > max){
                max = hm.get(e);
                maxElem = e;
            }
        }
        return maxElem;
    }
}
