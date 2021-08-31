package com.amalmikolaj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Vector;

import com.amalmikolaj.UserFrame.editPassword;
import com.amalmikolaj.dao.DaoFactory;
import com.amalmikolaj.model.Workstation;
import com.amalmikolaj.model.User;

public class AdminFrame extends JFrame{
	String mail ;
	
	
	DefaultListModel<Workstation>listModel = new DefaultListModel<Workstation>();
	ArrayList<Workstation> workstationList = new ArrayList<Workstation>();
	JScrollPane workstationListScrolling = new JScrollPane();
	DaoFactory dao = new DaoFactory();
	JLabel label = new JLabel();
	JButton editProfile = new JButton();
	JButton addPc = new JButton();
	JPanel addPcPanel = new JPanel();
	JTextField brand = new JTextField();
	JTextField model = new JTextField();
	JTextField tag = new JTextField();
	JTextField studentName = new JTextField();
	JTextField studentSurname = new JTextField();
	JTextField course = new JTextField();
	JTextField dateOfBorrow = new JTextField();
	JTextField cheque = new JTextField();
	JTextField returnComment = new JTextField();
	JLabel brandLabel = new JLabel();
	JLabel modelLabel = new JLabel();
	JLabel tagLabel = new JLabel();
	JLabel nameLabel = new JLabel();
	JLabel surnameLabel = new JLabel();
	JLabel courseLabel = new JLabel();
	JLabel dateLabel = new JLabel();
	JLabel chequeLabel = new JLabel();
	JLabel commentLabel = new JLabel();
	JButton savePc = new JButton();
	JPanel addButtonPanel = new JPanel();
	JPanel editButtonPanel = new JPanel();
	
	JPanel editProfilePanel = new JPanel();
	JTextField name = new JTextField();
	JTextField surname = new JTextField();
	JTextField dateOfBirth = new JTextField();
	JTextField post = new JTextField();
	JTextField password = new JTextField();
	JTextField email = new JTextField();
	JLabel userNameL = new JLabel();
	JLabel uSurnameL = new JLabel();
	JLabel dobL = new JLabel();
	JLabel postL = new JLabel();
	JLabel passL = new JLabel();
	JLabel emailL = new JLabel();
	JButton modifyUser = new JButton();
	JPanel panelA = new JPanel();
	JPanel panelB = new JPanel();
	JPanel panelC = new JPanel();
	JPanel panelD = new JPanel();
	JPanel panelE = new JPanel();
	JPanel panelF = new JPanel();
	
	JLabel editIdL = new JLabel("Type in the ID of PC to modify (Num). Then click 'Modify WOrkstation'. After getting data you can modify and save it by 'Save Modification'");
	JLabel editBrandL = new JLabel("Brand: ");
	JLabel editModelL = new JLabel("Model: ");
	JLabel editTagL = new JLabel("Service tag: ");
	JLabel edStudNameL = new JLabel("Student Name: ");
	JLabel edStudSurnL = new JLabel("Student surname: ");
	JLabel editCourseL = new JLabel("Course: ");
	JLabel editDobL = new JLabel("Date of borrow: ");
	JLabel editChequeL = new JLabel("Cheque(true/false): ");
	JLabel editRetCommL = new JLabel("Return comment: ");
	
	JTextField editId = new JTextField("0");
	JTextField editBrand = new JTextField();
	JTextField editModel = new JTextField();
	JTextField editTag = new JTextField();
	JTextField edStudName = new JTextField();
	JTextField edStudSurn = new JTextField();
	JTextField editCourse = new JTextField();
	JTextField editDob = new JTextField();
	JTextField editCheque = new JTextField();
	JTextField editRetComm = new JTextField();
	
	JPanel panelG = new JPanel();
	
	//TextFields and Labels for user edition panel
	JLabel editUserIdL = new JLabel("Type in the ID of USER to modify (Num). Then click 'Modify WOrkstation'.\n After getting data you can modify and save it by 'Save Modification'");
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

	
	JButton modifyWS = new JButton("Save Modification");
	
