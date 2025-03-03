package view;

import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.UserController;
import model.User;
import java.util.List;

import controller.UserController;
import model.User;

public class UserView extends JFrame {
    private UserController userController;
    private JTextArea txaUsers;

    public UserView() {
        userController = new UserController();

        setTitle("User Management");
        setSize(450, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(2, 2, 5, 5));
        JButton btnAdd = new JButton("Add User");
        JButton btnUpdate = new JButton("Update User");
        JButton btnDel = new JButton("Delete User");
        JButton btnFind = new JButton("Find User");

        panel.add(btnAdd);
        panel.add(btnUpdate);
        panel.add(btnDel);
        panel.add(btnFind);

        txaUsers = new JTextArea();
        txaUsers.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txaUsers);

        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        btnAdd.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Enter User Name:");
            if (name != null && !name.trim().isEmpty()) {
                userController.addUser(name);
                updateUserList();
            }
        });

        btnUpdate.addActionListener(e -> {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter User ID to Update:"));
            String newName = JOptionPane.showInputDialog("Enter New Name:");
            userController.updateUser(id, newName);
            updateUserList();
        });

        btnDel.addActionListener(e -> {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter User ID to Delete:"));
            userController.deleteUser(id);
            updateUserList();
        });

        btnFind.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int userId = Integer.parseInt(JOptionPane.showInputDialog("Enter User ID to Find:"));
                userController.getUserById(userId);
                updateUserList();
            }
        });

        updateUserList();
    }

    private void updateUserList() {
        List<User> users = userController.getAllUsers();
        txaUsers.setText("");
        users.forEach(user -> txaUsers.append("ID: " + user.getId() + " - Name: " + user.getName() + "\n"));
    }
}
