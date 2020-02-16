public class ProjectMethods {

    //Klasa zawierająca pomocnicze metody statycze
    public static boolean Contains(String name){
        int numberCounter = 0;
        int lettersCounter = 0;
        boolean result = false;
        for(int i=0;i<name.length();i++){
            int charNumber = (int)name.charAt(i);
            if(charNumber>=65 && charNumber<=90){
                lettersCounter++;
            }
            if(charNumber>=48 && charNumber<=57){
                numberCounter++;
            }
        }
        if(numberCounter==4 && lettersCounter==3){
            result = true;
        }
        return result;
    }

    public static boolean CompareTo(String chain1, String chain2){
        boolean status = false;
        for(int i=0;i<chain1.length();i++){
            if(chain1.charAt(i)!=chain2.charAt(i)){
                status = false;
                break;
            }else{
                status = true;
            }
        }
        return status;
    }


}