	JButton selectPcToModify = new JButton("Modify Workstation");
	JPanel selectPcButP = new JPanel();
	JButton refreshListButton = new JButton("List Refresh");
	JPanel refreshListButtonPanel = new JPanel();
	
	JButton adminOptionsButton = new JButton();
	JPanel adminOptionsButtonPanel = new JPanel();
	
	JButton deletePcButton = new JButton();
	JPanel deletePcButtonPanel = new JPanel();
	
	JButton showUsersButton = new JButton();
	JPanel showUsersButtonPanel = new JPanel();
	
	JButton modifyUserButton = new JButton();
	JPanel modifyUserButtonPanel = new JPanel();
	
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
			for(int i = 0; i + 1 <= dao.getWorkstationDao().showAllMachines().size(); i++) {
				workstationList.add(dao.getWorkstationDao().showAllMachines().get(i));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		JList<Workstation> workstationJList = new JList<Workstation>(new Vector<Workstation>(workstationList));
		//workstationJList.setModel(listModel);
		workstationJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        workstationListScrolling = new JScrollPane(workstationJList);
        workstationListScrolling.setSize(800, 150);
        panelE.add(workstationListScrolling, BorderLayout.CENTER);
	}
	
	public void refreshList() {
		try {
			for(int i = 0; i + 1 <= dao.getWorkstationDao().showAllMachines().size(); i++) {
				workstationList.add(dao.getWorkstationDao().showAllMachines().get(i));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	// Managing the panel which holds the form for workstation edition.
	public void manageF() {
		panelF.setSize(800, 450);
		panelF.setLayout(new GridLayout(22, 2));
		panelF.add(editIdL);
		panelF.add(editId);
		panelF.add(editBrandL);
		panelF.add(editBrand);
		panelF.add(editModelL);
		panelF.add(editModel);
		panelF.add(editTagL);
		panelF.add(editTag);
		panelF.add(edStudNameL);
		panelF.add(edStudName);
		panelF.add(edStudSurnL);
		panelF.add(edStudSurn);
		panelF.add(editCourseL);
		panelF.add(editCourse);
		panelF.add(editDobL);
		panelF.add(editDob);
		panelF.add(editChequeL);
		panelF.add(editCheque);
		panelF.add(editRetCommL);
		panelF.add(editRetComm);
		panelF.add(modifyWS);
		panelF.setVisible(true);
	}
	// Managing the panel which holds the form for user edition.
	public void manageG() {
		panelG.setSize(400, 700);
		panelG.setLayout(new GridLayout(15, 2));
		panelG.add(editUserIdL);
		panelG.add(editUserId);
		panelG.add(editUserNameL);
		panelG.add(editUserName);
		panelG.add(editUserSurnameL);
		panelG.add(editUserSurname);
		panelG.add(editUserDobL);
		panelG.add(editUserDob);
		panelG.add(editUserPostL);
		panelG.add(editUserPost);
		panelG.add(editUserPassL);
		panelG.add(editUserPass);
		panelG.add(editUserMailL);
		panelG.add(editUserMail);
		
		panelG.add(modifyWS);
		panelG.setVisible(true);
	}
	
	// Managing the button for save the modification of workstation.
	public void manageModifyWS() {
		modifyWS.setFocusable(false);
		modifyWS.setBackground(Color.ORANGE);
		modifyWS.addActionListener(new savePcModification());
	}
	// Managing of the panels which are hold everything else.
	public void manageA() {
		
		panelA.setSize(800, 700);
		panelA.setLayout(new BorderLayout());
		panelA.add(panelE, BorderLayout.NORTH);
		panelA.add(panelF, BorderLayout.CENTER);
		//panelA.add(panelG, BorderLayout.CENTER);
	}
	
	public void manageB() {
		
		panelB.setSize(800, 700);
		panelB.setLayout(new GridLayout(1, 2));
		panelB.add(panelC);
		panelB.add(panelD);
	}
	public void manageC() {
		
		panelC.setSize(400, 700);
		panelC.setLayout(new GridLayout(12, 1));
		panelC.add(addButtonPanel);
		panelC.add(editButtonPanel);
		panelC.add(selectPcButP);
		panelC.add(refreshListButtonPanel);
		panelC.add(activatePassChengeButtonPanel);
		panelC.add(saveNewPassButtonPanel);
		panelC.add(adminOptionsButtonPanel);
		panelC.add(deletePcButtonPanel);
		panelC.add(showUsersButtonPanel);
		panelC.add(modifyUserButtonPanel);
		panelC.add(deleteUserButtonPanel);
		
	}
	public void manageD() {
		panelD.setSize(400, 700);
		panelD.setLayout(new BorderLayout());
		panelD.add(addPcPanel, BorderLayout.NORTH);
		panelD.add(editProfilePanel, BorderLayout.CENTER);
		//panelD.add(panelG, BorderLayout.NORTH);
	}
	// Managing the label with the title.
	public void labelManage() {
		label.setSize(800, 100);
		label.setText("Welcome to PC Admin-Manager!");
		label.setHorizontalAlignment(JLabel.CENTER);
	    label.setVerticalAlignment(JLabel.CENTER);
		label.setFont(new Font("Mv Boli", Font.PLAIN, 30));
	}
	// Managing the button which is filling data to the form of workstation modification.
	public void manageSelectPcToModifyButton() {
		selectPcToModify.setBackground(Color.YELLOW);
		selectPcToModify.setFocusable(false);
		selectPcToModify.setSize(200, 50);
		selectPcToModify.addActionListener(new getPcToMod());
		
	}
	// Managing the refresh(list) button.
	public void manageRefreshListButtonPanel() {
		refreshListButtonPanel.setSize(200, 50);
		refreshListButton.setBackground(Color.pink);
		refreshListButton.setFocusable(false);
		refreshListButton.setSize(200, 50);
		refreshListButton.addActionListener(e -> {
			//listModel.removeAllElements();
			//listModel.addAll(workstationList);
		});
		refreshListButtonPanel.add(refreshListButton);
	}
	
	//Managing "Admin Options" button.
	public void ManageAdminOptionsButton() {
		adminOptionsButton.setText("Admin Options >>>");
		adminOptionsButton.setBackground(Color.WHITE);
		adminOptionsButton.setFocusable(false);
		adminOptionsButton.addActionListener(e -> {
			deletePcButtonPanel.setVisible(true);
			showUsersButtonPanel.setVisible(true);
			modifyUserButtonPanel.setVisible(true);
			deleteUserButtonPanel.setVisible(true);
		});
	}
	
	//Managing the panel which hold "Admin Options" button.
	public void ManageAdminOptionsButtonPanel() {
		adminOptionsButtonPanel.setSize(200, 50);
		adminOptionsButtonPanel.add(adminOptionsButton);
	}
	
	
	// Managing the panel which hold the button.
	public void manageSelectPcButP() {
		selectPcButP.setSize(200, 50);
		selectPcButP.add(selectPcToModify);
	}
	// Managing the button which shows the panel for new workstation addition.
	public void manageAddPcButton() {
		addPc.setText("Add new PC");
		addPc.setBackground(Color.green);
		addPc.setFocusable(false);
		addPc.setSize(200, 50);
		addPc.addActionListener(e -> {
			addPcPanel.setVisible(true);
			editProfilePanel.setVisible(false);
			panelG.setVisible(false);
		});
	}
	// Managing the panel for the button.
	public void manageAddButtonPanel() {
		addButtonPanel.setSize(200, 50);
		addButtonPanel.add(addPc);
	}
	// Managing the button which shows the panel for user-profile modifications.
	public void manageProfileButton() {
		editProfile.setText("Edit my profile");
		editProfile.setBackground(Color.cyan);
		editProfile.setFocusable(false);
		editProfile.setSize(200, 50);
		editProfile.addActionListener(e -> {
			editProfilePanel.setVisible(true);
			addPcPanel.setVisible(false);
			panelG.setVisible(false);
		});
	}
	// Managing the panel for the button.
	public void manageEditButtonPanel() {
		editButtonPanel.setSize(200, 50);
		editButtonPanel.add(editProfile);
	}
	// Managing "admin" buttons
	public void manageDeletePcButton() {
		deletePcButton.setText("Delete PC");
		deletePcButton.setBackground(Color.red);
		deletePcButton.setFocusable(false);
		deletePcButton.addActionListener(null);
	}
	
	public void manageDeletePcButtonPanel() {
		deletePcButtonPanel.setSize(200, 50);
		deletePcButtonPanel.add(deletePcButton);
		deletePcButtonPanel.setVisible(false);
	}
	
	public void manageShowUsersButton() {
		showUsersButton.setText("Show Users");
		showUsersButton.setBackground(Color.green);
		showUsersButton.setFocusable(false);
		showUsersButton.addActionListener(null);
	}
	
	public void manageShowUsersButtonPanel() {
		showUsersButtonPanel.setSize(200, 50);
		showUsersButtonPanel.add(showUsersButton);
		showUsersButtonPanel.setVisible(false);
	}
	
	public void manageModifyUserButton() {
		modifyUserButton.setText("Edit User");
		modifyUserButton.setBackground(Color.yellow);
		modifyUserButton.setFocusable(false);
		modifyUserButton.addActionListener(e -> {
			addPcPanel.setVisible(false);
			editProfilePanel.setVisible(false);
			panelG.setVisible(true);
			//activatePassChengeButtonPanel.setVisible(true);
		});
	}
	
	public void manageModifyUserButtonPanel() {
		modifyUserButtonPanel.setSize(200, 50);
		modifyUserButtonPanel.add(modifyUserButton);
		modifyUserButtonPanel.setVisible(false);
	}
	
	public void manageDeleteUserButton() {
		deleteUserButton.setText("Delete User");
		deleteUserButton.setBackground(Color.RED);
		deleteUserButton.setFocusable(false);
		deleteUserButton.addActionListener(null);
	}
	
	public void manageDeleteUserButtonPanel() {
		deleteUserButtonPanel.setSize(200, 50);
		deleteUserButtonPanel.add(deleteUserButton);
		deleteUserButtonPanel.setVisible(false);
	}
	// Managing the button for saving new workstation in the database.
	public void manageSavePcButton() {
		savePc.setText("Save new Pc");
		savePc.setBackground(Color.green);
		savePc.setFocusable(false);
		savePc.addActionListener(new savePcListen());
	}
	
	// Managing the button which activate the option of password change for the user.
	public void manageActivatePassChangeButton() {
		activatePassChangeButton.setText("Set new password");
		activatePassChangeButton.setBackground(Color.red);
		activatePassChangeButton.setFocusable(false);
		activatePassChangeButton.addActionListener(e -> {
			password.setEditable(true);
			saveNewPassButtonPanel.setVisible(true);
		});
	}
		
	// Managing the panel for the "activatePassChangeButton".
	public void manageActivatePassChangeButtonPanel() {
		activatePassChengeButtonPanel.setSize(200, 50);
		activatePassChengeButtonPanel.add(activatePassChangeButton);
	}
	
	// Managing the button which saves password change
	public void manageSaveNewPassButton() {
		saveNewPassButton.setText("Save new password");
		saveNewPassButton.setBackground(Color.RED);
		saveNewPassButton.setFocusable(false);
		saveNewPassButton.addActionListener(new editPassword());
	}
		
	// Managing the panel for the "activatePassChangeButton".
	public void manageSaveNewPassButtonPanel() {
		saveNewPassButtonPanel.setSize(200, 50);
		saveNewPassButtonPanel.add(saveNewPassButton);
		saveNewPassButtonPanel.setVisible(false);
	}
	
	// Managing the panel for new workstation addition.
	public void manageAddPcPanel() {
		addPcPanel.setLayout(new GridLayout(20, 1));
		addPcPanel.add(brandLabel);
		addPcPanel.add(brand);
		addPcPanel.add(modelLabel);
		addPcPanel.add(model);
		addPcPanel.add(tagLabel);
		addPcPanel.add(tag);
		addPcPanel.add(nameLabel);
		addPcPanel.add(studentName);
		addPcPanel.add(surnameLabel);
		addPcPanel.add(studentSurname);
		addPcPanel.add(courseLabel);
		addPcPanel.add(course);
		addPcPanel.add(dateLabel);
		addPcPanel.add(dateOfBorrow);
		addPcPanel.add(chequeLabel);
		addPcPanel.add(cheque);	
		addPcPanel.add(commentLabel);
		addPcPanel.add(returnComment);
		addPcPanel.add(savePc);
		addPcPanel.setVisible(false);
	}
	// Managing the button for saving modifications in the user account.
	public void modifyUser() {
		modifyUser.setText("Modify My profile");
		modifyUser.setBackground(Color.red);
		modifyUser.setFocusable(false);
		modifyUser.addActionListener(new modifyProfileListen());
	}
	// Managing the form for modify user account.
	public void manageEditProfilePanel() {
		editProfilePanel.setLayout(new GridLayout(14, 1));
		editProfilePanel.add(userNameL);
		editProfilePanel.add(name);
		editProfilePanel.add(uSurnameL);
		editProfilePanel.add(surname);
		editProfilePanel.add(dobL);
		editProfilePanel.add(dateOfBirth);
		editProfilePanel.add(postL);
		editProfilePanel.add(post);
		editProfilePanel.add(passL);
		editProfilePanel.add(password);
		editProfilePanel.add(emailL);
		editProfilePanel.add(email);
		editProfilePanel.add(modifyUser);
		editProfilePanel.setVisible(false);
		
	}
	//Manage some labels and text fields.
	public void labelsManage() {
		
		editIdL.setForeground(Color.RED);
		editId.setFont(new Font("Helvetica", Font.PLAIN, 15));
		
		editBrand.setFont(new Font("Helvetica", Font.PLAIN, 15));
		editModel.setFont(new Font("Helvetica", Font.PLAIN, 15));
		editTag.setFont(new Font("Helvetica", Font.PLAIN, 15));
		edStudName.setFont(new Font("Helvetica", Font.PLAIN, 15));
		edStudSurn.setFont(new Font("Helvetica", Font.PLAIN, 15));
		editCourse.setFont(new Font("Helvetica", Font.PLAIN, 15));
		editDob.setFont(new Font("Helvetica", Font.PLAIN, 15));
		editCheque.setFont(new Font("Helvetica", Font.PLAIN, 15));
		editRetComm.setFont(new Font("Helvetica", Font.PLAIN, 15));
		
		
		name.setEditable(true);
		name.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		name.setSize(600, 50);
		userNameL.setSize(600, 50);
		userNameL.setText("Name");
		userNameL.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		
		surname.setEditable(true);
		surname.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		surname.setSize(600, 50);
		uSurnameL.setSize(600, 50);
		uSurnameL.setText("Surname");
		uSurnameL.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		
		dateOfBirth.setEditable(true);
		dateOfBirth.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		dateOfBirth.setSize(600, 50);
		dobL.setSize(600, 50);
		dobL.setText("Date of birth");
		dobL.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		
		post.setEditable(true);
		post.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		post.setSize(600, 50);
		postL.setSize(600, 50);
		postL.setText("Post");
		postL.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		
		password.setEditable(false);
		password.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		password.setSize(600, 50);
		passL.setSize(600, 50);
		passL.setText("Password");
		passL.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		
		email.setEditable(true);
		email.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		email.setSize(600, 50);
		emailL.setSize(600, 50);
		emailL.setText("E-Mail");
		emailL.setFont(new Font("Mv Boli", Font.PLAIN, 13));
		
		brand.setEditable(true);
		brand.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		brand.setSize(600, 50);
		brandLabel.setSize(600, 50);
		brandLabel.setText("Brand");
		brandLabel.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		
		
		model.setEditable(true);
		model.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		model.setSize(600, 50);
		modelLabel.setSize(600, 50);
		modelLabel.setText("Model");
		modelLabel.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		
		
		tag.setEditable(true);
		tag.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		tag.setSize(600, 50);
		tagLabel.setSize(600, 50);
		tagLabel.setText("Service Tag");
		tagLabel.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		
		
		studentName.setEditable(true);
		studentName.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		studentName.setSize(600, 50);
		nameLabel.setSize(600, 50);
		nameLabel.setText("Student Name");
		nameLabel.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		
		
		studentSurname.setEditable(true);
		studentSurname.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		studentSurname.setSize(600, 50);
		surnameLabel.setSize(600, 50);
		surnameLabel.setText("Student Surname");
		surnameLabel.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		
		
		course.setEditable(true);
		course.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		course.setSize(600, 50);
		courseLabel.setSize(600, 50);
		courseLabel.setText("Course");
		courseLabel.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		
		
		dateOfBorrow.setEditable(true);
		dateOfBorrow.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		dateOfBorrow.setSize(600, 50);
		dateLabel.setSize(600, 50);
		dateLabel.setText("Date");
		dateLabel.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		
		
		cheque.setEditable(true);
		cheque.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		cheque.setSize(600, 50);
		chequeLabel.setSize(600, 50);
		chequeLabel.setText("Cheque(true/false)");
		chequeLabel.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		
		
		returnComment.setEditable(true);
		returnComment.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		returnComment.setSize(600, 50);
		commentLabel.setSize(600, 50);
		commentLabel.setText("Return comment");
		commentLabel.setFont(new Font("Mv Boli", Font.PLAIN, 15));
	}
	
	public class modifyProfileListen implements ActionListener {
		
		modifyProfileListen() {
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				User user = new User();
				user.setId(Integer.valueOf(editId.getText()));
				user.setName(name.getText());
				user.setSurname(surname.getText());
				user.setDateOfBirth(Date.valueOf(dateOfBirth.getText()));
				user.setPost(post.getText());
				//user.setPassword(password.getText());
				user.setEmail(email.getText());
				dao.getUserDao().modifyUser(user, mail);
			} catch(Exception x) {
				System.out.println(x.getMessage());
			}
		}
	}
	
	public class editPassword implements ActionListener {
		
		editPassword() {
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				User user = new User();
				user.setId(Integer.valueOf(editId.getText()));
				user.setName(name.getText());
				user.setSurname(surname.getText());
				user.setDateOfBirth(Date.valueOf(dateOfBirth.getText()));
				user.setPost(post.getText());
				user.setPassword(password.getText());
				user.setEmail(email.getText());
				dao.getUserDao().modifyPassword(user, mail);
			} catch(Exception x) {
				System.out.println(x.getMessage());
			}
			password.setText(null);
			password.setEditable(false);
		}
	}
	
	public class savePcModification implements ActionListener {
		
		savePcModification() {
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				Workstation w = new Workstation();
				w.setId(Integer.valueOf(editId.getText()));
				w.setBrand(editBrand.getText());
				w.setModel(editModel.getText());
				w.setTag(editTag.getText());
				w.setStudentName(edStudName.getText());
				w.setStudentSurname(edStudSurn.getText());
				w.setCourse(editCourse.getText());
				w.setDateOfBorrow(Date.valueOf(editDob.getText()));
				w.setCheque(Boolean.parseBoolean(editCheque.getText()));
				w.setReturnComment(editRetComm.getText());
				dao.getWorkstationDao().modifyPC(w);
			} catch(Exception x) {
				System.out.println(x.getMessage());
			}
			
			editId.setText("0");
			editBrand.setText("");
			editModel.setText("");
			editTag.setText("");
			edStudName.setText("");
			edStudSurn.setText("");
			editCourse.setText("");
			editDob.setText("");
			editCheque.setText("");
			editRetComm.setText("");
			
		}	
	}
	
