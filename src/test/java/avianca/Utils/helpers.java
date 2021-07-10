package avianca.Utils;

import net.serenitybdd.core.pages.WebElementFacade;

public class helpers {

    public String formatDate(String date){
        String formatedDate="";
        String[] partes = date.split("\\"+".");
        StringBuilder sb = new StringBuilder();
        formatedDate = (sb.append(partes[0]).append(".").append(partes[1])).toString();
        System.out.println(formatedDate);
        return formatedDate;
    }
    public void clicksPass(int veces, WebElementFacade boton){
        for(int i = 0 ; i < veces;i++){
            boton.click();
        }
    }
    public void esperaSelenium(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
