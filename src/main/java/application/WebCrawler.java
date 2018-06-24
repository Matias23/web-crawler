package application;

import resolvers.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class WebCrawler {

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
