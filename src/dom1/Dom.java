package dom1;

import java.util.ArrayList;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author pablo
 */
public class Dom {

//EJERCICIO 1
    public Document creaArbol(String ruta) {
        Document doc = null;
        try {
            DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
            factoria.setIgnoringComments(true);
            DocumentBuilder builder = factoria.newDocumentBuilder();
            doc = builder.parse(ruta);
        } catch (Exception e) {
            System.out.println("Error generando el árbol DOM: " + e.getMessage());
        }
        return doc;
    }

//EJERCICIO 2
    public void verTitulos(Document doc) {
        NodeList titulos = doc.getElementsByTagName("titulo");
        for (int i = 0; i < titulos.getLength(); i++) {
            System.out.println(titulos.item(i).getFirstChild().getNodeValue());
        }
    }

//Ejercicio 3
    public void verPeliculas(Document doc) {
        NodeList peliculas, datos, director;
        Node raiz, pelicula, directorNombre = null, directorApellido = null, titulo, genero;
        NamedNodeMap atributos;
        raiz = doc.getFirstChild();
        peliculas = raiz.getChildNodes();
        for (int i = 0; i < peliculas.getLength(); i++) {
            if (peliculas.item(i).getNodeName().equals("pelicula")) {
                pelicula = peliculas.item(i);
                datos = pelicula.getChildNodes();
                System.out.print("Titulo: ");
                for (int j = 0; j < datos.getLength(); j++) {
                    if (datos.item(j).getNodeName().equals("titulo")) {
                        titulo = datos.item(j);
                        System.out.println(titulo.getFirstChild().getNodeValue());
                    }
                    if (datos.item(j).getNodeName().equals("director")) {
                        director = datos.item(j).getChildNodes();
                        for (int h = 0; h < director.getLength(); h++) {
                            if (director.item(h).getNodeName().equals("nombre")) {
                                directorNombre = director.item(h);
                            }
                            if (director.item(h).getNodeName().equals("apellido")) {
                                directorApellido = director.item(h);
                            }
                        }
                        System.out.println("Director: " + directorNombre.getFirstChild().getNodeValue() + " " + directorApellido.getFirstChild().getNodeValue());
                    }
                }
                atributos = pelicula.getAttributes();
                for (int j = 0; j < atributos.getLength(); j++) {
                    if (atributos.item(j).getNodeName().equals("genero")) {
                        genero = atributos.item(j);
                        System.out.println("Genero: " + genero.getFirstChild().getNodeValue());
                    }
                }
            }
        }
    }

    //Ejercicio 4
    public void verTodoTabulado(Document doc) {
        Node raiz = doc.getFirstChild();
        NodeList peliculas = raiz.getChildNodes();
    }

    //Ejercicio 5
    public void masNDirectores(Document doc, int n) {
        Node pelicula, raiz = doc.getFirstChild(), titulo = null;
        int cont = 0;
        NodeList datos, peliculas = raiz.getChildNodes();
        for (int i = 0; i < peliculas.getLength(); i++) {
            cont = 0;

            if (peliculas.item(i).getNodeName().equals("pelicula")) {
                pelicula = peliculas.item(i);
                datos = pelicula.getChildNodes();
                for (int j = 0; j < datos.getLength(); j++) {
                    if (datos.item(j).getNodeName().equals("titulo")) {
                        titulo = datos.item(j);
                    }
                    if (datos.item(j).getNodeName().equals("director")) {
                        cont++;
                    }
                }
                if (cont > n) {
                    System.out.println("Titulo: " + titulo.getFirstChild().getNodeValue());
                }
            }
        }
    }

    //Ejercicio 6
    public void numGeneros(Document doc) {
        HashMap<Integer, String> generos = new HashMap();
        String genero;
        NodeList peliculas = doc.getElementsByTagName("pelicula");
        for (int i = 0; i < peliculas.getLength(); i++) {
            genero = peliculas.item(i).getAttributes().getNamedItem("genero").getNodeValue();
            if (!generos.containsValue(genero)) {
                generos.put(i, genero);
            }
        }
        System.out.println("Hay " + generos.size() + " Generos");
    }

    //Ejercicio 7
    public void nuevoAtributo(Document doc, String atributo, String titulo) {
        NodeList datos, peliculas = doc.getElementsByTagName("pelicula");
        Node pelicula;
        for(int i=0;i<peliculas.getLength();i++){
            pelicula=peliculas.item(i);
            datos=pelicula.getChildNodes();
            for (int j = 0; j < datos.getLength(); j++) {
                    if (datos.item(j).getNodeName().equals("titulo")) {
                        if(datos.item(j).getNodeValue().equals(titulo)){
                            pelicula.setAttribute("atributo", atributo);
                        }
                    }
                 
                }
        }
                

    }

    public void eliminarAtributo(Document doc, String atributo) {

    }
}
