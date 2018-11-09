package dom1;

import org.w3c.dom.Document;

/**
 *
 * @author pablo
 */
public class DOM1 {

    public static void main(String[] args) {
        Dom dom = new Dom();
        String ruta = "peliculas.xml";
        Document doc = dom.creaArbol(ruta);
        //dom.verTitulos(doc);
        //dom.verPeliculas(doc);
        //dom.masNDirectores(doc, 1);
        //dom.numGeneros(doc);
    }

}