	public class getPcToMod implements ActionListener {
		
		getPcToMod() {
			
		}

		@Override
		public void actionPerformed(ActionEvent e){
			
			try {
				Workstation w = dao.getWorkstationDao().getWorkstationById(Integer.valueOf(editId.getText()));
				editBrand.setText(w.getBrand());
				editModel.setText(w.getModel());
				editTag.setText(w.getTag());
				edStudName.setText(w.getStudentName());
				edStudSurn.setText(w.getStudentSurname());
				editCourse.setText(w.getCourse());
				editDob.setText(w.getDateOfBorrow().toString());
				editCheque.setText(String.valueOf(w.isCheque()));
				editRetComm.setText(w.getReturnComment());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
		}
	}
	
	public class savePcListen implements ActionListener {
		
		savePcListen() {
			
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Workstation workstation = new Workstation();
			workstation.setBrand(brand.getText());
			workstation.setModel(model.getText());
			workstation.setTag(tag.getText());
			workstation.setStudentName(studentName.getText());
			workstation.setStudentSurname(studentSurname.getText());
			workstation.setCourse(course.getText());
			workstation.setDateOfBorrow(Date.valueOf(dateOfBorrow.getText()));
			workstation.setCheque(Boolean.parseBoolean(cheque.getText()));
			workstation.setReturnComment(returnComment.getText());
			try {
				dao.getWorkstationDao().addWorkstation(workstation);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			brand.setText("");
			model.setText("");
			tag.setText("");
			studentName.setText("");
			studentSurname.setText("");
			course.setText("");
			dateOfBorrow.setText("");
			cheque.setText("");
			returnComment.setText("");	
		}
		
	}
	// Filling panel for modification of the user-account.
	public void getUserInfo() {
		
		User u = dao.getUserDao().getUserByMail(mail);
		name.setText(u.getName());
		surname.setText(u.getSurname());
		dateOfBirth.setText(String.valueOf(u.getDateOfBirth()));
		post.setText(u.getPost());
		//password.setText(u.getPassword());
		email.setText(u.getEmail());
		
	}
	// Constructor of the frame
	public AdminFrame(String mail) {
		this.mail = mail;
		
		getUserInfo();
		labelManage();
		manageAddPcButton();
		manageProfileButton();
		labelsManage();
		manageSavePcButton();
		manageAddPcPanel();
		manageAddButtonPanel();
		manageEditButtonPanel();
		modifyUser();
		manageEditProfilePanel();
		manageA();
		manageB();
		manageC();
		manageD();
		manageE();
		manageF();
		manageModifyWS();
		manageSelectPcToModifyButton();
		manageSelectPcButP();
		manageRefreshListButtonPanel();
		ManageAdminOptionsButton();
		ManageAdminOptionsButtonPanel();
		manageDeletePcButton();
		manageDeletePcButtonPanel();
		manageShowUsersButton();
		manageShowUsersButtonPanel();
		manageModifyUserButton();
		manageModifyUserButtonPanel();
		manageDeleteUserButton();
		manageDeleteUserButtonPanel();
		manageActivatePassChangeButton();
		manageActivatePassChangeButtonPanel();
		manageSaveNewPassButton();
		manageSaveNewPassButtonPanel();
		
		this.setSize(1600, 700);
	    this.setTitle("Our Workstations");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLayout(new GridLayout(1, 2, 1, 1));
	    this.add(panelA);
	    this.add(panelB);
		this.setVisible(true);
	}	
}