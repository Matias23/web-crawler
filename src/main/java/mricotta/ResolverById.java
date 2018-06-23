package mricotta;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.HashMap;

public class ResolverById extends ElementResolver {

    public ResolverById(ElementResolver e){
        super(e);
    }

    public void findMatchingElements(Element searched, Document toBeSearchedDoc, HashMap<Element, Integer> hm){
        final Element elementFoundById = toBeSearchedDoc.getElementById(searched.id());
        if(elementFoundById != null){
            addElement(elementFoundById, hm);
        } else {
            super.findMatchingElements(searched, toBeSearchedDoc, hm);
        }
    }
}
