package obj;

import Controllers.Client_Menu_Controler;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client_Validation {





    public static boolean txtfieldNotEmpty( TextField i){
       boolean r=false;
       if (i.getText()!=null && !i.getText().isEmpty()){

       r=true;
       }
      return r;
    }

    public static boolean txtfieldNotEmpty(TextField i, Label l){
        boolean r=true;
        String c=null;
        String err_mess_1="*Required Field";

        if (!txtfieldNotEmpty(i)) //if txtfield is empty
             {
            r=false;
            c=err_mess_1;
        }
        //
        l.setText(c);
        return r;
    }



    public static boolean isEmailValid( TextField email,Label l){
        String regex="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";
        Pattern emailPat= Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher matcher=emailPat.matcher(email.getText());
        String err_mess_1="*Email is not valid";
        String c=null;

        if (email.getText().trim().isEmpty()||(matcher.find())){
           return true;

        }
        else if (!matcher.find()){
            c=err_mess_1;
            return false;
        }
    else return false;

    }


  public static boolean getChoiceBox (ChoiceBox<String> ch, Label l) {
      boolean r = true;
      String choice = null;
      choice = ch.getValue();
      String err_mess = "Reference not selected";
      String c = null;
      if (choice == null) {
          c = err_mess;
          l.setText(c);
          r = false;
          System.out.println(choice);
          System.out.println(r);
      } else {
          System.out.println(choice);
          l.setText("");
          System.out.println(r);
      }
      return r;
/*
     public static void maskFormater( Textfield in){
          MaskFormatter mf1 = null;
          try {
              mf1 = new MaskFormatter("###-###-###");
          } catch (ParseException e) {
              e.printStackTrace();
          }
          mf1.setPlaceholderCharacter('_');
      JFormattedTextField ftf1 = new JFormattedTextField(mf1);
      content.add(ftf1);
      }
  }
*/


  }
}
