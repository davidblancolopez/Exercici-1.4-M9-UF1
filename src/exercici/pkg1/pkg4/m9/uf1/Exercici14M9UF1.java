
package exercici.pkg1.pkg4.m9.uf1;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;


public class Exercici14M9UF1 {


    public static void main(String[] args) throws NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, NoSuchProviderException, NoSuchPaddingException, UnsupportedEncodingException {
        xifratRSAEmissor xRSAe = new xifratRSAEmissor();
        xifratRSAReceptor xRSAr = new xifratRSAReceptor();
        
        xRSAr.generaClaus();
        
        xRSAe.xifraDadesEmissor( "Mensaje", xRSAr.getClauPublica());
        
        System.out.println(xRSAr.getClauPublica());
        
        xRSAr.desxifraDadesReceptor(xRSAe.getMissatgeXifrat());
        System.out.println(new String(xRSAe.getMissatgeXifrat()));
        System.out.println(new String (xRSAr.getTextDesxifrat()));
    }
    
}
