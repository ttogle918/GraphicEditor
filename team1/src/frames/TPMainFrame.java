package frames;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import constants.TPConstants;
import control.Hash;
import menu.TPMenuBar;
import model.UserInfo;

public class TPMainFrame extends JFrame {
	private TPToolBar toolBar;
	private TPSearchBar sBar;
	private TPResultTable rTable;
	private TPMenuBar MenuBar;
	private Hash hash;
	private UserInfo userInfo;
	private static TPMainFrame uniqueMainFrame = new TPMainFrame(TPConstants.TITLE_MAINFRAME);

	public void setUserInfo(UserInfo userInfo) {this.userInfo = userInfo;}
	public TPMainFrame(String title) {
		super(title);
		hash = new Hash(223);
//		toolBar = new TPToolBar(TPConstants.TITLE_TOOLBAR);
//		this.add(BorderLayout.NORTH, toolBar);
		MenuBar = new TPMenuBar();
		this.setJMenuBar(MenuBar);
		rTable = new TPResultTable(hash);
		this.add(BorderLayout.CENTER, rTable);
		sBar = new TPSearchBar(hash, rTable);
		this.add(BorderLayout.NORTH, sBar);
		// personalInfoPanel.setBorder(new LineBorder(Color.black));
		// personalInfoPanel.setBounds(0, 15,380,40);
		// this.add(this.personalInfoPanel);
		// this.selectionPanel = new SelectionPanel(this);
		// selectionPanel.setBounds(0, 55, 380,300);
		// selectionPanel.setBorder(new LineBorder(Color.black));
		hash.add("denmark",1200, "coffee", "gs");
		hash.add("foce",1000, "coffee", "gs");
		
		hash.add("coke",84, "colar", "cu");
		hash.add("egg",200, "food", "cu");
		hash.add("water",500, "water", "gs");
		hash.add("Samyang",800, "milk","cu");
		hash.add("Seoul",800,"milk", "e");
		hash.add("denmark",1800, "coffee","e");
		hash.add("denmark",1880, "coffee", "e");
		hash.add("coke",1000, "colar", "mini");
		hash.add("seoul",1000, "milk","mini");
		hash.add("coke",1000, "colar","mini");
		hash.add("egg", 220, "food", "e");
		hash.add("samdasu",600, "water", "gs");
		hash.add("milk",600, "drink", "gs", 77);
		hash.add("milk1",230490,"Drink","gs");
		hash.add("kimbap",1800, "fresh","gs");
		hash.add("samgackkimbap",1000, "fresh","gs");
		hash.add("kimbap",2000, "fresh","gs");
		hash.add("kimbap",1800, "fresh","gs");
		
		hash.add("coke",999, "colar","gs");
		hash.add("egg",222, "food","gs");
		hash.add("water",232, "water","gs");
		hash.add("milk",214, "drink","gs", 90);
		hash.add("milk1",230490,"Drink","gs");
		hash.add("csoqweqwe",1120, "coffee","gs");
		hash.add("coqwseqwe",1010, "coffee","gs");
		hash.add("qwecoqwe",1000, "coffee","gs");
		hash.add("qcoqwe",1000, "coffee","gs");
		
		hash.add("coke",999, "colar","gs");
		hash.add("egg",222, "food","gs");
		hash.add("water",232, "water","gs");
		hash.add("milk",2424, "drink","gs",3);
		hash.add("milk1",230490,"Drink","gs");
		hash.add("milk",2424, "drink","gs",1);
		hash.add("milk",2424, "drink","cu",1);
		hash.add("csoqweqwe",1090, "coffee","gs");
		hash.add("milk",2424, "drink","gs",50);
		hash.add("coqwseqwe",11300, "coffee","gs");
		hash.add("qwecoqwe",1400, "coffee","gs");
		hash.add("qcoqwe",1000, "coffee","gs");
		hash.add("milk",2084, "drink","gs",100);
		hash.add("milk",2284, "drink","cu",100);
		hash.add("milk",384, "drink","mini",100);
		
		hash.add("qwecoqw",1000, "coffee","gs");
		hash.add("foca", 200, "coffee","gs");
		hash.add("milk",124, "drink","gs", 5);
		hash.add("Strawberry",1350 ,"milk", "cu");
		hash.add("Banana ",1350   ,"milk", "cu");
		hash.add("Banana-light",1350 ,"milk", "cu");
		hash.add("Melon",1350 ,"milk", "cu");
		hash.add("Cocoa",1350 ,"milk", "cu");
		hash.add("Strawberry",1350 ,"milk", "sevenEleven");
		hash.add("Banana ",1350   ,"milk", "sevenEleven");
		hash.add("Banana-light",1350 ,"milk", "sevenEleven");
		hash.add("Melon",1350 ,"milk", "sevenEleven");
		hash.add("Cocoa",1350 ,"milk", "sevenEleven");
		
		hash.add("Strawberry",1350 ,"milk", "GS");
		hash.add("Banana ",1350   ,"milk", "GS");
		hash.add("Banana-light",1350 ,"milk", "GS");
		hash.add("Melon",1350 ,"milk", "GS");
		hash.add("Cocoa",1350 ,"milk", "GS");
		
		hash.add("Strawberry",1350 ,"milk", "mini");
		hash.add("Banana ",1350   ,"milk", "mini");
		hash.add("Banana-light",1350 ,"milk", "mini");
		hash.add("Melon",1350 ,"milk", "mini");
		hash.add("Cocoa",1350 ,"milk", "mini");
		
		//milk µé 4 x 5 20°³ 
		
		hash.add("egg",850,"food", "cu");
		hash.add("gimbap-bulgogi",1300,"food", "cu",4, 20161031);
		hash.add("gimbap-kimchi", 1300  ,"food", "cu",1, 20161112);
		hash.add("gimbap-tunar",1300   ,"food", "cu");
		hash.add("gimbap-tunarMayo",1350   ,"food", "cu");
		hash.add("gimbap-bulgogihot",1350   ,"food", "cu");
		hash.add("gimbap-do",1300   ,"food", "cu");
		hash.add("packed lunch-1",2500   ,"food", "cu");
		hash.add("packed lunch-2",2800   ,"food", "cu");
		hash.add("packed lunch-3",3000   ,"food", "cu");
		hash.add("bread-Milk",2000   ,"food", "cu");
		hash.add("bread-Cheese",2000   ,"food", "cu");
		hash.add("donut",1000   ,"food", "cu");
		hash.add("Triangular Kimbap-tunar",850, "food", "cu");
		hash.add("Triangular Kimbap-kimchi",850, "food", "cu");
		hash.add("Sausage", 600, "food", "cu");
		hash.add("Ramen",1200 ,"food", "cu");
		hash.add("UDong",1350 ,"food", "cu");
		hash.add("Zapageti",1180,"food", "cu");
		hash.add("IceCream-Melon",840,"food","cu");
		hash.add("IceCream-Bappico",850,"food","cu");
		hash.add("IceCream-Peach",850,"food","cu");
		hash.add("IceCream-Apple",850,"food","cu");
		hash.add("IceCream-Banana",850,"food","cu");
		
		
		hash.add("egg",850,"food", "sevenEleven");
		hash.add("gimbap-bulgogi",1300,"food", "sevenEleven", 7,20161029);
		hash.add("gimbap-kimchi", 1300  ,"food", "sevenEleven");
		hash.add("gimbap-tunar",1300   ,"food", "sevenEleven");
		hash.add("gimbap-tunarMayo",1350   ,"food", "sevenEleven");
		hash.add("gimbap-bulgogihot",1350   ,"food", "sevenEleven");
		hash.add("gimbap-do",1300   ,"food", "sevenEleven");
		hash.add("packed lunch-1",2500   ,"food", "sevenEleven");
		hash.add("packed lunch-2",2800   ,"food", "sevenEleven");
		hash.add("packed lunch-3",3000   ,"food", "sevenEleven");
		hash.add("bread-Milk",2000   ,"food", "sevenEleven");
		hash.add("bread-Cheese",2000   ,"food", "sevenEleven");
		hash.add("donut",1000   ,"food", "sevenEleven");
		hash.add("Triangular Kimbap-tunar",850, "food", "sevenEleven");
		hash.add("Triangular Kimbap-kimchi",850, "food", "sevenEleven");
		hash.add("Sausage", 600, "food", "sevenEleven");
		hash.add("Ramen",1200 ,"food", "sevenEleven");
		hash.add("UDong",1350 ,"food", "sevenEleven");
		hash.add("Zapageti",1180,"food", "sevenEleven");
		hash.add("IceCream-Melon",840,"food","sevenEleven");
		hash.add("IceCream-Bappico",850,"food","sevenEleven");
		hash.add("IceCream-Peach",850,"food","sevenEleven");
		hash.add("IceCream-Apple",850,"food","sevenEleven");
		hash.add("IceCream-Banana",850,"food","sevenEleven");
		
		
		hash.add("egg",850,"food", "GS");
		hash.add("gimbap-bulgogi",1300,"food", "GS", 3, 20161012);
		hash.add("gimbap-kimchi", 1300  ,"food", "GS");
		hash.add("gimbap-tunar",1300   ,"food", "GS");
		hash.add("gimbap-tunarMayo",1350   ,"food", "GS");
		hash.add("gimbap-bulgogihot",1350   ,"food", "GS");
		hash.add("gimbap-do",1300   ,"food", "GS");
		hash.add("packed lunch-1",2500   ,"food", "GS");
		hash.add("packed lunch-2",2800   ,"food", "GS");
		hash.add("packed lunch-3",3000   ,"food", "GS");
		hash.add("bread-Milk",2000   ,"food", "GS");
		hash.add("bread-Cheese",2000   ,"food", "GS");
		hash.add("donut",1000   ,"food", "GS");
		hash.add("Triangular Kimbap-tunar",850, "food", "GS");
		hash.add("Triangular Kimbap-kimchi",850, "food", "GS");
		hash.add("Sausage", 600, "food", "GS");
		hash.add("Ramen",1200 ,"food", "GS");
		hash.add("UDong",1350 ,"food", "GS");
		hash.add("Zapageti",1180,"food", "GS");
		hash.add("IceCream-Melon",840,"food","GS");
		hash.add("IceCream-Bappico",850,"food","GS");
		hash.add("IceCream-Peach",850,"food","GS");
		hash.add("IceCream-Apple",850,"food","GS");
		hash.add("IceCream-Banana",850,"food","GS");
		
		
		hash.add("egg",850,"food", "mini");
		hash.add("gimbap-bulgogi",1300,"food", "mini", 5, 20161010);
		hash.add("gimbap-kimchi", 1300  ,"food", "mini");
		hash.add("gimbap-tunar",1300   ,"food", "mini");
		hash.add("gimbap-tunarMayo",1350   ,"food", "mini");
		hash.add("gimbap-bulgogihot",1350   ,"food", "mini");
		hash.add("gimbap-do",1300   ,"food", "mini");
		hash.add("packed lunch-1",2500   ,"food", "mini");
		hash.add("packed lunch-2",2800   ,"food", "mini");
		hash.add("packed lunch-3",3000   ,"food", "mini");
		hash.add("bread-Milk",2000   ,"food", "mini");
		hash.add("bread-Cheese",2000   ,"food", "mini");
		hash.add("donut",1000   ,"food", "mini");
		hash.add("Triangular Kimbap-tunar",850, "food", "mini");
		hash.add("Triangular Kimbap-kimchi",850, "food", "mini");
		hash.add("Triangular Kimbap-bulgogi",850, "food", "mini");
		hash.add("Triangular Kimbap-dongach",850, "food", "mini");
		hash.add("Triangular Kimbap-mayonnaze",850, "food", "mini");
		hash.add("Triangular Kimbap-red",850, "food", "mini");
		hash.add("Sausage", 600, "food", "mini");
		hash.add("Ramen",1200 ,"food", "mini");
		hash.add("UDong",1350 ,"food", "mini");
		hash.add("Zapageti",1180,"food", "mini");
		hash.add("IceCream-Melon",840,"food","mini");
		hash.add("IceCream-Bappico",850,"food","mini");
		hash.add("IceCream-Peach",850,"food","mini");
		hash.add("IceCream-Apple",850,"food","mini");
		hash.add("IceCream-Banana",850,"food","mini");
		//food 25 x 4 =100
		
		
		
		
		
		
		hash.add("coca-cola",1240, "drink", "cu");
		hash.add("pepsi",1160, "drink", "cu");
		hash.add("cider",1080, "drink", "cu");
		hash.add("samdasoo",600, "drink", "cu");
		hash.add("oksoosoo",850, "drink", "cu");
		hash.add("Hwanta-orange",1050, "drink", "cu");
		hash.add("Hwanta-grape",1050, "drink", "cu");
		
		hash.add("coca-cola",1240, "drink", "sevenEleven");
		hash.add("pepsi",1160, "drink", "sevenEleven");
		hash.add("cider",1080, "drink", "sevenEleven");
		hash.add("samdasoo",600, "drink", "sevenEleven");
		hash.add("oksoosoo",850, "drink", "sevenEleven");
		hash.add("Hwanta-orange",1050, "drink", "sevenEleven");
		hash.add("Hwanta-grape",1050, "drink", "sevenEleven");
		
		hash.add("coca-cola",1240, "drink", "sevenEleven");
		hash.add("pepsi",1160, "drink", "sevenEleven");
		hash.add("cider",1080, "drink", "sevenEleven");
		hash.add("samdasoo",600, "drink", "sevenEleven");
		hash.add("oksoosoo",850, "drink", "sevenEleven");
		hash.add("Hwanta-orange",1050, "drink", "sevenEleven");
		hash.add("Hwanta-grape",1050, "drink", "sevenEleven");

		hash.add("coca-cola",1240, "drink", "GS");
		hash.add("pepsi",1160, "drink", "GS");
		hash.add("cider",1080, "drink", "GS");
		hash.add("samdasoo",600, "drink", "GS");
		hash.add("oksoosoo",850, "drink", "GS");
		hash.add("Hwanta-orange",1050, "drink", "GS");
		hash.add("Hwanta-grape",1050, "drink", "GS");
//		System.out.println(hash.toString());
	}

	public static TPMainFrame getInstance() {
		return uniqueMainFrame;
	}

	public void init() {
		this.setSize(TPConstants.WIDTH_MAINFRAME, TPConstants.HEIGHT_MAINFRAME);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}