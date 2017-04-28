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
    
    public void generaClaus() throws NoSuchAlgorithmException{
        KeyPairGenerator KeyGenerator = KeyPairGenerator.getInstance("RSA");
        KeyGenerator.initialize(2048);
        keyPair = KeyGenerator.genKeyPair();
    }
    
    public void desxifraDadesReceptor(byte[] data) throws NoSuchProviderException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        Cipher descifrador = Cipher.getInstance("RSA/ECB/PKCS1Padding", "SunJCE");
        descifrador.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
        buffer = descifrador.doFinal(data);
    }

    public PublicKey getClauPublica(){
        PublicKey key = null;
        
        key = keyPair.getPublic();
        
        return key;
    }
    
    public byte[] getTextDesxifrat(){
        return buffer;
    }

}
