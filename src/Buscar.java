import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Buscar {
    private JTextField cedula1;
    public JPanel busca;
    private JButton buscarButton;
    private JLabel info1;
    private JLabel info2;
    private JLabel info3;
    private JLabel info4;
    private JLabel info5;
    private JLabel info6;
    private JLabel info7;
    private JLabel error;
    private JButton loginButton;
    private JButton registrarPacienteButton;
    private JFrame frame1;

    public Buscar(JFrame frame) {
        frame1=frame;
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*Creacia de objeto*/
                pacientes pacienteNuevo = new pacientes();
                pacienteNuevo.setCedula(cedula1.getText());

                /*Linea de conexion*/
                String url = "jdbc:mysql://localhost:3306/sistema_hospitalario";
                String usuario1 = "root";
                String contrasenia1 = "123456";
                /*Conectado*/
                try(Connection connection = DriverManager.getConnection(url, usuario1, contrasenia1)){
                    String sql = "select * from paciente where cedula='"+pacienteNuevo.getCedula()+"'";
                    PreparedStatement busca = connection.prepareStatement(sql);
                    ResultSet resultado = busca.executeQuery();
                    if(resultado.next()){
                        info2.setText(resultado.getString("n_historial_clinico"));
                        info3.setText(resultado.getString("nombre"));
                        info4.setText(resultado.getString("apellido"));
                        info5.setText(resultado.getString("telefono"));
                        info6.setText(resultado.getString("edad"));
                        info7.setText(resultado.getString("descripcion_enfermedad"));
                    }else {
                        error.setText("No existe una paciente con ese cedula");
                    }
                }
                catch(SQLException exception){
                    System.out.println(exception.getMessage());
                }
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Sistema Hospitalario");
                frame.pack();
                frame.setContentPane(new Login(frame).logeo);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(500, 500);
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
                frame1.setVisible(false);
            }
        });
        registrarPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Registro de pacientes");
                frame.setContentPane(new Registrarse(frame).registrar);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
                frame.setSize(600, 600);
                frame1.setVisible(false);
            }
        });
    }
}
