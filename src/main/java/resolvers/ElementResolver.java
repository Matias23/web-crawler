package resolvers;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.HashMap;

public  abstract class ElementResolver {
    protected ElementResolver nextResolver;

    public ElementResolver(){
        nextResolver =  null;
    }

    public ElementResolver(ElementResolver next){
        nextResolver = next;
    }

    void findMatchingElements(Element searched, Document toBeSearchedDoc, HashMap<Element, Integer> hm){
        if (nextResolver != null){
            nextResolver.findMatchingElements(searched, toBeSearchedDoc, hm);
        }
    }

    protected void addElement(Element found, HashMap<Element, Integer> hm){
        if(hm.containsKey(found)){
            hm.replace(found, hm.get(found) + 1);
        } else{
            hm.put(found, 1);
        }
    }
}
