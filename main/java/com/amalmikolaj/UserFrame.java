package com.amalmikolaj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Vector;

import com.amalmikolaj.dao.DaoFactory;
import com.amalmikolaj.model.Workstation;

public class UserFrame extends JFrame{
	
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
	JLabel userNameL = new JLabel();
	JLabel uSurnameL = new JLabel();
	JLabel dobL = new JLabel();
	JLabel postL = new JLabel();
	JLabel passL = new JLabel();
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
	JLabel editChequeL = new JLabel("Cheque: ");
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
	
	JButton modifyWS = new JButton("Save Modification");
	
	JButton selectPcToModify = new JButton("Modify Workstation");
	JPanel selectPcButP = new JPanel();
	
	
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
		workstationJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        workstationListScrolling = new JScrollPane(workstationJList);
        workstationListScrolling.setSize(800, 150);
        panelE.add(workstationListScrolling, BorderLayout.CENTER);
		
	}
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
	
	public void manageModifyWS() {
		modifyWS.setFocusable(false);
		modifyWS.setBackground(Color.ORANGE);
		modifyWS.addActionListener(new savePcModification());
		
	}
	
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
		panelC.setLayout(new FlowLayout());
		panelC.add(addButtonPanel);
		panelC.add(editButtonPanel);
		panelC.add(selectPcButP);
		
	}
	public void manageD() {
		
		panelD.setSize(400, 700);
		panelD.setLayout(new BorderLayout());
		panelD.add(addPcPanel, BorderLayout.NORTH);
		panelD.add(editProfilePanel, BorderLayout.CENTER);
	}
	
	public void labelManage() {
		label.setSize(800, 100);
		label.setText("Welcome to PC Manager!");
		label.setHorizontalAlignment(JLabel.CENTER);
	    label.setVerticalAlignment(JLabel.CENTER);
		label.setFont(new Font("Mv Boli", Font.PLAIN, 30));
	}
	
	public void manageSelectPcToModifyButton() {
		selectPcToModify.setBackground(Color.YELLOW);
		selectPcToModify.setFocusable(false);
		selectPcToModify.addActionListener(new getPcToMod());
	}
	
	public void manageSelectPcButP() {
		selectPcButP.setSize(200, 50);
		selectPcButP.add(selectPcToModify);
	}
	
	public void manageAddPcButton() {
		addPc.setText("Add new PC");
		addPc.setBackground(Color.green);
		addPc.setFocusable(false);
		addPc.addActionListener(e -> {
			addPcPanel.setVisible(true);
			editProfilePanel.setVisible(false);
		});
	}
	
	public void manageAddButtonPanel() {
		addButtonPanel.setSize(200, 50);
		addButtonPanel.add(addPc);
	}
	
	public void manageProfileButton() {
		editProfile.setText("Edit my profile");
		editProfile.setBackground(Color.cyan);
		editProfile.setFocusable(false);
		editProfile.addActionListener(e -> {
			editProfilePanel.setVisible(true);
			addPcPanel.setVisible(false);
		});
	}
	
	public void manageEditButtonPanel() {
		editButtonPanel.setSize(200, 50);
		editButtonPanel.add(editProfile);
	}
	
	public void manageSavePcButton() {
		savePc.setText("Save new Pc");
		savePc.setBackground(Color.green);
		savePc.setFocusable(false);
		savePc.addActionListener(new savePcListen());
	}
	
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
	
	public void modifyUser() {
		modifyUser.setText("Modify My profile");
		modifyUser.setBackground(Color.red);
		modifyUser.setFocusable(false);
		modifyUser.addActionListener(new modifyProfileListen());
	}
	
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
		editProfilePanel.add(modifyUser);
		editProfilePanel.setVisible(false);
		
	}
	
	public void labelsManage() {
		
		editIdL.setForeground(Color.RED);
		
		name.setEditable(true);
		name.setFont(new Font("Mv Boli", Font.PLAIN, 10));
		name.setSize(600, 50);
		userNameL.setSize(600, 50);
		userNameL.setText("Name");
		userNameL.setFont(new Font("Mv Boli", Font.PLAIN, 13));
		
		surname.setEditable(true);
		surname.setFont(new Font("Mv Boli", Font.PLAIN, 10));
		surname.setSize(600, 50);
		uSurnameL.setSize(600, 50);
		uSurnameL.setText("Surname");
		uSurnameL.setFont(new Font("Mv Boli", Font.PLAIN, 13));
		
		dateOfBirth.setEditable(true);
		dateOfBirth.setFont(new Font("Mv Boli", Font.PLAIN, 10));
		dateOfBirth.setSize(600, 50);
		dobL.setSize(600, 50);
		dobL.setText("Date of birth");
		dobL.setFont(new Font("Mv Boli", Font.PLAIN, 13));
		
		post.setEditable(true);
		post.setFont(new Font("Mv Boli", Font.PLAIN, 10));
		post.setSize(600, 50);
		postL.setSize(600, 50);
		postL.setText("Post");
		postL.setFont(new Font("Mv Boli", Font.PLAIN, 13));
		
		password.setEditable(true);
		password.setFont(new Font("Mv Boli", Font.PLAIN, 10));
		password.setSize(600, 50);
		passL.setSize(600, 50);
		passL.setText("Password");
		passL.setFont(new Font("Mv Boli", Font.PLAIN, 13));
		
		brand.setEditable(true);
		brand.setFont(new Font("Mv Boli", Font.PLAIN, 10));
		brand.setSize(600, 50);
		brandLabel.setSize(600, 50);
		brandLabel.setText("Brand");
		brandLabel.setFont(new Font("Mv Boli", Font.PLAIN, 13));
		
		
		model.setEditable(true);
		model.setFont(new Font("Mv Boli", Font.PLAIN, 10));
		model.setSize(600, 50);
		modelLabel.setSize(600, 50);
		modelLabel.setText("Model");
		modelLabel.setFont(new Font("Mv Boli", Font.PLAIN, 13));
		
		
		tag.setEditable(true);
		tag.setFont(new Font("Mv Boli", Font.PLAIN, 10));
		tag.setSize(600, 50);
		tagLabel.setSize(600, 50);
		tagLabel.setText("Service Tag");
		tagLabel.setFont(new Font("Mv Boli", Font.PLAIN, 13));
		
		
		studentName.setEditable(true);
		studentName.setFont(new Font("Mv Boli", Font.PLAIN, 10));
		studentName.setSize(600, 50);
		nameLabel.setSize(600, 50);
		nameLabel.setText("Student Name");
		nameLabel.setFont(new Font("Mv Boli", Font.PLAIN, 13));
		
		
		studentSurname.setEditable(true);
		studentSurname.setFont(new Font("Mv Boli", Font.PLAIN, 10));
		studentSurname.setSize(600, 50);
		surnameLabel.setSize(600, 50);
		surnameLabel.setText("Student Surname");
		surnameLabel.setFont(new Font("Mv Boli", Font.PLAIN, 13));
		
		
		course.setEditable(true);
		course.setFont(new Font("Mv Boli", Font.PLAIN, 10));
		course.setSize(600, 50);
		courseLabel.setSize(600, 50);
		courseLabel.setText("Course");
		courseLabel.setFont(new Font("Mv Boli", Font.PLAIN, 13));
		
		
		dateOfBorrow.setEditable(true);
		dateOfBorrow.setFont(new Font("Mv Boli", Font.PLAIN, 10));
		dateOfBorrow.setSize(600, 50);
		dateLabel.setSize(600, 50);
		dateLabel.setText("Date");
		dateLabel.setFont(new Font("Mv Boli", Font.PLAIN, 13));
		
		
		cheque.setEditable(true);
		cheque.setFont(new Font("Mv Boli", Font.PLAIN, 10));
		cheque.setSize(600, 50);
		chequeLabel.setSize(600, 50);
		chequeLabel.setText("Cheque");
		chequeLabel.setFont(new Font("Mv Boli", Font.PLAIN, 13));
		
		
		returnComment.setEditable(true);
		returnComment.setFont(new Font("Mv Boli", Font.PLAIN, 10));
		returnComment.setSize(600, 50);
		commentLabel.setSize(600, 50);
		commentLabel.setText("Return comment");
		commentLabel.setFont(new Font("Mv Boli", Font.PLAIN, 13));
	}
	
	public class modifyProfileListen implements ActionListener {
		
		modifyProfileListen() {
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
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
	
	public UserFrame() {
		
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
		
		this.setSize(1600, 700);
	    this.setTitle("Our Workstations");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLayout(new GridLayout(1, 2, 1, 1));
	    this.add(panelA);
	    this.add(panelB);
		this.setVisible(true);
	}
	
}
