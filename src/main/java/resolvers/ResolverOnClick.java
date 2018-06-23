package resolvers;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.HashMap;
import java.util.Iterator;

public class ResolverOnClick extends ElementResolver{

    public ResolverOnClick(){
        super();
    }

    public void findMatchingElements(Element searched, Document toBeSearchedDoc, HashMap<Element, Integer> hm){
        final Iterator<Element> elementsFoundOnClick = toBeSearchedDoc.getElementsByAttributeValue("onclick",
                searched.attr("onclick")).iterator();
        while(elementsFoundOnClick.hasNext()){
            addElement(elementsFoundOnClick.next(), hm);
        }
        super.findMatchingElements(searched, toBeSearchedDoc, hm);
    }
}
