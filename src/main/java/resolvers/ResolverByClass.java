package resolvers;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.HashMap;
import java.util.Iterator;

public class ResolverByClass extends ElementResolver{

    public ResolverByClass(ElementResolver e){
        super(e);
    }

    public void findMatchingElements(Element searched, Document toBeSearchedDoc, HashMap<Element, Integer> hm){
        final Iterator<Element> elementsFoundByClass = toBeSearchedDoc.getElementsByAttributeValue("class",
                searched.className()).iterator();
        while (elementsFoundByClass.hasNext()){
            Element next = elementsFoundByClass.next();
            addElement(next, hm);
        }
        super.findMatchingElements(searched, toBeSearchedDoc, hm);
    }
}
