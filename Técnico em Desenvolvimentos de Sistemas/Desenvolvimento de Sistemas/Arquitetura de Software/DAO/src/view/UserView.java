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
    private JTextArea txaUsers;

    public UserView() {
        userDao = new UserDaoImpl();

        setTitle("User Management");
        setSize(450, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2, 5, 5));

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

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog("Enter User Name:");
                if (name != null && !name.trim().isEmpty()) {
                    userDao.saveUser(new User(name));
                    updateUserList();
                }
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int userId = Integer.parseInt(JOptionPane.showInputDialog("Enter User ID to Update:"));
                    String newName = JOptionPane.showInputDialog("Enter New Name:");
                    if (newName != null && !newName.trim().isEmpty()) {
                        userDao.updateUser(userId, newName);
                        updateUserList();
                    }
                } catch (NumberFormatException ex) {
                    //JOptionPane.showMessageDialog(null, "Invalid ID format!");
                    ex.printStackTrace();
                }
            }
        });

        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int userId = Integer.parseInt(JOptionPane.showInputDialog("Enter User ID to Delete:"));
                    userDao.deleteUser(userId);
                    updateUserList();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid ID format!");
                }
            }
        });

        btnFind.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int userId = Integer.parseInt(JOptionPane.showInputDialog("Enter User ID to Find:"));
                    User user = userDao.findUserById(userId);
                    if (user != null) {
                        JOptionPane.showMessageDialog(null, "User Found:\nID: " + user.getId() + "\nName: " + user.getName());
                    } else {
                        JOptionPane.showMessageDialog(null, "User Not Found!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid ID format!");
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
