/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication14;

import java.util.ArrayList;

/**
 *
 * @author لل
 */
public class JavaApplication14 {

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



    
  /////////////////////////////////TABLE//////////////
     //Initial Permutation Table 
   private static final byte[] IP = { 
        58, 50, 42, 34, 26, 18, 10, 2,
        60, 52, 44, 36, 28, 20, 12, 4,
        62, 54, 46, 38, 30, 22, 14, 6,
        64, 56, 48, 40, 32, 24, 16, 8,
        57, 49, 41, 33, 25, 17, 9,  1,
        59, 51, 43, 35, 27, 19, 11, 3,
        61, 53, 45, 37, 29, 21, 13, 5,
        63, 55, 47, 39, 31, 23, 15, 7
    };
   /////////final permutation/////////////
    private static final byte[] FP = {
        40, 8, 48, 16, 56, 24, 64, 32,
        39, 7, 47, 15, 55, 23, 63, 31,
        38, 6, 46, 14, 54, 22, 62, 30,
        37, 5, 45, 13, 53, 21, 61, 29,
        36, 4, 44, 12, 52, 20, 60, 28,
        35, 3, 43, 11, 51, 19, 59, 27,
        34, 2, 42, 10, 50, 18, 58, 26,
        33, 1, 41, 9, 49, 17, 57, 25
    };
/////////////////expansionDBOX/////////////////////
      private static final byte[] E = {
        32, 1,  2,  3,  4,  5,
        4,  5,  6,  7,  8,  9,
        8,  9,  10, 11, 12, 13,
        12, 13, 14, 15, 16, 17,
        16, 17, 18, 19, 20, 21,
        20, 21, 22, 23, 24, 25,
        24, 25, 26, 27, 28, 29,
        28, 29, 30, 31, 32, 1
    };
      /////////////////////////////////////////SBOX//////////////////////////
       private static final byte[][] S = { {
        14, 4,  13, 1,  2,  15, 11, 8,  3,  10, 6,  12, 5,  9,  0,  7,
        0,  15, 7,  4,  14, 2,  13, 1,  10, 6,  12, 11, 9,  5,  3,  8,
        4,  1,  14, 8,  13, 6,  2,  11, 15, 12, 9,  7,  3,  10, 5,  0,
        15, 12, 8,  2,  4,  9,  1,  7,  5,  11, 3,  14, 10, 0,  6,  13
    }, {
        15, 1,  8,  14, 6,  11, 3,  4,  9,  7,  2,  13, 12, 0,  5,  10,
        3,  13, 4,  7,  15, 2,  8,  14, 12, 0,  1,  10, 6,  9,  11, 5,
        0,  14, 7,  11, 10, 4,  13, 1,  5,  8,  12, 6,  9,  3,  2,  15,
        13, 8,  10, 1,  3,  15, 4,  2,  11, 6,  7,  12, 0,  5,  14, 9
    }, {
        10, 0,  9,  14, 6,  3,  15, 5,  1,  13, 12, 7,  11, 4,  2,  8,
        13, 7,  0,  9,  3,  4,  6,  10, 2,  8,  5,  14, 12, 11, 15, 1,
        13, 6,  4,  9,  8,  15, 3,  0,  11, 1,  2,  12, 5,  10, 14, 7,
        1,  10, 13, 0,  6,  9,  8,  7,  4,  15, 14, 3,  11, 5,  2,  12
    }, {
        7,  13, 14, 3,  0,  6,  9,  10, 1,  2,  8,  5,  11, 12, 4,  15,
        13, 8,  11, 5,  6,  15, 0,  3,  4,  7,  2,  12, 1,  10, 14, 9,
        10, 6,  9,  0,  12, 11, 7,  13, 15, 1,  3,  14, 5,  2,  8,  4,
        3,  15, 0,  6,  10, 1,  13, 8,  9,  4,  5,  11, 12, 7,  2,  14
    }, {
        2,  12, 4,  1,  7,  10, 11, 6,  8,  5,  3,  15, 13, 0,  14, 9,
        14, 11, 2,  12, 4,  7,  13, 1,  5,  0,  15, 10, 3,  9,  8,  6,
        4,  2,  1,  11, 10, 13, 7,  8,  15, 9,  12, 5,  6,  3,  0,  14,
        11, 8,  12, 7,  1,  14, 2,  13, 6,  15, 0,  9,  10, 4,  5,  3
    }, {
        12, 1,  10, 15, 9,  2,  6,  8,  0,  13, 3,  4,  14, 7,  5,  11,
        10, 15, 4,  2,  7,  12, 9,  5,  6,  1,  13, 14, 0,  11, 3,  8,
        9,  14, 15, 5,  2,  8,  12, 3,  7,  0,  4,  10, 1,  13, 11, 6,
        4,  3,  2,  12, 9,  5,  15, 10, 11, 14, 1,  7,  6,  0,  8,  13
    }, {
        4,  11, 2,  14, 15, 0,  8,  13, 3,  12, 9,  7,  5,  10, 6,  1,
        13, 0,  11, 7,  4,  9,  1,  10, 14, 3,  5,  12, 2,  15, 8,  6,
        1,  4,  11, 13, 12, 3,  7,  14, 10, 15, 6,  8,  0,  5,  9,  2,
        6,  11, 13, 8,  1,  4,  10, 7,  9,  5,  0,  15, 14, 2,  3,  12
    }, {
        13, 2,  8,  4,  6,  15, 11, 1,  10, 9,  3,  14, 5,  0,  12, 7,
        1,  15, 13, 8,  10, 3,  7,  4,  12, 5,  6,  11, 0,  14, 9,  2,
        7,  11, 4,  1,  9,  12, 14, 2,  0,  6,  10, 13, 15, 3,  5,  8,
        2,  1,  14, 7,  4,  10, 8,  13, 15, 12, 9,  0,  3,  5,  6,  11
    } };//////////////////PERMUTION FOR EACH ROUND////////////////
        private static final byte[] P = {
        16, 7,  20, 21,
        29, 12, 28, 17,
        1,  15, 23, 26,
        5,  18, 31, 10,
        2,  8,  24, 14,
        32, 27, 3,  9,
        19, 13, 30, 6,
        22, 11, 4,  25
    };
        ///////////////FROM 64 TO 56////////////
      
