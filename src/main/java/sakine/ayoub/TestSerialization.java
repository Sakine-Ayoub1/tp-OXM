package sakine.ayoub;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import sakine.ayoub.entities.Banque;
import sakine.ayoub.entities.Compte;
import sakine.ayoub.enums.TypeCompte;

import java.io.File;
import java.util.Date;

public class TestSerialization {

    public static void main(String[] args) throws JAXBException {

        JAXBContext jaxbContext=JAXBContext.newInstance(Banque.class);
        Banque banque=new Banque();
        banque.comptes.add(new Compte(1,7340,new Date(), TypeCompte.COURANT));
        banque.comptes.add(new Compte(2,10000,new Date(), TypeCompte.EPARGNE));
        banque.comptes.add(new Compte(3,9500,new Date(), TypeCompte.COURANT));

        Marshaller marshaller=jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.marshal(banque,new File("comptes.xml"));
    }
}
