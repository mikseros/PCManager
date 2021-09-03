package com.amalmikolaj;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

import com.amalmikolaj.dao.DaoFactory;
import com.amalmikolaj.model.User;

public class AdminFrame2 extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String mail ;
	
	DefaultListModel<User> modelUser = new DefaultListModel<User>();
	JList<User> userJList = new JList<User>(modelUser);
	ArrayList<User> userList = new ArrayList<User>();
	JScrollPane userListScroll = new JScrollPane();
	DaoFactory dao = new DaoFactory();
	JLabel label = new JLabel();
	

	JPanel panelA = new JPanel();
	JPanel panelB = new JPanel();
	JPanel panelC = new JPanel();
	JPanel panelD = new JPanel();
	JPanel panelE = new JPanel();
	JPanel panelF = new JPanel();
	
	//TextFields and Labels for user edition panel
	JLabel editUserIdL = new JLabel("Here you can modify users. For update, just click 'Save Modification' button.");
	JLabel editUserNameL = new JLabel("Name: ");
	JLabel editUserSurnameL = new JLabel("Surname: ");
	JLabel editUserDobL = new JLabel("Date of birth: ");
	JLabel editUserPostL = new JLabel("Post: ");
	JLabel editUserPassL = new JLabel("Password: ");
	JLabel editUserMailL = new JLabel("E-mail: ");
	
	JTextField editUserId = new JTextField("0");
	JTextField editUserName = new JTextField();
	JTextField editUserSurname = new JTextField();
	JTextField editUserDob = new JTextField();
	JTextField editUserPost = new JTextField();
	JTextField editUserPass = new JTextField();
	JTextField editUserMail = new JTextField();
	
	// TextFields and Labels for new user addition
	JLabel addUserIdL = new JLabel("ID: ");
	JLabel addUserNameL = new JLabel("Name: ");
	JLabel addUserSurnameL = new JLabel("Surname: ");
	JLabel addUserDobL = new JLabel("Date of birth: ");
	JLabel addUserPostL = new JLabel("Post: ");
	JLabel addUserPassL = new JLabel("Password: ");
	JLabel addUserMailL = new JLabel("E-mail: ");
	
	JTextField addUserId = new JTextField("0");
	JTextField addUserName = new JTextField();
	JTextField addUserSurname = new JTextField();
	JTextField addUserDob = new JTextField();
	JTextField addUserPost = new JTextField();
	JTextField addUserPass = new JTextField();
	JTextField addUserMail = new JTextField();
	
	JButton addUser = new JButton();
	JButton unblock = new JButton();

	
	JButton modifyWS = new JButton("Save Modification");
	
	JButton deleteUserButton = new JButton();
	JPanel deleteUserButtonPanel = new JPanel();
	
	JButton activatePassChangeButton = new JButton();
	JPanel activatePassChengeButtonPanel = new JPanel();
	
	JButton saveNewPassButton = new JButton();
	JPanel saveNewPassButtonPanel = new JPanel();

	public void manageE() {
		panelE.setSize(800, 250);
		panelE.setLayout(new BorderLayout());
		panelE.add(label, BorderLayout.NORTH);
		try {
			for(int i = 0; i + 1 <= dao.getUserDao().showAllUsers().size(); i++) {
				if(dao.getUserDao().showAllUsers().get(i).isDeleted()==false) {
					userList.add(dao.getUserDao().showAllUsers().get(i));
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		modelUser.addAll(userList);
		userJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		userJList.addListSelectionListener(new getUserToMod());
        
        userListScroll = new JScrollPane(userJList);
        userListScroll.setSize(800, 150);
        panelE.add(userListScroll, BorderLayout.CENTER);
	}
	
	public void refreshList() {
		userList.clear();
		modelUser.clear();
		try {
			for(int i = 0; i + 1 <= dao.getUserDao().showAllUsers().size(); i++) {
				if(dao.getUserDao().showAllUsers().get(i).isDeleted()==false) {
					userList.add(dao.getUserDao().showAllUsers().get(i));
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		modelUser.addAll(userList);	
	}
	
	
	// Managing the panel which holds the form for user edition.
	public void manageF() {
		panelF.setSize(800, 450);
		panelF.setLayout(new GridLayout(15, 2));
		panelF.add(editUserIdL);
		panelF.add(editUserId);
		panelF.add(editUserNameL);
		panelF.add(editUserName);
		panelF.add(editUserSurnameL);
		panelF.add(editUserSurname);
		panelF.add(editUserDobL);
		panelF.add(editUserDob);
		panelF.add(editUserPostL);
		panelF.add(editUserPost);
		panelF.add(editUserPassL);
		panelF.add(editUserPass);
		panelF.add(editUserMailL);
		panelF.add(editUserMail);
		panelF.add(modifyWS);
		panelF.setVisible(true);
	}
	
	// Managing the button for save the modification of workstation.
	public void manageModifyWS() {
		modifyWS.setFocusable(false);
		modifyWS.setBackground(Color.ORANGE);
		modifyWS.addActionListener(new saveUserModification());
	}
	// Managing of the panels which are hold everything else.
	public void manageA() {
		
		panelA.setSize(800, 700);
		panelA.setLayout(new BorderLayout());
		panelA.add(panelE, BorderLayout.NORTH);
		panelA.add(panelF, BorderLayout.CENTER);
	}
	
	public void manageB() {
		
		panelB.setSize(800, 700);
		panelB.setLayout(new GridLayout(1, 2));
		panelB.add(panelC);
		panelB.add(panelD);
	}
	public void manageC() {
		
		panelC.setSize(400, 700);
		panelC.setLayout(new GridLayout(3, 1));
		panelC.add(activatePassChengeButtonPanel);
		panelC.add(saveNewPassButtonPanel);
		panelC.add(deleteUserButtonPanel);
		
	}
	
	public void manageD() {
		panelD.setSize(400, 700);
		panelD.setLayout(new GridLayout(15, 1));
		panelD.add(unblock);
		panelD.add(addUserId);
		panelD.add(addUserNameL);
		panelD.add(addUserName);
		panelD.add(addUserSurnameL);
		panelD.add(addUserSurname);
		panelD.add(addUserDobL);
		panelD.add(addUserDob);
		panelD.add(addUserPostL);
		panelD.add(addUserPost);
		panelD.add(addUserPassL);
		panelD.add(addUserPass);
		panelD.add(addUserMailL);
		panelD.add(addUserMail);
		panelD.add(addUser);
		
	}
	// Managing the button "unblock user addition"
	public void manageUnblock() {
		unblock.setText("Add new user");
		unblock.setBackground(Color.red);
		unblock.setFocusable(false);
		unblock.addActionListener(e -> {
			addUserName.setEditable(true);
			addUserSurname.setEditable(true);
			addUserDob.setEditable(true);
			addUserPost.setEditable(true);
			addUserPass.setEditable(true);
			addUserMail.setEditable(true);
			addUser.setEnabled(true);
		});
	}
	
	
	// Managing "Add new user" button
	public void manageAddUserButton() {
		addUser.setText("Save new user!");
		addUser.setBackground(Color.green);
		addUser.setFocusable(false);
		addUser.setEnabled(false);
		if(!(addUserMail.getText()==null)) {
			addUser.addActionListener(new addNewUser());
		}
	}
	
	// Managing the label with the title.
	public void labelManage() {
		label.setSize(800, 100);
		label.setText("Welcome to Admin-User-Manager!");
		label.setHorizontalAlignment(JLabel.CENTER);
	    label.setVerticalAlignment(JLabel.CENTER);
		label.setFont(new Font("Mv Boli", Font.PLAIN, 30));
	}
	
	// Managing the button which activate the option of password change for the user.
	public void manageActivatePassChangeButton() {
		activatePassChangeButton.setText("Set new password");
		activatePassChangeButton.setBackground(Color.red);
		activatePassChangeButton.setFocusable(false);
		activatePassChangeButton.addActionListener(e -> {
			if(!(Integer.valueOf(editUserId.getText())==0)) {
				saveNewPassButtonPanel.setVisible(true);
				editUserPass.setEditable(true);
			}
		});
	}
		
	// Managing the panel for the "activatePassChangeButton".
	public void manageActivatePassChangeButtonPanel() {
		activatePassChengeButtonPanel.setSize(200, 50);
		activatePassChengeButtonPanel.add(activatePassChangeButton);
	}
	
	// Managing "Save new password" button
	public void manageSaveNewPassButton() {
		saveNewPassButton.setText("Save new password");
		saveNewPassButton.setBackground(Color.red);
		saveNewPassButton.setFocusable(false);
		saveNewPassButton.addActionListener(new changePassword());
		
	}
	
	// Managing panel for the "Save new password" button
	public void manageSaveNewPassButtonPanel() {
		saveNewPassButtonPanel.setSize(200, 50);
		saveNewPassButtonPanel.add(saveNewPassButton);
		saveNewPassButtonPanel.setVisible(false);
	}
	
	public void manageDeleteUserButton() {
		deleteUserButton.setText("Delete User");
		deleteUserButton.setBackground(Color.RED);
		deleteUserButton.setFocusable(false);
		deleteUserButton.addActionListener(new deleteUser());
	}
	
	public void manageDeleteUserButtonPanel() {
		deleteUserButtonPanel.setSize(200, 50);
		deleteUserButtonPanel.add(deleteUserButton);
	}
	
	//Manage some labels and text fields.
	public void labelsManage() {
		
		editUserIdL.setForeground(Color.RED);
		editUserId.setFont(new Font("Helvetica", Font.PLAIN, 15));
		editUserId.setEditable(false);
		editUserName.setFont(new Font("Helvetica", Font.PLAIN, 15));
		editUserSurname.setFont(new Font("Helvetica", Font.PLAIN, 15));
		editUserDob.setFont(new Font("Helvetica", Font.PLAIN, 15));
		editUserPost.setFont(new Font("Helvetica", Font.PLAIN, 15));
		editUserPass.setFont(new Font("Helvetica", Font.PLAIN, 15));
		editUserPass.setEditable(false);
		editUserMail.setFont(new Font("Helvetica", Font.PLAIN, 15));
		
		addUserIdL.setForeground(Color.RED);
		addUserId.setFont(new Font("Helvetica", Font.PLAIN, 15));
		addUserId.setEditable(false);
		addUserName.setFont(new Font("Helvetica", Font.PLAIN, 15));
		addUserName.setEditable(false);
		addUserSurname.setFont(new Font("Helvetica", Font.PLAIN, 15));
		addUserSurname.setEditable(false);
		addUserDob.setFont(new Font("Helvetica", Font.PLAIN, 15));
		addUserDob.setText("1900-01-01");
		addUserDob.setEditable(false);
		addUserPost.setFont(new Font("Helvetica", Font.PLAIN, 15));
		addUserPost.setEditable(false);
		addUserPass.setFont(new Font("Helvetica", Font.PLAIN, 15));
		addUserPass.setEditable(false);
		addUserMail.setFont(new Font("Helvetica", Font.PLAIN, 15));
		addUserMail.setEditable(false);
		addUserMail.setText(null);
	}	
	
	public class addNewUser implements ActionListener {
		
		addNewUser() {
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			User user = new User();
			user.setName(addUserName.getText());
			user.setSurname(addUserSurname.getText());
			user.setDateOfBirth(Date.valueOf(addUserDob.getText()));
			user.setPost(addUserPost.getText());
			user.setPassword(addUserPass.getText());
			user.setEmail(addUserMail.getText());
			//dao.getUserDao().addUser(user);
			if(dao.getUserDao().getUserByMail(addUserMail.getText())==null) {
				dao.getUserDao().addUser(user);
			} else {
				JOptionPane.showMessageDialog(null, "This e-mail is already in use!");
			}
			addUserName.setText("");
			addUserName.setEditable(false);
			addUserSurname.setText("");
			addUserSurname.setEditable(false);
			addUserDob.setText("1900-01-01");
			addUserDob.setEditable(false);
			addUserPost.setText("");
			addUserPost.setEditable(false);
			addUserPass.setText("");
			addUserPass.setEditable(false);
			addUserMail.setText(null);
			addUserMail.setEditable(false);
			addUser.setEnabled(false);
			refreshList();
		}
	}
	
	public class changePassword implements ActionListener {
		
		changePassword() {
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				User user = new User();
				user.setId(Integer.valueOf(editUserId.getText()));
				user.setName(editUserName.getText());
				user.setSurname(editUserSurname.getText());
				user.setDateOfBirth(Date.valueOf(editUserDob.getText()));
				user.setPost(editUserPost.getText());
				user.setPassword(editUserPass.getText());
				user.setEmail(editUserMail.getText());
				dao.getUserDao().changePass(user, user.getId());
			} catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
			editUserPass.setText(null);
			editUserPass.setEditable(false);
			saveNewPassButtonPanel.setVisible(false);
			refreshList();
		}

	}
	
	public class saveUserModification implements ActionListener {
		
		saveUserModification() {
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				User u = new User();
				u.setId(Integer.valueOf(editUserId.getText()));
				u.setName(editUserName.getText());
				u.setSurname(editUserSurname.getText());
				u.setDateOfBirth(Date.valueOf(editUserDob.getText()));
				u.setPost(editUserPost.getText());
				u.setEmail(editUserMail.getText());
				dao.getUserDao().updateUser(u);
			} catch(Exception x) {
				System.out.println(x.getMessage());
			}
			refreshList();
			
		}	
	}
	
	public class getUserToMod implements ListSelectionListener {
		
		getUserToMod() {
			
		}

		@Override
		public void valueChanged(ListSelectionEvent e) {
			try {
				User u = userJList.getSelectedValue();
				editUserId.setText(String.valueOf(u.getId()));
				editUserName.setText(u.getName());
				editUserSurname.setText(u.getSurname());
				editUserDob.setText(String.valueOf(u.getDateOfBirth()));
				editUserPost.setText(u.getPost());
				editUserMail.setText(u.getEmail());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
	// Action Listener for deleting user
	public class deleteUser implements ActionListener {
		deleteUser() {}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(Integer.valueOf(editUserId.getText())!=0) {
				dao.getUserDao().deleteUserDao(Integer.valueOf(editUserId.getText()));
			}
			editUserId.setText("");
			editUserName.setText("");
			editUserSurname.setText("");
			editUserDob.setText("");
			editUserPost.setText("");
			editUserMail.setText("");
			refreshList();
		}
	}

	// Constructor of the frame
	public AdminFrame2(String mail) {
		this.mail = mail;
		
		labelManage();
		labelsManage();
		manageA();
		manageB();
		manageC();
		manageD();
		manageE();
		manageF();
		manageModifyWS();
		manageAddUserButton();
		manageActivatePassChangeButton();
		manageActivatePassChangeButtonPanel();
		manageSaveNewPassButton();
		manageSaveNewPassButtonPanel();
		manageUnblock();
		manageDeleteUserButtonPanel();
		manageDeleteUserButton();
		
		this.setSize(1600, 700);
	    this.setTitle("Our Workstations");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLayout(new GridLayout(1, 2, 1, 1));
	    this.add(panelA);
	    this.add(panelB);
		this.setVisible(true);
	}	
}

