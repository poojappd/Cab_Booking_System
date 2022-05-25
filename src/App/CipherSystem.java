package App;

public class CipherSystem {
    public static char[] encrypt(String s) {
        //return char[] array of encrypted password
        char[] temp = s.toCharArray();
        //return temp;
        for (int i = 0; i < temp.length; i++) {
            temp[i] = (char)((temp[i]+1)*10);
        }
        return temp;
    }
    public static char[] decrypt(char [] s){

        //return temp;
        for (int i = 0; i < s.length; i++) {
            s[i] = (char)((s[i]/10)-1);
        }

        return s;
    }
}
