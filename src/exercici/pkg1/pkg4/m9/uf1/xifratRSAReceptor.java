/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercici.pkg1.pkg4.m9.uf1;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;


public class xifratRSAReceptor {
    
    private KeyPair keyPair;
    private byte[] buffer;
    
    /**
     * Metodo que genera las claves que se utilizaran para cifrar y descifrar los mensajes.
     * Crea un KeyPairGenerator, lo inicializa y lo mete en la variable keyPair.
     * 
     * @throws NoSuchAlgorithmException 
     */
    public void generaClaus() throws NoSuchAlgorithmException{
        KeyPairGenerator KeyGenerator = KeyPairGenerator.getInstance("RSA");
        KeyGenerator.initialize(2048);
        keyPair = KeyGenerator.genKeyPair();
    }
    
    /**
     * Metodo que sirve para descifrar los mensajes.
     * Le llega el array con el mensaje cifrado, crea, inicializa y usa un cifrador
     * para descifrar. El mensaje resultante despues de descifrar lo guarda en el array llamado buffer.
     * 
     * @param data
     * @throws NoSuchProviderException
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException 
     */
    public void desxifraDadesReceptor(byte[] data) throws NoSuchProviderException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        Cipher descifrador = Cipher.getInstance("RSA/ECB/PKCS1Padding", "SunJCE");
        descifrador.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
        buffer = descifrador.doFinal(data);
    }

    /**
     * Metodo que devueve las claves publicas.
     * @return 
     */
    public PublicKey getClauPublica(){
        
        return keyPair.getPublic();
    }
    
    /**
     * Metodo que retorna el texto descifrado que se ha guardado en el array buffer.
     * @return 
     */
    public byte[] getTextDesxifrat(){
        return buffer;
    }

}