    private static final byte[] PC1 = {
        57, 49, 41, 33, 25, 17, 9,
        1,  58, 50, 42, 34, 26, 18,
        10, 2,  59, 51, 43, 35, 27,
        19, 11, 3,  60, 52, 44, 36,
        63, 55, 47, 39, 31, 23, 15,
        7,  62, 54, 46, 38, 30, 22,
        14, 6,  61, 53, 45, 37, 29,
        21, 13, 5,  28, 20, 12, 4
    };
    ///////////// FROM 56 INT0 48/////////////
    private static final byte[] PC2 = {
        14, 17, 11, 24, 1,  5,
        3,  28, 15, 6,  21, 10,
        23, 19, 12, 4,  26, 8,
        16, 7,  27, 20, 13, 2,
        41, 52, 31, 37, 47, 55,
        30, 40, 51, 45, 33, 48,
        44, 49, 39, 56, 34, 53,
        46, 42, 50, 36, 29, 32
    }; /////////////////ROTATION///
     private static final byte[] rotations = {
        1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1
    };
     ////////////////////Declaration///////////////////////////////////
    ArrayList<String>subkey=new ArrayList();
    StringBuilder key0=new StringBuilder();
   String prevLeft;
    String prevRight;
    //////////////////////permute//////////////////
    private StringBuilder permute(StringBuilder recevied,byte []permutationtable){
        StringBuilder bulider=new StringBuilder();
        for(byte index:permutationtable){
            bulider.append(recevied.charAt(index-1));
        }return bulider;}
    public String shiftSubkey(String subkey,int shiftTime){
    StringBuilder sub=new StringBuilder(subkey);
    for(int i=0;i<shiftTime;i++)
    {
    char x=sub.charAt(0);
    sub.deleteCharAt(0);
    sub.append(x);
    }
    return sub.toString();
    } private void generatorKey(StringBuilder k){
  this.key0=new StringBuilder(k);
   key0= permute(key0, PC1);
 prevLeft=k.substring(0, key0.length()/2);
  prevRight=k.substring(key0.length()/2);
  for(int i=0;i<16;i++){
    String newLeft= shiftSubkey(prevLeft,rotations[i]);
    String newRight= shiftSubkey(prevRight,rotations[i]);
    StringBuilder newsubkey=new StringBuilder(newLeft+newRight);
    newsubkey=permute(newsubkey, PC2);
    subkey.add(newsubkey.toString());
    prevLeft=newLeft;
    prevRight=newRight;
  }
    }  public void sbox(StringBuilder xorRESULTwithkey){
     StringBuilder s=new StringBuilder();
    for(int i=0;i<48;i=i+6){
     String sixBit=xorRESULTwithkey.substring(i, i+5);
         char[] bits = null;
        bits[i]=sixBit.charAt(i);
         
         bits[i+6]=sixBit.charAt(i+6);
         String row=new   String(bits);
       
        int twoBits=Integer.parseInt(row,2);
         int fourBit=(Integer.parseInt(sixBit.substring(i+1, i+5), 2));
         int x=twoBits*16+fourBit;
         int value=S[i/6][x];
        String y=Integer.toBinaryString(value);
         while (y.length()<4) {
             y="0"+y; 
         }
             s.append(y);
    }}StringBuilder xor(StringBuilder one,String two){
   StringBuilder builder2=new StringBuilder();
   for(int i=0;i<one.length();i++){
   int xor1=one.charAt(i) ^ two.charAt(i);
   builder2.append(xor1 +" ");}
   return  builder2;
}
    public StringBuilder finalexecution(StringBuilder  outputright,String key2){
    StringBuilder assleft,assright1,outputleft;
    key0=new StringBuilder(key2);
   assleft=new StringBuilder(outputright.substring(0, key0.length()/2));
  assright1=new StringBuilder(outputright.substring( key0.length()/2));
  outputleft=assright1;
  StringBuilder output=new StringBuilder(outputleft);
  assright1=permute(assright1, E);
  assright1=xor(assright1, key2);
  sbox(assright1);
  assright1=permute(assright1,P);
  assright1=xor(assright1,assleft.toString());
  outputleft=outputleft.append(assright1);
  return output;
}public String encrpt(String message,String key3){
    StringBuilder key2=new StringBuilder(key3);
    generatorKey(key2);
    StringBuilder input= new StringBuilder(message);
    input=permute(input, IP);
    for (int i=1;i<16;i++){
   input=finalexecution(input, subkey.get(i));}
    StringBuilder finalright,finalleft;
    finalright=new StringBuilder(input.substring(0, key2.length()/2));
 finalleft=new StringBuilder(input.substring( key2.length()/2));
 input=finalright;
 input.append(finalleft);
 input=permute(input, FP);
    
 return input.toString();   
}
public String decrpt(String message,String key4){
    StringBuilder key5=new StringBuilder(key4);
    generatorKey(key5);
    StringBuilder input= new StringBuilder(message);
    input=permute(input, IP);
    for (int i=16;i>1;i--){
   input=finalexecution(input, subkey.get(i));}
    StringBuilder finalright,finalleft;
     finalright=new StringBuilder(input.substring(0, key5.length()/2));
 finalleft=new StringBuilder(input.substring( key5.length()/2));
 input=finalright;
 input.append(finalleft);
 input=permute(input, FP);
    
 return input.toString();   
}

}
