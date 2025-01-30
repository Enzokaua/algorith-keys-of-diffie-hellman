import javax.crypto.KeyAgreement;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.util.Base64;

public class App {

    private KeyPair keyPair;
    private KeyAgreement keyAgreement;


    public void init() throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DH");
        keyPairGen.initialize(2048);
        keyPair = keyPairGen.generateKeyPair();
        keyAgreement = KeyAgreement.getInstance("DH");
        keyAgreement.init(keyPair.getPrivate());
    }
    public PublicKey getPublicKey() {
        return keyPair.getPublic();
    }

    public byte[] computeSharedSecret(PublicKey receivedPublicKey) throws Exception {
        keyAgreement.doPhase(receivedPublicKey, true);
        return keyAgreement.generateSecret();
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Algoritmo de Diffie-Hellman, modelo para troca de chaves secretas de forma segura ");
        App usuarioProdutor = new App();
        usuarioProdutor.init();
        App usuarioConsumidor = new App();
        usuarioConsumidor.init();

        String chaveSecretaProdutor = Base64.getEncoder().encodeToString(usuarioProdutor.computeSharedSecret(usuarioConsumidor.getPublicKey()));
        String chaveSecretaConsumidor = Base64.getEncoder().encodeToString(usuarioConsumidor.computeSharedSecret( usuarioProdutor.getPublicKey()));

        System.out.println("\nAgora vamos verificar, o usuário 1 que chamaremos de produtor, tem a seguinte chave: \n" + chaveSecretaProdutor);
        System.out.println("\nO usuário 2, consumidor, tem a seguinte chave:\n " + chaveSecretaConsumidor);
        System.out.println("\nOs segredos deles são iguais? " + chaveSecretaProdutor.equals(chaveSecretaConsumidor));

    }
}
