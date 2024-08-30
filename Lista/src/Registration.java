import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Registration extends JFrame {
    private JTextField tfNome;
    private JTextField tfEmail;
    private JTextField tfTelefone;
    private JTextField tfPesquisa;
    private JButton btnRegister;
    private JButton btnAdicionar;
    private JButton btnRemover;
    private JButton btnListar;
    private JButton btnSair;
    private JTextArea taResultados;
    private JLabel listaContatos;
    private JLabel tfRegistrar;
    private JPanel RegistrarPainel;
    private JTextField textField2;
    private JTextArea textArea1;
    private JButton button1;
    private JButton btnPesquisar;
    private JButton button2;
    private JTextField textField1;
    private JButton adicionarButton;


    public Registration() {
        setTitle("Registro de Usuário");
        setLayout(new GridLayout(6, 2)); // Ajustado para incluir todos os componentes
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Inicializa a conexão com o banco de dados
        try {
            String url = "#";
            String user = "#";
            String password = "#";
            Connection connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Falha na conexão com o banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        // Adiciona componentes ao JFrame
        add(new JLabel("Nome:"));
        tfNome = new JTextField();
        add(tfNome);

        add(new JLabel("Email:"));
        tfEmail = new JTextField();
        add(tfEmail);

        add(new JLabel("Telefone:"));
        tfTelefone = new JTextField();
        add(tfTelefone);

        add(new JLabel("Pesquisar:"));
        tfPesquisa = new JTextField(); // Adiciona campo de pesquisa
        add(tfPesquisa);

        btnRegister = new JButton("Registrar");
        add(btnRegister);

        btnAdicionar = new JButton("Adicionar");
        add(btnAdicionar);

        btnRemover = new JButton("Remover");
        add(btnRemover);

        btnListar = new JButton("Listar");
        add(btnListar);

        btnSair = new JButton("Sair");
        add(btnSair);

        taResultados = new JTextArea(10, 30);
        taResultados.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(taResultados);
        add(scrollPane);

        // Adiciona ActionListener ao botão de registrar
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });

        // Adiciona ActionListener aos outros botões
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para adicionar contato
            }
        });

        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para remover contato
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para listar contatos
            }
        });

        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void registerUser() {
        String nome = tfNome.getText();
        String email = tfEmail.getText();
        String telefone = tfTelefone.getText();

        if (nome.isEmpty() || email.isEmpty() || telefone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String sql = "INSERT INTO users (nome, email, telefone) VALUES (?, ?, ?)";

        Connection connection = null;
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.setString(2, email);
            pstmt.setString(3, telefone);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Usuário registrado com sucesso");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao registrar usuário", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createUIComponents() {
        // Este método é necessário para criar componentes personalizados
        // No seu caso, se todos os componentes são criados diretamente no construtor,
        // você pode deixá-lo vazio.
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Registration());
    }
}
