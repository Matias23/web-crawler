package mricotta;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ResolverByHref extends ElementResolver{

    public ResolverByHref(ElementResolver e){
        super(e);
    }

    public void findMatchingElements(Element searched, Document toBeSearchedDoc, HashMap<Element, Integer> hm){
        final Iterator<Element> elementsFoundByHref = toBeSearchedDoc.getElementsByAttributeValue("href", searched.attr("href")).iterator();
        if(elementsFoundByHref.hasNext()){
            addElement(elementsFoundByHref.next(), hm);
        } else {
            super.findMatchingElements(searched, toBeSearchedDoc, hm);
        }
    }
}
