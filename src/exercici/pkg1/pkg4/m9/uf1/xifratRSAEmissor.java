/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercici.pkg1.pkg4.m9.uf1;


import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;


public class xifratRSAEmissor {
    private byte [] missatgeEncriptat;
    
    public void xifraDadesEmissor(String missatge_text, PublicKey pub) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, UnsupportedEncodingException{
        byte [] data = missatge_text.getBytes("UTF-8");
        
        Cipher cifrador = Cipher.getInstance("RSA/ECB/PKCS1Padding", "SunJCE");
        cifrador.init(Cipher.ENCRYPT_MODE, pub);
        missatgeEncriptat = cifrador.doFinal(data);
    }
    
    public byte[]  getMissatgeXifrat(){
        return missatgeEncriptat;
    }
    
}
