import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Registrarse {
    private JTextField cedu;
    public JPanel registrar;
    private JTextField numeroH;
    private JTextField nombre;
    private JTextField apellido;
    private JTextField telefono;
    private JTextField edad;
    private JTextField descrip;
    private JButton registro;
    private JLabel confirmacion;
    private JButton buscarPacienteButton;

    public Registrarse(JFrame frame1) {
        registro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*Creacia de objeto*/
                pacientes pacienteNuevo = new pacientes();
                pacienteNuevo.setCedula(cedu.getText());
                pacienteNuevo.setHistoria(Integer.parseInt(numeroH.getText()));
                pacienteNuevo.setNombre(nombre.getText());
                pacienteNuevo.setApellido(apellido.getText());
                pacienteNuevo.setTelefono(telefono.getText());
                pacienteNuevo.setEdad(Integer.parseInt(edad.getText()));
                pacienteNuevo.setDescri_enfe(descrip.getText());
                /*Linea de conexion*/
                String url = "jdbc:mysql://localhost:3306/sistema_hospitalario";
                String usuario1 = "root";
                String contrasenia1 = "123456";
                /*Conectado*/
                try(Connection connection= DriverManager.getConnection(url, usuario1, contrasenia1)){
                    String insertar = "insert into PACIENTE(cedula, n_historial_clinico, nombre, apellido, telefono,  edad, descripcion_enfermedad) values (?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement inserta = connection.prepareStatement(insertar);
                    inserta.setString(1, pacienteNuevo.getCedula());
                    inserta.setString(2, String.valueOf(pacienteNuevo.getHistoria()));
                    inserta.setString(3, pacienteNuevo.getNombre());
                    inserta.setString(4, pacienteNuevo.getApellido());
                    inserta.setString(5, pacienteNuevo.getTelefono());
                    inserta.setInt(6, pacienteNuevo.getEdad());
                    inserta.setString(7,pacienteNuevo.getDescri_enfe());
                    inserta.executeUpdate();
                    confirmacion.setText("Se ha ingresado el paciente");
                }
                /*No conectado*/
                catch (SQLException exception){
                    System.out.println(exception.getMessage());
                }
            }
        });
        buscarPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Registro de pacientes");
                frame.setContentPane(new Buscar(frame).busca);
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
