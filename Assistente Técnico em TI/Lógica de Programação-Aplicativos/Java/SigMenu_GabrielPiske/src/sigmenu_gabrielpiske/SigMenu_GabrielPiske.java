/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sigmenu_gabrielpiske;

import telas.*;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author gabriel_piske
 */
public class SigMenu_GabrielPiske {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Selecionar o Look & Feel desejado
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (UnsupportedLookAndFeelException exc) {
            exc.printStackTrace();
        } catch (ClassNotFoundException exc) {
            exc.printStackTrace();
        } catch (InstantiationException exc) {
            exc.printStackTrace();
        } catch (IllegalAccessException exc) {
            exc.printStackTrace();
        }

        // Listar os Look & Feel
        for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            System.out.println(info.getName());
        }

        //FormMain fMain = new FormMain();
        FormLogin fLogin = new FormLogin();
        ////PaneImgFundo FormLogin = new PaneImgFundo("back.jpg");
        ///fLogin.add(FormLogin);
        fLogin.setLocationRelativeTo(fLogin);
        fLogin.setVisible(true);
    }

}
