package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import dao.UserDaoImpl;
import model.User;
import dao.UserDao;

public class UserView extends JFrame {
    private UserDao userDao;
    private JTextField txtName, txtId;
    private JTextArea txaUsers;

    public UserView() {
        userDao = new UserDaoImpl();

        setTitle("User Management");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        panel.add(new JLabel("Name:"));
        txtName = new JTextField();
        panel.add(txtName);

        JButton btnAdd = new JButton("Add User");
        panel.add(btnAdd);

        panel.add(new JLabel("User ID:"));
        txtId = new JTextField();
        panel.add(txtId);

        JButton btnDel = new JButton("Delete User");
        panel.add(btnDel);

        txaUsers = new JTextArea();
        txaUsers.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txaUsers);

        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txtName.getText();
                if (!name.isEmpty()) {
                    userDao.saveUser(new User(name));
                    txtName.setText("");
                    updateUserList();
                }
            }
        });

        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int userId = Integer.parseInt(txtId.getText());
                    userDao.deleteUser(userId);
                    txtId.setText("");
                    updateUserList();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Digite um ID válido.");
                }
            }
        });

        updateUserList();
    }

    private void updateUserList() {
        List<User> users = userDao.findAllUsers();
        txaUsers.setText("");
        for (User user : users) {
            txaUsers.append("ID: " + user.getId() + " - Nome: " + user.getName() + "\n");
        }
    }
}
