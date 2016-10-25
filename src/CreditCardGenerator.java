import java.util.Arrays;

/**
 * Created by user on 22.08.2014.
 */
public class CreditCardGenerator {
    private static int[] cardArr;
    private static String prefix = "4539";
    private static int cardLength = 16;

    public static String getCreditCardNumber() {
        int afterPrefix = cardLength-prefix.length();
        String cardNumb;
        do {
            cardNumb = prefix;
            cardArr = new int[cardLength-1];
            for (int i = 0; i < afterPrefix-1; i++) {
                cardNumb +=""+ (int) (Math.random() * 10);
            }
            for (int i = cardArr.length-1; i >= 0; i--){
                cardArr[i] = Character.getNumericValue(cardNumb.charAt(cardArr.length-i-1));
            }
            int sum = 0;
            int pos = 0;

            while (pos < cardLength - 1) {

                int odd = cardArr[pos] * 2;
                if (odd > 9) {
                    odd -= 9;
                }

                sum += odd;

                if (pos != (cardLength - 2)) {
                    sum += cardArr[pos + 1];
                }
                pos += 2;
            }

            int checkDigit = new Double(((Math.floor(sum / 10) + 1) * 10 - sum) % 10).intValue();
            cardNumb += checkDigit;
        } while (checkCard(cardNumb));
        return cardNumb;
    }
    private static boolean checkCard(String cardNumb) {
        int[] checkCard = new int[cardLength];
        for (int i = 0; i < checkCard.length; i++){
            checkCard[i] = Character.getNumericValue(cardNumb.charAt(i));
        }
        int[] doubleArr = new int[16];
        int sumArr = 0;
        int multiArr = 0;
        for(int i = 0; i < doubleArr.length-1; i++) {
            if(i%2==0) {
                if(checkCard[i]*2 >= 10) {
                    doubleArr[i] =  (checkCard[i]*2) - 9;
                }
                else {
                    doubleArr[i] = checkCard[i]*2;
                }
                sumArr += doubleArr[i];
            }

        }
        multiArr = (sumArr*9)%10;
        if (multiArr == checkCard[checkCard.length-1]) {
            return false;
        } else return true;

    }
    static String strrev(String str) {
        if (str == null)
            return "";
        String revstr = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            revstr += str.charAt(i);
        }

        return revstr;
    }
}
