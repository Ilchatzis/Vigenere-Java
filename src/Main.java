import java.util.Scanner;

public class Main {
    public static void main (String Args[]){
        Scanner input = new Scanner(System.in);
        char[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        String plaintext = "";
        boolean funcFlag = false;
        String keyword = "";
        StringBuilder stringBuilder = new StringBuilder();
        String repeatedKeyword = "";
        System.out.print("~~~~~~~~ VIGENERE ~~~~~~~~");
        System.out.println();
        String func = "";
        do{
            System.out.println();
            System.out.println("Type 'encrypt' or 'decrypt' to declare function.");
            System.out.println();
            func = input.nextLine();
            if (func.equals("encrypt")){
                funcFlag = true;
            }else if (func.equals("decrypt")){
                funcFlag = false;
            }
        }while (!func.equals("encrypt") && !func.equals("decrypt"));
        do {
            System.out.println();
            System.out.print("Enter text (latin alphabet): ");
            plaintext = input.nextLine();
        }while (CheckKeyword(plaintext));
        char [] arraytext = plaintext.toUpperCase().toCharArray();
        do {
            System.out.println();
            System.out.print("Enter keyword : ");
            keyword = input.nextLine();
        }while(CheckKeyword(keyword));
        for (int i=0;i<plaintext.length();i++){
                stringBuilder.append(keyword.charAt(i%keyword.length()));
        }
        repeatedKeyword = stringBuilder.toString();
        char [] arraykey = repeatedKeyword.toUpperCase().toCharArray();
        int [] gentextArray = new int[arraykey.length];
        if (funcFlag==false){
            for (int i=0;i<plaintext.length();i++){
                gentextArray[i] = (arraytext[i]-arraykey[i]+26)%26;
            }
        }else{
            for (int i=0;i<plaintext.length();i++){
                gentextArray[i] = (arraytext[i]+arraykey[i]-2*65)%26;
            }
        }
        System.out.println();
        System.out.print("Generated text: ");
        for (int i=0;i<gentextArray.length;i++){
            System.out.print(letters[gentextArray[i]]);
        }
        System.out.println();
    }

    public static boolean CheckKeyword(String keyword){
        boolean flag = false;
        for (int i=0;i<keyword.length();i++){
            if (!((keyword.charAt(i) >= 'A' && keyword.charAt(i) <= 'Z') || (keyword.charAt(i) >= 'a' && keyword.charAt(i) <= 'z'))){
                flag = true;
            }
        }
        return flag;
    }
}
