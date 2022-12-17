package sakine.ayoub;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.SchemaOutputResolver;
import sakine.ayoub.entities.Banque;

import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class TestGenerateXmlSchema {

    public static void main(String[] args) throws JAXBException, IOException {
        JAXBContext jaxbContext=JAXBContext.newInstance(Banque.class);

        jaxbContext.generateSchema(new SchemaOutputResolver() {
            @Override
            public Result createOutput(String s, String s1) throws IOException {
                File file=new File("comptes.xsd");
                StreamResult streamResult=new StreamResult(file);
                return streamResult;
            }
        });
    }
}
