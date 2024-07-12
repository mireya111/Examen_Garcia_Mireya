import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login {
    private JTextField correo;
    public JPanel logeo;
    private JTextField contrasenia;
    private JButton entrar;
    private JLabel errores;

    public Login(JFrame frame1) {
        entrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuario usuario = new usuario();
                usuario.setCorreo(correo.getText());
                usuario.setContrasenia(contrasenia.getText());
                /*linea de conexio*/
                String url = "jdbc:mysql://localhost:3306/sistema_hospitalario";
                String usuario1 = "root";
                String contrasenia1 = "123456";
                /*Conecta*/
                try(Connection connection = DriverManager.getConnection(url, usuario1, contrasenia1)){
                    String sql = "select * from usuario where username='"+ usuario.getCorreo() +"' and password='"+ usuario.getContrasenia() +"'";
                    PreparedStatement login = connection.prepareStatement(sql);
                    ResultSet busqueda = login.executeQuery();
                    if(busqueda.next()){
                        errores.setText("");
                        JFrame frame = new JFrame("Registro de pacientes");
                        frame.setContentPane(new Registrarse(frame).registrar);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.pack();
                        frame.setVisible(true);
                        frame.setLocationRelativeTo(null);
                        frame.setSize(600, 600);
                        frame1.setVisible(false);
                    } else {
                        errores.setText("Contraseñas incorrectas");
                    }
                }
                catch (SQLException exception) {
                    System.out.println(exception.getMessage());
                }

            }
        });
    }
}
