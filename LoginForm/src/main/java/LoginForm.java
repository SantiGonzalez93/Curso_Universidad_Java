import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    private JPanel panelPrincipal;
    private JTextField usuarioTexto;
    private JPasswordField passwordTexto;
    private JButton enviarBoton;


    public  LoginForm(){
        inicializarForm();
        enviarBoton.addActionListener(e -> validar());
    }

    private void inicializarForm(){
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
    }

    private void validar(){
        //vamos a leer los valores

        String usuario = this.usuarioTexto.getText();
        String password = new String(this.passwordTexto.getPassword());

        if ("root".equals(usuario) && "admin".equals(password)){
            mostrarMensaje("Datos correctos, Bienvenido");
        }else if("root".equals(usuario)){
            mostrarMensaje("Password Incorrecto, Corregirlo");
        }else {
            mostrarMensaje("Usuario Incorrecto, Corregirlo");
        }


    }

    private void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public static void main(String[] args) {
        FlatDarculaLaf.setup();
        LoginForm loginForm = new LoginForm();
        loginForm.setVisible(true);
    }


}
