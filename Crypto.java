import java.io.*;
/*
# Cryptography is free software: you can redistribute it and/or modify it under the terms of the
# GNU General Public License as published by the Free Software Foundation, version 3.
*/
/**
 * @author Andrés Guillermo Bonilla Olarte
 */
public class Crypto
{
    public static String convertVocals(String original)
    {
        String modified = original;
        modified = modified.replace("a","4"); //replaces "a" to "4"
        modified = modified.replace("e","3"); //replaces "e" to "3"
        modified = modified.replace("i","1"); //replaces "i" to "1"
        modified = modified.replace("o","0"); //replaces "o" to "0"
        modified = modified.replace("u","9"); //replaces "u" to "9"
        
        return modified;
    }
    
    /**
     * 
     * @param real
     * @return
     */
    
    public static String convertVowels(String real)
    {
        String modified = real;
        modified = modified.replace("4","a"); //replaces "4" to "a"
        modified = modified.replace("3","e"); //replaces "3" to "e"
        modified = modified.replace("1","i"); //replaces "1" to "i"
        modified = modified.replace("0","o"); //replaces "0" to "o"
        modified = modified.replace("9","u"); //replaces "9" to "u"

        return modified;
    }   
    /**
     *     
     * @param texto
     * @param codigo
     * @return
     */
    
    public static String cifrado(String texto, int codigo) {
        StringBuilder cifrado = new StringBuilder();
        codigo = codigo % 26;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                if ((texto.charAt(i) + codigo) > 'z') {
                    cifrado.append((char) (texto.charAt(i) + codigo - 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) + codigo));
                }
            } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                if ((texto.charAt(i) + codigo) > 'Z') {
                    cifrado.append((char) (texto.charAt(i) + codigo - 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) + codigo));
                }
            }
        }
        return cifrado.toString();
    }
    
    /**
     * 
     * @param args
     * @return 
     */

    public static void main(String[] args) 
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));       //creating the Reading Buffer
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));     //creating the Writing Buffer
        try
        {     	
        	String Cadena = br.readLine();  //reading the string
        	String cadena = Cadena.toLowerCase();  //converting all the string to lower characters
        	String c4d3n4 = convertVocals(cadena); //convert all vocals into numbers, as the function

        	char encrypt[] = c4d3n4.toCharArray();
      		char decrypt[] = cadena.toCharArray();
      		
      		bw.write("Código de encriptación: " + "\n");  
      		int codigo = Integer.parseInt(br.readLine());
      		bw.write(codigo + "\n");              //showing the encrypt code
      		char code = (char) codigo;
   			bw.newLine();
   			
        	bw.write("Texto original: " + "\n");  
        	bw.write(cadena + "\n"); //showing the original string
   			bw.newLine();
   			
        	bw.write("Texto con vocales convertidas: " + "\n");
        	bw.write(c4d3n4 + "\n"); //showing the original string with replaced vowels
        	String splitted []= c4d3n4.split(" ");     //splitting the array 
   			bw.newLine();
   			
        	  //creating the split substring
          
        	bw.write("Texto encriptado:"+"\n"); //showing the new string
        	
        	 for (int i = 0; i < encrypt.length; i++)
       		 {
       			 encrypt[i] = (char)(encrypt[i] + (char) code); //encrypting the string[]
       		 }

       			String encrypted = String.valueOf(encrypt);
       			String spl []= encrypted.split("\\s+");
       		    
        	 for (int a = 0; a < spl.length; a++) 
        	 {
        		 
        		 bw.write(spl[a]+" "+a);    //output: array + index
        		 bw.newLine();
        	 }
    			bw.newLine();  		 
       		 bw.write("Texto desencriptado:" + "\n");
       		 
       		 for (int j = 0; j < decrypt.length; j++)
       		 {
       			 decrypt[j] = (char)(encrypt[j] - (char) code); //decrypting the encrypted string[]
       		 }
       		 String decrypted = String.valueOf(decrypt);
       		 String desencriptado = convertVowels(decrypted);   //reconverting numbers into vocals
  			 bw.write(desencriptado);             //output: decrypted code
       		 bw.newLine();
      
       		 bw.flush(); //releases information
        }
        catch (Exception ex)
        {
        	ex.printStackTrace();
        }
    }
}
