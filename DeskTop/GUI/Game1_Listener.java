package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game1_Listener  implements ActionListener {
    static Game1 game1;
    static JTextField text;

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Start Game!")){
            if(game1.reachEnd()){
                game1.End();
            }else{
                game1.goNext();
            }
        }else if(e.getActionCommand().equals("Next")){
            if(Game1.check){
                game1.goNext();
            }

        }else if(e.getActionCommand().equals("Check")){
            if(text!=null){
                String string = text.getText();
                String[] array = string.split("\\|");
                int i = 0;
                for(String s : array){
                    if(Game1.list1.contains(s)){
                        i++;
                    }
                }
                if(i==Game1.list1.size()){
                    Game1.check = true;
                }else{
                    System.out.println("The words are false, please input again");
                }
            }else{
                System.out.println("Please input words");
            }
        }
    }
}
