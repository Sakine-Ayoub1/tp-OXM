package sakine.ayoub;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import sakine.ayoub.entities.Banque;

import java.io.File;

public class TestDeserialization {

    public static void main(String[] args) throws JAXBException {

        JAXBContext jaxbContext=JAXBContext.newInstance(Banque.class);

        Unmarshaller unmarshaller= jaxbContext.createUnmarshaller();
        Banque banque= (Banque) unmarshaller.unmarshal(new File("comptes.xml"));

        banque.comptes.forEach(c->{
            System.out.println("*********************");
            System.out.println(c.toString());
        });
    }
}
