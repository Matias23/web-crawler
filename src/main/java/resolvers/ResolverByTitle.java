package resolvers;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.HashMap;
import java.util.Iterator;

public class ResolverByTitle extends ElementResolver{

    public ResolverByTitle(ElementResolver e){
        super(e);
    }

    public void findMatchingElements(Element searched, Document toBeSearchedDoc, HashMap<Element, Integer> hm){
        final Iterator<Element> elementsFoundByTitle = toBeSearchedDoc.getElementsByAttributeValue("title", searched.attr("title")).iterator();
        while(elementsFoundByTitle.hasNext()){
            Element next = elementsFoundByTitle.next();
            addElement(next, hm);
        }
        super.findMatchingElements(searched, toBeSearchedDoc, hm);
    }
}
