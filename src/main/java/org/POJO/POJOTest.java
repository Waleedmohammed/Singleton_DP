package org.POJO;


import org.apache.juneau.html.HtmlSerializer;
import org.apache.juneau.json.JsonParser;
import org.apache.juneau.json.JsonSerializer;
import org.apache.juneau.xml.XmlSerializer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class POJOTest {

    public static void main(String[] args) {

        // Serialization

        // pojo to json
        JsonSerializer defaultReadable = JsonSerializer.DEFAULT_READABLE;
        String cities[] = {"Munich", "Berlin", "Frankfurt"};
        POJO pojo = new POJO("Waleed", 36, "QA", cities);
        String json = defaultReadable.serialize(pojo);
        System.out.println(json);

        // pojo to xml
        XmlSerializer serializer = XmlSerializer.DEFAULT_SQ_READABLE;
        String xmlRequest = serializer.serialize(pojo);
        System.out.println(xmlRequest);

        // pojo to HTML
        HtmlSerializer htmlSerializer = HtmlSerializer.DEFAULT_SQ_READABLE;
        String xmlhtmlRequest = htmlSerializer.serialize(pojo);
        System.out.println(xmlhtmlRequest);


        // Deserialization

        // JSON to pojo
        JsonParser parser = JsonParser.DEFAULT;

        String jsonBody = "{\n" +
                "\t\"age\": 36,\n" +
                "\t\"cities\": [\n" +
                "\t\t\"Munich\",\n" +
                "\t\t\"Berlin\",\n" +
                "\t\t\"Frankfurt\"\n" +
                "\t],\n" +
                "\t\"job\": \"QA\",\n" +
                "\t\"name\": \"Waleed\"\n" +
                "}";

        POJO pojo1 = parser.parse(jsonBody, POJO.class);
        System.out.println("Name is : "+ pojo1.getName());
        System.out.println("age is : "+ pojo1.getAge());

        List<String> citieslist = Arrays.stream(pojo1.getCities()).collect(Collectors.toList());

        System.out.println("cities is : "+ citieslist);




    }

}
