package exercicio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiLogin extends JFrame {
    private JTextField tfLogin;
    private JLabel lbSenha;
    private JLabel lbLogin;
    private JButton btlogar;
    private JButton btcancelar;
    private JPasswordField pfSenha;
    private static GuiLogin frame;

    private GuiLogin() {
        inicializaComponentes();
        definirEventos();
    }

    private void inicializaComponentes() {
        setTitle("Login do Sistema");
        setBounds(0,0,250,200);
        setLayout(null);
        // instancia dos objetos na tela
        tfLogin = new JTextField(5);
        pfSenha = new JPasswordField(5);
        lbSenha = new JLabel("Senha");
        lbLogin = new JLabel("Login");
        btlogar = new JButton("Logar");
        btcancelar = new JButton("Cancelar");
        // Definir o tamnho de cada objeto
        tfLogin.setBounds(100,30,120,25);
        lbLogin.setBounds(30,30,80,25);
        lbSenha.setBounds(30,75,80,25);
        pfSenha.setBounds(100,75,80,25);
        btlogar.setBounds(20,120,100,25);
        btcancelar.setBounds(125,120,100,25);
        //adicionando objetos
        add(tfLogin);
        add(lbLogin);
        add(lbSenha);
        add(pfSenha);
        add(btlogar);
        add(btcancelar);
    }

    private void definirEventos() {
        btlogar.addActionListener(new ActionListener() {
            @Override
            public  void actionPerformed(ActionEvent e) {
                String senha = String.valueOf(pfSenha.getPassword());
                if (tfLogin.getText().equals("carlos") && senha.equals("12345")) {
                    JOptionPane.showMessageDialog(null, "Login efetuado com sucesso!");
                    frame.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(frame, "Login ou senha incorretos");
                }
            }
        });
        btcancelar.addActionListener(new ActionListener() {
            @Override
            public  void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame = new GuiLogin();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
                frame.setLocation(tela.width -frame.getSize().width/2, tela.height -frame.getSize().height/2 );
                frame.setVisible(true);
            }
        });


    }
}
