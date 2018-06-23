package mricotta;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.HashMap;
import java.util.Iterator;

public class ResolverByText extends ElementResolver{

    public ResolverByText(ElementResolver e){
        super(e);
    }

    public void findMatchingElements(Element searched, Document toBeSearchedDoc, HashMap<Element, Integer> hm){
        final Iterator<Element> elementsFoundByText = toBeSearchedDoc.getElementsContainingOwnText(searched.text()).iterator();
        while(elementsFoundByText.hasNext()) {
            Element next = elementsFoundByText.next();
            if (next.text().equals(searched.text())) {
                addElement(next, hm);
            }
        }
        super.findMatchingElements(searched, toBeSearchedDoc, hm);
    }
}
