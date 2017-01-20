import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<String> phoneNumbers = new ArrayList<String>();
    static boolean paid = true;
    static boolean trial = false;
    static boolean annual = false;
    static boolean month = true;
    public static boolean firefox = false;
    public static boolean remote = false;
    public static int prod = 0; // 0 - prod 1 - env
    public static String odsup = "odsup", rlz = "rlzstb", qaup = "qaup", ops ="ops", gciAqa = "gci3", att511 = "att511",
            amsup = "amsup", devft3 = "devft3", devft3ams = "devft3ams", edi = "ediatt", mob ="devmob",
            amsup03 = "amsupp03", swtup  = "swtup";
    public static String environment = amsup;
    public static String urlToAW = "http://ai-amsup.lab.nordigy.ru:8088";
    public static String urlToAWWithPass = "http://" + "alex" + ":" + "123123" + "@" + "ai-amsup.lab.nordigy.ru:8088";
   /* private int numberOfEmployers = 1;
    private int typeOfPlane = 2; // 1,2,3
    private int billingCycle = 0; //0 - annual,1*/

    public static void main(String[] args) throws Exception {
              // goThread(new ATT(trial, 4, 1, month));
               //goThread(new ATT(paid, 2, 2, month));
       //  goThread(new BritishTel(paid, 2, 7747, month));
        goThread(new GBOffice(trial,2, 2, month));

               //  goThread(new CanadaFax(trial,2,1,month));
                //goThread(new CanadaMobile(paid,2,1,month));
           //  goThread(new CanadaOffice(paid,2,2,month));

              // goThread(new USFax(trial,2,1,month));
            //goThread(new USMobile(paid,2,2,month));
            //  goThread(new USOffice(paid,3,1,month));





     /*

        CanadaOffice canadaOfficeAlik = new CanadaOffice(true,2,1,1,"alexey.kudlaenko");


            //Change name and card
             /*officeUs.changeCreditCard("MasterCard","5454545454545454","123");
              officeUs.changeName("MasterCard", "5454545454545454");
              officeUs.changeCreditCard("Visa","4444424444444440" ,"123");*/
            //officeUs.changeCreditCard("Visa",CreditCardGenerator.getCreditCardNumber(),"123");
            //officeUs.changeName("Testyr","Testyr");
            //System.out.println(CreditCardGenerator.getCreditCardNumber());
            // greatBrit.changeName("Tester","Testor");
            // greatBrit.changeCreditCard("Visa","4444444444444448" ,"123");

    }
    private static void goThread(final Account acc) {
        new Thread(new Runnable() {@Override public void run() {
            try {
               // acc.changeName("ASergei","JanuarySecond");
                //acc.changeCreditCard("Visa",CreditCardGenerator.getCreditCardNumber(),"123");
               //  acc.changeCreditCard("Master Card",CreditCardGenerator.getCreditCardNumber(),"123");
               // acc.countryListBillingValue = "74";
               //  acc.vatValue ="vatushka!";
               // acc.vatValue ="";//  04147552
              // acc.changeCreditCard("American Express","373705305958152","1234");
               //  acc.changeCreditCard("Master Card","5171043822021533","555"); //
              // acc.changeCreditCard("Master Card","5548181737210902","123");

                 // acc.changeCreditCardCountry("74","04147552");//04147552  vatushka!
                  acc.create();



            }
            catch (MalformedURLException | InterruptedException e) {e.printStackTrace();}
            }}).start();
    }
}

